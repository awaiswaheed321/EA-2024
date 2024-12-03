package util;

import entity.Car;
import service.CarService;

public class Helper {
    public static void run() {
        try (CarService carService = new CarService("Day1")) {
            Car car1 = new Car("Corvette", "Cheverlot", 2024, 60000);
            Car car2 = new Car("Civic", "Honda", 2024, 60000);
//            Saving Cars and fetching by ID
            carService.save(car1);
            carService.save(car2);
            Car dbCar1 = carService.findById(car1.getId());
            Car dbCar2 = carService.findById(car2.getId());
            System.out.println("First Saved Objects:");
            System.out.println(dbCar1);
            System.out.println(dbCar2);
//          Updating Cars and fetching by ID
            car1.setYear(2020);
            car2.setMileage(400000);
            carService.update(car1);
            carService.update(car2);
            System.out.println("Updated Objects");
            Car updatedCar1 = carService.findById(car1.getId());
            Car updatedCar2 = carService.findById(car2.getId());
            System.out.println(updatedCar1);
            System.out.println(updatedCar2);
//          Deleting
            carService.delete(updatedCar1);
            carService.delete(updatedCar2);
//          Trying to find after deleting
            System.out.println("Trying to find after deleting");
            Car c = carService.findById(car1.getId());
            System.out.println(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
