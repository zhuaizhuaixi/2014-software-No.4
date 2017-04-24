<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.se.util.PageBean"%>
<%@page import="java.util.List,com.se.domain.Student"%>
<%@page import="com.se.dao.StudentDaoJDBCImpl"%>
<%@page import="com.se.dao.StudentDao"%>
<html lang="en">
<head>
	<meta charset="utf-8">
	<title>课程网站平台</title>

	<link rel="stylesheet" media="screen" href="style.css?v=8may2013">
	<link rel="alternate" type="application/rss+xml" title="RSS" href="http://www.csszengarden.com/zengarden.xml">

	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="author" content="Dave Shea">
	<meta name="description" content="A demonstration of what can be accomplished visually through CSS-based design.">
	<meta name="robots" content="all">


	<!--[if lt IE 9]>
	<script src="script/html5shiv.js"></script>
	<![endif]-->
</head>



<body id="css-zen-garden">

<div class="page-wrapper">
	<section class="intro" id="zen-intro">
		<!--个人信息-->


<p>  欢迎您${sessionScope.username}!</p>


		<!--日历-->
		<div class="summary" id="calendar" role="article">
			<div id="blog-calendar" style=""><table id="blogCalendar" class="Cal" cellspacing="0" cellpadding="0" title="日历">
	<tbody><tr><td colspan="7"><table class="CalTitle" cellspacing="0">
		<tbody><tr><td class="CalNextPrev"><a href="javascript:void(0);" onclick="loadBlogCalendar(&#39;2017/03/01&#39;);return false;">&lt;</a></td><td align="center">2017年4月</td><td class="CalNextPrev" align="right"><a href="javascript:void(0);" onclick="loadBlogCalendar(&#39;2017/05/01&#39;);return false;">&gt;</a></td></tr>
	</tbody></table></td></tr><tr><th class="CalDayHeader" align="center" abbr="日" scope="col">日</th><th class="CalDayHeader" align="center" abbr="一" scope="col">一</th><th class="CalDayHeader" align="center" abbr="二" scope="col">二</th><th class="CalDayHeader" align="center" abbr="三" scope="col">三</th><th class="CalDayHeader" align="center" abbr="四" scope="col">四</th><th class="CalDayHeader" align="center" abbr="五" scope="col">五</th><th class="CalDayHeader" align="center" abbr="六" scope="col">六</th></tr><tr><td class="CalOtherMonthDay" align="center">26</td><td class="CalOtherMonthDay" align="center">27</td><td class="CalOtherMonthDay" align="center">28</td><td class="CalOtherMonthDay" align="center">29</td><td class="CalOtherMonthDay" align="center">30</td><td class="CalOtherMonthDay" align="center">31</td><td class="CalWeekendDay" align="center"><a>1</a></td></tr><tr><td class="CalWeekendDay" align="center"><a >2</a></td><td align="center">3</td><td align="center"><a>4</a></td><td align="center"><a>5</a></td><td align="center">6</td><td align="center">7</td><td class="CalWeekendDay" align="center">8</td></tr><tr><td class="CalWeekendDay" align="center">9</td><td align="center">10</td><td align="center">11</td><td align="center">12</td><td align="center">13</td><td align="center">14</td><td class="CalWeekendDay" align="center">15</td></tr><tr><td class="CalWeekendDay" align="center">16</td><td align="center">17</td><td align="center">18</td><td align="center">19</td><td align="center">20</td><td align="center">21</td><td class="CalWeekendDay" align="center">22</td></tr><tr><td class="CalWeekendDay" align="center">23</td><td align="center">24</td><td align="center">25</td><td align="center">26</td><td align="center">27</td><td align="center">28</td><td class="CalWeekendDay" align="center">29</td></tr><tr><td class="CalWeekendDay" align="center">30</td><td class="CalOtherMonthDay" align="center">1</td><td class="CalOtherMonthDay" align="center">2</td><td class="CalOtherMonthDay" align="center">3</td><td class="CalOtherMonthDay" align="center">4</td><td class="CalOtherMonthDay" align="center">5</td><td class="CalOtherMonthDay" align="center">6</td></tr>
</tbody></table></div><script type="text/javascript">loadBlogDefaultCalendar();</script></div>
		</div>

<!--留言板-->
		<div class="preamble" id="zen-preamble" role="article">
			<h3>The Road to Enlightenment</h3>
			<p>Littering a dark and dreary road lay the past relics of browser-specific tags, incompatible <abbr title="Document Object Model">DOM</abbr>s, broken <abbr title="Cascading Style Sheets">CSS</abbr> support, and abandoned browsers.</p>
			<p>We must clear the mind of the past. Web enlightenment has been achieved thanks to the tireless efforts of folk like the <abbr title="World Wide Web Consortium">W3C</abbr>, <abbr title="Web Standards Project">WaSP</abbr>, and the major browser creators.</p>
			<p>The CSS Zen Garden invites you to relax and meditate on the important lessons of the masters. Begin to see with clarity. Learn to use the time-honored techniques in new and invigorating fashion. Become one with the web.</p>
		</div>
	</section>

	<div class="main supporting" id="zen-supporting" role="main">
		<div class="explanation" id="zen-explanation" role="article">
			<tr>
    <!--标签栏-->
    <td valign="top" ><table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2" style="background-image:url(picture/content-bg.gif)">
      <tbody><tr>
      	<td width="17" valign="top"><img src="picture/left-top-right.gif" width="17" height="29"></td>
               <td height="31" width="130"><div class="titlebt"><a href="index.jsp">首页</a></div></td>
        <td height="31" width="130"><div class="titlebt"><a href="show.action"><font color="#00AEAE">学生名单</font></a></div></td>
        <td height="31" width="130"><div class="titlebt"><a href="showfile.action">查看课件</a></div></td>
        <td height="31" width="130"><div class="titlebt"><a href="teach.action">教学大纲</a></div></td>
        <td height="31" width="130"><div class="titlebt"><a href="practice.action">习题问答</a></div></td>
        <td height="31" width="130" ><div class="titlebt" ><a href="showexp.action">教学实验</a></div></td>
        <td height="31" width="130" ><div class="titlebt" ><a href="showmessage.action">交流天地</a></div></td>
         <td width="16" valign="top" ><img src="picture/nav-right-bg.gif" width="0" height="29"></td>
      </tr>
    </tbody></table>
    </td>
    </tr>



    <!--按钮-->
    	<a href="#" class="button grey">导出花名册</a>
    	<a href="add.jsp" class="button grey">导入数据</a>
		 <!--正文-->
		</div>

		<h1 align="center">学生花名册</h1>
	<table>
		<tr>
			<td>学生学号</td>
			<td>学生姓名</td>
			<td>学生性别</td>
			<td>上次登陆时间</td>
		</tr>
		<%-- jsp尽量不要调用service或者dao对象, 应该从request里取出对象 --%>
		<%
			String status;
			PageBean pageBean = (PageBean) request.getAttribute("studentList"); //important!
			List<Student> students = pageBean.getData();
			for (Student student : students) {
				
		%>
		<tr>
			<td><%=student.getId()%></td>
			<td><%=student.getName()%></td>
			<td><%=student.getSex()%></td>
			<td><%=student.getLast_login()%></td>
		</tr>

		<%
			}
		%>
	</table>
	<form name="PageForm" action="show.action" method="post">
					<%@ include file="./page.jsp"%>
	</form>


<!--页脚-->
		<footer>
		
		</footer>

	</div>

</div>

<div class="extra1" role="presentation"></div><div class="extra2" role="presentation"></div><div class="extra3" role="presentation"></div>
<div class="extra4" role="presentation"></div><div class="extra5" role="presentation"></div><div class="extra6" role="presentation"></div>

</body>
</html>