package dao;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Logger;

public class DBQuery
{
    private List<Object> result;
    private PreparedStatement preparedStatement;
    static Connection connection;
    private ResultSet resultSet;

    public DBQuery() throws Exception
    {
        ConnKit connKit = new ConnKit();
        this.connection = connKit.getConnection();
    }

    public List<Object> queryAll(String tableName, String className) throws Exception
    {
        String sql = "select * from " + tableName;
        return getObjects(className, sql);
    }

    public List<Object> queryByCondition(String tableName, Map<String, ?> equal, Map<String, ?> like, String className) throws Exception
    {
        String sql = "select * from " + tableName;
        if (equal.size() > 0 || like.size() > 0) sql += " where ";
        for (Map.Entry<String, ?> entry : equal.entrySet())
        {
            sql += entry.getKey() + " = " + entry.getValue() + " and ";
        }
        for (Map.Entry<String, ?> entry : like.entrySet())
        {
            sql += entry.getKey() + " like %" + entry.getValue() + "% and ";
        }
        sql = sql.substring(0,sql.length() - 4);
        return getObjects(className, sql);
    }

    private List<Object> getObjects(String className, String sql) throws SQLException, ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, java.lang.reflect.InvocationTargetException
    {
        preparedStatement = connection.prepareStatement(sql);
        System.out.println("sql!:"+ sql);

        resultSet = preparedStatement.executeQuery();
        ResultSetMetaData metaData = resultSet.getMetaData();

        Class<?> adaptive = Class.forName(className);
        Constructor<?> constructor = adaptive.getConstructor();

        Method[] methods = adaptive.getDeclaredMethods();

        while (resultSet.next())
        {
            Object o = constructor.newInstance();
            for (Method currentMethod : methods)
            {
                if (currentMethod.getName().startsWith("set"))
                {
                    for (int i = 1; i <= metaData.getColumnCount(); i++)
                    {
                        if (metaData.getColumnName(i).equals(currentMethod.getName().toLowerCase(Locale.ROOT).substring(3)))
                        {
                            currentMethod.invoke(o, currentMethod.getName());
                        }
                    }
                }
            }
            result.add(o);
        }
        return result;
    }
}
