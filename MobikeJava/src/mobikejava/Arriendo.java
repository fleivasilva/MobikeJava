/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobikejava;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author Felipe
 */
@Entity
@Table(name = "arriendo", catalog = "mobike_schema", schema = "")
@NamedQueries({
    @NamedQuery(name = "Arriendo.findAll", query = "SELECT a FROM Arriendo a")
    , @NamedQuery(name = "Arriendo.findByIdArriendo", query = "SELECT a FROM Arriendo a WHERE a.idArriendo = :idArriendo")
    , @NamedQuery(name = "Arriendo.findByCodigoArriendo", query = "SELECT a FROM Arriendo a WHERE a.codigoArriendo = :codigoArriendo")
    , @NamedQuery(name = "Arriendo.findByHoraRegistro", query = "SELECT a FROM Arriendo a WHERE a.horaRegistro = :horaRegistro")
    , @NamedQuery(name = "Arriendo.findByCliente", query = "SELECT a FROM Arriendo a WHERE a.cliente = :cliente")
    , @NamedQuery(name = "Arriendo.findByBicicleta", query = "SELECT a FROM Arriendo a WHERE a.bicicleta = :bicicleta")})
public class Arriendo implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_ARRIENDO")
    private Integer idArriendo;
    @Column(name = "CODIGO_ARRIENDO")
    private String codigoArriendo;
    @Column(name = "HORA_REGISTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaRegistro;
    @Column(name = "CLIENTE")
    private Integer cliente;
    @Column(name = "BICICLETA")
    private Integer bicicleta;
    @JoinColumn(name = "CLIENTE", referencedColumnName = "ID_CLIENTE", updatable = false, insertable = false)
    @ManyToOne
    private Cliente cliente2;

    public Arriendo() {
    }

    public Arriendo(Integer idArriendo) {
        this.idArriendo = idArriendo;
    }

    public Integer getIdArriendo() {
        return idArriendo;
    }

    public void setIdArriendo(Integer idArriendo) {
        Integer oldIdArriendo = this.idArriendo;
        this.idArriendo = idArriendo;
        changeSupport.firePropertyChange("idArriendo", oldIdArriendo, idArriendo);
    }

    public String getCodigoArriendo() {
        return codigoArriendo;
    }

    public void setCodigoArriendo(String codigoArriendo) {
        String oldCodigoArriendo = this.codigoArriendo;
        this.codigoArriendo = codigoArriendo;
        changeSupport.firePropertyChange("codigoArriendo", oldCodigoArriendo, codigoArriendo);
    }

    public Date getHoraRegistro() {
        return horaRegistro;
    }

    public void setHoraRegistro(Date horaRegistro) {
        Date oldHoraRegistro = this.horaRegistro;
        this.horaRegistro = horaRegistro;
        changeSupport.firePropertyChange("horaRegistro", oldHoraRegistro, horaRegistro);
    }

    public Integer getCliente() {
        return cliente;
    }

    public void setCliente(Integer cliente) {
        Integer oldCliente = this.cliente;
        this.cliente = cliente;
        changeSupport.firePropertyChange("cliente", oldCliente, cliente);
    }

    public Integer getBicicleta() {
        return bicicleta;
    }

    public void setBicicleta(Integer bicicleta) {
        Integer oldBicicleta = this.bicicleta;
        this.bicicleta = bicicleta;
        changeSupport.firePropertyChange("bicicleta", oldBicicleta, bicicleta);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idArriendo != null ? idArriendo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Arriendo)) {
            return false;
        }
        Arriendo other = (Arriendo) object;
        if ((this.idArriendo == null && other.idArriendo != null) || (this.idArriendo != null && !this.idArriendo.equals(other.idArriendo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mobikejava.Arriendo[ idArriendo=" + idArriendo + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

    public Cliente getCliente2() {
        return cliente2;
    }

    public void setCliente2(Cliente cliente2) {
        Cliente oldCliente2 = this.cliente2;
        this.cliente2 = cliente2;
        changeSupport.firePropertyChange("cliente2", oldCliente2, cliente2);
    }
    
}
