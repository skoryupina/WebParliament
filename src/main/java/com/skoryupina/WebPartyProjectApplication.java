package com.skoryupina;

import com.skoryupina.configurations.JpaConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebPartyProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(new Class<?>[] {WebPartyProjectApplication.class, JpaConfiguration.class}, args);

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
