<%--
  Created by IntelliJ IDEA.
  User: silence
  Date: 16/6/27
  Time: 下午9:52
  学生申请列表页面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生申请列表</title>
    <link rel="stylesheet" type="text/css" href="../css/common.css"/>
    <link rel="stylesheet" type="text/css" href="../css/main.css"/>
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
                        <li><a href="/workPlan/workPlanList.jsp"><i class="icon-font">&#xe008;</i>工作计划</a></li>
                        <li><a href="studentRequestList.jsp"><i class="icon-font">&#xe005;</i>学生申请</a></li>
                        <li><a href="/examine/examineList.jsp"><i class="icon-font">&#xe006;</i>考核记录</a></li>
                        <li><a href=""><i class="icon-font">&#xe017;</i>退出登录</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="/workPlan/workPlanList.jsp">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">学生申请</span></div>
        </div>
        <div class="search-wrap">
            <div class="search-content">
                <form action="#" method="post">
                    <table class="search-tab">
                        <tr>
                            <th width="120">选择分类:</th>
                            <td>
                                <select name="search-sort" id="">
                                    <option value="class00">全部</option>
                                </select>
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
        <div class="result-wrap">
            <form name="myform" id="myform" method="post">
                <div class="result-title">
                    <div class="result-list">
                        <a href="studentRequestAdd.jsp"><i class="icon-font"></i>新增申请</a>
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <tr>
                            <th>学号</th>
                            <th>姓名</th>
                            <th>联系方式</th>
                            <th>第一志愿</th>
                            <th>第二志愿</th>
                            <th>学院</th>
                            <th>专业</th>
                            <th>状态</th>
                            <th>操作</th>
                        </tr>
                        <tr>
                            <td>01</td>  <!--标签ID-->
                            <td>学霸</td> <!--标签名称-->
                            <td>1383838438</td>
                            <td>第一食堂</td> <!--标签名称-->
                            <td>第二食堂</td> <!--标签名称-->
                            <td>计算机</td> <!--标签名称-->
                            <td>软工</td> <!--标签名称-->
                            <td>空闲</td> <!--标签名称-->
                            <td>
                                <a class="link-update" href="studentRequestModify.jsp">修改</a>
                                <a class="link-del" href="#">删除</a>
                            </td>
                        </tr>
                        <tr>
                            <td>08</td>  <!--标签ID-->
                            <td>科技</td> <!--标签名称-->
                            <td>科学究竟是什么</td>
                            <td>第一食堂</td> <!--标签名称-->
                            <td>第二食堂</td> <!--标签名称-->
                            <td>计算机</td> <!--标签名称-->
                            <td>软工</td> <!--标签名称-->
                            <td>工作</td> <!--标签名称-->
                            <td>
                                <a class="link-update" href="studentRequestModify.jsp">修改</a>
                                <a class="link-del" href="#">删除</a>
                            </td>
                        </tr>
                    </table>
                </div>
            </form>
        </div>
    </div>
    <!--/main-->
</div>
</body>
</html>
