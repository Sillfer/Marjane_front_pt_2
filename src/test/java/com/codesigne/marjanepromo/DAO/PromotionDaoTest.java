package com.codesigne.marjanepromo.DAO;

import com.codesigne.marjanepromo.model.Promotion;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class PromotionDaoTest {

    @Test
    void createPromotion() {
        PromotionDao p = new PromotionDao();
        Promotion promotion = new Promotion();
        promotion.setDateStart(new Date("2021/06/01"));
        promotion.setDateEnd(new Date("2021/06/30"));
        promotion.setPoints(100L);
        promotion.setAdminCenter(new AdminCenterDao().getAdminById(41L));
        promotion.setSubCategory(new SubCategoryDao().getCategoryById(1L));
        assertNotNull(p.createPromotion(promotion));
//        promotion.setStatus("PENDING");
    }
}