//package entity;
//
//import jakarta.persistence.*;
//
//import java.time.LocalDate;
//import java.util.List;
//
//@Entity
//@Inheritance(strategy = InheritanceType.JOINED)
//@SecondaryTable(name = "contact_info", pkJoinColumns = @PrimaryKeyJoinColumn(name = "person_id"))
//@DiscriminatorColumn
//public class Person {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long emId;
//    private String name;
//    @Column(table = "contact_info")
//    private String email;
//    @Column(table = "contact_info")
//    private String phone;
//    private LocalDate birthDate;
//
//    @ManyToMany
//    List<Skill> skills;
//
//    public List<Skill> getSkills() {
//        return skills;
//    }
//
//    public void setSkills(List<Skill> skills) {
//        this.skills = skills;
//    }
//
//    @Override
//    public String toString() {
//        return "Person{" +
//                "emId=" + emId +
//                ", name='" + name + '\'' +
//                ", email='" + email + '\'' +
//                ", phone='" + phone + '\'' +
//                ", birthDate=" + birthDate +
//                '}';
//    }
//
//    @Embedded
//    private Address address;
//
//    public Address getAddress() {
//        return address;
//    }
//
//    public void setAddress(Address address) {
//        this.address = address;
//    }
//
//    public Person() {}
//
//    public String getPhone() {
//        return phone;
//    }
//
//    public void setPhone(String phone) {
//        this.phone = phone;
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
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public LocalDate getBirthDate() {
//        return birthDate;
//    }
//
//    public void setBirthDate(LocalDate birthDate) {
//        this.birthDate = birthDate;
//    }
//
////    public List<Address> getAddress() {
////        return address;
////    }
////
////    public void setAddress(List<Address> address) {
////        this.address = address;
////    }
//}
