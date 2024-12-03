package entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "Student.canGraduate", query = "SELECT s from Student s JOIN s.coursesAttended c "),
        @NamedQuery(name = "Student.TopPerformers", query = "SELECT s from Student s where s.gpa > 4.0"),
        @NamedQuery(name = "Student.AvailableStudents", query = "SELECT s from Student s where s.courseAttending IS " +
                "NULL"),
        @NamedQuery(name = "Student.CompletedCourses", query = "select s from Student s JOIN s.coursesAttended c " +
                "GROUP BY s HAVING COUNT(c) > 10"),
        @NamedQuery(name = "Student.LowPerformers", query = "SELECT s from Student s where s.gpa < 2.5")
})

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long emId;

    private String name;

    private float gpa;

    @ManyToOne
    @JoinColumn(name = "course_attending_em_id")
    Course courseAttending;

    @ManyToMany
    List<Course> coursesAttended;

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Student {\n")
                .append("  emId: ").append(emId).append(",\n")
                .append("  name: '").append(name).append("',\n")
                .append("  gpa: ").append(gpa).append(",\n")
                .append("  courseAttending: ").append(courseAttending != null ? courseAttending.toString() : "null").append(",\n")
                .append("  coursesAttended: [\n");

        if (coursesAttended != null && !coursesAttended.isEmpty()) {
            coursesAttended.forEach(course -> builder.append("    ").append(course.toString()).append(",\n"));
        } else {
            builder.append("    No courses attended\n");
        }

        builder.append("  ]\n}");
        return builder.toString();
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

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public Course getCourseAttending() {
        return courseAttending;
    }

    public void setCourseAttending(Course courseAttending) {
        this.courseAttending = courseAttending;
    }

    public List<Course> getCoursesAttended() {
        return coursesAttended;
    }

    public void setCoursesAttended(List<Course> coursesAttended) {
        this.coursesAttended = coursesAttended;
    }

    public Student() {
    }
}
