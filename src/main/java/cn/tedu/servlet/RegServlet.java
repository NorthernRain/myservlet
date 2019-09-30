package cn.tedu.servlet;

import cn.tedu.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author LeafDust
 * @create 2019-09-20 10:48
 */
@WebServlet(name = "RegServlet", urlPatterns = "/RegServlet")
public class RegServlet extends HttpServlet {
    //处理注册业务
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("pwd");
        new UserDao().register(name, email, password);
        response.sendRedirect(request.getContextPath()+"/blog/login.html");
    }
}
