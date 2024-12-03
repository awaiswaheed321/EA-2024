package service;

import entity.task1.Course;
import entity.task1.Student;

import java.util.Arrays;

public class Task1Service {
    private final PersistenceService ps;

    public Task1Service(PersistenceService ps) {
        this.ps = ps;
    }

    public void runTask1() {
        Course ea = new Course();
        ea.setTitle("Enterprise Architecture");
        ea.setCourseNumber("CS544");
        ea.setCapacity(20);
        ea.setRoomNumber(10);
        Student student1 = new Student("Tom Hide", 30, ea);
        Student student2 = new Student("John Doe", 35, ea);
        ea.setStudents(Arrays.asList(student1, student2));

        Course waa = new Course();
        waa.setTitle("Web Application Architecture");
        waa.setCourseNumber("CS545");
        waa.setCapacity(18);
        waa.setRoomNumber(12);
        Student student3 = new Student("Jill Newman", 25, waa);
        Student student4 = new Student("Henry Oxford", 28, waa);
        waa.setStudents(Arrays.asList(student3, student4));

        saveCourse(ea);
        saveCourse(waa);

        Course savedEa = getCourse(ea.getEmId());
        Course savedWaa = getCourse(waa.getEmId());
        System.out.println(savedEa);
        System.out.println(savedWaa);
    }

    private void saveCourse(Course course) {
        ps.startTransaction();
        ps.getEntityManager().persist(course);
        ps.endTransaction();
    }

    private Course getCourse(Long id) {
        ps.startTransaction();
        Course course = ps.getEntityManager().find(Course.class, id);
        ps.endTransaction();
        return course;
    }
}
