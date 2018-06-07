<%@ page import="java.util.ArrayList" %>
<%@ page import="entity.NewsEntity" %>
<%@ page import="dao.NewsDao" %>
<%@ page import="entity.UserEntity" %>
<%@ page import="dao.UserDao" %>
<%@ page import="entity.PostEntity" %>
<%@ page import="dao.PostDao" %>
<%@ page import="serivce.Test" %>
<%--
  Created by IntelliJ IDEA.
  UserEntity: ange
  Date: 2018/5/15
  Time: 15:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  //for test
  Test test = new Test();
  //test.test_updateUsrName("1819d8c52007", "apache1");
  //test.test_updateUsrPwd("1819d8c52007", "111111");
  //test.test_updateUsrEmail("1819d8c52007", "imageogo1@dhfs.cn");
  //test.test_updatePostFollowNum("000000000001", true);
  //System.out.println(test.test_getArticle_count("1819d8c52007"));
  //System.out.println(test.test_getFollowed_count("1819d8832000"));
  //System.out.println(test.test_getCommentCount_byPostId("100000000001"));
  //System.out.println(test.test_getFollowedCount_byPostId("100000000022"));
  //test.test_getComments_byUsrId("1819d8832000");
%>
<%
  int news_range = 6;;
   int news01 = 0;
   int news02 = 1;
   int news03 = 2;
   int news04 = 3;
   int news05 = 4;
   int news06 = 5;
  ArrayList<NewsEntity> newsEntities = (new NewsDao()).getNews_withRange(news_range);
%>
<%
  int users_range = 10;
  ArrayList<UserEntity> userEntities = (new UserDao()).getUsers_withRange(users_range);
%>
<%
  int posts_range = 20;
  ArrayList<PostEntity> postEntities = (new PostDao()).getPosts_withRange(posts_range);
%>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <title>index</title>
  <meta name="description" content="">
  <meta name="keywords" content="">
  <link rel="stylesheet" type="text/css" href="font-awesome-4.7.0/css/font-awesome.min.css">
  <link rel="stylesheet" type="text/css" href="css/style.css">
  <link rel="stylesheet" href="bootstrap-4.1.1-dist/css/bootstrap.min.css">
  <script src="js/jquery-1.4.2.min.js"></script>
  <script src="https://cdn.bootcss.com/popper.js/1.12.5/umd/popper.min.js"></script>
  <script src="bootstrap-4.1.1-dist/js/bootstrap.min.js"></script>
</head>

<body>
<div class="container-fluid header">
  <div class="row">
    <div class="col-md-5"><img src="image/logo1.png" alt="" class="webLogo1" /></div>
    <div class="col-md-1 resourceEntity"><a href="resourceEntity.jsp" class="btn btn-info btn-sm">resourceEntity </a></div>
    <div class="col-md-4 search">
      <form action="" method="get" class="form-horizontal" role="form">
        <div class="row">
          <div class="col-md-10">
            <input type="text" class="form-control" name="keyword">
          </div>
          <div class="col-md-2"><i class="fa fa-search fa-lg" aria-hidden="true" onclick="submit"></i></div>
        </div>
      </form>
    </div>
    <%
      if (session.getAttribute("userEntity") == null) {
    %>
    <div class="col-md-2 loginBtn"><a href="login.jsp" class="btn btn-warning btn-sm">sign in</a></div>
    <%
      }else {
    %>
    <div class="col-md-2 loginBtn"><a href="#" class="btn btn-warning btn-sm">用户中心</a></div>
    <%
      }
    %>
  </div>
</div>
<div class="container-fluid newsEntities">
  <div class="row">
    <div class="col-md-4">
      <div class="row">
        <div class="col-md-12 new-item01">
          <span class="new-item-title"><%=newsEntities.get(news01).getTitle()%></span>
        </div>
      </div>
      <div class="row">
        <div class="col-md-12 new-item02">
          <span class="new-item-title"><%=newsEntities.get(news02).getTitle()%></span>
        </div>
      </div>
    </div>
    <div class="col-md-8 newsEntities-show">
      <div id="demo" class="carousel slide" data-ride="carousel">
        <!-- 指示符 -->
        <ul class="carousel-indicators">
          <li data-target="#demo" data-slide-to="0" class="active"></li>
          <li data-target="#demo" data-slide-to="1"></li>
          <li data-target="#demo" data-slide-to="2"></li>
          <li data-target="#demo" data-slide-to="2"></li>
        </ul>
        <!-- 轮播图片 -->
        <div class="carousel-inner">
          <div class="carousel-item active">
            <img src="image/newsEntities/news1.jpg">
            <div class="carousel-caption">
              <a href="#" class=""><h3><%=newsEntities.get(news03).getTitle()%></h3></a>
            </div>
          </div>
          <div class="carousel-item">
            <img src="image/newsEntities/news2.jpg">
            <div class="carousel-caption">
              <a href="#" class=""><h3><%=newsEntities.get(news04).getTitle()%></h3></a>
            </div>
          </div>
          <div class="carousel-item">
            <img src="image/newsEntities/news3.jpg">
            <div class="carousel-caption">
              <a href="#" class=""><h3><%=newsEntities.get(news05).getTitle()%></h3></a>
            </div>
          </div>
          <div class="carousel-item">
            <img src="image/newsEntities/news4.jpg">
            <div class="carousel-caption">
              <a href="#" class=""><h3><%=newsEntities.get(news06).getTitle()%></h3></a>
            </div>
          </div>
        </div>
        <!-- 左右切换按钮 -->
        <a class="carousel-control-prev" href="#demo" data-slide="prev">
          <span class="carousel-control-prev-icon"></span>
        </a>
        <a class="carousel-control-next" href="#demo" data-slide="next">
          <span class="carousel-control-next-icon"></span>
        </a>
      </div>
    </div>
  </div>
</div>
<div class="container-fluid recommened-content">
  <div class="row">
    <div class="col-md-1"></div>
    <div class="col-md-<%=session.getAttribute("userEntity") == null ?9:7%> recommened-postEntities">
      <span>推荐帖子：</span>
      <%
        UserEntity userEntity;
        for (int i = 0; i< postEntities.size()-1; i++){
            userEntity = (new UserDao()).getUserInfoByID(postEntities.get(i).getUser_id());
      %>
      <div class="row rec-postEntity">
        <div class="col-md-12">
          <div class="row rec-postEntity-msg">
            <div class="col-md-1"><img src="<%=userEntity.getHead()%>" alt="" class="rec-postEntity-usrHead"></div>
            <div class="col-md-2 rec-postEntity-usrName"><span><%=userEntity.getName()%></span></div>
            <div class="col-md-4 rec-postEntity-date"><span><%=postEntities.get(i).getPub_date().toString()%></span></div>
          </div>
          <div class="row rec-postEntity-title">
            <a href="postEntity.jsp?postid=<%=postEntities.get(i).getPost_id()%>"><h4><%=postEntities.get(i).getTitle()%></h4></a>
          </div>
          <div class="row rec-postEntity-detail">
            <span><%=postEntities.get(i).getDetail().length() >100 ? postEntities.get(i).getDetail().substring(0, 99)+"....": postEntities.get(i).getDetail()%></span></div>
        </div>
      </div>
      <hr class="rec-postEntity-sline">
      <%
        }
      %>
      <div class="row rec-postEntity">
        <div class="col-md-12">
          <div class="row rec-postEntity-msg">
            <div class="col-md-1"><img src="<%=(new UserDao()).getUserInfoByID(postEntities.get(postEntities.size()-1).getUser_id()).getHead()%>" alt="" class="rec-postEntity-usrHead"></div>
            <div class="col-md-2 rec-postEntity-usrName"><span><%=(new UserDao()).getUserInfoByID(postEntities.get(postEntities.size()-1).getUser_id()).getName()%></span></div>
            <div class="col-md-4 rec-postEntity-date"><span><%=postEntities.get(postEntities.size()-1).getPub_date().toString()%></span></div>
          </div>
          <div class="row rec-postEntity-title">
            <a href="postEntity.jsp?postid=<%=postEntities.get(postEntities.size()-1).getPost_id()%>"><h4><%=postEntities.get(postEntities.size()-1).getTitle()%></h4></a>
          </div>
          <div class="row rec-postEntity-detail">
            <span>
            <%=postEntities.get(postEntities.size()-1).getDetail().length() >100 ? postEntities.get(postEntities.size()-1).getDetail().substring(0, 99)+"....": postEntities.get(postEntities.size()-1).getDetail()%>
            </span>
          </div>
        </div>
      </div>
      <div class="row rec-content-load">
        <div class="col-md-5"></div>
        <div class="col-md-1">
          <i class="fa fa-spinner fa-pulse fa-2x fa-fw"></i>
          <span class="sr-only">Loading...</span>
        </div>
      </div>
    </div>
    <div class="col-md-1"></div>
    <%
      if (session.getAttribute("userEntity") != null){
    %>
    <div class="col-md-2 recommened-usrs">
      <span>您可能会喜欢的用户：</span>
      <%
        for (int i = 0; i< userEntities.size(); i++){
      %>
      <div class="row recommened-usr">
        <div class="col-md-4"><img src="<%=userEntities.get(i).getHead()%>" alt="" class="rec-usrHead" title="head"></div>
        <div class="col-md-5 rec-usrName"><span><%=userEntities.get(i).getName()%></span></div>
        <div class="col-md-3 rec-usrFollow">
          <button class="btn btn-danger btn-sm">关注</button>
        </div>
      </div>
      <%
        }
      %>
      </div>
    <%
      }
    %>
    </div>
  </div>
</div>
<div class="container-fluid footer">
  <div class="row">
    <div class="col-md-1"></div>
    <div class="col-md-3">
      <img src="image/web-logo.png" alt="" class="web-logo">
    </div>
    <div class="col-md-2">
      <div class="row"><span>联系我们</span></div>
      <div class="row"><span>collapsett@fox.mail</span></div>
    </div>
    <div class="col-md-2">
      <div class="row"><span>友情链接</span></div>
      <div class="row"><a href="">简书</a></div>
      <div class="row"><a href="">CSDN</a></div>
      <div class="row"><a href="">HTML中国</a></div>
      <div class="row"><a href="">StackOverFlow</a></div>
    </div>
    <div class="col-md-2">
      <div class="row"><span>帮助中心</span></div>
      <div class="row"><a href="">侵权申述</a></div>
    </div>
    <div class="col-md-2">
      <div class="row"><span>合作伙伴</span></div>
    </div>
  </div>
</div>
</body>

</html>
