package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnKit
{
    static final String url = "jdbc:mysql://localhost:3306/product924";
    static final String username = "raymond";
    static final String password = "root";
    static final String driver = "com.mysql.cj.jdbc.Driver";

    public Connection getConnection() throws Exception
    {
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url,username,password);
        return connection;
    }
}
