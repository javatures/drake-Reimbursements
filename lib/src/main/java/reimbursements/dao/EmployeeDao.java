package reimbursements.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import reimbursements.model.Employee;

public class EmployeeDao {
    private ArrayList<Employee> employees;

    public EmployeeDao() {
        try {
            Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/reimbursements", "reimbursements", "password");
            ResultSet result = conn.prepareStatement("select * from employees").executeQuery();
            while (result.next()) {
                PreparedStatement types = conn.prepareStatement("select * from employeetypes where id=?");
                types.setInt(1, result.getInt("employeetype"));
                ResultSet set = types.executeQuery();
                employees.add(new Employee(
                    result.getInt("id"),
                    result.getString("firstname"), 
                    result.getString("lastname"), 
                    result.getString("user"), 
                    result.getString("pass"), 
                    set.getString("position")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
