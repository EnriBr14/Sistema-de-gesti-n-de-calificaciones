package com.sistemaCalificaciones.Repository;

import com.sistemaCalificaciones.modelo.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumnoRepository extends JpaRepository <Alumno, Integer> {


}
