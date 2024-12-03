package service;

import entity.*;
import jakarta.persistence.Tuple;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CriteriaApiPracticeService {
    private final PersistenceService ps;

    public CriteriaApiPracticeService(PersistenceService ps) {
        this.ps = ps;
    }

    public void runCriteriaApiPractice() {
        caQ1();
        caQ2();
        caQ3();
        caQ4();
        caQ5();
        caQ6();
        caQ7();
        caQ8();
        caQ9();
        caQ10();
    }

    private void caQ10() {
        CriteriaBuilder builder = ps.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Student> cq = builder.createQuery(Student.class);
        Root<Student> root = cq.from(Student.class);

        Join<Student, Course> courseJoin = root.join("courseAttending");
        Predicate profNamePredicate = builder.like(courseJoin.get("professor"), "Na%");
        cq.select(root).where(profNamePredicate);

        TypedQuery<Student> q = ps.getEntityManager().createQuery(cq);
        List<Student> students = q.getResultList();
        System.out.println("\ncaQ10");
        System.out.println(students);
    }

    private void caQ9() {
        CriteriaBuilder builder = ps.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<OnCampusCourse> cq = builder.createQuery(OnCampusCourse.class);
        Root<OnCampusCourse> root = cq.from(OnCampusCourse.class);
        cq.select(root);

        Predicate roomPredicate = builder.like(root.get("room"), "%31%");

        cq.where(roomPredicate);
        TypedQuery<OnCampusCourse> q = ps.getEntityManager().createQuery(cq);
        List<OnCampusCourse> list = q.getResultList();
        System.out.println("\ncaQ9");
        System.out.println(list);
    }

    private void caQ8() {
        CriteriaBuilder builder = ps.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Course> cq = builder.createQuery(Course.class);
        Root<Student> root = cq.from(Student.class);

        Join<Student, Course> courseJoin = root.join("coursesAttended");
        Predicate gpaPredicate = builder.greaterThan(root.get("gpa"), 3.5);

        cq.where(gpaPredicate);
        cq.select(courseJoin).distinct(true).orderBy(builder.asc(courseJoin.get("emId")));
        TypedQuery<Course> query = ps.getEntityManager().createQuery(cq);
        List<Course> courses = query.getResultList();
        System.out.println("\ncaQ8");
        System.out.println(courses);
    }

    private void caQ7() {
        CriteriaBuilder builder = ps.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Student> cq = builder.createQuery(Student.class);
        Root<Student> root = cq.from(Student.class);
        cq.select(root);

        Predicate coursePredicate = builder.isNull(root.get("courseAttending"));
        Predicate gpaPredicate = builder.lessThan(root.get("gpa"), 3.2);

        cq.where(coursePredicate, gpaPredicate);

        TypedQuery<Student> q = ps.getEntityManager().createQuery(cq);
        List<Student> res = q.getResultList();
        System.out.println("\ncaQ7");
        System.out.println(res);

    }

    private void caQ6() {
        CriteriaBuilder builder = ps.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Tuple> cq = builder.createTupleQuery();
        Root<DistanceEducationCourse> root = cq.from(DistanceEducationCourse.class);

        // Join the webinar session dates
        Join<DistanceEducationCourse, WebinarSessionDate> dateJoin = root.join("webinarSessionDates", JoinType.LEFT);

        // Create a distinct count expression
        Expression<Long> countExpression = builder.countDistinct(dateJoin.get("emId"));

        // Select the DistanceEducationCourse and count of distinct session dates
        cq.multiselect(root, countExpression).groupBy(root).having(builder.greaterThan(countExpression, 3L));

        // Execute the query
        TypedQuery<Tuple> query = ps.getEntityManager().createQuery(cq);
        List<Tuple> resultList = query.getResultList();

        // Extract the courses from the result
        List<DistanceEducationCourse> courses = new ArrayList<>();
        for (Tuple tuple : resultList) {
            DistanceEducationCourse course = tuple.get(root);
            courses.add(course);
        }

        // Print the results
        System.out.println("\ncaQ6");
        System.out.println(courses);
    }


    private void caQ5() {
        CriteriaBuilder builder = ps.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<String> cq = builder.createQuery(String.class);
        Root<Student> root = cq.from(Student.class);

        Join<Student, Course> courseJoin = root.join("coursesAttended");

        Expression<Long> countExpression = builder.count(courseJoin);
        cq.select(root.get("name")).groupBy(root.get("name")).having(builder.greaterThan(countExpression, 5L));

        TypedQuery<String> query = ps.getEntityManager().createQuery(cq);
        List<String> students = query.getResultList();
        System.out.println("\ncaQ5");
        System.out.println(students);
    }

    private void caQ4() {
        CriteriaBuilder builder = ps.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Course> cq = builder.createQuery(Course.class);
        Root<Course> root = cq.from(Course.class);
        cq.select(root);

        Predicate datePredicate = builder.greaterThan(root.get("startDate"), LocalDate.of(2025, 3, 9));
        cq.where(datePredicate);

        TypedQuery<Course> query = ps.getEntityManager().createQuery(cq);
        List<Course> courses = query.getResultList();
        System.out.println("\ncaQ4");
        System.out.println(courses);
    }

    private void caQ1() {
        CriteriaBuilder builder = ps.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Student> cq = builder.createQuery(Student.class);
        Root<Student> root = cq.from(Student.class);
        cq.select(root);

        Predicate gpaPredicate = builder.greaterThan(root.get("gpa"), 3.0);
        Predicate coursePredicate = builder.isNotNull(root.get("courseAttending"));
        cq.where(builder.and(gpaPredicate, coursePredicate));

        TypedQuery<Student> query = ps.getEntityManager().createQuery(cq);
        List<Student> students = query.getResultList();
        System.out.println("\n caQ1");
        System.out.println(students);
    }

    private void caQ2() {
        CriteriaBuilder builder = ps.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<OnCampusCourse> cq = builder.createQuery(OnCampusCourse.class);
        Root<OnCampusCourse> root = cq.from(OnCampusCourse.class);
        cq.select(root);

        Predicate capacityPredicate = builder.lessThan(root.get("capacity"), 30);
        cq.where(builder.and(capacityPredicate));

        TypedQuery<OnCampusCourse> query = ps.getEntityManager().createQuery(cq);
        List<OnCampusCourse> courses = query.getResultList();
        System.out.println("\n caQ2");
        System.out.println(courses);
    }

    private void caQ3() {
        CriteriaBuilder builder = ps.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Student> cq = builder.createQuery(Student.class);
        Root<Student> root = cq.from(Student.class);
        cq.select(root);

        Join<Student, Course> courseJoin = root.join("courseAttending");

        Predicate profNamePredicate = builder.equal(courseJoin.get("professor"), "Najeeb");
        Predicate dePredicate = builder.equal(builder.literal(DistanceEducationCourse.class), courseJoin.type());
        cq.where(builder.and(profNamePredicate, dePredicate));

        TypedQuery<Student> query = ps.getEntityManager().createQuery(cq);
        List<Student> students = query.getResultList();
        System.out.println("\n caQ3");
        System.out.println(students);
    }
}
