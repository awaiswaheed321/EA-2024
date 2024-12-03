package service;

import entity.task2.Car;
import entity.task2.Person;

public class Task2Service {
    private final PersistenceService ps;

    public Task2Service(PersistenceService ps) {
        this.ps = ps;
    }

    public void runTask2() {
        Car car1 = new Car();
        car1.setMake("Honda");
        car1.setModel("Civic");
        car1.setYear(2020);
        car1.setMileage(60000);

        Person owner1 = new Person();
        owner1.setOwner(true);
        owner1.setName("Jack");
        owner1.setAge(22);
        owner1.setCar(car1);

        Person driver1 = new Person();
        driver1.setOwner(false);
        driver1.setName("Jill");
        driver1.setAge(22);

        car1.setOwner(owner1);
        car1.setDriver(driver1);

        createCar(car1);

        Car savedCar = findCar(car1.getEmId());
        System.out.println(savedCar);
    }

    private void createCar(Car car) {
        ps.startTransaction();
        ps.getEntityManager().persist(car);
        ps.endTransaction();
    }

    private Car findCar(Long id) {
        ps.startTransaction();
        Car car = ps.getEntityManager().find(Car.class, id);
        ps.endTransaction();
        return car;
    }

    private Person findPerson(Long id) {
        ps.startTransaction();
        Person person = ps.getEntityManager().find(Person.class, id);
        ps.endTransaction();
        return person;
    }
}
