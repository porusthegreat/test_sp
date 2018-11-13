package com.example.testStroedProcedures;

import com.example.testStroedProcedures.dao.BookDao;
import com.example.testStroedProcedures.entities.Book;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TemporalType;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestStroedProceduresApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	private BookDao bookDao;

	@Autowired
	private EntityManager entityManager;


	@Test
	public void testShouldCreateBookByNamingStoredProcedure() {

		String bookName = "Design Patterns: Elements of Reusable Object-Oriented Software";
		String authorFirstname = "Gang";
		String authorLastname = "of four";

		StoredProcedureQuery addBookNamedStoredProcedure = entityManager.createNamedStoredProcedureQuery("addBook_sp");
		addBookNamedStoredProcedure.setParameter("bookName", bookName);
		addBookNamedStoredProcedure.setParameter("bookReleaseDate", new Date(), TemporalType.DATE);
		addBookNamedStoredProcedure.setParameter("authorFirstname", authorFirstname);
		addBookNamedStoredProcedure.setParameter("authorLastname", authorLastname);

		// Stored procedure call
		Integer createdBookId = (Integer) addBookNamedStoredProcedure.getSingleResult();

		Assert.assertNotNull(createdBookId);

		/*Book book = bookDao.findOne(createdBookId);

		Assert.assertEquals(bookName, book.getName());
		Assert.assertEquals(authorFirstname, book.getAuthor().getFirstname());
		Assert.assertEquals(authorLastname, book.getAuthor().getLastname());*/
	}

}
