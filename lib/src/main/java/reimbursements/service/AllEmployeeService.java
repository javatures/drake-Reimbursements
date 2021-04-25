package reimbursements.service;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import reimbursements.dao.EmployeeDao;
import reimbursements.model.Employee;

@WebServlet("/api/allemployees")
public class AllEmployeeService extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EmployeeDao dao = (EmployeeDao) req.getSession().getAttribute("dao");

        resp.setContentType("application/json");

        ArrayList<Employee> list = dao.getEmployees();
        String output = "[\n";
        for (int i = 0; i < list.size()-1; i++) {
            output += list.get(i) + ",\n";
        }
        output += list.get(list.size()-1) + "\n]";

        resp.getWriter().println(output);
    }
}