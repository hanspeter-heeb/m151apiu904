<% 
	Object cnt = session.getAttribute("counter");
	if(cnt==null)
	{	session.setAttribute("counter", new Integer(1)); ;}
	else
	{
		int i = ((Integer)session.getAttribute("counter")).intValue();
		session.setAttribute("counter", new Integer(i+1));
	}
	for(long i=1;i<1000000000;i++);
%>
Zähler: <%= session.getAttribute("counter").toString() %><br>
