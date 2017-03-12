/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usuariofw.bean;

import com.usuariofw.ejb.RolFacade;
import com.usuariofw.entities.Rol;
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
@Named(value = "rolManagedBean")
@RequestScoped
public class RolManagedBean implements Serializable, IManagedBean<Rol>{
    private Rol rol;
    @EJB private RolFacade rf;
    public RolManagedBean() {
    }
    
    @PostConstruct
public void init(){
rol = new Rol();
}

    @Override
    public Rol getObject(Integer i) {
     return rf.find(i);
    }

    public RolFacade getRf() {
        return rf;
    }

    public void setRf(RolFacade rf) {
        this.rf = rf;
    }
    
     public List<Rol> listar(){
    return rf.findAll();
    }
    
    public void create(){
    rf.create(rol);
    }
    
    
}
