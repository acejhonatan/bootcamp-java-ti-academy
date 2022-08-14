package com.acejhonatan.parkingcontrol.domain.persistence.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Table(name = "APARTMENT")
@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = PROTECTED)
public class Apartment implements Serializable {

    private static final long serialVersionUID = -7084804058979300490L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NUMBER", nullable = false, unique = true, length = 15)
    private String number;

    @OneToOne
    @JoinColumn(name = "OWNER_ID", unique = true)
    private Owner owner;

    public Apartment(String number, Owner owner) {
        this.number = number;
        this.owner = owner;
    }
}
