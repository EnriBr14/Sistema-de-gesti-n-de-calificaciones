package com.sistemaCalificaciones.Controller;


import com.sistemaCalificaciones.Repository.MateriaRepository;
import com.sistemaCalificaciones.modelo.Calificaciones;
import com.sistemaCalificaciones.modelo.Materia;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@Tag(name = "Materias", description = "Operaciones para administrar materias")
@RequestMapping("/materias/api")
public class MateriasController {

    @Autowired
    private MateriaRepository materiasRepository;

    //---------------------Metodo Get all
    @GetMapping("cali/todo")
    @Operation(
            summary = "Trae todos los registros ",
            description = "Consulta todos los registros de las calificaciones"
    )
    @ApiResponse(responseCode = "200", description = "Encontrado")
    @ApiResponse(responseCode = "404", description = "No encontrado")
    public List<Materia> listaMaterias() {
        return materiasRepository.findAll();
    }

    //---------------------Metodo GetById
    @GetMapping("cali/{id}")
    @Operation(
            summary = "Consulta materia por ID",
            description = "Consulta la informacion de materias especificas por ID"
    )
    @ApiResponse(responseCode = "200", description = "Encontrado")
    @ApiResponse(responseCode = "404", description = "No encontrado")
    public Materia buscarPorId(@PathVariable("id") Integer id) {
        Materia materia = materiasRepository.findById(id).orElse(null);
        if (materia == null) {
            return null;
        }
        return materia;
    }

    //---------------------Metodo Patch
    @PatchMapping("/materia/{id}")
    @Operation(
            summary = "Actualizar parcialmente un registro",
            description = "Modifica uno o varios campos de un registro existente sin reemplazar toda su información"
    )
    @ApiResponse(responseCode = "200", description = "Actualizado")
    @ApiResponse(responseCode = "404", description = "No se pudo actualizar la información")
    public Materia consultaDatos(@PathVariable("id") Integer id,@RequestBody Materia ma) {

        Materia materia = materiasRepository.findById(id).orElse(null);
        if (materia == null) {
            return null;
        }
        if (ma.getClave() != null) {
            materia.setClave(ma.getClave());
        }
        if (ma.getNombreMateria() != null) {
            materia.setNombreMateria(ma.getNombreMateria());
        }
        return materiasRepository.save(materia);
    }

    //---------------------Metodo Post
    @PostMapping
    @Operation(
            summary = "Guarda un registro",
            description = "Guarda la informacion de una nueva materia"
    )
    @ApiResponse(responseCode = "200", description = "Guardado")
    @ApiResponse(responseCode = "404", description = "No se guardo la información")
    public Materia guardarMateria(@RequestBody Materia ma) {
        return materiasRepository.save(ma);
    }


//---------------------Metodo Delete
    @DeleteMapping("/delete/{id}")
    @Operation(
            summary = "Eliminar registro",
            description = "Elimina un registro existente utilizando su identificador"
    )
    @ApiResponse(responseCode = "200", description = "Materia eliminada")
    @ApiResponse(responseCode = "400", description = "Materia no encontrada")

    public void deleteMateria(@PathVariable("id")Integer id){
        materiasRepository.deleteById(id);
}
}


