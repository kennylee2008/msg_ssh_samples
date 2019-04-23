<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>初始化数据成功</title>
    
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
    <h1>初始化数据成功[<a href="index.jsp">返回登录页面</a>]</h1>
    <ul>
    	<li>Group:OA项目组
    		<ul>
    			<li>User:张三,密码：1</li>
    			<li>User:李四,密码：1</li>
    			<li>User:王五,密码：1</li>
    		</ul>
    	</li>
    	<li>Group:CRM项目组
    		<ul>
    			<li>User:赵毅,密码：1</li>
    			<li>User:陈思,密码：1</li>
    		</ul>
    	</li>
    	<li>Group:ERP项目组
    		<ul>
    			<li>User:刘备,密码：1</li>
    			<li>User:诸葛亮,密码：1</li>
    		</ul>
    	</li>
    </ul>
  </body>
</html>
