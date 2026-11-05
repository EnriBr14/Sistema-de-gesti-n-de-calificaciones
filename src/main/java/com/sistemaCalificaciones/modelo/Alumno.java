package com.sistemaCalificaciones.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "alumnos")
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_alumnos")
    private Integer alumnoId;

    private String matricula;
    private String nombre;
    private String apellidos;

    //Contructor
    public Alumno(){}

    public int getAlumnoId(){return alumnoId;}
    public void setAlumnoId(int alumnoId){this.alumnoId = alumnoId;}

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
}
