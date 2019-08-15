/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sistema;

import controlador.Controlador;
import dao.Persistencia;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author nico2
 */
public class Main {
    public static void main (String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("IntegradorPooPU");
        
        Persistencia p = new Persistencia(emf);
        Controlador c = new Controlador(p);
        //ventanaPrincipal v1 = new ventanaPrincipal(c);
        
    }
    
}
