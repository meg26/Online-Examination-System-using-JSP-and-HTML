<html>
<body>

<%
String str1=request.getParameter("ans1");
String str2=request.getParameter("ans2");
String str3=request.getParameter("ans3");
float m =0;
float p;
if (str1.equals("b")) {
	
        out.println("Q1) CORRECT: correct answer->One teacher can have many classes  <br>");
		
		m=m+1;
		
       
     
   
         
		
		
  } 
		else {

            out.println("Q1) WRONG: correct answer->One teacher can have many classes  <br>");
           
		     }
			 
			 
if (str2.equals("a")) {
	
        out.println("Q2)CORRECT: correct answer->Data Definition <br>");
		 m=m+1;
		
		
        
     
   
         
		
		
  } 
		else {

            out.println("Q2)WRONG: correct answer->Data Definition <br>");
           
		     }
if (str3.equals("b")) {
	
        out.println("Q3)CORRECT: correct answer->Query <br>");
		
		
		
        
     m=m+1;
   
         
		
		
  } 
		else {

            out.println("Q3)WRONG: correct answer->Query<br>");
           
		     }			 
		p=(m/3)*100;
	out.println("Result"+p);	
      	
			 
%>

</body>
</html>

