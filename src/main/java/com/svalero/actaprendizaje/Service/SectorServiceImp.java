package com.svalero.actaprendizaje.Service;

import com.svalero.actaprendizaje.DTO.SectorDTO;
import com.svalero.actaprendizaje.Domain.Parque;
import com.svalero.actaprendizaje.Domain.Sector;
import com.svalero.actaprendizaje.Repository.ParqueRepository;
import com.svalero.actaprendizaje.Repository.SectorRepository;
import com.svalero.actaprendizaje.Utils.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SectorServiceImp implements SectorService {

    @Autowired
    private SectorRepository sectorRepository;

    @Autowired
    private ParqueRepository parqueRepository;

    @Override
    public Sector addSector(SectorDTO sectorDTO) {
        long idParque = sectorDTO.getParque_id();
        Parque parque = parqueRepository.findById(idParque)
                .orElseThrow(()-> new NotFoundException());
        Sector sector = new Sector();
        sector.setNombreSec(sectorDTO.getNombreSec());
        sector.setExtensionSec(sectorDTO.getExtensionSec());
        sector.setNumRutas(sectorDTO.getNumRutas());
        sector.setBus(sectorDTO.isBus());
        sector.setFechaSec(sectorDTO.getFechaSec());
        sector.setParque(parque);
        return sectorRepository.save(sector);
    }


    @Override
    public List<Sector> findAll(long parque_id) {
        Parque parque = parqueRepository.findById(parque_id)
                .orElseThrow(()-> new NotFoundException());
        List<Sector> sectores;
        sectores = sectorRepository.findSectores(parque_id);
        return sectores;
    }

    @Override
    public Sector modifySector(long id, SectorDTO sectorDTO) {
        long idParque = sectorDTO.getParque_id();
        Parque parque = parqueRepository.findById(idParque)
                .orElseThrow(()-> new NotFoundException());
        Sector sector = sectorRepository.findById(id)
                .orElseThrow(()-> new NotFoundException());
        Sector nuevoSector = new Sector();
        nuevoSector.setId(id);
        nuevoSector.setNombreSec(sectorDTO.getNombreSec());
        nuevoSector.setExtensionSec(sectorDTO.getExtensionSec());
        nuevoSector.setNumRutas(sectorDTO.getNumRutas());
        nuevoSector.setBus(sectorDTO.isBus());
        nuevoSector.setFechaSec(sectorDTO.getFechaSec());
        nuevoSector.setParque(parque);
        return sectorRepository.save(nuevoSector);
    }

    @Override
    public void deleteSector(long id) {
        sectorRepository.deleteById(id);
    }

    @Override
    public Sector modifyRutas(long id, int numRutas) {
        Sector sector;
        sector = sectorRepository.findById(id)
                .orElseThrow(()-> new NotFoundException());
        sector.setNumRutas(numRutas);
        return sectorRepository.save(sector);
    }

    @Override
    public Sector findById(long id) {
        Sector sector;
        sector = sectorRepository.findById(id)
                .orElseThrow(()-> new NotFoundException());
        return sector;
    }

}
