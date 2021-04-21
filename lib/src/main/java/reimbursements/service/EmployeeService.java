package reimbursements.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import reimbursements.dao.EmployeeDao;

@WebServlet("/api/employee")
public class EmployeeService extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = (int) req.getSession().getAttribute("id");

        EmployeeDao dao = (EmployeeDao) req.getSession().getAttribute("dao");

        resp.setContentType("application/json");
        resp.getWriter().println(dao.getEmployee(id));
    }
}
