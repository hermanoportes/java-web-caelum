package com.hermano.javawebcaelum;

import java.time.LocalDate;

import com.hermano.javawebcaelum.dao.ContactDAO;
import com.hermano.javawebcaelum.model.Contact;

public class TestDAOAdd {
	
	public static void main(String[] args) {
		Contact contact = new Contact();
		contact.setName("Zuza Avelino");
		contact.setEmail("zuza@mail.com");
		contact.setAddress("Rua dos Bobos, 0");
		contact.setBirthday(LocalDate.of(1980, 12, 31));
		
		ContactDAO dao = new ContactDAO();
		dao.add(contact);
	}

}
