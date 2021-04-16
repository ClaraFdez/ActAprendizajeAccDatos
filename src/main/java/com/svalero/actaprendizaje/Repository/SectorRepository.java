package com.svalero.actaprendizaje.Repository;


import com.svalero.actaprendizaje.Domain.Sector;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface SectorRepository extends CrudRepository<Sector, Long> {

    @Query(value = "SELECT * FROM sector WHERE parque_id = (?1)", nativeQuery = true)
    List<Sector> findSectores(long parque_id);

}
