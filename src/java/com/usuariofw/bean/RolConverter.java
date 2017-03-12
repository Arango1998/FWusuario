/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usuariofw.bean;

import com.usuariofw.entities.Rol;
import com.usuariofw.logica.AbstractConverter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Cristian Suesca
 */
@FacesConverter (forClass = Rol.class)
public class RolConverter extends AbstractConverter{
    
    public RolConverter(){
    super.namedBean = "rolManagedBean";
    }
    
}
