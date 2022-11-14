package com.codesigne.marjanepromo.DAO;

import com.codesigne.marjanepromo.model.MarketManager;
import com.codesigne.marjanepromo.utils.SendMail;

import java.util.List;

import static com.codesigne.marjanepromo.utils.Security.checkPassword;
import static com.codesigne.marjanepromo.utils.Security.hashPassword;

public class MarketDao extends AbstractHibernateDao<MarketManager> {
    public MarketDao() {
        tableName = "marketmanager";
        setClazz(MarketManager.class);
    }

    public List getAllMarketManagers() {
        return findAll();
    }

    public MarketManager getMarketManagerById(long id) {
        return findOne(id);
    }

    public MarketManager getMarketManagerByEmail(String email) {
        return jpaService.runInTransaction(entityManager -> {
            return entityManager.createQuery("select m from MarketManager m where m.email = :email", MarketManager.class)
                    .setParameter("email", email)
                    .getSingleResult();
        });
    }

    public MarketManager validateMarketManagerLogin(String email, String password) {
        MarketManager marketManager = getMarketManagerByEmail(email);
        if (marketManager == null) {
            return null;
        }
        if (checkPassword(password, marketManager.getPassword())) {
            return marketManager;
        } else {
            return null;
        }
    }

    public boolean createMarketManager(MarketManager marketManager) throws Exception {
        String message = "Welcome to Marjane Promo, your account has been created successfully/n" +
                "your email is " + marketManager.getEmail() + " and your password is " + marketManager.getPassword();
        SendMail.sendMail(marketManager.getEmail(), message);
        marketManager.setPassword(hashPassword(marketManager.getPassword()));
        return create(marketManager);
    }
}
