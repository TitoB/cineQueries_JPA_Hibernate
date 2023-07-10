package org.jpaHibernate.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUtil {
    private  static final EntityManagerFactory entityManagerFactory =
            buildEntityManagerFactor();

    private static EntityManagerFactory buildEntityManagerFactor(){
        return Persistence.createEntityManagerFactory("cineJPA");
    }

    public static EntityManager getEntityManager(){
        return entityManagerFactory.createEntityManager();
    }

}
