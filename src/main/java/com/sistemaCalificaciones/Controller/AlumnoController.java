package com.sistemaCalificaciones.Controller;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import com.sistemaCalificaciones.Repository.AlumnoRepository;
import com.sistemaCalificaciones.Repository.CalificacionesRepository;
import com.sistemaCalificaciones.Repository.MateriaRepository;
import com.sistemaCalificaciones.modelo.Alumno;
import com.sistemaCalificaciones.modelo.Calificaciones;
import com.sistemaCalificaciones.modelo.Materia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name = "Alumnos", description = "Operaciones para administrar alumnos")
@RestController
@RequestMapping("/api/alumnos")

public class AlumnoController {

    @Autowired
    private AlumnoRepository alumnoRepository;
    @Autowired
    private CalificacionesRepository calificacionesRepository;
    @Autowired
    private MateriaRepository materiaRepository;
//----------------------------------Metodo Get
    @GetMapping("/todo")
    @Operation(
            summary = "Trae todos los registros ",
            description = "Consulta todos los registros de los alumnos guardados"
    )
    @ApiResponse(responseCode = "200", description = "Alumno encontrado")
    @ApiResponse(responseCode = "404", description = "Alumno no encontrado")
    public List<Alumno> listas(){
        List<Alumno> alumnos =  alumnoRepository.findAll();
        return alumnos;
    }

    //----------------------------------Metodo Join
    @GetMapping("/alumno/{id}")
    @Operation(
            summary = "Consulta calificaciones",
            description = "trae todas las calificaciones asociadas a un alumno"
    )
    @ApiResponse(responseCode = "200", description = "Alumno encontrado")
    @ApiResponse(responseCode = "404", description = "Alumno no encontrado")
    public List<Calificaciones> obtenerCalificacionesPorAlumno(
            @PathVariable ("id")Integer alumnoId) {

        return calificacionesRepository.findByAlumnoId_AlumnoId(alumnoId);
    }
    //----------------------------------Metodo Post
    @PostMapping("/alumno/post")
    @Operation(
            summary = "Guarda un nuevo registro",
            description = "Guarda la información de un nuevo alumno"
    )
    @ApiResponse(responseCode = "200", description = "Alumno guardado")
    @ApiResponse(responseCode = "404", description = "Alumno no guardado")
    public Alumno saveAlumno(@RequestBody Alumno a){
        return alumnoRepository.save(a);
    }


    //----------------------------------Metodo Put
    @PutMapping("/alumno/modificar/{id}")
    @Operation(
            summary = "Actualizar registro",
            description = "Actualiza toda la información de un registro existente mediante su identificador"
    )
    @ApiResponse(responseCode = "200", description = "Alumno actualizado")
    @ApiResponse(responseCode = "404", description = "Alumno no encontrado")
    public Alumno modificarAlumno(@PathVariable Integer id, @RequestBody Alumno a){
        Alumno alu = alumnoRepository.findById(id).orElse(null);
        if(alu == null){
            return null;
        }
        alu.setMatricula(a.getMatricula());
        alu.setNombre(a.getNombre());
        alu.setApellidos(a.getApellidos());
        return alumnoRepository.save(alu);
    }


    //----------------------------------Metodo Patch
    @PatchMapping("/alumno/soloModificar/{id}")
    @Operation(
            summary = "Actualizar parcialmente un registro",
            description ="Modifica uno o varios campos de un registro existente sin reemplazar toda su información"
    )
    @ApiResponse(responseCode = "200", description = "Alumno actualizado")
    @ApiResponse(responseCode = "404", description = "Alumno no encontrado")
    public Alumno modificarCampos(@PathVariable Integer id, @RequestBody Alumno alumno){
        Alumno alu = alumnoRepository.findById(id).orElse(null);
        if(alu == null){
            return null;
        }
        if(alumno.getMatricula() != null){
            alu.setMatricula(alumno.getMatricula());
        }
        if(alumno.getNombre() != null){
            alu.setNombre(alumno.getNombre());
        }
        if(alumno.getApellidos() != null){
            alu.setApellidos(alumno.getApellidos());
        }
        return alumnoRepository.save(alu);
    }


    //----------------------------------Metodo Delete
    @DeleteMapping("/alumno/delete/{id}")
    @Operation(
            summary = "Eliminar registro",
            description = "Elimina un registro existente utilizando su identificador"
    )
    @ApiResponse(responseCode = "200", description = "Alumno eliminado")
    @ApiResponse(responseCode = "404", description = "Alumno no encontrado")
    public void deteleAlumno(@PathVariable Integer id){
        alumnoRepository.deleteById(id);
    }


    //----------------------------------Metodo GETporID
    @GetMapping("/alumnoBuscar/{id}")
    @Operation(
            summary = "Buscar alumno por ID",
            description = "Busca un alumno utilizando su identificador"
    )
    @ApiResponse(responseCode = "200", description = "Alumno encontrado")
    @ApiResponse(responseCode = "404", description = "Alumno no encontrado")
    public  Alumno buscarAlumno(@PathVariable("id")Integer alum){

        return alumnoRepository.findById(alum).orElse(null);
    }




}
