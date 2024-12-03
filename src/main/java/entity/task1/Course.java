package entity.task1;

import jakarta.persistence.*;

import java.util.List;

@Entity
@SecondaryTable(
        name = "room_numbers",
        pkJoinColumns = @PrimaryKeyJoinColumn(name = "course_id", referencedColumnName = "emId")
)
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long emId;

    private String title;
    private int capacity;

    @Column(name = "CODE")
    private String courseNumber;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Student> students;

    @Column(table = "room_numbers", name = "room_number")
    @Basic(optional = false)
    private int roomNumber;

    public Course() {}

    public Course(String title, int capacity, String courseNumber, List<Student> students, int roomNumber) {
        this.title = title;
        this.capacity = capacity;
        this.courseNumber = courseNumber;
        this.students = students;
        this.roomNumber = roomNumber;
    }

    @Override
    public String toString() {
        return "Course{" +
                "emId=" + emId +
                ", title='" + title + '\'' +
                ", capacity=" + capacity +
                ", courseNumber='" + courseNumber + '\'' +
                ", students=" + students +
                ", roomNumber=" + roomNumber +
                '}';
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

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }
}
