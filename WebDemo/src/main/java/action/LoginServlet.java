package action;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class LoginServlet extends HttpServlet
{
    Connection connection;
    PreparedStatement preparedStatement;
    String sql_add = "insert into user values(?,?)";
    String sql_add_test = "select * from user where username = ?";
    String sql_query = "select * from user where username = ? and password = ?";
    String userNameFromTable;
    String passwordFromTable;
    String mode;
    ResultSet resultSet;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        mode = (String)req.getParameter("mode");
        userNameFromTable = req.getParameter("UserName");
        passwordFromTable = req.getParameter("Password");
        HttpSession session = req.getSession();
        session.setAttribute("LoginStatus","unsuccess");
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
        }catch (Exception e)
        {
            e.printStackTrace();
        }

        if(mode.equals("login"))
        {
            try
            {
                preparedStatement = connection.prepareStatement(sql_query,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                preparedStatement.setString(1,userNameFromTable);
                preparedStatement.setString(2,passwordFromTable);
                resultSet = preparedStatement.executeQuery();

                resultSet.last();
                if(resultSet.getRow() == 1)
                {
                    session.setAttribute("LoginStatus","success");
                    resp.sendRedirect("functionPage.jsp");
                }
                else
                {
                    session.setAttribute("LoginStatus","unsuccess");
                    resp.sendRedirect("errorPage.jsp");
                }

            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            try
            {
                preparedStatement = connection.prepareStatement(sql_add_test,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                preparedStatement.setString(1,userNameFromTable);
                resultSet = preparedStatement.executeQuery();
                resultSet.last();
                if(resultSet.getRow() == 0)
                {
                    preparedStatement = connection.prepareStatement(sql_add,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                    preparedStatement.setString(1,userNameFromTable);
                    preparedStatement.setString(2,passwordFromTable);
                    preparedStatement.execute();
                    resp.sendRedirect("index.jsp");
                }
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        this.doGet(req,resp);
    }
}
