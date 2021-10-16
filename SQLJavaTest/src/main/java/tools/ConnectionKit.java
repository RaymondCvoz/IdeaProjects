package tools;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionKit
{
    private boolean ifGetConnectionSuccess;
    private Connection connection;

    public ConnectionKit()
    {
        this.ifGetConnectionSuccess = false;
        this.connection = null;
    }
    public boolean isIfGetConnectionSuccess()
    {
        return ifGetConnectionSuccess;
    }

    public Connection getConnection()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
            this.ifGetConnectionSuccess = true;
        }
        catch (Exception e)
        {
            ifGetConnectionSuccess = false;
            e.printStackTrace();
        }
        return connection;
    }
}
