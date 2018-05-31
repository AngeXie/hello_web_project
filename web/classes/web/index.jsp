<%@ page import="java.util.ArrayList" %>
<%@ page import="entity.News" %>
<%@ page import="dao.NewsDao" %>
<%@ page import="entity.User" %>
<%@ page import="dao.UserDao" %><%--
  Created by IntelliJ IDEA.
  User: ange
  Date: 2018/5/15
  Time: 15:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  int news_range = 6;;
   int news01 = 0;
   int news02 = 1;
   int news03 = 2;
   int news04 = 3;
   int news05 = 4;
   int news06 = 5;
  ArrayList<News> news = (new NewsDao()).getNews_withRange(news_range);
%>
<%
  int users_range = 10;
  ArrayList<User> users = (new UserDao()).getUsers_withRange(users_range);
%>
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
    <div class="col-md-5"><img src="image/logo1.png" alt="" class="webLogo1" /></div>
    <div class="col-md-1 resource"><a href="resource.jsp" class="btn btn-info btn-sm">resource </a></div>
    <div class="col-md-4 search">
      <form action="" method="post" class="form-horizontal" role="form">
        <div class="row">
          <div class="col-md-10">
            <input type="text" class="form-control">
          </div>
          <div class="col-md-2"><i class="fa fa-search fa-lg" aria-hidden="true"></i></div>
        </div>
      </form>
    </div>
    <%
      if (session.getAttribute("user") == null) {
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
<div class="container-fluid news">
  <div class="row">
    <div class="col-md-4">
      <div class="row">
        <div class="col-md-12 new-item01">
          <span class="new-item-title"><%=news.get(news01).getTitle()%></span>
        </div>
      </div>
      <div class="row">
        <div class="col-md-12 new-item02">
          <span class="new-item-title"><%=news.get(news02).getTitle()%></span>
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
              <a href="#" class=""><h3><%=news.get(news03).getTitle()%></h3></a>
            </div>
          </div>
          <div class="carousel-item">
            <img src="image/news/news2.jpg">
            <div class="carousel-caption">
              <a href="#" class=""><h3><%=news.get(news04).getTitle()%></h3></a>
            </div>
          </div>
          <div class="carousel-item">
            <img src="image/news/news3.jpg">
            <div class="carousel-caption">
              <a href="#" class=""><h3><%=news.get(news05).getTitle()%></h3></a>
            </div>
          </div>
          <div class="carousel-item">
            <img src="image/news/news4.jpg">
            <div class="carousel-caption">
              <a href="#" class=""><h3><%=news.get(news06).getTitle()%></h3></a>
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
    <div class="col-md-<%=session.getAttribute("user") == null ?9:7%> recommened-posts">
      <span>推荐帖子：</span>
      <div class="row rec-post">
        <div class="col-md-12">
          <div class="row rec-post-msg">
            <div class="col-md-1"><img src="image/usr-head/head-001.jpg" alt="" class="rec-post-usrHead"></div>
            <div class="col-md-2 rec-post-usrName"><span>用户名guda</span></div>
            <div class="col-md-4 rec-post-date"><span>2018-4-19 12:30</span></div>
          </div>
          <div class="row rec-post-title">
            <a href="post.jsp"><h4>Sublime Text 3 使用指南</h4></a>
          </div>
          <div class="row rec-post-detail"><span>前言 本文源自实际开发中的需求，核心的要求有几个：1、多个UITableview要支持左右滑动；2、点击Tab也要有UITableview的滑动切换效果；3、每个UITabl...</span></div>
        </div>
      </div>
      <hr class="rec-post-sline">
      <div class="row rec-post">
        <div class="col-md-12">
          <div class="row rec-post-msg">
            <div class="col-md-1"><img src="image/usr-head/head-001.jpg" alt="" class="rec-post-usrHead"></div>
            <div class="col-md-2 rec-post-usrName"><span>用户名guda</span></div>
            <div class="col-md-4 rec-post-date"><span>2018-4-19 12:30</span></div>
          </div>
          <div class="row rec-post-title">
            <a href="#"><h4>Sublime Text 3 使用指南</h4></a>
          </div>
          <div class="row rec-post-detail"><span>前言 本文源自实际开发中的需求，核心的要求有几个：1、多个UITableview要支持左右滑动；2、点击Tab也要有UITableview的滑动切换效果；3、每个UITabl...</span></div>
        </div>
      </div>
      <hr class="rec-post-sline">
      <div class="row rec-post">
        <div class="col-md-12">
          <div class="row rec-post-msg">
            <div class="col-md-1"><img src="image/usr-head/head-001.jpg" alt="" class="rec-post-usrHead"></div>
            <div class="col-md-2 rec-post-usrName"><span>用户名guda</span></div>
            <div class="col-md-4 rec-post-date"><span>2018-4-19 12:30</span></div>
          </div>
          <div class="row rec-post-title">
            <a href="#"><h4>Sublime Text 3 使用指南</h4></a>
          </div>
          <div class="row rec-post-detail"><span>前言 本文源自实际开发中的需求，核心的要求有几个：1、多个UITableview要支持左右滑动；2、点击Tab也要有UITableview的滑动切换效果；3、每个UITabl...</span></div>
        </div>
      </div>
      <hr class="rec-post-sline">
      <div class="row rec-post">
        <div class="col-md-12">
          <div class="row rec-post-msg">
            <div class="col-md-1"><img src="image/usr-head/head-001.jpg" alt="" class="rec-post-usrHead"></div>
            <div class="col-md-2 rec-post-usrName"><span>用户名guda</span></div>
            <div class="col-md-4 rec-post-date"><span>2018-4-19 12:30</span></div>
          </div>
          <div class="row rec-post-title">
            <a href="#"><h4>Sublime Text 3 使用指南</h4></a>
          </div>
          <div class="row rec-post-detail"><span>前言 本文源自实际开发中的需求，核心的要求有几个：1、多个UITableview要支持左右滑动；2、点击Tab也要有UITableview的滑动切换效果；3、每个UITabl...</span></div>
        </div>
      </div>
      <hr class="rec-post-sline">
      <div class="row rec-post">
        <div class="col-md-12">
          <div class="row rec-post-msg">
            <div class="col-md-1"><img src="image/usr-head/head-001.jpg" alt="" class="rec-post-usrHead"></div>
            <div class="col-md-2 rec-post-usrName"><span>用户名guda</span></div>
            <div class="col-md-4 rec-post-date"><span>2018-4-19 12:30</span></div>
          </div>
          <div class="row rec-post-title">
            <a href="#"><h4>Sublime Text 3 使用指南</h4></a>
          </div>
          <div class="row rec-post-detail"><span>前言 本文源自实际开发中的需求，核心的要求有几个：1、多个UITableview要支持左右滑动；2、点击Tab也要有UITableview的滑动切换效果；3、每个UITabl...</span></div>
        </div>
      </div>
      <hr class="rec-post-sline">
      <div class="row rec-post">
        <div class="col-md-12">
          <div class="row rec-post-msg">
            <div class="col-md-1"><img src="image/usr-head/head-001.jpg" alt="" class="rec-post-usrHead"></div>
            <div class="col-md-2 rec-post-usrName"><span>用户名guda</span></div>
            <div class="col-md-4 rec-post-date"><span>2018-4-19 12:30</span></div>
          </div>
          <div class="row rec-post-title">
            <a href="#"><h4>Sublime Text 3 使用指南</h4></a>
          </div>
          <div class="row rec-post-detail"><span>前言 本文源自实际开发中的需求，核心的要求有几个：1、多个UITableview要支持左右滑动；2、点击Tab也要有UITableview的滑动切换效果；3、每个UITabl...</span></div>
        </div>
      </div>
      <hr class="rec-post-sline">
      <div class="row rec-post">
        <div class="col-md-12">
          <div class="row rec-post-msg">
            <div class="col-md-1"><img src="image/usr-head/head-001.jpg" alt="" class="rec-post-usrHead"></div>
            <div class="col-md-2 rec-post-usrName"><span>用户名guda</span></div>
            <div class="col-md-4 rec-post-date"><span>2018-4-19 12:30</span></div>
          </div>
          <div class="row rec-post-title">
            <a href="#"><h4>Sublime Text 3 使用指南</h4></a>
          </div>
          <div class="row rec-post-detail"><span>前言 本文源自实际开发中的需求，核心的要求有几个：1、多个UITableview要支持左右滑动；2、点击Tab也要有UITableview的滑动切换效果；3、每个UITabl...</span></div>
        </div>
      </div>
      <hr class="rec-post-sline">
      <div class="row rec-post">
        <div class="col-md-12">
          <div class="row rec-post-msg">
            <div class="col-md-1"><img src="image/usr-head/head-001.jpg" alt="" class="rec-post-usrHead"></div>
            <div class="col-md-2 rec-post-usrName"><span>用户名guda</span></div>
            <div class="col-md-4 rec-post-date"><span>2018-4-19 12:30</span></div>
          </div>
          <div class="row rec-post-title">
            <a href="#"><h4>Sublime Text 3 使用指南</h4></a>
          </div>
          <div class="row rec-post-detail"><span>前言 本文源自实际开发中的需求，核心的要求有几个：1、多个UITableview要支持左右滑动；2、点击Tab也要有UITableview的滑动切换效果；3、每个UITabl...</span></div>
        </div>
      </div>
      <hr class="rec-post-sline">
      <div class="row rec-post">
        <div class="col-md-12">
          <div class="row rec-post-msg">
            <div class="col-md-1"><img src="image/usr-head/head-001.jpg" alt="" class="rec-post-usrHead"></div>
            <div class="col-md-2 rec-post-usrName"><span>用户名guda</span></div>
            <div class="col-md-4 rec-post-date"><span>2018-4-19 12:30</span></div>
          </div>
          <div class="row rec-post-title">
            <a href="#"><h4>Sublime Text 3 使用指南</h4></a>
          </div>
          <div class="row rec-post-detail"><span>前言 本文源自实际开发中的需求，核心的要求有几个：1、多个UITableview要支持左右滑动；2、点击Tab也要有UITableview的滑动切换效果；3、每个UITabl...</span></div>
        </div>
      </div>
      <hr class="rec-post-sline">
      <div class="row rec-post">
        <div class="col-md-12">
          <div class="row rec-post-msg">
            <div class="col-md-1"><img src="image/usr-head/head-001.jpg" alt="" class="rec-post-usrHead"></div>
            <div class="col-md-2 rec-post-usrName"><span>用户名guda</span></div>
            <div class="col-md-4 rec-post-date"><span>2018-4-19 12:30</span></div>
          </div>
          <div class="row rec-post-title">
            <a href="#"><h4>Sublime Text 3 使用指南</h4></a>
          </div>
          <div class="row rec-post-detail"><span>前言 本文源自实际开发中的需求，核心的要求有几个：1、多个UITableview要支持左右滑动；2、点击Tab也要有UITableview的滑动切换效果；3、每个UITabl...</span></div>
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
        for (int i=0; i<users.size(); i++){
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