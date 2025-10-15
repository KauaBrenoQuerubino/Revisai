package com.br.revisai.Service;

import com.br.revisai.Model.Pergunta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PerguntasService extends CrudRepository<Pergunta, Integer> {

    Pergunta save(Pergunta entity);

    Optional<Pergunta> findById(Pergunta integer);

    List<Pergunta> findAll();

    void delete(Pergunta entity);
}
