package com.sistemaCalificaciones.modelo;


import jakarta.persistence.*;

@Entity
@Table(name = "calificaciones")
public class Calificaciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_calificacion")
    private int califiacionId;

    @ManyToOne
    @JoinColumn(name = "alumno_id")
    private Alumno alumnoId;

    @ManyToOne
    @JoinColumn(name = "materia_id")
    private Materia materiaId;

    private float calificacion;

    public int getCalifiacionId() {
        return califiacionId;
    }

    public void setCalifiacionId(int califiacionId) {
        this.califiacionId = califiacionId;
    }

    public Alumno getAlumnoId() {
        return alumnoId;
    }

    public void setAlumnoId(Alumno alumnoId) {
        this.alumnoId = alumnoId;
    }

    public float getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(float calificacion) {
        this.calificacion = calificacion;
    }

    public Materia getMateriaId() {
        return materiaId;
    }

    public void setMateriaId(Materia materiaId) {
        this.materiaId = materiaId;
    }
}
