package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;

@Entity
public class OnCampusCourse extends Course {
    private String room;
    private Integer capacity;

    public OnCampusCourse() {
        super();
    }

    @Override
    public String toString() {
        return super.toString() + ", OnCampusCourse{" +
                "room='" + room + '\'' +
                ", capacity=" + capacity +
                '}';
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
}
