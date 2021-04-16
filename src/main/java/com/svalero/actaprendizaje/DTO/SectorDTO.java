package com.svalero.actaprendizaje.DTO;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class SectorDTO {

    private long id;
    private String nombreSec;
    private float extensionSec;
    private int numRutas;
    private boolean bus;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate fechaSec;

    private long parque_id;

}
