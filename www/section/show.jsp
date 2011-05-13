<%@ page import = "m223.apiu904.model.*" %>
<%
	Object o = session.getAttribute("section");
	Section s = null;
	if(o instanceof Section)
		s = (Section) o;
%>
<html>
	<head>
		<title></title>
	</head>
	<body>
		
		<h3><%= s==null? "Datensatz nicht gefunden" : s.getTitle() %></h3>
		<p><%=  session.getAttribute("base") %></p>
		<p>controller=<%=  session.getAttribute("controller") %></p>
		<p>action=<%=  session.getAttribute("action") %></p>
		<p>id=<%=  session.getAttribute("id") %></p>
		
	</body>
</html>