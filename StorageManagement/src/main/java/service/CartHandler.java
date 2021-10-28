package service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CartHandler extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        req.setCharacterEncoding("UTF-8");
        String operation = req.getParameter("req");
        HttpSession session = req.getSession();


        Map<String,Integer> cartDetails = (HashMap<String, Integer>) session.getAttribute("CartDetails");
        Map<String,String> cartDetailsName = (HashMap<String, String>) session.getAttribute("CartDetailsName");

        if(cartDetails == null)
        {
            Map<String,Integer> newCartDetails = new HashMap<>();
            Map<String,String> newCartDetailsName = new HashMap<>();
            cartDetails = newCartDetails;
            cartDetailsName = newCartDetailsName;
        }

        if(operation.equals("add"))
        {
            String pid = req.getParameter("ProductId");
            String pname = req.getParameter("ProductName");

            if(cartDetails.get(pid) == null)
            {
                cartDetails.put(pid,1);
                cartDetailsName.put(pid,pname);
            }
            else
            {
                Integer tmp = cartDetails.get(pid);
                cartDetails.put(pid,++tmp);
            }
            session.setAttribute("CartDetails",cartDetails);
            session.setAttribute("CartDetailsName",cartDetailsName);

            resp.sendRedirect(req.getServletContext().getContextPath() + "/Product/ProductGallery.jsp");
        }
        else
        {
            String pid = req.getParameter("ProductId");
            if(cartDetails.get(pid) != null)
            {
                Integer tmp = cartDetails.get(pid);
                if(tmp > 0)
                {
                    cartDetails.put(pid,--tmp);
                }
                else
                {
                    cartDetails.remove(pid);
                    cartDetailsName.remove(pid);
                }
            }
            session.setAttribute("CartDetails",cartDetails);
            session.setAttribute("CartDetailsName",cartDetailsName);
            resp.sendRedirect(req.getServletContext().getContextPath() + "/Product/Cart.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        this.doGet(req, resp);
    }
}
