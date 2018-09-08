<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
    <%@taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<sb:head/>
</head>
<body>
<h1><s:property value="message"/></h1>

<s:form action="checklogin" method="post">
<s:textfield  name="userid" label="Enter the Userid"/>
<s:password name="pwd" label="Enter the Password"/>
<s:select name="mycountry" list="country"/>

<s:combobox list="country"  name="co"></s:combobox>
<s:submit cssClass="btn btn-primary"/>
</s:form>
</body>
</html>