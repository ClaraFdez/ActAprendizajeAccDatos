package com.svalero.actaprendizaje.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class AutobusDTO {

    private long id;
    private String inicioBus;
    private String finBus;
    private boolean mascota;
    private int plazas;

    private float precio;
    @JsonFormat(pattern = "dd/MM/yyyy")

    private LocalDate fechaBus;
    private long sector_id;

}
