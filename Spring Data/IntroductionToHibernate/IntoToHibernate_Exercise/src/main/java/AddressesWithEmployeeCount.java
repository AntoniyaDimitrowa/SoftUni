import entities.Address;

import javax.persistence.EntityManager;

public class AddressesWithEmployeeCount {
    public static void main(String[] args) {
        Utils.createEntityManager().createQuery("FROM Address ORDER BY employees.size DESC", Address.class)
                .setMaxResults(10)
                .getResultList()
                .forEach(Address::printAddressTextTownNameAndEmployeeCount);
    }
}
