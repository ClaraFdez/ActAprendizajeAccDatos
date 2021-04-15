package com.svalero.actaprendizaje.Repository;

import com.svalero.actaprendizaje.Domain.Cima;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CimaRepository extends CrudRepository<Cima, Long> {

    List<Cima> findAll();
   // Optional<Cima> findByIdCima(long idCima);

}
