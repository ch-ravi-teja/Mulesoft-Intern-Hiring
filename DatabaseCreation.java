import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseCreation 
{
	public static void main(String[] args) throws SQLException
	{
		Connection con = null;
		try {
			//Connecting to Database
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","systemadmin");
			
			//Creating Database
			Statement stmt = con.createStatement();
			String sql = "CREATE DATABASE MoviesDatabase";
			stmt.executeUpdate(sql);
			System.out.println("Movies Database Created Successfully");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			con.close();
		}
	}
}
