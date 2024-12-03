package entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class DistanceEducationCourse extends Course {
    private String examProfessor;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn
    private List<WebinarSessionDate> webinarSessionDates;

    public DistanceEducationCourse() {
        super();
    }

    @Override
    public String toString() {
        return super.toString() + ", DistanceEducationCourse{" +
                "examProfessor='" + examProfessor + '\'' +
                ", webinarSessionDates=" + webinarSessionDates +
                '}';
    }

    public List<WebinarSessionDate> getWebinarSessionDates() {
        return webinarSessionDates;
    }

    public void setWebinarSessionDates(List<WebinarSessionDate> webinarSessionDates) {
        this.webinarSessionDates = webinarSessionDates;
    }

    public String getExamProfessor() {
        return examProfessor;
    }

    public void setExamProfessor(String examProfessor) {
        this.examProfessor = examProfessor;
    }
}
