/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;
import java.util.List;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author nico2
 */
public class Pregunta {
    private int idPregunta;
    private String titulo;
    private String descripcion;
    private Date fecha;
    
    //Relaciones
    @ManyToOne
    private Foro foro;
    @OneToMany(mappedBy = "pregunta")
    private List<Respuesta> respuestas;
    
    
    //Metodos de los DSD
    
}
