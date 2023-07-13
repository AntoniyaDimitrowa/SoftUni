import entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure();
        SessionFactory sessionFactory =
                cfg.buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Student student = new Student("Pesho", 15);
        session.save(student);

        Student student1 = session.get(Student.class, 2);
        System.out.println(student1);

        List<Student> allStudents = session
                .createQuery("FROM Student AS s WHERE s.name = 'Pesho'", Student.class)
                .stream().toList();

        session.getTransaction().commit();
        session.close();
    }
}
