package br.com.sbs.cubatech.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtilTest {

    private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("cubatechDbTest");

    public static EntityManager getEntityManager(){
        return FACTORY.createEntityManager();
    }
}