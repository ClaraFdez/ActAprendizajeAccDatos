package com.svalero.actaprendizaje.Service;

import com.svalero.actaprendizaje.Domain.Cima;
import java.util.List;

public interface CimaService {

    Cima addCima(Cima cima);
    List<Cima> findAll();
    Cima modifyCima(long id, Cima newCima);
    void deleteCima(long id);
    Cima modidfyCimaVivac(long id, int vivac);
    Cima findById(long id);

}
