<%@ page import="util.IDGenerator" %><%--
  Created by IntelliJ IDEA.
  User: ange
  Date: 2018/6/21
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>posting</title>
    <meta name="description" content="">
    <meta name="keywords" content="">
    <link rel="stylesheet" type="text/css" href="font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="bootstrap-4.1.1-dist/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/posting_style.css">
    <script src="js/jquery-1.4.2.min.js"></script>
    <script src="bootstrap-4.1.1-dist/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="wangEditor/wangEditor.js"></script>
</head>
<body onload="postTitleGetFocus()">
<div class="container-fluid header">
    <div class="row">
        <div class="col-md-1"><a href="#" name="header"></a></div>
        <div class="col-md-1"><span>hello web</span></div>
        <div class="col-md-6"></div>
        <div class="col-md-1">
            <a href="index.jsp" class="return-index-btn" title="首页">
                <i class="fa fa-home fa-2x" aria-hidden="true"></i>
            </a>
        </div>
        <div class="col-md-2">
            <a href="#" class="user-info-btn" title="用户中心">
                <i class="fa fa-user-circle-o fa-2x" aria-hidden="true"></i>
            </a>
            <span class="user-name">amy</span>
        </div>
    </div>
</div>

<div class="container post">
    <div class="row post-title-row">
        <div class="col-md-1 post-title-hint">
            <span>标题：</span>
        </div>
        <div class="col-md-11 post-title">
            <input type="text" class="post-title-input"/>
        </div>
    </div>

    <div class="row post-content">
        <div class="col-md-12 post-editor" id="editor"></div>
    </div>

    <div class="row post-btn" onmouseover="postBtnMouseOver()" onmouseleave="postBtnMouseLeave()" onclick="post()">
        <i class="fa fa-paper-plane-o" aria-hidden="true"></i>
        <span>发帖</span>
    </div>
</div>

<script type="text/javascript">
    var E = window.wangEditor;
    var editor = new E('#editor');
    editor.create();
    function postTitleGetFocus(){
        $(".post-title-input").focus();
    }
    function postBtnMouseOver(){
        $(".post-btn i").css('color', '#FF692F');
        $(".post-btn span").css('color', '#FF692F');
    }
    function postBtnMouseLeave(){
        $(".post-btn i").css('color', '#A1A1A1');
        $(".post-btn span").css('color', '#A1A1A1');
    }
    function post(){
        var post_title = $(".post-title-input").eq(0).val();
        var post_content = editor.txt.html();
        var post_id = <%="'"+new IDGenerator().generate()+"'"%>;
        $.ajax({
            url : "/hello web/postServlet",
            type : 'post',
            data : {post_title : post_title, post_content : post_content, post_id : post_id},
            success : function() {
                alert("发帖成功！ 即将跳往帖子页面");
                window.location.href = "post.jsp?page=1&postid="+post_id;
            }
        });
    }
</script>
</body>
</html>
