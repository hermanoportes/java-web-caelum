import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCExemplo {
	
	public static void main(String[] args) throws SQLException{
		String url = "jdbc:mysql://localhost:3306/java_web_caelum?useTimezone=true&serverTimezone=UTC";
		String user = "root";
		String password = "root";
		
		Connection conn = DriverManager.getConnection(url, user, password);
		
		System.out.println("Connected");
		
		conn.close();
		
	}

}
