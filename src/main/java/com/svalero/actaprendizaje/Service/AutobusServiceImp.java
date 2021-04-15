package com.svalero.actaprendizaje.Service;

import com.svalero.actaprendizaje.Controller.ParqueController;
import com.svalero.actaprendizaje.DTO.AutobusDTO;
import com.svalero.actaprendizaje.Domain.Autobus;
import com.svalero.actaprendizaje.Domain.Sector;
import com.svalero.actaprendizaje.Repository.AutobusRepository;
import com.svalero.actaprendizaje.Repository.SectorRepository;
import com.svalero.actaprendizaje.Utils.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutobusServiceImp implements AutobusService{

    private final Logger logger = LoggerFactory.getLogger(ParqueController.class);

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
    public Autobus addBus(AutobusDTO autobusDTO) {
        logger.info("inicio adbus en autobusServiceimp");
        long idSector = autobusDTO.getSector_id();
        logger.info("valor del id del sector " + idSector);
        Sector sector = sectorRepository.findById(idSector)
                .orElseThrow(()-> new NotFoundException());
        Autobus bus = new Autobus();
        logger.info("inicio del bus " + autobusDTO.getInicioBus());
        bus.setInicioBus(autobusDTO.getInicioBus());
        bus.setFinBus(autobusDTO.getFinBus());
        bus.setMascota(autobusDTO.isMascota());
        bus.setPlazas(autobusDTO.getPlazas());
        bus.setPrecio(autobusDTO.getPrecio());
        bus.setFechaBus(autobusDTO.getFechaBus());
        bus.setSector(sector);
        return autobusRepository.save(bus);
    }

    @Override
    public Autobus modifyBus(long id, AutobusDTO autobusDTO) {
        long idSector = autobusDTO.getSector_id();
        Sector sector = sectorRepository.findById(idSector)
                .orElseThrow(()-> new NotFoundException());
        Autobus bus = autobusRepository.findById(id)
                .orElseThrow(()-> new NotFoundException());
        Autobus newBus = new Autobus();
        newBus.setId(id);
        newBus.setInicioBus(autobusDTO.getInicioBus());
        newBus.setFinBus(autobusDTO.getFinBus());
        newBus.setMascota(autobusDTO.isMascota());
        newBus.setPlazas(autobusDTO.getPlazas());
        newBus.setPrecio(autobusDTO.getPrecio());
        newBus.setFechaBus(autobusDTO.getFechaBus());
        newBus.setSector(sector);
        return autobusRepository.save(newBus);
    }

    @Override
    public void deleteBus(long id) {
        Autobus bus;
        bus = autobusRepository.findById(id)
                .orElseThrow(()-> new NotFoundException());
        autobusRepository.deleteById(id);
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
