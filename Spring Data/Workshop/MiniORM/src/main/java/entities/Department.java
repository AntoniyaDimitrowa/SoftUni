package entities;

import orm.annotations.Column;
import orm.annotations.Entity;
import orm.annotations.Id;

@Entity(name = "departments")
public class Department {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;
}
