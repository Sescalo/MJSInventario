/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author sescalo
 */
public class Busqueda {
    private AtributosObjeto ab;
    private String input;

    
    public Busqueda() {
    
    }
    
    public Busqueda(AtributosObjeto ab, String input) {
        this.ab = ab;
        this.input = input;
    }
    

    public AtributosObjeto getAb() {
        return ab;
    }

    public void setAb(AtributosObjeto ab) {
        this.ab = ab;
    }
    
    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }
       
}
