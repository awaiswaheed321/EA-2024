package service;

import entity.Course;
import entity.Student;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.util.List;

public class NamedQueryPracticeService {
    private final PersistenceService ps;

    public NamedQueryPracticeService(PersistenceService ps) {
        this.ps = ps;
    }

    public void runPracticeQuestions() {
        nqQ1();
        nqQ2();
        nqQ3();
        nqQ4();
        nqQ5();
        nqQ6();
        nqQ7();
        nqQ8();
    }

    private void nqQ1() {
        TypedQuery<Student> query = ps.getEntityManager().createNamedQuery("Student.TopPerformers", Student.class);
        List<Student> students = query.getResultList();
        System.out.println("\nnqQ1");
        System.out.println(students);
    }

    private void nqQ2() {
        TypedQuery<Course> query = ps.getEntityManager().createNamedQuery("Course.CoursesByProfessor", Course.class);
        query.setParameter("name", "Najeeb");
        List<Course> courses = query.getResultList();
        System.out.println("\nnqQ2");
        System.out.println(courses);
    }

    private void nqQ3() {
        TypedQuery<Course> query = ps.getEntityManager().createNamedQuery("OnCampusCourse.PopularCourses",
                Course.class);
        List<Course> courses = query.getResultList();
        System.out.println("\nnqQ3");
        System.out.println(courses);
    }

    private void nqQ4() {
        TypedQuery<Student> query = ps.getEntityManager().createNamedQuery("Student.AvailableStudents", Student.class);
        List<Student> students = query.getResultList();
        System.out.println("\nnqQ4");
        System.out.println(students);
    }

    private void nqQ5() {
        TypedQuery<Student> query = ps.getEntityManager().createNamedQuery("Student.CompletedCourses", Student.class);
        List<Student> students = query.getResultList();
        System.out.println("\nnqQ5");
        System.out.println(students);
    }

    private void nqQ6() {
        TypedQuery<Course> query = ps.getEntityManager().createNamedQuery("DistanceEducationCourse.UpcomingWebinars",
                Course.class);
        LocalDate startDate = LocalDate.of(2025, 5, 1);
        LocalDate endDate = startDate.plusDays(7);
        query.setParameter("startDate", startDate);
        query.setParameter("endDate", endDate);
        List<Course> courses = query.getResultList();
        System.out.println("\nnqQ6");
        System.out.println(courses);
    }

    private void nqQ7() {
        TypedQuery<Student> query = ps.getEntityManager().createNamedQuery("Student.LowPerformers", Student.class);
        List<Student> students = query.getResultList();
        System.out.println("\nnqQ7");
        System.out.println(students);
    }

    private void nqQ8() {
        TypedQuery<Course> query = ps.getEntityManager().createNamedQuery("OnCampusCourse.RoomAssignments", Course.class);
        List<Course> courses = query.getResultList();
        System.out.println("\nnqQ8");
        System.out.println(courses);
    }
}
