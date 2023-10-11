package com.Alojamientos.alojamientos.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "alojamientos")
@Data
public class Alojamiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name="name")
    String name;

    @Column(name="description")
    String description;

    @Column(name="phone")
    Long phone;

    @Column(name="photo")
    String photo;


}