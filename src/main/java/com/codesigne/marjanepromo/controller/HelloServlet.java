package com.codesigne.marjanepromo.controller;

import java.io.*;

import com.codesigne.marjanepromo.DAO.AdminCenterDao;
import com.codesigne.marjanepromo.model.AdminCenter;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        AdminCenterDao ad = new AdminCenterDao();
        AdminCenter a = new AdminCenter();
        a=ad.getAdminById(1L);




        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + a.getLastname()+ "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}