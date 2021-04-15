package com.svalero.actaprendizaje.Domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "autobus")
public class Autobus {

    @Schema(description = "Identificador del autobus", example = "1", required = true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    @Schema(description = "Punto de salida del autobus", example = "Torla", required = true)
    @Column
    @NotBlank
    private String inicioBus;

    @Schema(description = "Punto de llegada del autobus", example = "Pradera de Ordesa", required = true)
    @Column
    @NotBlank
    private String finBus;

    @Schema(description = "Si permite mascotas", example = "true")
    @Column
    private boolean mascota;

    @Schema(description = "Numero de plazas en el autobus", example = "55")
    @Column
    private int plazas;

    @Schema(description = "Precio del servicio", example = "2.5")
    @Column
    private float precio;

    @Schema(description = "Fecha de inicio del servicio", example = "01/06/2021")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate fechaBus;




    @ManyToOne(optional = false)
    //@JsonBackReference
    @JoinColumn(name = "sector_id")
    private Sector sector;
}
