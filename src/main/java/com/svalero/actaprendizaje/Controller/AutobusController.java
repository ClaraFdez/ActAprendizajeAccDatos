package com.svalero.actaprendizaje.Controller;

import com.svalero.actaprendizaje.DTO.AutobusDTO;
import com.svalero.actaprendizaje.Domain.Autobus;
import com.svalero.actaprendizaje.Service.AutobusService;
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



@Tag(name = "Autobus", description = "Servicio de Autobuses para ciertas partes de ciertos sectores")
@RestController
public class AutobusController {

    private final Logger logger = LoggerFactory.getLogger(ParqueController.class);

    @Autowired
    private AutobusService autobusService;



    @Operation(summary = "Buscar todos los autobuses de un sector")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Listado con éxito", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Autobus.class)))),
    })
    @GetMapping(value = "/bus", produces = "application/json")
    public ResponseEntity<List<Autobus>> findAllBusSec(@RequestParam(name = "sector_id") long sector_id){
        logger.info("Inicio de findAllBusSec");
        List<Autobus> listaBus;
        listaBus = autobusService.findAllBusSec(sector_id);
        logger.info("Fin de findAllBusSec");
        return new ResponseEntity<>(listaBus, HttpStatus.OK);
    }



    @Operation(summary = "Añadir un Autobus")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Insertado con exito", content = @Content(schema = @Schema(implementation = Autobus.class))),
    })
    @PostMapping(value = "/bus", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Autobus> addBus(@RequestBody AutobusDTO autobusDTO){
        logger.info("Inicio de addBus");
        Autobus busadd = autobusService.addBus(autobusDTO);
        logger.info("Fin de addBus");
        return new ResponseEntity<>(busadd, HttpStatus.CREATED);
    }



    @Operation(summary = "Modificar un autobus al completo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Modificado con exito", content = @Content(schema = @Schema(implementation = Autobus.class))),
            @ApiResponse(responseCode = "404", description = "El autobus no existe", content = @Content(schema = @Schema(implementation = Respuesta.class)))
    })
    @PutMapping(value = "/bus/{id}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Autobus> modifyBus(@PathVariable long id, @RequestBody AutobusDTO autobusDTO){
        logger.info("Inicio de modifyBus");
        Autobus bus;
        bus = autobusService.modifyBus(id, autobusDTO);
        logger.info("Fin de modifyBus");
        return new ResponseEntity<>(bus, HttpStatus.CREATED);
    }



    @Operation(summary = "Eliminar un Autobus")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Eliminado con éxito", content = @Content(schema = @Schema(implementation = Autobus.class))),
            @ApiResponse(responseCode = "404", description = "El autobus no existe", content = @Content(schema = @Schema(implementation = Respuesta.class)))
    })
    @DeleteMapping(value = "/bus/{id}", produces = "application/json")
    public ResponseEntity<Respuesta> deleteBus(@PathVariable long id){
        logger.info("Inicio de deleteBus");
        autobusService.deleteBus(id);
        logger.info("Fin de deleteBus");
        return new ResponseEntity<>(Respuesta.noErrorResponse(), HttpStatus.OK);
    }



    @Operation(summary = "Modificación del precio de un autobus")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Modificado con exito", content = @Content(schema = @Schema(implementation = Autobus.class))),
            @ApiResponse(responseCode = "404", description = "El autobus no existe", content = @Content(schema = @Schema(implementation = Respuesta.class)))
    })
    @PatchMapping(value = "/bus/{id}/precio", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Autobus> modifyBusPrecio(@PathVariable long id, @RequestParam(name = "precio") float precio){
        logger.info("Inicio modifyBusPrecio");
        Autobus bus;
        bus = autobusService.modifyBusPrecio(id, precio);
        logger.info("Fin modifyBusPrecio");
        return new ResponseEntity<>(bus, HttpStatus.CREATED);
    }



    @Operation(summary = "Buscar un autobus por su identificador")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busqueda realizada", content = @Content(schema = @Schema(implementation = Autobus.class))),
            @ApiResponse(responseCode = "404", description = "No existe", content = @Content(schema = @Schema(implementation = Respuesta.class)))
    })
    @GetMapping(value = "/bus/{id}", produces = "application/json")
    public ResponseEntity<Autobus> findById(@PathVariable long id){
        logger.info("Inicio de findById");
        Autobus autobus;
        autobus = autobusService.findById(id);
        logger.info("Fin de findById");
        return new ResponseEntity<>(autobus, HttpStatus.OK);
    }

}
