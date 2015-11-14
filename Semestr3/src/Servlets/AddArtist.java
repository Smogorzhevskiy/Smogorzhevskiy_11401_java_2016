package Servlets;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/UploadS")
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
        maxFileSize=1024*1024*10,      // 10MB
        maxRequestSize=1024*1024*50)   // 50MB
public class AddArtist extends HttpServlet {

    /**
     * Name of the directory where uploaded files will be saved, relative to
     * the web application directory.
     */

    private static final String SAVE_DIR = "Avatars";

    /**
     * handles file upload
     */
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        // gets absolute path of the web application
        HttpSession s = request.getSession();
        String appPath = this.getServletContext().getRealPath("/images");
        String savePath = appPath + File.separator + SAVE_DIR;

        File fileSaveDir = new File(savePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }
        System.out.println("lll");

        for (Part part : request.getParts()) {

            String fileName = extractFileName(part);

            part.write(savePath + File.separator + fileName);            System.out.println("lll");

            siteRepository sr = new siteRepository();
            sr.addArtist((String)request.getParameter("artist"), (String)fileName);
            System.out.println("lll");

            System.out.println("Photo added");
            System.out.println(fileName);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/DataServlet");
            if (dispatcher != null) {

                dispatcher.forward(request, response);

            }


        }

    }

    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }
}
