package serivce;

import dao.UserDao;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

import static java.io.FileDescriptor.out;

public class LoginServlet extends HttpServlet {
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
        String usr_name = request.getParameter("username");
        String usr_pwd = request.getParameter("userpwd");
        User user = (new UserDao()).getUserInfoByName(usr_name);
        String hint_fail = "<script>alert('用户信息错误！请重新输入');window.location='login.jsp';</script>";
        String hint_success = "<script>alert('登陆成功！即将跳转至主页');window.location='index.jsp';</script>";
        if (user == null){
            out.println(hint_fail);
            //response.sendRedirect("login.jsp");
            return;
        }
        if (usr_pwd.equals(user.getPwd())){
            HttpSession session = request.getSession(true);
            session.setAttribute("user", user);
            out.println(hint_success);
            //response.sendRedirect("index.jsp");
        }else {
            out.println(hint_fail);
           //response.sendRedirect("login.jsp");
        }
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
