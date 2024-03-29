/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Modelo.Foro;
import Modelo.Materia;
import Modelo.Pregunta;
import Modelo.Respuesta;
import Modelo.Tema;
import Modelo.Universitario;
import Modelo.Voto;
import dao.Persistencia;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static javafx.scene.input.KeyCode.T;

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
    
    public List listarRespuestas(Pregunta unaPregunta){
        List auxList = this.persistencia.buscarTodos(Respuesta.class);
        List listaR = new ArrayList<>();
        for (int i = 0; i < auxList.size(); i++) {
            Respuesta r1 = (Respuesta) auxList.get(i);
            if (r1.getPregunta() == unaPregunta ) {
                listaR.add(r1);
            }
        }
        
        return listaR;
                
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
    
    public void editarPregunta(Pregunta unaPregunta, String titulo, String descripcion){
       this.persistencia.iniciarTransaccion();
        try {
            unaPregunta.modificarPregunta(titulo, descripcion);
            this.persistencia.modificar(unaPregunta);
            this.persistencia.confirmarTransaccion();
        } catch (Exception e) {
            this.persistencia.descartarTransaccion();
            System.err.println("No se pudo editar la Pregunta");
        } 
    }
    
    public void editarRespuesta(Respuesta unaRespuesta, String respuesta){
        this.persistencia.iniciarTransaccion();
        try {
            unaRespuesta.modificarRespuesta(respuesta);
            this.persistencia.modificar(unaRespuesta);
            this.persistencia.confirmarTransaccion();
        } catch (Exception e) {
            this.persistencia.descartarTransaccion();
            System.err.println("No se pudo editar la Respuesta");
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
    
    public void eliminarRespuesta(Respuesta unaRespuesta){
        this.persistencia.iniciarTransaccion();
        try {
            List votos = unaRespuesta.getVotos();
            Pregunta unaPregunta = unaRespuesta.getPregunta();
            Universitario unUniversitario = unaRespuesta.getUniversitario();
            
            for (int i = 0; i < votos.size(); i++) {
                this.persistencia.eliminar(votos.get(i));
            }
            unaRespuesta.borrarVotos();
            
            unaRespuesta.borrarUniversitario(unUniversitario);
            unUniversitario.borrarRespuesta(unaRespuesta);
            
            unaRespuesta.borrarPregunta(unaPregunta);
            unaPregunta.borrarRespuesta(unaRespuesta);
            
            this.persistencia.modificar(unaRespuesta);
            this.persistencia.eliminar(unaRespuesta);
            this.persistencia.confirmarTransaccion();
            
        } catch (Exception e) {
            this.persistencia.descartarTransaccion();
            System.err.println("No se pudo eliminar la respuesta");
        }
    }
    
    public void eliminarPregunta(Pregunta unaPregunta){
        
        try {
            List listaRespuestas = unaPregunta.getRespuestas();
            for (int i = 0; i < listaRespuestas.size(); i++) {
                System.out.println(i);
                Respuesta unaRespuesta =(Respuesta) listaRespuestas.get(i);
                this.eliminarRespuesta(unaRespuesta);
            }
            this.persistencia.iniciarTransaccion();
            System.out.println("no salio del for");
            unaPregunta.eliminarRespuestas();
            
            Universitario unUniversitario = unaPregunta.getUniversitario();
            unUniversitario.eliminarPregunta(unaPregunta);
            
            Foro unForo = unaPregunta.getForo();
            unForo.eliminarPregunta(unaPregunta);

            
            this.persistencia.modificar(unaPregunta);
            this.persistencia.modificar(unForo);
            this.persistencia.modificar(unUniversitario);
            
            this.persistencia.eliminar(unaPregunta);
            this.persistencia.confirmarTransaccion();
            
        } catch (Exception e) {
            this.persistencia.descartarTransaccion();
            System.err.println("No se pudo eliminar la pregunta");
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
    
    public void publicarRespuesta(Universitario unUniversitario, String respuesta, Pregunta unaPregunta){
        this.persistencia.iniciarTransaccion();
        try {
            Respuesta unaRespuesta = new Respuesta();
            unaRespuesta.cargarRespuesta(respuesta);
            unaRespuesta.asociarPregunta(unaPregunta);
            unUniversitario.asociarRespuesta(unaRespuesta);
            unaRespuesta.asociarUniversitario(unUniversitario);
            this.persistencia.insertar(unaRespuesta);
            this.persistencia.modificar(unaPregunta);
            this.persistencia.modificar(unUniversitario);
            this.persistencia.confirmarTransaccion();
        } catch (Exception e) {
            this.persistencia.descartarTransaccion();
            System.err.println("No se pudo publicar la respuesta");
        }
    }
    
    
    public List verDatosUsuario(Universitario unUniversitario){
        
        this.persistencia.buscar(Universitario.class, unUniversitario.getDni());
        
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
            System.out.println("entro en null");
            List listaForos = unTema.getlistaForos();
            
            for (int i = 0; i < listaForos.size(); i++) {
                Foro f = (Foro) listaForos.get(i);
                List listaPreguntas = f.getPreguntas();
                
                for (int j = 0; j < listaPreguntas.size(); j++) {
                    Pregunta pg = (Pregunta) listaPreguntas.get(j);
                    boolean res;
                    if(textoBuscado.isEmpty()){//texto buscado es vacio
                        res = pg.coincideUser(nomUser.toUpperCase());
                    }else{//texto buscado no vacio
                        if(critCoinci){ //si la busqueda se realiza por coincidencia (palabra clave que este en algo de la pregunta)
                            
                            if(critUser){ //hacer que coincida con el usuario tambien
                                res = pg.claveConUser(textoBuscado.toUpperCase(),nomUser.toUpperCase());
                            }else{ 
                                res = pg.claveSinUser(textoBuscado.toUpperCase());
                            }
                        
                        }else{//busqueda solo en el titulo
                        
                            if(critUser){//hacer que coincida con el usuario tambien
                                res = pg.tituloConUser(textoBuscado.toUpperCase(),nomUser.toUpperCase());
                            }else{ // no importa el usuario, no hay
                                res = pg.tituloSinUser(textoBuscado.toUpperCase());
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
                        res = pg.coincideUser(nomUser.toUpperCase());
                    }else{//texto buscado no vacio
                        if(critCoinci){ //si la busqueda se realiza por coincidencia (palabra clave que este en algo de la pregunta)
                            
                            if(critUser){ //hacer que coincida con el usuario tambien
                                res = pg.claveConUser(textoBuscado.toUpperCase(),nomUser.toUpperCase());
                            }else{ 
                                res = pg.claveSinUser(textoBuscado.toUpperCase());
                            }
                        
                        }else{//busqueda solo en el titulo
                        
                            if(critUser){//hacer que coincida con el usuario tambien
                                res = pg.tituloConUser(textoBuscado.toUpperCase(),nomUser.toUpperCase());
                            }else{ // no importa el usuario, no hay
                                res = pg.tituloSinUser(textoBuscado.toUpperCase());
                            }
                            
                            
                        }
                    
                    }
                    
                    if(res){//si res es true se agrega la pregunta a la lista final
                        listaPreguntasFinales.add(pg);
                    }
                
                
                
                
                
            }
        
        
        
        
        
        
        }
        
        
        return listaPreguntasFinales;
    }

    public Voto votoExiste(Universitario universitario, Respuesta r1) {
        
        List auxList = this.persistencia.buscarTodos(Voto.class);
        List listaV = new ArrayList<>();
        for (int i = 0; i < auxList.size(); i++) {
            Voto v1 = (Voto) auxList.get(i);
            if (v1.getUniversitario() == universitario) {
                listaV.add(v1);
            }
        }
        
      
        List listaVotos =listaV;
        List listaVotosRespuesta = r1.getVotos();
        for (int i = 0; i < listaVotos.size(); i++) {
            Voto v1 = (Voto) listaVotos.get(i);
            
            
            for (int j = 0; j < listaVotosRespuesta.size(); j++) {
                Voto vr = (Voto) listaVotosRespuesta.get(j);
                if(v1==vr){
                
                    return v1;
                
                }
            }
        }
        
        
        return null;
    }

    public void votarRespuesta(Respuesta unaRespuesta, Universitario unUniversitario, boolean valor) {
        this.persistencia.iniciarTransaccion();
        try{
            //crear,cargar, asociar u, asociar resp
            //cargar v a uni
            //cargar v a resp
            Voto unVoto = new Voto();
            unVoto.cargarVoto(valor);
            unVoto.asociarVoto(unaRespuesta,unUniversitario);
            Universitario autor = unaRespuesta.getUniversitario();
            autor.setModificarReputacion(valor);
            
            unaRespuesta.addVoto(unVoto);
            unUniversitario.addVoto(unVoto);
            
            System.out.println("se creo el voto correctamente");
            
            this.persistencia.insertar(unVoto);
            this.persistencia.modificar(autor);
            this.persistencia.confirmarTransaccion();
        }catch(Exception e){
        
            this.persistencia.descartarTransaccion();
        }
    }

    public void modificarVoto(Voto existenteVoto, boolean b) {
        this.persistencia.iniciarTransaccion();
        try{
            Voto unVoto = existenteVoto;
            unVoto.cargarVoto(b);
            Universitario autor = unVoto.getRespuesta().getUniversitario();
            autor.setModificarReputacion(b);
            
            
            this.persistencia.modificar(unVoto);
            this.persistencia.modificar(autor);
            
            this.persistencia.confirmarTransaccion();
        }catch(Exception e){
        
            this.persistencia.descartarTransaccion();
        }
    }

    public int cantVotoPositivos(Respuesta unaRespuesta) {
        
        List auxList = this.persistencia.buscarTodos(Voto.class);
        List listaV = new ArrayList<>();
        for (int i = 0; i < auxList.size(); i++) {
            Voto v1 = (Voto) auxList.get(i);
            if (v1.getRespuesta() == unaRespuesta ) {
                listaV.add(v1);
            }
        }
        
        
        
        List votos = listaV;
        int cant = 0;
        for (int i = 0; i < votos.size(); i++) {
            Voto v1 = (Voto) votos.get(i);
            if(v1.isValor()){
                cant += 1;
            }
        }
        return cant;
    }

    public int cantVotoNegativos(Respuesta unaRespuesta) {
        
        List auxList = this.persistencia.buscarTodos(Voto.class);
        List listaV = new ArrayList<>();
        for (int i = 0; i < auxList.size(); i++) {
            Voto v1 = (Voto) auxList.get(i);
            if (v1.getRespuesta() == unaRespuesta ) {
                listaV.add(v1);
            }
        }
        
        
        
        List votos = listaV;
        int cant = 0;
        for (int i = 0; i < votos.size(); i++) {
            Voto v1 = (Voto) votos.get(i);
            if(!v1.isValor()){
                cant += 1;
            }
        }
        return cant;
    
    }
    
  
}
