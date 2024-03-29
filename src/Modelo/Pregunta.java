/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author nico2
 */
@Entity
@Table (name="pregunta")
public class Pregunta {
    @Id
    @SequenceGenerator(name="sec_codPregunta", initialValue=1, allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sec_codPregunta")
    private int idPregunta;
    private String titulo;
    private String descripcion;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;
    
    //Relaciones
    @ManyToOne
    private Foro foro;
    @OneToMany(mappedBy = "pregunta")
    private List<Respuesta> respuestas;
    @ManyToOne
    private Universitario universitario;
    
    
    //Metodos de los DSD

    public Pregunta() {
    }

    public Foro getForo() {
        return foro;
    }

    public void cargarPregunta(String titulo, String descripcion) {
       this.titulo = titulo;
       this.descripcion = descripcion;
       this.fecha = new Date();
       
    }

    public void asociarUniversitario(Universitario unUniversitario) {
        this.universitario = unUniversitario;
    }

    public void asociarForo(Foro unForo) {
        this.foro = unForo;
    }

    @Override
    public String toString() {
        return titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public Universitario getUniversitario() {
        return universitario;
    }
    
    
    //Metodos del DSD
    public void asociarRespuesta(Respuesta unaRespuesta){
        this.respuestas.add(unaRespuesta);
    }
    
    public boolean coincideUser(String nomyape){
        String autor = this.universitario.getApellido() + " " + this.universitario.getNombre(); 
        return autor.contains(nomyape);
    }
    public boolean coincideTitulo(String casiTitulo){
        String titulon = this.titulo; 
        return titulon.contains(casiTitulo);
    }
    public boolean coincideDescripcion(String casiDescripcion){
    
        String miDescripcion = this.descripcion; 
        return miDescripcion.contains(casiDescripcion);
    }

    public boolean claveConUser(String textoBuscado, String nomUser) {
        
        if(this.coincideUser(nomUser)){//aparece user
            if(this.coincideTitulo(textoBuscado)){//aparecce en titulo
            
                return true;
                
            }else{//o aparece en descripcion
                if(this.coincideDescripcion(textoBuscado)){
                
                    return true;
                
                }
            
            }
        
        }
       return false; 
    }

    public boolean claveSinUser(String textoBuscado) {
        
        if(this.coincideTitulo(textoBuscado)){//aparecce en titulo
            
                return true;
                
            }else{//o aparece en descripcion
                if(this.coincideDescripcion(textoBuscado)){
                
                    return true;
                
                }
            
            }
        
        return false;
        
    }

    public boolean tituloConUser(String textoBuscado, String nomUser) {
        
        if(this.coincideUser(nomUser)){
            
            return this.coincideTitulo(textoBuscado);
        
        
        
        }
        
        return false;
    }

    public boolean tituloSinUser(String textoBuscado) {
       return this.coincideTitulo(textoBuscado);
    }
    
    public void modificarPregunta(String titulo, String descripcion){
        this.titulo=titulo;
        this.descripcion=descripcion;
    }
    
    //Getters and Setters

    public List<Respuesta> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(List<Respuesta> respuestas) {
        this.respuestas = respuestas;
    }
    
    
    
    public void borrarRespuesta(Respuesta unaRespuesta){
        this.respuestas.remove(unaRespuesta);
        unaRespuesta.borrarPregunta(this);
    }
    
    
    public void eliminarUniversitario(Universitario unUniversitario){
        this.universitario=null;
    }
    
    public void eliminarForo(Foro unForo){
        this.foro=null;
    }
    
    public void eliminarRespuestas(){
        this.respuestas.removeAll(respuestas);
    }
    
}
