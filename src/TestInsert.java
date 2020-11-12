import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import com.hermano.javawebcaelum.connection.ConnectionFactory;
import com.hermano.javawebcaelum.model.Contact;

public class TestInsert {
	
	public static void main(String[] args) throws SQLException {
		
		Contact contact = new Contact();
		contact.setName("Hermano Portes");
		contact.setEmail("hermano@mail.com");
		contact.setAddress("Rua dos Bobos, 0");
		contact.setBirthday(LocalDate.of(1980, 04, 19));
		
		String sql = "INSERT into contacts (name, email, address, birthday) VALUES (?, ?, ?, ?);";
				
		try(Connection con = new ConnectionFactory().getConnection();
				PreparedStatement stmt = con.prepareStatement(sql)) {
			
			System.out.println("Connected to the database");
			
			stmt.setString(1, contact.getName());
			stmt.setString(2, contact.getEmail());
			stmt.setString(3, contact.getAddress());
			stmt.setDate(4, Date.valueOf(contact.getBirthday()));
			
			stmt.execute();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
