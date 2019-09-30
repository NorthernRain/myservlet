package cn.tedu.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author LeafDust
 * @create 2019-09-23 9:38
 */
public class DemoFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
       System.out.println("start");
       chain.doFilter(request, response);
        System.out.println("end");
    }

    @Override
    public void destroy() {

    }
}
