package com.codesigne.marjanepromo.controller;

import com.codesigne.marjanepromo.DAO.AdminCenterDao;
import com.codesigne.marjanepromo.DAO.MarketDao;
import com.codesigne.marjanepromo.DAO.PromotionDao;
import com.codesigne.marjanepromo.DAO.SubCategoryDao;
import com.codesigne.marjanepromo.model.SubCategory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ManagerServlet", value = "/ManagerServlet")
public class ManagerServlet extends HttpServlet {

    private AdminCenterDao adminCenterDao;
    private PromotionDao promotionDao;
    private SubCategoryDao subCategoryDao;
    private MarketDao marketDao;


    public void init() throws ServletException {
        adminCenterDao = new AdminCenterDao();
        promotionDao = new PromotionDao();
        subCategoryDao = new SubCategoryDao();
        marketDao = new MarketDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        if (path.equals("/landing.manager")) {
            request.getRequestDispatcher("views/MarketManager/ManagerLogin.jsp").forward(request, response);
        } else if (path.equals("/Dashboard.manager")) {
            List<SubCategory> subCategories = subCategoryDao.getAllCategories();
            request.setAttribute("subCategories", subCategories);
            Cookie[] cookies = request.getCookies();
            String id_manager = "0";
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("id_manager")) {
                    id_manager = cookie.getValue();
                }
            }
            if (id_manager.equals("0")) {
                response.sendRedirect("landing.manager");
            } else {
                request.getRequestDispatcher("views/MarketManager/MarketDashboard.jsp").forward(request, response);
            }
        } else if (path.equals("/logout.manager")) {
            Cookie[] cookies = request.getCookies();
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("id_manager")) {
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                }
            }
            response.sendRedirect("landing.manager");
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        if (path.equals("/loginManager.manager")) {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            if (marketDao.validateMarketManagerLogin(email, password) != null) {
                Cookie cookie = new Cookie("id_manager", String.valueOf(marketDao.validateMarketManagerLogin(email, password).getId()));
                cookie.setMaxAge(60 * 60);
                response.addCookie(cookie);
                request.setAttribute("id_manager", marketDao.validateMarketManagerLogin(email, password).getId());
                response.sendRedirect("Dashboard.manager");
            } else {
                String message = "Invalid email or password";
                request.setAttribute("message", message);
                response.sendRedirect("landing.manager");
            }
        }
    }
}