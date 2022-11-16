package com.codesigne.marjanepromo.DAO;

import com.codesigne.marjanepromo.model.AdminGeneral;


import java.util.List;

import static com.codesigne.marjanepromo.utils.Security.checkPassword;
import static com.codesigne.marjanepromo.utils.Security.hashPassword;


public class AdminGeneralDao extends AbstractHibernateDao<AdminGeneral>{

    public AdminGeneralDao(){
        tableName = "admingeneral";
        setClazz(AdminGeneral.class);
    }

    // find all admins
    public List getAllAdmins() {
        return findAll();
    }

    // find one admin by id
    public AdminGeneral getAdminById(long id) {
        return findOne(id);
    }

    // find one admin by email
    public AdminGeneral getAdminByEmail(String email) {
        return jpaService.runInTransaction(entityManager -> {
            return entityManager.createQuery("select a from AdminGeneral a WHERE a.email = :email", AdminGeneral.class)
                    .setParameter("email", email)
                    .getSingleResult();
        });
    }

    // find one admin by email and password
    public AdminGeneral validateAdminLogin(String email,String password){
        AdminGeneral admin = getAdminByEmail(email);
        if (admin == null){
            return null;
        }
        if (checkPassword(password, admin.getPassword())){
           return admin;
        }else {
            return null;
        }
    }

    // create admin
    public boolean createAdmin(AdminGeneral admin) {
        admin.setPassword(hashPassword(admin.getPassword()));
        return create(admin);
    }



    // update admin
    public AdminGeneral updateAdmin(AdminGeneral admin) {
        return update(admin);
    }

    // delete admin
    public void deleteAdmin(AdminGeneral admin) {
        delete(admin);
    }

    // delete admin by id
    public void deleteAdminById(long id) {
        deleteById(id);
    }

}
