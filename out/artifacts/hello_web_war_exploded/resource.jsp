<%@ page import="java.util.ArrayList" %>
<%@ page import="entity.ResourceEntity" %>
<%@ page import="dao.ResourceDao" %>
<%@ page import="entity.UserEntity" %>
<%@ page import="dao.UserDao" %>
<%--
  Created by IntelliJ IDEA.
  User: ange
  Date: 2018/5/15
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String keyword = "";
    keyword = request.getParameter("keyword");
    ArrayList<ResourceEntity> resources;
    if (keyword == null || keyword.equals("")){
        int range = 3;
        resources = (new ResourceDao()).getResource_byRange(range);
    }else {
        resources = (new ResourceDao()).getResource_byNameLike(keyword);
    }
    String pageOut = request.getParameter("keyword") == null ? "热门资源：" : "搜索结果";
%>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>resource</title>
    <meta name="description" content="">
    <meta name="keywords" content="">
    <link rel="stylesheet" type="text/css" href="font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.0.0-beta/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/resource_style.css">
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/popper.js/1.12.5/umd/popper.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container-fluid header">
    <div class="row">
        <div class="col-md-8"></div>
        <div class="col-md-1"><a href="index.jsp" class="btn btn-warning btn-sm">首页</a></div>
        <%
            if (session.getAttribute("user") == null) {
        %>
        <div class="col-md-2"><a href="login.jsp" class="btn btn-danger btn-sm">SIGN IN</a></div>
        <%
        }else {
        %>
        <div class="col-md-2"><a href="#" class="btn btn-danger btn-sm">用户中心</a></div>
        <%
            }
        %>
    </div>
</div>

<div class="container search">
    <div class="row">
        <div class="col-md-2"></div>
        <div class="col-md-8">
            <form action="resource.jsp" class="form-horizontal" method="post">
                <div class="row">
                    <div class="col-md-9">
                        <input type="text" name="keyword" class="form-control" placeholder="<%=keyword == null ? "请输入关键字" : keyword%>"/>
                    </div>
                    <div class="col-md-3">
                        <input type="submit" class="form-control searchbtn" value="search" />
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

<div class="container rec-resource">
    <div class="row">
        <div class="col-md-2"></div>
        <div class="col-md-8">
            <div class="row"><span><%=pageOut%></span></div>
            <%
                UserEntity user;
                for (int i = 0; i< resources.size(); i++){
                    user = (new UserDao()).getUserInfoByID(resources.get(i).getUser_id());
            %>
            <div class="row rec-res-item">
                <div class="col-md-12">
                    <div class="row rec-res-msg">
                        <span class="rec-res-item-name">资源名称： <%=resources.get(i).getTitle()%></span>
                        <span class="rec-res-item-poster">贡献者：<%=user.getName()%></span>
                    </div>
                    <div class="row rec-res-desrb">
                        <span><%=resources.get(i).getDetail()%></span>
                    </div>
                    <div class="row rec-res-url">
                        <input type="text" class="form-control" value="<%=resources.get(i).getUrl()%>"/>
                    </div>
                </div>
            </div>
            <hr class="splitline"/>
            <%
                }
            %>
        </div>
    </div>
</div>
</body>
</html>
