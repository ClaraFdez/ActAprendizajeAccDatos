package com.svalero.actaprendizaje.Service;

import com.svalero.actaprendizaje.DTO.RutaDTO;
import com.svalero.actaprendizaje.Domain.Ruta;

import java.util.List;

public interface RutaService {

    Ruta addRuta(RutaDTO rutaDTO); // añade una ruta
    List<Ruta> findAll(); // busca todas las rutas
   // la que da error YA NO DA AL COMPILAR
    List<Ruta> findAllIdSec(long sector_id); //busca todas las rutas por sector
    Ruta findById(long id); //busca ruta por id
    Ruta modifyRuta(long id, RutaDTO rutaDTO); //modifica una ruta completa
    void deleteRuta(long id); //borra
    Ruta modifyRutaMaterial(long id, String material); //modifica el material de una ruta
    List<Ruta> findBySalidaRutaAndCircularAndEpoca(String salidaRuta, boolean circular, String epoca);

}
