<html>
<body>
<%
String str1=request.getParameter("ans1");
String str2=request.getParameter("ans2");
String str3=request.getParameter("ans3");
if (str1.equals("a")) {
	
        out.println("<h1>"+"correct"+"</h1>");
		
		
		
        
     
   
         
		
		
  } 
		else {

            out.println("wrong");
           
		     }
			 
			 
if (str2.equals("a")) {
	
        out.println("<h1>"+"correct"+"</h1>");
		
		
		
        
     
   
         
		
		
  } 
		else {

            out.println("wrong");
           
		     }
if (str3.equals("b")) {
	
        out.println("<h1>"+"correct"+"</h1>");
		
		
		
        
     
   
         
		
		
  } 
		else {

            out.println("wrong");
           
		     }			 
			 
			 
			 
%>
</html>
</body>
