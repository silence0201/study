<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="struts"%>
<html lang="en" class="no-js">
    <head>
        <meta charset="utf-8">
        <title>漂亮支持响应式多终端适配的网站登录页面模板 - JS代码网</title>
		<meta name="keywords" content="网站模板,手机网站模板,手机登录页面,登录页面HTML,免费网站模板下载" />
		<meta name="description" content="JS代码网提供高质量手机网站模板下载" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">

        <!-- CSS -->
        <link rel="stylesheet" href="assets/css/reset.css">
        <link rel="stylesheet" href="assets/css/supersized.css">
        <link rel="stylesheet" href="assets/css/style.css">

        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->

    </head>

    <body>

        <div class="page-container">
            <h1>登录</h1>
            <struts:form action="loginAction" onsubmit="return login();" method="POST">
                <div class="con_input">
                    <input name="account" type="text" id="uName" placeholder="工号" class="username"/>
                </div>
                <div class="con_input">
                    <input name="password" type="password" id="uPass" placeholder="密码" class="password"/>
                </div>
                <struts:submit class="submit-btn"  value="登    录"></struts:submit>
            </struts:form>
            <div class="connect">
                <p>Or connect with:</p>
                <p>
                    <a class="facebook" href=""></a>
                    <a class="twitter" href=""></a>
                </p>
            </div>
        </div>
		
        <!-- Javascript -->
        <script src="assets/js/jquery-1.8.2.min.js"></script>
        <script src="assets/js/supersized.3.2.7.min.js"></script>
        <script src="assets/js/supersized-init.js"></script>
        <script src="assets/js/scripts.js"></script>

    </body>

</html>


