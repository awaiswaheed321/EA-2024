package service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class PersistenceService implements AutoCloseable {
    private static PersistenceService instance;

    private final EntityManagerFactory emf;
    private final EntityManager em;
    private EntityTransaction tx;

    private PersistenceService() {
        emf = Persistence.createEntityManagerFactory("day2_PU");
        em = emf.createEntityManager();
    }

    public static synchronized PersistenceService getInstance() {
        if (instance == null) {
            instance = new PersistenceService();
        }
        return instance;
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

    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public void close() {
        if (em != null) {
            em.close();
        }
        if (emf != null) {
            emf.close();
        }
    }
}

