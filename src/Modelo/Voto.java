/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import javax.persistence.ManyToOne;


/**
 *
 * @author nico2
 */
public class Voto {
    private int idVoto;
    private boolean valor;
    
    //Relaciones
    @ManyToOne
    private Respuesta respuesta;
    @ManyToOne
    private Profesor profesor;
    @ManyToOne
    private Estudiante estudiante;
    
    
    
}
