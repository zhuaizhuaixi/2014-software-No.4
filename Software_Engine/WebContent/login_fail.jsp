<!DOCTYPE html>
<!-- saved from url=(0086)https://passport.zhihuishu.com/login?service=http://online.zhihuishu.com/onlineSchool/ -->
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<meta name="viewport" content="width=device-width, initial-scale=0.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0">
<meta name="description">
<title>课程网站平台</title>
<link href="https://assets.zhihuishu.com/icon/favicon.ico" rel="shortcut icon">
<link href="./css/base.css" rel="stylesheet" type="text/css">
<link href="./css/wall.css" rel="stylesheet" type="text/css">
<script src="./css/jquery.min.js.下载" type="text/javascript"></script>
<script src="./css/three.min.js.下载" type="text/javascript"></script>
<script src="./css/layer.js.下载" type="text/javascript"></script>
<link rel="stylesheet" href="./css/layer.css" id="layuicss-skinlayercss">
<script type="text/javascript" src="./css/sign_up.js.下载"></script>
<script type="text/javascript" src="./css/find_pwd.js.下载"></script>
</head>
<body class="wall-body">



<form name="form1" action="login.action" method="post" >

<div class="wall-warp">
		<div class="wall-main">
			<div class="wall-icon wall-logo"></div>
			<div class="switch-nav">
				
			</div>
			<!--登录-->
			<div class="switch-wrap switch-wrap-signin active">
				<ul class="wall-form-ipt-list">
					<li>
						<input type="text" placeholder="请输入学号" value=""  name="username" onfocus="hideErrorInfo(&#39;form-ipt-error-l-username&#39;);"id="lUsername" >
						<label class="form-ipt-error" id="form-ipt-error-l-username">学号不能为空</label>
					</li>
					<li>
						<input type="password" placeholder="密码" value="" name="password" onfocus="hideErrorInfo(&#39;form-ipt-error-l-password&#39;);" id="lPassword" >
						<label class="form-ipt-error" id="form-ipt-error-l-password">密码不能为空</label>
					</li>
				</ul>
				
				
			
   					<div class="row">
     				    <div class="col col-4">
     				     <label class="radio">
        			    <input type="radio" name="radio"  value="student" checked >
        			    <i></i>学生</label>
        				  <label class="radio">
       	 			    <input type="radio" name="radio"  value="teacher">
     		       <i></i>教师</label>
      				</div>
        <p>密码错误，请重新登录</p>
     					</div>
  		<input type="submit" class="wall-sub-btn" value="登录">
               </div>
           </div>

 
<script src="./css/wallbgcanvas.js.下载" type="text/javascript"></script>
<div id="wall-bg"><span></span><canvas width="1362" height="909" style="width: 1362px; height: 909px;"></canvas></div>
	</div>
	</form>
</body>
</html>