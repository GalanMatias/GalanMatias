/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author alumno
 */
@Entity
@Table(name = "empleado", catalog = "municipiolaquiaca", schema = "")
@NamedQueries({
    @NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e")
    , @NamedQuery(name = "Empleado.findByNroDeLegajo", query = "SELECT e FROM Empleado e WHERE e.nroDeLegajo = :nroDeLegajo")
    , @NamedQuery(name = "Empleado.findByNombreYapellido", query = "SELECT e FROM Empleado e WHERE e.nombreYapellido = :nombreYapellido")
    , @NamedQuery(name = "Empleado.findByDni", query = "SELECT e FROM Empleado e WHERE e.dni = :dni")
    , @NamedQuery(name = "Empleado.findByFechaNac", query = "SELECT e FROM Empleado e WHERE e.fechaNac = :fechaNac")
    , @NamedQuery(name = "Empleado.findBySueldo", query = "SELECT e FROM Empleado e WHERE e.sueldo = :sueldo")})
public class Empleado implements Serializable, Comparable<Empleado> {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "nroDeLegajo", nullable = false)
    private Integer nroDeLegajo;
    @Column(name = "nombreYapellido", length = 50)
    private String nombreYapellido;
    @Column(name = "dni")
    private Integer dni;
    @Column(name = "fechaNac")
    @Temporal(TemporalType.DATE)
    private Date fechaNac;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "sueldo", precision = 12, scale = 0)
    private Float sueldo;

    public Empleado() {
    }

    public Empleado(Integer nroDeLegajo) {
        this.nroDeLegajo = nroDeLegajo;
    }

    public Integer getNroDeLegajo() {
        return nroDeLegajo;
    }

    public void setNroDeLegajo(Integer nroDeLegajo) {
        this.nroDeLegajo = nroDeLegajo;
    }

    public String getNombreYapellido() {
        return nombreYapellido;
    }

    public void setNombreYapellido(String nombreYapellido) {
        this.nombreYapellido = nombreYapellido;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public Float getSueldo() {
        return sueldo;
    }

    public void setSueldo(Float sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nroDeLegajo != null ? nroDeLegajo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.nroDeLegajo == null && other.nroDeLegajo != null) || (this.nroDeLegajo != null && !this.nroDeLegajo.equals(other.nroDeLegajo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Empleado[ nroDeLegajo=" + nroDeLegajo + " ]";
    }
    
    @Override
    public int compareTo(Empleado otroEmp){
        return getNombreYapellido().compareTo(otroEmp.getNombreYapellido());
    }
    
}
