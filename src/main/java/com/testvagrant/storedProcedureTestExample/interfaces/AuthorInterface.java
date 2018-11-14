package com.testvagrant.storedProcedureTestExample.interfaces;

import com.testvagrant.storedProcedureTestExample.entities.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorInterface extends CrudRepository<Author, Integer> {
}
