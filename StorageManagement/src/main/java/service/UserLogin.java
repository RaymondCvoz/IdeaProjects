package service;

import dao.DBQuery;
import entities.UserAccount;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserLogin extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        HttpSession session = req.getSession();
        String userName = (String) session.getAttribute("LoginUserName");
        String password = (String) session.getAttribute("LoginPassword");

        try
        {
            DBQuery dbQuery = new DBQuery();
            Map<String,String> equal = new HashMap<>();
            Map<String,String> like = new HashMap<>();
            equal.put("`name`",userName);
            equal.put("`password`",password);
            List<Object> result = dbQuery.queryByCondition("user",equal,like
                    ,"user");
            if(result.size() == 1)
            {
                resp.sendRedirect(req.getServletContext().getContextPath() + "/Account");
            }
            else
            {
                resp.sendRedirect(req.getServletContext().getContextPath() + "/ErrorPage.jsp");
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        this.doGet(req, resp);
    }
}
