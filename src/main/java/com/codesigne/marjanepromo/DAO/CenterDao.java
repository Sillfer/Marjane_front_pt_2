package com.codesigne.marjanepromo.DAO;

import com.codesigne.marjanepromo.model.Center;


import java.util.List;

public class CenterDao extends AbstractHibernateDao<Center>{

    public CenterDao(){
        tableName = "center";
        setClazz(Center.class);
    }

    public List getAllCenter(){
        return findAll();
    }

    public Center getCenterByVille(String name){
        return jpaService.runInTransaction(entityManager -> {
            return entityManager.createQuery("select c from Center c where c.nom = :nom",Center.class)
                    .setParameter(1,name)
                    .getSingleResult();
        });

    }


    public Center getCenterById(long id){
        return findOne(id);
    }

    public boolean createCenter(Center c){
        return create(c);
    }




    public static void main(String[] args) {
        Center c = new Center();
        c.setNom("shop");
        c.setVille("casablanca");
        AdminCenterDao ad = new AdminCenterDao();
        c.setAdminCenter(ad.getAdminById(4L));

        CenterDao ce = new CenterDao();
        ce.createCenter(c);
    }


}
