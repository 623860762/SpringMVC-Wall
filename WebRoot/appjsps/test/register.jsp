<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String name = (String)request.getAttribute("user");
 %>
<html>
  <head>
    <title>新增用户</title>
  </head>
  
  <body>
   <form method="post" action='../testController/createSuccess.do'>
     <table>
      <tr>
       <td>用户名:</td>
       <td><input type="text" name="username"/></td>
      </tr>
      <tr>
       <td>密码:</td>
       <td><input type="password" name="password"/></td>
      </tr>
      <tr>
       <td colspan="2"><input type="submit" name="提交"/></td>
      </tr>
     </table>
   
   </form>
  </body>
</html>