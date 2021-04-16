package com.svalero.actaprendizaje.Repository;

import com.svalero.actaprendizaje.Domain.Cima;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface CimaRepository extends CrudRepository<Cima, Long> {

    List<Cima> findAll();

}
