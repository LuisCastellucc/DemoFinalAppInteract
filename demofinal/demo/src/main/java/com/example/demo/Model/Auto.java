package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Auto {
    @Id
    private Integer id;
    private String marca;
    private Integer anio;
    private Integer kilometros;
    private Integer nafta ;
    @ManyToOne
    @JoinColumn(name = "duenio_id")
    private Duenio duenio;
}
