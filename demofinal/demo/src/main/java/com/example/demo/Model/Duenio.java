package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Duenio {
    @Id
    private Integer id;
    private String nombre;
    private String apellido;
    private Integer edad;
    @OneToMany(mappedBy = "duenio")
    @JsonIgnore
    private List<Auto> autos;
}
