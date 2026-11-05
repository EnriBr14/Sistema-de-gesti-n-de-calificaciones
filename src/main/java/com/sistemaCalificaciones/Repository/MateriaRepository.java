package com.sistemaCalificaciones.Repository;

import com.sistemaCalificaciones.modelo.Materia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MateriaRepository extends JpaRepository <Materia, Integer> {
}
