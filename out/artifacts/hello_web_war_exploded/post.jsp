<%@ page import="dao.UserDao" %>
<%@ page import="entity.User" %>
<%@ page import="dao.PostDao" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="entity.Post" %>
<%@ page import="dao.ResourceDao" %>
<%@ page import="entity.Resource" %><%--
  Created by IntelliJ IDEA.
  User: ange
  Date: 2018/5/20
  Time: 21:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>post</title>
</head>
<body>

<%
    PostDao postDao = new PostDao();
    ArrayList<Post> posts = new ArrayList<Post>();
    try {
        posts = postDao.getPosts_byUsrId("user00012345");
    }catch (Exception e){
        System.out.println("exception occur in getPosts");
        System.out.println(e.getMessage());
    }
    if (posts.size() == 0){
        System.out.println("read none data");
    }else {
        int len = posts.size();
        for (int i = 0; i<len; i++){
            Post post = posts.get(i);
%>
<%=post.getDetail()%><br>
<%=post.getFollow_number()%><br>
<%=post.getLast_date().toString()%><br>
<%=post.getLike_number()%><br>
<%=post.getPost_id()%><br>
<%=post.getPub_date()%><br>
<%=post.getTitle()%><br>
<%=post.getUser_id()%><br>
<hr>
<%
        }
    }
%>
</body>
</html>
