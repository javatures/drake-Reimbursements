package reimbursements.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RequestDao {
    private String json;

    public RequestDao(String reason, String image, int employeeId) {
        try {
            Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/reimbursements", "reimbursements", "password");
            PreparedStatement prep = conn.prepareStatement("insert into requests (reason, picture, approved, employee)" +
                " values (?, ?, ?, ?)");
            prep.setString(1, reason);
            prep.setString(2, image);
            prep.setBoolean(3, false);
            prep.setInt(4, employeeId);
            prep.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public RequestDao(int id) {
        try {
            Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/reimbursements", "reimbursements", "password");
            ResultSet result = conn.prepareStatement(
                "select requests.id, requests.reason, requests.picture, requests.approved, requests.manager, employees.firstname, " +
                "employees.lastname from requests left join employees on requests.manager=employees.id where requests.employee="
                + id).executeQuery();
            
            json = "[\n";
            while (result.next()) {
                String image = result.getString("picture")
                    .substring(result.getString("picture").indexOf("images"))
                    .replace("\\", "/");
                json += "{\n";
                json += "\"id\":" + result.getInt("id") + ",\n";
                json += "\"reason\":\"" + result.getString("reason") + "\",\n";
                json += "\"image\":\"" + image + "\",\n";
                json += "\"approved\":" + result.getBoolean("approved") + ",\n";
                json += "\"manager\":\"" + result.getString("firstname") + " " + result.getString("lastname") + "\"\n";
                json += "},\n";
            }
            json += "]";
            json = json.replace("},\n]", "}\n]");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public RequestDao(boolean approved) {
        try {
            Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/reimbursements", "reimbursements", "password");
            String not = approved ? "" : "not ";
            ResultSet result = conn.prepareStatement(
                "select requests.id, requests.reason, requests.picture, requests.manager, employee.firstname as employeefirst, " +
                "employee.lastname as employeelast, manager.firstname as managerfirst, manager.lastname as managerlast from " +
                "requests left join employees employee on requests.employee=employee.id left join employees manager on " +
                "requests.manager=manager.id where " + not + "requests.approved").executeQuery();
            
            json = "[\n";
            while (result.next()) {
                String image = result.getString("picture")
                    .substring(result.getString("picture").indexOf("images"))
                    .replace("\\", "/");
                json += "{\n";
                json += "\"id\":" + result.getInt("id") + ",\n";
                json += "\"reason\":\"" + result.getString("reason") + "\",\n";
                json += "\"image\":\"" + image + "\",\n";
                json += "\"employee\":\"" + result.getString("employeefirst") + " " + result.getString("employeelast") + "\",\n";
                json += "\"approved\":" + result.getBoolean("approved") + ",\n";
                json += "\"manager\":\"" + result.getString("managerfirst") + " " + result.getString("managerlast") + "\"\n";
                json += "},\n";
            }
            json += "]";
            json = json.replace("},\n]", "}\n]");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public RequestDao(int id, boolean approved) {
        try {
            Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/reimbursements", "reimbursements", "password");
            String not = approved ? "" : "not ";
            ResultSet result = conn.prepareStatement(
                "select requests.id, requests.reason, requests.picture, requests.approved, requests.manager, employees.firstname, " +
                "employees.lastname from requests left join employees on requests.manager=employees.id where " + not +
                "approved and requests.employee=" + id).executeQuery();
            
            json = "[\n";
            while (result.next()) {
                String image = result.getString("picture")
                    .substring(result.getString("picture").indexOf("images"))
                    .replace("\\", "/");
                json += "{\n";
                json += "\"id\":" + result.getInt("id") + ",\n";
                json += "\"reason\":\"" + result.getString("reason") + "\",\n";
                json += "\"image\":\"" + image + "\",\n";
                json += "\"approved\":" + result.getBoolean("approved") + ",\n";
                json += "\"manager\":\"" + result.getString("firstname") + " " + result.getString("lastname") + "\"\n";
                json += "},\n";
            }
            json += "]";
            json = json.replace("},\n]", "}\n]");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getJson() {
        return json;
    }
}
