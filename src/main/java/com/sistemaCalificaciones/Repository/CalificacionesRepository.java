package com.sistemaCalificaciones.Repository;

import com.sistemaCalificaciones.modelo.Calificaciones;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CalificacionesRepository extends JpaRepository <Calificaciones,Integer> {
    List<Calificaciones> findByAlumnoId_AlumnoId(Integer alumnoId);

    List<Calificaciones> findByMateriaId_MateriaId(Integer matId);
}
