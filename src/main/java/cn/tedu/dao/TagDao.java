package cn.tedu.dao;

import cn.tedu.entity.Tag;
import cn.tedu.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author LeafDust
 * @create 2019-09-17 16:32
 */
public class TagDao {
    public List<Tag> getTagsByArticleId(int articleId) {
        List<Tag> tags = new ArrayList<>();
        try (Connection connection = DBUtils.getConn()) {
            String sql = "select t.* from tag t join tag_article ta on t.oId=ta.tag_oId where ta.article_oId=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, articleId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int oId = resultSet.getInt(1);
                int referenceCount = resultSet.getInt(3);//关联文章数量
                String title = resultSet.getString(4);//标签标题
                tags.add(new Tag(oId, referenceCount, title));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tags;
    }

  /*  public static void main(String[] args) {
        List<Tag> tags=new TagDao().getTagsByArticleId(9);
        for (Tag tag : tags) {
            System.out.println(tag.getReferenceCount());
        }
    }*/
}
