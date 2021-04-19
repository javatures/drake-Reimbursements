package reimbursements;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import reimbursements.dao.EmployeeDao;
import reimbursements.model.Employee;

@WebServlet("/login")
public class Login extends HttpServlet {
    private static final long serialVersionUID = 1;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = req.getParameter("user").toLowerCase();
        String pass = req.getParameter("pass");
        EmployeeDao dao = new EmployeeDao();
        ArrayList<Employee> list = dao.getEmployees();
        System.out.println(list.size());

        for (Employee e : list) {
            if (e.getUser().equals(user)) {
                if (e.getPass().equals(pass)) {
                    resp.getWriter().println(e);
                    return;
                }
                else {
                    resp.sendRedirect("?status=pass");
                    return;
                }
            }
        }
        resp.sendRedirect("?status=user");
    }


}