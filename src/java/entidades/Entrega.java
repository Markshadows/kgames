/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Desconocido
 */
@Entity
@Table(name = "entrega")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Entrega.findAll", query = "SELECT e FROM Entrega e")
    , @NamedQuery(name = "Entrega.findByIdkeyCod", query = "SELECT e FROM Entrega e WHERE e.idkeyCod = :idkeyCod")})
public class Entrega implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_keyCod")
    private Integer idkeyCod;
    @JoinColumn(name = "id_pago", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Compra idPago;

    public Entrega() {
    }

    public Entrega(Integer idkeyCod) {
        this.idkeyCod = idkeyCod;
    }

    public Integer getIdkeyCod() {
        return idkeyCod;
    }

    public void setIdkeyCod(Integer idkeyCod) {
        this.idkeyCod = idkeyCod;
    }

    public Compra getIdPago() {
        return idPago;
    }

    public void setIdPago(Compra idPago) {
        this.idPago = idPago;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idkeyCod != null ? idkeyCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entrega)) {
            return false;
        }
        Entrega other = (Entrega) object;
        if ((this.idkeyCod == null && other.idkeyCod != null) || (this.idkeyCod != null && !this.idkeyCod.equals(other.idkeyCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Entrega[ idkeyCod=" + idkeyCod + " ]";
    }
    
}
