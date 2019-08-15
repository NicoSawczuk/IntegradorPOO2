/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.List;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author nico2
 */
public class Foro {
    private int idForo;
    private String titulo;
    
    //Relaciones
    @ManyToOne
    private Tema tema;
    @OneToMany(mappedBy = "foro")
    private List<Pregunta> preguntas;
    
    
    //Metodos de los DSD
    
}
