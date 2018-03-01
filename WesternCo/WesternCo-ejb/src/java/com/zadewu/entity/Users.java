/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zadewu.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Harrik
 */
@Entity
@Table(name = "Users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u")
    , @NamedQuery(name = "Users.findByUId", query = "SELECT u FROM Users u WHERE u.uId = :uId")
    , @NamedQuery(name = "Users.findByUName", query = "SELECT u FROM Users u WHERE u.uName = :uName")
    , @NamedQuery(name = "Users.findByUPass", query = "SELECT u FROM Users u WHERE u.uPass = :uPass")
    , @NamedQuery(name = "Users.findByIsAva", query = "SELECT u FROM Users u WHERE u.isAva = :isAva")})
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "uId")
    private Integer uId;
    @Size(max = 50)
    @Column(name = "uName")
    private String uName;
    @Size(max = 50)
    @Column(name = "uPass")
    private String uPass;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isAva")
    private boolean isAva;
    @JoinColumn(name = "empId", referencedColumnName = "empId")
    @ManyToOne(optional = false)
    private Employees empId;

    public Users() {
    }

    public Users(Integer uId) {
        this.uId = uId;
    }

    public Users(Integer uId, boolean isAva) {
        this.uId = uId;
        this.isAva = isAva;
    }

    public Integer getUId() {
        return uId;
    }

    public void setUId(Integer uId) {
        this.uId = uId;
    }

    public String getUName() {
        return uName;
    }

    public void setUName(String uName) {
        this.uName = uName;
    }

    public String getUPass() {
        return uPass;
    }

    public void setUPass(String uPass) {
        this.uPass = uPass;
    }

    public boolean getIsAva() {
        return isAva;
    }

    public void setIsAva(boolean isAva) {
        this.isAva = isAva;
    }

    public Employees getEmpId() {
        return empId;
    }

    public void setEmpId(Employees empId) {
        this.empId = empId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uId != null ? uId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.uId == null && other.uId != null) || (this.uId != null && !this.uId.equals(other.uId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zadewu.entity.Users[ uId=" + uId + " ]";
    }
    
}
