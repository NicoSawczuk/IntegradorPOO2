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
    
    
    //Setters and Getters
    
    public void setCorreo(String correo){
        this.correo = correo;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLegajo() {
        return legajo;
    }

    public void setLegajo(String legajo) {
        this.legajo = legajo;
    }

    public double getReputacion() {
        return reputacion;
    }

    public void setReputacion(double reputacion) {
        this.reputacion = reputacion;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getTipo() {
        return tipo;
    }
    
    public void setTipo(String tipo) {    
        this.tipo = tipo;
    }

    public List<Materia> getMaterias() {
        return materias;
    }
    
    
    //Metodo agregar materias
    public void agregarMaterias(Materia unaMateria){
        this.materias.add(unaMateria);
        unaMateria.AgregarUniversitario(this);
        
    }
    
    //Metodo eliminar materias
    public void eliminarMaterias(Materia unaMateria){
        this.materias.remove(unaMateria);
        unaMateria.eliminarUniversitario(this);
    }

    @Override
    public String toString() {
        return this.nombre+"    "+this.tipo+"    "+this.estado;
    }
    
}
