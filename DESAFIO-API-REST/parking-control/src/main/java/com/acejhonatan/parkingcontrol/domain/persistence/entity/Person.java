package com.acejhonatan.parkingcontrol.domain.persistence.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;

import static javax.persistence.GenerationType.TABLE;
import static javax.persistence.InheritanceType.TABLE_PER_CLASS;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Inheritance(strategy = TABLE_PER_CLASS)
@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = PROTECTED)
public abstract class Person {

    @Id
    @GeneratedValue(strategy = TABLE)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME", nullable = false, length = 60)
    private String name;

    @Column(name = "DOCUMENT", nullable = false, unique = true, length = 15)
    private String document;

    public Person(String name, String document) {
        this.name = name;
        this.document = document;
    }
}
