package service;

import entity.Course;
import entity.DistanceEducationCourse;
import entity.OnCampusCourse;
import entity.Student;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.util.List;

public class JPQLPracticeService {
    private final PersistenceService ps;

    public JPQLPracticeService(PersistenceService ps) {
        this.ps = ps;
    }

    public void runPracticeTasks() {
        runJPQLQuestions();
    }

    private void runJPQLQuestions() {
        jpqlQ1();
        jpqlQ2();
        jpqlQ3();
        jpqlQ4();
        jpqlQ5(5, 2025);
        jpqlQ6();
        jpqlQ7();
        jpqlQ8();
        jpqlQ9();
        jpqlQ10();
    }

    private void jpqlQ1() {
        String queryString = "SELECT s from Student s where s.gpa > 3.5 AND s.courseAttending.startDate > :date";
        TypedQuery<Student> query = ps.getEntityManager().createQuery(queryString, Student.class);
        query.setParameter("date", LocalDate.now());
        List<Student> students = query.getResultList();
        System.out.println("\n JPQL Q1");
        System.out.println(students);
    }

    private void jpqlQ2() {
        String queryString = "SELECT occ from OnCampusCourse occ where occ.room = 'Room 203'";
        TypedQuery<OnCampusCourse> query = ps.getEntityManager().createQuery(queryString, OnCampusCourse.class);
        List<OnCampusCourse> courses = query.getResultList();
        System.out.println("\n JPQL Q2");
        System.out.println(courses);
    }

    private void jpqlQ3() {
        String queryString = "SELECT s from Student s JOIN s.coursesAttended c GROUP BY s HAVING COUNT(c) > 7";
        TypedQuery<Student> query = ps.getEntityManager().createQuery(queryString, Student.class);
        List<Student> res = query.getResultList();
        System.out.println("\n JPQL Q3");
        System.out.println(res);
    }

    private void jpqlQ4() {
        String queryString = "SELECT c from Course c where c.professor LIKE '%NAJ%'";
        TypedQuery<Course> query = ps.getEntityManager().createQuery(queryString, Course.class);
        List<Course> res = query.getResultList();
        System.out.println("\n JPQL Q4");
        System.out.println(res);
    }

    private void jpqlQ5(int month, int year) {
        String queryString = "SELECT DISTINCT dec from DistanceEducationCourse dec JOIN dec.webinarSessionDates wsd " +
                "where wsd.date >= :startDate AND wsd.date < :endDate";
        LocalDate startDate = LocalDate.of(year, month, 1);
        LocalDate endDate = startDate.plusMonths(1);
        TypedQuery<DistanceEducationCourse> query = ps.getEntityManager().createQuery(queryString,
                DistanceEducationCourse.class);
        query.setParameter("startDate", startDate);
        query.setParameter("endDate", endDate);
        List<DistanceEducationCourse> res = query.getResultList();
        System.out.println("\n JPQL Q5");
        System.out.println(res);
    }

    private void jpqlQ6() {
        String queryString = "SELECT s FROM Student s WHERE s.courseAttending IN (SELECT c FROM " +
                "DistanceEducationCourse c where c.professor = 'Najeeb')";
        TypedQuery<Student> query = ps.getEntityManager().createQuery(queryString, Student.class);
        List<Student> students = query.getResultList();
        System.out.println("\n JPQL Q6");
        System.out.println(students);
    }

    private void jpqlQ7() {
        String queryString = "SELECT COUNT(s) from Student s where TYPE(s.courseAttending) = OnCampusCourse";
        TypedQuery<Long> query = ps.getEntityManager().createQuery(queryString, Long.class);
        Long students = query.getSingleResult();
        System.out.println("\n JPQL Q7");
        System.out.println(students);
    }

    private void jpqlQ8() {
        String queryString = "SELECT s FROM Student s where s.courseAttending IS NULL";
        TypedQuery<Student> query = ps.getEntityManager().createQuery(queryString, Student.class);
        List<Student> students = query.getResultList();
        System.out.println("\n JPQL Q8");
        System.out.println(students);
    }

    private void jpqlQ9() {
        String queryString = "SELECT c FROM Student s JOIN s.coursesAttended c where s.gpa > 3.0";
        TypedQuery<Course> query = ps.getEntityManager().createQuery(queryString, Course.class);
        List<Course> courses = query.getResultList();
        System.out.println("\n JPQL Q9");
        System.out.println(courses);
    }

    private void jpqlQ10() {
        String queryString = "SELECT s from Student s where s.courseAttending.title LIKE '%1%'";
        TypedQuery<Student> query = ps.getEntityManager().createQuery(queryString, Student.class);
        List<Student> students = query.getResultList();
        System.out.println("\n JPQL Q10");
        System.out.println(students);
    }
}
