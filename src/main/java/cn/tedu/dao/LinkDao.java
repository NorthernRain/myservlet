package cn.tedu.dao;

import cn.tedu.entity.Link;
import cn.tedu.utils.DBUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author LeafDust
 * @create 2019-09-18 17:26
 */
public class LinkDao {
    public List<Link> findAll() {
        List<Link> links = new ArrayList<>();
        try (Connection connection = DBUtils.getConn()) {
            String sql = "select title,address from link";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String title = resultSet.getString(1);
                String address = resultSet.getString(2);
                links.add(new Link(title, address));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return links;
    }
}
