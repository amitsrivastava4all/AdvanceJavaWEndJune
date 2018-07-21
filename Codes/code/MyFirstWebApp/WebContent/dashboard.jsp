<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" autoFlush="true" buffer="18kb" 
    errorPage="error.jsp" isErrorPage="false" import="java.util.Date"
    trimDirectiveWhitespaces="true" 
     %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>डैशबोर्ड </title>
</head>
<body>
<%@include file="/pages/paritals/header.jsp" %>
<%! int counter; %>
<%
int mycounter=0;
counter++;
mycounter++;
int x = 10/3;
//out.println("Counter is "+counter+" Local Counter is "+mycounter);
%>
UserName is <%=userName %>
<h2>Counter is <%=counter %> and Local Counter is <%=mycounter %></h2>
<%=new Date() %>
<%@include file="/pages/paritals/footer.jsp" %>
</body>
</html>




