package reimbursements.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RequestDao {
    public RequestDao(String reason, String image, int employeeId) {
        try {
            Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/reimbursements", "reimbursements", "password");
            PreparedStatement prep = conn.prepareStatement("insert into requests (reason, picture, approved, employee)" +
                " values (?, ?, f, ?)");
            prep.setString(1, reason);
            prep.setString(2, image);
            prep.setInt(3, employeeId);
            prep.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
