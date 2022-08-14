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
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Table(name = "VEHICLE")
@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = PROTECTED)
public class Vehicle implements Serializable {

    private static final long serialVersionUID = -6921603354406530302L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "LICENSE_PLATE", nullable = false, unique = true, length = 7)
    private String licensePlate;

    @Column(name = "BRAND", nullable = false, length = 40)
    private String brand;

    @Column(name = "MODEL", nullable = false, length = 40)
    private String model;

    @Column(name = "COLOR", nullable = false, length = 40)
    private String color;

    @ManyToOne
    @JoinColumn(name = "OWNER_ID")
    private Owner owner;

    public Vehicle(String licensePlate, String brand, String model, String color, Owner owner) {
        this.licensePlate = licensePlate;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.owner = owner;
    }
}
