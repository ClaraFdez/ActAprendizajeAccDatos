package com.svalero.actaprendizaje.Controller;


import com.svalero.actaprendizaje.DTO.RutaDTO;
import com.svalero.actaprendizaje.Domain.Ruta;
import com.svalero.actaprendizaje.Service.RutaService;
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



@Tag(name = "Rutas", description = "Descripción de las Rutas")
@RestController
public class RutaController {

    private final Logger logger = LoggerFactory.getLogger(ParqueController.class);

    @Autowired
    private RutaService rutaService;



    @Operation(summary = "Añadir una ruta")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Insertado con éxito", content = @Content(schema = @Schema(implementation = Ruta.class))),
    })
    @PostMapping(value = "/ruta", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Ruta> addRuta(@RequestBody RutaDTO rutaDTO){
        logger.info("Inicio de addRuta");
        Ruta rutaadd = rutaService.addRuta(rutaDTO);
        logger.info("Fin de addRuta");
        return new ResponseEntity<>(rutaadd, HttpStatus.CREATED);
    }




    @Operation(summary = "Listar todas las rutas independientemente del sector y parque")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Listado con exito", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Ruta.class)))),
    })
    @GetMapping(value = "/ruta", produces = "application/json")
    public ResponseEntity<List<Ruta>> findAll(){
        logger.info("Inicio de findAll");
        List<Ruta> listaRutas;
        listaRutas = rutaService.findAll();
        logger.info("Fin de finAll");
        return new ResponseEntity<>(listaRutas, HttpStatus.OK);
    }




    @Operation(summary = "Lista de las rutas de un determinado sector")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busqueda realizada con exito", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Ruta.class))))
    })
    @GetMapping(value = "/ruta/sector", produces = "application/json")
    public ResponseEntity<List<Ruta>> findAllSec(@RequestParam(name = "sector_id") long sector_id){
        logger.info("Inicio de findAllSec");
        List<Ruta> listaRutas;
        listaRutas = rutaService.findAllIdSec(sector_id);
        logger.info("Fin de findAllSec");
        return new ResponseEntity<>(listaRutas, HttpStatus.OK);
    }




    @Operation(summary = "Búsqueda de una ruta por su identificador")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busqueda realizada con éxito", content = @Content(schema = @Schema(implementation = Ruta.class))),
            @ApiResponse(responseCode = "404", description = "La ruta no existea", content = @Content(schema = @Schema(implementation = Respuesta.class)))
    })
    @GetMapping(value = "/ruta/{id}", produces = "application/json")
    public ResponseEntity<Ruta> findById(@PathVariable long id){
        logger.info("Inicio de findById");
        Ruta ruta;
        ruta = rutaService.findById(id);
        logger.info("Fin de findById");
        return new ResponseEntity<>(ruta, HttpStatus.OK);

    }




    @Operation(summary = "Modificación de una ruta completa")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Modificación realizada", content = @Content(schema = @Schema(implementation = Ruta.class))),
            @ApiResponse(responseCode = "404", description = "La ruta no existe", content = @Content(schema = @Schema(implementation = Respuesta.class)))
    })
    @PutMapping(value = "/ruta/{id}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Ruta> modifyRuta(@PathVariable long id, @RequestBody RutaDTO rutaDTO){
        logger.info("Inicio de modifyRuta");
        Ruta ruta;
        ruta = rutaService.modifyRuta(id, rutaDTO);
        logger.info("Fin de modifyRuta");
        return new ResponseEntity<>(ruta, HttpStatus.CREATED);
    }



    @Operation(summary = "Eliminación de una ruta")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Eliminado con éxito", content = @Content(schema = @Schema(implementation = Ruta.class))),
            @ApiResponse(responseCode = "404", description = "La ruta no existe", content = @Content(schema = @Schema(implementation = Respuesta.class)))
    })
    @DeleteMapping(value = "/ruta/{id}", produces = "application/json")
    public ResponseEntity<Respuesta> deleteRuta(@PathVariable long id){
        logger.info("Inicio de deleteRuta");
        rutaService.deleteRuta(id);
        logger.info("Fin de deleteRuta");
        return new ResponseEntity<>(Respuesta.noErrorResponse(), HttpStatus.OK);
    }



    @Operation(summary = "Modificar el material de una ruta")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Modificación realizada", content = @Content(schema = @Schema(implementation = Ruta.class))),
            @ApiResponse(responseCode = "404", description = "La ruta no existe", content = @Content(schema = @Schema(implementation = Respuesta.class)))
    })
    @PatchMapping(value = "/ruta/{id}/material", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Ruta> modifyRutaMaterial(@PathVariable long id, @RequestParam(name = "material") String material){
        logger.info("Inicio de modifyRutaMaterial");
        Ruta ruta;
        ruta = rutaService.modifyRutaMaterial(id, material);
        logger.info("Fin de modifyRutaMaterial");
        return new ResponseEntity<>(ruta, HttpStatus.CREATED);
    }




    @Operation(summary = "Busqueda de una ruta por su lugar de salida, si es circular y la época del año recomendada")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busqueda realizada on éxito", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Ruta.class))))
    })
    @GetMapping(value = "/ruta/salida_circular_epoca", produces = "application/json")
    public ResponseEntity<List<Ruta>> findBySalidaRutaAndCircularAndEpoca(@RequestParam(name = "salidaRuta") String salidaRuta,
                                                                          @RequestParam(name = "circular") boolean circular,
                                                                          @RequestParam(name = "epoca") String epoca){
        logger.info("Inicio de findBySalidaRutaAndCircularAndEpoca");
        List<Ruta> listaRutas;
        listaRutas = rutaService.findBySalidaRutaAndCircularAndEpoca(salidaRuta, circular, epoca);
        logger.info("Fin de findBySalidaRutaAndCircularAndEpoca");
        return new ResponseEntity<>(listaRutas, HttpStatus.OK);
    }

}
