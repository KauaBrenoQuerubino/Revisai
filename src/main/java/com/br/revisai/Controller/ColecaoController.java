package com.br.revisai.Controller;

import com.br.revisai.Model.Colecao;
import com.br.revisai.Model.Usuario;
import com.br.revisai.Service.ColecaoService;
import com.br.revisai.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
