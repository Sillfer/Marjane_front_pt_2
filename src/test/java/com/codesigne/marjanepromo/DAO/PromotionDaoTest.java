package com.codesigne.marjanepromo.DAO;

import com.codesigne.marjanepromo.helpers.StatusEnum;
import com.codesigne.marjanepromo.model.Promotion;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class PromotionDaoTest {

    @Test
    void createPromotion() {
        PromotionDao p = new PromotionDao();
        Promotion promotion = new Promotion();
        promotion.setDateStart(LocalDate.now());
        promotion.setDateEnd(LocalDate.parse("2022-12-12"));
        promotion.setPoints(100L);
        promotion.setAdminCenter(new AdminCenterDao().getAdminById(41L));
        promotion.setSubCategory(new SubCategoryDao().getCategoryById(1L));
        assertNotNull(p.createPromotion(promotion));
//        promotion.setStatus("PENDING");
    }

    @Test
    void getAllPromotions() {
        PromotionDao p = new PromotionDao();
        List<Promotion> promotions = p.getAllPromotions();
//        System.out.println(promotions);
        assertNotNull(promotions);
    }

    @Test
    void updateStatus() {
        PromotionDao p = new PromotionDao();
        Promotion promotion = new Promotion();
        promotion = p.findOne(9L);
        String status = StatusEnum.ACCEPTED.toString();
        p.updateStatus(promotion, status);
        assertNotNull(promotion);
    }
}