package Model;

import javax.persistence.EntityManager;

public class StudentDao extends GenericDao<Student, Integer> {
    public StudentDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Student> getentityClass() {
        return Student.class;
    }
}
