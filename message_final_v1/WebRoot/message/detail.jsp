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
  	您现在的位置：查看消息的详细内容
  </div>

<div>
    	<table>
    		<tr>
    			<td>
    				<label>标题
			          
			       </label>
    			</td>
    			<td>
    				${msg.title }
    			</td>
    		</tr>
    		<tr>
    			<td>
    				<label>内容
			            
			       </label>
    			</td>
    			<td>
    				${msg.content }
    			</td>
    		</tr>
    		<tr>
    			<td>
    				<label>发送者
			       </label>
    			</td>
    			<td>
    				${msg.senderName}
    			</td>
    		</tr>    		
    		<tr>
    			<td>
    				<label>接收者
			       </label>
    			</td>
    			<td>
    				${msg.receiver.username}
    			</td>
    		</tr>
    		<tr>
    			<td>
    				<label>接收时间
			       </label>
    			</td>
    			<td>
    				${msg.receiveTime}
    			</td>
    		</tr>
    	</table>
</div>

 </div>
<%@include file="/common/footer.jsp" %>
  </body>
</html>
