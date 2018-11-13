package com.example.testStroedProcedures.dao;

import com.example.testStroedProcedures.entities.Book;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;


public interface BookDao extends CrudRepository<Book, Integer> {

    /**
     * Will call the database stored procedure :
     *
     * CREATE OR REPLACE FUNCTION addbook(
     * 		bookname character varying,
     * 		bookreleasedate timestamp without time zone,
     * 		authorfirstname character varying,
     * 		authorlastname character varying)
     * RETURNS integer
     *
     */
    @Procedure
    public Integer addBook(String bookName, Date bookReleaseDate, String authorFirstname, String authorLastname);

//    Book findOne(Integer id);
}
