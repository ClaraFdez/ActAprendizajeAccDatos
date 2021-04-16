package com.svalero.actaprendizaje.Service;

import com.svalero.actaprendizaje.DTO.RutaDTO;
import com.svalero.actaprendizaje.Domain.Cima;
import com.svalero.actaprendizaje.Domain.Ruta;
import com.svalero.actaprendizaje.Domain.Sector;
import com.svalero.actaprendizaje.Repository.CimaRepository;
import com.svalero.actaprendizaje.Repository.RutaRepository;
import com.svalero.actaprendizaje.Repository.SectorRepository;
import com.svalero.actaprendizaje.Utils.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RutaServiceImp implements RutaService{

    @Autowired
    private RutaRepository rutaRepository;

    @Autowired
    private SectorRepository sectorRepository;

    @Autowired
    private CimaRepository cimaRepository;


    @Override
    public Ruta addRuta(RutaDTO rutaDTO) {
        long sector_id = rutaDTO.getSector_id();
        Sector sector = sectorRepository.findById(sector_id)
                .orElseThrow(()-> new NotFoundException());
        long cima_id = rutaDTO.getCima_id();
        Cima cima = cimaRepository.findById(cima_id)
                .orElseThrow(()-> new NotFoundException());
        Ruta ruta = new Ruta();
        ruta.setNombreRuta(rutaDTO.getNombreRuta());
        ruta.setSalidaRuta(rutaDTO.getSalidaRuta());
        ruta.setFinRuta(rutaDTO.getFinRuta());
        ruta.setDistancia(rutaDTO.getDistancia());
        ruta.setCircular(rutaDTO.isCircular());
        ruta.setEpoca(rutaDTO.getEpoca());
        ruta.setDificultad(rutaDTO.getDificultad());
        ruta.setMaterial(rutaDTO.getMaterial());
        ruta.setFecha(rutaDTO.getFecha());
        ruta.setSector(sector);
        ruta.setCima(cima);

        return rutaRepository.save(ruta);
    }

    @Override
    public List<Ruta> findAll() {
        List<Ruta> listaRutas;
        listaRutas = rutaRepository.findAll();
        return listaRutas;
    }

    @Override
    public List<Ruta> findAllIdSec(long sector_id) {
        List<Ruta> listaRutas;
        listaRutas = rutaRepository.findAllIdSec(sector_id);
        return listaRutas;
    }

    @Override
    public Ruta findById(long id) {
        Ruta ruta;
        ruta = rutaRepository.findById(id)
                .orElseThrow(()-> new NotFoundException());
        return ruta;
    }

    @Override
    public Ruta modifyRuta(long id, RutaDTO rutaDTO) {
        Ruta ruta;
        ruta = rutaRepository.findById(id)
                .orElseThrow(()-> new NotFoundException());
        long sector_id = rutaDTO.getSector_id();
        Sector sector = sectorRepository.findById(sector_id)
                .orElseThrow(()-> new NotFoundException());
        long cima_id = rutaDTO.getCima_id();
        Cima cima = cimaRepository.findById(cima_id)
                .orElseThrow(()-> new NotFoundException());
        Ruta newRuta = new Ruta();
        newRuta.setId(id);
        newRuta.setNombreRuta(rutaDTO.getNombreRuta());
        newRuta.setSalidaRuta(rutaDTO.getSalidaRuta());
        newRuta.setFinRuta(rutaDTO.getFinRuta());
        newRuta.setDistancia(rutaDTO.getDistancia());
        newRuta.setCircular(rutaDTO.isCircular());
        newRuta.setEpoca(rutaDTO.getEpoca());
        newRuta.setDificultad(rutaDTO.getDificultad());
        newRuta.setMaterial(rutaDTO.getMaterial());
        newRuta.setFecha(rutaDTO.getFecha());
        newRuta.setSector(sector);
        newRuta.setCima(cima);
        newRuta.setId(id);
        return rutaRepository.save(newRuta);
    }

    @Override
    public void deleteRuta(long id) {
        rutaRepository.deleteById(id);
    }

    @Override
    public Ruta modifyRutaMaterial(long id, String material) {
        Ruta ruta;
        ruta = rutaRepository.findById(id)
                .orElseThrow(()-> new NotFoundException());
        ruta.setMaterial(material);
        return rutaRepository.save(ruta);
    }

    @Override
    public List<Ruta> findBySalidaRutaAndCircularAndEpoca(String salidaRuta, boolean circular, String epoca) {
        List<Ruta> listaRutas;
        listaRutas = rutaRepository.findBySalidaRutaAndCircularAndEpoca(salidaRuta, circular, epoca);
        return listaRutas;
    }
}
