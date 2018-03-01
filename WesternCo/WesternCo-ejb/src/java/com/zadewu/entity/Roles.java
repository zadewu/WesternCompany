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
@Table(name = "Roles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Roles.findAll", query = "SELECT r FROM Roles r")
    , @NamedQuery(name = "Roles.findByRolId", query = "SELECT r FROM Roles r WHERE r.rolId = :rolId")
    , @NamedQuery(name = "Roles.findByRolName", query = "SELECT r FROM Roles r WHERE r.rolName = :rolName")
    , @NamedQuery(name = "Roles.findByIsAva", query = "SELECT r FROM Roles r WHERE r.isAva = :isAva")})
public class Roles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "rolId")
    private Integer rolId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "rolName")
    private String rolName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isAva")
    private boolean isAva;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rolId")
    private Collection<Employees> employeesCollection;

    public Roles() {
    }

    public Roles(Integer rolId) {
        this.rolId = rolId;
    }

    public Roles(Integer rolId, String rolName, boolean isAva) {
        this.rolId = rolId;
        this.rolName = rolName;
        this.isAva = isAva;
    }

    public Integer getRolId() {
        return rolId;
    }

    public void setRolId(Integer rolId) {
        this.rolId = rolId;
    }

    public String getRolName() {
        return rolName;
    }

    public void setRolName(String rolName) {
        this.rolName = rolName;
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
        hash += (rolId != null ? rolId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Roles)) {
            return false;
        }
        Roles other = (Roles) object;
        if ((this.rolId == null && other.rolId != null) || (this.rolId != null && !this.rolId.equals(other.rolId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zadewu.entity.Roles[ rolId=" + rolId + " ]";
    }
    
}
