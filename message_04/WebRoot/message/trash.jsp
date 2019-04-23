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
  	您有【0】条新的短消息 <br/><br/>
  	您现在的位置：垃圾箱
  </div>

<div>
    <table>
    	<tr>
    		<th>ID</th>
    		<th>标题</th>
    		<th>发送者</th>
    		<th>接收者</th>
    		<th>发送时间</th>
    		<th>操作</th>
    	</tr>
   		<s:iterator value="#msgs">
    	<tr>
    		<td><s:property value="id"/></td>
    		<td>
    			<a href="msg!detail.action?id=<s:property value="id"/>"><s:property value="thread.title"/></a>
    		</td>
    		<td><s:property value="thread.senderName"/></td>
    		<td>
    		<s:iterator value="thread.receiverNames">
    			<s:property value="key"/>[<s:property value="value?'已读':'未读'"/>],
    		</s:iterator>
    		</td>
    		<td>
    			<s:date name="thread.sendTime" format="yyyy-MM-dd HH:mm:ss"/>
    		</td>    		
    		<td>
    			<a href="msg!delReal.action?id=<s:property value="id"/>">删除</a>
    		</td>
    	</tr>
    	</s:iterator>
    </table>
</div>

 </div>
  </body>
</html>
