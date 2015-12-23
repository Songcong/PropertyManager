<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
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
     <a href="loginAssign" >aldkj</a><br>
     <a href="userinfoAssign!list">查看信息</a>
     <a href="carAssign!list">查看车辆信息</a>
     <a href="carmanageAssign!list">carmanage</a>
     <a href="charstanAssign!list">charstan</a>
     <a href="expdetailAssign!list">exp</a>
     <a href="expensetypeAssign!list">exp2</a>
     <a href="stallAssign!list">stall</a>
     <a href="jobtypeAssign!list">jobtypeDao</a>
     
  </body>
</html>
