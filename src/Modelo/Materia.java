/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author nico2
 */
@Entity
@Table (name="materia")
public class Materia {
    @Id
    private String nombre;
    
    //Relaciones
    @ManyToMany(mappedBy = "materias")
    private List<Profesor> profesores;

    public Materia() {
    }
    
    
    
    
}
