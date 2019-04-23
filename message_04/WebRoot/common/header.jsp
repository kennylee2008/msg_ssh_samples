<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<script type="text/javascript">
<!--
window.onload = function(){
	document.getElementById("content").style.width = document.body.clientWidth - 211;
}
//-->
</script>
<div id=top>
 <div id=logo><img src="image/logo.gif" width="145" height="30" /></div>
 <div id=xx>
  <div id=hy>您好，<strong><s:property value="#session.login.username"/> [<a href="#">退出登录</a>]</strong>
  	<h1>基于SSH的消息管理系统 - Version 2.0</h1>
  </div>
  <div id=topTags>
   <ul></ul>
  </div>
 </div>
</div>
<div id=zhong>
 <div id=zb>
  <div id=shb>
   <ul>
    <li class="aa" onmouseover="this.className='bb'" onmouseout="this.className='aa'"><a href="back_index.jsp">首页</a></li>
    <li class="cc" onmouseover="this.className='dd'" onmouseout="this.className='cc'"><a href="msg!sendInput.action">发消息</a></li>
   </ul>
  </div>
  <div id=sys><img src="image/icon01.gif" width="11" height="6" />功能菜单</div>
  <div id=leftMenu>
  <div id="leftMenuPic"><img src="image/mun_bg.gif" /></div>
   <ul>
    <li><a href="msg!inbox.action">收件箱</a></li>
    <li><a href="msg!outbox.action">发件箱</a></li>
    <li><a href="msg!trash.action">垃圾箱</a></li>
   </ul>
  </div>
 </div>
