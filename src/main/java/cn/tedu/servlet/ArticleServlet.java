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
import java.util.List;

/**
 * @author LeafDust
 * @create 2019-09-19 9:06
 */
@WebServlet(name = "ArticleServlet", urlPatterns = "/ArticleServlet")
//实现跳转到文章列表功能
public class ArticleServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sql = "select a.oId,a.title,a.abstract,a.commentCount,a.viewCount,a.putTop,a.created,a.updated,a.imgName,u.userName from article a join user u on a.authorId=u.oId order by a.putTop desc,a.created desc";
        List<Article> articles = new ArticleDao().getArticlesList(sql);
        Context context = new Context();
        context.setVariable("articles", articles);
        context.setVariable("user", new UserDao().getUserName());
        THUtils.write("list", response, context);
    }
}
