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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "Ib_Order_Status_A")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IbOrderStatusA.findAll", query = "SELECT i FROM IbOrderStatusA i"),
    @NamedQuery(name = "IbOrderStatusA.findById", query = "SELECT i FROM IbOrderStatusA i WHERE i.id = :id"),
    @NamedQuery(name = "IbOrderStatusA.findByOrderId", query = "SELECT i FROM IbOrderStatusA i WHERE i.orderId = :orderId"),
    @NamedQuery(name = "IbOrderStatusA.findByStatus", query = "SELECT i FROM IbOrderStatusA i WHERE i.status = :status"),
    @NamedQuery(name = "IbOrderStatusA.findByFilled", query = "SELECT i FROM IbOrderStatusA i WHERE i.filled = :filled"),
    @NamedQuery(name = "IbOrderStatusA.findByRemaining", query = "SELECT i FROM IbOrderStatusA i WHERE i.remaining = :remaining"),
    @NamedQuery(name = "IbOrderStatusA.findByAvgFillPrice", query = "SELECT i FROM IbOrderStatusA i WHERE i.avgFillPrice = :avgFillPrice"),
    @NamedQuery(name = "IbOrderStatusA.findByPermId", query = "SELECT i FROM IbOrderStatusA i WHERE i.permId = :permId"),
    @NamedQuery(name = "IbOrderStatusA.findByParentId", query = "SELECT i FROM IbOrderStatusA i WHERE i.parentId = :parentId"),
    @NamedQuery(name = "IbOrderStatusA.findByLastFillPrice", query = "SELECT i FROM IbOrderStatusA i WHERE i.lastFillPrice = :lastFillPrice"),
    @NamedQuery(name = "IbOrderStatusA.findByClientId", query = "SELECT i FROM IbOrderStatusA i WHERE i.clientId = :clientId"),
    @NamedQuery(name = "IbOrderStatusA.findByWhyHeld", query = "SELECT i FROM IbOrderStatusA i WHERE i.whyHeld = :whyHeld"),
    @NamedQuery(name = "IbOrderStatusA.findByMktCapPricemkt", query = "SELECT i FROM IbOrderStatusA i WHERE i.mktCapPricemkt = :mktCapPricemkt")})
public class IbOrderStatusA implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Integer id;
    @Column(name = "orderId")
    private Integer orderId;
    @Size(max = 50)
    @Column(name = "status")
    private String status;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "filled")
    private BigDecimal filled;
    @Column(name = "remaining")
    private BigDecimal remaining;
    @Column(name = "avgFillPrice")
    private BigDecimal avgFillPrice;
    @Column(name = "permId")
    private Integer permId;
    @Column(name = "parentId")
    private Integer parentId;
    @Column(name = "lastFillPrice")
    private BigDecimal lastFillPrice;
    @Column(name = "clientId")
    private Integer clientId;
    @Size(max = 50)
    @Column(name = "whyHeld")
    private String whyHeld;
    @Column(name = "mktCapPricemkt")
    private BigDecimal mktCapPricemkt;

    public IbOrderStatusA() {
    }

    public IbOrderStatusA(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getFilled() {
        return filled;
    }

    public void setFilled(BigDecimal filled) {
        this.filled = filled;
    }

    public BigDecimal getRemaining() {
        return remaining;
    }

    public void setRemaining(BigDecimal remaining) {
        this.remaining = remaining;
    }

    public BigDecimal getAvgFillPrice() {
        return avgFillPrice;
    }

    public void setAvgFillPrice(BigDecimal avgFillPrice) {
        this.avgFillPrice = avgFillPrice;
    }

    public Integer getPermId() {
        return permId;
    }

    public void setPermId(Integer permId) {
        this.permId = permId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public BigDecimal getLastFillPrice() {
        return lastFillPrice;
    }

    public void setLastFillPrice(BigDecimal lastFillPrice) {
        this.lastFillPrice = lastFillPrice;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public String getWhyHeld() {
        return whyHeld;
    }

    public void setWhyHeld(String whyHeld) {
        this.whyHeld = whyHeld;
    }

    public BigDecimal getMktCapPricemkt() {
        return mktCapPricemkt;
    }

    public void setMktCapPricemkt(BigDecimal mktCapPricemkt) {
        this.mktCapPricemkt = mktCapPricemkt;
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
        if (!(object instanceof IbOrderStatusA)) {
            return false;
        }
        IbOrderStatusA other = (IbOrderStatusA) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.finflock.jps.IbOrderStatusA[ id=" + id + " ]";
    }
    
}
