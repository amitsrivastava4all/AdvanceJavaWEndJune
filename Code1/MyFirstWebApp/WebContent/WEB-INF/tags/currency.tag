<%@tag import="java.text.NumberFormat"%>
<%@tag import="java.util.Locale"%>

<%@tag import="java.util.Map"%>
<%@tag import="java.util.HashMap"%>

<%@ tag import="java.util.Date" language="java" pageEncoding="UTF-8"%>
<%@ attribute name="amount" type="java.lang.Double" required="true" %>
<%
Map<String, String> map = new HashMap<>();
map.put("hi","IN");
map.put("en","US");
String country = map.get(session.getAttribute("currentlang").toString());
System.out.println("Current Lang is "+session.getAttribute("currentlang"));
Locale locale = new Locale(session.getAttribute("currentlang").toString(), country);
NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
String formattedAmount = nf.format(amount);
%>
<script>
convert("USD","INR",<%=amount%>,"printcur");
</script>
 <%=formattedAmount %>
