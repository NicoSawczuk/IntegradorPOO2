/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 *
 * @author nico2
 */
@Entity
@DiscriminatorValue("profesor")
public class Profesor extends Universitario{
    private String legajo;
    private double reputacion;
    
    //Relaciones
    @OneToMany(mappedBy = "profesor")
    private List<Voto> votos;
    @OneToMany(mappedBy = "profesor")
    private List<Respuesta> respuestas;
    @OneToMany(mappedBy = "profesor")
    private List<Pregunta> preguntas;
    @ManyToMany
    private List<Materia> materias;
    
    //Metodos de los DSD

    public Profesor() {
    }
    
    
}
