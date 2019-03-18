/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finflock.jpa;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Finflock-3
 */
@Entity
@Table(name = "Ib_Orders")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IbOrders.findAll", query = "SELECT i FROM IbOrders i"),
    @NamedQuery(name = "IbOrders.findByOrderId", query = "SELECT i FROM IbOrders i WHERE i.orderId = :orderId"),
    @NamedQuery(name = "IbOrders.findByClientId", query = "SELECT i FROM IbOrders i WHERE i.clientId = :clientId"),
    @NamedQuery(name = "IbOrders.findByPermId", query = "SELECT i FROM IbOrders i WHERE i.permId = :permId"),
    @NamedQuery(name = "IbOrders.findByAction", query = "SELECT i FROM IbOrders i WHERE i.action = :action"),
    @NamedQuery(name = "IbOrders.findByTotalQuantity", query = "SELECT i FROM IbOrders i WHERE i.totalQuantity = :totalQuantity"),
    @NamedQuery(name = "IbOrders.findByOrderType", query = "SELECT i FROM IbOrders i WHERE i.orderType = :orderType"),
    @NamedQuery(name = "IbOrders.findByLimitPrice", query = "SELECT i FROM IbOrders i WHERE i.limitPrice = :limitPrice"),
    @NamedQuery(name = "IbOrders.findByAuxPrice", query = "SELECT i FROM IbOrders i WHERE i.auxPrice = :auxPrice"),
    @NamedQuery(name = "IbOrders.findByTif", query = "SELECT i FROM IbOrders i WHERE i.tif = :tif"),
    @NamedQuery(name = "IbOrders.findByOcagroup", query = "SELECT i FROM IbOrders i WHERE i.ocagroup = :ocagroup"),
    @NamedQuery(name = "IbOrders.findByOcatype", query = "SELECT i FROM IbOrders i WHERE i.ocatype = :ocatype"),
    @NamedQuery(name = "IbOrders.findByOrderref", query = "SELECT i FROM IbOrders i WHERE i.orderref = :orderref"),
    @NamedQuery(name = "IbOrders.findByTransmit", query = "SELECT i FROM IbOrders i WHERE i.transmit = :transmit"),
    @NamedQuery(name = "IbOrders.findByParentid", query = "SELECT i FROM IbOrders i WHERE i.parentid = :parentid"),
    @NamedQuery(name = "IbOrders.findByBlockorder", query = "SELECT i FROM IbOrders i WHERE i.blockorder = :blockorder"),
    @NamedQuery(name = "IbOrders.findBySweeptofill", query = "SELECT i FROM IbOrders i WHERE i.sweeptofill = :sweeptofill"),
    @NamedQuery(name = "IbOrders.findByDisplaysize", query = "SELECT i FROM IbOrders i WHERE i.displaysize = :displaysize"),
    @NamedQuery(name = "IbOrders.findByTriggermethod", query = "SELECT i FROM IbOrders i WHERE i.triggermethod = :triggermethod"),
    @NamedQuery(name = "IbOrders.findByOutsiderth", query = "SELECT i FROM IbOrders i WHERE i.outsiderth = :outsiderth"),
    @NamedQuery(name = "IbOrders.findByHidden", query = "SELECT i FROM IbOrders i WHERE i.hidden = :hidden"),
    @NamedQuery(name = "IbOrders.findByGoodaftertime", query = "SELECT i FROM IbOrders i WHERE i.goodaftertime = :goodaftertime"),
    @NamedQuery(name = "IbOrders.findByGoodtilldate", query = "SELECT i FROM IbOrders i WHERE i.goodtilldate = :goodtilldate"),
    @NamedQuery(name = "IbOrders.findByOverridepercentageconstraints", query = "SELECT i FROM IbOrders i WHERE i.overridepercentageconstraints = :overridepercentageconstraints"),
    @NamedQuery(name = "IbOrders.findByRule80a", query = "SELECT i FROM IbOrders i WHERE i.rule80a = :rule80a"),
    @NamedQuery(name = "IbOrders.findByAllornone", query = "SELECT i FROM IbOrders i WHERE i.allornone = :allornone"),
    @NamedQuery(name = "IbOrders.findByMinqty", query = "SELECT i FROM IbOrders i WHERE i.minqty = :minqty"),
    @NamedQuery(name = "IbOrders.findByPercentoffset", query = "SELECT i FROM IbOrders i WHERE i.percentoffset = :percentoffset"),
    @NamedQuery(name = "IbOrders.findByTrailstopprice", query = "SELECT i FROM IbOrders i WHERE i.trailstopprice = :trailstopprice"),
    @NamedQuery(name = "IbOrders.findByFagroup", query = "SELECT i FROM IbOrders i WHERE i.fagroup = :fagroup"),
    @NamedQuery(name = "IbOrders.findByFaprofile", query = "SELECT i FROM IbOrders i WHERE i.faprofile = :faprofile"),
    @NamedQuery(name = "IbOrders.findByFamethod", query = "SELECT i FROM IbOrders i WHERE i.famethod = :famethod"),
    @NamedQuery(name = "IbOrders.findByFapercentage", query = "SELECT i FROM IbOrders i WHERE i.fapercentage = :fapercentage"),
    @NamedQuery(name = "IbOrders.findByOpenclose", query = "SELECT i FROM IbOrders i WHERE i.openclose = :openclose"),
    @NamedQuery(name = "IbOrders.findByOrigin", query = "SELECT i FROM IbOrders i WHERE i.origin = :origin"),
    @NamedQuery(name = "IbOrders.findByShortsaleslot", query = "SELECT i FROM IbOrders i WHERE i.shortsaleslot = :shortsaleslot"),
    @NamedQuery(name = "IbOrders.findByDesignatedlocation", query = "SELECT i FROM IbOrders i WHERE i.designatedlocation = :designatedlocation"),
    @NamedQuery(name = "IbOrders.findByExemptcode", query = "SELECT i FROM IbOrders i WHERE i.exemptcode = :exemptcode"),
    @NamedQuery(name = "IbOrders.findByDiscretionaryamt", query = "SELECT i FROM IbOrders i WHERE i.discretionaryamt = :discretionaryamt"),
    @NamedQuery(name = "IbOrders.findByEtradeonly", query = "SELECT i FROM IbOrders i WHERE i.etradeonly = :etradeonly"),
    @NamedQuery(name = "IbOrders.findByFirmquoteonly", query = "SELECT i FROM IbOrders i WHERE i.firmquoteonly = :firmquoteonly"),
    @NamedQuery(name = "IbOrders.findByNbbopricecap", query = "SELECT i FROM IbOrders i WHERE i.nbbopricecap = :nbbopricecap"),
    @NamedQuery(name = "IbOrders.findByOptoutsmartrouting", query = "SELECT i FROM IbOrders i WHERE i.optoutsmartrouting = :optoutsmartrouting"),
    @NamedQuery(name = "IbOrders.findByAuctionstrategy", query = "SELECT i FROM IbOrders i WHERE i.auctionstrategy = :auctionstrategy"),
    @NamedQuery(name = "IbOrders.findByStartingprice", query = "SELECT i FROM IbOrders i WHERE i.startingprice = :startingprice"),
    @NamedQuery(name = "IbOrders.findByStockrefprice", query = "SELECT i FROM IbOrders i WHERE i.stockrefprice = :stockrefprice"),
    @NamedQuery(name = "IbOrders.findByDelta", query = "SELECT i FROM IbOrders i WHERE i.delta = :delta"),
    @NamedQuery(name = "IbOrders.findByStockrangelower", query = "SELECT i FROM IbOrders i WHERE i.stockrangelower = :stockrangelower"),
    @NamedQuery(name = "IbOrders.findByStockrangeupper", query = "SELECT i FROM IbOrders i WHERE i.stockrangeupper = :stockrangeupper"),
    @NamedQuery(name = "IbOrders.findByVolatility", query = "SELECT i FROM IbOrders i WHERE i.volatility = :volatility"),
    @NamedQuery(name = "IbOrders.findByVolatilitytype", query = "SELECT i FROM IbOrders i WHERE i.volatilitytype = :volatilitytype"),
    @NamedQuery(name = "IbOrders.findByContinuousupdate", query = "SELECT i FROM IbOrders i WHERE i.continuousupdate = :continuousupdate"),
    @NamedQuery(name = "IbOrders.findByReferencepricetype", query = "SELECT i FROM IbOrders i WHERE i.referencepricetype = :referencepricetype"),
    @NamedQuery(name = "IbOrders.findByDeltaneutralordertype", query = "SELECT i FROM IbOrders i WHERE i.deltaneutralordertype = :deltaneutralordertype"),
    @NamedQuery(name = "IbOrders.findByDeltaneutralauxprice", query = "SELECT i FROM IbOrders i WHERE i.deltaneutralauxprice = :deltaneutralauxprice"),
    @NamedQuery(name = "IbOrders.findByDeltaneutralconid", query = "SELECT i FROM IbOrders i WHERE i.deltaneutralconid = :deltaneutralconid"),
    @NamedQuery(name = "IbOrders.findByDeltaneutralsettlingfirm", query = "SELECT i FROM IbOrders i WHERE i.deltaneutralsettlingfirm = :deltaneutralsettlingfirm"),
    @NamedQuery(name = "IbOrders.findByDeltaneutralclearingaccount", query = "SELECT i FROM IbOrders i WHERE i.deltaneutralclearingaccount = :deltaneutralclearingaccount"),
    @NamedQuery(name = "IbOrders.findByDeltaneutralclearingintent", query = "SELECT i FROM IbOrders i WHERE i.deltaneutralclearingintent = :deltaneutralclearingintent"),
    @NamedQuery(name = "IbOrders.findByBasispoints", query = "SELECT i FROM IbOrders i WHERE i.basispoints = :basispoints"),
    @NamedQuery(name = "IbOrders.findByBasispointstype", query = "SELECT i FROM IbOrders i WHERE i.basispointstype = :basispointstype"),
    @NamedQuery(name = "IbOrders.findByScaleinitlevelsize", query = "SELECT i FROM IbOrders i WHERE i.scaleinitlevelsize = :scaleinitlevelsize"),
    @NamedQuery(name = "IbOrders.findByScalesubslevelsize", query = "SELECT i FROM IbOrders i WHERE i.scalesubslevelsize = :scalesubslevelsize"),
    @NamedQuery(name = "IbOrders.findByScalepriceincrement", query = "SELECT i FROM IbOrders i WHERE i.scalepriceincrement = :scalepriceincrement"),
    @NamedQuery(name = "IbOrders.findByHedgetype", query = "SELECT i FROM IbOrders i WHERE i.hedgetype = :hedgetype"),
    @NamedQuery(name = "IbOrders.findByHedgeparam", query = "SELECT i FROM IbOrders i WHERE i.hedgeparam = :hedgeparam"),
    @NamedQuery(name = "IbOrders.findByAccount", query = "SELECT i FROM IbOrders i WHERE i.account = :account"),
    @NamedQuery(name = "IbOrders.findBySettlingfirm", query = "SELECT i FROM IbOrders i WHERE i.settlingfirm = :settlingfirm"),
    @NamedQuery(name = "IbOrders.findByClearingaccount", query = "SELECT i FROM IbOrders i WHERE i.clearingaccount = :clearingaccount"),
    @NamedQuery(name = "IbOrders.findByClearingintent", query = "SELECT i FROM IbOrders i WHERE i.clearingintent = :clearingintent"),
    @NamedQuery(name = "IbOrders.findByAlgostrategy", query = "SELECT i FROM IbOrders i WHERE i.algostrategy = :algostrategy"),
    @NamedQuery(name = "IbOrders.findByAlgoparams", query = "SELECT i FROM IbOrders i WHERE i.algoparams = :algoparams"),
    @NamedQuery(name = "IbOrders.findByWhatif", query = "SELECT i FROM IbOrders i WHERE i.whatif = :whatif"),
    @NamedQuery(name = "IbOrders.findByNotheld", query = "SELECT i FROM IbOrders i WHERE i.notheld = :notheld"),
    @NamedQuery(name = "IbOrders.findBySmartcomboroutingparams", query = "SELECT i FROM IbOrders i WHERE i.smartcomboroutingparams = :smartcomboroutingparams"),
    @NamedQuery(name = "IbOrders.findByCreateTimestamp", query = "SELECT i FROM IbOrders i WHERE i.createTimestamp = :createTimestamp"),
    @NamedQuery(name = "IbOrders.findByLastUpdateTimestamp", query = "SELECT i FROM IbOrders i WHERE i.lastUpdateTimestamp = :lastUpdateTimestamp"),
    @NamedQuery(name = "IbOrders.findByIsActive", query = "SELECT i FROM IbOrders i WHERE i.isActive = :isActive"),
    @NamedQuery(name = "IbOrders.findByUpdateUsername", query = "SELECT i FROM IbOrders i WHERE i.updateUsername = :updateUsername")})
public class IbOrders implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "order_id")
    private BigDecimal orderId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "client_id")
    private BigDecimal clientId;
    @Column(name = "perm_id")
    private BigDecimal permId;
    @Size(max = 25)
    @Column(name = "action")
    private String action;
    @Column(name = "total_quantity")
    private BigDecimal totalQuantity;
    @Size(max = 25)
    @Column(name = "order_type")
    private String orderType;
    @Column(name = "limit_price")
    private BigDecimal limitPrice;
    @Column(name = "aux_price")
    private BigDecimal auxPrice;
    @Size(max = 25)
    @Column(name = "tif")
    private String tif;
    @Size(max = 25)
    @Column(name = "ocagroup")
    private String ocagroup;
    @Column(name = "ocatype")
    private BigDecimal ocatype;
    @Size(max = 25)
    @Column(name = "orderref")
    private String orderref;
    @Column(name = "Transmit")
    private Character transmit;
    @Column(name = "parentid")
    private BigDecimal parentid;
    @Column(name = "blockorder")
    private Character blockorder;
    @Column(name = "sweeptofill")
    private Character sweeptofill;
    @Column(name = "displaysize")
    private BigDecimal displaysize;
    @Column(name = "triggermethod")
    private BigDecimal triggermethod;
    @Column(name = "outsiderth")
    private Character outsiderth;
    @Column(name = "hidden")
    private Character hidden;
    @Size(max = 25)
    @Column(name = "goodaftertime")
    private String goodaftertime;
    @Size(max = 25)
    @Column(name = "goodtilldate")
    private String goodtilldate;
    @Column(name = "overridepercentageconstraints")
    private Character overridepercentageconstraints;
    @Size(max = 25)
    @Column(name = "rule80a")
    private String rule80a;
    @Column(name = "allornone")
    private Character allornone;
    @Column(name = "minqty")
    private BigDecimal minqty;
    @Column(name = "percentoffset")
    private BigDecimal percentoffset;
    @Column(name = "trailstopprice")
    private BigDecimal trailstopprice;
    @Size(max = 25)
    @Column(name = "fagroup")
    private String fagroup;
    @Size(max = 25)
    @Column(name = "faprofile")
    private String faprofile;
    @Size(max = 25)
    @Column(name = "famethod")
    private String famethod;
    @Size(max = 25)
    @Column(name = "fapercentage")
    private String fapercentage;
    @Size(max = 25)
    @Column(name = "openclose")
    private String openclose;
    @Column(name = "origin")
    private BigDecimal origin;
    @Column(name = "shortsaleslot")
    private BigDecimal shortsaleslot;
    @Size(max = 25)
    @Column(name = "designatedlocation")
    private String designatedlocation;
    @Column(name = "exemptcode")
    private BigDecimal exemptcode;
    @Column(name = "discretionaryamt")
    private BigDecimal discretionaryamt;
    @Column(name = "etradeonly")
    private Character etradeonly;
    @Column(name = "firmquoteonly")
    private Character firmquoteonly;
    @Column(name = "nbbopricecap")
    private BigDecimal nbbopricecap;
    @Column(name = "optoutsmartrouting")
    private Character optoutsmartrouting;
    @Column(name = "auctionstrategy")
    private BigDecimal auctionstrategy;
    @Column(name = "startingprice")
    private BigDecimal startingprice;
    @Column(name = "stockrefprice")
    private BigDecimal stockrefprice;
    @Column(name = "delta")
    private BigDecimal delta;
    @Column(name = "stockrangelower")
    private BigDecimal stockrangelower;
    @Column(name = "stockrangeupper")
    private BigDecimal stockrangeupper;
    @Column(name = "volatility")
    private BigDecimal volatility;
    @Column(name = "volatilitytype")
    private BigDecimal volatilitytype;
    @Column(name = "continuousupdate")
    private BigDecimal continuousupdate;
    @Column(name = "referencepricetype")
    private BigDecimal referencepricetype;
    @Size(max = 25)
    @Column(name = "deltaneutralordertype")
    private String deltaneutralordertype;
    @Column(name = "deltaneutralauxprice")
    private BigDecimal deltaneutralauxprice;
    @Column(name = "deltaneutralconid")
    private BigDecimal deltaneutralconid;
    @Size(max = 25)
    @Column(name = "deltaneutralsettlingfirm")
    private String deltaneutralsettlingfirm;
    @Size(max = 25)
    @Column(name = "deltaneutralclearingaccount")
    private String deltaneutralclearingaccount;
    @Size(max = 25)
    @Column(name = "deltaneutralclearingintent")
    private String deltaneutralclearingintent;
    @Column(name = "basispoints")
    private BigDecimal basispoints;
    @Column(name = "basispointstype")
    private BigDecimal basispointstype;
    @Column(name = "scaleinitlevelsize")
    private BigDecimal scaleinitlevelsize;
    @Column(name = "scalesubslevelsize")
    private BigDecimal scalesubslevelsize;
    @Column(name = "scalepriceincrement")
    private BigDecimal scalepriceincrement;
    @Size(max = 25)
    @Column(name = "hedgetype")
    private String hedgetype;
    @Size(max = 25)
    @Column(name = "hedgeparam")
    private String hedgeparam;
    @Size(max = 25)
    @Column(name = "account")
    private String account;
    @Size(max = 25)
    @Column(name = "settlingfirm")
    private String settlingfirm;
    @Size(max = 25)
    @Column(name = "clearingaccount")
    private String clearingaccount;
    @Size(max = 25)
    @Column(name = "clearingintent")
    private String clearingintent;
    @Size(max = 25)
    @Column(name = "algostrategy")
    private String algostrategy;
    @Size(max = 100)
    @Column(name = "algoparams")
    private String algoparams;
    @Column(name = "whatif")
    private Character whatif;
    @Column(name = "notheld")
    private Character notheld;
    @Size(max = 100)
    @Column(name = "smartcomboroutingparams")
    private String smartcomboroutingparams;
    @Basic(optional = false)
    @NotNull
    @Column(name = "create_timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTimestamp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "last_update_timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdateTimestamp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_active")
    private Character isActive;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "update_username")
    private String updateUsername;
    @JoinColumn(name = "ib_account_id", referencedColumnName = "ib_account_id")
    @ManyToOne(optional = false)
    private IbUserInfo ibAccountId;

    public IbOrders() {
    }

    public IbOrders(BigDecimal orderId) {
        this.orderId = orderId;
    }

    public IbOrders(BigDecimal orderId, BigDecimal clientId, Date createTimestamp, Date lastUpdateTimestamp, Character isActive, String updateUsername) {
        this.orderId = orderId;
        this.clientId = clientId;
        this.createTimestamp = createTimestamp;
        this.lastUpdateTimestamp = lastUpdateTimestamp;
        this.isActive = isActive;
        this.updateUsername = updateUsername;
    }

    public BigDecimal getOrderId() {
        return orderId;
    }

    public void setOrderId(BigDecimal orderId) {
        this.orderId = orderId;
    }

    public BigDecimal getClientId() {
        return clientId;
    }

    public void setClientId(BigDecimal clientId) {
        this.clientId = clientId;
    }

    public BigDecimal getPermId() {
        return permId;
    }

    public void setPermId(BigDecimal permId) {
        this.permId = permId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public BigDecimal getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(BigDecimal totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public BigDecimal getLimitPrice() {
        return limitPrice;
    }

    public void setLimitPrice(BigDecimal limitPrice) {
        this.limitPrice = limitPrice;
    }

    public BigDecimal getAuxPrice() {
        return auxPrice;
    }

    public void setAuxPrice(BigDecimal auxPrice) {
        this.auxPrice = auxPrice;
    }

    public String getTif() {
        return tif;
    }

    public void setTif(String tif) {
        this.tif = tif;
    }

    public String getOcagroup() {
        return ocagroup;
    }

    public void setOcagroup(String ocagroup) {
        this.ocagroup = ocagroup;
    }

    public BigDecimal getOcatype() {
        return ocatype;
    }

    public void setOcatype(BigDecimal ocatype) {
        this.ocatype = ocatype;
    }

    public String getOrderref() {
        return orderref;
    }

    public void setOrderref(String orderref) {
        this.orderref = orderref;
    }

    public Character getTransmit() {
        return transmit;
    }

    public void setTransmit(Character transmit) {
        this.transmit = transmit;
    }

    public BigDecimal getParentid() {
        return parentid;
    }

    public void setParentid(BigDecimal parentid) {
        this.parentid = parentid;
    }

    public Character getBlockorder() {
        return blockorder;
    }

    public void setBlockorder(Character blockorder) {
        this.blockorder = blockorder;
    }

    public Character getSweeptofill() {
        return sweeptofill;
    }

    public void setSweeptofill(Character sweeptofill) {
        this.sweeptofill = sweeptofill;
    }

    public BigDecimal getDisplaysize() {
        return displaysize;
    }

    public void setDisplaysize(BigDecimal displaysize) {
        this.displaysize = displaysize;
    }

    public BigDecimal getTriggermethod() {
        return triggermethod;
    }

    public void setTriggermethod(BigDecimal triggermethod) {
        this.triggermethod = triggermethod;
    }

    public Character getOutsiderth() {
        return outsiderth;
    }

    public void setOutsiderth(Character outsiderth) {
        this.outsiderth = outsiderth;
    }

    public Character getHidden() {
        return hidden;
    }

    public void setHidden(Character hidden) {
        this.hidden = hidden;
    }

    public String getGoodaftertime() {
        return goodaftertime;
    }

    public void setGoodaftertime(String goodaftertime) {
        this.goodaftertime = goodaftertime;
    }

    public String getGoodtilldate() {
        return goodtilldate;
    }

    public void setGoodtilldate(String goodtilldate) {
        this.goodtilldate = goodtilldate;
    }

    public Character getOverridepercentageconstraints() {
        return overridepercentageconstraints;
    }

    public void setOverridepercentageconstraints(Character overridepercentageconstraints) {
        this.overridepercentageconstraints = overridepercentageconstraints;
    }

    public String getRule80a() {
        return rule80a;
    }

    public void setRule80a(String rule80a) {
        this.rule80a = rule80a;
    }

    public Character getAllornone() {
        return allornone;
    }

    public void setAllornone(Character allornone) {
        this.allornone = allornone;
    }

    public BigDecimal getMinqty() {
        return minqty;
    }

    public void setMinqty(BigDecimal minqty) {
        this.minqty = minqty;
    }

    public BigDecimal getPercentoffset() {
        return percentoffset;
    }

    public void setPercentoffset(BigDecimal percentoffset) {
        this.percentoffset = percentoffset;
    }

    public BigDecimal getTrailstopprice() {
        return trailstopprice;
    }

    public void setTrailstopprice(BigDecimal trailstopprice) {
        this.trailstopprice = trailstopprice;
    }

    public String getFagroup() {
        return fagroup;
    }

    public void setFagroup(String fagroup) {
        this.fagroup = fagroup;
    }

    public String getFaprofile() {
        return faprofile;
    }

    public void setFaprofile(String faprofile) {
        this.faprofile = faprofile;
    }

    public String getFamethod() {
        return famethod;
    }

    public void setFamethod(String famethod) {
        this.famethod = famethod;
    }

    public String getFapercentage() {
        return fapercentage;
    }

    public void setFapercentage(String fapercentage) {
        this.fapercentage = fapercentage;
    }

    public String getOpenclose() {
        return openclose;
    }

    public void setOpenclose(String openclose) {
        this.openclose = openclose;
    }

    public BigDecimal getOrigin() {
        return origin;
    }

    public void setOrigin(BigDecimal origin) {
        this.origin = origin;
    }

    public BigDecimal getShortsaleslot() {
        return shortsaleslot;
    }

    public void setShortsaleslot(BigDecimal shortsaleslot) {
        this.shortsaleslot = shortsaleslot;
    }

    public String getDesignatedlocation() {
        return designatedlocation;
    }

    public void setDesignatedlocation(String designatedlocation) {
        this.designatedlocation = designatedlocation;
    }

    public BigDecimal getExemptcode() {
        return exemptcode;
    }

    public void setExemptcode(BigDecimal exemptcode) {
        this.exemptcode = exemptcode;
    }

    public BigDecimal getDiscretionaryamt() {
        return discretionaryamt;
    }

    public void setDiscretionaryamt(BigDecimal discretionaryamt) {
        this.discretionaryamt = discretionaryamt;
    }

    public Character getEtradeonly() {
        return etradeonly;
    }

    public void setEtradeonly(Character etradeonly) {
        this.etradeonly = etradeonly;
    }

    public Character getFirmquoteonly() {
        return firmquoteonly;
    }

    public void setFirmquoteonly(Character firmquoteonly) {
        this.firmquoteonly = firmquoteonly;
    }

    public BigDecimal getNbbopricecap() {
        return nbbopricecap;
    }

    public void setNbbopricecap(BigDecimal nbbopricecap) {
        this.nbbopricecap = nbbopricecap;
    }

    public Character getOptoutsmartrouting() {
        return optoutsmartrouting;
    }

    public void setOptoutsmartrouting(Character optoutsmartrouting) {
        this.optoutsmartrouting = optoutsmartrouting;
    }

    public BigDecimal getAuctionstrategy() {
        return auctionstrategy;
    }

    public void setAuctionstrategy(BigDecimal auctionstrategy) {
        this.auctionstrategy = auctionstrategy;
    }

    public BigDecimal getStartingprice() {
        return startingprice;
    }

    public void setStartingprice(BigDecimal startingprice) {
        this.startingprice = startingprice;
    }

    public BigDecimal getStockrefprice() {
        return stockrefprice;
    }

    public void setStockrefprice(BigDecimal stockrefprice) {
        this.stockrefprice = stockrefprice;
    }

    public BigDecimal getDelta() {
        return delta;
    }

    public void setDelta(BigDecimal delta) {
        this.delta = delta;
    }

    public BigDecimal getStockrangelower() {
        return stockrangelower;
    }

    public void setStockrangelower(BigDecimal stockrangelower) {
        this.stockrangelower = stockrangelower;
    }

    public BigDecimal getStockrangeupper() {
        return stockrangeupper;
    }

    public void setStockrangeupper(BigDecimal stockrangeupper) {
        this.stockrangeupper = stockrangeupper;
    }

    public BigDecimal getVolatility() {
        return volatility;
    }

    public void setVolatility(BigDecimal volatility) {
        this.volatility = volatility;
    }

    public BigDecimal getVolatilitytype() {
        return volatilitytype;
    }

    public void setVolatilitytype(BigDecimal volatilitytype) {
        this.volatilitytype = volatilitytype;
    }

    public BigDecimal getContinuousupdate() {
        return continuousupdate;
    }

    public void setContinuousupdate(BigDecimal continuousupdate) {
        this.continuousupdate = continuousupdate;
    }

    public BigDecimal getReferencepricetype() {
        return referencepricetype;
    }

    public void setReferencepricetype(BigDecimal referencepricetype) {
        this.referencepricetype = referencepricetype;
    }

    public String getDeltaneutralordertype() {
        return deltaneutralordertype;
    }

    public void setDeltaneutralordertype(String deltaneutralordertype) {
        this.deltaneutralordertype = deltaneutralordertype;
    }

    public BigDecimal getDeltaneutralauxprice() {
        return deltaneutralauxprice;
    }

    public void setDeltaneutralauxprice(BigDecimal deltaneutralauxprice) {
        this.deltaneutralauxprice = deltaneutralauxprice;
    }

    public BigDecimal getDeltaneutralconid() {
        return deltaneutralconid;
    }

    public void setDeltaneutralconid(BigDecimal deltaneutralconid) {
        this.deltaneutralconid = deltaneutralconid;
    }

    public String getDeltaneutralsettlingfirm() {
        return deltaneutralsettlingfirm;
    }

    public void setDeltaneutralsettlingfirm(String deltaneutralsettlingfirm) {
        this.deltaneutralsettlingfirm = deltaneutralsettlingfirm;
    }

    public String getDeltaneutralclearingaccount() {
        return deltaneutralclearingaccount;
    }

    public void setDeltaneutralclearingaccount(String deltaneutralclearingaccount) {
        this.deltaneutralclearingaccount = deltaneutralclearingaccount;
    }

    public String getDeltaneutralclearingintent() {
        return deltaneutralclearingintent;
    }

    public void setDeltaneutralclearingintent(String deltaneutralclearingintent) {
        this.deltaneutralclearingintent = deltaneutralclearingintent;
    }

    public BigDecimal getBasispoints() {
        return basispoints;
    }

    public void setBasispoints(BigDecimal basispoints) {
        this.basispoints = basispoints;
    }

    public BigDecimal getBasispointstype() {
        return basispointstype;
    }

    public void setBasispointstype(BigDecimal basispointstype) {
        this.basispointstype = basispointstype;
    }

    public BigDecimal getScaleinitlevelsize() {
        return scaleinitlevelsize;
    }

    public void setScaleinitlevelsize(BigDecimal scaleinitlevelsize) {
        this.scaleinitlevelsize = scaleinitlevelsize;
    }

    public BigDecimal getScalesubslevelsize() {
        return scalesubslevelsize;
    }

    public void setScalesubslevelsize(BigDecimal scalesubslevelsize) {
        this.scalesubslevelsize = scalesubslevelsize;
    }

    public BigDecimal getScalepriceincrement() {
        return scalepriceincrement;
    }

    public void setScalepriceincrement(BigDecimal scalepriceincrement) {
        this.scalepriceincrement = scalepriceincrement;
    }

    public String getHedgetype() {
        return hedgetype;
    }

    public void setHedgetype(String hedgetype) {
        this.hedgetype = hedgetype;
    }

    public String getHedgeparam() {
        return hedgeparam;
    }

    public void setHedgeparam(String hedgeparam) {
        this.hedgeparam = hedgeparam;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getSettlingfirm() {
        return settlingfirm;
    }

    public void setSettlingfirm(String settlingfirm) {
        this.settlingfirm = settlingfirm;
    }

    public String getClearingaccount() {
        return clearingaccount;
    }

    public void setClearingaccount(String clearingaccount) {
        this.clearingaccount = clearingaccount;
    }

    public String getClearingintent() {
        return clearingintent;
    }

    public void setClearingintent(String clearingintent) {
        this.clearingintent = clearingintent;
    }

    public String getAlgostrategy() {
        return algostrategy;
    }

    public void setAlgostrategy(String algostrategy) {
        this.algostrategy = algostrategy;
    }

    public String getAlgoparams() {
        return algoparams;
    }

    public void setAlgoparams(String algoparams) {
        this.algoparams = algoparams;
    }

    public Character getWhatif() {
        return whatif;
    }

    public void setWhatif(Character whatif) {
        this.whatif = whatif;
    }

    public Character getNotheld() {
        return notheld;
    }

    public void setNotheld(Character notheld) {
        this.notheld = notheld;
    }

    public String getSmartcomboroutingparams() {
        return smartcomboroutingparams;
    }

    public void setSmartcomboroutingparams(String smartcomboroutingparams) {
        this.smartcomboroutingparams = smartcomboroutingparams;
    }

    public Date getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(Date createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public Date getLastUpdateTimestamp() {
        return lastUpdateTimestamp;
    }

    public void setLastUpdateTimestamp(Date lastUpdateTimestamp) {
        this.lastUpdateTimestamp = lastUpdateTimestamp;
    }

    public Character getIsActive() {
        return isActive;
    }

    public void setIsActive(Character isActive) {
        this.isActive = isActive;
    }

    public String getUpdateUsername() {
        return updateUsername;
    }

    public void setUpdateUsername(String updateUsername) {
        this.updateUsername = updateUsername;
    }

    public IbUserInfo getIbAccountId() {
        return ibAccountId;
    }

    public void setIbAccountId(IbUserInfo ibAccountId) {
        this.ibAccountId = ibAccountId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderId != null ? orderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IbOrders)) {
            return false;
        }
        IbOrders other = (IbOrders) object;
        if ((this.orderId == null && other.orderId != null) || (this.orderId != null && !this.orderId.equals(other.orderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.finflock.jpa.IbOrders[ orderId=" + orderId + " ]";
    }
    
}
