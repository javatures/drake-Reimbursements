package reimbursements;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import reimbursements.dao.EmployeeDao;

@WebServlet("/edit")
public class EditInfo extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EmployeeDao dao = (EmployeeDao) req.getSession().getAttribute("dao");
        String pass = req.getParameter("pass");
        resp.setContentType("text/html");

        if (!pass.equals(dao.getEmployee((int) req.getSession().getAttribute("id")).getPass())) {
            resp.getWriter().println("Error: incorrect password. <a href=\"user.html\">Click here</a> to return to the form.");
            return;
        }
        
        dao.setEmployee((int) req.getSession().getAttribute("id"),
            req.getParameter("firstname"),
            req.getParameter("lastname"),
            req.getParameter("user"),
            req.getParameter("newpass"));
        resp.getWriter().println("Your info has been updated. <a href=\"user.html\">Click here</a> to return to the form.");
    }
}
