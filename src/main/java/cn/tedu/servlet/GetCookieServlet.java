package cn.tedu.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;

/**
 * @author LeafDust
 * @create 2019-09-20 15:26
 */
@WebServlet(name = "GetCookieServlet", urlPatterns = "/GetCookieServlet")
public class GetCookieServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取cookie
        Cookie[] cookies = request.getCookies();
        //避免null指针添加异常判断
        if (cookies != null) {
            //遍历
            for (Cookie cookie : cookies) {
                //取出cookie中的键值
                System.out.println(cookie.getName() + ":" + URLDecoder.decode(cookie.getValue(), "UTF-8"));
            }
        }
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print("OK");
    }
}
