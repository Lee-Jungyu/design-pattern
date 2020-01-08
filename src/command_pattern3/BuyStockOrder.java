package command_pattern3;

public class BuyStockOrder extends Order {
	StockTrade stock;
	
	public BuyStockOrder(StockTrade stock) {
		this.stock = stock;
	}
	public void execute() {
		stock.buy();
	}
}
