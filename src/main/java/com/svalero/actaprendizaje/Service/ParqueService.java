package com.svalero.actaprendizaje.Service;

import com.svalero.actaprendizaje.Domain.Parque;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ParqueService {

    Parque findByNombreParque(String nombre);
    List<Parque> findByAcceso(Boolean b);
    Optional<Parque> findById(long id);
    void delete(long id);
    Parque addParque(Parque parque);
    Parque modifyParque (long id, Parque parque);
    Parque modifyExtension (float extension, long id);
    List<Parque> findAll();
    List<Parque> findByNombreParqueContaining(String sec);

}
