package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class WebinarSessionDate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long emId;

    private LocalDate date;

    public WebinarSessionDate() {
    }

    public WebinarSessionDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "WebinarSessionDate{" +
                "emId=" + emId +
                ", date=" + date +
                '}';
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Long getEmId() {
        return emId;
    }
}
