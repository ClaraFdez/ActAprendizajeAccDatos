package com.svalero.actaprendizaje.Service;

import com.svalero.actaprendizaje.Domain.Ruta;

import java.util.List;

public interface RutaService {

    Ruta addRuta(Ruta ruta); // añade una ruta
    List<Ruta> findAll(); // busca todas las rutas
   // la que da error YA NO DA AL COMPILAR
    List<Ruta> findAllIdSec(long sector_id); //busca todas las rutas por sector
    Ruta findById(long idRuta); //busca ruta por id
    Ruta modifyRuta(long idRuta, Ruta newRuta); //modifica una ruta completa
    void deleteRuta(long idRuta); //borra
    Ruta modifyRutaMaterial(long idRuta, String material); //modifica el material de una ruta
    List<Ruta> findBySalidaRutaAndCircularAndEpoca(String salidaRuta, boolean circular, String epoca);

}
