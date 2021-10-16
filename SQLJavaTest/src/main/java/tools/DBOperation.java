package tools;

import entity.Products;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBOperation
{

    boolean connectionStatus;
    Connection connection;
    ConnectionKit connectionKit = new ConnectionKit();
    Statement statement;
    ResultSet resultSet;

    boolean connect()
    {
        connection = connectionKit.getConnection();
        if(connection != null)
        {
            connectionStatus = true;
        }
        else
        {
            connectionStatus = false;
        }
        return false;
    }

    public ArrayList<Products> queryProduct(ArrayList<String> keyParms,ArrayList<String> valParms)
    {

        ArrayList<Products> products = new ArrayList<>();
        if (!connectionStatus)
        {
            this.connect();
        }

        String querySql;
        if (keyParms.size() != valParms.size())
        {
            return products;
        }

        if (keyParms.size() == 0)
        {

            querySql = "select * from product";
        } else
        {
            querySql = "select * from product where ";
        }

        for (int i = 0; i < keyParms.size(); i++)
        {
            querySql += keyParms.get(i) + "=" + valParms.get(i);
            if (i < keyParms.size() - 1)
            {
                querySql += " and ";
            }
        }
        try
        {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(querySql);
            while (resultSet.next())
            {
                String id = resultSet.getString(1);
                String name = resultSet.getString(2);
                String value = resultSet.getString(3);
                String time = resultSet.getString(4);

                Products products1 = new Products(id,name,value,time);
                products.add(products1);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return products;
    }
}
