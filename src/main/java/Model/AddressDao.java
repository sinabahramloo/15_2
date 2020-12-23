package Model;

import javax.persistence.EntityManager;

public class AddressDao extends GenericDao<Address, Integer> {
    public AddressDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Address> getentityClass() {
        return Address.class;
    }

}
