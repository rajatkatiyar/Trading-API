/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finflock.jpa;

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
 * @author Finflock-3
 */
@Entity
@Table(name = "Ib_User_Info")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IbUserInfo.findAll", query = "SELECT i FROM IbUserInfo i"),
    @NamedQuery(name = "IbUserInfo.findByIbAccountId", query = "SELECT i FROM IbUserInfo i WHERE i.ibAccountId = :ibAccountId"),
    @NamedQuery(name = "IbUserInfo.findByIbUsername", query = "SELECT i FROM IbUserInfo i WHERE i.ibUsername = :ibUsername"),
    @NamedQuery(name = "IbUserInfo.findByIbAccountPassword", query = "SELECT i FROM IbUserInfo i WHERE i.ibAccountPassword = :ibAccountPassword"),
    @NamedQuery(name = "IbUserInfo.findByIbAccountType", query = "SELECT i FROM IbUserInfo i WHERE i.ibAccountType = :ibAccountType")})
public class IbUserInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ib_account_id")
    private String ibAccountId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ib_username")
    private String ibUsername;
    @Size(max = 10)
    @Column(name = "ib_account_password")
    private String ibAccountPassword;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "ib_account_type")
    private String ibAccountType;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ibAccountId")
    private Collection<IbOrders> ibOrdersCollection;

    public IbUserInfo() {
    }

    public IbUserInfo(String ibAccountId) {
        this.ibAccountId = ibAccountId;
    }

    public IbUserInfo(String ibAccountId, String ibUsername, String ibAccountType) {
        this.ibAccountId = ibAccountId;
        this.ibUsername = ibUsername;
        this.ibAccountType = ibAccountType;
    }

    public String getIbAccountId() {
        return ibAccountId;
    }

    public void setIbAccountId(String ibAccountId) {
        this.ibAccountId = ibAccountId;
    }

    public String getIbUsername() {
        return ibUsername;
    }

    public void setIbUsername(String ibUsername) {
        this.ibUsername = ibUsername;
    }

    public String getIbAccountPassword() {
        return ibAccountPassword;
    }

    public void setIbAccountPassword(String ibAccountPassword) {
        this.ibAccountPassword = ibAccountPassword;
    }

    public String getIbAccountType() {
        return ibAccountType;
    }

    public void setIbAccountType(String ibAccountType) {
        this.ibAccountType = ibAccountType;
    }

    @XmlTransient
    public Collection<IbOrders> getIbOrdersCollection() {
        return ibOrdersCollection;
    }

    public void setIbOrdersCollection(Collection<IbOrders> ibOrdersCollection) {
        this.ibOrdersCollection = ibOrdersCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ibAccountId != null ? ibAccountId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IbUserInfo)) {
            return false;
        }
        IbUserInfo other = (IbUserInfo) object;
        if ((this.ibAccountId == null && other.ibAccountId != null) || (this.ibAccountId != null && !this.ibAccountId.equals(other.ibAccountId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.finflock.jpa.IbUserInfo[ ibAccountId=" + ibAccountId + " ]";
    }
    
}
