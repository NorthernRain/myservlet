package cn.tedu.servlet;

import cn.tedu.utils.THUtils;
import org.thymeleaf.context.Context;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author LeafDust
 * @create 2019-09-19 16:51
 */
@WebServlet(name = "PublishServlet", urlPatterns = "/PublishServlet")
//显示文章发布页面
public class PublishServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        THUtils.write("send", response, new Context());
    }
}
