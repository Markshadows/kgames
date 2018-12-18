/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Desconocido
 */
@Entity
@Table(name = "respuesta_ticket")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RespuestaTicket.findAll", query = "SELECT r FROM RespuestaTicket r")
    , @NamedQuery(name = "RespuestaTicket.findById", query = "SELECT r FROM RespuestaTicket r WHERE r.id = :id")
    , @NamedQuery(name = "RespuestaTicket.findByRespuesta", query = "SELECT r FROM RespuestaTicket r WHERE r.respuesta = :respuesta")
    , @NamedQuery(name = "RespuestaTicket.findByFecha", query = "SELECT r FROM RespuestaTicket r WHERE r.fecha = :fecha")})
public class RespuestaTicket implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "respuesta")
    private String respuesta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JoinColumn(name = "administrador", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Administrador administrador;
    @JoinColumn(name = "ticket", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Ticket ticket;

    public RespuestaTicket() {
    }

    public RespuestaTicket(Integer id) {
        this.id = id;
    }

    public RespuestaTicket(Integer id, String respuesta, Date fecha) {
        this.id = id;
        this.respuesta = respuesta;
        this.fecha = fecha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RespuestaTicket)) {
            return false;
        }
        RespuestaTicket other = (RespuestaTicket) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.RespuestaTicket[ id=" + id + " ]";
    }
    
}
