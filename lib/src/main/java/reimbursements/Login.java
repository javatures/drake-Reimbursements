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

        boolean found = false;
        for (Employee e : list) {
            if (e.getUser().equals(user) && e.getPass().equals(pass))
                found = true;
                resp.getWriter().println(e);
        }
        if (!found)
        resp.sendRedirect("");
    }


}