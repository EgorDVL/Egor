package web.controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import web.controller.admin.CreateUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by Egor on 10.12.2016.
 */
@WebServlet("/UploadImage")
public class UploadImage extends HttpServlet {
    private final String UPLOAD_DIRECTORY = "D:/Java/Java_Idea/Hospital/src/main/webapp/image";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        if (ServletFileUpload.isMultipartContent(request)) {
            try {
                List<FileItem> multiparts = new ServletFileUpload(
                        new DiskFileItemFactory()).parseRequest(request);
                for (FileItem item : multiparts) {
                    if (!item.isFormField()) {
                        String name = new File(item.getName()).getName();
                        item.write(new File(UPLOAD_DIRECTORY + "/" + name));
                        String filePath = "image" + "/" + name;
                        session.setAttribute("filePath", filePath);
                    }
                }
                request.setAttribute("message", "File Uploaded Successfully");
            } catch (Exception ex) {
                request.setAttribute("message", "File Upload Failed due to " + ex);
            }
        } else {
            request.setAttribute("message", "Sorry this Servlet only handles file upload request");
        }
        response.sendRedirect("CreateUser");
    }
}