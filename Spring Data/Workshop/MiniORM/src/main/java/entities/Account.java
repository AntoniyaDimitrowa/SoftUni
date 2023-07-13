package entities;

import orm.annotations.Column;
import orm.annotations.Entity;
import orm.annotations.Id;

import java.time.LocalDate;


@Entity(name = "accounts")
public class Account {

    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;

    @Column(name = "count_of_followers")
    private Integer countOfFollowers;

    @Column(name = "created_on")
    private LocalDate createdOn;

    @Column(name = "last_logged")
    private LocalDate lastLogged;

    @Column(name = "nickname")
    private String nickname;

    public Account(String name, LocalDate createdOn, Integer age) {
        this.name = name;
        this.createdOn = createdOn;
        this.age = age;
    }
}