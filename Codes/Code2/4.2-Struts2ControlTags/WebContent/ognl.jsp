<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Result</title>
<s:head />
<style type="text/css">
@import url(style.css);
</style>
</head>
<body>
<div class="content">

<b>Array Usage Examples</b>
<br><hr>
<b>sampleArray :</b> <s:property value="sampleArray"/> <br>
<b>sampleArray.length :</b> <s:property value="sampleArray.length"/> <br>
<b>sampleArray[0] :</b> <s:property value="sampleArray[0]"/> <br>
<b>[0].sampleArray :</b> <s:property value="[0].sampleArray"/> <br>
<b>top.sampleArray :</b> <s:property value="top.sampleArray"/> <br>
<br>

<b>List Usage Examples</b>
<br><hr>
<b>sampleList :</b> <s:property value="sampleList"/> <br>
<b>sampleList.size :</b> <s:property value="sampleList.size"/> <br>
<b>sampleList[0] :</b> <s:property value="sampleList[0]"/> <br>
<br>

<b>Map Usage Examples</b>
<br><hr>
<b>sampleMap[1] :</b> <s:property value="sampleMap[1]"/> <br>
<b>sampleMap.size :</b> <s:property value="sampleMap.size"/> <br>
<s:select list="#{'make1':'Ford', 'make2':'Honda', 'make3':'Toyota'}" name="carMake" label="Select "></s:select><br>
<br>

<b>Invoking a Method</b>
<br><hr>
<b>user.name :</b> <s:property value="user.name"/> <br>
<b>quote() :</b> <s:property value="quote()"/> <br>
<b>UserList :</b> <s:property value="userList[0].name"/><br>
<b>Session Value :</b> <s:property value="#session.sessionuser"/><br>
<b>Session Value Another Way:</b> <s:property value="#session['sessionuser']"/><br>

</div>
</body>
</html>