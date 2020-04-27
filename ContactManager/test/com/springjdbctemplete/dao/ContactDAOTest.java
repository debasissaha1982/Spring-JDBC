package com.springjdbctemplete.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.mysql.jdbc.AssertionFailedException;
import com.springjdbctemplete.model.Contact;

class ContactDAOTest {
	
	private DriverManagerDataSource datasource;
	private ContactDAO dao;
	
	@BeforeEach
	void setupBeforeEach() {
		datasource = new DriverManagerDataSource();
		datasource.setDriverClassName("com.mysql.jdbc.Driver");
		datasource.setUrl("jdbc:mysql://localhost:3306/springjdbctemplete");
		datasource.setUsername("root");
		datasource.setPassword("welcome123");	
		dao = new ContactDAImpl(datasource);
	}

	@Test
	void testSave() {
		
		Contact contacttest = new Contact();
		contacttest.setName("Ishita Saha1");
		contacttest.setEmail("abcd@gmail.com");
		contacttest.setAddress("Kolkata");
		contacttest.setPhone("7777777777777775");
		int result = dao.save(contacttest);
		
		assertTrue(result>0);
		
		//Another way using contractor
		//Contact contacttest = new Contact("Saptanshu Saha", "debasis.saha1982@gmail.com", "Kolkata", "9999999999");
		//int result = dao.save(contacttest);
		
		//assertTrue(result>0);
	}

	@Test
	void testUpdate() {
		
		Contact contacttest = new Contact();
		contacttest.setName("Ishita Saha");
		contacttest.setEmail("abcd@gmail.com");
		contacttest.setAddress("Kolkata");
		contacttest.setPhone("777777777777777");
		contacttest.setId(1);
		int result = dao.update(contacttest);
		
		assertTrue(result>0);

		//Another way using contractor
		//Contact contacttest = "";//new Contact(3,"Saptanshu Saha", "spatanshu.saha1982@gmail.com", "Kolkata", "111111111111");
		//int result = dao.update(contacttest);
		
		//assertTrue(result>0);
	}

	@Test
	void testGet() {
		Contact contact = dao.get(1);
		if(contact !=null) {
			System.out.println(contact);
		}
		assertNotNull(contact);
	}

	@Test
	void testDelete() {
		int result = dao.delete(2);
		if (result>0) {
			System.out.println("One record Deleted");
		}
		
		assertTrue(result>0);
	}

	@Test
	void testList() {
		List<Contact> listcontact = dao.list();
		
		for (Contact allContact : listcontact) {
			System.out.println(allContact);
		}
		
		assertTrue(!listcontact.isEmpty());
		
	}

}
