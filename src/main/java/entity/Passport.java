//package entity;
//
//import jakarta.persistence.*;
//
//import java.time.LocalDate;
//
//@Entity
//public class Passport {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long emId;
//    private String number;
//    private LocalDate issueDate;
//
//    @OneToOne
//    private Person person;
//
//    public Passport() {
//    }
//
//    public Long getEmId() {
//        return emId;
//    }
//
//    public String getNumber() {
//        return number;
//    }
//
//    public void setNumber(String number) {
//        this.number = number;
//    }
//
//    public LocalDate getIssueDate() {
//        return issueDate;
//    }
//
//    public void setIssueDate(LocalDate issueDate) {
//        this.issueDate = issueDate;
//    }
//
//    public Person getPerson() {
//        return person;
//    }
//
//    public void setPerson(Person person) {
//        this.person = person;
//    }
//}
