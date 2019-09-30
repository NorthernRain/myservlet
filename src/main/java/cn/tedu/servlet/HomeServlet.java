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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @author LeafDust
 * @create 2019-09-17 14:51
 */
@WebServlet(name = "HomeServlet", urlPatterns = "/HomeServlet")
//显示Home页面
public class HomeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String name = (String) session.getAttribute("username");
        if (name == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }
        //查询首页的文章列表
        ArticleDao articleDao = new ArticleDao();
        String sql = "select a.oId,a.title,a.abstract,a.commentCount,a.viewCount,a.putTop,a.created,a.updated,a.imgName,u.userName from article a join user u on a.authorId=u.oId order by a.putTop desc limit 0,8";
        List<Article> articles = articleDao.getArticlesList(sql);
        //把第一篇文章传递到页面中
        Context context = new Context();
        context.setVariable("first", articles.get(0));
        //THUtils.write("index", response, context);这个只能写一次，写多了就会显示不出来！！！！！！！！！！！！！！！！
        //截取第2-4篇
        context.setVariable("second", articles.subList(1, 4));
        // THUtils.write("index", response, context);
        //5-8篇传到页面
        context.setVariable("normal", articles.subList(4, articles.size()));
        context.setVariable("user",new UserDao().getUserName());
        THUtils.write("index", response, context);
    }
}
