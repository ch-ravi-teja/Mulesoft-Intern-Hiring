import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TableCreation 
{
	public static void main(String[] args) throws SQLException
	{
		Connection con = null;
		try {
			//Connecting to Database
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/moviesdatabase","root","systemadmin");
			
			//Creating Table
			Statement stmt = con.createStatement();
			String sql = "CREATE TABLE Movies (moviename varchar(20) primary key,leadactor varchar(20),actress varchar(20),yearofrelease int,directorname varchar(20))";
			stmt.executeUpdate(sql);
			System.out.println("Movies Table Created Successfully");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			con.close();
		}
	}
}
