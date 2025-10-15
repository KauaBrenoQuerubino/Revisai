package com.br.revisai.Service;


import com.br.revisai.Model.Flashcard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface FlashcardService extends CrudRepository<Flashcard, Integer> {

    Flashcard save(Flashcard entity);

    Optional<Flashcard> findById(Flashcard integer);

    List<Flashcard> findAll();

    void delete(Flashcard entity);
}
