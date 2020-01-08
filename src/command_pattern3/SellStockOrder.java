package command_pattern3;

public class SellStockOrder extends Order {
	StockTrade stock;
	
	public SellStockOrder(StockTrade stock) {
		this.stock = stock;
	}
	public void execute() {
		stock.sell();
	}
}
