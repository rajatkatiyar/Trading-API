package Test2;


import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.finflock.jpa.IbAccountUpdate;
import com.finflock.jpa.IbExecutionDetails;
import com.finflock.jpa.IbOrderStatusA;
import com.finflock.jpa.IbOrders;

import com.finflock.jpa.JPA_DB_Manager;
import com.finflock.jpa.ObjectHolder;
import com.ib.client.Bar;
import com.ib.client.CommissionReport;
import com.ib.client.Contract;
import com.ib.client.ContractDescription;
import com.ib.client.ContractDetails;
import com.ib.client.DeltaNeutralContract;
import com.ib.client.DepthMktDataDescription;
import com.ib.client.EClient;
import com.ib.client.EClientSocket;
import com.ib.client.EJavaSignal;
import com.ib.client.EReaderSignal;
import com.ib.client.EWrapper;
import com.ib.client.EWrapperMsgGenerator;
import com.ib.client.Execution;
import com.ib.client.FamilyCode;
import com.ib.client.HistogramEntry;
import com.ib.client.HistoricalTick;
import com.ib.client.HistoricalTickBidAsk;
import com.ib.client.HistoricalTickLast;
import com.ib.client.NewsProvider;
import com.ib.client.Order;
import com.ib.client.OrderState;
import com.ib.client.PriceIncrement;
import com.ib.client.SoftDollarTier;
import com.ib.client.TickAttrib;
import com.ib.client.TickAttribBidAsk;
import com.ib.client.TickAttribLast;
import com.ib.client.TickType;



public class MyEwrapperInterface implements EWrapper{
	private com.ib.client.EReaderSignal readerSignal;
	private EClient clientSocket;
	//protected int currentOrderId = -1;
	protected int currentOrderId = -1;
	//! [socket_declare]
	
	//! [socket_init]
	public MyEwrapperInterface() {
		readerSignal = new EJavaSignal();
		clientSocket = new EClientSocket(this, readerSignal);
	}
	//! [socket_init]
	public EClient getClient() {
		return clientSocket;
	}
	
	public EReaderSignal getSignal() {
		
		return readerSignal;
	}
	
	public int getCurrentOrderId() {
		return currentOrderId;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    }

	@Override
	public void tickPrice(int tickerId, int field, double price, TickAttrib attribs) {
		System.out.println("Tick Price. Ticker Id:"+tickerId+", Field: "+field+", Price: "+price+", CanAutoExecute: "+ attribs.canAutoExecute()
		+ ", pastLimit: " + attribs.pastLimit() + ", pre-open: " + attribs.preOpen());
	}
	//! [tickprice]
	
	//! [ticksize]
	@Override
	public void tickSize(int tickerId, int field, int size) {
		System.out.println("Tick Size. Ticker Id:" + tickerId + ", Field: " + field + ", Size: " + size);
	}
	//! [ticksize]
	
	//! [tickoptioncomputation]
	@Override
	public void tickOptionComputation(int tickerId, int field,
			double impliedVol, double delta, double optPrice,
			double pvDividend, double gamma, double vega, double theta,
			double undPrice) {
		System.out.println("TickOptionComputation. TickerId: "+tickerId+", field: "+field+", ImpliedVolatility: "+impliedVol+", Delta: "+delta
                +", OptionPrice: "+optPrice+", pvDividend: "+pvDividend+", Gamma: "+gamma+", Vega: "+vega+", Theta: "+theta+", UnderlyingPrice: "+undPrice);
	}
	//! [tickoptioncomputation]
	
	//! [tickgeneric]
	@Override
	public void tickGeneric(int tickerId, int tickType, double value) {
		System.out.println("Tick Generic. Ticker Id:" + tickerId + ", Field: " + TickType.getField(tickType) + ", Value: " + value);
	}
	//! [tickgeneric]
	
	//! [tickstring]
	@Override
	public void tickString(int tickerId, int tickType, String value) {
		System.out.println("Tick string. Ticker Id:" + tickerId + ", Type: " + tickType + ", Value: " + value);
	}
	//! [tickstring]
	@Override
	public void tickEFP(int tickerId, int tickType, double basisPoints,
			String formattedBasisPoints, double impliedFuture, int holdDays,
			String futureLastTradeDate, double dividendImpact,
			double dividendsToLastTradeDate) {
		System.out.println("TickEFP. "+tickerId+", Type: "+tickType+", BasisPoints: "+basisPoints+", FormattedBasisPoints: "+
			formattedBasisPoints+", ImpliedFuture: "+impliedFuture+", HoldDays: "+holdDays+", FutureLastTradeDate: "+futureLastTradeDate+
			", DividendImpact: "+dividendImpact+", DividendsToLastTradeDate: "+dividendsToLastTradeDate);
	}
	//! [orderstatus]
	IbOrderStatusA ObjIbOrderStatusC;
	{
		ObjIbOrderStatusC=new IbOrderStatusA();
	}
	@Override
	public void orderStatus(int orderId, String status, double filled,
			double remaining, double avgFillPrice, int permId, int parentId,
			double lastFillPrice, int clientId, String whyHeld, double mktCapPrice) {
		System.out.println("OrderStatus. Id: "+orderId+", Status: "+status+", Filled"+filled+", Remaining: "+remaining
                +", AvgFillPrice: "+avgFillPrice+", PermId: "+permId+", ParentId: "+parentId+", LastFillPrice: "+lastFillPrice+
                ", ClientId: "+clientId+", WhyHeld: "+whyHeld+", MktCapPrice: "+mktCapPrice);
		System.out.println("-----------------------------------oprn order id   "+orderId+"--------------------------------------");
		System.out.println("OrderId.getOId()  db  -  "+(OrderId.getOId()+1));
		System.out.println("orderId               -  "+orderId);
		
		if((OrderId.getOId()+1)==orderId) {
			System.out.println("if--");
		//	ObjIbOrderStatusC.setId(5);
			ObjIbOrderStatusC.setOrderId(orderId);
			ObjIbOrderStatusC.setStatus(status);
			ObjIbOrderStatusC.setFilled(new BigDecimal(filled));
			ObjIbOrderStatusC.setAvgFillPrice(new BigDecimal(avgFillPrice));
			ObjIbOrderStatusC.setPermId(permId);
			ObjIbOrderStatusC.setParentId(parentId);
			ObjIbOrderStatusC.setLastFillPrice(new BigDecimal(lastFillPrice));
			ObjIbOrderStatusC.setClientId(clientId);
			ObjIbOrderStatusC.setWhyHeld(whyHeld);
			ObjIbOrderStatusC.setMktCapPricemkt(new BigDecimal(mktCapPrice));
			JPA_DB_Manager.insertIbOrderStatus(ObjIbOrderStatusC);
			//ObjectHolder.setObjOrderStatus(ObjIbOrderStatusC);
			}
			
	}
	//! [orderstatus]
	
	//! [openorder]
	/*JSONArray ja;
	
	public JSONArray getJa() {
		return ja;
	}
	public void setJa(JSONArray ja) {
		this.ja = ja;
	}
*/
	{
		//ja=new JSONArray();
//	System.out.println("JSON OBject created$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$##############################################");
	}
	@Override
	
	public void openOrder(int orderId, Contract contract, Order order,
			OrderState orderState) {
		System.out.println(EWrapperMsgGenerator.openOrder(orderId, contract, order, orderState));
		JSONObject jo=new JSONObject();
		try {
			jo.put("OpenOrder",":");
			jo.put("Action",order.action());
			jo.put("Total Quantity",order.totalQuantity());
			jo.put("cashQty",order.cashQty());
			jo.put("conid",contract.conid());
			jo.put("symbol",contract.symbol());
			jo.put("getSecType", contract.getSecType());
			jo.put("lastTradeDateOrContractMonth", contract.lastTradeDateOrContractMonth());
			jo.put("orderState", ":");
			jo.put("Status", orderState.getStatus());
			jo.put("commissionCurrency", orderState.commissionCurrency());
			
					JSONArrayPojo.setJo(jo);
			
		
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("---------------------------oprn order end  id    --   "+orderId+"---------------------------------------------------");
	}
	//! [openorder]
	
	//! [openorderend]
	@Override
	public void openOrderEnd() {
		System.out.println("OpenOrderEnd");
	}
	//! [openorderend]
	IbAccountUpdate obj;
	{
		obj=new IbAccountUpdate();
		System.out.println("object for IbAccountUpdate is -----------"+obj);
	}
	
	//! [updateaccountvalue]
	int i=0;
	int j=0;
	int k=0;
	@Override
	public void updateAccountValue(String key, String value, String currency,
			String accountName) {
		
		obj.setCurrency(currency);
		if(key.equals("AccountCode")) {obj.setAccountCode(value);	}	
		if(key.equals("AccountOrGroup")) {obj.setAccountOrGroup(value);	}		
		if(key.equals("NetLiquidationByCurrency")) {obj.setNetLiquidationByCurrency(new BigDecimal(value));	}
		if(key.equals("AccountReady")) {obj.setAccountReady(new BigDecimal(value));	}	
		if(key.equals("AccountType")) {obj.setAccountType(value);	}	
		if(key.equals("AccruedCash")) {obj.setAccruedCash(new BigDecimal(value));	}	
		if(key.equals("AccruedCash-C")) {obj.setAccruedCashC(new BigDecimal(value));	}
		if(key.equals("AccruedCash-S")) {obj.setAccruedCashS(new BigDecimal(value));	}
		if(key.equals("AccruedDividend")) {obj.setAccruedDividend(new BigDecimal(value));	}
		//if(key.equals("AccruedCash")) {obj.setAccruedCash(new BigDecimal(value));	}
		if(key.equals("AccruedDividend-C")) {obj.setAccruedDividendC(new BigDecimal(value));	}
		if(key.equals("AccruedDividend-S")) {obj.setAccruedDividendS(new BigDecimal(value));	}
		if(key.equals("AvailableFunds")) {obj.setAvailableFunds(new BigDecimal(value));	}
		if(key.equals("AvailableFunds-C")) {obj.setAvailableFundsC(new BigDecimal(value));	}
		if(key.equals("AvailableFunds-S")) {obj.setAvailableFundsS(new BigDecimal(value));	}
		if(key.equals("Billable")) {obj.setBillable(new BigDecimal(value));	}
		if(key.equals("Billable-C")) {obj.setBillableC(new BigDecimal(value));	}
		if(key.equals("Billable-S")) {obj.setBillableS(new BigDecimal(value));	}
		if(key.equals("BuyingPower")) {obj.setBuyingPower(new BigDecimal(value));	}

		if(key.equals("CashBalance")) {obj.setCashBalance(new BigDecimal(value));	}
		if(key.equals("CorporateBondValue")) {obj.setCorporateBondValue(new BigDecimal(value));	}
		if(key.equals("Cushion")) {obj.setCushion(new BigDecimal(value));	}

		if(key.equals("EquityWithLoanValue")) {obj.setEquityWithLoanValue(new BigDecimal(value));	}
		if(key.equals("EquityWithLoanValue-C")) {obj.setEquityWithLoanValueC(new BigDecimal(value));	}

		if(key.equals("EquityWithLoanValue-S")) {obj.setEquityWithLoanValueS(new BigDecimal(value));	}

		if(key.equals("ExcessLiquidity")) {obj.setExcessLiquidity(new BigDecimal(value));	}
		if(key.equals("ExcessLiquidity-C")) {obj.setExcessLiquidityC(new BigDecimal(value));	}
		if(key.equals("ExcessLiquidity-S")) {obj.setExcessLiquidityS(new BigDecimal(value));	}
		if(key.equals("ExchangeRate")) {obj.setExchangeRate(new BigDecimal(value));	}
		if(key.equals("FullAvailableFunds")) {obj.setFullAvailableFunds(new BigDecimal(value));	}
		if(key.equals("FullAvailableFunds-C")) {obj.setFullAvailableFundsC(new BigDecimal(value));	}
		
		if(key.equals("FullAvailableFunds-S")) {obj.setFullAvailableFundsS(new BigDecimal(value));	}
		if(key.equals("FullExcessLiquidity")) {obj.setFullExcessLiquidity(new BigDecimal(value));	}
		if(key.equals("FullExcessLiquidity-C")) {obj.setFullExcessLiquidityC(new BigDecimal(value));	}
		if(key.equals("FullExcessLiquidity-S")) {obj.setFullExcessLiquidityS(new BigDecimal(value));	}
		if(key.equals("FullInitMarginReq")) {obj.setFullInitMarginReq(new BigDecimal(value));	}
		if(key.equals("FullInitMarginReq-C")) {obj.setFullInitMarginReqC(new BigDecimal(value));	}
		if(key.equals("FullInitMarginReq-S")) {obj.setFullInitMarginReqS(new BigDecimal(value));	}
		if(key.equals("FullMaintMarginReq")) {obj.setFullMaintMarginReq(new BigDecimal(value));	}
		if(key.equals("FullMaintMarginReq-C")) {obj.setFullMaintMarginReqC(new BigDecimal(value));	}
		if(key.equals("FullMaintMarginReq-S")) {obj.setFullMaintMarginReqS(new BigDecimal(value));	}
		
	//	if(key.equals("FullMaintMarginReq")) {obj.setFullMaintMarginReq(new BigDecimal(value));	}
		//if(key.equals("FullMaintMarginReq-C")) {obj.setFullMaintMarginReqC(new BigDecimal(value));	}
		//if(key.equals("FullMaintMarginReq-S")) {obj.setFullMaintMarginReqS(new BigDecimal(value));	}
		if(key.equals("FundValue")) {obj.setFundValue(new BigDecimal(value));	}
		if(key.equals("FutureOptionValue")) {obj.setFutureOptionValue(new BigDecimal(value));	}
		if(key.equals("FuturesPNL")) {obj.setFuturesPNL(new BigDecimal(value));	}
		if(key.equals("FxCashBalance")) {obj.setFxCashBalance(new BigDecimal(value));	}
		if(key.equals("GrossPositionValue")) {obj.setGrossPositionValue(new BigDecimal(value));	}
		if(key.equals("GrossPositionValue-S")) {obj.setGrossPositionValueS(new BigDecimal(value));	}
		if(key.equals("Guarantee")) {obj.setGuarantee(new BigDecimal(value));	}
		if(key.equals("Guarantee-C")) {obj.setGuaranteeC(new BigDecimal(value));	}
		if(key.equals("Guarantee-S")) {obj.setGuaranteeS(new BigDecimal(value));	}
		if(key.equals("ExcessLiquidity")) {obj.setExcessLiquidity(new BigDecimal(value));	}

		if(key.equals("IndianStockHaircut")) {obj.setIndianStockHaircut(new BigDecimal(value));	}
		if(key.equals("IndianStockHaircut-C")) {obj.setIndianStockHaircutC(new BigDecimal(value));	}

		if(key.equals("IndianStockHaircut-S")) {obj.setIndianStockHaircutS(new BigDecimal(value));	}
		if(key.equals("InitMarginReq")) {obj.setInitMarginReq(new BigDecimal(value));	}
		if(key.equals("InitMarginReq-C")) {obj.setInitMarginReqC(new BigDecimal(value));	}
		if(key.equals("InitMarginReq-S")) {obj.setInitMarginReqS(new BigDecimal(value));	}
		if(key.equals("IssuerOptionValue")) {obj.setIssuerOptionValue(new BigDecimal(value));	}

		if(key.equals("Leverage-S")) {obj.setLeverageS(new BigDecimal(value));	}
		if(key.equals("LookAheadAvailableFunds")) {obj.setLookAheadAvailableFunds(new BigDecimal(value));	}
		if(key.equals("LookAheadAvailableFunds-C")) {obj.setLookAheadAvailableFundsC(new BigDecimal(value));	}
		if(key.equals("LookAheadAvailableFunds-S")) {obj.setLookAheadAvailableFundsS(new BigDecimal(value));	}
		if(key.equals("LookAheadExcessLiquidity")) {obj.setLookAheadExcessLiquidity(new BigDecimal(value));	}
		if(key.equals("LookAheadExcessLiquidity-C")) {obj.setLookAheadExcessLiquidityC(new BigDecimal(value));	}
		if(key.equals("LookAheadExcessLiquidity-S")) {obj.setLookAheadExcessLiquidityS(new BigDecimal(value));	}
		if(key.equals("LookAheadInitMarginReq")) {obj.setLookAheadInitMarginReq(new BigDecimal(value));	}
		if(key.equals("LookAheadInitMarginReq-C")) {obj.setLookAheadInitMarginReqC(new BigDecimal(value));	}
		if(key.equals("LookAheadInitMarginReq-S")) {obj.setLookAheadInitMarginReqS(new BigDecimal(value));	}
		if(key.equals("LookAheadMaintMarginReq")) {obj.setLookAheadMaintMarginReq(new BigDecimal(value));	}
		if(key.equals("LookAheadMaintMarginReq-C")) {obj.setLookAheadMaintMarginReqC(new BigDecimal(value));	}
		if(key.equals("LookAheadMaintMarginReq-S")) {obj.setLookAheadMaintMarginReqS(new BigDecimal(value));	}

		if(key.equals("LookAheadNextChange")) {obj.setLookAheadNextChange(new BigDecimal(value));	}
		if(key.equals("MaintMarginReq")) {obj.setMaintMarginReq(new BigDecimal(value));	}
		if(key.equals("MaintMarginReq-C")) {obj.setMaintMarginReqC(new BigDecimal(value));	}
		if(key.equals("MaintMarginReq-S")) {obj.setMaintMarginReqS(new BigDecimal(value));	}
		if(key.equals("MoneyMarketFundValue")) {obj.setMoneyMarketFundValue(new BigDecimal(value));	}
		if(key.equals("MutualFundValue")) {obj.setMutualFundValue(new BigDecimal(value));	}
		//if(key.equals("NLVAndMarginInReview")) {obj.setNLVAndMarginInReview(new BigDecimal(value));	}
		if(key.equals("NetDividend")) {obj.setNetDividend(new BigDecimal(value));	}
		//if(key.equals("NetLiquidation")) {obj.setNetLiquidationByCurrency(new BigDecimal(value));	}

		if(key.equals("NetLiquidation")) {obj.setNetLiquidation(new BigDecimal(value));	}
		if(key.equals("NetLiquidation-C")) {obj.setNetLiquidationC(new BigDecimal(value));	}
		if(key.equals("NetLiquidation-S")) {obj.setNetLiquidationS(new BigDecimal(value));	}
		if(key.equals("NetLiquidationByCurrency")) {obj.setNetLiquidationByCurrency(new BigDecimal(value));	}
		if(key.equals("NetLiquidationUncertainty")) {obj.setNetLiquidationUncertainty(new BigDecimal(value));	}
		if(key.equals("OptionMarketValue")) {obj.setOptionMarketValue(new BigDecimal(value));	}
		if(key.equals("PASharesValue")) {obj.setPASharesValue(new BigDecimal(value));	}
		if(key.equals("PASharesValue-C")) {obj.setPASharesValueC(new BigDecimal(value));	}

		if(key.equals("PASharesValue-S")) {obj.setPASharesValueS(new BigDecimal(value));	}
		if(key.equals("PostExpirationExcess")) {obj.setPostExpirationExcess(new BigDecimal(value));	}
		if(key.equals("PostExpirationExcess-C")) {obj.setPostExpirationExcessC(new BigDecimal(value));	}
		if(key.equals("PostExpirationExcess-S")) {obj.setPostExpirationExcessS(new BigDecimal(value));	}
		if(key.equals("PostExpirationMargin")) {obj.setPostExpirationMargin(new BigDecimal(value));	}
		if(key.equals("PostExpirationMargin-C")) {obj.setPostExpirationMarginC(new BigDecimal(value));	}
		if(key.equals("PostExpirationMargin-S")) {obj.setPostExpirationMarginS(new BigDecimal(value));	}
		//if(key.equals("PostExpirationMargin")) {obj.setPostExpirationMargin(new BigDecimal(value));	}
		if(key.equals("RealCurrency")) {obj.setRealCurrency(value);	}
		if(key.equals("RealizedPnL")) {obj.setRealizedPnL(new BigDecimal(value));	}
		//if(key.equals("SegmentTitle")) {obj.setSegmentTitle(new BigDecimal(value));	}
		if(key.equals("PASharesValue")) {obj.setPASharesValue(new BigDecimal(value));	}

		if(key.equals("SegmentTitle-C")) {obj.setSegmentTitleC(value);	}
		if(key.equals("SegmentTitle-S")) {obj.setSegmentTitleS(value);	}
		if(key.equals("StockMarketValue")) {obj.setStockMarketValue(new BigDecimal(value));	}
		if(key.equals("TBillValue")) {obj.setTBillValue(new BigDecimal(value));	}
		if(key.equals("TBondValue")) {obj.setTBondValue(new BigDecimal(value));	}
		if(key.equals("TotalCashBalance")) {obj.setTotalCashBalance(new BigDecimal(value));	}
		//----------------------
		
		if(key.equals("TotalCashBalance")) {obj.setTotalCashBalance(new BigDecimal(value));	}
		if(key.equals("TotalCashValue")) {obj.setTotalCashValue(new BigDecimal(value));	}
		if(key.equals("TotalCashValue")) {obj.setTotalCashValueC(new BigDecimal(value));	}
		
		if(key.equals("TotalCashValue")) {obj.setTotalCashValueS(new BigDecimal(value));	}
		if(key.equals("TotalDebitCardPendingCharges")) {obj.setTotalDebitCardPendingCharges(new BigDecimal(value));	}
		if(key.equals("TotalDebitCardPendingCharges-C")) {obj.setTotalDebitCardPendingChargesC(new BigDecimal(value));	}
		
		if(key.equals("TotalDebitCardPendingCharges-S")) {obj.setTotalDebitCardPendingChargesS(new BigDecimal(value));	}
		if(key.equals("TBondValue")) {obj.setTBondValue(new BigDecimal(value));	}
		if(key.equals("TotalCashBalance")) {obj.setTotalCashBalance(new BigDecimal(value));	}
		
		if(key.equals("TradingType-S")) {obj.setTradingTypeS(value);	}
		if(key.equals("UnrealizedPnL")) {obj.setUnrealizedPnL(new BigDecimal(value));	}
		if(key.equals("WarrantValue")) {obj.setWarrantValue(new BigDecimal(value));	}
		//------
		
	
		
		



ObjectHolder.setObj(obj);
		
		System.out.println("UpdateAccountValue. Key: " + key + ", Value: " + value + ", Currency: " +
		currency + ", AccountName: " + accountName);
	}
	//! [updateaccountvalue]
	
	//! [updateportfolio]
	@Override
	public void updatePortfolio(Contract contract, double position,
			double marketPrice, double marketValue, double averageCost,
			double unrealizedPNL, double realizedPNL, String accountName) {
	 
		System.out.println(""+contract.symbol()+", "+contract.secType()+" @ "+contract.exchange()
                +": Position: "+position+", MarketPrice: "+marketPrice+", MarketValue: "+marketValue+", AverageCost: "+averageCost
                +", UnrealizedPNL: "+unrealizedPNL+", RealizedPNL: "+realizedPNL+", AccountName: "+accountName);
	}
	//! [updateportfolio]
	
	//! [updateaccounttime]
	@Override
	public void updateAccountTime(String timeStamp) {
		obj.setLastUpdateDatetime	(new Date());	
		k=k+1;
		System.out.println("---k-"+k+"---"+obj+"-----UpdateAccountTime. Time: " + timeStamp+"\n");
	}
	//! [updateaccounttime]
	
	//! [accountdownloadend]
	@Override
	public void accountDownloadEnd(String accountName) {
	obj.setUpdateUserName	(accountName);	
		ObjectHolder.setObj(obj);
		JPA_DB_Manager.insert(obj);
		System.out.println("Account download finished: "+accountName+"\n");
	}
	//! [accountdownloadend]
	
	//! [nextvalidid]
	@Override
	public void nextValidId(int orderId) throws ClassNotFoundException, SQLException {
		System.out.println();
		System.out.println();
		System.out.println("Next Valid Id ~~~~~~~~~~~~~~~~~~~~~~~new order~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~: ["+orderId+"]");
		System.out.println();
		System.out.println();
		currentOrderId = orderId;
		OrderId.setOId(orderId);
	}
	//! [nextvalidid]
	
	//! [contractdetails]
	@Override
	public void contractDetails(int reqId, ContractDetails contractDetails) {
		System.out.println(EWrapperMsgGenerator.contractDetails(reqId, contractDetails)); 
	}
	//! [contractdetails]
	@Override
	public void bondContractDetails(int reqId, ContractDetails contractDetails) {
		System.out.println(EWrapperMsgGenerator.bondContractDetails(reqId, contractDetails)); 
	}
	//! [contractdetailsend]
	@Override
	public void contractDetailsEnd(int reqId) {
		System.out.println("ContractDetailsEnd. "+reqId+"\n");
	}
	//! [contractdetailsend]
	
	//! [execdetails
	
	@Override
	public void execDetails(int reqId, Contract contract, Execution execution) {
		System.out.println("ExecDetails. "+reqId+" - ["+contract.symbol()+"], ["+contract.secType()+"], "
				+ "["+contract.currency()+"], ["+execution.execId()+
		        "], ["+execution.orderId()+"], ["+execution.shares()+"]"  + ", [" + execution.lastLiquidity() + "]");
		JSONObject obj=new JSONObject();
		IbExecutionDetails 	objExeDetail=new IbExecutionDetails();
		objExeDetail.setReqId(reqId);
		objExeDetail.setSymbol(contract.symbol());
		objExeDetail.setSecType(contract.getSecType());
		objExeDetail.setCurrency(contract.currency());
		objExeDetail.setExecId(execution.execId());
		objExeDetail.setOrderId(execution.orderId());
		objExeDetail.setShares(new BigDecimal(execution.shares()));
		JPA_DB_Manager.insertExecutionDetails(objExeDetail);
		
	
		try {
			obj.put("ExecDetails",reqId);
			obj.put("contract symbol",contract.symbol());
			obj.put("contract secType",contract.secType());
			obj.put("contract currency",contract.currency());
			obj.put("execution execId",execution.execId());
			obj.put("execution orderId",execution.orderId());
			obj.put("execution shares",execution.shares());
		
			obj.put("execution lastLiquidity",execution.lastLiquidity());
			JSONArrayExecutionPOJO.setJo(obj);

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//! [execdetails]
	
	//! [execdetailsend]
	@Override
	public void execDetailsEnd(int reqId) {
		System.out.println("ExecDetailsEnd. "+reqId+"\n");
	}
	//! [execdetailsend]
	
	//! [updatemktdepth]
	@Override
	public void updateMktDepth(int tickerId, int position, int operation,
			int side, double price, int size) {
		System.out.println("UpdateMarketDepth. "+tickerId+" - Position: "+position+", Operation: "+operation+", Side: "+side+", Price: "+price+", Size: "+size+"");
	}
	//! [updatemktdepth]
	
	//! [updatemktdepthl2]
	@Override
	public void updateMktDepthL2(int tickerId, int position,
			String marketMaker, int operation, int side, double price, int size, boolean isSmartDepth) {
		System.out.println("UpdateMarketDepthL2. "+tickerId+" - Position: "+position+", Operation: "+operation+", Side: "+side+", Price: "+price+", Size: "+size+", isSmartDepth: "+isSmartDepth);
	}
	//! [updatemktdepthl2]
	
	//! [updatenewsbulletin]
	@Override
	public void updateNewsBulletin(int msgId, int msgType, String message,
			String origExchange) {
		
		System.out.println("News Bulletins. "+msgId+" - Type: "+msgType+", Message: "+message+", Exchange of Origin: "+origExchange+"\n");
	}
	//! [updatenewsbulletin]
	
	//! [managedaccounts]
	@Override
	public void managedAccounts(String accountsList) {
		System.out.println("Account list: " +accountsList);
	}
	//! [managedaccounts]

	//! [receivefa]
	@Override
	public void receiveFA(int faDataType, String xml) {
		System.out.println("Receiving FA: "+faDataType+" - "+xml);
	}
	//! [receivefa]
	
	//! [historicaldata]
	@Override
    public void historicalData(int reqId, Bar bar) {
        System.out.println("HistoricalData. "+reqId+" - Date: "+bar.time()+", Open: "+bar.open()+", High: "+bar.high()+", Low: "+bar.low()+", Close: "+bar.close()+", Volume: "+bar.volume()+", Count: "+bar.count()+", WAP: "+bar.wap());
    }
	//! [historicaldata]
	
	//! [historicaldataend]
	 @Override
	    public void historicalDataEnd(int reqId, String startDateStr, String endDateStr) {
	        System.out.println("HistoricalDataEnd. "+reqId+" - Start Date: "+startDateStr+", End Date: "+endDateStr);
	    }
	//! [historicaldataend]
	
	
	//! [scannerparameters]
	@Override
	public void scannerParameters(String xml) {
		System.out.println("ScannerParameters. "+xml+"\n");
	}
	//! [scannerparameters]
	
	//! [scannerdata]
	@Override
	public void scannerData(int reqId, int rank,
			ContractDetails contractDetails, String distance, String benchmark,
			String projection, String legsStr) {
		System.out.println("ScannerData. "+reqId+" - Rank: "+rank+", Symbol: "+contractDetails.contract().symbol()+", SecType: "+contractDetails.contract().secType()+", Currency: "+contractDetails.contract().currency()
                +", Distance: "+distance+", Benchmark: "+benchmark+", Projection: "+projection+", Legs String: "+legsStr);
	}
	//! [scannerdata]
	
	//! [scannerdataend]
	@Override
	public void scannerDataEnd(int reqId) {
		System.out.println("ScannerDataEnd. "+reqId);
	}
	//! [scannerdataend]nextValidId
	
	//! [realtimebar]
	@Override
	public void realtimeBar(int reqId, long time, double open, double high,
			double low, double close, long volume, double wap, int count) {
		System.out.println("RealTimeBars. " + reqId + " - Time: " + time + ", Open: " + open + ", High: " + high + ", Low: " + low + ", Close: " + close + ", Volume: " + volume + ", Count: " + count + ", WAP: " + wap);
	}
	//! [realtimebar]
	@Override
	public void currentTime(long time) {
		System.out.println("currentTime");
	}
	//! [fundamentaldata]
	@Override
	public void fundamentalData(int reqId, String data) {
		System.out.println("FundamentalData. ReqId: ["+reqId+"] - Data: ["+data+"]");
	}
	//! [fundamentaldata]
	@Override
	public void deltaNeutralValidation(int reqId, DeltaNeutralContract deltaNeutralContract) {
		System.out.println("deltaNeutralValidation");
	}
	//! [ticksnapshotend]
	@Override
	public void tickSnapshotEnd(int reqId) {
		System.out.println("TickSnapshotEnd: "+reqId);
	}
	//! [ticksnapshotend]
	
	//! [marketdatatype]
	@Override
	public void marketDataType(int reqId, int marketDataType) {
		System.out.println("MarketDataType. ["+reqId+"], Type: ["+marketDataType+"]\n");
	}
	//! [marketdatatype]
	
	//! [commissionreport]
	@Override
	public void commissionReport(CommissionReport commissionReport) {
		System.out.println("CommissionReport. ["+commissionReport.m_execId+"] - ["+commissionReport.m_commission+"] ["+commissionReport.m_currency+"] RPNL ["+commissionReport.m_realizedPNL+"]");
	}
	//! [commissionreport]
	
	//! [position]
	@Override
	public void position(String account, Contract contract, double pos,
			double avgCost) {
		System.out.println("Position. "+account+" - Symbol: "+contract.symbol()+", SecType: "+contract.secType()+", Currency: "+contract.currency()+", Position: "+pos+", Avg cost: "+avgCost);
	}
	//! [position]
	
	//! [positionend]
	@Override
	public void positionEnd() {
		System.out.println("PositionEnd \n");
	}
	//! [positionend]
	
	//! [accountsummary]
	@Override
	public void accountSummary(int reqId, String account, String tag,
			String value, String currency) {
		System.out.println("Acct Summary. ReqId: " + reqId + ", Acct: " + account + ", Tag: " + tag + ", Value: " + value + ", Currency: " + currency);
	}
	//! [accountsummary]
	
	//! [accountsummaryend]
	@Override
	public void accountSummaryEnd(int reqId) {
		System.out.println("AccountSummaryEnd. Req Id: "+reqId+"\n");
	}
	//! [accountsummaryend]
	@Override
	public void verifyMessageAPI(String apiData) {
		System.out.println("verifyMessageAPI");
	}

	@Override
	public void verifyCompleted(boolean isSuccessful, String errorText) {
		System.out.println("verifyCompleted");
	}

	@Override
	public void verifyAndAuthMessageAPI(String apiData, String xyzChallenge) {
		System.out.println("verifyAndAuthMessageAPI");
	}

	@Override
	public void verifyAndAuthCompleted(boolean isSuccessful, String errorText) {
		System.out.println("verifyAndAuthCompleted");
	}
	//! [displaygrouplist]
	@Override
	public void displayGroupList(int reqId, String groups) {
		System.out.println("Display Group List. ReqId: "+reqId+", Groups: "+groups+"\n");
	}
	//! [displaygrouplist]
	
	//! [displaygroupupdated]
	@Override
	public void displayGroupUpdated(int reqId, String contractInfo) {
		System.out.println("Display Group Updated. ReqId: "+reqId+", Contract info: "+contractInfo+"\n");
	}
	//! [displaygroupupdated]
	@Override
	public void error(Exception e) {
		System.out.println("Exception: "+e.getMessage());
	}

	@Override
	public void error(String str) {
		System.out.println("Error STR");
	}
	//! [error]
	@Override
	public void error(int id, int errorCode, String errorMsg) {
		System.out.println("Error. Id: " + id + ", Code: " + errorCode + ", Msg: " + errorMsg + "\n");
	}
	//! [error]
	@Override
	public void connectionClosed() {
		System.out.println("Connection closed");
	}

	//! [connectack]
	@Override
	public void connectAck() {
		//System.out.println("Acknowledging connection");
		if (((EClientSocket) clientSocket).isAsyncEConnect()) {
			System.out.println("Acknowledging connection");
			clientSocket.startAPI();
		}
	}
	//! [connectack]
	
	//! [positionmulti]
	@Override
	public void positionMulti(int reqId, String account, String modelCode,
			Contract contract, double pos, double avgCost) {
		System.out.println("Position Multi. Request: " + reqId + ", Account: " + account + ", ModelCode: " + modelCode + ", Symbol: " + contract.symbol() + ", SecType: " + contract.secType() + ", Currency: " + contract.currency() + ", Position: " + pos + ", Avg cost: " + avgCost + "\n");
	}
	//! [positionmulti]
	
	//! [positionmultiend]
	@Override
	public void positionMultiEnd(int reqId) {
		System.out.println("Position Multi End. Request: " + reqId + "\n");
	}
	//! [positionmultiend]
	
	//! [accountupdatemulti]
	@Override
	public void accountUpdateMulti(int reqId, String account, String modelCode,
			String key, String value, String currency) {
		System.out.println("Account Update Multi. Request: " + reqId + ", Account: " + account + ", ModelCode: " + modelCode + ", Key: " + key + ", Value: " + value + ", Currency: " + currency + "\n");
	}
	//! [accountupdatemulti]
	
	//! [accountupdatemultiend]
	@Override
	public void accountUpdateMultiEnd(int reqId) {
		System.out.println("Account Update Multi End. Request: " + reqId + "\n");
	}
	//! [accountupdatemultiend]
	
	//! [securityDefinitionOptionParameter]
	@Override
	public void securityDefinitionOptionalParameter(int reqId, String exchange,
			int underlyingConId, String tradingClass, String multiplier,
			Set<String> expirations, Set<Double> strikes) {
		System.out.println("Security Definition Optional Parameter. Request: "+reqId+", Trading Class: "+tradingClass+", Multiplier: "+multiplier+" \n");
	}
	//! [securityDefinitionOptionParameter]

	//! [securityDefinitionOptionParameterEnd]
	@Override
	public void securityDefinitionOptionalParameterEnd(int reqId) {
		System.out.println("Security Definition Optional Parameter End. Request: " + reqId);
	}
	//! [securityDefinitionOptionParameterEnd]

    //! [softDollarTiers]
	@Override
	public void softDollarTiers(int reqId, SoftDollarTier[] tiers) {
		for (SoftDollarTier tier : tiers) {
			System.out.print("tier: " + tier.toString() + ", ");
		}
		
		System.out.println();
	}
    //! [softDollarTiers]

    //! [familyCodes]
    @Override
    public void familyCodes(FamilyCode[] familyCodes) {
        for (FamilyCode fc : familyCodes) {
            System.out.print("Family Code. AccountID: " + fc.accountID() + ", FamilyCode: " + fc.familyCodeStr());
        }

        System.out.println();
    }
    //! [familyCodes]
    
    //! [symbolSamples]
    @Override
    public void symbolSamples(int reqId, ContractDescription[] contractDescriptions) {
        System.out.println("Contract Descriptions. Request: " + reqId + "\n");
        for (ContractDescription  cd : contractDescriptions) {
            Contract c = cd.contract();
            StringBuilder derivativeSecTypesSB = new StringBuilder();
            for (String str : cd.derivativeSecTypes()) {
                derivativeSecTypesSB.append(str);
                derivativeSecTypesSB.append(",");
            }
            System.out.print("Contract. ConId: " + c.conid() + ", Symbol: " + c.symbol() + ", SecType: " + c.secType() + 
                    ", PrimaryExch: " + c.primaryExch() + ", Currency: " + c.currency() + 
                    ", DerivativeSecTypes:[" + derivativeSecTypesSB.toString() + "]");
        }

        System.out.println();
    }
    //! [symbolSamples]
    
	//! [mktDepthExchanges]
	@Override
	public void mktDepthExchanges(DepthMktDataDescription[] depthMktDataDescriptions) {
		for (DepthMktDataDescription depthMktDataDescription : depthMktDataDescriptions) {
			System.out.println("Depth Mkt Data Description. Exchange: " + depthMktDataDescription.exchange() +
			", ListingExch: " + depthMktDataDescription.listingExch() + 
			", SecType: " + depthMktDataDescription.secType() +
			", ServiceDataType: " + depthMktDataDescription.serviceDataType() +
			", AggGroup: " + depthMktDataDescription.aggGroup()
			);
		}
	}
	//! [mktDepthExchanges]
	
	//! [tickNews]
	@Override
	public void tickNews(int tickerId, long timeStamp, String providerCode, String articleId, String headline, String extraData) {
		System.out.println("Tick News. TickerId: " + tickerId + ", TimeStamp: " + timeStamp + ", ProviderCode: " + providerCode + ", ArticleId: " + articleId + ", Headline: " + headline + ", ExtraData: " + extraData + "\n");
	}
	//! [tickNews]

	//! [smartcomponents]
	@Override
	public void smartComponents(int reqId, Map<Integer, Entry<String, Character>> theMap) {
		System.out.println("smart components req id:" + reqId);
		
		for (Map.Entry<Integer, Entry<String, Character>> item : theMap.entrySet()) {
			System.out.println("bit number: " + item.getKey() + 
					", exchange: " + item.getValue().getKey() + ", exchange letter: " + item.getValue().getValue());			
		}
	}
	//! [smartcomponents]

	//! [tickReqParams]
	@Override
	public void tickReqParams(int tickerId, double minTick, String bboExchange, int snapshotPermissions) {
		System.out.println("Tick req params. Ticker Id:" + tickerId + ", Min tick: " + minTick + ", bbo exchange: " + bboExchange + ", Snapshot permissions: " + snapshotPermissions);
	}
	//! [tickReqParams]

	//! [newsProviders]
	@Override
	public void newsProviders(NewsProvider[] newsProviders) {
		for (NewsProvider np : newsProviders) {
			System.out.print("News Provider. ProviderCode: " + np.providerCode() + ", ProviderName: " + np.providerName() + "\n");
		}

		System.out.println();
	}
	//! [newsProviders]

	//! [newsArticle]
	@Override
	public void newsArticle(int requestId, int articleType, String articleText) {
		System.out.println("News Article. Request Id: " + requestId + ", ArticleType: " + articleType + 
				", ArticleText: " + articleText);
	}
	//! [newsArticle]

	//! [historicalNews]
	@Override
	public void historicalNews(int requestId, String time, String providerCode, String articleId, String headline) {
		System.out.println("Historical News. RequestId: " + requestId + ", Time: " + time + ", ProviderCode: " + providerCode + ", ArticleId: " + articleId + ", Headline: " + headline + "\n");
	}
	//! [historicalNews]

	//! [historicalNewsEnd]
	@Override
	public void historicalNewsEnd(int requestId, boolean hasMore) {
		System.out.println("Historical News End. RequestId: " + requestId + ", HasMore: " + hasMore + "\n");
	}
	//! [historicalNewsEnd]

	//! [headTimestamp]
	@Override
	public void headTimestamp(int reqId, String headTimestamp) {
		System.out.println("Head timestamp. Req Id: " + reqId + ", headTimestamp: " + headTimestamp);
	}
	//! [headTimestamp]
	
	//! [histogramData]
	@Override
	public void histogramData(int reqId, List<HistogramEntry> items) {
		System.out.println(EWrapperMsgGenerator.histogramData(reqId, items));
	}
	//! [histogramData]

	//! [historicalDataUpdate]
	@Override
    public void historicalDataUpdate(int reqId, Bar bar) {
        System.out.println("HistoricalDataUpdate. "+reqId+" - Date: "+bar.time()+", Open: "+bar.open()+", High: "+bar.high()+", Low: "+bar.low()+", Close: "+bar.close()+", Volume: "+bar.volume()+", Count: "+bar.count()+", WAP: "+bar.wap());
    }
	//! [historicalDataUpdate]
	
	//! [rerouteMktDataReq]
	@Override
	public void rerouteMktDataReq(int reqId, int conId, String exchange) {
		System.out.println(EWrapperMsgGenerator.rerouteMktDataReq(reqId, conId, exchange));
	}
	//! [rerouteMktDataReq]
	
	//! [rerouteMktDepthReq]
	@Override
	public void rerouteMktDepthReq(int reqId, int conId, String exchange) {
		System.out.println(EWrapperMsgGenerator.rerouteMktDepthReq(reqId, conId, exchange));
	}
	//! [rerouteMktDepthReq]
	
	//! [marketRule]
	@Override
	public void marketRule(int marketRuleId, PriceIncrement[] priceIncrements) {
		DecimalFormat df = new DecimalFormat("#.#");
		df.setMaximumFractionDigits(340);
		System.out.println("Market Rule Id: " + marketRuleId);
		for (PriceIncrement pi : priceIncrements) {
			System.out.println("Price Increment. Low Edge: " + df.format(pi.lowEdge()) + ", Increment: " + df.format(pi.increment()));
		}
	}
	//! [marketRule]
	
	//! [pnl]
    @Override
    public void pnl(int reqId, double dailyPnL, double unrealizedPnL, double realizedPnL) {
        System.out.println(EWrapperMsgGenerator.pnl(reqId, dailyPnL, unrealizedPnL, realizedPnL));
    }
    //! [pnl]
	
	//! [pnlsingle]
    @Override
    public void pnlSingle(int reqId, int pos, double dailyPnL, double unrealizedPnL, double realizedPnL, double value) {
        System.out.println(EWrapperMsgGenerator.pnlSingle(reqId, pos, dailyPnL, unrealizedPnL, realizedPnL, value));                
    }
    //! [pnlsingle]
	
	//! [historicalticks]
    @Override
    public void historicalTicks(int reqId, List<HistoricalTick> ticks, boolean done) {
        for (HistoricalTick tick : ticks) {
            System.out.println(EWrapperMsgGenerator.historicalTick(reqId, tick.time(), tick.price(), tick.size()));
        }
    }
    //! [historicalticks]
	
	//! [historicalticksbidask]
    @Override
    public void historicalTicksBidAsk(int reqId, List<HistoricalTickBidAsk> ticks, boolean done) {
        for (HistoricalTickBidAsk tick : ticks) {
            System.out.println(EWrapperMsgGenerator.historicalTickBidAsk(reqId, tick.time(), tick.tickAttribBidAsk(), tick.priceBid(), tick.priceAsk(), tick.sizeBid(),
                    tick.sizeAsk()));
        }
    }   
    //! [historicalticksbidask]
	
    @Override
	//! [historicaltickslast]
    public void historicalTicksLast(int reqId, List<HistoricalTickLast> ticks, boolean done) {
        for (HistoricalTickLast tick : ticks) {
            System.out.println(EWrapperMsgGenerator.historicalTickLast(reqId, tick.time(), tick.tickAttribLast(), tick.price(), tick.size(), tick.exchange(), 
                tick.specialConditions()));
        }
    }
    //! [historicaltickslast]

    //! [tickbytickalllast]
   @Override
    public void tickByTickAllLast(int reqId, int tickType, long time, double price, int size, TickAttribLast tickAttribLast,
            String exchange, String specialConditions) {
        System.out.println(EWrapperMsgGenerator.tickByTickAllLast(reqId, tickType, time, price, size, tickAttribLast, exchange, specialConditions));
    }
    //! [tickbytickalllast]

    //! [tickbytickbidask]
    @Override
    public void tickByTickBidAsk(int reqId, long time, double bidPrice, double askPrice, int bidSize, int askSize,
            TickAttribBidAsk tickAttribBidAsk) {
        System.out.println(EWrapperMsgGenerator.tickByTickBidAsk(reqId, time, bidPrice, askPrice, bidSize, askSize, tickAttribBidAsk));
    }
    //! [tickbytickbidask]
    
    //! [tickbytickmidpoint]
    @Override
    public void tickByTickMidPoint(int reqId, long time, double midPoint) {
        System.out.println(EWrapperMsgGenerator.tickByTickMidPoint(reqId, time, midPoint));
    }
    //! [tickbytickmidpoint]

    //! [orderbound]
    @Override
    public void orderBound(long orderId, int apiClientId, int apiOrderId) {
        System.out.println(EWrapperMsgGenerator.orderBound(orderId, apiClientId, apiOrderId));
    }
    //! [orderbound]
}


