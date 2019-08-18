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
        Universitario unEstudiante = new Universitario();
        try {
            unEstudiante.cargarDatos(nombre, apellido, dni, legajo, correo, tipoUsuario, fecha, direccion, sexo, pass);
            this.persistencia.insertar(unEstudiante);
            this.persistencia.confirmarTransaccion();
        } catch (Exception e) {
            this.persistencia.descartarTransaccion();
            System.err.println("No se pudo agregar el Estudiante");
        }
    }
    
    public void crearProfesor(String nombre, String apellido, int dni, String legajo, String correo, String tipoUsuario, Date fecha, String direccion, char sexo, String pass){
        this.persistencia.iniciarTransaccion();
        Universitario unProfesor = new Universitario();
        try {
            unProfesor.cargarDatos(nombre, apellido, dni, legajo, correo, tipoUsuario, fecha, direccion, sexo, pass);
            this.persistencia.insertar(unProfesor);
            this.persistencia.confirmarTransaccion();
        } catch (Exception e) {
            this.persistencia.descartarTransaccion();
            System.err.println("No se pudo agregar el Estudiante");
        }
    }
    
    
    //Editar
    public void editarEstudiante(Universitario unUniversitario,String nombre, String apellido, int dni, String legajo, String correo, String tipoUsuario, Date fecha, String direccion, char sexo, String pass){        
        this.persistencia.iniciarTransaccion();
        try {
            unUniversitario.setNombre(nombre);
            unUniversitario.setApellido(apellido);
            unUniversitario.setDni(dni);
            unUniversitario.setLegajo(legajo);
            unUniversitario.setCorreo(correo);
            unUniversitario.setTipo(tipoUsuario.toUpperCase());
            unUniversitario.setFechaNac(fecha);
            unUniversitario.setDireccion(direccion);
            unUniversitario.setSexo(sexo);
            unUniversitario.setPass(pass);
            this.persistencia.modificar(unUniversitario);
            this.persistencia.confirmarTransaccion();
        } catch (Exception e) {
            this.persistencia.descartarTransaccion();
            System.err.println("No se pudo editar el Estudiante");
        }
        
    }
    
    public void editarProfesor(Universitario unUniversitario,String nombre, String apellido, int dni, String legajo, String correo, String tipoUsuario, Date fecha, String direccion, char sexo, String pass){
        this.persistencia.iniciarTransaccion();
        try {
            unUniversitario.setNombre(nombre);
            unUniversitario.setApellido(apellido);
            unUniversitario.setDni(dni);
            unUniversitario.setLegajo(legajo);
            unUniversitario.setCorreo(correo);
            unUniversitario.setTipo(tipoUsuario.toUpperCase());
            unUniversitario.setFechaNac(fecha);
            unUniversitario.setDireccion(direccion);
            unUniversitario.setSexo(sexo);
            unUniversitario.setPass(pass);
            this.persistencia.modificar(unUniversitario);
            this.persistencia.confirmarTransaccion();
        } catch (Exception e) {
            this.persistencia.descartarTransaccion();
            System.err.println("No se pudo editar el Profesor");
        }
    }
    
    //Borrar
    public void borrarUsuario(Universitario unUniversitario){
        this.persistencia.iniciarTransaccion();
        try {
            if (unUniversitario.isEstado() == true){
                unUniversitario.setEstado(false);
            }
            else{
                unUniversitario.setEstado(true);
            }
            this.persistencia.modificar(unUniversitario);
            this.persistencia.confirmarTransaccion();
        } catch (Exception e) {
            this.persistencia.descartarTransaccion();
            System.err.println("No se pudo cambiar el estado");
        }
        
    }
    
    //Asociar
    public void asociarMaterias(Materia unaMateria,Universitario unUniversitario){
        this.persistencia.iniciarTransaccion();
        try {
            unUniversitario.agregarMaterias(unaMateria);
            this.persistencia.modificar(unUniversitario);
            this.persistencia.modificar(unaMateria);
            this.persistencia.confirmarTransaccion();
        } catch (Exception e) {
            this.persistencia.descartarTransaccion();
            System.err.println("No se pudo asociar la materia");
        }
    }
    
    
    //Desasociar
    public void desasociarMateria(Materia unaMateria, Universitario unUniversitario){
        this.persistencia.iniciarTransaccion();
        try {
            unUniversitario.eliminarMaterias(unaMateria);
            this.persistencia.modificar(unUniversitario);
            this.persistencia.modificar(unaMateria);
            this.persistencia.confirmarTransaccion();
        } catch (Exception e) {
            this.persistencia.descartarTransaccion();
            System.err.println("No se pudo desasociar la materia");
        }
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
