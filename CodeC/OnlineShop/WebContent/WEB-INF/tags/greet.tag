<%@ tag language="java" import="com.brainmentors.utils.LangReader" pageEncoding="UTF-8"%>

<%@ attribute name="user" type="com.brainmentors.app.dto.UserDTO" required="true" %>
  <% if(user!=null){ %>
          <h1 class="page-header"><%=LangReader.getValue("welcomemsg")%>, <%=LangReader.getValue("rolemsg")%><%=user.getRoleName() %>  &nbsp; <%=session.getAttribute("uid") %> </h1>
		<% } %>