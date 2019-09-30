package cn.tedu.servlet;

import cn.tedu.dao.ArticleDao;
import cn.tedu.dao.UserDao;
import cn.tedu.entity.Article;
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
 * @create 2019-09-19 14:16
 */
@WebServlet(name = "ArticleShowServlet", urlPatterns = "/ArticleShowServlet")
//实现点击文章标题跳转到对应的浏览页
public class ArticleShowServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.valueOf(request.getParameter("id"));
        System.out.println("文章ID"+id);
        Article article = new ArticleDao().findArticleById(id);
        Context context = new Context();
        context.setVariable("article2", article);
        context.setVariable("user",new UserDao().getUserName());
        THUtils.write("article2", response, context);
    }
}
