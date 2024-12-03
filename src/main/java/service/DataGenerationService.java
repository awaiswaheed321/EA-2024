package service;

import entity.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DataGenerationService {
    private final PersistenceService ps;

    public DataGenerationService(PersistenceService ps) {
        this.ps = ps;
    }

    public void createData() {
        createCoursesAndStudents();
    }

    private void createCoursesAndStudents() {
        ps.startTransaction();
        List<Course> courses = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            OnCampusCourse onCampusCourse = getOnCampusCourse(i);
            DistanceEducationCourse distanceEducationCourse = getDistanceEducationCourse(i);
            if (i % 2 != 0) {
                onCampusCourse.setCapacity(35 + i);
            }
            ps.getEntityManager().persist(onCampusCourse);
            ps.getEntityManager().persist(distanceEducationCourse);
            courses.add(onCampusCourse);
            courses.add(distanceEducationCourse);
        }
        for (int i = 1; i <= 10; i++) {
            Student student = getStudent(courses, i);
            if (i % 3 == 0) {
                student.setCoursesAttended(courses.subList(0, Math.min(9, courses.size())));
            }
            if (i % 4 == 0) {
                student.setCourseAttending(null);
            }

            ps.getEntityManager().persist(student);
        }
        ps.endTransaction();
        System.out.println("Courses and students created successfully!");
    }

    private Student getStudent(List<Course> courses, int studentIndex) {
        Student student = new Student();
        student.setName("Student " + studentIndex);
        student.setGpa((studentIndex % 2 == 0) ? 3.2f + (studentIndex * 0.1f) : 2.8f - (studentIndex * 0.05f));
        student.setCourseAttending(courses.get(studentIndex % courses.size()));
        student.setCoursesAttended(courses.subList(0, Math.min(3, courses.size())));
        return student;
    }

    private DistanceEducationCourse getDistanceEducationCourse(int index) {
        DistanceEducationCourse distanceEducationCourse = new DistanceEducationCourse();
        distanceEducationCourse.setTitle("Distance Education Course " + index);
        distanceEducationCourse.setProfessor(index == 2 ? "Najeeb" : "Professor D" + index);
        distanceEducationCourse.setStartDate(LocalDate.of(2025, 2, index));
        distanceEducationCourse.setExamProfessor("Exam Professor D" + index);
        distanceEducationCourse.setWebinarSessionDates(List.of(
                new WebinarSessionDate(LocalDate.of(2025, 2, index)),
                new WebinarSessionDate(LocalDate.of(2025, 5, index))
        ));
        return distanceEducationCourse;
    }

    private OnCampusCourse getOnCampusCourse(int index) {
        OnCampusCourse onCampusCourse = new OnCampusCourse();
        onCampusCourse.setTitle("On Campus Course " + index);
        onCampusCourse.setCapacity((index % 2 == 0) ? 20 + index : 40 + index);
        onCampusCourse.setRoom("Room " + (200 + index));
        onCampusCourse.setStartDate(LocalDate.of(2025, 1, index));
        onCampusCourse.setProfessor("Professor C" + index);
        return onCampusCourse;
    }
}
