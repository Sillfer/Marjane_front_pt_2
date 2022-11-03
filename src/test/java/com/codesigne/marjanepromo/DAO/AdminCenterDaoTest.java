package com.codesigne.marjanepromo.DAO;

import com.codesigne.marjanepromo.model.AdminCenter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class AdminCenterDaoTest {

    @Test
    void createAdmin() throws Exception {
        AdminCenterDao adminCenterDao = new AdminCenterDao();
        AdminCenter adminCenter = new AdminCenter();
        adminCenter.setFirstname("test");
        adminCenter.setLastname("test");
        adminCenter.setEmail("lonelycrow1@gmail.com");
        adminCenter.setPassword("123456");
        assertNotNull(adminCenterDao.createAdmin(adminCenter));
    }
}