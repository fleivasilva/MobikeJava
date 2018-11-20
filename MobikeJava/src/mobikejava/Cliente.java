/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobikejava;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Felipe
 */
@Entity
@Table(name = "cliente", catalog = "mobike_schema", schema = "")
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")
    , @NamedQuery(name = "Cliente.findByIdCliente", query = "SELECT c FROM Cliente c WHERE c.idCliente = :idCliente")
    , @NamedQuery(name = "Cliente.findByRut", query = "SELECT c FROM Cliente c WHERE c.rut = :rut")
    , @NamedQuery(name = "Cliente.findByNombreCompleto", query = "SELECT c FROM Cliente c WHERE c.nombreCompleto = :nombreCompleto")
    , @NamedQuery(name = "Cliente.findByEdad", query = "SELECT c FROM Cliente c WHERE c.edad = :edad")
    , @NamedQuery(name = "Cliente.findByMedioPago", query = "SELECT c FROM Cliente c WHERE c.medioPago = :medioPago")
    , @NamedQuery(name = "Cliente.findByNumeroCelular", query = "SELECT c FROM Cliente c WHERE c.numeroCelular = :numeroCelular")
    , @NamedQuery(name = "Cliente.findByEmail", query = "SELECT c FROM Cliente c WHERE c.email = :email")})
public class Cliente implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_CLIENTE")
    private Integer idCliente;
    @Column(name = "RUT")
    private String rut;
    @Column(name = "NOMBRE_COMPLETO")
    private String nombreCompleto;
    @Column(name = "EDAD")
    private Integer edad;
    @Column(name = "MEDIO_PAGO")
    private String medioPago;
    @Column(name = "NUMERO_CELULAR")
    private String numeroCelular;
    @Column(name = "EMAIL")
    private String email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente2")
    private Collection<Arriendo> arriendoCollection;

    public Cliente() {
    }

    public Cliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        Integer oldIdCliente = this.idCliente;
        this.idCliente = idCliente;
        changeSupport.firePropertyChange("idCliente", oldIdCliente, idCliente);
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        String oldRut = this.rut;
        this.rut = rut;
        changeSupport.firePropertyChange("rut", oldRut, rut);
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        String oldNombreCompleto = this.nombreCompleto;
        this.nombreCompleto = nombreCompleto;
        changeSupport.firePropertyChange("nombreCompleto", oldNombreCompleto, nombreCompleto);
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        Integer oldEdad = this.edad;
        this.edad = edad;
        changeSupport.firePropertyChange("edad", oldEdad, edad);
    }

    public String getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(String medioPago) {
        String oldMedioPago = this.medioPago;
        this.medioPago = medioPago;
        changeSupport.firePropertyChange("medioPago", oldMedioPago, medioPago);
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(String numeroCelular) {
        String oldNumeroCelular = this.numeroCelular;
        this.numeroCelular = numeroCelular;
        changeSupport.firePropertyChange("numeroCelular", oldNumeroCelular, numeroCelular);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        String oldEmail = this.email;
        this.email = email;
        changeSupport.firePropertyChange("email", oldEmail, email);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCliente != null ? idCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.idCliente == null && other.idCliente != null) || (this.idCliente != null && !this.idCliente.equals(other.idCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mobikejava.Cliente[ idCliente=" + idCliente + " ]";
    }

    public Collection<Arriendo> getArriendoCollection() {
        return arriendoCollection;
    }

    public void setArriendoCollection(Collection<Arriendo> arriendoCollection) {
        this.arriendoCollection = arriendoCollection;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
