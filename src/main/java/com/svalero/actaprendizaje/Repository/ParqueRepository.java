package com.svalero.actaprendizaje.Repository;

import com.svalero.actaprendizaje.Domain.Parque;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface ParqueRepository extends CrudRepository<Parque, Long> {

    Set<Parque> findAll();
    Parque findByNombreParque(String nombreParque);
    List<Parque> findByAcceso(Boolean b);
    Optional<Parque> findById(long id);



}
