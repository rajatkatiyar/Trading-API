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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "Ib_Account_Update")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IbAccountUpdate.findAll", query = "SELECT i FROM IbAccountUpdate i"),
    @NamedQuery(name = "IbAccountUpdate.findByAccountUpdateId", query = "SELECT i FROM IbAccountUpdate i WHERE i.accountUpdateId = :accountUpdateId"),
    @NamedQuery(name = "IbAccountUpdate.findByAccountCode", query = "SELECT i FROM IbAccountUpdate i WHERE i.accountCode = :accountCode"),
    @NamedQuery(name = "IbAccountUpdate.findByAccountOrGroup", query = "SELECT i FROM IbAccountUpdate i WHERE i.accountOrGroup = :accountOrGroup"),
    @NamedQuery(name = "IbAccountUpdate.findByAccountReady", query = "SELECT i FROM IbAccountUpdate i WHERE i.accountReady = :accountReady"),
    @NamedQuery(name = "IbAccountUpdate.findByAccountType", query = "SELECT i FROM IbAccountUpdate i WHERE i.accountType = :accountType"),
    @NamedQuery(name = "IbAccountUpdate.findByAccruedCash", query = "SELECT i FROM IbAccountUpdate i WHERE i.accruedCash = :accruedCash"),
    @NamedQuery(name = "IbAccountUpdate.findByAccruedCashC", query = "SELECT i FROM IbAccountUpdate i WHERE i.accruedCashC = :accruedCashC"),
    @NamedQuery(name = "IbAccountUpdate.findByAccruedCashS", query = "SELECT i FROM IbAccountUpdate i WHERE i.accruedCashS = :accruedCashS"),
    @NamedQuery(name = "IbAccountUpdate.findByAccruedDividend", query = "SELECT i FROM IbAccountUpdate i WHERE i.accruedDividend = :accruedDividend"),
    @NamedQuery(name = "IbAccountUpdate.findByAccruedDividendC", query = "SELECT i FROM IbAccountUpdate i WHERE i.accruedDividendC = :accruedDividendC"),
    @NamedQuery(name = "IbAccountUpdate.findByAccruedDividendS", query = "SELECT i FROM IbAccountUpdate i WHERE i.accruedDividendS = :accruedDividendS"),
    @NamedQuery(name = "IbAccountUpdate.findByAvailableFunds", query = "SELECT i FROM IbAccountUpdate i WHERE i.availableFunds = :availableFunds"),
    @NamedQuery(name = "IbAccountUpdate.findByAvailableFundsC", query = "SELECT i FROM IbAccountUpdate i WHERE i.availableFundsC = :availableFundsC"),
    @NamedQuery(name = "IbAccountUpdate.findByAvailableFundsS", query = "SELECT i FROM IbAccountUpdate i WHERE i.availableFundsS = :availableFundsS"),
    @NamedQuery(name = "IbAccountUpdate.findByBillable", query = "SELECT i FROM IbAccountUpdate i WHERE i.billable = :billable"),
    @NamedQuery(name = "IbAccountUpdate.findByBillableC", query = "SELECT i FROM IbAccountUpdate i WHERE i.billableC = :billableC"),
    @NamedQuery(name = "IbAccountUpdate.findByBillableS", query = "SELECT i FROM IbAccountUpdate i WHERE i.billableS = :billableS"),
    @NamedQuery(name = "IbAccountUpdate.findByBuyingPower", query = "SELECT i FROM IbAccountUpdate i WHERE i.buyingPower = :buyingPower"),
    @NamedQuery(name = "IbAccountUpdate.findByCashBalance", query = "SELECT i FROM IbAccountUpdate i WHERE i.cashBalance = :cashBalance"),
    @NamedQuery(name = "IbAccountUpdate.findByCorporateBondValue", query = "SELECT i FROM IbAccountUpdate i WHERE i.corporateBondValue = :corporateBondValue"),
    @NamedQuery(name = "IbAccountUpdate.findByCurrency", query = "SELECT i FROM IbAccountUpdate i WHERE i.currency = :currency"),
    @NamedQuery(name = "IbAccountUpdate.findByCushion", query = "SELECT i FROM IbAccountUpdate i WHERE i.cushion = :cushion"),
    @NamedQuery(name = "IbAccountUpdate.findByEquityWithLoanValue", query = "SELECT i FROM IbAccountUpdate i WHERE i.equityWithLoanValue = :equityWithLoanValue"),
    @NamedQuery(name = "IbAccountUpdate.findByEquityWithLoanValueC", query = "SELECT i FROM IbAccountUpdate i WHERE i.equityWithLoanValueC = :equityWithLoanValueC"),
    @NamedQuery(name = "IbAccountUpdate.findByEquityWithLoanValueS", query = "SELECT i FROM IbAccountUpdate i WHERE i.equityWithLoanValueS = :equityWithLoanValueS"),
    @NamedQuery(name = "IbAccountUpdate.findByExcessLiquidity", query = "SELECT i FROM IbAccountUpdate i WHERE i.excessLiquidity = :excessLiquidity"),
    @NamedQuery(name = "IbAccountUpdate.findByExcessLiquidityC", query = "SELECT i FROM IbAccountUpdate i WHERE i.excessLiquidityC = :excessLiquidityC"),
    @NamedQuery(name = "IbAccountUpdate.findByExcessLiquidityS", query = "SELECT i FROM IbAccountUpdate i WHERE i.excessLiquidityS = :excessLiquidityS"),
    @NamedQuery(name = "IbAccountUpdate.findByExchangeRate", query = "SELECT i FROM IbAccountUpdate i WHERE i.exchangeRate = :exchangeRate"),
    @NamedQuery(name = "IbAccountUpdate.findByFullAvailableFunds", query = "SELECT i FROM IbAccountUpdate i WHERE i.fullAvailableFunds = :fullAvailableFunds"),
    @NamedQuery(name = "IbAccountUpdate.findByFullAvailableFundsC", query = "SELECT i FROM IbAccountUpdate i WHERE i.fullAvailableFundsC = :fullAvailableFundsC"),
    @NamedQuery(name = "IbAccountUpdate.findByFullAvailableFundsS", query = "SELECT i FROM IbAccountUpdate i WHERE i.fullAvailableFundsS = :fullAvailableFundsS"),
    @NamedQuery(name = "IbAccountUpdate.findByFullExcessLiquidity", query = "SELECT i FROM IbAccountUpdate i WHERE i.fullExcessLiquidity = :fullExcessLiquidity"),
    @NamedQuery(name = "IbAccountUpdate.findByFullExcessLiquidityC", query = "SELECT i FROM IbAccountUpdate i WHERE i.fullExcessLiquidityC = :fullExcessLiquidityC"),
    @NamedQuery(name = "IbAccountUpdate.findByFullExcessLiquidityS", query = "SELECT i FROM IbAccountUpdate i WHERE i.fullExcessLiquidityS = :fullExcessLiquidityS"),
    @NamedQuery(name = "IbAccountUpdate.findByFullInitMarginReq", query = "SELECT i FROM IbAccountUpdate i WHERE i.fullInitMarginReq = :fullInitMarginReq"),
    @NamedQuery(name = "IbAccountUpdate.findByFullInitMarginReqC", query = "SELECT i FROM IbAccountUpdate i WHERE i.fullInitMarginReqC = :fullInitMarginReqC"),
    @NamedQuery(name = "IbAccountUpdate.findByFullInitMarginReqS", query = "SELECT i FROM IbAccountUpdate i WHERE i.fullInitMarginReqS = :fullInitMarginReqS"),
    @NamedQuery(name = "IbAccountUpdate.findByFullMaintMarginReq", query = "SELECT i FROM IbAccountUpdate i WHERE i.fullMaintMarginReq = :fullMaintMarginReq"),
    @NamedQuery(name = "IbAccountUpdate.findByFullMaintMarginReqC", query = "SELECT i FROM IbAccountUpdate i WHERE i.fullMaintMarginReqC = :fullMaintMarginReqC"),
    @NamedQuery(name = "IbAccountUpdate.findByFullMaintMarginReqS", query = "SELECT i FROM IbAccountUpdate i WHERE i.fullMaintMarginReqS = :fullMaintMarginReqS"),
    @NamedQuery(name = "IbAccountUpdate.findByFundValue", query = "SELECT i FROM IbAccountUpdate i WHERE i.fundValue = :fundValue"),
    @NamedQuery(name = "IbAccountUpdate.findByFutureOptionValue", query = "SELECT i FROM IbAccountUpdate i WHERE i.futureOptionValue = :futureOptionValue"),
    @NamedQuery(name = "IbAccountUpdate.findByFuturesPNL", query = "SELECT i FROM IbAccountUpdate i WHERE i.futuresPNL = :futuresPNL"),
    @NamedQuery(name = "IbAccountUpdate.findByFxCashBalance", query = "SELECT i FROM IbAccountUpdate i WHERE i.fxCashBalance = :fxCashBalance"),
    @NamedQuery(name = "IbAccountUpdate.findByGrossPositionValue", query = "SELECT i FROM IbAccountUpdate i WHERE i.grossPositionValue = :grossPositionValue"),
    @NamedQuery(name = "IbAccountUpdate.findByGrossPositionValueS", query = "SELECT i FROM IbAccountUpdate i WHERE i.grossPositionValueS = :grossPositionValueS"),
    @NamedQuery(name = "IbAccountUpdate.findByGuarantee", query = "SELECT i FROM IbAccountUpdate i WHERE i.guarantee = :guarantee"),
    @NamedQuery(name = "IbAccountUpdate.findByGuaranteeC", query = "SELECT i FROM IbAccountUpdate i WHERE i.guaranteeC = :guaranteeC"),
    @NamedQuery(name = "IbAccountUpdate.findByGuaranteeS", query = "SELECT i FROM IbAccountUpdate i WHERE i.guaranteeS = :guaranteeS"),
    @NamedQuery(name = "IbAccountUpdate.findByIndianStockHaircut", query = "SELECT i FROM IbAccountUpdate i WHERE i.indianStockHaircut = :indianStockHaircut"),
    @NamedQuery(name = "IbAccountUpdate.findByIndianStockHaircutC", query = "SELECT i FROM IbAccountUpdate i WHERE i.indianStockHaircutC = :indianStockHaircutC"),
    @NamedQuery(name = "IbAccountUpdate.findByIndianStockHaircutS", query = "SELECT i FROM IbAccountUpdate i WHERE i.indianStockHaircutS = :indianStockHaircutS"),
    @NamedQuery(name = "IbAccountUpdate.findByInitMarginReq", query = "SELECT i FROM IbAccountUpdate i WHERE i.initMarginReq = :initMarginReq"),
    @NamedQuery(name = "IbAccountUpdate.findByInitMarginReqC", query = "SELECT i FROM IbAccountUpdate i WHERE i.initMarginReqC = :initMarginReqC"),
    @NamedQuery(name = "IbAccountUpdate.findByInitMarginReqS", query = "SELECT i FROM IbAccountUpdate i WHERE i.initMarginReqS = :initMarginReqS"),
    @NamedQuery(name = "IbAccountUpdate.findByIssuerOptionValue", query = "SELECT i FROM IbAccountUpdate i WHERE i.issuerOptionValue = :issuerOptionValue"),
    @NamedQuery(name = "IbAccountUpdate.findByLeverageS", query = "SELECT i FROM IbAccountUpdate i WHERE i.leverageS = :leverageS"),
    @NamedQuery(name = "IbAccountUpdate.findByLookAheadAvailableFunds", query = "SELECT i FROM IbAccountUpdate i WHERE i.lookAheadAvailableFunds = :lookAheadAvailableFunds"),
    @NamedQuery(name = "IbAccountUpdate.findByLookAheadAvailableFundsC", query = "SELECT i FROM IbAccountUpdate i WHERE i.lookAheadAvailableFundsC = :lookAheadAvailableFundsC"),
    @NamedQuery(name = "IbAccountUpdate.findByLookAheadAvailableFundsS", query = "SELECT i FROM IbAccountUpdate i WHERE i.lookAheadAvailableFundsS = :lookAheadAvailableFundsS"),
    @NamedQuery(name = "IbAccountUpdate.findByLookAheadExcessLiquidity", query = "SELECT i FROM IbAccountUpdate i WHERE i.lookAheadExcessLiquidity = :lookAheadExcessLiquidity"),
    @NamedQuery(name = "IbAccountUpdate.findByLookAheadExcessLiquidityC", query = "SELECT i FROM IbAccountUpdate i WHERE i.lookAheadExcessLiquidityC = :lookAheadExcessLiquidityC"),
    @NamedQuery(name = "IbAccountUpdate.findByLookAheadExcessLiquidityS", query = "SELECT i FROM IbAccountUpdate i WHERE i.lookAheadExcessLiquidityS = :lookAheadExcessLiquidityS"),
    @NamedQuery(name = "IbAccountUpdate.findByLookAheadInitMarginReq", query = "SELECT i FROM IbAccountUpdate i WHERE i.lookAheadInitMarginReq = :lookAheadInitMarginReq"),
    @NamedQuery(name = "IbAccountUpdate.findByLookAheadInitMarginReqC", query = "SELECT i FROM IbAccountUpdate i WHERE i.lookAheadInitMarginReqC = :lookAheadInitMarginReqC"),
    @NamedQuery(name = "IbAccountUpdate.findByLookAheadInitMarginReqS", query = "SELECT i FROM IbAccountUpdate i WHERE i.lookAheadInitMarginReqS = :lookAheadInitMarginReqS"),
    @NamedQuery(name = "IbAccountUpdate.findByLookAheadMaintMarginReq", query = "SELECT i FROM IbAccountUpdate i WHERE i.lookAheadMaintMarginReq = :lookAheadMaintMarginReq"),
    @NamedQuery(name = "IbAccountUpdate.findByLookAheadMaintMarginReqC", query = "SELECT i FROM IbAccountUpdate i WHERE i.lookAheadMaintMarginReqC = :lookAheadMaintMarginReqC"),
    @NamedQuery(name = "IbAccountUpdate.findByLookAheadMaintMarginReqS", query = "SELECT i FROM IbAccountUpdate i WHERE i.lookAheadMaintMarginReqS = :lookAheadMaintMarginReqS"),
    @NamedQuery(name = "IbAccountUpdate.findByLookAheadNextChange", query = "SELECT i FROM IbAccountUpdate i WHERE i.lookAheadNextChange = :lookAheadNextChange"),
    @NamedQuery(name = "IbAccountUpdate.findByMaintMarginReq", query = "SELECT i FROM IbAccountUpdate i WHERE i.maintMarginReq = :maintMarginReq"),
    @NamedQuery(name = "IbAccountUpdate.findByMaintMarginReqC", query = "SELECT i FROM IbAccountUpdate i WHERE i.maintMarginReqC = :maintMarginReqC"),
    @NamedQuery(name = "IbAccountUpdate.findByMaintMarginReqS", query = "SELECT i FROM IbAccountUpdate i WHERE i.maintMarginReqS = :maintMarginReqS"),
    @NamedQuery(name = "IbAccountUpdate.findByMoneyMarketFundValue", query = "SELECT i FROM IbAccountUpdate i WHERE i.moneyMarketFundValue = :moneyMarketFundValue"),
    @NamedQuery(name = "IbAccountUpdate.findByMutualFundValue", query = "SELECT i FROM IbAccountUpdate i WHERE i.mutualFundValue = :mutualFundValue"),
    @NamedQuery(name = "IbAccountUpdate.findByNetDividend", query = "SELECT i FROM IbAccountUpdate i WHERE i.netDividend = :netDividend"),
    @NamedQuery(name = "IbAccountUpdate.findByNetLiquidation", query = "SELECT i FROM IbAccountUpdate i WHERE i.netLiquidation = :netLiquidation"),
    @NamedQuery(name = "IbAccountUpdate.findByNetLiquidationC", query = "SELECT i FROM IbAccountUpdate i WHERE i.netLiquidationC = :netLiquidationC"),
    @NamedQuery(name = "IbAccountUpdate.findByNetLiquidationS", query = "SELECT i FROM IbAccountUpdate i WHERE i.netLiquidationS = :netLiquidationS"),
    @NamedQuery(name = "IbAccountUpdate.findByNetLiquidationByCurrency", query = "SELECT i FROM IbAccountUpdate i WHERE i.netLiquidationByCurrency = :netLiquidationByCurrency"),
    @NamedQuery(name = "IbAccountUpdate.findByNetLiquidationUncertainty", query = "SELECT i FROM IbAccountUpdate i WHERE i.netLiquidationUncertainty = :netLiquidationUncertainty"),
    @NamedQuery(name = "IbAccountUpdate.findByOptionMarketValue", query = "SELECT i FROM IbAccountUpdate i WHERE i.optionMarketValue = :optionMarketValue"),
    @NamedQuery(name = "IbAccountUpdate.findByPASharesValue", query = "SELECT i FROM IbAccountUpdate i WHERE i.pASharesValue = :pASharesValue"),
    @NamedQuery(name = "IbAccountUpdate.findByPASharesValueC", query = "SELECT i FROM IbAccountUpdate i WHERE i.pASharesValueC = :pASharesValueC"),
    @NamedQuery(name = "IbAccountUpdate.findByPASharesValueS", query = "SELECT i FROM IbAccountUpdate i WHERE i.pASharesValueS = :pASharesValueS"),
    @NamedQuery(name = "IbAccountUpdate.findByPostExpirationExcess", query = "SELECT i FROM IbAccountUpdate i WHERE i.postExpirationExcess = :postExpirationExcess"),
    @NamedQuery(name = "IbAccountUpdate.findByPostExpirationExcessC", query = "SELECT i FROM IbAccountUpdate i WHERE i.postExpirationExcessC = :postExpirationExcessC"),
    @NamedQuery(name = "IbAccountUpdate.findByPostExpirationExcessS", query = "SELECT i FROM IbAccountUpdate i WHERE i.postExpirationExcessS = :postExpirationExcessS"),
    @NamedQuery(name = "IbAccountUpdate.findByPostExpirationMargin", query = "SELECT i FROM IbAccountUpdate i WHERE i.postExpirationMargin = :postExpirationMargin"),
    @NamedQuery(name = "IbAccountUpdate.findByPostExpirationMarginC", query = "SELECT i FROM IbAccountUpdate i WHERE i.postExpirationMarginC = :postExpirationMarginC"),
    @NamedQuery(name = "IbAccountUpdate.findByPostExpirationMarginS", query = "SELECT i FROM IbAccountUpdate i WHERE i.postExpirationMarginS = :postExpirationMarginS"),
    @NamedQuery(name = "IbAccountUpdate.findByRealCurrency", query = "SELECT i FROM IbAccountUpdate i WHERE i.realCurrency = :realCurrency"),
    @NamedQuery(name = "IbAccountUpdate.findByRealizedPnL", query = "SELECT i FROM IbAccountUpdate i WHERE i.realizedPnL = :realizedPnL"),
    @NamedQuery(name = "IbAccountUpdate.findBySegmentTitleC", query = "SELECT i FROM IbAccountUpdate i WHERE i.segmentTitleC = :segmentTitleC"),
    @NamedQuery(name = "IbAccountUpdate.findBySegmentTitleS", query = "SELECT i FROM IbAccountUpdate i WHERE i.segmentTitleS = :segmentTitleS"),
    @NamedQuery(name = "IbAccountUpdate.findByStockMarketValue", query = "SELECT i FROM IbAccountUpdate i WHERE i.stockMarketValue = :stockMarketValue"),
    @NamedQuery(name = "IbAccountUpdate.findByTBillValue", query = "SELECT i FROM IbAccountUpdate i WHERE i.tBillValue = :tBillValue"),
    @NamedQuery(name = "IbAccountUpdate.findByTBondValue", query = "SELECT i FROM IbAccountUpdate i WHERE i.tBondValue = :tBondValue"),
    @NamedQuery(name = "IbAccountUpdate.findByTotalCashBalance", query = "SELECT i FROM IbAccountUpdate i WHERE i.totalCashBalance = :totalCashBalance"),
    @NamedQuery(name = "IbAccountUpdate.findByTotalCashValue", query = "SELECT i FROM IbAccountUpdate i WHERE i.totalCashValue = :totalCashValue"),
    @NamedQuery(name = "IbAccountUpdate.findByTotalCashValueC", query = "SELECT i FROM IbAccountUpdate i WHERE i.totalCashValueC = :totalCashValueC"),
    @NamedQuery(name = "IbAccountUpdate.findByTotalCashValueS", query = "SELECT i FROM IbAccountUpdate i WHERE i.totalCashValueS = :totalCashValueS"),
    @NamedQuery(name = "IbAccountUpdate.findByTotalDebitCardPendingCharges", query = "SELECT i FROM IbAccountUpdate i WHERE i.totalDebitCardPendingCharges = :totalDebitCardPendingCharges"),
    @NamedQuery(name = "IbAccountUpdate.findByTotalDebitCardPendingChargesC", query = "SELECT i FROM IbAccountUpdate i WHERE i.totalDebitCardPendingChargesC = :totalDebitCardPendingChargesC"),
    @NamedQuery(name = "IbAccountUpdate.findByTotalDebitCardPendingChargesS", query = "SELECT i FROM IbAccountUpdate i WHERE i.totalDebitCardPendingChargesS = :totalDebitCardPendingChargesS"),
    @NamedQuery(name = "IbAccountUpdate.findByTradingTypeS", query = "SELECT i FROM IbAccountUpdate i WHERE i.tradingTypeS = :tradingTypeS"),
    @NamedQuery(name = "IbAccountUpdate.findByUnrealizedPnL", query = "SELECT i FROM IbAccountUpdate i WHERE i.unrealizedPnL = :unrealizedPnL"),
    @NamedQuery(name = "IbAccountUpdate.findByWarrantValue", query = "SELECT i FROM IbAccountUpdate i WHERE i.warrantValue = :warrantValue"),
    @NamedQuery(name = "IbAccountUpdate.findByCreateDatetime", query = "SELECT i FROM IbAccountUpdate i WHERE i.createDatetime = :createDatetime"),
    @NamedQuery(name = "IbAccountUpdate.findByLastUpdateDatetime", query = "SELECT i FROM IbAccountUpdate i WHERE i.lastUpdateDatetime = :lastUpdateDatetime"),
    @NamedQuery(name = "IbAccountUpdate.findByIsActive", query = "SELECT i FROM IbAccountUpdate i WHERE i.isActive = :isActive"),
    @NamedQuery(name = "IbAccountUpdate.findByUpdateUserName", query = "SELECT i FROM IbAccountUpdate i WHERE i.updateUserName = :updateUserName")})
public class IbAccountUpdate implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull

	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_update_id")
    private Integer accountUpdateId;
    @Size(max = 25)
    @Column(name = "AccountCode")
    private String accountCode;
    @Size(max = 25)
    @Column(name = "AccountOrGroup")
    private String accountOrGroup;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "AccountReady")
    private BigDecimal accountReady;
    @Size(max = 25)
    @Column(name = "AccountType")
    private String accountType;
    @Column(name = "AccruedCash")
    private BigDecimal accruedCash;
    @Column(name = "AccruedCash_C")
    private BigDecimal accruedCashC;
    @Column(name = "AccruedCash_S")
    private BigDecimal accruedCashS;
    @Column(name = "AccruedDividend")
    private BigDecimal accruedDividend;
    @Column(name = "AccruedDividend_C")
    private BigDecimal accruedDividendC;
    @Column(name = "AccruedDividend_S")
    private BigDecimal accruedDividendS;
    @Column(name = "AvailableFunds")
    private BigDecimal availableFunds;
    @Column(name = "AvailableFunds_C")
    private BigDecimal availableFundsC;
    @Column(name = "AvailableFunds_S")
    private BigDecimal availableFundsS;
    @Column(name = "Billable")
    private BigDecimal billable;
    @Column(name = "Billable_C")
    private BigDecimal billableC;
    @Column(name = "Billable_S")
    private BigDecimal billableS;
    @Column(name = "BuyingPower")
    private BigDecimal buyingPower;
    @Column(name = "CashBalance")
    private BigDecimal cashBalance;
    @Column(name = "CorporateBondValue")
    private BigDecimal corporateBondValue;
    @Size(max = 25)
    @Column(name = "Currency")
    private String currency;
    @Column(name = "Cushion")
    private BigDecimal cushion;
    @Column(name = "EquityWithLoanValue")
    private BigDecimal equityWithLoanValue;
    @Column(name = "EquityWithLoanValue_C")
    private BigDecimal equityWithLoanValueC;
    @Column(name = "EquityWithLoanValue_S")
    private BigDecimal equityWithLoanValueS;
    @Column(name = "ExcessLiquidity")
    private BigDecimal excessLiquidity;
    @Column(name = "ExcessLiquidity_C")
    private BigDecimal excessLiquidityC;
    @Column(name = "ExcessLiquidity_S")
    private BigDecimal excessLiquidityS;
    @Column(name = "ExchangeRate")
    private BigDecimal exchangeRate;
    @Column(name = "FullAvailableFunds")
    private BigDecimal fullAvailableFunds;
    @Column(name = "FullAvailableFunds_C")
    private BigDecimal fullAvailableFundsC;
    @Column(name = "FullAvailableFunds_S")
    private BigDecimal fullAvailableFundsS;
    @Column(name = "FullExcessLiquidity")
    private BigDecimal fullExcessLiquidity;
    @Column(name = "FullExcessLiquidity_C")
    private BigDecimal fullExcessLiquidityC;
    @Column(name = "FullExcessLiquidity_S")
    private BigDecimal fullExcessLiquidityS;
    @Column(name = "FullInitMarginReq")
    private BigDecimal fullInitMarginReq;
    @Column(name = "FullInitMarginReq_C")
    private BigDecimal fullInitMarginReqC;
    @Column(name = "FullInitMarginReq_S")
    private BigDecimal fullInitMarginReqS;
    @Column(name = "FullMaintMarginReq")
    private BigDecimal fullMaintMarginReq;
    @Column(name = "FullMaintMarginReq_C")
    private BigDecimal fullMaintMarginReqC;
    @Column(name = "FullMaintMarginReq_S")
    private BigDecimal fullMaintMarginReqS;
    @Column(name = "FundValue")
    private BigDecimal fundValue;
    @Column(name = "FutureOptionValue")
    private BigDecimal futureOptionValue;
    @Column(name = "FuturesPNL")
    private BigDecimal futuresPNL;
    @Column(name = "FxCashBalance")
    private BigDecimal fxCashBalance;
    @Column(name = "GrossPositionValue")
    private BigDecimal grossPositionValue;
    @Column(name = "GrossPositionValue_S")
    private BigDecimal grossPositionValueS;
    @Column(name = "Guarantee")
    private BigDecimal guarantee;
    @Column(name = "Guarantee_C")
    private BigDecimal guaranteeC;
    @Column(name = "Guarantee_S")
    private BigDecimal guaranteeS;
    @Column(name = "IndianStockHaircut")
    private BigDecimal indianStockHaircut;
    @Column(name = "IndianStockHaircut_C")
    private BigDecimal indianStockHaircutC;
    @Column(name = "IndianStockHaircut_S")
    private BigDecimal indianStockHaircutS;
    @Column(name = "InitMarginReq")
    private BigDecimal initMarginReq;
    @Column(name = "InitMarginReq_C")
    private BigDecimal initMarginReqC;
    @Column(name = "InitMarginReq_S")
    private BigDecimal initMarginReqS;
    @Column(name = "IssuerOptionValue")
    private BigDecimal issuerOptionValue;
    @Column(name = "Leverage_S")
    private BigDecimal leverageS;
    @Column(name = "LookAheadAvailableFunds")
    private BigDecimal lookAheadAvailableFunds;
    @Column(name = "LookAheadAvailableFunds_C")
    private BigDecimal lookAheadAvailableFundsC;
    @Column(name = "LookAheadAvailableFunds_S")
    private BigDecimal lookAheadAvailableFundsS;
    @Column(name = "LookAheadExcessLiquidity")
    private BigDecimal lookAheadExcessLiquidity;
    @Column(name = "LookAheadExcessLiquidity_C")
    private BigDecimal lookAheadExcessLiquidityC;
    @Column(name = "LookAheadExcessLiquidity_S")
    private BigDecimal lookAheadExcessLiquidityS;
    @Column(name = "LookAheadInitMarginReq")
    private BigDecimal lookAheadInitMarginReq;
    @Column(name = "LookAheadInitMarginReq_C")
    private BigDecimal lookAheadInitMarginReqC;
    @Column(name = "LookAheadInitMarginReq_S")
    private BigDecimal lookAheadInitMarginReqS;
    @Column(name = "LookAheadMaintMarginReq")
    private BigDecimal lookAheadMaintMarginReq;
    @Column(name = "LookAheadMaintMarginReq_C")
    private BigDecimal lookAheadMaintMarginReqC;
    @Column(name = "LookAheadMaintMarginReq_S")
    private BigDecimal lookAheadMaintMarginReqS;
    @Column(name = "LookAheadNextChange")
    private BigDecimal lookAheadNextChange;
    @Column(name = "MaintMarginReq")
    private BigDecimal maintMarginReq;
    @Column(name = "MaintMarginReq_C")
    private BigDecimal maintMarginReqC;
    @Column(name = "MaintMarginReq_S")
    private BigDecimal maintMarginReqS;
    @Column(name = "MoneyMarketFundValue")
    private BigDecimal moneyMarketFundValue;
    @Column(name = "MutualFundValue")
    private BigDecimal mutualFundValue;
    @Column(name = "NetDividend")
    private BigDecimal netDividend;
    @Column(name = "NetLiquidation")
    private BigDecimal netLiquidation;
    @Column(name = "NetLiquidation_C")
    private BigDecimal netLiquidationC;
    @Column(name = "NetLiquidation_S")
    private BigDecimal netLiquidationS;
    @Column(name = "NetLiquidationByCurrency")
    private BigDecimal netLiquidationByCurrency;
    @Column(name = "NetLiquidationUncertainty")
    private BigDecimal netLiquidationUncertainty;
    @Column(name = "OptionMarketValue")
    private BigDecimal optionMarketValue;
    @Column(name = "PASharesValue")
    private BigDecimal pASharesValue;
    @Column(name = "PASharesValue_C")
    private BigDecimal pASharesValueC;
    @Column(name = "PASharesValue_S")
    private BigDecimal pASharesValueS;
    @Column(name = "PostExpirationExcess")
    private BigDecimal postExpirationExcess;
    @Column(name = "PostExpirationExcess_C")
    private BigDecimal postExpirationExcessC;
    @Column(name = "PostExpirationExcess_S")
    private BigDecimal postExpirationExcessS;
    @Column(name = "PostExpirationMargin")
    private BigDecimal postExpirationMargin;
    @Column(name = "PostExpirationMargin_C")
    private BigDecimal postExpirationMarginC;
    @Column(name = "PostExpirationMargin_S")
    private BigDecimal postExpirationMarginS;
    @Size(max = 25)
    @Column(name = "RealCurrency")
    private String realCurrency;
    @Column(name = "RealizedPnL")
    private BigDecimal realizedPnL;
    @Size(max = 25)
    @Column(name = "SegmentTitle_C")
    private String segmentTitleC;
    @Size(max = 25)
    @Column(name = "SegmentTitle_S")
    private String segmentTitleS;
    @Column(name = "StockMarketValue")
    private BigDecimal stockMarketValue;
    @Column(name = "TBillValue")
    private BigDecimal tBillValue;
    @Column(name = "TBondValue")
    private BigDecimal tBondValue;
    @Column(name = "TotalCashBalance")
    private BigDecimal totalCashBalance;
    @Column(name = "TotalCashValue")
    private BigDecimal totalCashValue;
    @Column(name = "TotalCashValue_C")
    private BigDecimal totalCashValueC;
    @Column(name = "TotalCashValue_S")
    private BigDecimal totalCashValueS;
    @Column(name = "TotalDebitCardPendingCharges")
    private BigDecimal totalDebitCardPendingCharges;
    @Column(name = "TotalDebitCardPendingCharges_C")
    private BigDecimal totalDebitCardPendingChargesC;
    @Column(name = "TotalDebitCardPendingCharges_S")
    private BigDecimal totalDebitCardPendingChargesS;
    @Size(max = 25)
    @Column(name = "TradingType_S")
    private String tradingTypeS;
    @Column(name = "UnrealizedPnL")
    private BigDecimal unrealizedPnL;
    @Column(name = "WarrantValue")
    private BigDecimal warrantValue;
    @Column(name = "create_datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDatetime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "last_update_datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdateDatetime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_active")
    private Character isActive;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "update_user_name")
    private String updateUserName;

    public IbAccountUpdate() {
    }

    public IbAccountUpdate(Integer accountUpdateId) {
        this.accountUpdateId = accountUpdateId;
    }

    public IbAccountUpdate(Integer accountUpdateId, Date lastUpdateDatetime, Character isActive, String updateUserName) {
        this.accountUpdateId = accountUpdateId;
        this.lastUpdateDatetime = lastUpdateDatetime;
        this.isActive = isActive;
        this.updateUserName = updateUserName;
    }

    public Integer getAccountUpdateId() {
        return accountUpdateId;
    }

    public void setAccountUpdateId(Integer accountUpdateId) {
        this.accountUpdateId = accountUpdateId;
    }

    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public String getAccountOrGroup() {
        return accountOrGroup;
    }

    public void setAccountOrGroup(String accountOrGroup) {
        this.accountOrGroup = accountOrGroup;
    }

    public BigDecimal getAccountReady() {
        return accountReady;
    }

    public void setAccountReady(BigDecimal accountReady) {
        this.accountReady = accountReady;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public BigDecimal getAccruedCash() {
        return accruedCash;
    }

    public void setAccruedCash(BigDecimal accruedCash) {
        this.accruedCash = accruedCash;
    }

    public BigDecimal getAccruedCashC() {
        return accruedCashC;
    }

    public void setAccruedCashC(BigDecimal accruedCashC) {
        this.accruedCashC = accruedCashC;
    }

    public BigDecimal getAccruedCashS() {
        return accruedCashS;
    }

    public void setAccruedCashS(BigDecimal accruedCashS) {
        this.accruedCashS = accruedCashS;
    }

    public BigDecimal getAccruedDividend() {
        return accruedDividend;
    }

    public void setAccruedDividend(BigDecimal accruedDividend) {
        this.accruedDividend = accruedDividend;
    }

    public BigDecimal getAccruedDividendC() {
        return accruedDividendC;
    }

    public void setAccruedDividendC(BigDecimal accruedDividendC) {
        this.accruedDividendC = accruedDividendC;
    }

    public BigDecimal getAccruedDividendS() {
        return accruedDividendS;
    }

    public void setAccruedDividendS(BigDecimal accruedDividendS) {
        this.accruedDividendS = accruedDividendS;
    }

    public BigDecimal getAvailableFunds() {
        return availableFunds;
    }

    public void setAvailableFunds(BigDecimal availableFunds) {
        this.availableFunds = availableFunds;
    }

    public BigDecimal getAvailableFundsC() {
        return availableFundsC;
    }

    public void setAvailableFundsC(BigDecimal availableFundsC) {
        this.availableFundsC = availableFundsC;
    }

    public BigDecimal getAvailableFundsS() {
        return availableFundsS;
    }

    public void setAvailableFundsS(BigDecimal availableFundsS) {
        this.availableFundsS = availableFundsS;
    }

    public BigDecimal getBillable() {
        return billable;
    }

    public void setBillable(BigDecimal billable) {
        this.billable = billable;
    }

    public BigDecimal getBillableC() {
        return billableC;
    }

    public void setBillableC(BigDecimal billableC) {
        this.billableC = billableC;
    }

    public BigDecimal getBillableS() {
        return billableS;
    }

    public void setBillableS(BigDecimal billableS) {
        this.billableS = billableS;
    }

    public BigDecimal getBuyingPower() {
        return buyingPower;
    }

    public void setBuyingPower(BigDecimal buyingPower) {
        this.buyingPower = buyingPower;
    }

    public BigDecimal getCashBalance() {
        return cashBalance;
    }

    public void setCashBalance(BigDecimal cashBalance) {
        this.cashBalance = cashBalance;
    }

    public BigDecimal getCorporateBondValue() {
        return corporateBondValue;
    }

    public void setCorporateBondValue(BigDecimal corporateBondValue) {
        this.corporateBondValue = corporateBondValue;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getCushion() {
        return cushion;
    }

    public void setCushion(BigDecimal cushion) {
        this.cushion = cushion;
    }

    public BigDecimal getEquityWithLoanValue() {
        return equityWithLoanValue;
    }

    public void setEquityWithLoanValue(BigDecimal equityWithLoanValue) {
        this.equityWithLoanValue = equityWithLoanValue;
    }

    public BigDecimal getEquityWithLoanValueC() {
        return equityWithLoanValueC;
    }

    public void setEquityWithLoanValueC(BigDecimal equityWithLoanValueC) {
        this.equityWithLoanValueC = equityWithLoanValueC;
    }

    public BigDecimal getEquityWithLoanValueS() {
        return equityWithLoanValueS;
    }

    public void setEquityWithLoanValueS(BigDecimal equityWithLoanValueS) {
        this.equityWithLoanValueS = equityWithLoanValueS;
    }

    public BigDecimal getExcessLiquidity() {
        return excessLiquidity;
    }

    public void setExcessLiquidity(BigDecimal excessLiquidity) {
        this.excessLiquidity = excessLiquidity;
    }

    public BigDecimal getExcessLiquidityC() {
        return excessLiquidityC;
    }

    public void setExcessLiquidityC(BigDecimal excessLiquidityC) {
        this.excessLiquidityC = excessLiquidityC;
    }

    public BigDecimal getExcessLiquidityS() {
        return excessLiquidityS;
    }

    public void setExcessLiquidityS(BigDecimal excessLiquidityS) {
        this.excessLiquidityS = excessLiquidityS;
    }

    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public BigDecimal getFullAvailableFunds() {
        return fullAvailableFunds;
    }

    public void setFullAvailableFunds(BigDecimal fullAvailableFunds) {
        this.fullAvailableFunds = fullAvailableFunds;
    }

    public BigDecimal getFullAvailableFundsC() {
        return fullAvailableFundsC;
    }

    public void setFullAvailableFundsC(BigDecimal fullAvailableFundsC) {
        this.fullAvailableFundsC = fullAvailableFundsC;
    }

    public BigDecimal getFullAvailableFundsS() {
        return fullAvailableFundsS;
    }

    public void setFullAvailableFundsS(BigDecimal fullAvailableFundsS) {
        this.fullAvailableFundsS = fullAvailableFundsS;
    }

    public BigDecimal getFullExcessLiquidity() {
        return fullExcessLiquidity;
    }

    public void setFullExcessLiquidity(BigDecimal fullExcessLiquidity) {
        this.fullExcessLiquidity = fullExcessLiquidity;
    }

    public BigDecimal getFullExcessLiquidityC() {
        return fullExcessLiquidityC;
    }

    public void setFullExcessLiquidityC(BigDecimal fullExcessLiquidityC) {
        this.fullExcessLiquidityC = fullExcessLiquidityC;
    }

    public BigDecimal getFullExcessLiquidityS() {
        return fullExcessLiquidityS;
    }

    public void setFullExcessLiquidityS(BigDecimal fullExcessLiquidityS) {
        this.fullExcessLiquidityS = fullExcessLiquidityS;
    }

    public BigDecimal getFullInitMarginReq() {
        return fullInitMarginReq;
    }

    public void setFullInitMarginReq(BigDecimal fullInitMarginReq) {
        this.fullInitMarginReq = fullInitMarginReq;
    }

    public BigDecimal getFullInitMarginReqC() {
        return fullInitMarginReqC;
    }

    public void setFullInitMarginReqC(BigDecimal fullInitMarginReqC) {
        this.fullInitMarginReqC = fullInitMarginReqC;
    }

    public BigDecimal getFullInitMarginReqS() {
        return fullInitMarginReqS;
    }

    public void setFullInitMarginReqS(BigDecimal fullInitMarginReqS) {
        this.fullInitMarginReqS = fullInitMarginReqS;
    }

    public BigDecimal getFullMaintMarginReq() {
        return fullMaintMarginReq;
    }

    public void setFullMaintMarginReq(BigDecimal fullMaintMarginReq) {
        this.fullMaintMarginReq = fullMaintMarginReq;
    }

    public BigDecimal getFullMaintMarginReqC() {
        return fullMaintMarginReqC;
    }

    public void setFullMaintMarginReqC(BigDecimal fullMaintMarginReqC) {
        this.fullMaintMarginReqC = fullMaintMarginReqC;
    }

    public BigDecimal getFullMaintMarginReqS() {
        return fullMaintMarginReqS;
    }

    public void setFullMaintMarginReqS(BigDecimal fullMaintMarginReqS) {
        this.fullMaintMarginReqS = fullMaintMarginReqS;
    }

    public BigDecimal getFundValue() {
        return fundValue;
    }

    public void setFundValue(BigDecimal fundValue) {
        this.fundValue = fundValue;
    }

    public BigDecimal getFutureOptionValue() {
        return futureOptionValue;
    }

    public void setFutureOptionValue(BigDecimal futureOptionValue) {
        this.futureOptionValue = futureOptionValue;
    }

    public BigDecimal getFuturesPNL() {
        return futuresPNL;
    }

    public void setFuturesPNL(BigDecimal futuresPNL) {
        this.futuresPNL = futuresPNL;
    }

    public BigDecimal getFxCashBalance() {
        return fxCashBalance;
    }

    public void setFxCashBalance(BigDecimal fxCashBalance) {
        this.fxCashBalance = fxCashBalance;
    }

    public BigDecimal getGrossPositionValue() {
        return grossPositionValue;
    }

    public void setGrossPositionValue(BigDecimal grossPositionValue) {
        this.grossPositionValue = grossPositionValue;
    }

    public BigDecimal getGrossPositionValueS() {
        return grossPositionValueS;
    }

    public void setGrossPositionValueS(BigDecimal grossPositionValueS) {
        this.grossPositionValueS = grossPositionValueS;
    }

    public BigDecimal getGuarantee() {
        return guarantee;
    }

    public void setGuarantee(BigDecimal guarantee) {
        this.guarantee = guarantee;
    }

    public BigDecimal getGuaranteeC() {
        return guaranteeC;
    }

    public void setGuaranteeC(BigDecimal guaranteeC) {
        this.guaranteeC = guaranteeC;
    }

    public BigDecimal getGuaranteeS() {
        return guaranteeS;
    }

    public void setGuaranteeS(BigDecimal guaranteeS) {
        this.guaranteeS = guaranteeS;
    }

    public BigDecimal getIndianStockHaircut() {
        return indianStockHaircut;
    }

    public void setIndianStockHaircut(BigDecimal indianStockHaircut) {
        this.indianStockHaircut = indianStockHaircut;
    }

    public BigDecimal getIndianStockHaircutC() {
        return indianStockHaircutC;
    }

    public void setIndianStockHaircutC(BigDecimal indianStockHaircutC) {
        this.indianStockHaircutC = indianStockHaircutC;
    }

    public BigDecimal getIndianStockHaircutS() {
        return indianStockHaircutS;
    }

    public void setIndianStockHaircutS(BigDecimal indianStockHaircutS) {
        this.indianStockHaircutS = indianStockHaircutS;
    }

    public BigDecimal getInitMarginReq() {
        return initMarginReq;
    }

    public void setInitMarginReq(BigDecimal initMarginReq) {
        this.initMarginReq = initMarginReq;
    }

    public BigDecimal getInitMarginReqC() {
        return initMarginReqC;
    }

    public void setInitMarginReqC(BigDecimal initMarginReqC) {
        this.initMarginReqC = initMarginReqC;
    }

    public BigDecimal getInitMarginReqS() {
        return initMarginReqS;
    }

    public void setInitMarginReqS(BigDecimal initMarginReqS) {
        this.initMarginReqS = initMarginReqS;
    }

    public BigDecimal getIssuerOptionValue() {
        return issuerOptionValue;
    }

    public void setIssuerOptionValue(BigDecimal issuerOptionValue) {
        this.issuerOptionValue = issuerOptionValue;
    }

    public BigDecimal getLeverageS() {
        return leverageS;
    }

    public void setLeverageS(BigDecimal leverageS) {
        this.leverageS = leverageS;
    }

    public BigDecimal getLookAheadAvailableFunds() {
        return lookAheadAvailableFunds;
    }

    public void setLookAheadAvailableFunds(BigDecimal lookAheadAvailableFunds) {
        this.lookAheadAvailableFunds = lookAheadAvailableFunds;
    }

    public BigDecimal getLookAheadAvailableFundsC() {
        return lookAheadAvailableFundsC;
    }

    public void setLookAheadAvailableFundsC(BigDecimal lookAheadAvailableFundsC) {
        this.lookAheadAvailableFundsC = lookAheadAvailableFundsC;
    }

    public BigDecimal getLookAheadAvailableFundsS() {
        return lookAheadAvailableFundsS;
    }

    public void setLookAheadAvailableFundsS(BigDecimal lookAheadAvailableFundsS) {
        this.lookAheadAvailableFundsS = lookAheadAvailableFundsS;
    }

    public BigDecimal getLookAheadExcessLiquidity() {
        return lookAheadExcessLiquidity;
    }

    public void setLookAheadExcessLiquidity(BigDecimal lookAheadExcessLiquidity) {
        this.lookAheadExcessLiquidity = lookAheadExcessLiquidity;
    }

    public BigDecimal getLookAheadExcessLiquidityC() {
        return lookAheadExcessLiquidityC;
    }

    public void setLookAheadExcessLiquidityC(BigDecimal lookAheadExcessLiquidityC) {
        this.lookAheadExcessLiquidityC = lookAheadExcessLiquidityC;
    }

    public BigDecimal getLookAheadExcessLiquidityS() {
        return lookAheadExcessLiquidityS;
    }

    public void setLookAheadExcessLiquidityS(BigDecimal lookAheadExcessLiquidityS) {
        this.lookAheadExcessLiquidityS = lookAheadExcessLiquidityS;
    }

    public BigDecimal getLookAheadInitMarginReq() {
        return lookAheadInitMarginReq;
    }

    public void setLookAheadInitMarginReq(BigDecimal lookAheadInitMarginReq) {
        this.lookAheadInitMarginReq = lookAheadInitMarginReq;
    }

    public BigDecimal getLookAheadInitMarginReqC() {
        return lookAheadInitMarginReqC;
    }

    public void setLookAheadInitMarginReqC(BigDecimal lookAheadInitMarginReqC) {
        this.lookAheadInitMarginReqC = lookAheadInitMarginReqC;
    }

    public BigDecimal getLookAheadInitMarginReqS() {
        return lookAheadInitMarginReqS;
    }

    public void setLookAheadInitMarginReqS(BigDecimal lookAheadInitMarginReqS) {
        this.lookAheadInitMarginReqS = lookAheadInitMarginReqS;
    }

    public BigDecimal getLookAheadMaintMarginReq() {
        return lookAheadMaintMarginReq;
    }

    public void setLookAheadMaintMarginReq(BigDecimal lookAheadMaintMarginReq) {
        this.lookAheadMaintMarginReq = lookAheadMaintMarginReq;
    }

    public BigDecimal getLookAheadMaintMarginReqC() {
        return lookAheadMaintMarginReqC;
    }

    public void setLookAheadMaintMarginReqC(BigDecimal lookAheadMaintMarginReqC) {
        this.lookAheadMaintMarginReqC = lookAheadMaintMarginReqC;
    }

    public BigDecimal getLookAheadMaintMarginReqS() {
        return lookAheadMaintMarginReqS;
    }

    public void setLookAheadMaintMarginReqS(BigDecimal lookAheadMaintMarginReqS) {
        this.lookAheadMaintMarginReqS = lookAheadMaintMarginReqS;
    }

    public BigDecimal getLookAheadNextChange() {
        return lookAheadNextChange;
    }

    public void setLookAheadNextChange(BigDecimal lookAheadNextChange) {
        this.lookAheadNextChange = lookAheadNextChange;
    }

    public BigDecimal getMaintMarginReq() {
        return maintMarginReq;
    }

    public void setMaintMarginReq(BigDecimal maintMarginReq) {
        this.maintMarginReq = maintMarginReq;
    }

    public BigDecimal getMaintMarginReqC() {
        return maintMarginReqC;
    }

    public void setMaintMarginReqC(BigDecimal maintMarginReqC) {
        this.maintMarginReqC = maintMarginReqC;
    }

    public BigDecimal getMaintMarginReqS() {
        return maintMarginReqS;
    }

    public void setMaintMarginReqS(BigDecimal maintMarginReqS) {
        this.maintMarginReqS = maintMarginReqS;
    }

    public BigDecimal getMoneyMarketFundValue() {
        return moneyMarketFundValue;
    }

    public void setMoneyMarketFundValue(BigDecimal moneyMarketFundValue) {
        this.moneyMarketFundValue = moneyMarketFundValue;
    }

    public BigDecimal getMutualFundValue() {
        return mutualFundValue;
    }

    public void setMutualFundValue(BigDecimal mutualFundValue) {
        this.mutualFundValue = mutualFundValue;
    }

    public BigDecimal getNetDividend() {
        return netDividend;
    }

    public void setNetDividend(BigDecimal netDividend) {
        this.netDividend = netDividend;
    }

    public BigDecimal getNetLiquidation() {
        return netLiquidation;
    }

    public void setNetLiquidation(BigDecimal netLiquidation) {
        this.netLiquidation = netLiquidation;
    }

    public BigDecimal getNetLiquidationC() {
        return netLiquidationC;
    }

    public void setNetLiquidationC(BigDecimal netLiquidationC) {
        this.netLiquidationC = netLiquidationC;
    }

    public BigDecimal getNetLiquidationS() {
        return netLiquidationS;
    }

    public void setNetLiquidationS(BigDecimal netLiquidationS) {
        this.netLiquidationS = netLiquidationS;
    }

    public BigDecimal getNetLiquidationByCurrency() {
        return netLiquidationByCurrency;
    }

    public void setNetLiquidationByCurrency(BigDecimal netLiquidationByCurrency) {
        this.netLiquidationByCurrency = netLiquidationByCurrency;
    }

    public BigDecimal getNetLiquidationUncertainty() {
        return netLiquidationUncertainty;
    }

    public void setNetLiquidationUncertainty(BigDecimal netLiquidationUncertainty) {
        this.netLiquidationUncertainty = netLiquidationUncertainty;
    }

    public BigDecimal getOptionMarketValue() {
        return optionMarketValue;
    }

    public void setOptionMarketValue(BigDecimal optionMarketValue) {
        this.optionMarketValue = optionMarketValue;
    }

    public BigDecimal getPASharesValue() {
        return pASharesValue;
    }

    public void setPASharesValue(BigDecimal pASharesValue) {
        this.pASharesValue = pASharesValue;
    }

    public BigDecimal getPASharesValueC() {
        return pASharesValueC;
    }

    public void setPASharesValueC(BigDecimal pASharesValueC) {
        this.pASharesValueC = pASharesValueC;
    }

    public BigDecimal getPASharesValueS() {
        return pASharesValueS;
    }

    public void setPASharesValueS(BigDecimal pASharesValueS) {
        this.pASharesValueS = pASharesValueS;
    }

    public BigDecimal getPostExpirationExcess() {
        return postExpirationExcess;
    }

    public void setPostExpirationExcess(BigDecimal postExpirationExcess) {
        this.postExpirationExcess = postExpirationExcess;
    }

    public BigDecimal getPostExpirationExcessC() {
        return postExpirationExcessC;
    }

    public void setPostExpirationExcessC(BigDecimal postExpirationExcessC) {
        this.postExpirationExcessC = postExpirationExcessC;
    }

    public BigDecimal getPostExpirationExcessS() {
        return postExpirationExcessS;
    }

    public void setPostExpirationExcessS(BigDecimal postExpirationExcessS) {
        this.postExpirationExcessS = postExpirationExcessS;
    }

    public BigDecimal getPostExpirationMargin() {
        return postExpirationMargin;
    }

    public void setPostExpirationMargin(BigDecimal postExpirationMargin) {
        this.postExpirationMargin = postExpirationMargin;
    }

    public BigDecimal getPostExpirationMarginC() {
        return postExpirationMarginC;
    }

    public void setPostExpirationMarginC(BigDecimal postExpirationMarginC) {
        this.postExpirationMarginC = postExpirationMarginC;
    }

    public BigDecimal getPostExpirationMarginS() {
        return postExpirationMarginS;
    }

    public void setPostExpirationMarginS(BigDecimal postExpirationMarginS) {
        this.postExpirationMarginS = postExpirationMarginS;
    }

    public String getRealCurrency() {
        return realCurrency;
    }

    public void setRealCurrency(String realCurrency) {
        this.realCurrency = realCurrency;
    }

    public BigDecimal getRealizedPnL() {
        return realizedPnL;
    }

    public void setRealizedPnL(BigDecimal bigDecimal) {
        this.realizedPnL = bigDecimal;
    }

    public String getSegmentTitleC() {
        return segmentTitleC;
    }

    public void setSegmentTitleC(String segmentTitleC) {
        this.segmentTitleC = segmentTitleC;
    }

    public String getSegmentTitleS() {
        return segmentTitleS;
    }

    public void setSegmentTitleS(String segmentTitleS) {
        this.segmentTitleS = segmentTitleS;
    }

    public BigDecimal getStockMarketValue() {
        return stockMarketValue;
    }

    public void setStockMarketValue(BigDecimal stockMarketValue) {
        this.stockMarketValue = stockMarketValue;
    }

    public BigDecimal getTBillValue() {
        return tBillValue;
    }

    public void setTBillValue(BigDecimal tBillValue) {
        this.tBillValue = tBillValue;
    }

    public BigDecimal getTBondValue() {
        return tBondValue;
    }

    public void setTBondValue(BigDecimal tBondValue) {
        this.tBondValue = tBondValue;
    }

    public BigDecimal getTotalCashBalance() {
        return totalCashBalance;
    }

    public void setTotalCashBalance(BigDecimal totalCashBalance) {
        this.totalCashBalance = totalCashBalance;
    }

    public BigDecimal getTotalCashValue() {
        return totalCashValue;
    }

    public void setTotalCashValue(BigDecimal totalCashValue) {
        this.totalCashValue = totalCashValue;
    }

    public BigDecimal getTotalCashValueC() {
        return totalCashValueC;
    }

    public void setTotalCashValueC(BigDecimal totalCashValueC) {
        this.totalCashValueC = totalCashValueC;
    }

    public BigDecimal getTotalCashValueS() {
        return totalCashValueS;
    }

    public void setTotalCashValueS(BigDecimal totalCashValueS) {
        this.totalCashValueS = totalCashValueS;
    }

    public BigDecimal getTotalDebitCardPendingCharges() {
        return totalDebitCardPendingCharges;
    }

    public void setTotalDebitCardPendingCharges(BigDecimal totalDebitCardPendingCharges) {
        this.totalDebitCardPendingCharges = totalDebitCardPendingCharges;
    }

    public BigDecimal getTotalDebitCardPendingChargesC() {
        return totalDebitCardPendingChargesC;
    }

    public void setTotalDebitCardPendingChargesC(BigDecimal totalDebitCardPendingChargesC) {
        this.totalDebitCardPendingChargesC = totalDebitCardPendingChargesC;
    }

    public BigDecimal getTotalDebitCardPendingChargesS() {
        return totalDebitCardPendingChargesS;
    }

    public void setTotalDebitCardPendingChargesS(BigDecimal totalDebitCardPendingChargesS) {
        this.totalDebitCardPendingChargesS = totalDebitCardPendingChargesS;
    }

    public String getTradingTypeS() {
        return tradingTypeS;
    }

    public void setTradingTypeS(String tradingTypeS) {
        this.tradingTypeS = tradingTypeS;
    }

    public BigDecimal getUnrealizedPnL() {
        return unrealizedPnL;
    }

    public void setUnrealizedPnL(BigDecimal bigDecimal) {
        this.unrealizedPnL = bigDecimal;
    }

    public BigDecimal getWarrantValue() {
        return warrantValue;
    }

    public void setWarrantValue(BigDecimal warrantValue) {
        this.warrantValue = warrantValue;
    }

    public Date getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(Date createDatetime) {
        this.createDatetime = createDatetime;
    }

    public Date getLastUpdateDatetime() {
        return lastUpdateDatetime;
    }

    public void setLastUpdateDatetime(Date lastUpdateDatetime) {
        this.lastUpdateDatetime = lastUpdateDatetime;
    }

    public Character getIsActive() {
        return isActive;
    }

    public void setIsActive(Character isActive) {
        this.isActive = isActive;
    }

    public String getUpdateUserName() {
        return updateUserName;
    }

    public void setUpdateUserName(String updateUserName) {
        this.updateUserName = updateUserName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accountUpdateId != null ? accountUpdateId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IbAccountUpdate)) {
            return false;
        }
        IbAccountUpdate other = (IbAccountUpdate) object;
        if ((this.accountUpdateId == null && other.accountUpdateId != null) || (this.accountUpdateId != null && !this.accountUpdateId.equals(other.accountUpdateId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.finflock.IbAccountUpdate[ accountUpdateId=" + accountUpdateId + " ]";
    }
    
}
