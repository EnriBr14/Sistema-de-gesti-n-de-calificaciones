package com.sistemaCalificaciones.Controller;


import com.sistemaCalificaciones.Repository.CalificacionesRepository;
import com.sistemaCalificaciones.modelo.Calificaciones;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Tag(name = "Calificaciones", description = "Operaciones para administrar calificaiones")
@RestController
@RequestMapping("/calificaciones/api")
public class CalificacionesController {

    @Autowired
    private CalificacionesRepository calificacionesRepository;

    //---------------------Metodo para traer calificaciones por alumno
    @GetMapping("/alumnoBuscar/{id}")
    @Operation(
            summary = "Consulta calificaciones",
            description = "Consulta las calificaciones de un alumno por su identificador"
    )
    @ApiResponse(responseCode = "200", description = "Encontrado")
    @ApiResponse(responseCode = "404", description = "No encontrado")
    public List<Calificaciones> buscar(@PathVariable("id") Integer matId){
        return calificacionesRepository.findByAlumnoId_AlumnoId(matId);
    }

    //---------------------Metodo para traer calificaciones por materia
   @GetMapping("/cali/materia/{id}")
   public List<Calificaciones> calificaciones(@PathVariable("id") Integer id) {
        List<Calificaciones> lista = calificacionesRepository.findByMateriaId_MateriaId(id);
        return lista;
   }


    //---------------------Metodo Patch
    @PatchMapping("/modificar/{id}")
    @Operation(
            summary = "Modificar registro",
            description = "Modifica la calificacion de un alumno"
    )
    @ApiResponse(responseCode = "200", description = "Calificación modificada")
    @ApiResponse(responseCode = "404", description = "No se realizo el cambio")
    public Calificaciones modiCali(@PathVariable("id") Integer id,@RequestBody Calificaciones cali){
        Calificaciones ca = calificacionesRepository.findById(id).orElse(null);
        if(ca == null){
            return null;
        }
        if(cali.getAlumnoId() != null){
         ca.setAlumnoId(cali.getAlumnoId());
        }
        if(cali.getMateriaId() != null){
            ca.setMateriaId(cali.getMateriaId());
            ca.setCalificacion(cali.getCalificacion());
        }
        return ca;




    }

    //---------------------Save
    @PostMapping("/guardar")
    @Operation(
            summary = "Guarda un nuevo registro",
            description = "Guarda la información de una calificación"
    )
    @ApiResponse(responseCode = "200", description = "Calificación guardado")
    @ApiResponse(responseCode = "404", description = "calificación no guardado")
    public Calificaciones saveCalificacion (@RequestBody Calificaciones ca){
        return calificacionesRepository.save(ca);
    }
    //---------------------Metodo Delete

    @DeleteMapping("/delete/{id}")
    @Operation(
            summary = "Eliminar registro",
            description = "Elimina un registro existente utilizando su identificador"
    )
    @ApiResponse(responseCode = "200", description = "Calificación eliminada")
    @ApiResponse(responseCode = "400", description = "Calificación no encontrada")
    public void deleteCalificacion (@PathVariable("id") Integer id){
        calificacionesRepository.deleteById(id);
    }



}
