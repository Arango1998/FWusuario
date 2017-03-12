/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usuariofw.bean;

import com.usuariofw.ejb.UsuarioFacade;
import com.usuariofw.entities.Usuario;
import com.usuariofw.logica.IManagedBean;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author Cristian Suesca
 */
@Named(value = "usuarioManagedBean")
@RequestScoped
public class UsuarioManagedBean implements Serializable, IManagedBean<Usuario> {

    private Usuario usuario;
    @EJB
    private UsuarioFacade uf;
    @Inject
    private EstadoUsuarioManagedBean estadoUsuarioManagedBean;
    @Inject
    private RolManagedBean rolManagedBean;

    public UsuarioManagedBean() {
    }

    @PostConstruct
    public void init() {

        usuario = new Usuario();
    }

    @Override
    public Usuario getObject(Integer i) {
        return uf.find(i);
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public EstadoUsuarioManagedBean getEstadoUsuarioManagedBean() {
        return estadoUsuarioManagedBean;
    }

    public RolManagedBean getRolManagedBean() {
        return rolManagedBean;
    }

    public List<Usuario> listUsers() {

        return uf.findAll();
    }

    public void crearUsuario() {
        try {
            uf.create(usuario);
        } catch (Exception e) {
        }

    }

    public void crearUsuarioAcudiente() {
        try {
            usuario.setFkIdEstado(getEstadoUsuarioManagedBean().getObject(1));
            usuario.setFkIdTipoRol(getRolManagedBean().getObject(4));
            uf.create(usuario);
        } catch (Exception e) {
        }

    }

    public void crearUsuarioJugador() {
        try {
            usuario.setFkIdEstado(getEstadoUsuarioManagedBean().getObject(1));
            usuario.setFkIdTipoRol(getRolManagedBean().getObject(3));
            uf.create(usuario);
        } catch (Exception e) {
        }

    }

}
