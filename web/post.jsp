<%@ page import="dao.UserDao" %>
<%@ page import="entity.UserEntity" %>
<%@ page import="dao.PostDao" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="entity.PostEntity" %>
<%@ page import="dao.ResourceDao" %>
<%@ page import="entity.ResourceEntity" %>
<%@ page import="entity.CommentEntity" %>
<%@ page import="dao.CommentDao" %>
<%--
  Created by IntelliJ IDEA.
  UserEntity: ange
  Date: 2018/5/20
  Time: 21:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String postid = request.getParameter("postid");
    PostEntity curPost =(new PostDao()).getPost_byid(postid);
    ArrayList<CommentEntity> comments = (new CommentDao()).getComment_byPostId(postid);
    UserEntity post_user = (new UserDao()).getUserInfoByID(curPost.getUser_id());
%>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>post</title>
    <meta name="description" content="">
    <meta name="keywords" content="">
    <link rel="stylesheet" type="text/css" href="font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="bootstrap-4.1.1-dist/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/post_style.css">
    <script src="bootstrap-4.1.1-dist/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
    <script type="text/javascript" src="wangEditor/wangEditor.js"></script>
    <script type="text/javascript">
        function commentToUser(name) {
                alert(name);
        }
    </script>
</head>

<body>
<div class="container-fluid header">
    <div class="row">
        <div class="col-md-1"><a href="#" name="header"></a></div>
        <div class="col-md-1"><span>hello web</span></div>
        <div class="col-md-6 search">
            <form action="#" method="post" class="form-horizontal" role="form">
                <div class="row">
                    <div class="col-md-10">
                        <input type="text" class="form-control">
                    </div>
                    <div class="col-md-2"><i class="fa fa-search fa-lg" aria-hidden="true"></i></div>
                </div>
            </form>
        </div>
        <div class="col-md-2"><a href="login.html" class="btn btn-danger btn-sm">SIGN IN</a></div>
    </div>
</div>
<div class="container-fluid title_r">
    <div class="row">
        <div class="col-md-1"></div>
        <div class="col-md-7">
            <div class="row title">
                <div class="col-md-2 post-usr-info">
                    <div class="row usr-head">
                        <img src="<%=post_user.getHead()%>" alt="" />
                    </div>
                    <div class="row">
                        <span><%=post_user.getName()%></span>
                    </div>
                    <div class="row">
                        <button class="btn btn-danger btn-sm">+关注</button>
                    </div>
                </div>
                <div class="col-md-10">
                    <h3><%=curPost.getTitle()%></h3>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="container-fluid detail">
    <div class="row detail_r">
        <div class="col-md-1"></div>
        <div class="col-md-7 post">
            <div class="row post-detail">
                <span><%=curPost.getDetail()%></span>
            </div>
            <div class="row post-btn">
                <div class="col-md-7"></div>
                <div class="col-md-5">
                    <span class="post_date"><%=curPost.getLast_date().toString()%></span>
                    <a href="#" title="点赞"><i class="fa fa-thumbs-o-up" aria-hidden="true">(<%=curPost.getLike_number()%>)</i></a>
                    <a href="#" title="收藏"><i class="fa fa-heart" aria-hidden="true">(<%=curPost.getFollow_number()%>)</i></a>
                    <a href="#" title="举报"><i class="fa fa-hand-paper-o" aria-hidden="true"></i></a>
                </div>
            </div>
            <div class="row comments" id="comments">
                <div class="col-md-12">
                    <%
                        UserEntity comment_user;
                        for (int i = 0; i< comments.size(); i++){
                            comment_user = (new UserDao()).getUserInfoByID(comments.get(i).getUser_id());
                    %>
                    <div class="row comment_item">
                        <div class="col-md-12 comment-detail">
                            <div class="row">
                                <div class="col-md-2 comment-user-info">
                                    <div class="row comment-usr-head">
                                        <img src="<%=comment_user.getHead()%>" alt="">
                                    </div>
                                    <div class="row comment-usr-name">
                                        <span><%=comment_user.getName()%></span>
                                    </div>
                                    <div class="row">
                                        <button class="btn btn-danger btn-sm">+关注</button>
                                    </div>
                                </div>
                                <div class="col-md-10">
                                    <div class="row comment-content">
                                        <div class="col-md-12">
                                            <div><%=comments.get(i).getDetail()%></div>
                                        </div>
                                    </div>
                                    <div class="row comment-btns">
                                        <div class="col-md-7"></div>
                                        <div class="col-md-5">
                                            <span class="comment-date"><%=comments.get(i).getDate().toString()%></span>
                                            <a href="#comment-input" title="回复" onclick="commentToUser('<%=comment_user.getName()%>')">
                                                <i class="fa fa-commenting-o" aria-hidden="true"></i>
                                            </a>
                                            <a href="#" title="点赞" class="comment-btns-like">
                                                <i class="fa fa-heart" aria-hidden="true">(<%=comments.get(i).getLike_num()%>)</i>
                                            </a>
                                            <a href="#" title="举报">
                                                <i class="fa fa-hand-paper-o" aria-hidden="true"></i>
                                            </a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <%
                        }
                    %>
                </div>
            </div>
            <div class="row comment-pages">
                <nav>
                    <ul class="pagination">
                        <li class="page-item">
                            <a class="page-link" href="#">
                                <i class="fa fa-arrow-left" aria-hidden="true"></i>
                            </a>
                        </li>
                        <li class="page-item"><a class="page-link" href="#">1</a></li>
                        <li class="page-item"><a class="page-link" href="#">2</a></li>
                        <li class="page-item disabled"><a class="page-link" href="#">...</a></li>
                        <li class="page-item"><a class="page-link" href="#">8</a></li>
                        <li class="page-item">
                            <a class="page-link" href="#">
                                <i class="fa fa-arrow-right" aria-hidden="true"></i>
                            </a>
                        </li>
                    </ul>
                </nav>
            </div>
            <div class="row comment-input">
                <a href="#" name="comment-input"></a>
                <div class="col-md-12 comment-editor">
                    <div id="editor">
                    </div>
                    <button class="btn btn-default" id="CommentBtn">回复</button>
                </div>
            </div>
        </div>
        <div class="col-md-3 rec">
            <div class="rec-content">
                <span>相关帖子：</span>
                <div class="row rec-item">
                    <div class="col-md-9 rec-item-title">
                        <a href="#" class="">SEO站内优化的重点是什么?</a>
                    </div>
                </div>
                <hr/>
                <div class="row rec-item">
                    <div class="col-md-9 rec-item-title">
                        <a href="#" class="">SEO站内优化的重点是什么?</a>
                    </div>
                </div>
                <hr/>
                <div class="row rec-item">
                    <div class="col-md-9 rec-item-title">
                        <a href="#" class="">SEO站内优化的重点是什么?</a>
                    </div>
                </div>
                <hr/>
                <div class="row rec-item">
                    <div class="col-md-9 rec-item-title">
                        <a href="#" class="">SEO站内优化的重点是什么?</a>
                    </div>
                </div>
                <hr/>
                <div class="row rec-item">
                    <div class="col-md-9 rec-item-title">
                        <a href="#" class="">SEO站内优化的重点是什么?</a>
                    </div>
                </div>
            </div>
            <div class="func-bar">
                <ul class="nav flex-column">
                    <li class="nav-item">
                        <a class="nav-link" href="#comment-input">
                            <i class="fa fa-commenting-o" aria-hidden="true"></i>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="index.jsp">
                            <i class="fa fa-home" aria-hidden="true"></i>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#header">
                            <i class="fa fa-angle-double-up" aria-hidden="true"></i>
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    var E = window.wangEditor
    var editor = new E('#editor')
    editor.customConfig.uploadImgServer = '/hello web/UploadImg';
    editor.create();

    var element_commentBtn = document.getElementById('CommentBtn');
    element_commentBtn.addEventListener('click', function () {
        //alert(editor.txt.html())
        var comment_content = editor.txt.html();
        $.ajax({
            url : "/hello web/commentServlet",
            type : 'post',
            data : {comment_content : comment_content, post_id : <%=postid%>},
            success : function() {
                alert("回复成功！");
                var new_commentItem = $(".comment_item").eq(0).clone(true);
                var cur_commentItem0 = $(".comment_item").eq(0);
                cur_commentItem0.before(new_commentItem);
                cur_commentItem0 = $(".comment_item").eq(0);
                $(".comment-usr-head > img").eq(0).attr("src", "image/usr-head/head-001.jpg");
                $(".comment-usr-name > span").eq(0).text("测试用-用户");
                $(".comment-content > div > div").eq(0).html(comment_content);
                $(".comment-btns-like > i").eq(0).text("(0)");
                editor.txt.html('');
                $('html, body').animate({scrollTop: $('#comments').offset().top}, 1000);
            }
        });
    }, false);

    function commentToUser(name) {
        var info = '@ '+name;
        editor.txt.html('<p style="font-weight: 600; color: #AE592D; text-decoration: underline">'+info+'</p><br/>');
        editor.focus();
    }
</script>
</body>

</html>
