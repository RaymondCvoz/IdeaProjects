package service;

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

public class FetchProduct extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        HttpSession session = req.getSession();
        String operation = (String) req.getParameter("operation");
        List<Object> result = new ArrayList<>();
        if(operation.equals("fetchAll"))
        {
            try
            {
                DBQuery dbQuery = new DBQuery();
                result = dbQuery.queryAll("product","Product");
                session.setAttribute("productList",result);
                resp.sendRedirect(req.getServletContext().getContextPath() + "/Product/ProductGallery.jsp");
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else if(operation.equals("fetchByCondition"))
        {
            try
            {
                DBQuery dbQuery = new DBQuery();
                Map<String,String> equal = new HashMap<>();
                Map<String,String> like = new HashMap<>();
                String productName = (String)req.getParameter("productName");
                if(productName != "")
                    like.put("name",productName);
                result = dbQuery.queryByCondition("product",equal,like,"Product");
                session.setAttribute("productList",result);
                resp.sendRedirect(req.getServletContext().getContextPath() + "/Product/ProductGallery.jsp");
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        this.doGet(req, resp);
    }
}
