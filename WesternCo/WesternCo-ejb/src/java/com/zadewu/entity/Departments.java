/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zadewu.entity;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Harrik
 */
@Entity
@Table(name = "Departments")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Departments.findAll", query = "SELECT d FROM Departments d")
    , @NamedQuery(name = "Departments.findByDepId", query = "SELECT d FROM Departments d WHERE d.depId = :depId")
    , @NamedQuery(name = "Departments.findByDepName", query = "SELECT d FROM Departments d WHERE d.depName = :depName")
    , @NamedQuery(name = "Departments.findByIsAva", query = "SELECT d FROM Departments d WHERE d.isAva = :isAva")})
public class Departments implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "depId")
    private Integer depId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "depName")
    private String depName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isAva")
    private boolean isAva;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "depId")
    private Collection<Employees> employeesCollection;

    public Departments() {
    }

    public Departments(Integer depId) {
        this.depId = depId;
    }

    public Departments(Integer depId, String depName, boolean isAva) {
        this.depId = depId;
        this.depName = depName;
        this.isAva = isAva;
    }

    public Integer getDepId() {
        return depId;
    }

    public void setDepId(Integer depId) {
        this.depId = depId;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public boolean getIsAva() {
        return isAva;
    }

    public void setIsAva(boolean isAva) {
        this.isAva = isAva;
    }

    @XmlTransient
    public Collection<Employees> getEmployeesCollection() {
        return employeesCollection;
    }

    public void setEmployeesCollection(Collection<Employees> employeesCollection) {
        this.employeesCollection = employeesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (depId != null ? depId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Departments)) {
            return false;
        }
        Departments other = (Departments) object;
        if ((this.depId == null && other.depId != null) || (this.depId != null && !this.depId.equals(other.depId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zadewu.entity.Departments[ depId=" + depId + " ]";
    }
    
}
