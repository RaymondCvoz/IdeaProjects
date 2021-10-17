package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnKit
{
    static final String url = "jdbc:mysql://localhost:3306/storagemanagement";
    static final String username = "root";
    static final String password = "root";
    static final String driver = "com.mysql.jdbc.Driver";

    public Connection getConnection() throws Exception
    {
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url,username,password);
        return connection;
    }
}
