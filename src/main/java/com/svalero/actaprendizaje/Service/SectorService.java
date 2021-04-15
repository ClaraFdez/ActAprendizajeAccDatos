package com.svalero.actaprendizaje.Service;

import com.svalero.actaprendizaje.Domain.Sector;
import org.springframework.stereotype.Service;

import java.util.List;


public interface SectorService {

    Sector addSector(Sector sector); //añadir un sector

    List<Sector> findAll(long parque_id); //todos los sectores
    Sector modifySector(long idSector, Sector nuevoSector); //modificar un sector
    void deleteSector(long idSector); //eliminar un sector
    Sector modifyAcceso(long idSector, boolean b);//modificar un parametro de un sector
    Sector findById(long idSec);
}
