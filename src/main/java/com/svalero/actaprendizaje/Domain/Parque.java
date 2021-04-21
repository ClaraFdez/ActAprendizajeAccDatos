package com.svalero.actaprendizaje.Domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "parque")
public class Parque {

    @Schema(description = "Identificador del parque", example = "1", required = true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    @Schema(description = "Nombre del parque", example = "Parque Nacional de Ordesa y Monte Perdido", required = true)
    @Column
    private String nombreParque;

    @Schema(description = "Donde está localizado", example = "Huesca", required = true)
    @Column
    private String localizacion;

    @Schema(description = "Extensión del parque en km2", example = "156.1")
    @Column
    private float extParque;

    @Schema(description = "Año de creación del parque", example = "1918")
    @Column
    private int creacion;

    @Schema(description = "Si tiene buen acceso en coche", example = "true")
    @Column
    private boolean acceso;

    @Schema(description = "Fecha de aparición en la API", example = "27/03/2021")
    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column
    private LocalDate fechaParque;

}
