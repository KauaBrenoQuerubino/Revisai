package com.br.revisai.Controller;

import com.br.revisai.Model.Colecao;
import com.br.revisai.Model.Usuario;
import com.br.revisai.Service.ColecaoService;
import com.br.revisai.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/Colecao")
public class ColecaoController {

    @Autowired
    ColecaoService service;

    @Autowired
    private UsuarioService usuarioRepository;

    @PostMapping
    public ResponseEntity<Colecao> create(@RequestBody Colecao colecao){
        // Garante que os usuários existam no banco
        if (colecao.getUsuarios() != null) {
            List<Usuario> usuariosValidados = colecao.getUsuarios().stream()
                    .map(u -> usuarioRepository.findById(u.getId())
                            .orElseThrow(() -> new RuntimeException("Usuário não encontrado: " + u.getId())))
                    .toList();

            colecao.setUsuarios(usuariosValidados);
        }

        service.save(colecao);
        return ResponseEntity.ok(colecao);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> procurarUsuario(@PathVariable Integer id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario == null){
            return ResponseEntity.notFound().build();
        }

        List<Colecao> colecoes = service.findByUsuarios_Id(id);

        return ResponseEntity.ok(colecoes);

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> procurarColecao(@PathVariable Integer id) {

        Optional<Colecao> colecoes = service.findById(id);

        return ResponseEntity.ok(colecoes);

    }



}
