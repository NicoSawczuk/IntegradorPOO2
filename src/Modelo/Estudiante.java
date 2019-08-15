/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 *
 * @author nico2
 */
@Entity
@DiscriminatorValue("estudiante")
public class Estudiante extends Universitario{
    private String legajo;
    private double reputacion;
    
    //Relaciones
    @OneToMany(mappedBy = "estudiante")
    private List<Voto> votos;
    @OneToMany(mappedBy = "estudiante")
    private List<Respuesta> respuestas;
    @OneToMany(mappedBy = "estudiante")
    private List<Pregunta> preguntas;
    
    
    //Metodos de los DSD

    public Estudiante() {
    }
    
    
}
