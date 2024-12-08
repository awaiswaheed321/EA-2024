package service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Component;

@Component
public class PersistenceService implements DisposableBean {
    private static PersistenceService instance;
    private final EntityManagerFactory emf;
    private final EntityManager em;
    private EntityTransaction tx;

    public PersistenceService() {
        emf = Persistence.createEntityManagerFactory("day3_PU");
        em = emf.createEntityManager();
    }

    public static PersistenceService getInstance() {
        if (instance == null) {
            instance = new PersistenceService();
        }
        return instance;
    }

    public EntityManager getEntityManager() {
        return em;
    }

    public void startTransaction() {
        if (em != null) {
            tx = em.getTransaction();
            tx.begin();
        } else {
            throw new IllegalStateException("EntityManager is not initialized.");
        }
    }

    public void endTransaction() {
        if (tx != null && tx.isActive()) {
            tx.commit();
        } else {
            throw new IllegalStateException("No active transaction to commit.");
        }
    }

    @Override
    public void destroy() throws Exception {
        em.close();
        emf.close();
    }
}
