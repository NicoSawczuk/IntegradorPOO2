/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Modelo.Materia;
import Modelo.Universitario;
import dao.Persistencia;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author nico2
 */
public class Controlador {
    Persistencia persistencia;

    public Controlador(Persistencia p) {
        this.persistencia=p;
    }

    public boolean buscarUniversitario(String auxCorreo) {
        List universitarios = new ArrayList<>();
        universitarios = persistencia.buscarTodos(Universitario.class);
        
        for (int i = 0; i < universitarios.size(); i++) {
            Universitario auxU = (Universitario) universitarios.get(i);
            
            if (auxCorreo.equals(auxU.getCorreo())) {
                
                return true;
            }
        }
        
        return false;
    }

    public Universitario ObtenerUniversitario(String auxCorreo) {
        List universitarios = new ArrayList<>();
        universitarios = persistencia.buscarTodos(Universitario.class);
        
        for (int i = 0; i < universitarios.size(); i++) {
            Universitario auxU = (Universitario) universitarios.get(i);
            if (auxU.getCorreo() == auxCorreo) {
                return auxU;
            }
        }
        return null;
    }

    //Listar
    public List listarMaterias(){
        return this.persistencia.buscarTodos(Materia.class);
    }
    
    public List listarUsuarios(){
        return this.persistencia.buscarTodos(Universitario.class);
    }
    
    
    //Cargar
    public void crearEstudiante(String nombre, String apellido, int dni, String legajo, String correo, String tipoUsuario, Date fecha, String direccion, char sexo, String pass){
        this.persistencia.iniciarTransaccion();
        Universitario auxEstudiante = new Universitario();
        try {
            auxEstudiante.cargarDatos(nombre, apellido, dni, legajo, correo, tipoUsuario, fecha, direccion, sexo, pass);
            this.persistencia.insertar(auxEstudiante);
            this.persistencia.confirmarTransaccion();
        } catch (Exception e) {
            this.persistencia.descartarTransaccion();
            System.err.println("No se pudo agregar el Estudiante");
        }
    }
    
    public void CrearProfesor(String nombre, String apellido, int dni, String legajo, String correo, String tipoUsuario, Date fecha, String direccion, char sexo, String pass){
        this.persistencia.iniciarTransaccion();
        Universitario auxProfesor = new Universitario();
        try {
            auxProfesor.cargarDatos(nombre, apellido, dni, legajo, correo, tipoUsuario, fecha, direccion, sexo, pass);
            this.persistencia.insertar(auxProfesor);
            this.persistencia.confirmarTransaccion();
        } catch (Exception e) {
            this.persistencia.descartarTransaccion();
            System.err.println("No se pudo agregar el Estudiante");
        }
    }
    
    
    
}
