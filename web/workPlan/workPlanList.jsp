<%--
  Created by IntelliJ IDEA.
  User: silence
  Date: 16/6/27
  Time: 下午10:09
  工作信息列表
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>工作信息列表</title>
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
                        <li><a href="workPlanList.jsp"><i class="icon-font">&#xe008;</i>工作计划</a></li>
                        <li><a href="/studentReqest/studentRequestList.jsp"><i class="icon-font">&#xe005;</i>学生申请</a></li>
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
            <div class="crumb-list"><i class="icon-font"></i><a href="workPlanList.jsp">首页</a>
                <span class="crumb-step">&gt;</span><span class="crumb-name">工作计划</span></div>
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
                                    <option value="class01">运动健身</option>
                                    <option value="class02">旅游</option>
                                    <option value="class03">文学艺术</option>
                                    <option value="class04">演讲</option>
                                    <option value="class05">经济</option>
                                    <option value="class06">电影</option>
                                    <option value="class07">科技</option>
                                    <option value="class08">美食</option>
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
                        <a href="workPlanAdd.jsp"><i class="icon-font"></i>新增计划</a>
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <tr>
                            <th>地点</th>
                            <th>标题</th>
                            <th>时间(天)</th>
                            <th>人数(人)</th>
                            <th>工时(时/人)</th>
                            <th>工资(元/时)</th>
                            <th>状态</th>
                            <th>操作</th>
                        </tr>
                        <tr>
                            <td>第一食堂</td>  <!--标签ID-->
                            <td>擦桌子</td>
                            <td>10天</td> <!--标签名称-->
                            <td>5</td>
                            <td>20</td>
                            <td>20</td>
                            <td>未分配</td><!-- 未分配的操作显示修改和分配 -->
                            <td>
                                <a class="link-update" href="workPlanModify.jsp">修改</a>
                                <a class="link-update" href="workPlanDistribution.jsp">分配</a>
                            </td>
                        </tr>
                        <tr>
                            <td>科技馆</td>  <!--标签ID-->
                            <td>值班</td>
                            <td>10天</td> <!--标签名称-->
                            <td>5</td>
                            <td>20</td>
                            <td>20</td>
                            <td>已分配</td>
                            <td>
                                <a class="link-update" href="workContract.jsp">合同</a>
                                <a class="link-update" href="workExamine.jsp">考核</a>
                            </td>
                        </tr>
                        <tr>
                            <td>图书馆</td>  <!--标签ID-->
                            <td>搬书</td>
                            <td>10天</td> <!--标签名称-->
                            <td>5</td>
                            <td>20</td>
                            <td>20</td>
                            <td>已结束</td>
                            <td>
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
