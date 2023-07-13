import entities.Town;

import javax.persistence.EntityManager;
import java.util.List;

public class ChangeCasing {
    public static void main(String[] args) {
        final EntityManager em = Utils.createEntityManager();
        em.getTransaction().begin();

        List<Town> allTowns = em.createQuery("FROM Town", Town.class).getResultList();

        for (Town t : allTowns) {
            if (t.getName().length() > 5) {
                em.detach(t);
                continue;
            }
            t.setName(t.getName().toUpperCase());
            em.persist(t);
        }

        em.getTransaction().commit();
        em.close();
    }
}
