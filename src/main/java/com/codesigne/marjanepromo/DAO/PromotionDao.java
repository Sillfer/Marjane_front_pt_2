package com.codesigne.marjanepromo.DAO;

import com.codesigne.marjanepromo.helpers.StatusEnum;
import com.codesigne.marjanepromo.model.Promotion;

import java.time.LocalTime;
import java.util.List;

public class PromotionDao extends AbstractHibernateDao<Promotion> {

    public PromotionDao() {
        tableName = "promotion";
        setClazz(Promotion.class);
    }


    public List getAllPromotions() {
        return findAll();
    }

    //get all promotion between 8 and 12

    public List getPromotionByCenterAdminId(int id) {
        return jpaService.runInTransaction(entityManager -> {
            return entityManager.createQuery("select p from Promotion p where p.adminCenter.id = :id", Promotion.class)
                    .setParameter("id", id)
                    .getResultList();
        });
    }

    public Promotion getPromotionByCategory(long idCat) {
        LocalTime currentTime = LocalTime.now();
        if (currentTime.isAfter(LocalTime.of(17, 0)) && currentTime.isBefore(LocalTime.of(20, 30))) {
            System.out.println("teeeeeeeeeeeest");
            return jpaService.runInTransaction(entityManager -> {
                return entityManager.createQuery("select p from Promotion p where p.subCategory.id=:id", Promotion.class)
                        .setParameter("id", idCat)
                        .getSingleResult();
            });
        } else {
            return null;
        }
    }


    //create promotion

    public List getList(Long id) {
        LocalTime currentTime = LocalTime.now();
        if (currentTime.isAfter(LocalTime.of(8, 0)) && currentTime.isBefore(LocalTime.of(18, 30))) {
            return jpaService.runInTransaction(entityManager -> {
                return entityManager.createQuery("select p from Promotion p where p.subCategory.id=:id", Promotion.class)
                        .setParameter("id", id)
                        .getResultList();
            });
        }
        return null;
    }
    public List getPromotionAccepted() {
        return jpaService.runInTransaction(entityManager -> {
            return entityManager.createQuery("select p from Promotion p where p.status = :status", Promotion.class)
                    .setParameter("status", StatusEnum.ACCEPTED.toString())
                    .getResultList();
        });
    }
//    get the percentage of the promotion accepted
    public List getPromotionPending() {
        return jpaService.runInTransaction(entityManager -> {
            return entityManager.createQuery("select p from Promotion p where p.status = :status", Promotion.class)
                    .setParameter("status", StatusEnum.PENDING.toString())
                    .getResultList();
        });
    }
    public List getPromotionRejected() {
        return jpaService.runInTransaction(entityManager -> {
            return entityManager.createQuery("select p from Promotion p where p.status = :status", Promotion.class)
                    .setParameter("status", StatusEnum.REJECTED.toString())
                    .getResultList();
        });
    }


    public boolean createPromotion(Promotion p) {
        p.setStatus(StatusEnum.PENDING.toString());
        return create(p);
    }

    public void updateStatus(Promotion p, String status) {
        p.setStatus(status.toUpperCase());
        update(p);
    }


}
