package com.svalero.actaprendizaje.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class RutaDTO {

    private long id;
    private String nombreRuta;
    private String salidaRuta;
    private String finRuta;
    private float distancia;
    private boolean circular;
    private String epoca;
    private int dificultad;
    private String material;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate fecha;

    private long sector_id;
    private long cima_id;

}
