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

    public static void main(String[] args) {

        //========================change status
        Promotion promotion = new Promotion();
        PromotionDao p = new PromotionDao();
        promotion = p.findOne(4L);
        String status = StatusEnum.ACCEPTED.toString();
        p.updateStatus(promotion, status);

        //=============================afficher promo
//        Promotion pp = new Promotion();
//        SubCategoryDao sub = new SubCategoryDao();
//        pp = p.getPromotionByCategory(1L);
//            if(pp == null){
//                System.out.println("there is no promotions");
//            }else{
//                System.out.println("Promotion Number ===> "+pp.getId()+ " ==> Status : "+pp.getStatus()+ " , Date ===>> "+ pp.getDate()+" ----\n SubCategory : "+pp.getSubCategory().getName());
//            }
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
        if (currentTime.isAfter(LocalTime.of(17, 0)) && currentTime.isBefore(LocalTime.of(23, 30))) {
            return jpaService.runInTransaction(entityManager -> {
                return entityManager.createQuery("select p from Promotion p where p.subCategory.id=:id", Promotion.class)
                        .setParameter("id", id)
                        .getResultList();
            });
        }
        return null;
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
