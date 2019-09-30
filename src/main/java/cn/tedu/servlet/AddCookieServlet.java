package cn.tedu.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @author LeafDust
 * @create 2019-09-20 15:14
 */
@WebServlet(name = "AddCookieServlet", urlPatterns = "/AddCookieServlet")
public class AddCookieServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //由于cookie在Http协议中规定 存在于协议头中进行传输，需要对中文和特殊字符进行URL编码
        Cookie cookie = new Cookie("m1", URLEncoder.encode("Hello World", "UTF-8"));
        Cookie cookie1 = new Cookie("m2", URLEncoder.encode("你好世界！", "UTF-8"));
        //设置保存时间，如果不写则保存在浏览器的内存中。浏览器关闭时清除，如果是设置了时间则保存到磁盘中时间到了之后删除，如果设置时间为0则立即删除。
        cookie1.setMaxAge(60 * 60 * 24 * 30);//保存一个月
        //通过response对象将cookie下发到浏览器(客户端)
        response.addCookie(cookie);
        response.addCookie(cookie1);
        //显示回馈信息
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print("OK");
    }
}
