package command_pattern3;

import java.util.*;

public class Agent {
	Queue<Order> m_ordersQueue = new LinkedList<Order>();
	
	public void placeOrder(Order order) {
		System.out.println("Agent place order");
		m_ordersQueue.add(order);
		order.execute();
	}
}
