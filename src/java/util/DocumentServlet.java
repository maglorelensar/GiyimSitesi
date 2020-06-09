package util;

import controller.DocumentController;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "DocumentServlet", urlPatterns = {"/filee/*"})
public class DocumentServlet  extends HttpServlet{
   
@Inject
private DocumentController dc;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String dosya=request.getPathInfo();
       File r=new File(dc.getUploadTo()+dosya);
       Files.copy(r.toPath(),response.getOutputStream());
    }
}


