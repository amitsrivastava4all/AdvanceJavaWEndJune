
	<%
	if(session.getAttribute("uid")==null){
		response.sendRedirect("index.html");
	}
	%>
	<h2>Welcome <%=session.getAttribute("uid") %></h2>
	<h1>Add Product</h1>
	
