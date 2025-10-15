package com.br.revisai.Service;


import com.br.revisai.Model.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public interface UsuarioService extends CrudRepository<Usuario, Integer> {

    Usuario save(Usuario entity);

    Optional<Usuario> findById(Integer integer);

    Optional<Usuario> findByEmail(String email);

    List<Usuario> findAll();

    void delete(Usuario entity);

}
