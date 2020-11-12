package com.hermano.javawebcaelum;

import java.time.LocalDate;

import com.hermano.javawebcaelum.dao.ContactDAO;
import com.hermano.javawebcaelum.model.Contact;

public class TestDAOUpdate {
	
	public static void main(String[] args) {
		
		ContactDAO dao = new ContactDAO();
		
		Contact contact = dao.getById(4L);
		
		contact.setName("Graziela");
		contact.setEmail("gra@email.com");
		contact.setBirthday(LocalDate.of(1983, 06, 14));
		
		dao.update(contact);
		
		System.out.println(contact.getId() + "- " + contact.getName());
		System.out.println(contact.getEmail());
		System.out.println(contact.getAddress());
		System.out.println(contact.getBirthday() + "\n");
	}
}
