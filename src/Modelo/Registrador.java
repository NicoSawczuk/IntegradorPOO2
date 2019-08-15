/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author nico2
 */
@Entity
@DiscriminatorValue("registrador")
public class Registrador extends Universitario{

    public Registrador() {
    }
    
    //Metodos de los DSD
    
}
