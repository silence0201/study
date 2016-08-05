<%--
  Created by IntelliJ IDEA.
  User: silence
  Date: 16/6/27
  Time: 下午10:13
  新增工作申请
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="struts"%>
<html>
<head>
    <title>工作申请添加</title>
    <link rel="stylesheet" type="text/css" href="../css/common.css"/>
    <link rel="stylesheet" type="text/css" href="../css/main.css"/>
    <script>
        function addRequest() {

            var studentID = document.getElementById("stuID").value;

            var studentName = document.getElementById("stuName").value;

            var studentAcademy = document.getElementById("stuAcademy").value;
            var studentMajor = document.getElementById("stuMajor").value;
            var studentPhone = document.getElementById("stuPhone").value;
            var studentFirstChoice = document.getElementById("stuFirstChoice").value;
            var studentSecondChoice = document.getElementById("stuSecondChoice").value;
            var pattern = /^([0-9]+)$/;
            if (studentID == "" || studentID == null) {
                alert("学号不能为空");
                return false;
            } else if (studentName == "" || studentName == null) {
                alert("姓名不能为空");
                return false;
            } else if (!pattern.test(studentID)){
                alert("学号只能为数字");
                return false;
            }else if (studentAcademy == "" || studentAcademy == null){
                alert("学院不能为空");
                return false;
            }else if (studentMajor == "" || studentMajor == null){
                alert("专业不能为空");
                return false;
            }else if (studentPhone == "" || studentPhone == null){
                alert("手机号不能为空");
                return false;
            }else if (!(/^1[3|4|5|7|8]\d{9}$/.test(studentPhone))){
                alert("手机号输入有误");
                return false;
            }else if (studentFirstChoice == "" || studentFirstChoice == null || studentFirstChoice == "18"){
                alert("第一志愿不能为空");
                return false;
            }else if (studentSecondChoice == "" || studentSecondChoice == null || studentSecondChoice == "18"){
                alert("第二志愿不能为空");
                return false;
            }else {
                return true;
            }
        }
    </script>
</head>
<body>
<div class="container clearfix">
    <div class="sidebar-wrap">
        <div class="sidebar-title">
            <h1>菜单</h1>
        </div>
        <div class="sidebar-content">
            <ul class="sidebar-list">
                <li>
                    <a href="#"><i class="icon-font">&#xe003;</i>常用操作</a>
                    <ul class="sub-menu">
                        <li><a href="workList.action"><i class="icon-font">&#xe008;</i>工作计划</a></li>
                        <li><a href="requestList.action"><i class="icon-font">&#xe005;</i>学生申请</a></li>
                        <li><a href="examineList.action"><i class="icon-font">&#xe006;</i>考核记录</a></li>
                        <li><a href="logoutAction.action"><i class="icon-font">&#xe017;</i>退出登录</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="/workPlan/workPlanList.jsp">首页</a>
                <span class="crumb-step">&gt;</span><a class="crumb-name" href="requestList.action">学生申请</a>
                <span class="crumb-step">&gt;</span><span>新增申请</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <struts:form action="studentRequestAddAction" onsubmit="return addRequest();" method="GET">
                    <table class="insert-tab" width="100%">
                        <tbody>
                        <tr>
                            <th><i class="require-red">*</i>学号：</th>
                            <td>
                                <input class="common-text required" id="stuID" name="student_id" size="50" value="" type="text">
                            </td>
                        </tr>
                        <tr>
                            <th><i class="require-red">*</i>姓名：</th>
                            <td>
                                <input class="common-text required" id="stuName" name="student_name" size="50" value="" type="text">
                            </td>
                        </tr>
                        <tr>
                            <th><i class="require-red">*</i>学院：</th>
                            <td>
                                <input class="common-text required" id="stuAcademy" name="student_academy" size="50" value="" type="text">
                            </td>
                        </tr>
                        <tr>
                            <th><i class="require-red">*</i>专业：</th>
                            <td>
                                <input class="common-text required" id="stuMajor" name="student_major" size="50" value="" type="text">
                            </td>
                        </tr>
                        <tr>
                            <th><i class="require-red">*</i>手机：</th>
                            <td>
                                <input class="common-text required" id="stuPhone" name="student_phone" size="50" value="" type="text">
                            </td>
                        </tr>
                        <tr>
                            <th><i class="require-red">*</i>第一志愿：</th>
                            <td>
                                <select name="student_first_choice" id="stuFirstChoice"  class="required">
                                    <option value="18">请选择</option>
                                    <option value="第一食堂">第一食堂</option>
                                    <option value="第二食堂">第二食堂</option>
                                    <option value="第一实验室">第一实验室</option>
                                    <option value="第二实验室">第二实验室</option>
                                    <option value="图书馆前台服务处">图书馆前台服务处</option>
                                    <option value="图书馆自由阅览室">图书馆自由阅览室</option>
                                    <option value="科技馆">科技馆</option>
                                    <option value="学生活动中心">学生活动中心</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <th><i class="require-red">*</i>第二志愿：</th>
                            <td>
                                <select name="student_second_choice" id="stuSecondChoice" class="required">
                                    <option value="18">请选择</option>
                                    <option value="第一食堂">第一食堂</option>
                                    <option value="第二食堂">第二食堂</option>
                                    <option value="第一实验室">第一实验室</option>
                                    <option value="第二实验室">第二实验室</option>
                                    <option value="图书馆前台服务处">图书馆前台服务处</option>
                                    <option value="图书馆自由阅览室">图书馆自由阅览室</option>
                                    <option value="科技馆">科技馆</option>
                                    <option value="学生活动中心">学生活动中心</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <th></th>
                            <td>
                                <input class="btn btn-primary btn6 mr10" value="提交" type="submit">
                                <input class="btn btn6" onclick="history.go(-1)" value="返回" type="button">
                            </td>
                        </tr>
                        </tbody></table>
                </struts:form>
            </div>
        </div>

    </div>
    <!--/main-->
</div>
</body>
</html>
