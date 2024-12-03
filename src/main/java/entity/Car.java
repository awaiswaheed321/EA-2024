package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    String Model;
    String Make;
    int Year;
    int Mileage;

    @Override
    public String toString() {
        return "entity.Car{" +
                "id=" + id +
                ", Model='" + Model + '\'' +
                ", Make='" + Make + '\'' +
                ", Year=" + Year +
                ", Mileage=" + Mileage +
                '}';
    }

    public Car() {
    }

    public Car(String model, String make, int year, int mileage) {
        Model = model;
        Make = make;
        Year = year;
        Mileage = mileage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public String getMake() {
        return Make;
    }

    public void setMake(String make) {
        Make = make;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        Year = year;
    }

    public int getMileage() {
        return Mileage;
    }

    public void setMileage(int mileage) {
        Mileage = mileage;
    }
}
