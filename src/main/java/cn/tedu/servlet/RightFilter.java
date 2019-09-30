package cn.tedu.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author LeafDust
 * @create 2019-09-23 10:34
 */
public class RightFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        HttpServletResponse servletResponse = (HttpServletResponse) response;

        String username = (String) servletRequest.getSession().getAttribute("username");
        if (username == null) {
            System.out.println("你还没有登录！");
            servletResponse.setContentType("text/html;charset=UTF-8");
            servletResponse.getWriter().print("禁止盗链——张帆！！！");
        } else {
            System.out.println("登陆成功！");
            chain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
