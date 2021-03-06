/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.eventos.dtos;

import co.edu.uniandes.csw.eventos.entities.ActividadEventoEntity;
import co.edu.uniandes.csw.eventos.entities.EventoEntity;
import co.edu.uniandes.csw.eventos.entities.LugarEntity;
import co.edu.uniandes.csw.eventos.entities.MemoriaEntity;
import co.edu.uniandes.csw.eventos.entities.PatrocinioEntity;
import co.edu.uniandes.csw.eventos.entities.UsuarioEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que extiende de {@link EventoDTO} para manejar las relaciones entre los
 * Eventos JSON y otros DTOs.
 *
 * @author Germán David Martínez Solano
 */
public class EventoDetailDTO extends EventoDTO implements Serializable {

    /**
     * Lista de tipo ActividadEventoDTO que contiene las actividades que están
     * asociadas a un evento
     */
    private List<ActividadEventoDTO> actividades;

    /**
     * Lista de tipo LugarDTO que contiene los lugares que están asociados a un
     * evento
     */
    private List<LugarDTO> lugares;

    /**
     * Lista de tipo MemoriaDTO que contiene las memorias que están asociadas a
     * un evento
     */
    private List<MemoriaDTO> memorias;

    /**
     * Lista de tipo PatrocinioDTO que contiene los patrocinios que están
     * asociados a un evento
     */
    private List<PatrocinioDTO> patrocinios;

    /**
     * Lista de tipo UsuarioDTO que contiene los usuarios que están asociados a
     * un evento
     */
    private List<UsuarioDTO> usuarios;

    /**
     * Constructor por defecto
     */
    public EventoDetailDTO() {
        super();
    }

    /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param eventoEntity entidad del evento para tranformar a DTO
     */
    public EventoDetailDTO(EventoEntity eventoEntity) {
        super(eventoEntity);
        if (eventoEntity.getActividadesEvento() != null) {
            actividades = new ArrayList<>();
            for (ActividadEventoEntity entityActividad : eventoEntity.getActividadesEvento()) {
                actividades.add(new ActividadEventoDTO(entityActividad));
            }
        }
        if (eventoEntity.getLugares() != null) {
            lugares = new ArrayList<>();
            for (LugarEntity entityLugar : eventoEntity.getLugares()) {
                lugares.add(new LugarDTO(entityLugar));
            }
        }
        if (eventoEntity.getMemorias() != null) {
            memorias = new ArrayList<>();
            for (MemoriaEntity memoria : eventoEntity.getMemorias()) {
                memorias.add(new MemoriaDTO(memoria));
            }
        }
        if (eventoEntity.getPatrocinios() != null) {
            patrocinios = new ArrayList<>();
            for (PatrocinioEntity patrocinio : eventoEntity.getPatrocinios()) {
                patrocinios.add(new PatrocinioDTO(patrocinio));
            }
        }
        if (eventoEntity.getUsuarios() != null) {
            usuarios = new ArrayList<>();
            for (UsuarioEntity invitadoE : eventoEntity.getUsuarios()) {
                usuarios.add(new UsuarioDTO(invitadoE));
            }
        }
    }

    /**
     * Transformar un DTO a un Entity
     *
     * @return DTO del evento para tranformar a Entity
     */
    @Override
    public EventoEntity toEntity() {
        EventoEntity entidad = super.toEntity();
        if (getActividades() != null) {
            List<ActividadEventoEntity> actividadesEntity = new ArrayList<>();
            for (ActividadEventoDTO dtoActividad : getActividades()) {
                actividadesEntity.add(dtoActividad.toEntity());
            }
            entidad.setActividadesEvento(actividadesEntity);
        }
        if (getLugares() != null) {
            List<LugarEntity> lugaresEntity = new ArrayList<>();
            for (LugarDTO dtoAuthor : getLugares()) {
                lugaresEntity.add(dtoAuthor.toEntity());
            }
            entidad.setLugares(lugaresEntity);
        }
        if (getMemorias() != null) {
            List<MemoriaEntity> memoriasEntity = new ArrayList<>();
            for (MemoriaDTO mem : getMemorias()) {
                memoriasEntity.add(mem.toEntity());
            }
            entidad.setMemorias(memoriasEntity);

        }
        if (getPatrocinios() != null) {
            List<PatrocinioEntity> patrociniosEntity = new ArrayList<>();
            for (PatrocinioDTO pat : getPatrocinios()) {
                patrociniosEntity.add(pat.toEntity());
            }
            entidad.setPatrocinios(patrociniosEntity);
        }
        if (getUsuarios() != null) {
            List<UsuarioEntity> usuariosEntity = new ArrayList<>();
            for (UsuarioDTO dtoUsuario : getUsuarios()) {
                usuariosEntity.add(dtoUsuario.toEntity());
            }
            entidad.setUsuarios(usuariosEntity);
        }
        return entidad;
    }

    /**
     * @return the lugares
     */
    public List<LugarDTO> getLugares() {
        return lugares;
    }

    /**
     * @param lugares the lugares to set
     */
    public void setLugares(List<LugarDTO> lugares) {
        this.lugares = lugares;
    }

    /**
     * @return the memorias
     */
    public List<MemoriaDTO> getMemorias() {
        return memorias;
    }

    /**
     * @param memorias the memorias to set
     */
    public void setMemorias(List<MemoriaDTO> memorias) {
        this.memorias = memorias;
    }

    /**
     * @return the patrocinios
     */
    public List<PatrocinioDTO> getPatrocinios() {
        return patrocinios;
    }

    /**
     * @param patrocinios the patrocinios to set
     */
    public void setPatrocinios(List<PatrocinioDTO> patrocinios) {
        this.patrocinios = patrocinios;
    }

    /**
     * @return the usuarios
     */
    public List<UsuarioDTO> getUsuarios() {
        return usuarios;
    }

    /**
     * @param usuarios the usuarios to set
     */
    public void setUsuarios(List<UsuarioDTO> usuarios) {
        this.usuarios = usuarios;
    }

    /**
     * @return the actividades
     */
    public List<ActividadEventoDTO> getActividades() {
        return actividades;
    }

    /**
     * @param actividades the actividades to set
     */
    public void setActividades(List<ActividadEventoDTO> actividades) {
        this.actividades = actividades;
    }

}
