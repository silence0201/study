<%--
  Created by IntelliJ IDEA.
  User: silence
  Date: 16/6/27
  Time: 下午10:36
  考核记录
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>考核记录</title>
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
                        <li><a href="/studentReqest/studentRequestList.jsp"><i class="icon-font">&#xe005;</i>学生申请</a></li>
                        <li><a href="examineList.jsp"><i class="icon-font">&#xe006;</i>考核记录</a></li>
                        <li><a href=""><i class="icon-font">&#xe017;</i>退出登录</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i>
                <a href="/workPlan/workPlanList.jsp" color="#white">首页</a>
                <span class="crumb-step">&gt;</span><span class="crumb-name">考核记录</span></div>
        </div>
        <div class="search-wrap">
            <div class="search-content">
                <form action="#" method="post">
                    <table class="search-tab">
                        <tr>
                            <th width="120">选择日期:</th>
                            <td>
                                <select name="search-sort" id="">
                                    <option value="">全部</option>
                                    <option value="19">运动健身</option>
                                    <option value="20">旅游</option>
                                    <option value="21">文学艺术</option>
                                    <option value="22">演讲</option>
                                    <option value="23">经济</option>
                                    <option value="24">电影</option>
                                    <option value="25">科技</option>
                                    <option value="26">美食</option>
                                </select>
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
        <div class="result-wrap">
            <form >

                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <tr>
                            <th>学号</th>
                            <th>姓名</th>
                            <th>学院</th>
                            <th>专业</th>
                            <th>第一志愿</th>
                            <th>累计工时（时）</th>
                            <th>第二志愿</th>
                            <th>累计工时（时）</th>
                        </tr>
                        <tr>

                            <td>01</td> <!--标签ID-->
                            <td>学霸</td>
                            <td>计算机</td> <!--购买者用户名-->
                            <td>软工</td> <!--销售者用户名-->
                            <td>科技馆</td> <!--订单时间-->
                            <td>20</td> <!--课程价格-->
                            <td>图书馆</td> <!--订单时间-->
                            <td>20</td>
                        </tr>
                        <tr>
                            <td>01</td> <!--标签ID-->
                            <td>学霸2</td>
                            <td>计算机</td> <!--购买者用户名-->
                            <td>软工</td> <!--销售者用户名-->
                            <td>科技馆</td> <!--订单时间-->
                            <td>20</td> <!--课程价格-->
                            <td>图书馆</td> <!--订单时间-->
                            <td>20</td>
                        </tr>
                    </table>
                    <input class="btn btn-primary btn6 mr10" value="打印" type="submit">
                    <a href="monetary.jsp"><input class="btn btn-primary btn6 mr10" value="酬金结算" type="button"></a>
                </div>
            </form>
        </div>
    </div>
    <!--/main-->
</div>
</body>
</html>
