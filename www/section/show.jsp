<%@ page import = "m223.apiu904.model.*" %>
<%@ page import = "m151.apiu904.controller.*" %>

<html>
	<head>
		<title></title>
	</head>
	<body>
		
		
		<p><%=  session.getAttribute("base") %></p>
		<p>controller=<%=  session.getAttribute("controller") %></p>
		<p>action=<%=  session.getAttribute("action") %></p>
		<p>id=<%=  session.getAttribute("id") %></p>
		<p>section=<%=  session.getAttribute("section") %></p>
		
		<%= new Helper(session.getAttribute("section")).fieldsTable() %>
	</body>
</html>