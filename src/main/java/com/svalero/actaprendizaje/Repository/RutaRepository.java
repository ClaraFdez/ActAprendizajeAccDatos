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

    @Query(value = "SELECT * FROM ruta  WHERE sector_id = (?1)", nativeQuery = true)
    List<Ruta> findAllIdSec(long sector_id);

}
