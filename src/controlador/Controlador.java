/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Modelo.Foro;
import Modelo.Materia;
import Modelo.Tema;
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
            if (auxCorreo.equals(auxU.getCorreo())) {
                
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
    
    public void crearProfesor(String nombre, String apellido, int dni, String legajo, String correo, String tipoUsuario, Date fecha, String direccion, char sexo, String pass){
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
    
    
    //Editar
    public void editarEstudiante(Universitario auxUniversitario,String nombre, String apellido, int dni, String legajo, String correo, String tipoUsuario, Date fecha, String direccion, char sexo, String pass){        
        this.persistencia.iniciarTransaccion();
        try {
            auxUniversitario.setNombre(nombre);
            auxUniversitario.setApellido(apellido);
            auxUniversitario.setDni(dni);
            auxUniversitario.setLegajo(legajo);
            auxUniversitario.setCorreo(correo);
            auxUniversitario.setTipo(tipoUsuario.toUpperCase());
            auxUniversitario.setFechaNac(fecha);
            auxUniversitario.setDireccion(direccion);
            auxUniversitario.setSexo(sexo);
            auxUniversitario.setPass(pass);
            this.persistencia.modificar(auxUniversitario);
            this.persistencia.confirmarTransaccion();
        } catch (Exception e) {
            this.persistencia.descartarTransaccion();
            System.err.println("No se pudo editar el Estudiante");
        }
        
    }
    
    public void editarProfesor(Universitario auxUniversitario,String nombre, String apellido, int dni, String legajo, String correo, String tipoUsuario, Date fecha, String direccion, char sexo, String pass){
        this.persistencia.iniciarTransaccion();
        try {
            auxUniversitario.setNombre(nombre);
            auxUniversitario.setApellido(apellido);
            auxUniversitario.setDni(dni);
            auxUniversitario.setLegajo(legajo);
            auxUniversitario.setCorreo(correo);
            auxUniversitario.setTipo(tipoUsuario.toUpperCase());
            auxUniversitario.setFechaNac(fecha);
            auxUniversitario.setDireccion(direccion);
            auxUniversitario.setSexo(sexo);
            auxUniversitario.setPass(pass);
            this.persistencia.modificar(auxUniversitario);
            this.persistencia.confirmarTransaccion();
        } catch (Exception e) {
            this.persistencia.descartarTransaccion();
            System.err.println("No se pudo editar el Profesor");
        }
    }
    
    //Borrar
    public void borrarUsuario(Universitario auxUniversitario){
        this.persistencia.iniciarTransaccion();
        if (auxUniversitario.isEstado() == true){
            auxUniversitario.setEstado(false);
        }
        if(auxUniversitario.isEstado() != true){
            auxUniversitario.setEstado(true);
        }
        this.persistencia.modificar(auxUniversitario);
        this.persistencia.descartarTransaccion();
    }
    
    //Asociar
    public void asociarMaterias(Materia auxMateria,Universitario auxUniversitario){
        this.persistencia.iniciarTransaccion();
        auxUniversitario.agregarMaterias(auxMateria);
        this.persistencia.modificar(auxUniversitario);
        this.persistencia.modificar(auxMateria);
        this.persistencia.descartarTransaccion();
    }
    
    
    //Desasociar
    public void desasociarMateria(Materia auxMateria, Universitario auxUniversitario){
        this.persistencia.iniciarTransaccion();
        auxUniversitario.eliminarMaterias(auxMateria);
        this.persistencia.modificar(auxUniversitario);
        this.persistencia.modificar(auxMateria);
        this.persistencia.descartarTransaccion(); 
    }

    public List buscarListaTemas() {
        
        return this.persistencia.buscarTodos(Tema.class);
    }

    public void crearForo(Tema unTema, String titulo) {
        try{
            this.persistencia.iniciarTransaccion();
            //creo,cargo,asocio
            Foro unForo = new Foro();
            unForo.cargarForo(titulo);
            unForo.asociarTema(unTema);
            this.persistencia.insertar(unForo);
            
            System.out.println("se creo foro");
            this.persistencia.confirmarTransaccion();
        }catch(Exception e){
            this.persistencia.descartarTransaccion();
        }

    }

    public List buscarForosDeTema(Tema auxTema) {
         List foros = persistencia.buscarTodos(Foro.class);
         List auxForos = new ArrayList<>();
         for (int i = 0; i < foros.size(); i++) {
            Foro f1 = (Foro) foros.get(i);
             if (f1.getTema() == auxTema) {
                 auxForos.add(f1);
             }
        }
         
         return auxForos;
    }
    
    
}
