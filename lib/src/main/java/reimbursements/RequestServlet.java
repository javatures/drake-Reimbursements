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
        
        File file = new File("resources/images", image.getSubmittedFileName());

        try {
            InputStream stream = image.getInputStream();
            Files.copy(stream, file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        new RequestDao(description, "resources/images/" + image.getSubmittedFileName(), (int) req.getSession().getAttribute("id"));
    }
}
