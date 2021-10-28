package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Dispatch extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        HttpSession session = req.getSession();
        String dispatchType = req.getParameter("dispatchType");
        if(dispatchType.equals("login"))
        {
            String userName = req.getParameter("username");
            String password = req.getParameter("password");
            session.setAttribute("LoginUserName",userName);
            session.setAttribute("LoginPassword",password);
            resp.sendRedirect(req.getServletContext().getContextPath() + "/service/UserLogin");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        this.doGet(req, resp);
    }
}
