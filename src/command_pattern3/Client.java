package command_pattern3;

public class Client {
	public static void main(String[] args)
	{
		StockTrade stock = new StockTrade();
		BuyStockOrder bso = new BuyStockOrder(stock);
		SellStockOrder sso = new SellStockOrder(stock);
		Agent agent = new Agent();
		agent.placeOrder(bso); //buy shares
		agent.placeOrder(sso); //sell shares
	}
}
