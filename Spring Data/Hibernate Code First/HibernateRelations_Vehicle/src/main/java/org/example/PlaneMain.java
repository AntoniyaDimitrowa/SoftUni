package org.example;

import entities.composition.Company;
import entities.composition.CompositionPlane;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class PlaneMain {
    public static void main(String[] args) {
        EntityManager em = Persistence
                .createEntityManagerFactory("relations")
                .createEntityManager();
        em.getTransaction().begin();

        Company company = new Company("with planes new2");

//        CompositionPlane plane6 = em.find(CompositionPlane.class, 6);
//        CompositionPlane plane7 = em.find(CompositionPlane.class, 7);
//        CompositionPlane plane8 = em.find(CompositionPlane.class, 8);

        CompositionPlane new1 = new CompositionPlane("asda", 12);
        CompositionPlane new2 = new CompositionPlane("sadas", 14);

        List<CompositionPlane> fleet = new ArrayList<>();
        fleet.add(new1);
        fleet.add(new2);

        company.setPlanes(fleet);

        em.persist(company);
        em.getTransaction().commit();
    }
}
