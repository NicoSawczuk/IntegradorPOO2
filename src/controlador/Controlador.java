/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Modelo.Foro;
import Modelo.Materia;
import Modelo.Pregunta;
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
    
    public void editarForo(Foro auxForo, String titulo){
        this.persistencia.iniciarTransaccion();
        try {
            auxForo.setTitulo(titulo);
            this.persistencia.modificar(auxForo);
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
    public void asociarMaterias(Materia unaMateria,Universitario unProfesor){
        this.persistencia.iniciarTransaccion();
        try {
            unProfesor.agregarMaterias(unaMateria);
            this.persistencia.modificar(unProfesor);
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
            unTema.add(unForo);
            this.persistencia.insertar(unForo);
            
            System.out.println("se creo foro");
            this.persistencia.confirmarTransaccion();
        }catch(Exception e){
            this.persistencia.descartarTransaccion();
        }

    }

    public List verForo(Tema unTema) {
         return unTema.obtenerListaForos();
    }

    public List buscarPreguntasDeForo(Foro auxForo) {
       List preguntas = persistencia.buscarTodos(Pregunta.class);
         List auxPreguntas = new ArrayList<>();
         for (int i = 0; i < preguntas.size(); i++) {
            Pregunta p1 = (Pregunta) preguntas.get(i);
             if (p1.getForo() == auxForo) {
                 auxPreguntas.add(p1);
             }
        }
         
         return auxPreguntas;
    }

    public void publicarPregunta(Universitario unUniversitario, String titulo, String descripcion, Foro unForo) {
        try{
            this.persistencia.iniciarTransaccion();
            
            Pregunta unaPregunta = new Pregunta();
            
            unaPregunta.cargarPregunta(titulo,descripcion);//cargo la pregunta
            unaPregunta.asociarUniversitario(unUniversitario); //asocio la pregunta
            unaPregunta.asociarForo(unForo);//asociar foro con la pregunta
            
            unUniversitario.add(unaPregunta);
            unForo.add(unaPregunta);
            
            this.persistencia.insertar(unaPregunta);
            
            System.out.println("se creo la pregunta");
            
            this.persistencia.confirmarTransaccion();
        }catch(Exception e){
            this.persistencia.descartarTransaccion();
        }
    }
    
    
    public List verDatosUsuario(Universitario unUniversitario){
        ArrayList datosUniversitario= new ArrayList();
        
        String dni = String.valueOf(unUniversitario.getDni());
        datosUniversitario.add(0, dni);
        
        String legajo = unUniversitario.getLegajo();
        datosUniversitario.add(1, legajo);
        
        
        String sexo = String.valueOf(unUniversitario.getSexo());
        datosUniversitario.add(2, sexo);
        
        String nombre = unUniversitario.getNombre();
        datosUniversitario.add(3, nombre);
        
        String apellido = unUniversitario.getApellido();
        datosUniversitario.add(4, apellido);
        
        String correo = unUniversitario.getCorreo();
        datosUniversitario.add(5, correo);
        
        String direccion = unUniversitario.getDireccion();
        datosUniversitario.add(6, direccion);
        
        return datosUniversitario;
    }

    public List realizarBusqueda(String textoBuscado, String nomUser, boolean critUser, boolean critCoinci, Tema unTema, Foro unForo) {
        
        List listaPreguntasFinales = new ArrayList<>();
        
        if (unForo == null) {
            
            List listaForos = unTema.getlistaForos();
            
            for (int i = 0; i < listaForos.size(); i++) {
                Foro f = (Foro) listaForos.get(i);
                List listaPreguntas = f.getPreguntas();
                
                for (int j = 0; j < listaPreguntas.size(); j++) {
                    Pregunta pg = (Pregunta) listaPreguntas.get(i);
                    boolean res;
                    if(textoBuscado.isEmpty()){//texto buscado es vacio
                        res = pg.coincideUser(nomUser);
                    }else{//texto buscado no vacio
                        if(critCoinci){ //si la busqueda se realiza por coincidencia (palabra clave que este en algo de la pregunta)
                            
                            if(critUser){ //hacer que coincida con el usuario tambien
                                res = pg.claveConUser(textoBuscado,nomUser);
                            }else{ 
                                res = pg.claveSinUser(textoBuscado);
                            }
                        
                        }else{//busqueda solo en el titulo
                        
                            if(critUser){//hacer que coincida con el usuario tambien
                                res = pg.claveConUser(textoBuscado,nomUser);
                            }else{ // no importa el usuario, no hay
                                res = pg.claveSinUser(textoBuscado);
                            }
                            
                            
                        }
                    
                    }
                    
                    if(res){//si res es true se agrega la pregunta a la lista final
                        listaPreguntasFinales.add(pg);
                    }
                    
                    
                }
                
            }
            
            
            
            
            
        }else{//si busco solo las preguntas que coincidan con el foro obtenido
            
            List listaPreguntas = unForo.getPreguntas();
            
            for (int i = 0; i < listaPreguntas.size(); i++) {
                Pregunta pg = (Pregunta) listaPreguntas.get(i);
                boolean res;
                    if(textoBuscado.isEmpty()){//texto buscado es vacio
                        res = pg.coincideUser(nomUser);
                    }else{//texto buscado no vacio
                        if(critCoinci){ //si la busqueda se realiza por coincidencia (palabra clave que este en algo de la pregunta)
                            
                            if(critUser){ //hacer que coincida con el usuario tambien
                                res = pg.claveConUser(textoBuscado,nomUser);
                            }else{ 
                                res = pg.claveSinUser(textoBuscado);
                            }
                        
                        }else{//busqueda solo en el titulo
                        
                            if(critUser){//hacer que coincida con el usuario tambien
                                res = pg.claveConUser(textoBuscado,nomUser);
                            }else{ // no importa el usuario, no hay
                                res = pg.claveSinUser(textoBuscado);
                            }
                            
                            
                        }
                    
                    }
                    
                    if(res){//si res es true se agrega la pregunta a la lista final
                        listaPreguntasFinales.add(pg);
                    }
                
                
                
                
                
            }
        
        
        
        
        
        
        }
        
        
        return null;
    }
    
    
}
