package serivce;

import dao.PostDao;
import entity.PostEntity;
import entity.UserEntity;
import util.IDGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class PostingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("gb2312");
        PrintWriter out = response.getWriter();
        PostEntity post = new PostEntity();
        post.setPost_id(request.getParameter("post_id"));
        post.setUser_id(((UserEntity)request.getSession().getAttribute("user")).getId());
        //post.setUser_id("1819d8c52007");
        post.setTitle(request.getParameter("post_title"));
        post.setDetail(request.getParameter("post_content"));
        try {
            new PostDao().addPost(post);
        } catch (SQLException e) {
            System.out.println("fail to add post!");
            System.out.println(e.getMessage());
        }
        System.out.println("post success!");
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
