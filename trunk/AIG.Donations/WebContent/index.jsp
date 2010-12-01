<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<center>
	<script type="text/javascript">
	function change_the_title(){
		var msg = 'Use jQuery, GWS <br/>but never pure JS';
		document.getElementById('the_title').innerHTML = msg;
	}
	</script>
	
	
	<h1 id="the_title"> Hello World</h1>
	
	<input type='button' onclick='change_the_title()' value='Show Advise'/>
	<br/>
	
	<pre>
	Current time: <%= new java.util.Date() %> <br/>

	</pre>
	
	<hr/>
	
	<h2> Testlet </h2>
	<form name="input" action="Testlet" method="get">
		<input type="submit" value="Submit" />
	</form>
	
	<hr/>	
	<a href="db_test.jsp"> Go To DB Test</a>

	
</center>

</body>
</html>