package com.svalero.actaprendizaje.Service;

import com.svalero.actaprendizaje.DTO.RutaDTO;
import com.svalero.actaprendizaje.Domain.Ruta;
import java.util.List;

public interface RutaService {

    Ruta addRuta(RutaDTO rutaDTO);
    List<Ruta> findAll();
    List<Ruta> findAllIdSec(long sector_id);
    Ruta findById(long id);
    Ruta modifyRuta(long id, RutaDTO rutaDTO);
    void deleteRuta(long id);
    Ruta modifyRutaMaterial(long id, String material);
    List<Ruta> findBySalidaRutaAndCircularAndEpoca(String salidaRuta, boolean circular, String epoca);

}
