package cn.tedu.servlet;

import cn.tedu.utils.THUtils;
import org.thymeleaf.context.Context;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.URLDecoder;

/**
 * @author LeafDust
 * @create 2019-09-20 15:51
 */
@WebServlet(name = "ShowLoginServlet", urlPatterns = "/login")
public class ShowLoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //从session中查询是否有保存的用户名，有则说明登录成功过，不需要再次登录，直接显示首页
        HttpSession session = request.getSession();
        String name = (String) session.getAttribute("username");
        if (name != null) {
            //说明登陆成功，直接显示首页
            response.sendRedirect(request.getContextPath() + "/HomeServlet");
            return;
        }
        String username = "";
        String password = "";
        //获取cookie
        Cookie[] cookies = request.getCookies();
        //避免null指针添加异常判断
        if (cookies != null) {
            //遍历
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("username")) {
                    username = URLDecoder.decode(cookie.getValue(),"UTF-8");
                } else if (cookie.getName().equals("password")) {
                    password = URLDecoder.decode(cookie.getValue(),"UTF-8");
                }
            }
        }
        Context context = new Context();
        context.setVariable("username", username);
        context.setVariable("password", password);
        THUtils.write("login", response, context);
    }
}
