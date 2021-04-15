package com.svalero.actaprendizaje.Service;

import com.svalero.actaprendizaje.Domain.Sector;
import com.svalero.actaprendizaje.Repository.SectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SectorServiceImp implements SectorService {

    @Autowired
    private SectorRepository sectorRepository;

    @Override
    public Sector addSector(Sector sector) {
        return sectorRepository.save(sector);
    }


    @Override
    public List<Sector> findAll(long parque_id) {
        List<Sector> sectores;
        sectores = sectorRepository.findAll(parque_id);
        return sectores;
    }

    @Override
    public Sector modifySector(long idSec, Sector nuevoSector) {
        nuevoSector.setIdSec(idSec);
        sectorRepository.save(nuevoSector);
        return nuevoSector;
    }

    @Override
    public void deleteSector(long idSec) {
        sectorRepository.deleteById(idSec);
    }

    @Override
    public Sector modifyAcceso(long idSec, boolean b) {
        Sector sector;
        sector = sectorRepository.findById(idSec);
        sector.setBus(b);
        return sector;
    }

    @Override
    public Sector findById(long idSec) {
        Sector sector;
        sector = sectorRepository.findById(idSec);
        return sector;
    }

}
