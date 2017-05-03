<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xgtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
               <p>  学号${sessionScope.value}!</p>
				<p>  <a href="changepw.action?changeid=${sessionScope.value}">修改密码</a></p>


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
			<p>友情链接</p>
			<p><a href="http://www.baidu.com">百度</a></p>
			<p><a href="http://jwch.fzu.edu.cn">福大教务处</a></p>
			<p><a href="http://www.fzu.edu.cn">福大官网</a></p>
			<p><a href="http://yiban.fzu.edu.cn">福大易班</a></p>
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
        <td height="31" width="130"><div class="titlebt"><a href="show.action">学生名单</font></a></div></td>
        <td height="31" width="130"><div class="titlebt"><a href="showfile.action"><font color="#00AEAE">查看课件</a></div></td>
        <td height="31" width="130"><div class="titlebt"><a href="teach.action">教学大纲</a></div></td>
        <td height="31" width="130"><div class="titlebt"><a href="practice.action">习题问答</a></div></td>
        <td height="31" width="130" ><div class="titlebt" ><a href="showexp.action">教学实验</a></div></td>
        <td height="31" width="130" ><div class="titlebt" ><a href="showmessage.action">交流天地</a></div></td>
         <td width="16" valign="top" ><img src="picture/nav-right-bg.gif" width="0" height="29"></td>
      </tr>
    </tbody></table>
    </td>
    </tr>
    
    <s:form action="upload.action" enctype="multipart/form-data" method="post">
    <s:file   name="upload"  label="选择文件"/><br/>
    <s:submit value="上传"/>   
    </s:form>

  
<!--页脚-->
		<footer>
			
			
		</footer>

	</div>

</div>

<div class="extra1" role="presentation"></div><div class="extra2" role="presentation"></div><div class="extra3" role="presentation"></div>
<div class="extra4" role="presentation"></div><div class="extra5" role="presentation"></div><div class="extra6" role="presentation"></div>

</body>
</html>