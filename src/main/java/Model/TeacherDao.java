package Model;

import javax.persistence.EntityManager;

public class TeacherDao extends GenericDao<Teacher, Integer> {
    public TeacherDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Teacher> getentityClass() {
        return Teacher.class;
    }

}
