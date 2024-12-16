//package entity;
//
//import jakarta.persistence.*;
//
//import java.util.List;
//
//@Entity
//public class Skill {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long emId;
//
//    private String name;
//    private String level;
//
//    @ManyToMany(mappedBy = "skills")
//    private List<Person> persons;
//
//    public Skill() {}
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
//    public String getLevel() {
//        return level;
//    }
//
//    public void setLevel(String level) {
//        this.level = level;
//    }
//
//    public List<Person> getPersons() {
//        return persons;
//    }
//
//    public void setPersons(List<Person> persons) {
//        this.persons = persons;
//    }
//}
