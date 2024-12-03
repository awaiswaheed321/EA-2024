package service;

import entity.Car;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class CarService implements AutoCloseable {
    private final EntityManagerFactory emf;
    private final EntityManager em;
    private EntityTransaction tx;

    public CarService(String persistenceUnitName) {
        emf = Persistence.createEntityManagerFactory(persistenceUnitName);
        em = emf.createEntityManager();
    }

    private void startTransaction() {
        tx = em.getTransaction();
        tx.begin();
    }

    private void endTransaction() {
        tx.commit();
    }

    public void save(Car car) {
        startTransaction();
        em.persist(car);
        endTransaction();
    }

    public Car findById(int id) {
        startTransaction();
        Car car = em.find(Car.class, id);
        endTransaction();
        return car;
    }

    public void update(Car car) {
        startTransaction();
        em.merge(car);
        endTransaction();
    }

    public void delete(Car car) {
        startTransaction();
        em.remove(car);
        endTransaction();
    }

    @Override
    public void close() throws Exception {
        em.close();
        emf.close();
    }
}
