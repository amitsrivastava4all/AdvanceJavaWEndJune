<%@tag import="com.brainmentors.utils.CommonUtils"%>
<%@ tag language="java" import="com.brainmentors.app.dto.RightDTO" pageEncoding="UTF-8"%>
<%@ attribute name="userDTO" type="com.brainmentors.app.dto.UserDTO" required="true" %>
 <ul class="nav nav-sidebar">
          <% 
          boolean isActive = true;
          if(userDTO!=null && userDTO.getRights()!=null && userDTO.getRights().size()>0){
          for(RightDTO rightDTO : userDTO.getRights()) { %>
          <li class="<%=isActive?"active":"" %>"><a onclick="doAjax('<%=CommonUtils.getContextPath() %>','<%=rightDTO.getScreenName()%>')" href="#"><%=rightDTO.getName() %></a></li>
          <%
          isActive = false;
          }
          }
          %>
          
          </ul>