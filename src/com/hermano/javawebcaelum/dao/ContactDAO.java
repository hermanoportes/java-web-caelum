package com.hermano.javawebcaelum.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.hermano.javawebcaelum.connection.ConnectionFactory;
import com.hermano.javawebcaelum.exception.DAOException;
import com.hermano.javawebcaelum.model.Contact;

public class ContactDAO {
	
	private Connection connection;
	
	public ContactDAO() {
		this.connection = new ConnectionFactory().getConnection();
		System.out.println("Connecting to the database");
	}
	
	public List<Contact> findAll() {
		String sql = "SELECT * FROM contacts;";
		
		List<Contact> contacts = new ArrayList<Contact>();
		
		try {
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Contact contact = new Contact();
				contact.setId(rs.getLong("id"));
				contact.setName(rs.getString("name"));
				contact.setEmail(rs.getString("email"));
				contact.setAddress(rs.getString("address"));
				contact.setBirthday(rs.getDate("birthday").toLocalDate());
				
				contacts.add(contact);
			}
			
			rs.close();
			stmt.close();
		} catch (Exception e) {
			throw new DAOException("Contacts not found");
		}
		
		return contacts;
	}
	
	public List<Contact> findByName(String name) {
		String sql = "SELECT * FROM contacts WHERE name LIKE ?;";
		
		List<Contact> contacts = new ArrayList<Contact>();
		
		try {
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, "%" + name + "%");
			
			ResultSet rs = stmt.executeQuery();			
			
			while(rs.next()) {
				Contact contact = new Contact();
				contact.setId(rs.getLong("id"));
				contact.setName(rs.getString("name"));
				contact.setEmail(rs.getString("email"));
				contact.setAddress(rs.getString("address"));
				contact.setBirthday(rs.getDate("birthday").toLocalDate());
				
				contacts.add(contact);
			}
			
			rs.close();
			stmt.close();
		} catch (Exception e) {
			throw new  DAOException("Contacts not found");
		}
		
		return contacts;
	}
	
	public Contact getById(Long id) {
		String sql = "SELECT * FROM contacts WHERE id=?;";
		
		Contact contact = new Contact();
		
		try {
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, id);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				contact.setId(rs.getLong("id"));
				contact.setName(rs.getString("name"));
				contact.setEmail(rs.getString("email"));
				contact.setAddress(rs.getString("address"));
				contact.setBirthday(rs.getDate("birthday").toLocalDate());
			}	
			
			rs.close();
			stmt.close();
		} catch (Exception e) {
			throw new  RuntimeException(e);
		}
		
		return contact;
	}

	public void add(Contact contact) {	
		String sql = "INSERT into contacts (name, email, address, birthday) VALUES (?, ?, ?, ?);";
		
		try {
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, contact.getName());
			stmt.setString(2, contact.getEmail());
			stmt.setString(3, contact.getAddress());
			stmt.setDate(4, Date.valueOf(contact.getBirthday()));
			
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			throw new DAOException("Could not save contact");
		}
	}
	
	public void update(Contact contact) {	
		String sql = "UPDATE contacts SET name=?, email=?, address=?, birthday=? WHERE id=?;";
		
		try {
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, contact.getName());
			stmt.setString(2, contact.getEmail());
			stmt.setString(3, contact.getAddress());
			stmt.setDate(4, Date.valueOf(contact.getBirthday()));
			stmt.setLong(5, contact.getId());
			
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			throw new DAOException("Could not update contact");
		}
	}
	
	public void delete(Contact contact) {	
		String sql = "DELETE FROM contacts WHERE id=?;";
		
		try {
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setLong(1, contact.getId());
			
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			throw new DAOException("Could not delete contact");
		}
	}
}
