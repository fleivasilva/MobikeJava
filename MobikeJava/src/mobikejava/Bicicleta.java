/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobikejava;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Felipe
 */
@Entity
@Table(name = "bicicleta", catalog = "mobike_schema", schema = "")
@NamedQueries({
    @NamedQuery(name = "Bicicleta.findAll", query = "SELECT b FROM Bicicleta b")
    , @NamedQuery(name = "Bicicleta.findByIdBicicleta", query = "SELECT b FROM Bicicleta b WHERE b.idBicicleta = :idBicicleta")
    , @NamedQuery(name = "Bicicleta.findByLatitud", query = "SELECT b FROM Bicicleta b WHERE b.latitud = :latitud")
    , @NamedQuery(name = "Bicicleta.findByLongitud", query = "SELECT b FROM Bicicleta b WHERE b.longitud = :longitud")
    , @NamedQuery(name = "Bicicleta.findByCodigoMobike", query = "SELECT b FROM Bicicleta b WHERE b.codigoMobike = :codigoMobike")
    , @NamedQuery(name = "Bicicleta.findByEstadoCandado", query = "SELECT b FROM Bicicleta b WHERE b.estadoCandado = :estadoCandado")})
public class Bicicleta implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_BICICLETA")
    private Integer idBicicleta;
    @Column(name = "LATITUD")
    private String latitud;
    @Column(name = "LONGITUD")
    private String longitud;
    @Column(name = "CODIGO_MOBIKE")
    private String codigoMobike;
    @Column(name = "ESTADO_CANDADO")
    private String estadoCandado;

    public Bicicleta() {
    }

    public Bicicleta(Integer idBicicleta) {
        this.idBicicleta = idBicicleta;
    }

    public Integer getIdBicicleta() {
        return idBicicleta;
    }

    public void setIdBicicleta(Integer idBicicleta) {
        Integer oldIdBicicleta = this.idBicicleta;
        this.idBicicleta = idBicicleta;
        changeSupport.firePropertyChange("idBicicleta", oldIdBicicleta, idBicicleta);
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        String oldLatitud = this.latitud;
        this.latitud = latitud;
        changeSupport.firePropertyChange("latitud", oldLatitud, latitud);
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        String oldLongitud = this.longitud;
        this.longitud = longitud;
        changeSupport.firePropertyChange("longitud", oldLongitud, longitud);
    }

    public String getCodigoMobike() {
        return codigoMobike;
    }

    public void setCodigoMobike(String codigoMobike) {
        String oldCodigoMobike = this.codigoMobike;
        this.codigoMobike = codigoMobike;
        changeSupport.firePropertyChange("codigoMobike", oldCodigoMobike, codigoMobike);
    }

    public String getEstadoCandado() {
        return estadoCandado;
    }

    public void setEstadoCandado(String estadoCandado) {
        String oldEstadoCandado = this.estadoCandado;
        this.estadoCandado = estadoCandado;
        changeSupport.firePropertyChange("estadoCandado", oldEstadoCandado, estadoCandado);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBicicleta != null ? idBicicleta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bicicleta)) {
            return false;
        }
        Bicicleta other = (Bicicleta) object;
        if ((this.idBicicleta == null && other.idBicicleta != null) || (this.idBicicleta != null && !this.idBicicleta.equals(other.idBicicleta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mobikejava.Bicicleta[ idBicicleta=" + idBicicleta + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
