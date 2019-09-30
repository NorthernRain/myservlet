package cn.tedu.servlet;

import cn.tedu.dao.ArticleDao;
import cn.tedu.entity.Article;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author LeafDust
 * @create 2019-09-19 17:23
 */
@WebServlet(name = "PublishActionServlet", urlPatterns = "/PublishActionServlet")
//文章发布
public class PublishActionServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String abs = request.getParameter("abs");
        String content = request.getParameter("content");
        String imgName = request.getParameter("imgName");
        String putTop = request.getParameter("putTop");
        int isTop = putTop == null ? 0 : 1;
        Article article = new Article(0, title, abs, 0, 0, isTop, System.currentTimeMillis(), System.currentTimeMillis(), imgName, null, content);
        new ArticleDao().save(article);
        response.sendRedirect(request.getContextPath() + "/ArticleServlet");
    }
}
