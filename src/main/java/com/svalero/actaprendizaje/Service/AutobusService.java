package com.svalero.actaprendizaje.Service;

import com.svalero.actaprendizaje.DTO.AutobusDTO;
import com.svalero.actaprendizaje.Domain.Autobus;
import java.util.List;


public interface AutobusService {
    //la que da error  YA NO
    List<Autobus> findAllBusSec(long sector_id);
    Autobus addBus(AutobusDTO autobusDTO);
    Autobus modifyBus(long id, AutobusDTO autobusDTO);
    void deleteBus(long id);
    Autobus modifyBusPrecio(long id, float precio);
    Autobus findById(long id);
}
