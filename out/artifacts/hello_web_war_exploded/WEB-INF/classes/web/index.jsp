<%@ page import="java.util.ArrayList" %>
<%@ page import="entity.NewsEntity" %>
<%@ page import="dao.NewsDao" %>
<%@ page import="entity.UserEntity" %>
<%@ page import="dao.UserDao" %>
<%@ page import="entity.PostEntity" %>
<%@ page import="dao.PostDao" %>
<%@ page import="serivce.Test" %>
<%@ page import="dao.CommentDao" %>
<%@ page import="entity.CommentEntity" %>
<%--
  Created by IntelliJ IDEA.
  User: ange
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
  //test.test_getFollowedPosts_byUserid("1819d8c52007");
  //test.test_getFollowingUser_byUserId("1819d8832000");
  // test.test_getPosts_byKeyword("html");
  //test.test_getUsers_byKeyword("m");
  //System.out.println(new CommentDao().getCommentCount_byPostId("100000000001"));

%>
<%
  int news_range = 6;;
   int news01 = 0;
   int news02 = 1;
   int news03 = 2;
   int news04 = 3;
   int news05 = 4;
   int news06 = 5;
  ArrayList<NewsEntity> news = (new NewsDao()).getNews_withRange(news_range);
%>
<%
  int users_range = 10;
  ArrayList<UserEntity> users = (new UserDao()).getUsers_withRange(users_range);
%>
<%
  int posts_range = 20;
  ArrayList<PostEntity> posts = (new PostDao()).getPosts_withRange(posts_range);
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
  <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.0.0-beta/css/bootstrap.min.css">
  <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://cdn.bootcss.com/popper.js/1.12.5/umd/popper.min.js"></script>
  <script src="https://cdn.bootcss.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
</head>

<body>
<div class="container-fluid header">
  <div class="row">
    <div class="col-md-5"><img src="image/logo1.png" alt="" class="webLogo1"/></div>
    <div class="col-md-1 resource"><a href="resource.jsp" class="btn btn-info btn-sm">resource</a></div>
    <div class="col-md-4 search">
      <form action="" method="get" class="form-horizontal" role="form">
        <div class="row">
          <div class="col-md-10">
            <input type="text" class="form-control" name="keyword">
          </div>
          <div class="col-md-2 search-submit-btn"><i class="fa fa-search fa-lg" aria-hidden="true" onclick="submit"></i></div>
        </div>
      </form>
    </div>
    <%
      if (session.getAttribute("user") == null) {
    %>
    <div class="col-md-2 signIn-btn">
      <a href="login.jsp" class="btn btn-warning btn-sm">sign in</a>
    </div>
    <%
      }else {
    %>
    <div class="col-md-2 header-user-btn">
      <a href="#" title='用户中心' class="userinfo-btn">
        <i class="fa fa-user-circle-o fa-2x" aria-hidden="true"></i>
      </a>
      <a href="posting.jsp" title="发帖" class="post-btn">
        <i class="fa fa-pencil-square-o fa-2x" aria-hidden="true"></i>
      </a>
    </div>
    <%
      }
    %>
  </div>
</div>
<div class="container-fluid news">
  <div class="row">
    <div class="col-md-4">
      <div class="row">
        <div class="col-md-12 new-item01">
          <span class="new-item-title">戴尔易安信全体销售会师澳门，共启新时代！</span>
        </div>
      </div>
      <div class="row">
        <div class="col-md-12 new-item02">
          <span class="new-item-title">超越 Windows 时代！微软 Build 大会都透露了啥？</span>
        </div>
      </div>
    </div>
    <div class="col-md-8 news-show">
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
            <img src="image/news/news1.jpg">
            <div class="carousel-caption">
              <a href="#" class=""><h3>全媒体数据可视化的时代</h3></a>
            </div>
          </div>
          <div class="carousel-item">
            <img src="image/news/news2.jpg">
            <div class="carousel-caption">
              <a href="#" class=""><h3>HTML5 的新世界</h3></a>
            </div>
          </div>
          <div class="carousel-item">
            <img src="image/news/news3.jpg">
            <div class="carousel-caption">
              <a href="#" class=""><h3>最好用的响应式框架：bootstrap</h3></a>
            </div>
          </div>
          <div class="carousel-item">
            <img src="image/news/news4.jpg">
            <div class="carousel-caption">
              <a href="#" class=""><h3>ajax 从入门到精通</h3></a>
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
    <div class="col-md-<%=session.getAttribute("user") == null ?9:7%> recommened-post">
      <span>推荐帖子：</span>
      <%
        UserEntity user;
        for (int i = 0; i< posts.size()-1; i++){
            user = (new UserDao()).getUserInfoByID(posts.get(i).getUser_id());
      %>
      <div class="row rec-post">
        <div class="col-md-12">
          <div class="row rec-post-msg">
            <div class="col-md-1"><img src="<%=user.getHead()%>" alt="" class="rec-post-usrHead"></div>
            <div class="col-md-2 rec-post-usrName"><span><%=user.getName()%></span></div>
            <div class="col-md-4 rec-post-date"><span><%=posts.get(i).getPub_date().toString()%></span></div>
          </div>
          <div class="row rec-post-title">
            <a href="post.jsp?page=1&postid=<%=posts.get(i).getPost_id()%>"><h4><%=posts.get(i).getTitle()%></h4></a>
          </div>
          <div class="row rec-post-detail">
            <span><%=posts.get(i).getDetail().length() >100 ? posts.get(i).getDetail().substring(0, 99)+"....": posts.get(i).getDetail()%></span></div>
        </div>
      </div>
      <hr class="rec-post-sline">
      <%
        }
      %>
      <div class="row rec-post">
        <div class="col-md-12">
          <div class="row rec-post-msg">
            <div class="col-md-1"><img src="<%=(new UserDao()).getUserInfoByID(posts.get(posts.size()-1).getUser_id()).getHead()%>" alt="" class="rec-post-usrHead"></div>
            <div class="col-md-2 rec-post-usrName"><span><%=(new UserDao()).getUserInfoByID(posts.get(posts.size()-1).getUser_id()).getName()%></span></div>
            <div class="col-md-4 rec-post-date"><span><%=posts.get(posts.size()-1).getPub_date().toString()%></span></div>
          </div>
          <div class="row rec-post-title">
            <a href="post.jsp?postid=<%=posts.get(posts.size()-1).getPost_id()%>"><h4><%=posts.get(posts.size()-1).getTitle()%></h4></a>
          </div>
          <div class="row rec-post-detail">
            <span>
            <%=posts.get(posts.size()-1).getDetail().length() >100 ? posts.get(posts.size()-1).getDetail().substring(0, 99)+"....": posts.get(posts.size()-1).getDetail()%>
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
      if (session.getAttribute("user") != null){
    %>
    <div class="col-md-2 recommened-usrs">
      <span>您可能会喜欢的用户：</span>
      <%
        for (int i = 0; i< users.size(); i++){
      %>
      <div class="row recommened-usr">
        <div class="col-md-4"><img src="<%=users.get(i).getHead()%>" alt="" class="rec-usrHead" title="head"></div>
        <div class="col-md-5 rec-usrName"><span><%=users.get(i).getName()%></span></div>
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
