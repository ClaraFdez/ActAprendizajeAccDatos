package com.svalero.actaprendizaje.Domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "cima")
public class Cima {

    @Schema(description = "Identificador de la Cima", example = "1", required = true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long idCima;

    @Schema(description = "Nombre de la cima", example = "Monte Perdido", required = true)
    @Column
    @NotBlank
    private String nombre;

    @Schema(description = "Altura del pico", example = "3348.5")
    @Column
    private float altura;

    @Schema(description = "Si es necesario escalar para llegar a la cima", example = "false")
    @Column
    private boolean escalada;

    @Schema(description = "Numero de vivacs en la cima o muy cerca", example = "2")
    @Column
    private int vivacs;


/*
    @Schema(description = "Listado de rutas que hacen una cima en concreto", example = "Monte Perdido desde Goriz (normal), Monte Perdido desde Goriz (escaleras), Monte Perdido desde el Balcon de Pineta")
    @ManyToMany(mappedBy = "cima")
    private List<Ruta> listaRutas;*/
}
