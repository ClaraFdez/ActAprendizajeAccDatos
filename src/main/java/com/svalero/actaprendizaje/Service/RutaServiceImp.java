package com.svalero.actaprendizaje.Service;

import com.svalero.actaprendizaje.Domain.Ruta;
import com.svalero.actaprendizaje.Repository.RutaRepository;
import com.svalero.actaprendizaje.Utils.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RutaServiceImp implements RutaService{

    @Autowired
    private RutaRepository rutaRepository;


    @Override
    public Ruta addRuta(Ruta ruta) {
        return rutaRepository.save(ruta);
    }

    @Override
    public List<Ruta> findAll() {
        List<Ruta> listaRutas;
        listaRutas = rutaRepository.findAll();
        return listaRutas;
    }
//la que da error YA NO DA AL COMPILAR
    @Override
    public List<Ruta> findAllIdSec(long sector_id) {
        List<Ruta> listaRutas;
        listaRutas = rutaRepository.findAllIdSec(sector_id);
        return listaRutas;
    }

    @Override
    public Ruta findById(long idRuta) {
        Ruta ruta;
        ruta = rutaRepository.findById(idRuta)
                .orElseThrow(()-> new NotFoundException());
        return ruta;
    }

    @Override
    public Ruta modifyRuta(long idRuta, Ruta newRuta) {
        Ruta ruta;
        ruta = rutaRepository.findById(idRuta)
                .orElseThrow(()-> new NotFoundException());
        newRuta.setId(idRuta);
        return rutaRepository.save(newRuta);
    }

    @Override
    public void deleteRuta(long idRuta) {
        rutaRepository.deleteById(idRuta);
    }

    @Override
    public Ruta modifyRutaMaterial(long idRuta, String material) {
        Ruta ruta;
        ruta = rutaRepository.findById(idRuta)
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
