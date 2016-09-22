package com.skoryupina;

import com.skoryupina.entities.District;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

@SpringBootApplication
public class WebPartyProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebPartyProjectApplication.class, args);

//        District district = new District("Многомандатный избирательный округ");
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaPersistenceUnit");
//        EntityManager em = emf.createEntityManager();
//        EntityTransaction tx = em.getTransaction();
//        tx.begin();
//        System.out.println(district.toString());
//        em.persist(district);
//        tx.commit();
//        em.close();
//        emf.close();
    }
}
