package com.svalero.actaprendizaje.Service;

import com.svalero.actaprendizaje.Domain.Autobus;
import com.svalero.actaprendizaje.Domain.Sector;
import com.svalero.actaprendizaje.Repository.AutobusRepository;
import com.svalero.actaprendizaje.Repository.SectorRepository;
import com.svalero.actaprendizaje.Utils.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutobusServiceImp implements AutobusService{


    @Autowired
    private AutobusRepository autobusRepository;

    @Autowired
    private SectorRepository sectorRepository;

//la que da error  YA NO
    @Override
    public List<Autobus> findAllBusSec(long sector_id) {
        //Sector sector;
       //sector = sectorRepository.findAllById(sector_id)
        //        .orElseThrow(()-> new NotFoundException());
        List<Autobus> listaBus;
        listaBus = autobusRepository.findBusSec(sector_id);
        return listaBus;
    }

    @Override
    public Autobus addBus(Autobus bus) {
        autobusRepository.save(bus);
        return bus;
    }

    @Override
    public Autobus modifyBus(long idBus, Autobus newBus) {
        Autobus bus;
        bus = autobusRepository.findById(idBus)
                .orElseThrow(()-> new NotFoundException());
        newBus.setId(idBus);
        return autobusRepository.save(newBus);
    }

    @Override
    public void deleteBus(long idBus) {
        Autobus bus;
        bus = autobusRepository.findById(idBus)
                .orElseThrow(()-> new NotFoundException());
        autobusRepository.deleteById(idBus);
    }

    @Override
    public Autobus modifyBusPrecio(long id, float precio) {
        Autobus bus;
        bus = autobusRepository.findById(id)
                .orElseThrow(()-> new NotFoundException());
        bus.setPrecio(precio);
        return autobusRepository.save(bus);
    }

    @Override
    public Autobus findById(long id) {
        Autobus bus;
        bus = autobusRepository.findById(id)
                .orElseThrow(()-> new NotFoundException());
        return bus;
    }
}
