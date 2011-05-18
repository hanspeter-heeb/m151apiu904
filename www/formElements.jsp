<% 
	
	for(long i=1;i<1000000000;i++);

		java.util.Enumeration e = request.getParameterNames();
		while(e.hasMoreElements()){
			Object o = e.nextElement();
			String s = o.toString();
%>
			<%=  s%> = <%= request.getParameter(s) %><br>
<% }%>