<%@tag import="java.util.Locale"%>
<%@tag import="java.text.DateFormat"%>
<%@tag import="java.util.Map"%>
<%@tag import="java.util.HashMap"%>

<%@ tag import="java.util.Date" language="java" pageEncoding="UTF-8"%>
<%
Map<String, String> map = new HashMap<>();
map.put("hi","IN");
map.put("en","US");
String country = map.get(session.getAttribute("currentlang").toString());
System.out.println("Current Lang is "+session.getAttribute("currentlang"));
Locale locale = new Locale(session.getAttribute("currentlang").toString(), country);
DateFormat df = DateFormat.getDateInstance(DateFormat.FULL, locale);
Date date = new Date();
String formattedDate = df.format(date);
%>
 <%=formattedDate %>
