/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.eventos.entities;

import javax.persistence.Entity;
/**
 *
 * @author Alberic Despres
 */
@Entity
public class PatrocinadorEntity extends UsuarioEntity {
    private String nit;
    
     /**
     * @return the nit
     */
    public String getNit(){
        return this.nit;
    };
    
     /**
     * @param newNit the nit to set
     */
    public void setNit(String newNit){
        this.nit=newNit;
    }
    
}