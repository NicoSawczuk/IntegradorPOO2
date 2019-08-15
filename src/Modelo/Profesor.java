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
@DiscriminatorValue("profesor")
public class Profesor extends Universitario{
    private String legajo;
    private double reputacion;
    private List materias;
    
    //Relaciones
    @OneToMany(mappedBy = "profesor")
    private List<Voto> votos;
    
    
    //Metodos de los DSD

    public Profesor() {
    }
    
    
}
