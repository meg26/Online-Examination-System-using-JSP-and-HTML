import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
 
public class Stud extends HttpServlet
{
   public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
   {
		// JDBC driver name and database URL
		String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
		String DB_URL="jdbc:mysql://localhost/student";

		//  Database credentials
		String USER = "root";
		String PASS = "rajagiri";

		// Set response content type
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String title = "Student Details";
     
		out.println("<html><head><title>" + title + "</title></head><h1 align = \"center\">" + title + "</h1>\n");
		int flag=0;
		Statement stmt= null;
		String sql=null;
		Connection conn=null;
		try
		{
			// Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// Open a connection
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// Execute SQL query
			stmt = conn.createStatement();
   
			sql = "SELECT * FROM  Admin";
			ResultSet rs = stmt.executeQuery(sql);
			String name = request.getParameter("userName");
			String pass = request.getParameter("password");
			
			// Extract data from result set; Retrieve by column name
			while(rs.next())
			{
				String uname = rs.getString("Name");
				String passw = rs.getString("Password");
				
				
				if ( name.equals(uname) && pass.equals(passw))
				{
					flag=1;
					out.println("<center><br><br><h2>Welcome " + name + " </h2>" + "ACCESS GRANTED</center>");
				}
			}
			if(flag==0)
			{
				PreparedStatement prep = null;
				String query = "INSERT INTO Admin VALUES(?, ?)"; 
				prep = conn.prepareStatement(query);
				prep.setString(1, name);
				prep.setString(2, pass);
				
				prep.executeUpdate();
				out.println("<center><br><br><h2>Welcome " + name + " </h2>" + "Your details have been successfully added to this Database</center>");
			}
			out.println("</body></html>");
			rs.close();
			stmt.close();
			conn.close();
		}
		catch(SQLException se)
		{
			//Handle errors for JDBC
			se.printStackTrace();
		}
		catch(Exception e)
		{
			//Handle errors for Class.forName
			e.printStackTrace();
		}
		finally
		{
			//finally block used to close resources
			try
			{
				if(stmt!=null)
				stmt.close();
			}
			catch(SQLException se2)
			{
			} // nothing we can do
			try
			{
				if(conn!=null)
				conn.close();
			}
			catch(SQLException se)
			{
				se.printStackTrace();
			} //end finally try
		} //end try
	}
}
