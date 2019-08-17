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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author nico2
 */
@Entity
@Table (name="universitario")
public class Universitario {
    @Id
    private int dni;
    private String nombre;
    private String legajo;
    private double reputacion;
    private String apellido;
    private String correo;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaNac;
    private String direccion;
    private char sexo;
    private boolean estado;
    private String pass;
    private String tipo;
    
    
    //Relaciones
    @ManyToMany
    private List<Materia> materias;
    
    @OneToMany(mappedBy = "universitario")
    private List<Voto> votos;
    
    @OneToMany(mappedBy = "universitario")
    private List<Pregunta> preguntas;
    
    @OneToMany(mappedBy = "universitario")
    private List<Respuesta> respuestas;
    
    
    //Metodos de los DSD

    public Universitario() {
        this.estado=true;
    }

    public String getCorreo() {
        return correo;
    }

   
    
    //Metodo para crear estudiante
    public void cargarDatos(String nombre, String apellido, int dni, String legajo, String correo, String tipoUsuario, Date fecha, String direccion, char sexo, String pass){
        this.nombre=nombre;
        this.apellido=apellido;
        this.dni=dni;
        this.legajo=legajo;
        this.correo=correo;
        this.tipo=tipoUsuario.toUpperCase();
        this.fechaNac=fecha;
        this.direccion=direccion;
        this.sexo=sexo;
        this.pass=pass;
    }
    
    
    @Override
    public String toString(){
        return this.nombre+"    "+this.tipo+"    "+this.estado;
    }
    
}
