package cn.tedu.utils;

import org.apache.commons.dbcp.BasicDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author LeafDust
 * @create 2019-09-16 20:19
 */
public class DBUtils {
    private static BasicDataSource basicDataSource;

    static {
        Properties properties = new Properties();
        InputStream ips = DBUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
        try {
            properties.load(ips);
        } catch (IOException e) {
            e.printStackTrace();
        }
        basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName(properties.getProperty("driver"));
        basicDataSource.setUrl(properties.getProperty("url"));
        basicDataSource.setUsername(properties.getProperty("username"));
        basicDataSource.setPassword(properties.getProperty("password"));
        basicDataSource.setInitialSize(3);
        basicDataSource.setMaxActive(5);
    }

    public static Connection getConn() throws SQLException {
        return basicDataSource.getConnection();
    }
}
