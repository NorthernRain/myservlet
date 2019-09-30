package cn.tedu.dao;

import cn.tedu.entity.Article;
import cn.tedu.utils.DBUtils;
import com.sun.org.apache.bcel.internal.generic.Select;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author LeafDust
 * @create 2019-09-17 15:13
 */
public class ArticleDao {
        //获取Home页及文章列表页文章列表
    /**
     *
     * @param sql 查询的sql语句
     * @return List<Article> articles
     */
    public List<Article> getArticlesList(String sql) {
        List<Article> articles = new ArrayList<>();
        try (Connection connection = DBUtils.getConn()) {
            //获取首页8篇文章
            //String sql = "select a.oId,a.title,a.abstract,a.commentCount,a.viewCount,a.putTop,a.created,a.updated,a.imgName,u.userName from article a join user u on a.authorId=u.oId order by a.putTop desc limit 0,8";
            //获取列表页面的显示文章
            //String sql = "select a.oId,a.title,a.abstract,a.commentCount,a.viewCount,a.putTop,a.created,a.updated,a.imgName,u.userName from article a join user u on a.authorId=u.oId order by a.created desc";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int oId = resultSet.getInt(1);//主键
                String title = resultSet.getString(2);//标题
                String abs = resultSet.getString(3);//标题
                int commentCount = resultSet.getInt(4);//评论数量
                int viewCount = resultSet.getInt(5);//浏览数量
                int putTop = resultSet.getInt(6);//是否置顶
                long created = resultSet.getLong(7);//创建时间戳
                long updated = resultSet.getLong(8);//修改时间戳
                String imgName = resultSet.getString(9);//图片名字
                String userName = resultSet.getString(10);//用户名
                Article article = new Article(oId, title, abs, commentCount, viewCount, putTop, created, updated, imgName, userName);
                article.setTags(new TagDao().getTagsByArticleId(oId));
                articles.add(article);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return articles;
    }
    //实现搜索功能
    public List<Article> findArticlesByKeyword(String keyword) {
        List<Article> articles = new ArrayList<>();
        try (Connection connection = DBUtils.getConn()) {
            String sql = "select a.oId,a.title,a.abstract,a.commentCount,a.viewCount,a.putTop,a.created,a.updated,a.imgName,u.userName from article a join user u on a.authorId=u.oId where a.title like ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "%" + keyword + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int oId = resultSet.getInt(1);//主键
                String title = resultSet.getString(2);//标题
                String abs = resultSet.getString(3);//标题
                int commentCount = resultSet.getInt(4);//评论数量
                int viewCount = resultSet.getInt(5);//浏览数量
                int putTop = resultSet.getInt(6);//是否置顶
                long created = resultSet.getLong(7);//创建时间戳
                long updated = resultSet.getLong(8);//修改时间戳
                String imgName = resultSet.getString(9);//图片名字
                String userName = resultSet.getString(10);//用户名
                Article article = new Article(oId, title, abs, commentCount, viewCount, putTop, created, updated, imgName, userName);
                article.setTags(new TagDao().getTagsByArticleId(oId));
                articles.add(article);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return articles;
    }

    //实现文章标题点击跳转浏览
    public Article findArticleById(int id) {
        Article article = null;
        try (Connection connection = DBUtils.getConn()) {
            String sql = "select a.oId,a.title,a.abstract,a.commentCount,a.viewCount,a.putTop,a.created,a.updated,a.imgName,u.userName,a.content from article a join user u on a.authorId=u.oId where a.oId=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int oId = resultSet.getInt(1);//主键
                String title = resultSet.getString(2);//标题
                String abs = resultSet.getString(3);//标题
                int commentCount = resultSet.getInt(4);//评论数量
                int viewCount = resultSet.getInt(5);//浏览数量
                int putTop = resultSet.getInt(6);//是否置顶
                long created = resultSet.getLong(7);//创建时间戳
                long updated = resultSet.getLong(8);//修改时间戳
                String imgName = resultSet.getString(9);//图片名字
                String userName = resultSet.getString(10);//用户名
                String content = resultSet.getString(11);//用户名
                article = new Article(oId, title, abs, commentCount, viewCount, putTop, created, updated, imgName, userName, content);
                article.setTags(new TagDao().getTagsByArticleId(oId));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return article;
    }

    //实现发布文章的功能
    public void save(Article article) {
        try (Connection connection = DBUtils.getConn()) {
            String sql = "insert into article values(NULL ,?,?,1,0,0,?,1,1,?,?,?,?,1,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, article.getTitle());
            preparedStatement.setString(2, article.getAbs());
            preparedStatement.setString(3, article.getContent());
            preparedStatement.setInt(4, article.getPutTop());
            preparedStatement.setLong(5, article.getCreated());
            preparedStatement.setLong(6, article.getUpdated());
            preparedStatement.setDouble(7,(double)((int)(Math.random()*100000)));
            preparedStatement.setString(8, article.getImgName());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
