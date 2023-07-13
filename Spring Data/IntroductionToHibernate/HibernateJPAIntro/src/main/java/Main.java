import entities.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("hibernate-jpa");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Student student = new Student("Karina", 12, "School1");
        em.persist(student);
//
//        student.setName("Coco");
//        em.persist(student);

//        Student findFirstStudent = em.find(Student.class, 2);
//        em.remove(findFirstStudent);

//        System.out.println(findFirstStudent.getId());

        List<Student> allStudents = em
                .createQuery("FROM Student", Student.class)
                .getResultList();

        allStudents.forEach(s -> System.out.println(s));

        em.getTransaction().commit();
    }
}

