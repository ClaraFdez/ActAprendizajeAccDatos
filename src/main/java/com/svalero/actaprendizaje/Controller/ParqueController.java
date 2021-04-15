package com.svalero.actaprendizaje.Controller;

import com.svalero.actaprendizaje.Domain.Parque;
import com.svalero.actaprendizaje.Service.ParqueService;
import com.svalero.actaprendizaje.Utils.NotFoundException;
import com.svalero.actaprendizaje.Utils.Respuesta;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Set;

import static com.svalero.actaprendizaje.Utils.Respuesta.NOT_FOUND;

@RestController
@Tag(name = "Parques", description = "Listado de Parques Naturales o Nacionales de España")
public class ParqueController {

    private final Logger logger = LoggerFactory.getLogger(ParqueController.class);

    @Autowired
    private ParqueService parqueService;

    @Operation(summary = "Lista todos los Parques")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Listado de Parques", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Parque.class))))})
    @GetMapping(value = "/parque", produces = "application/json")
    public ResponseEntity<Set<Parque>> findAll(){
        logger.info("Inicio findAll en Parques");
        Set<Parque> parques = null;
        parques = parqueService.findAll();
        logger.info(("Fin de findAll en Parques"));
        return new ResponseEntity<>(parques, HttpStatus.OK);
    }


    @Operation(summary = "Buscar un Parque por su identificador")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Parque encontrado", content = @Content(schema = @Schema (implementation = Parque.class))),
            @ApiResponse(responseCode = "404", description = "El parque no existe", content = @Content(schema = @Schema(implementation = Respuesta.class)))
    })
    @GetMapping(value = "/parque/{id}", produces = "application/json")
    public ResponseEntity<Parque> findById(@PathVariable long id){
        logger.info("Inicio findById en Parques");
        Parque parque = new Parque();
        parque = parqueService.findById(id)
                .orElseThrow(()-> new NotFoundException(id));
        logger.info("Fin de findById en Parques");
        return new ResponseEntity<>(parque, HttpStatus.OK);
    }


    @Operation(summary = "Busca un Parque por su nombre")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Parque encontrado", content = @Content(schema = @Schema(implementation = Parque.class))),
            @ApiResponse(responseCode = "404", description = "El parque no existe", content = @Content(schema = @Schema(implementation = Respuesta.class)))
    })
    @GetMapping(value = "/parque/nombre", produces = "application/json")
    public ResponseEntity<Parque> findByNombre(@RequestParam(name = "nombreParque") String nombre){
        logger.info("Inicio findByNombre en Parques");
        Parque parque = null;
        parque = parqueService.findByNombreParque(nombre);
        logger.info(("Fin de findByNombre en Parques"));
        return new ResponseEntity<>(parque, HttpStatus.OK);
    }


    @Operation(summary = "Buscar un Paque por su facilidad de acceso")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Parques encontrados", content = @Content(schema = @Schema(implementation = Parque.class))),
            @ApiResponse(responseCode = "400", description = "El parque no existe", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Respuesta.class))))
    })
    @GetMapping(value = "/parque/acceso", produces = "application/json")
    public ResponseEntity<List<Parque>> findByAcceso(@RequestParam(name = "acceso") boolean b){
        logger.info("Inicio findByAcceso en Parques");
        List<Parque> listaParques = null;
        listaParques = parqueService.findByAcceso(b);
        logger.info(("Fin de findByAcceso en Parques"));
        return new ResponseEntity<>(listaParques, HttpStatus.OK);
    }


    @Operation(summary = "Eliminar un Parque")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Parque eliminado", content = @Content(schema = @Schema(implementation = Parque.class))),
            @ApiResponse(responseCode = "404", description = "El parque no existe", content = @Content(schema = @Schema(implementation = Respuesta.class)))
    })
    @DeleteMapping(value = "/parque/{id}", produces = "application/json")
    public ResponseEntity<Respuesta> delete(@PathVariable long id){
        logger.info("Inicio delete en Parques");
        parqueService.findById(id)
                .orElseThrow(()-> new NotFoundException(id));
        parqueService.delete(id);
        logger.info(("Fin de delete en Parques"));
        return new ResponseEntity<>(Respuesta.noErrorResponse(), HttpStatus.OK);
    }


    @Operation(summary = "Añadir un Parque")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Se ha añadido con exito", content = @Content(schema = @Schema(implementation = Parque.class))),
    })
    @PostMapping(value = "/parque", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Parque> addParque(@RequestBody Parque parque){
        logger.info("Inicio addParque en Parques");
        Parque parqueadd = parqueService.addParque(parque);
        logger.info(("Fin de addParque en Parques"));
        return new ResponseEntity<>(parqueadd, HttpStatus.CREATED);
    }


    @Operation(summary = "Modificar un Parque completo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Se ha modificado con exito", content = @Content(schema = @Schema(implementation = Parque.class))),
            @ApiResponse(responseCode = "404", description = "El parque no existe", content = @Content(schema = @Schema(implementation = Respuesta.class)))
    })
    @PutMapping(value = "/parque/{id}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Parque> modifyParque(@RequestBody Parque parque, @PathVariable long id){
        logger.info("Inicio modifyParque en Parques");
        Parque newParque;
        newParque = parqueService.modifyParque(id, parque);
        logger.info(("Fin de modifyParque en Parques"));
        return new  ResponseEntity<>(newParque, HttpStatus.CREATED);
    }

    /*
    @Operation(summary = "Modificar solo la extensión de un Parque")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Se ha modificado con exito", content = @Content(schema = @Schema(implementation = Parque.class))),
            @ApiResponse(responseCode = "404", description = "El parque no existe", content = @Content(schema = @Schema(implementation = Respuesta.class)))
    })
    @PutMapping(value = "/parque/extension/{id}/", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Parque> modifyExtension(@RequestParam(name = "extension") float extension, @PathVariable long id){
        logger.info("Inicio modifyExtension en Parques");
        Parque parque = null;
        parque = parqueService.modifyExtension(extension, id);
        logger.info(("Fin de modifyExtension en Parques"));
        return new ResponseEntity<>(parque, HttpStatus.CREATED);
    }
    */

    //COMPROBAR

    @Operation(summary = "Modificar solo la extensión de un Parque")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Se ha modificado con exito", content = @Content(schema = @Schema(implementation = Parque.class))),
            @ApiResponse(responseCode = "404", description = "El parque no existe", content = @Content(schema = @Schema(implementation = Respuesta.class)))
    })
    @PatchMapping(value = "/parque/extension/{id}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Parque> modifyExtension( @PathVariable long id, @RequestParam(name = "extension") float extension){
        logger.info("Inicio modifyExtension en Parques");
        Parque parque = parqueService.modifyExtension(extension, id);
        logger.info(("Fin de modifyExtension en Parques"));
        return new ResponseEntity<>(parque, HttpStatus.CREATED);
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Respuesta> handleException(NotFoundException pnfe) {
        Respuesta respuesta = Respuesta.errorResonse(NOT_FOUND, pnfe.getMessage());
        logger.error(pnfe.getMessage(), pnfe);
        return new ResponseEntity<>(respuesta, HttpStatus.NOT_FOUND);
    }


}
