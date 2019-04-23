<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
  <div id=hy>您好，<strong>${login.username } [<a href="../system/login!logout.action">退出登录</a>]</strong>
  	<h1>基于SSH的消息管理系统演示 - Version1</h1>
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
    <li class="aa" onmouseover="this.className='bb'" onmouseout="this.className='aa'"><a href="msg!index.action">首页</a></li>
    <li class="cc" onmouseover="this.className='dd'" onmouseout="this.className='cc'"><a href="msg!sendInput.action">发消息</a></li>
   </ul>
  </div>
  <div id=sys><img src="image/icon01.gif" width="11" height="6" />功能菜单</div>
  <div id=leftMenu>
  <div id="leftMenuPic"><img src="image/mun_bg.gif" /></div>
   <ul>
    <li><a href="msg!inbox.action">收件箱</a></li>
    <li><a href="msg!outbox.action">发件箱</a></li>
    <li><a href="msg!laji.action">垃圾箱</a></li>
   </ul>
  </div>
 </div>
