/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.List;
import javax.persistence.OneToMany;

/**
 *
 * @author nico2
 */
public class Tema {
    private int idTema;
    private String titulo;
    
    //Relaciones
    @OneToMany(mappedBy = "tema")
    private List<Foro> foros;
    
    
    //Metodos de los DSD
}
