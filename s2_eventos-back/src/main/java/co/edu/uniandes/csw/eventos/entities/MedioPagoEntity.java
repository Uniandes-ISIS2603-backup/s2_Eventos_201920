/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.eventos.entities;

import java.io.Serializable;
import javax.persistence.Entity;

/**
 *
 * @author Estudiante
 */
@Entity
public class MedioPagoEntity extends BaseEntity implements Serializable{
    private String numeroRecibo;
    
    public String getNumeroRecibo(){
        return numeroRecibo;
    }
    
    public void setNumeroRecibo(String pRecibo){
        this.numeroRecibo = pRecibo;
    }
}