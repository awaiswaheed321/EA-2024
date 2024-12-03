package entity.task1;

import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long emId;

    private String name;
    private int gpa;

    @ManyToOne
    private Course course;

    public Student() {
    }

    public Student(String name, int gpa, Course course) {
        this.name = name;
        this.gpa = gpa;
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student{" +
                "emId=" + emId +
                ", name='" + name + '\'' +
                ", gpa=" + gpa +
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

    public int getGpa() {
        return gpa;
    }

    public void setGpa(int gpa) {
        this.gpa = gpa;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
