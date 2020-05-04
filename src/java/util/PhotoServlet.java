/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import controller.PhotosController;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
@WebServlet(name = "PhotoServlet", urlPatterns = {"/file/*"})
public class PhotoServlet extends HttpServlet {
@Inject
private PhotosController pc;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String dosya=request.getPathInfo();
       File r=new File(pc.getYKlasoru()+dosya);
       Files.copy(r.toPath(),response.getOutputStream());
    }
}
