package Model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "mk_Student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "first_name")
    private String firstname;
    @Column(name = "last_name")
    private String lastname;
    @Column(name = "studentCode")
    private Integer studentcode;
    @Column(name = "birthday")
    @Temporal(TemporalType.DATE)
    private Date birthday;
    @OneToMany(mappedBy = "student")
    private Set<Address> addresses;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "mk_std_tch",
            joinColumns = @JoinColumn(name = "student_id")
            , inverseJoinColumns = @JoinColumn(name = "teacher_ID"))
    private Set<Teacher> teachers;

    public Student(String firstname, String lastname, Integer studentcode, Date birthday,  Set<Teacher> teachers) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.studentcode = studentcode;
        this.birthday = birthday;
//        this.addresses = addresses;
        this.teachers = teachers;
    }

    public Student() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getStudentcode() {
        return studentcode;
    }

    public void setStudentcode(Integer studentcode) {
        this.studentcode = studentcode;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    public Set<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", studentcode=" + studentcode +
                ", birthday=" + birthday +
                ", addresses=" + addresses +
                ", teachers=" + teachers +
                '}';
    }
}
