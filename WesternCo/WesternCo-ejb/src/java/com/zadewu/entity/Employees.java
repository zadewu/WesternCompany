/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zadewu.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Harrik
 */
@Entity
@Table(name = "Employees")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employees.findAll", query = "SELECT e FROM Employees e")
    , @NamedQuery(name = "Employees.findByEmpId", query = "SELECT e FROM Employees e WHERE e.empId = :empId")
    , @NamedQuery(name = "Employees.findByEmpName", query = "SELECT e FROM Employees e WHERE e.empName = :empName")
    , @NamedQuery(name = "Employees.findByEmpDoB", query = "SELECT e FROM Employees e WHERE e.empDoB = :empDoB")
    , @NamedQuery(name = "Employees.findByIsAva", query = "SELECT e FROM Employees e WHERE e.isAva = :isAva")})
public class Employees implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "empId")
    private String empId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "empName")
    private String empName;
    @Column(name = "empDoB")
    @Temporal(TemporalType.DATE)
    private Date empDoB;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isAva")
    private boolean isAva;
    @JoinColumn(name = "depId", referencedColumnName = "depId")
    @ManyToOne(optional = false)
    private Departments depId;
    @JoinColumn(name = "rolId", referencedColumnName = "rolId")
    @ManyToOne(optional = false)
    private Roles rolId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empId")
    private Collection<Users> usersCollection;

    public Employees() {
    }

    public Employees(String empId) {
        this.empId = empId;
    }

    public Employees(String empId, String empName, boolean isAva) {
        this.empId = empId;
        this.empName = empName;
        this.isAva = isAva;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Date getEmpDoB() {
        return empDoB;
    }

    public void setEmpDoB(Date empDoB) {
        this.empDoB = empDoB;
    }

    public boolean getIsAva() {
        return isAva;
    }

    public void setIsAva(boolean isAva) {
        this.isAva = isAva;
    }

    public Departments getDepId() {
        return depId;
    }

    public void setDepId(Departments depId) {
        this.depId = depId;
    }

    public Roles getRolId() {
        return rolId;
    }

    public void setRolId(Roles rolId) {
        this.rolId = rolId;
    }

    @XmlTransient
    public Collection<Users> getUsersCollection() {
        return usersCollection;
    }

    public void setUsersCollection(Collection<Users> usersCollection) {
        this.usersCollection = usersCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empId != null ? empId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employees)) {
            return false;
        }
        Employees other = (Employees) object;
        if ((this.empId == null && other.empId != null) || (this.empId != null && !this.empId.equals(other.empId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zadewu.entity.Employees[ empId=" + empId + " ]";
    }
    
}
