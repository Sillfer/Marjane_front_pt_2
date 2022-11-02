package com.codesigne.marjanepromo.controller;

import com.codesigne.marjanepromo.DAO.AdminGeneralDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class GeneralServlet extends HttpServlet {

    private AdminGeneralDao adminGeneralDao;

    public void init() throws ServletException {
        adminGeneralDao = new AdminGeneralDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        if (path.equals("/landing.general")) {
            Cookie[] cookies = request.getCookies();
            String log = "0";
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("log")) {
                    log = cookie.getValue();
                }
            }
            request.setAttribute("log", log);
            request.getRequestDispatcher("views/GeneralAdmin/GeneralLogin.jsp").forward(request, response);
        }else if(path.equals("/Dashboard.general")){
//            check if there is cookie named id
            Cookie[] cookies = request.getCookies();
            String id = "0";
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("id")) {
                    id = cookie.getValue();
                }
            }
            if (id.equals("0")) {
                response.sendRedirect("landing.general");
            } else {
                request.getRequestDispatcher("views/GeneralAdmin/GeneralDashboard.jsp").forward(request, response);
            }
        }else if(path.equals("/logout.general")){
            Cookie[] cookies = request.getCookies();
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("id")) {
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                }
            }
            response.sendRedirect("landing.general");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        if (path.equals("/loginGeneral.general")) {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            if (adminGeneralDao.validateAdminLogin(email, password) != null) {
                Cookie cookie = new Cookie("id", String.valueOf(adminGeneralDao.validateAdminLogin(email, password).getId()));  //create cookie
                cookie.setMaxAge(24 * 60 * 60);  //set cookie age to 1 year
                response.addCookie(cookie);  //add cookie to response
                request.setAttribute("id", adminGeneralDao.validateAdminLogin(email, password).getId());
                response.sendRedirect("Dashboard.general");
            }else {
                String errorMessage = "Invalid email or password";
                request.setAttribute("errorMessage", errorMessage);
                request.getRequestDispatcher("views/GeneralAdmin/GeneralLogin.jsp").forward(request, response);
            }
        }
    }
}
