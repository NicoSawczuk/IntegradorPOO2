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
    
    public List listarUniversitarios(){
        List listaUniversitarios = this.persistencia.buscarTodos(Universitario.class);
        Universitario auxUniversitario;
        for (int i = 0; i <= listaUniversitarios.size()-1; i++){
            auxUniversitario = (Universitario) listaUniversitarios.get(i);
            if ("ADMINISTRADOR".equals(auxUniversitario.getTipo()) || "REGISTRADOR".equals(auxUniversitario.getTipo())){
                listaUniversitarios.remove(i);
            }
        }
        return listaUniversitarios;
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
        try {
            if (auxUniversitario.isEstado() == true){
                auxUniversitario.setEstado(false);
            }
            else{
                auxUniversitario.setEstado(true);
            }
            this.persistencia.modificar(auxUniversitario);
            this.persistencia.confirmarTransaccion();
        } catch (Exception e) {
            this.persistencia.descartarTransaccion();
            System.err.println("No se pudo cambiar el estado");
        }
        
    }
    
    //Asociar
    public void asociarMaterias(Materia auxMateria,Universitario auxUniversitario){
        this.persistencia.iniciarTransaccion();
        try {
            auxUniversitario.agregarMaterias(auxMateria);
            this.persistencia.modificar(auxUniversitario);
            this.persistencia.modificar(auxMateria);
            this.persistencia.confirmarTransaccion();
        } catch (Exception e) {
            this.persistencia.descartarTransaccion();
            System.err.println("No se pudo asociar la materia");
        }
    }
    
    
    //Desasociar
    public void desasociarMateria(Materia auxMateria, Universitario auxUniversitario){
        this.persistencia.iniciarTransaccion();
        try {
            auxUniversitario.eliminarMaterias(auxMateria);
            this.persistencia.modificar(auxUniversitario);
            this.persistencia.modificar(auxMateria);
            this.persistencia.confirmarTransaccion();
        } catch (Exception e) {
            this.persistencia.descartarTransaccion();
            System.err.println("No se pudo desasociar la materia");
        }
    }
    
    
}
