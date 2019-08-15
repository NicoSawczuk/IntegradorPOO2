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
@DiscriminatorValue("administrador")
public class Administrador extends Universitario{
    
    //Relaciones
    @OneToMany(mappedBy = "administrador")
    private List<Respuesta> respuestas;
    @OneToMany(mappedBy = "administrador")
    private List<Pregunta> preguntas;
    @OneToMany(mappedBy = "administrador")
    private List<Voto> votos;

    public Administrador() {
    }
    
    //Metodos de los DSD
    
    
}
