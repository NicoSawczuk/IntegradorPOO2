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
public class Respuesta {
    private int idRespueta;
    private String respuesta;
    private Date fecha;
    
    //Relaciones
    
    @ManyToOne
    private Pregunta pregunta;
    @OneToMany(mappedBy = "respuesta")
    private List<Voto> votos;
    
    //Metodos de los DSD
    
}
