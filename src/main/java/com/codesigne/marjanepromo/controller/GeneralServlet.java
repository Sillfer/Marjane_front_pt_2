package com.codesigne.marjanepromo.controller;

import com.codesigne.marjanepromo.DAO.AdminCenterDao;
import com.codesigne.marjanepromo.DAO.AdminGeneralDao;
import com.codesigne.marjanepromo.DAO.CenterDao;
import com.codesigne.marjanepromo.DAO.PromotionDao;
import com.codesigne.marjanepromo.model.AdminCenter;
import com.codesigne.marjanepromo.model.Center;
import com.codesigne.marjanepromo.model.Promotion;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;

import java.io.IOException;
import java.util.List;

public class GeneralServlet extends HttpServlet {

    private AdminGeneralDao adminGeneralDao;
    private AdminCenterDao adminCenterDao;
    private CenterDao centerDao;
    private PromotionDao promotionDao;

    public void init() throws ServletException {
        adminGeneralDao = new AdminGeneralDao();
        adminCenterDao = new AdminCenterDao();
        centerDao = new CenterDao();
        promotionDao = new PromotionDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        if (path.equals("/landing.general")) {
            request.getRequestDispatcher("views/GeneralAdmin/GeneralLogin.jsp").forward(request, response);
//            if the cookie is not set don't redirect to the dashboard
        } else if (path.equals("/Dashboard.general")) {
            List<AdminCenter> admins = adminCenterDao.getAllAdmins();
            request.setAttribute("admins", admins);
            List<Center> centers = centerDao.getAllCenter();
            request.setAttribute("centers", centers);
            List<Promotion> promotions = promotionDao.getAllPromotions();
            request.setAttribute("promotions", promotions);
            Cookie[] cookies = request.getCookies();
            String id = "0";
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("id")) {
                    id = cookie.getValue();
                }
            }
            if (id.equals("0")) {
//                get all center admins and send them to the dashboard
                response.sendRedirect("landing.general");
            } else {
                request.getRequestDispatcher("views/GeneralAdmin/GeneralDashboard.jsp").forward(request, response);
            }
//            if there is no cookie named id redirect to landing.general page
        } else if (path.equals("/logout.general")) {
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

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        if (path.equals("/loginGeneral.general")) {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            if (adminGeneralDao.validateAdminLogin(email, password) != null) {
                Cookie cookie = new Cookie("id", String.valueOf(adminGeneralDao.validateAdminLogin(email, password).getId()));  //create cookie
                cookie.setMaxAge(60 * 60);  //set cookie age to 1 hour
                response.addCookie(cookie);  //add cookie to response
                request.setAttribute("id", adminGeneralDao.validateAdminLogin(email, password).getId());
                response.sendRedirect("Dashboard.general");
            } else {
                String errorMessage = "Invalid email or password";
                request.setAttribute("errorMessage", errorMessage);
                request.getRequestDispatcher("views/GeneralAdmin/GeneralLogin.jsp").forward(request, response);
            }
        } else if (path.equals("/createCentral.general")) {
            String firstname = request.getParameter("firstname");
            String lastname = request.getParameter("lastname");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            Long center_id = Long.valueOf(request.getParameter("center_id"));
//            get the parameter admin id from the cookie
            Cookie[] cookies = request.getCookies();
            String idgeneral = "0";
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("id")) {
                    idgeneral = cookie.getValue();
                }
            }
            AdminCenterDao adminCenterDao = new AdminCenterDao();
            AdminCenter adminCenter = new AdminCenter();
            adminCenter.setFirstname(firstname);
            adminCenter.setLastname(lastname);
            adminCenter.setEmail(email);
            adminCenter.setPassword(password);
            adminCenter.setCenter(centerDao.getCenterById(center_id));
            adminCenter.setAdminGeneral(adminGeneralDao.getAdminById(Long.parseLong(idgeneral)));
            if (adminCenterDao.createAdmin(adminCenter)) {
                response.sendRedirect("Dashboard.general");
            } else {
                String errorMessage = "Form is not valid";
                request.setAttribute("errorMessage", errorMessage);
                request.getRequestDispatcher("views/GeneralAdmin/GeneralDashboard.jsp").forward(request, response);
            }
        }

    }
}
