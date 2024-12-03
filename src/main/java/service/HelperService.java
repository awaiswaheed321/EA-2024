package service;

import entity.Course;
import entity.DistanceEducationCourse;
import entity.Student;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;

import java.util.List;

public class HelperService {
    private final PersistenceService ps;

    public HelperService(PersistenceService ps) {
        this.ps = ps;
    }

    public void runTasks() {
        jpqlTask();
        namedQueryTask();
        criteriaQueryTask();
        updateStudentToCheckVersion();
    }

    private void jpqlTask() {
        String query = "SELECT s from Student s where s.gpa > 3.5 AND s.courseAttending IN (SELECT c from " +
                "OnCampusCourse c where c.capacity > 30)";
        TypedQuery<Student> studentTypedQuery = ps.getEntityManager().createQuery(query, Student.class);
        List<Student> resultList = studentTypedQuery.getResultList();
        System.out.println("\n\nJPQL Task");
        System.out.println(resultList);
    }

    private void namedQueryTask() {
        TypedQuery<Student> studentNamedQuery = ps.getEntityManager().createNamedQuery("Student.canGraduate",
                Student.class);
        List<Student> resultList = studentNamedQuery.getResultList();
        System.out.println("\n\nNamed Query Task");
        System.out.println(resultList);
    }

    private void criteriaQueryTask() {
        CriteriaBuilder cb = ps.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Student> criteriaQuery = cb.createQuery(Student.class);
        Root<Student> root = criteriaQuery.from(Student.class);

        criteriaQuery.select(root);

        Predicate gpaPredicate = cb.lessThan(root.get("gpa"), 3.0);
        Join<Student, Course> courseJoin = root.join("courseAttending");
        Predicate typePredicate = cb.equal(cb.literal(DistanceEducationCourse.class), courseJoin.type());
        Predicate professorNamePredicate = cb.equal(courseJoin.get("professor"), "Najeeb");

        criteriaQuery.where(cb.and(gpaPredicate, typePredicate, professorNamePredicate));

        TypedQuery<Student> studentTypedQuery = ps.getEntityManager().createQuery(criteriaQuery);
        List<Student> resultList = studentTypedQuery.getResultList();

        System.out.println("\n\nCriteria Query Task");
        System.out.println(resultList);
    }

    private void updateStudentToCheckVersion() {
        Student student = ps.getEntityManager().find(Student.class, 1L);
        ps.startTransaction();
        student.setName("Updated name");
        ps.endTransaction();
        Student student2 = ps.getEntityManager().find(Student.class, 1L);
        System.out.println("\nUpdated Student to check Versioning");
        System.out.println(student2);
    }

}
