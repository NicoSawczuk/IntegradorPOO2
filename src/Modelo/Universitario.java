/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;
import java.util.List;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author nico2
 */
@Entity
@Table (name="universitario")
@Inheritance (strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo")
public abstract class Universitario {
    @Id
    private int dni;
    private String nombre;
    private String apellido;
    private String correo;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaNac;
    private String direccion;
    private char sexo;
    private boolean estado;
    private String pass;
    
    
    
    
    //Metodos de los DSD

    public Universitario() {
        this.estado=true;
    }
    
    
    
}
