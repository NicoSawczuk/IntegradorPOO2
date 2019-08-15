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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author nico2
 */
@Entity
@Table (name="tema")
public class Tema {
    @Id
    @SequenceGenerator(name="sec_codTema", initialValue=1, allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sec_codTema")
    private int idTema;
    private String titulo;
    
    //Relaciones
    @OneToMany(mappedBy = "tema")
    private List<Foro> foros;
    
    
    //Metodos de los DSD

    public Tema() {
    }
    
}
