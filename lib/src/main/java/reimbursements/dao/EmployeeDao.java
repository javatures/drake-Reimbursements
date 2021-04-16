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
}
