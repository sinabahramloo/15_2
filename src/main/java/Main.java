import Model.*;

import javax.persistence.EntityManager;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import util.JPAUtil;

public class Main {
    private static StudentDao studentDao;
    private static TeacherDao teacherDao;
    private static AddressDao addressDao;
    private static final Integer CHECK_IMP_ID=1;


    private static void deleteAllData(EntityManager entityManager){

    }
    private static void initializeData(){
        if(studentDao.load(CHECK_IMP_ID)==null) {
            Set<Teacher> teachers = new HashSet<>();
            Set<Teacher> teachers2 = new HashSet<>();
            Address address1 = createAddress(1,"state1","city1","adress1",1001);
            Address address2 = createAddress(2,"state1","city1","adress1",1002);
            Teacher teacher1 = createTeacher("Teacher1f","teacher1l",2001,1000.1,new Date(2001,1,1));
            address1.setTeacher(teacher1);
            Teacher teacher2 = createTeacher("Teacher2f","teacher2l",2002,1000.2,new Date(2002,1,1));
            address2.setTeacher(teacher2);
            teachers.add(teacher1);
            teachers.add(teacher2);
            teachers2.add(teacher2);
            Student student1 = createStudent("student1f","student1l",3001,new Date(2005,1,1));
            Student student2 = createStudent("student2f","student2l",3002,new Date(2005,2,2));
            student1.setTeachers(teachers);
            student2.setTeachers(teachers2);
            address1.setStudent(student1);
            address2.setStudent(student2);
        }
    }
    private static Teacher createTeacher(String firstname, String lastname, Integer teachercode, Double salary, Date birthday){
        Teacher teacher=new Teacher();
        teacher.setFirstname(firstname);
        teacher.setLastname(lastname);
        teacher.setBirthday(birthday);
        teacher.setSalary(salary);
        teacher.setTeachercode(teachercode);
        teacherDao.save(teacher);
        return teacher;
    }
    private static Student createStudent(String firstname, String lastname, Integer studentcode,  Date birthday){
        Student student=new Student();
        student.setFirstname(firstname);
        student.setLastname(lastname);
        student.setStudentcode(studentcode);
        student.setBirthday(birthday);
        studentDao.save(student);
        return student;
    }
    private static Address createAddress(Integer number, String state, String city, String postalAddress,Integer postalCode){
        Address address=new Address();
        address.setState(state);
        address.setCity(city);
        address.setNumber(number);
        address.setPostalAddress(postalAddress);
        address.setPostalCode(postalCode);
        addressDao.save(address);
        return address;
    }
    private static void initializeDao(EntityManager entityManager) {
        studentDao=new StudentDao(entityManager);
        addressDao=new AddressDao(entityManager);
        teacherDao =new TeacherDao(entityManager);
    }
    public static void main(String[] args) {
        EntityManager entityManager= JPAUtil.getEntityManagerFactory().createEntityManager();
        initializeDao(entityManager);
        entityManager.getTransaction().begin();
        initializeData();
        entityManager.getTransaction().commit();
        Student student=studentDao.load(CHECK_IMP_ID);
        Teacher teacher=teacherDao.load(CHECK_IMP_ID);
        Address address=addressDao.load(CHECK_IMP_ID);
        System.out.println("before update");
        System.out.println(student.getFirstname()+"  "+student.getLastname());
        System.out.println(teacher.getFirstname()+"  "+teacher.getLastname());
        System.out.println(address.getState()+"  "+address.getCity());
        entityManager.getTransaction().begin();
        student.setFirstname("ali");
        studentDao.update(student);
        teacher.setFirstname("sina");
        teacherDao.update(teacher);
        address.setCity("tehran");
        entityManager.getTransaction().commit();
        System.out.println("after update");
        System.out.println(student.getFirstname()+"  "+student.getLastname());
        System.out.println(teacher.getFirstname()+"  "+teacher.getLastname());
        System.out.println(address.getState()+"  "+address.getCity());
        entityManager.getTransaction().begin();
        studentDao.delete(student);
        teacherDao.delete(teacher);
        addressDao.delete(address);
        entityManager.getTransaction().commit();
        System.out.println();
        entityManager.close();
        JPAUtil.shutdown();

    }
}
