package Model;

import javax.persistence.*;

@Entity
@Table(name = "mk_Address")
public class Address {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "number",nullable = false,unique = true)
    private Integer number;
    @Column(name = "state")
    private String state;
    @Column(name = "city")
    private String city;
    @Column(name = "postaladdress")
    private String postalAddress;
    @Column(name = "postalcode")
    private Integer postalCode;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "fk_student",nullable = true)
    private Student student;
    @OneToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_teacher")
    private Teacher teacher;

    public Address(Integer number, String state, String city, String postalAddress,Integer postalCode, Student student, Teacher teacher) {
        this.number = number;
        this.state = state;
        this.city = city;
        this.postalAddress = postalAddress;
        this.postalCode = postalCode;
        this.student = student;
        this.teacher = teacher;
    }

    public Address() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(String postalAddress) {
        this.postalAddress = postalAddress;
    }

    public Integer getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", number=" + number +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", postalAddress='" + postalAddress + '\'' +
                ", postalCode=" + postalCode +
                ", student=" + student +
                ", teacher=" + teacher +
                '}';
    }
}
