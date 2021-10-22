package service;

import dao.DBQuery;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FetchProduct extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        HttpSession session = req.getSession();
        List<Object> result = new ArrayList<>();
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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        this.doGet(req, resp);
    }
}
