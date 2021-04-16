package com.svalero.actaprendizaje.Controller;

import com.svalero.actaprendizaje.Domain.Cima;
import com.svalero.actaprendizaje.Service.CimaService;
import com.svalero.actaprendizaje.Utils.Respuesta;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import static com.svalero.actaprendizaje.Utils.Respuesta.noErrorResponse;


@Tag(name = "Cima", description = "Descripción de las Cimas")
@RestController
public class CimaController {

    private final Logger logger = LoggerFactory.getLogger(ParqueController.class);


    @Autowired
    private CimaService cimaService;


    @Operation(summary = "Añade una cima")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Añadido con éxito", content = @Content(schema = @Schema(implementation = Cima.class))),
    })
    @PostMapping(value = "/cima", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Cima> addCima(@RequestBody Cima cima){
        logger.info("Inicio de addCima");
        Cima cimaadd = cimaService.addCima(cima);
        logger.info("Fin de addCima");
        return new ResponseEntity<>(cimaadd, HttpStatus.CREATED);
    }



    @Operation(summary = "Lista todas las cimas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Listado con éxito", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Cima.class)))),
    })
    @GetMapping(value = "/cimas", produces = "application/json")
    public ResponseEntity<List<Cima>> findAll(){
        logger.info("Inicio de findAll");
        List<Cima> listaCimas;
        listaCimas = cimaService.findAll();
        logger.info("Fin de findAll");
        return new ResponseEntity<>(listaCimas, HttpStatus.OK);
    }



    @Operation(summary = "Modificación de una cima")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Modificado con éxito", content = @Content(schema = @Schema(implementation = Cima.class))),
            @ApiResponse(responseCode = "404", description = "La cima no existe", content = @Content(schema = @Schema(implementation = Respuesta.class)))
    })
    @PutMapping(value = "/cima/{id}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Cima> modifyCima(@PathVariable long id, @RequestBody Cima newCima){
        logger.info("Inicio de modifyCima");
        Cima cima =  cimaService.modifyCima(id, newCima);
        logger.info("Fin de modifyCima");
        return new ResponseEntity<>(cima, HttpStatus.CREATED);
    }



    @Operation(summary = "Eliminación de una cima")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Eliminado con éxito", content = @Content(schema = @Schema(implementation = Cima.class))),
            @ApiResponse(responseCode = "404", description = "La cima no existen", content = @Content(schema = @Schema(implementation = Respuesta.class)))
    })
    @DeleteMapping(value = "/cima/{id}", produces = "application/json")
    public ResponseEntity<Respuesta> deleteCima(@PathVariable long id){
        logger.info("Inicio de deleteCima");
        cimaService.deleteCima(id);
        logger.info("Fin de deleteCima");
        return new ResponseEntity<>(noErrorResponse(), HttpStatus.OK);
    }




    @Operation(summary = "Modificación del campo vivac de una cima")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Modificado con éxito", content = @Content(schema = @Schema(implementation = Cima.class))),
            @ApiResponse(responseCode = "404", description = "La cima no existe", content = @Content(schema = @Schema(implementation = Respuesta.class)))
    })
    @PatchMapping(value = "/cima/{id}/vivac", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Cima> modifyCimaVivac(@PathVariable long id, @RequestParam(name = "vivac") int vivac){
        logger.info("Inicio de modifyCimaVivac");
        Cima cima;
        cima = cimaService.modidfyCimaVivac(id, vivac);
        logger.info("Fin de modifyCimaVivac");
        return new ResponseEntity<>(cima, HttpStatus.CREATED);
    }


    @Operation(summary = "Buscar una cima por su identificador")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busqueda realizada", content = @Content(schema = @Schema(implementation = Cima.class))),
            @ApiResponse(responseCode = "404", description = "No existe", content = @Content(schema = @Schema(implementation = Respuesta.class)))
    })
    @GetMapping(value = "/cima/{id}", produces = "application/json")
    public ResponseEntity<Cima> findById(@PathVariable long id){
        logger.info("Inicio de findById");
        Cima cima;
        cima = cimaService.findById(id);
        logger.info("Fin de findById");
        return new ResponseEntity<>(cima, HttpStatus.OK);
    }


}
