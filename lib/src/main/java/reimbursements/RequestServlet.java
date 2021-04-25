package reimbursements;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import reimbursements.dao.RequestDao;

@WebServlet("/request")
@MultipartConfig
public class RequestServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String description = req.getParameter("description");
        Part image = req.getPart("image");
        
        File file = new File("C:\\Users\\drake\\OneDrive\\Desktop\\Github\\reimbursements\\lib\\src\\main\\webapp\\images",
            image.getSubmittedFileName());

        try {
            InputStream stream = image.getInputStream();
            Files.copy(stream, file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
            e.printStackTrace(resp.getWriter());
        }

        new RequestDao(description, file.getPath(), (int) req.getSession().getAttribute("id"));

        resp.setContentType("text/html");
        resp.getWriter().println("Your request has been submitted.");
        resp.getWriter().println("<a href=employee.html>Click here to return to the employee homepage</a>");
    }
}
