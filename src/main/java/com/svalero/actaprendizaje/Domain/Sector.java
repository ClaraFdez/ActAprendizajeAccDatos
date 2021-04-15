package com.svalero.actaprendizaje.Domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "sector")
public class Sector {

    @Schema(description = "Identificador del Sector", example = "1", required = true)
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Schema(description = "Nombre del sector", example = "Ordesa", required = true)
    @Column
    @NotBlank
    private String nombreSec;

    @Schema(description = "Extensión en km2", example = "254.5")
    @Column
    private float extensionSec;

    @Schema(description = "Numero de rutas que tiene ese sector", example = "15")
    @Column
    private int numRutas;

    @Schema(description = "Si posee acceso a través de autobus o similar", example = "true")
    @Column
    private boolean bus;

    @Schema(description = "Fecha de grabación en la API", example = "28/03/2021")
    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column
    private LocalDate fechaSec;



    @Schema(description = "Identificador del parque donde se encuentra un sector")
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn (name = "parque_id", nullable = false)
    private Parque parque;



}
