package com.usuariofw.bean;

import com.usuariofw.ejb.EstadoUsuarioFacade;
import com.usuariofw.entities.EstadoUsuario;
import com.usuariofw.logica.IManagedBean;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Cristian Suesca
 */
@Named(value = "estadoUsuarioManagedBean")
@RequestScoped
public class EstadoUsuarioManagedBean implements Serializable, IManagedBean<EstadoUsuario> {

    private EstadoUsuario estadoUsuario;
    @EJB
    private EstadoUsuarioFacade ef;

    public EstadoUsuarioManagedBean() {
    }

    @PostConstruct
    public void init() {
        estadoUsuario = new EstadoUsuario();
    }

    @Override
    public EstadoUsuario getObject(Integer i) {
        return ef.find(i);
    }

    public EstadoUsuario getEstadoUsuario() {
        return estadoUsuario;
    }

    public void setEstadoUsuario(EstadoUsuario estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }

    public List<EstadoUsuario> listar() {
        return ef.findAll();
    }

    public void create() {
        ef.create(estadoUsuario);
    }

}
