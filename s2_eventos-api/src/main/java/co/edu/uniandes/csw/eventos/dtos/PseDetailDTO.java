/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.eventos.dtos;

import co.edu.uniandes.csw.eventos.entities.PseEntity;
import java.io.Serializable;

/**
 *
 * @author Santiaguito Leal
 */
public class PseDetailDTO extends PseDTO implements Serializable{

    public PseDetailDTO() {
        super();
    }

    public PseDetailDTO(PseEntity pseEntity) {
        super(pseEntity);

    }

    public PseEntity toEntity() {
        PseEntity entidad = super.toEntity();

        return entidad;
    }
}
