package com.testvagrant.storedProcedureTestExample.interfaces;

import com.testvagrant.storedProcedureTestExample.entities.Book;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;


public interface BookInterfaces extends CrudRepository<Book, Integer> {

    /**
     * Will call the database stored procedure :
     * <p>
     * CREATE OR REPLACE FUNCTION addbook(
     * bookname character varying,
     * bookreleasedate timestamp without time zone,
     * authorfirstname character varying,
     * authorlastname character varying)
     * RETURNS integer
     */
    @Procedure
    public Integer addBook(String bookName, Date bookReleaseDate, String authorFirstname, String authorLastname);

    public List<Book> findAll();
}
