package com.svalero.actaprendizaje.Service;

import com.svalero.actaprendizaje.Domain.Cima;

import java.util.List;

public interface CimaService {

    Cima addCima(Cima cima); //añade una cima
    List<Cima> findAll(); //lista todas las cimas
    Cima modifyCima(long id, Cima newCima); //modifica la cima entera
    void deleteCima(long id); // borra una cima
    Cima modidfyCimaVivac(long id, int vivac);
    Cima findById(long id);


}
