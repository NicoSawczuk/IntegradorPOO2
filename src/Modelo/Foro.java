/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author nico2
 */
@Entity
@Table (name="foro")
public class Foro {
    @Id
    @SequenceGenerator(name="sec_codForo", initialValue=1, allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sec_codForo")
    private int idForo;
    private String titulo;
    
    //Relaciones
    @ManyToOne
    private Tema tema;
    @OneToMany(mappedBy = "foro")
    private List<Pregunta> preguntas;
    
    
    //Metodos de los DSD

    public Foro() {
    }

    public void cargarForo(String titulo) {
       this.titulo = titulo;
    }

    public void asociarTema(Tema unTema) {
        this.tema = unTema;
    }

    public Tema getTema() {
        return tema;
    }

    @Override
    public String toString() {
        return titulo;
    }

    public void add(Pregunta unaPregunta) {
       this.preguntas.add(unaPregunta);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    
    
    
}
