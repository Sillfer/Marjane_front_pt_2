package com.codesigne.marjanepromo.controller;

import com.codesigne.marjanepromo.DAO.AdminCenterDao;
import com.codesigne.marjanepromo.DAO.PromotionDao;
import com.codesigne.marjanepromo.DAO.SubCategoryDao;
import com.codesigne.marjanepromo.model.Promotion;
import com.codesigne.marjanepromo.model.SubCategory;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

public class AdminServlet extends HttpServlet {

    private AdminCenterDao adminCenterDao;
    private PromotionDao promotionDao;
    private SubCategoryDao subCategoryDao;

    public void init() throws ServletException {
        adminCenterDao = new AdminCenterDao();
        promotionDao = new PromotionDao();
        subCategoryDao = new SubCategoryDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        if (path.equals("/landing.center")) {
            request.getRequestDispatcher("views/AdminCenter/CenterLogin.jsp").forward(request, response);
        } else if (path.equals("/Dashboard.center")) {
            List<SubCategory> subCategories = subCategoryDao.getAllCategories();
            request.setAttribute("subCategories", subCategories);
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
        } else if (path.equals("/createPromotion.center")) {
            Date dateStart = new Date();
            Date dateEnd = new Date();
            DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
            try {
                dateStart = dateFormat.parse(request.getParameter("dateStart"));
                dateEnd = dateFormat.parse(request.getParameter("dateEnd"));
            } catch (Exception e) {
                e.printStackTrace();
            }
            Long points = Long.parseLong(request.getParameter("points"));
            SubCategory subCategory = subCategoryDao.getCategoryById(Long.parseLong(request.getParameter("subCategory")));
            Cookie[] cookies = request.getCookies();
            String id_center = "0";
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("id_center")) {
                    id_center = cookie.getValue();
                }
            }
            Promotion promotion = new Promotion();
            promotion.setDateStart(dateStart);
            promotion.setDateEnd(dateEnd);
            promotion.setPoints(points);
            promotion.setSubCategory(subCategory);
            promotion.setAdminCenter(adminCenterDao.getAdminById(Long.parseLong(id_center)));
            if (promotionDao.createPromotion(promotion)) {
                response.sendRedirect("Dashboard.center");
            } else {
                String errorMessage = "Invalid Form";
                request.setAttribute("errorMessage", errorMessage);
                response.sendRedirect("Dashboard.center");
            }
        }
    }
}
