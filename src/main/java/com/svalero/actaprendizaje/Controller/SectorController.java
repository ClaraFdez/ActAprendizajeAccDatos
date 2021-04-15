package com.svalero.actaprendizaje.Controller;

import com.svalero.actaprendizaje.DTO.SectorDTO;
import com.svalero.actaprendizaje.Domain.Parque;
import com.svalero.actaprendizaje.Domain.Sector;
import com.svalero.actaprendizaje.Service.SectorService;
import com.svalero.actaprendizaje.Utils.NotFoundException;
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

import static com.svalero.actaprendizaje.Utils.Respuesta.NOT_FOUND;

@Tag(name = "Sectores", description = "Listado de todos los sectores de un determinado Parque")
@RestController
public class SectorController {

    private final Logger logger = LoggerFactory.getLogger(ParqueController.class);

    @Autowired
    private SectorService sectorService;


    @Operation(summary = "Añadir un sector")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Sector añadido con exito", content = @Content(schema = @Schema(implementation = Sector.class))),
    })
    @PostMapping(value = "/sector", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Sector> addSector(@RequestBody SectorDTO sectorDTO){
        logger.info("Inicio de addSector");
        Sector sectoradd = sectorService.addSector(sectorDTO);
        logger.info("Fin de addSector");
        return new ResponseEntity<>(sectoradd, HttpStatus.CREATED);
    }



    @Operation(summary = "Lista todos los sectores de un parque")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Se ha listado con éxito", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Sector.class)))),
    })
    @GetMapping(value = "/sector/id", produces = "application/json")
    public ResponseEntity<List<Sector>> findAllSectores(@PathVariable long idParque){
        logger.info("Inicio de findAllSectores");
        List<Sector> listaSectores;
        listaSectores = sectorService.findAll(idParque);
        logger.info("Fin de findAllSectores");
        return new ResponseEntity<>(listaSectores, HttpStatus.OK);
    }



    @Operation(summary = "Modificar un sector al completo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sector modificado con éxito", content = @Content(schema = @Schema(implementation = Sector.class))),
            @ApiResponse(responseCode = "404", description = "El sector no existe", content = @Content(schema = @Schema(implementation = Respuesta.class)))
    })
    @PutMapping(value = "/sector/{id}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Sector> modifySec(@RequestBody Sector newSector, @PathVariable long id){
        logger.info("Inicio de modifySec");
        Sector sector;
        sector = sectorService.modifySector(id, newSector);
        logger.info("Fin de modifySec");
        return new ResponseEntity<>(sector, HttpStatus.CREATED);
    }



    @Operation(summary = "Eliminar un Sector")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sector eliminado con éxito", content = @Content(schema = @Schema(implementation = Sector.class))),
            @ApiResponse(responseCode = "404", description = "El sector no existe", content = @Content(schema = @Schema(implementation = Respuesta.class)))
    })
    @DeleteMapping(value = "/sector/{id}", produces = "application/json")
    public ResponseEntity<Respuesta> deleteSector(@PathVariable long id){
        logger.info("Inicio de deleteSector");
        sectorService.deleteSector(id);
        logger.info("Fin de deleteSector");
        return new ResponseEntity<>(Respuesta.noErrorResponse(), HttpStatus.OK);
    }




    @Operation(summary = "Modificación del acceso al sector")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Modificado con éxito", content = @Content(schema = @Schema(implementation = Sector.class))),
            @ApiResponse(responseCode = "404", description = "El sector no existe", content = @Content(schema = @Schema(implementation = Respuesta.class)))
    })
    @PatchMapping(value = "/sector/{id}/bus/", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Sector> modifyAccSector(@PathVariable long id, @RequestParam(name = "bus") boolean bus){
        logger.info("Inicio de modifyAccSector");
        Sector sector;
        sector = sectorService.modifyAcceso(id, bus);
        logger.info("Fin de modifyAccSector");
        return new ResponseEntity<>(sector, HttpStatus.CREATED);
    }



    @Operation(summary = "Buscar un sector por su identificador")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sector encontrado", content = @Content(schema = @Schema (implementation = Sector.class)))
    })
    @GetMapping(value = "/sector/{id}", produces = "application/json")
    public ResponseEntity<Sector> findById(@PathVariable long id){
        logger.info("Inicio findById");
        Sector sector;
        sector = sectorService.findById(id);
        logger.info(("Fin de findById"));
        return new ResponseEntity<>(sector, HttpStatus.OK);
    }


}
