<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<title>car</title>
   <link rel="stylesheet" type="text/css" href="bootstrap-3.3.5-dist/css/bootstrap-theme.min.css"/>
	<link rel="stylesheet" type="text/css" href="bootstrap-3.3.5-dist/css/bootstrap.min.css" />
	<style type="text/css">
		.carId{
			display: none;		
		}
	</style>
  </head>
  
  <body>
    <form action="${cvm.viewClass.action}" method="post">
		${cvm.input}
		<input type="submit" value="提交"/>
    </form>
  </body>
</html>
