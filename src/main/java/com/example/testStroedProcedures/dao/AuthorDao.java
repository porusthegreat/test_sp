package com.example.testStroedProcedures.dao;

import com.example.testStroedProcedures.entities.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorDao extends CrudRepository<Author, Integer> {
}
