import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
 
public class Database extends HttpServlet{

   public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
   
      // JDBC driver name and database URL
      String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
      String DB_URL="jdbc:mysql://localhost/student";

      //  Database credentials
      String USER = "root";
      String PASS = "rajagiri";

      // Set response content type
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      String title = "Database Authentication";
      
//      String docType =     "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
      String docType =     "";
      int f=0;
      out.println(docType +
         "<html>\n" +
         "<head><title>" + title + "</title></head>\n" +
         "<body bgcolor = \"#f0f0f0\">\n" +
         "<h1 align = \"center\">" + title + "</h1>\n"); 
         String name = request.getParameter("name");
		 String psswd = request.getParameter("psswd");
	  Statement stmt= null;
	  String sql=null;
	  Connection conn=null;
      try {
         // Register JDBC driver
         Class.forName("com.mysql.jdbc.Driver");

         // Open a connection
          conn = DriverManager.getConnection(DB_URL, USER, PASS);

         // Execute SQL query
         stmt = conn.createStatement();
   
         sql = "SELECT * FROM Admin";
         ResultSet rs = stmt.executeQuery(sql);
		 
         // Extract data from result set
         while(rs.next()){
        
            String uname = rs.getString("Name");
            String pass = rs.getString("Password");
            
			
      
			if((name.compareTo(uname)==0))
			{	
			 if(psswd.compareTo(pass)==0)
				 
			 {	f=1;
			    out.println("<center><h2>login successfull</h2></center>");
                
				
				response.sendRedirect("welcomlogin.html"); 
		     }
		    }
			
         }
		
         // Clean-up environment
         rs.close();
         stmt.close();
         conn.close();
      } catch(SQLException se) {
         //Handle errors for JDBC
         se.printStackTrace();
      } catch(Exception e) {
         //Handle errors for Class.forName
         e.printStackTrace();
      } finally {
         //finally block used to close resources
         try {
            if(stmt!=null)
               stmt.close();
         } catch(SQLException se2) {
         } // nothing we can do
         try {
            if(conn!=null)
            conn.close();
         } catch(SQLException se) {
            se.printStackTrace();
         } //end finally try
      } //end try
  
        if(f==0)
		 {  
      
	 		 
		 
			 out.println("<center><h2>login failed</h2></center>");
		 }
		  out.println("</body></html>");
	  }
	  
}