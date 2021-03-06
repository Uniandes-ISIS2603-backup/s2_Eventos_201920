/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.eventos.entities;

import java.io.Serializable;
import javax.persistence.Entity;

/**
 * @author Samuel Osorio
 */
@Entity
public abstract class MedioPagoEntity extends BaseEntity implements Serializable {

    /**
     * numero de Recibo del pago
     */
    private String numeroRecibo;

    public MedioPagoEntity() {
        //Constructor
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public String getNumeroRecibo() {
        return numeroRecibo;
    }

    public void setNumeroRecibo(String pRecibo) {
        this.numeroRecibo = pRecibo;
    }
}
