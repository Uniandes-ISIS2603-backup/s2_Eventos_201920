/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.eventos.ejb;

import co.edu.uniandes.csw.eventos.entities.EventoEntity;
import co.edu.uniandes.csw.eventos.entities.UsuarioEntity;
import co.edu.uniandes.csw.eventos.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.eventos.persistence.UsuarioPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Daniel Betancurth Dorado
 */
@Stateless
public class UsuarioLogic {

    private static final Logger LOGGER = Logger.getLogger(UsuarioLogic.class.getName());

    @Inject
    private UsuarioPersistence persistence;

    public UsuarioEntity createUsuario(UsuarioEntity usuario) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creación de un usuario");
        if (usuario.getNombre() == null) {
            throw new BusinessLogicException("El nombre del usuario esta vacio");
        }
        if (usuario.getEmpresa() == null) {
            throw new BusinessLogicException("El nombre de la empresa del usuario esta vacio");
        }
        if (usuario.getCorreo() == null) {
            throw new BusinessLogicException("El correo del usuario esta vacio");
        }
        if (usuario.getContrasena() == null) {
            throw new BusinessLogicException("La contraseña del usuario esta vacia");
        }
        if (usuario.getCodigoQR() == null) {
            throw new BusinessLogicException("El codigo QR del usuario es nulo");
        }
        if (usuario.getAsiste() == null) {
            throw new BusinessLogicException("La informacion de asistencia del usuario es nula");
        }
        if (usuario.getCorreo().contains("@uniandes.edu.co") == false) {
            throw new BusinessLogicException("El correo del usuario no es valido");
        }
        if (persistence.findByEmail(usuario.getCorreo()) != null) {
            throw new BusinessLogicException("El correo del usuario ya existe");
        }
        usuario = persistence.create(usuario);
        return usuario;
    }

    public List<UsuarioEntity> getUsuarios() {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar todos los usuarios");
        List<UsuarioEntity> usuarios = persistence.findAll();
        LOGGER.log(Level.INFO, "Termina proceso de consultar todos los usuarios");
        return usuarios;
    }

    public UsuarioEntity getUsuario(Long usuariosId) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar el usuario con id = {0}", usuariosId);
        UsuarioEntity usuarioEntity = persistence.find(usuariosId);
        if (usuarioEntity == null) {
            LOGGER.log(Level.INFO, "El usuario con el id = {0} no existe", usuariosId);
        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar el usuario con id = {0}", usuariosId);
        return usuarioEntity;
    }

    public UsuarioEntity updateUsuario(Long usuariosId, UsuarioEntity usuarioEntity) {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar usuario con id = {0}", usuariosId);
        UsuarioEntity newEntity = persistence.update(usuarioEntity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar usuario con id = {0}", usuarioEntity.getId());
        return newEntity;
    }

    public void deleteUsuario(Long usuariosId) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar el evento con id = {0}", usuariosId);
        List<EventoEntity> inscritos = getUsuario(usuariosId).getEventosInscritos();
        if (inscritos != null && !inscritos.isEmpty()) {
            throw new BusinessLogicException("No se puede borrar el usuario con id = " + usuariosId + " porque tiene eventos inscritos asociados");
        }
        List<EventoEntity> iEspeciales = getUsuario(usuariosId).getEventosInvitadosEspeciales();
        if (iEspeciales != null && !iEspeciales.isEmpty()) {
            throw new BusinessLogicException("No se puede borrar el usuario con id = " + usuariosId + " porque tiene eventos como invitado especial asociados");
        }
        persistence.delete(usuariosId);
        LOGGER.log(Level.INFO, "Termina proceso de borrer el evento con id = {0}", usuariosId);
    }
}
