/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finflock.jpa;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Finflock-3
 */
@Entity
@Table(name = "Ib_ExecutionDetails")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IbExecutionDetails.findAll", query = "SELECT i FROM IbExecutionDetails i"),
    @NamedQuery(name = "IbExecutionDetails.findById", query = "SELECT i FROM IbExecutionDetails i WHERE i.id = :id"),
    @NamedQuery(name = "IbExecutionDetails.findByReqId", query = "SELECT i FROM IbExecutionDetails i WHERE i.reqId = :reqId"),
    @NamedQuery(name = "IbExecutionDetails.findBySymbol", query = "SELECT i FROM IbExecutionDetails i WHERE i.symbol = :symbol"),
    @NamedQuery(name = "IbExecutionDetails.findBySecType", query = "SELECT i FROM IbExecutionDetails i WHERE i.secType = :secType"),
    @NamedQuery(name = "IbExecutionDetails.findByCurrency", query = "SELECT i FROM IbExecutionDetails i WHERE i.currency = :currency"),
    @NamedQuery(name = "IbExecutionDetails.findByExecId", query = "SELECT i FROM IbExecutionDetails i WHERE i.execId = :execId"),
    @NamedQuery(name = "IbExecutionDetails.findByOrderId", query = "SELECT i FROM IbExecutionDetails i WHERE i.orderId = :orderId"),
    @NamedQuery(name = "IbExecutionDetails.findByShares", query = "SELECT i FROM IbExecutionDetails i WHERE i.shares = :shares")})
public class IbExecutionDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Column(name = "reqId")
    private Integer reqId;
    @Size(max = 50)
    @Column(name = "symbol")
    private String symbol;
    @Size(max = 50)
    @Column(name = "secType")
    private String secType;
    @Size(max = 50)
    @Column(name = "currency")
    private String currency;
    @Size(max = 50)
    @Column(name = "execId")
    private String execId;
    @Column(name = "orderId")
    private Integer orderId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "shares")
    private BigDecimal shares;

    public IbExecutionDetails() {
    }

    public IbExecutionDetails(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getReqId() {
        return reqId;
    }

    public void setReqId(Integer reqId) {
        this.reqId = reqId;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSecType() {
        return secType;
    }

    public void setSecType(String secType) {
        this.secType = secType;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getExecId() {
        return execId;
    }

    public void setExecId(String execId) {
        this.execId = execId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public BigDecimal getShares() {
        return shares;
    }

    public void setShares(BigDecimal shares) {
        this.shares = shares;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IbExecutionDetails)) {
            return false;
        }
        IbExecutionDetails other = (IbExecutionDetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.finflock.jpa.IbExecutionDetails[ id=" + id + " ]";
    }
    
}
