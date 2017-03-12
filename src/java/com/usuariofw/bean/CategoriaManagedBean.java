package com.usuariofw.bean;

import com.usuariofw.ejb.CategoriaFacade;
import com.usuariofw.entities.Categoria;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Cristian Suesca
 */
@Named(value = "categoriaManagedBean")
@RequestScoped
public class CategoriaManagedBean implements Serializable{
    
     @EJB
    private CategoriaFacade categoriaEJB;
    private Categoria categoria;

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    
       
    @PostConstruct
    public void init(){
    categoria = new Categoria();
    }
    
    
     public void registrarCategoria(){
        try {
            categoriaEJB.create(categoria);
        } catch (Exception e) {
        }
    }


  
    public CategoriaManagedBean() {
    }
    
}
