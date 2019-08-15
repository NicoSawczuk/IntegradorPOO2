/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author nico2
 */
@Entity
@Table (name="respuesta")
public class Respuesta {
    @Id
    @SequenceGenerator(name="sec_codRespuesta", initialValue=1, allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sec_codRespuesta")
    private int idRespueta;
    private String respuesta;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;
    
    //Relaciones
    
    @ManyToOne
    private Pregunta pregunta;
    @OneToMany(mappedBy = "respuesta")
    private List<Voto> votos;
    
    //Metodos de los DSD

    public Respuesta() {
    }
    
    
}
