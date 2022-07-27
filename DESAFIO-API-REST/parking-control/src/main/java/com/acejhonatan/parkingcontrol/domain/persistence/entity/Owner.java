package com.acejhonatan.parkingcontrol.domain.persistence.entity;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

import static lombok.AccessLevel.PROTECTED;

@Entity
@Table(name = "OWNER")
@NoArgsConstructor(access = PROTECTED)
public class Owner extends Person implements Serializable {

    private static final long serialVersionUID = -2914177047784286706L;

    public Owner(String name, String document) {
        super(name, document);
    }
}
