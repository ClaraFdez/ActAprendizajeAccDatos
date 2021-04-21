package com.svalero.actaprendizaje.Domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "ruta")
public class Ruta {

    @Schema(description = "Identificador de la ruta", example = "1", required = true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    @Schema(description = "Nombre de la ruta", example = "Monte Perdido desde el Refugio de Goriz", required = true)
    @Column
    @NotBlank
    private String nombreRuta;

    @Schema(description = "Punto de salida de la ruta", example = "Refugio de Goriz", required = true)
    @Column
    @NotBlank
    private String salidaRuta;

    @Schema(description = "Punto final de la ruta", example = "Cima de Monte Perdido", required = true)
    @Column
    @NotBlank
    private String finRuta;

    @Schema(description = "Distancia total de la ruta en km", example = "9")
    @Column
    private float distancia;

    @Schema(description = "Si la ruta es circular", example = "false")
    @Column
    private boolean circular;

    @Schema(description = "Mejor época para hacer la ruta", example = "verano", required = true)
    @Column
    private String epoca;

    @Schema(description = "Dificultad de la ruta según la escala MIDE", example = "3")
    @Column
    private int dificultad;

    @Schema(description = "Material obligatorio/aconsejable", example = "crampones y piolet", required = true)
    @Column
    private String material;

    @Schema(description = "Fecha recomendada", example = "15/02/021")
    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column
    private LocalDate fecha;




    @ManyToOne(optional = false)
    @JoinColumn(name = "sector_id", nullable = false)
    private Sector sector;


    @ManyToOne(optional = false)
    @JoinColumn(name = "cima_id")
    private Cima cima;
}
