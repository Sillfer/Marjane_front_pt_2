package com.codesigne.marjanepromo.DAO;

import com.codesigne.marjanepromo.model.MarketManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MarketDaoTest {

    @Test
    void validateMarketManagerLogin() {
    }

    @Test
    void createMarketManager() throws Exception {
        MarketDao marketDao = new MarketDao();
        MarketManager marketManager = new MarketManager();
        marketManager.setFirstname("test");
        marketManager.setLastname("test");
        marketManager.setEmail("lonelycrow1@gmail.com");
        marketManager.setPassword("123456");
        marketManager.setAdminCenter(null);
        marketManager.setSubCategory(null);
        assertNotNull(marketDao.createMarketManager(marketManager));
    }
}