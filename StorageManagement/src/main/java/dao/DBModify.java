package dao;
import com.google.protobuf.MapEntry;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLData;
import java.util.List;
import java.util.Map;

public class DBModify
{
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    static Connection connection;
    public DBModify() throws Exception
    {
        ConnKit connKit = new ConnKit();
        this.connection = connKit.getConnection();
    }

    boolean update(String tableName, Map<String,?>equal,Map<String,?>like,Map<String,?>updateValue) throws Exception
    {
        String sql = "UPDATE " + tableName +" SET ";
        for(Map.Entry<String, ?> entry : updateValue.entrySet())
        {
            sql += entry.getKey() + " = '" + entry.getValue() + "', ";
        }
        sql = sql.substring(0,sql.length() - 3);

        if(equal.size() > 0 || like.size() > 0) sql += " WHERE ";

        for(Map.Entry<String,?> entry : equal.entrySet())
        {
            sql += entry.getKey() + " = '" + entry.getValue() + "' and ";
        }
        for(Map.Entry<String,?> entry : like.entrySet())
        {
            sql += entry.getKey() + " like %" + entry.getValue() + "% and ";
        }

        sql = sql.substring(0,sql.length() - 4);

        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.execute();

        return true;
    }

    boolean delete(String tableName,Map<String, ?>equal,Map<String,?> like) throws Exception
    {
        String sql = "DELETE FROM " + tableName + " WHERE ";

        for(Map.Entry<String,?> entry : equal.entrySet())
        {
            sql += entry.getKey() + " = '" + entry.getValue() + "' and ";
        }
        for(Map.Entry<String,?> entry : like.entrySet())
        {
            sql += entry.getKey() + " like %" + entry.getValue() + "% and ";
        }
        sql = sql.substring(0,sql.length() - 4);

        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.execute();

        return true;
    }

    boolean insert(String tableName, List<String> values) throws Exception
    {
        String sql = "INSERT INTO " + tableName + " VALUES(";

        for(String s : values)
        {
            sql += s + ",";
        }
        sql = sql.substring(0,sql.length() - 1);
        sql += ")";

        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.execute();

        return true;
    }
}
