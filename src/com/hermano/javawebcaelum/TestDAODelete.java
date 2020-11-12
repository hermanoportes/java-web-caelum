package com.hermano.javawebcaelum;

import com.hermano.javawebcaelum.dao.ContactDAO;
import com.hermano.javawebcaelum.model.Contact;

public class TestDAODelete {
	public static void main(String[] args) {
		ContactDAO dao = new ContactDAO();
		
		Contact contact = dao.getById(2L);
		
		dao.delete(contact);
		
	}
}
