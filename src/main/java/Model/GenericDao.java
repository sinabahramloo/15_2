package Model;

import javax.persistence.EntityManager;

public abstract class GenericDao<T,U> {
    private EntityManager entityManager;
//    private final Class<T> entityClass;
    public GenericDao(EntityManager entityManager) {
        this.entityManager = entityManager;
//        this.entityClass= entityClass;
    }
    public  void save(T e){
        entityManager.persist(e );
//        beforeMerge();
    }
    public void beforeSave(){

    }
    public  T load(U id){
        return entityManager.find(getentityClass(),id);
    }

    public void beforeMerge(){

    }
    public void delete(T e){
        entityManager.remove(e);

    }
    public void update(T e){
        entityManager.merge(e);
    }
    public abstract Class<T> getentityClass();
}
