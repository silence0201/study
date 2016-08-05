<%--
  Created by IntelliJ IDEA.
  User: silence
  Date: 16/6/27
  Time: 下午9:33
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="struts"%>
<html>
  <head>
      <meta charset="UTF-8">
      <link rel="stylesheet" href="css/xgxt_login.css" />
      <title>用户登录-勤工俭学管理系统</title>
      <script>
          function login() {
              // console.info("点击了登录");
              var userName = document.getElementById("uName").value;
              // console.info(userName)
              var userPass = document.getElementById("uPass").value;
              // console.info(userPass);
              var pattern = /^([0-9.]+)$/;
              if (userName == "" || userName == null) {
                  alert("用户名不能为空");
                  return false;
              } else if (userPass == "" || userPass == null) {
                  alert("密码不能为空");
                  return false;
              } else if (!pattern.test(userName)){
                  alert("用户名只能为数字");
                  return false;
              }else {
                  return true;
              }
          }
      </script>
  </head>
  <body>
      <div id="header">
          <div class="header_title">
              <span class="title_con">勤工俭学管理系统</span>
          </div>
      </div>

      <div id="content">
          <center>
              <div class="con">
                  <div class="con_title">
                      <span class="con_title_sp">欢迎登录勤工俭学管理系统</span>
                  </div>
                  <div class="con_panel">
                      <struts:form action="loginAction" onsubmit="return login();" method="POST">
                          <div class="con_input">
                              <span>用户名：</span><input name="account" type="text" id="uName" placeholder="工号"/>
                          </div>
                          <div class="con_input">
                              <span>密&nbsp;&nbsp;&nbsp;&nbsp;码：</span><input name="password" type="password" id="uPass" placeholder="密码"/>
                          </div>
                          <struts:submit class="submit-btn"  value="登    录"></struts:submit>
                      </struts:form>
                  </div>
              </div>
          </center>
      </div>

      <div style="text-align:center;">
      </div>
  </body>
</html>
