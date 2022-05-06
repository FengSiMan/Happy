package com.cx.web.servletContext;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/download")
public class servletContext extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String filename = request.getParameter("filename");
        ServletContext servletContext = this.getServletContext();
        String realPath = servletContext.getRealPath("/img/"+filename);
        FileInputStream fis = new FileInputStream(realPath);
        String mimeType = servletContext.getMimeType(filename);
        response.setHeader("content-type",mimeType);
        response.setHeader("content-disposition","attachment;filenmame="+filename);
        ServletOutputStream sos = response.getOutputStream();
        byte[] buff = new byte[1024*8];
        int len = 0;
        while((len=fis.read(buff))!=-1){
            sos.write(buff,0,len);
        }
        fis.close();

    }
}
