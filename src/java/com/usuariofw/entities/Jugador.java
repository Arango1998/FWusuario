/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usuariofw.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Cristian Suesca
 */
@Entity
@Table(name = "jugadores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Jugador.findAll", query = "SELECT j FROM Jugador j"),
    @NamedQuery(name = "Jugador.findByIdUsuario", query = "SELECT j FROM Jugador j WHERE j.idUsuario = :idUsuario"),
    @NamedQuery(name = "Jugador.findByPosicion", query = "SELECT j FROM Jugador j WHERE j.posicion = :posicion")})
public class Jugador implements Serializable, IEntity {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_usuario")
    private Long idUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "posicion")
    private String posicion;
    @JoinColumn(name = "id_usuario", referencedColumnName = "documento", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.EAGER)
    private Usuario usuario;
    @JoinColumn(name = "fk_id_equipo", referencedColumnName = "id_equipo")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Equipo fkIdEquipo;

    public Jugador() {
    }

    public Jugador(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Jugador(Long idUsuario, String posicion) {
        this.idUsuario = idUsuario;
        this.posicion = posicion;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Equipo getFkIdEquipo() {
        return fkIdEquipo;
    }

    public void setFkIdEquipo(Equipo fkIdEquipo) {
        this.fkIdEquipo = fkIdEquipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Jugador)) {
            return false;
        }
        Jugador other = (Jugador) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.usuariofw.entities.Jugador[ idUsuario=" + idUsuario + " ]";
    }

    @Override
    public String getPK() {
    return idUsuario.toString();
    }
    
}
