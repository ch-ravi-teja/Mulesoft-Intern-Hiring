import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertData
{
	public static void main(String[] args) throws SQLException
	{
		Connection con = null;
		try {
			//Connecting to Database
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/moviesdatabase","root","systemadmin");
			
			//Inserting record into Movies Table
			Statement stmt = con.createStatement();
			stmt.executeUpdate("INSERT INTO Movies VALUES('Aravindha Sametha','NTR','Pooja Hegde',2018,'TriVikram')");
			stmt.executeUpdate("INSERT INTO Movies VALUES('Bahubali','Prabhas','Anushka',2015,'Rajamouli')");
			stmt.executeUpdate("INSERT INTO Movies VALUES('KGF','Yash','Srinidhi Shetty',2018,'Prashanth Neel')");
			stmt.executeUpdate("INSERT INTO Movies VALUES('Janatha Garage','NTR','Samantha',2016,'Koratal Siva')");
			stmt.executeUpdate("INSERT INTO Movies VALUES('Eega','Nani','Samantha',2012,'Rajamouli')");
			stmt.executeUpdate("INSERT INTO Movies VALUES('Legend','Bala Krishna','Sonal Chauhan',2014,'Boyapati')");
			stmt.executeUpdate("INSERT INTO Movies VALUES('Temper','NTR','Kajal Aggarwal',2015,'Puri Jaganath')");
			System.out.println("Records Inserted Successfully");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			con.close();
		}
	}
}
