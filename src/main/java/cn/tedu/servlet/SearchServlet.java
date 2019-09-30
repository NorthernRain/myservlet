package cn.tedu.servlet;

import cn.tedu.dao.ArticleDao;
import cn.tedu.entity.Article;
import cn.tedu.utils.THUtils;
import org.thymeleaf.context.Context;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author LeafDust
 * @create 2019-09-19 10:41
 */
@WebServlet(name = "SearchServlet", urlPatterns = "/SearchServlet")
//实现文章的查询功能
public class SearchServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取传递过来的参数
        String keyword = request.getParameter("keyword");
        List<Article> articles = new ArticleDao().findArticlesByKeyword(keyword);
        Context context = new Context();
        context.setVariable("articles", articles);
        THUtils.write("list", response, context);
    }
}
