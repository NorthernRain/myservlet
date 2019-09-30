package cn.tedu.dao;

import cn.tedu.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author LeafDust
 * @create 2019-09-20 10:52
 * 用户数据操作
 */
public class UserDao {
    //实现注册功能
    private static String username;
    /**
     * @param name     用户名
     * @param email    用户邮箱
     * @param password 用户密码
     */
    public void register(String name, String email, String password) {
        try (Connection connection = DBUtils.getConn()) {
            String sql = "insert into user values(null,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, password);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //实现登录功能

    /**
     * @param name     用户名
     * @param password 用户密码
     * @return boolean 登录成功返回true，失败返回false
     */
    public boolean login(String name, String password) {
        try (Connection connection = DBUtils.getConn()) {
            String sql = "select userName,password from user where userName=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                username=resultSet.getString(1);
                String pwd = resultSet.getString(2);
                return pwd.equals(password);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public String getUserName() {
        return username;
    }
}
