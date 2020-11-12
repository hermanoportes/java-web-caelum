package com.hermano.javawebcaelum;

import java.util.List;

import com.hermano.javawebcaelum.dao.ContactDAO;
import com.hermano.javawebcaelum.model.Contact;

public class TestDAOList {
	
	public static void main(String[] args) {
		ContactDAO dao = new ContactDAO();
		
		List<Contact> contacts = dao.findAll();
		
		print(contacts);
		System.out.println("=======================");
		
		List<Contact> search = dao.findByName("zuz");
		print(search);
		System.out.println("=======================");
		
		Contact contact = dao.getById(3L);
		System.out.println(contact.getId() + "- " + contact.getName());
		System.out.println(contact.getEmail());
		System.out.println(contact.getAddress());
		System.out.println(contact.getBirthday() + "\n");
		
	}

	private static void print(List<Contact> contacts) {
		for(Contact contact : contacts) {
			System.out.println(contact.getId() + "- " + contact.getName());
			System.out.println(contact.getEmail());
			System.out.println(contact.getAddress());
			System.out.println(contact.getBirthday() + "\n");
		}
		
	}

}
