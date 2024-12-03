package entity.task2;

import jakarta.persistence.*;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long emId;
    private String name;
    private int age;
    private boolean owner;
    @OneToOne(mappedBy = "owner")
    private Car car;

    public Person() {
    }

    public Person(String name, int age, boolean owner, Car car) {
        this.name = name;
        this.age = age;
        this.owner = owner;
        this.car = car;
    }

    @Override
    public String toString() {
        return "Person{" +
                "emId=" + emId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", owner=" + owner +
                '}';
    }

    public Long getEmId() {
        return emId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isOwner() {
        return owner;
    }

    public void setOwner(boolean owner) {
        this.owner = owner;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
