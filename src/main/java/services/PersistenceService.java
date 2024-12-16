package services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class PersistenceService implements AutoCloseable{
    private static PersistenceService ps;

    private final EntityManagerFactory emf;
    private final EntityManager em;
    private EntityTransaction tx;

    private PersistenceService() {
        emf = Persistence.createEntityManagerFactory("Practice_PU");
        em = emf.createEntityManager();
    }

    public static PersistenceService getInstance() {
        if(ps == null) {
            ps = new PersistenceService();
        }
        return ps;
    }

    public EntityManager getEntityManager() {
        return em;
    }

    public void startTransaction() {
        if(em != null) {
            tx = em.getTransaction();
            tx.begin();
        } else {
            throw new IllegalArgumentException("EM not initialized.");
        }
    }

    public void endTransaction() {
        if(tx != null && tx.isActive()) {
            tx.commit();
        } else {
            throw new IllegalArgumentException("No active Transaction.");
        }
    }

    @Override
    public void close() throws Exception {
        if(tx != null && tx.isActive()) {
            tx.commit();
        }
        if(em != null && em.isOpen()) {
            em.close();
        }
        if(emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}
