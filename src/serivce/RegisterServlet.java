package serivce;

import dao.UserDao;
import entity.User;
import util.IDGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class RegisterServlet extends HttpServlet {
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
        User user = new User();
        user.setId((new IDGenerator()).generate());
        user.setEmail(request.getParameter("useremail"));
        user.setHead(User.DEFAULT_HEAD);
        user.setStatus(User.STATUS_NORMAL);
        user.setPwd(request.getParameter("userpwd"));
        user.setName(request.getParameter("username"));
        UserDao userDao = new UserDao();
        String reg_fail = "<script>alert('很抱歉注册失败，您可以尝试更改信息后重试');window.location='register.jsp';</script>";
        String reg_success = "<script>alert('注册成功，当前为已登录状态，即将为您跳转至主页面');window.location='index.jsp';</script>";
        try {
            userDao.addUser(user);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            out.println(reg_fail);
            return;
        }
        HttpSession session = request.getSession(true);
        session.setAttribute("user", user);
        out.println(reg_success);
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
