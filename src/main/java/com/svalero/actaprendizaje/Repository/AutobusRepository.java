package com.svalero.actaprendizaje.Repository;

import com.svalero.actaprendizaje.Domain.Autobus;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface AutobusRepository extends CrudRepository<Autobus, Long> {


    @Query(value = "SELECT * FROM autobus  WHERE sector_id = (?1)", nativeQuery = true)
    List<Autobus> findBusSec(long sector_id);

}
