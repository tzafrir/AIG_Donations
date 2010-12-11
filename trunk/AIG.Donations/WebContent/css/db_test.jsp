<%@ page import="java.sql.*" %>
<%@ page import="aig.debug.*" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DB TEsts</title>
</head>
<body>

<%
    // This is a scriptlet.  Notice that the "date"
    // variable we declare here is available in the
    // embedded expression later on.


//String driverName = "com.jnetdirect.jsql.JSQLDriver"; // NetDirect JDBC driver 
%>
   <p> fetching table from mysql </p>
   
   <table border="1px">
   <tr> <td> LOCAL test_tbl </td> </tr>
   <tr> <td> id_c5 </td> </tr>
   <%= DBcommon.testHome() %>
   </table>
   
   <p>SSDL</p>
   
   <table border="1px">
   <tr> <td> SSDL test_tbl </td> </tr>
   <tr> <td> id_c5 </td> </tr>
   <%= DBcommon.testSSDL()  %>
   </table>


</body>
</html>