/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Richy
 */
@Entity
@Table(name = "notaventa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Notaventa.findAll", query = "SELECT n FROM Notaventa n"),
    @NamedQuery(name = "Notaventa.findByIdNotaventa", query = "SELECT n FROM Notaventa n WHERE n.idNotaventa = :idNotaventa"),
    @NamedQuery(name = "Notaventa.findByCantidad", query = "SELECT n FROM Notaventa n WHERE n.cantidad = :cantidad")})
public class Notaventa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_NOTAVENTA")
    private Integer idNotaventa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDAD")
    private int cantidad;
    @JoinColumn(name = "ID_PRODUCTO", referencedColumnName = "ID_PRODUCTO")
    @ManyToOne(optional = false)
    private Producto idProducto;
    @JoinColumn(name = "ID_VENTA", referencedColumnName = "ID_VENTA")
    @ManyToOne(optional = false)
    private Venta idVenta;

    public Notaventa() {
    }

    public Notaventa(Integer idNotaventa) {
        this.idNotaventa = idNotaventa;
    }

    public Notaventa(Integer idNotaventa, int cantidad) {
        this.idNotaventa = idNotaventa;
        this.cantidad = cantidad;
    }

    public Integer getIdNotaventa() {
        return idNotaventa;
    }

    public void setIdNotaventa(Integer idNotaventa) {
        this.idNotaventa = idNotaventa;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    public Venta getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Venta idVenta) {
        this.idVenta = idVenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNotaventa != null ? idNotaventa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Notaventa)) {
            return false;
        }
        Notaventa other = (Notaventa) object;
        if ((this.idNotaventa == null && other.idNotaventa != null) || (this.idNotaventa != null && !this.idNotaventa.equals(other.idNotaventa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Notaventa[ idNotaventa=" + idNotaventa + " ]";
    }
    
}
