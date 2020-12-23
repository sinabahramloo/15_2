package Model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;


@Entity
@Table(name = "mk_Teacher")
public class Teacher {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "first_name")
    private String firstname;
    @Column(name = "last_name")
    private String lastname;
    @Column(name = "teacherCode", nullable = false, unique = true)
    private Integer teachercode;
    @Column(name = "salary")
    private double Salary;
    @Column(name = "birthday")
    @Temporal(TemporalType.DATE)
    private Date birthday;
    @OneToOne(mappedBy = "teacher")
    private Address address;
    @ManyToMany(mappedBy = "teachers",cascade = CascadeType.PERSIST)
    private Set<Student> students;

    public Teacher(String firstname, String lastname, Integer teachercode, Double salary, Date birthday, Address address, Set<Student> students) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.teachercode = teachercode ;
        Salary = salary;
        this.birthday = birthday;
        this.address = address;
        this.students = students;
    }

    public Teacher() {
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

    public Integer getTeachercode() {
        return teachercode;
    }

    public void setTeachercode(Integer teachercode) {
        this.teachercode = teachercode;
    }

    public Double getSalary() {
        return Salary;
    }

    public void setSalary(Double salary) {
        Salary = salary;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", teachercode=" + teachercode +
                ", Salary=" + Salary +
                ", birthday=" + birthday +
                ", address=" + address +
                ", students=" + students +
                '}';
    }
}
