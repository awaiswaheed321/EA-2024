package entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long emId;
    private String title;
    private LocalDate startDate;
    private String professor;

    public Course() {
    }

    @Override
    public String toString() {
        return String.format(
                """
                        
                        {Course Information:
                        ID: %d
                        Title: '%s'
                        Start Date: %s
                        Professor: '%s'
                        }""",
                emId, title, startDate, professor
        );
    }


    public Long getEmId() {
        return emId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }
}
