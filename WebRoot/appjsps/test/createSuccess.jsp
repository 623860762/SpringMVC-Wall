<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.ceit.ebs.cn.test.entity.Test"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String username = (String)request.getAttribute("username");
String password = (String)request.getAttribute("password");
List<Test> list = (List<Test>)request.getAttribute("list");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'createSuccess.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body> 
    用户名：<%=username %><br>
    密码：<%=password %><br>
    <%
    	for(int i = 0 ;i < list.size();i++){
    		%><%=list.get(i).getName()%>
    		<%
    	}
    
     %>
  </body>
</html>
