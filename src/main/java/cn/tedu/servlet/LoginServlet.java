package cn.tedu.servlet;

import cn.tedu.dao.UserDao;
import cn.tedu.utils.THUtils;
import org.thymeleaf.context.Context;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * @author LeafDust
 * @create 2019-09-20 11:46
 */
@WebServlet(name = "LoginServlet", urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    //处理登录业务
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String password = request.getParameter("pwd");
        //登陆成功跳转到home页面
        if (new UserDao().login(name, password)) {
            //把登陆成功的状态保存到session中
            HttpSession session = request.getSession();
            //把当前登录成功的状态保存奥session中
            session.setAttribute("username", name);
            String rem = request.getParameter("rem");
            if (rem != null) {
                Cookie nameCookie = new Cookie("username", URLEncoder.encode(name, "UTF-8"));
                Cookie passwordCookie = new Cookie("password", URLEncoder.encode(password, "UTF-8"));
                response.addCookie(nameCookie);
                response.addCookie(passwordCookie);
            }
            response.sendRedirect(request.getContextPath() + "/HomeServlet");
        }
        //登录失败重定向到登录页面
        else {
            response.sendRedirect(request.getContextPath() + "/login");
        }
    }

}
