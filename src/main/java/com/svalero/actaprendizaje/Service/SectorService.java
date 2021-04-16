package com.svalero.actaprendizaje.Service;

import com.svalero.actaprendizaje.DTO.SectorDTO;
import com.svalero.actaprendizaje.Domain.Sector;
import java.util.List;


public interface SectorService {

    Sector addSector(SectorDTO sectorDTO);
    List<Sector> findAll(long parque_id);
    Sector modifySector(long id, SectorDTO sectorDTO);
    void deleteSector(long id);
    Sector modifyRutas(long id, int numRutas);
    Sector findById(long id);

}
