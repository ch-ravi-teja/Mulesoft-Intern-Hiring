import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryData
{
	public static void main(String[] args) throws SQLException
	{
		Connection con = null;
		try {
			//Connecting to Database
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/moviesdatabase","root","systemadmin");
			
			//Querying Data without parameter
			Statement stmt = con.createStatement();
			String sql = "SELECT * FROM Movies";
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println("Selecting All Movies in the Table....");
			System.out.println("Movie Name"+"\t"+"Lead Actor"+"\t"+"Actress"+"\t"+"Year of Relase"+"\t"+"Director");
			while(rs.next()) {
				System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getInt(4)+"\t"+rs.getString(5));
			}
			
			//Querying Data with parameter
			Statement stmt1 = con.createStatement();
			String sql1 = "SELECT * FROM Movies where leadactor='NTR'";
			ResultSet rs1 = stmt1.executeQuery(sql1);
			System.out.println("\nSelecting All Movies in the Table in which lead actor is NTR....");
			System.out.println("Movie Name"+"\t"+"Lead Actor"+"\t"+"Actress"+"\t"+"Year of Relase"+"\t"+"Director");
			while(rs1.next()) {
				System.out.println(rs1.getString(1)+"\t"+rs1.getString(2)+"\t"+rs1.getString(3)+"\t"+rs1.getInt(4)+"\t"+rs1.getString(5));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			con.close();
		}
	}
}
