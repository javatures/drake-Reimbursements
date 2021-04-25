package reimbursements.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import reimbursements.model.Employee;

public class EmployeeDao {
    private ArrayList<Employee> employees = new ArrayList<>();

    public EmployeeDao() {
        try {
            Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/reimbursements", "reimbursements", "password");
            ResultSet result = conn.prepareStatement(
                "select * from employees inner join employeetypes on employees.employeetype=employeetypes.id").executeQuery();
            while (result.next()) {
                employees.add(new Employee(
                    result.getInt("id"),
                    result.getString("firstname"), 
                    result.getString("lastname"), 
                    result.getString("username"), 
                    result.getString("pass"), 
                    result.getString("position")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public Employee getEmployee(int id) {
        for (Employee e : employees) {
            if (e.getId() == id)
                return e;
        }
        return null;
    }

    public void setEmployee(int id, String first, String last, String user, String pass) {
        Employee employee = getEmployee(id);

        employee.setFirstName(first);
        employee.setLastName(last);
        employee.setUser(user);
        employee.setPass(pass);

        try {
            Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/reimbursements", "reimbursements", "password");
            PreparedStatement prep = conn.prepareStatement(
                "update employees set firstname=?, lastname=?, username=?, pass=? where id=?");
            prep.setString(1, first);
            prep.setString(2, last);
            prep.setString(3, user);
            prep.setString(4, pass);
            prep.setInt(5, id);
            prep.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
