
<%@page import="java.sql.*;" contentType="text/html" pageEncoding="UTF-8"%>
<%
    String ccode=request.getParameter("ccode");
    try{  
  Class.forName("com.mysql.jdbc.Driver");  
        Connection con=DriverManager.getConnection(  
"jdbc:mysql://localhost:3306/testdb","root","jaspal");  
      //here sonoo is database name, root is username and password  
Statement stmt=con.createStatement();  
ResultSet rs=stmt.executeQuery("select * from states where country_id="+ccode);  
while(rs.next())  
out.println("<option value="+rs.getInt(1) +">"+rs.getString(2)+"</option>");  
con.close();  
    }catch(Exception e)
    {out.println(e);}    
%>