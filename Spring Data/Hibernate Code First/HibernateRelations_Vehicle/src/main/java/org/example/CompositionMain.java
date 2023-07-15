package org.example;

import entities.composition.CompositionCar;
import entities.composition.PlateNumber;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class CompositionMain {
    public static void main(String[] args) {
        EntityManager em = Persistence
                .createEntityManagerFactory("relations")
                .createEntityManager();
        em.getTransaction().begin();

        CompositionCar car1 = new CompositionCar("Opel", 6000);
        CompositionCar car2 = new CompositionCar("BMV", 10000);
        PlateNumber number = new PlateNumber("CB4567BC");

        car1.setPlateNumber(number);

        number.setCar(car2);

        em.persist(car1);
        em.persist(number);
        em.persist(car2);



        em.getTransaction().commit();
    }
}
