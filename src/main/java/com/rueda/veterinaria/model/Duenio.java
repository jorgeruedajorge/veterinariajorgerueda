package com.rueda.veterinaria.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Duenio {

    @Id
    private int id;
    private String nombre;
    private int cedula;
    private String correo;
}