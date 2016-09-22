package com.skoryupina;

import com.skoryupina.entities.District;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.validation.ConstraintViolationException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class DistrictIntegrationTest {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaPersistenceUnit");
    private EntityManager em;
    private EntityTransaction tx;

    @Before
    public void initEntityManager() throws Exception {
        em = emf.createEntityManager();
        tx = em.getTransaction();
    }

    @After
    public void closeEntityManager() throws Exception {
        if (em!=null)
            em.close();
    }

    @Test
    public void shouldFindMultiMemberConstituencies() throws Exception {
        District district = em.find(District.class, 2);
        assertEquals("Multi-member constituencies", district.getName());
    }

    @Test
    public void shouldCreateMultiMemberConstituencies() throws Exception {
        District district = new District("");
        tx.begin();
        em.persist(district);
        tx.commit();
        assertNotNull("ID не может быть NULL", district.getId());

        district = em.createNamedQuery("findMultiMemberConstituency", District.class).getSingleResult();
        assertEquals("Multi-member constituencies", district.getName());
    }

    @Test (expected = ConstraintViolationException.class)
    public void shouldRaiseConstraintViolationCauseNullName(){
        District district = new District(null);
        em.persist(district);
    }
}
