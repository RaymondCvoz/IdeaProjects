package service;

import dao.DBModify;
import dao.DBQuery;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRegister extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        HttpSession session = req.getSession();
        String userName = (String) session.getAttribute("RegisterUserName");
        String password = (String) session.getAttribute("RegisterUserPassword");
        Map<String,String> equal = new HashMap<>();
        Map<String,String> like = new HashMap<>();
        try
        {
            DBQuery dbQuery = new DBQuery();
            equal.put("name",userName);
            //equal.put("password",password);
            List<Object> result = dbQuery.queryByCondition("user",equal,like,"User");
            if(result.size() > 0)
            {
                session.setAttribute("userExistInfo","用户已存在");
                resp.sendRedirect(req.getServletContext().getContextPath() + "/Account/UserRegister.jsp");
            }
            else
            {
                DBModify dbModify = new DBModify();
                List<String> value = new ArrayList<>();
                value.add("0");
                value.add(userName);
                value.add(password);
                boolean updateResult = dbModify.insert("user",value);
                if(updateResult)
                {
                    session.setAttribute("CurrentLoginUserName",userName);
                    resp.sendRedirect(req.getServletContext().getContextPath() + "/service/FetchProduct");
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        this.doGet(req, resp);
    }
}
