package reimbursements.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import reimbursements.dao.EmployeeDao;
import reimbursements.dao.RequestDao;

@WebServlet("/api/requests")
public class RequestService extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String employee = req.getParameter("employee");
        resp.setContentType("application/json");

        if (employee != null) {
            int id = Integer.parseInt(employee);
            RequestDao dao = new RequestDao(id);
            resp.getWriter().println(dao.getJson());
            return;
        }

        String approved = req.getParameter("approved");
        int id = (int) req.getSession().getAttribute("id");
        EmployeeDao edao = (EmployeeDao) req.getSession().getAttribute("dao");
        boolean manager = edao.getEmployee(id).getType().equals("manager");

        if (approved.equals("false")) {
            RequestDao dao;
            if (manager) {
                dao = new RequestDao(false);
            }
            else {
                dao = new RequestDao(id, false);
            }
            resp.getWriter().println(dao.getJson());
            return;
        }

        if (approved.equals("true")) {
            RequestDao dao;
            if (manager) {
                dao = new RequestDao(true);
            }
            else {
                dao = new RequestDao(id, true);
            }
            resp.getWriter().println(dao.getJson());
            return;
        }
    }
}
