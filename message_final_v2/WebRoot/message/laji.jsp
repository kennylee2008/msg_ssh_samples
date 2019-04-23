<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/message/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>欢迎使用领航致远消息管理系统</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="领航致远,SSH,Spring,Hibernate,Struts,消息管理系统">
	<meta http-equiv="description" content="领航致远,SSH,Spring,Hibernate,Struts,消息管理系统">
	<link rel="stylesheet" type="text/css" href="styles.css">
  </head>
  
  <body>
<%@include file="/common/header.jsp" %>
 <div id=content>
  <div id=sm>
  	欢迎使用消息管理系统！
  	您有【${newmsg}】条新的短消息 <br/><br/>
  	您现在的位置：垃圾箱
  </div>

<div>
    <table>
    	<tr>
    		<th>ID</th>
    		<th>标题</th>
    		<th>内容</th>
    		<th>发送者</th>
    		<th>接收者</th>
    		<th>删除时间</th>
    		<th>操作</th>
    	</tr>
    	<s:iterator value="#msgs">
    	<tr>
    		<td><s:property value="id"/></td>
    		<td><s:property value="title"/></td>
    		<td><s:property value="content"/></td>
    		<td><s:property value="senderName"/></td>
    		<td><s:property value="receiverNames"/></td>
    		<td><s:property value="deletedTime"/></td>
    		<td><a href="msg!delLaji.action?id=<s:property value="id"/>">删除</a></td>
    	</tr>
    	</s:iterator>
    </table>
</div>

 </div>
<%@include file="/common/footer.jsp" %>
  </body>
</html>
