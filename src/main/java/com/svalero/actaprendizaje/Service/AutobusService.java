package com.svalero.actaprendizaje.Service;

import com.svalero.actaprendizaje.Domain.Autobus;

import java.util.List;

public interface AutobusService {

    //la que da error  YA NO
    List<Autobus> findAllBusSec(long sector_id); //buscar todos los autobuses de un sector
    Autobus addBus(Autobus bus); // crea un autobus
    Autobus modifyBus(long id, Autobus newBus); //modifica un autobus completo
    void deleteBus(long id); //elimina un bus completo
    Autobus modifyBusPrecio(long id, float precio); //modifica solo un parametro (patch)
    Autobus findById(long id);
}
