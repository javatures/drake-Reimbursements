package reimbursements.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import reimbursements.dao.RequestDao;

@WebServlet("/approve")
public class ApproveService extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        new RequestDao(id, (int) req.getSession().getAttribute("id"));

        resp.setContentType("text/html");
        resp.getWriter().println(
            "The request has been approved. <a href=\"pending.html\">Click here to return to pending requests.</a>");
    }
}
