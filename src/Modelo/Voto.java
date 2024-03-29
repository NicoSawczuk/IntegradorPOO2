/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 *
 * @author nico2
 */
@Entity
@Table (name="voto")
public class Voto {
    @Id
    @SequenceGenerator(name="sec_codVoto", initialValue=1, allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sec_codVoto")
    private int idVoto;
    private boolean valor;
    
    //Relaciones
    @ManyToOne
    private Respuesta respuesta;
    @ManyToOne
    private Universitario universitario;
    

    public Voto() {
    }

    public void cargarVoto(boolean valor) {
        this.valor = valor;
        
    }

    public void asociarVoto(Respuesta unaRespuesta, Universitario unUniversitario) {
        this.respuesta = unaRespuesta;
        this.universitario = unUniversitario;
    }

    public boolean isValor() {
        return valor;
    }

    public Respuesta getRespuesta() {
        return respuesta;
    }
    
    //Metodos del DSD
    public void desasociarRespuesta(Respuesta unaRespuesta){
        this.respuesta = null;
    }
    
    public void desasociarUniversitario(Universitario unUniversitario){
        this.universitario=null;
    }

    public Universitario getUniversitario() {
        return universitario;
    }
    
    
    
}
