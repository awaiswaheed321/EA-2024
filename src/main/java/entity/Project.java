//package entity;
//
//import jakarta.persistence.*;
//
//import java.time.LocalDate;
//import java.util.List;
//
//@Entity
//public class Project {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long emId;
//    private String name;
//    private LocalDate startDate;
//    private LocalDate endDate;
//
//    @ManyToMany
//    private List<Person> persons;
//
//    @ManyToMany
//    private List<Skill> skills;
//
//    public Project() {
//    }
//
//    public Long getEmId() {
//        return emId;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public LocalDate getStartDate() {
//        return startDate;
//    }
//
//    public void setStartDate(LocalDate startDate) {
//        this.startDate = startDate;
//    }
//
//    public LocalDate getEndDate() {
//        return endDate;
//    }
//
//    public void setEndDate(LocalDate endDate) {
//        this.endDate = endDate;
//    }
//
//    public List<Person> getPersons() {
//        return persons;
//    }
//
//    public void setPersons(List<Person> persons) {
//        this.persons = persons;
//    }
//
//    public List<Skill> getSkills() {
//        return skills;
//    }
//
//    public void setSkills(List<Skill> skills) {
//        this.skills = skills;
//    }
//}
