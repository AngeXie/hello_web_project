package serivce;

import dao.CommentDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class CommentServlet extends HttpServlet{

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
        HttpSession session = request.getSession();
        //UserEntity curUser = (UserEntity) session.getAttribute("user");
        //String usr_id = curUser.getId();
        String usr_id = "1819d8832000";
        String comment_detial = request.getParameter("comment_content");
        String post_id = request.getParameter("post_id");
        try {
            (new CommentDao()).addComment_byUserIdPostsId(comment_detial, post_id, usr_id);
        } catch (SQLException e) {
            System.out.println("fail to add comment\n"+e.getMessage());
            System.out.println("comment_detail : "+comment_detial);
            System.out.println("post_id : "+post_id);
        }
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
