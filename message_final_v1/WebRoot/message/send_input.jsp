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
  	发送消息，请选择一个或多个用户进行发送，您也可以同时选择一个组进行发送
  </div>

<div id="stylized" class="myform">
    <form id="form" name="form" method="post" action="msg!send.action">
    	<table>
    		<tr>
    			<td>
    				<label>标题
			           <span class="small">长度不能超过255个字符</span>
			       </label>
    			</td>
    			<td>
    				<input type="text" name="title" maxlength="255" size="100"/>
    			</td>
    		</tr>
    		<tr>
    			<td>
    				<label>内容
			            <span class="small">请输入消息的内容</span>
			       </label>
    			</td>
    			<td>
    				<textarea rows="10" cols="100" name="content"></textarea>
    			</td>
    		</tr>
    		<tr>
    			<td>
    				<label>接收者
			            <span class="small">您可以选择多个接收者或者同时选择一个组</span>
			       </label>
    			</td>
    			<td>
    				选择接收者：
    				<select name="receiverIds" multiple="multiple" size="5" style="width:150px">
    				<s:iterator value="#users">
    				<option value="<s:property value="id"/>"><s:property value="username"/></option>
    				</s:iterator>
    				</select>
    				
    				或选择接收组：
    				<select name="groupId" style="width:150px">
    				<option value="0">----</option>
    				<s:iterator value="#groups">
    				<option value="<s:property value="id"/>"><s:property value="name"/></option>
    				</s:iterator>
    				</select>
    			</td>
    		</tr>
    		<tr>
    			<td colspan="2" style="text-align: center">
    				<button type="submit">发送消息</button>
    			</td>
    		</tr>
    	</table>
    	
       
       <div class="spacer"></div>
    </form>
</div>

 </div>
<%@include file="/common/footer.jsp" %>
  </body>
</html>
