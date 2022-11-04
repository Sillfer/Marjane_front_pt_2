package com.codesigne.marjanepromo.controller;

import com.codesigne.marjanepromo.DAO.AdminCenterDao;
import com.codesigne.marjanepromo.DAO.PromotionDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Date;

public class AdminServlet extends HttpServlet {

    private AdminCenterDao adminCenterDao;
    private PromotionDao promotionDao;

    public void init() throws ServletException {
        adminCenterDao = new AdminCenterDao();
        promotionDao = new PromotionDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        if (path.equals("/landing.center")) {
            request.getRequestDispatcher("views/AdminCenter/CenterLogin.jsp").forward(request, response);
        } else if (path.equals("/Dashboard.center")) {
            Cookie[] cookies = request.getCookies();
            String id_center = "0";
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("id_center")) {
                    id_center = cookie.getValue();
                }
            }
            if (id_center.equals("0")) {
                response.sendRedirect("landing.center");
            } else {
                request.getRequestDispatcher("views/AdminCenter/CenterDashboard.jsp").forward(request, response);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        if (path.equals("/loginCenter.center")) {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            if (adminCenterDao.validateAdminLogin(email, password) != null) {
                Cookie cookie = new Cookie("id_center", String.valueOf(adminCenterDao.validateAdminLogin(email, password).getId()));
                cookie.setMaxAge(60 * 60);
                response.addCookie(cookie);
                request.setAttribute("id_center", adminCenterDao.validateAdminLogin(email, password).getId());
                response.sendRedirect("Dashboard.center");
            } else {
                String errorMessage = "Invalid email or password";
                request.setAttribute("errorMessage", errorMessage);
                response.sendRedirect("landing.center");
            }
        }else if(path.equals("/createPromotion.center")){
        }
    }
}
