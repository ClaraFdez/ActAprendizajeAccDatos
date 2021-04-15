package com.svalero.actaprendizaje.Service;

import com.svalero.actaprendizaje.DTO.SectorDTO;
import com.svalero.actaprendizaje.Domain.Sector;
import org.springframework.stereotype.Service;

import java.util.List;


public interface SectorService {

    Sector addSector(SectorDTO sectorDTO); //añadir un sector

    List<Sector> findAll(long parque_id); //todos los sectores
    Sector modifySector(long id, Sector nuevoSector); //modificar un sector
    void deleteSector(long id); //eliminar un sector
    Sector modifyAcceso(long id, boolean b);//modificar un parametro de un sector
    Sector findById(long id);
}
