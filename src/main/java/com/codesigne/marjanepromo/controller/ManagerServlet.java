package com.codesigne.marjanepromo.controller;

import com.codesigne.marjanepromo.DAO.AdminCenterDao;
import com.codesigne.marjanepromo.DAO.MarketDao;
import com.codesigne.marjanepromo.DAO.PromotionDao;
import com.codesigne.marjanepromo.DAO.SubCategoryDao;
import com.codesigne.marjanepromo.helpers.StatusEnum;
import com.codesigne.marjanepromo.model.Promotion;
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
            Cookie[] cookies = request.getCookies();
            String id_manager = "0";
            String subcategory_id = "0";
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("id_manager")) {
                    id_manager = cookie.getValue();
                }
                if (cookie.getName().equals("subcategory_id")) {
                    subcategory_id = cookie.getValue();
                }
            }
            List<Promotion> promotions = promotionDao.getList(Long.valueOf(subcategory_id));
            request.setAttribute("promotions", promotions);
            List<Promotion> accepted = promotionDao.getPromotionAcceptedBySubCategory(Long.parseLong(subcategory_id));
            request.setAttribute("accepted", accepted);
            double percentage = (double) accepted.size() / promotions.size() * 100;
            percentage = Math.round(percentage * 100.0) / 100.0;
            request.setAttribute("percentage", percentage);
            List<Promotion> pending = promotionDao.getPromotionPendingBySubCategory(Long.parseLong(subcategory_id));
            request.setAttribute("pending", pending);
            double percentagePending = (double) pending.size() / promotions.size() * 100;
            percentagePending = Math.round(percentagePending * 100.0) / 100.0;
            request.setAttribute("percentagePending", percentagePending);
            List<Promotion> rejected = promotionDao.getPromotionRejectedBySubCategory(Long.parseLong(subcategory_id));
            request.setAttribute("rejected", rejected);
            double percentageRejected = (double) rejected.size() / promotions.size() * 100;
            percentageRejected = Math.round(percentageRejected * 100.0) / 100.0;
            request.setAttribute("percentageRejected", percentageRejected);
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
                }if (cookie.getName().equals("subcategory_id")) {
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
                Cookie cookie1 = new Cookie("subcategory_id", String.valueOf(marketDao.validateMarketManagerLogin(email, password).getSubCategory().getId()));
                cookie.setMaxAge(60 * 60);
                cookie1.setMaxAge(60 * 60);
                response.addCookie(cookie);
                response.addCookie(cookie1);
                request.setAttribute("id_manager", marketDao.validateMarketManagerLogin(email, password).getId());
                response.sendRedirect("Dashboard.manager");
            } else {
                String message = "Invalid email or password";
                request.setAttribute("message", message);
                response.sendRedirect("landing.manager");
            }
        } else if (path.equals("/acceptPromotion.manager")) {
            long id = Long.parseLong(request.getParameter("id"));
            String status = StatusEnum.ACCEPTED.toString();
            Promotion promotion = promotionDao.findOne(id);   // promotionDao.findOne(id) returns a Promotion object
            promotion.setStatus(status);
            promotionDao.updateStatus(promotion, status);
            response.sendRedirect("Dashboard.manager");
        }
    }
}