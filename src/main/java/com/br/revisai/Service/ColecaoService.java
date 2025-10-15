package com.br.revisai.Service;

import com.br.revisai.Model.Colecao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ColecaoService extends CrudRepository<Colecao, Integer> {
    Colecao save(Colecao entity);

    Optional<Colecao> findById(Integer integer);

    List<Colecao> findAll();

    void delete(Colecao entity);
}
