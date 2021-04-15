package com.svalero.actaprendizaje.Repository;

import com.svalero.actaprendizaje.Domain.Ruta;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RutaRepository extends CrudRepository<Ruta, Long> {

    List<Ruta> findAll();
    List<Ruta> findBySalidaRutaAndCircularAndEpoca(String salidaRuta, boolean circular, String epoca);
   // la que da error YA NO DA AL COMPILAR
    @Query(value = "SELECT r FROM ruta r WHERE r.sector_id = (?1)", nativeQuery = true)
    List<Ruta> findAllIdSec(long idSec);

}
