<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'register.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		#userid,#tag{
			display: none;		
		}
	</style>
  </head>
  
  <body>
    <form action="${revm.viewclass.action}" method="post">
    	${revm.userid}
    	${revm.username}
    	${revm.password}
    	${revm.realname}
		${revm.sex}
		${revm.telnumber}
		${revm.email}
		${revm.address}
		${revm.tag}
		<input type="submit" value="提交"/>
    </form>
  </body>
</html>
