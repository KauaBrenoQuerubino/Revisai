package com.br.revisai.Controller.Auth;


import com.br.revisai.Model.DTO.LoginDTO;
import com.br.revisai.Model.Usuario;
import com.br.revisai.Service.Token.JWTservice;
import com.br.revisai.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

@CrossOrigin("*")
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UsuarioService service;

    @Autowired
    private JWTservice tokenjwt;

    @PostMapping("/cadastro")
    public ResponseEntity<?> cadastro(@RequestBody Usuario dto) {
        Optional<Usuario> usuario = service.findByEmail(dto.getEmail());

        if (usuario == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();

        service.save(dto);

        return ResponseEntity.ok(dto);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) throws ExecutionException, InterruptedException {


        Optional<Usuario> usuario = service.findByEmail(loginDTO.getEmail());

        Map<String, Object> resposta = new HashMap<>();


        if (usuario.isPresent() && usuario.get().getSenha().equals(loginDTO.getSenha())) {

            String token = tokenjwt.gerarToken(usuario.orElse(null));
            resposta.put("mensagem", "Login efetuado com sucesso");
            resposta.put("token", token);

            return ResponseEntity.ok(resposta);
        }

        resposta.put("mensagem", "Error ao efetuar o Login");
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }

    @PostMapping(value = "/sessao")
    public ResponseEntity<?> sessao (@RequestBody String token) throws InterruptedException, ExecutionException{

        String uid = tokenjwt.validarToken(token);
        System.out.println(uid);
        Optional<Usuario> usuario = service.findByEmail(uid);

        if (usuario.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(usuario);

    }

}

