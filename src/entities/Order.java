package entities;


import java.util.ArrayList;
import java.util.Calendar;

import java.util.List;

import enums.OrderStatus;

public class Order {
	//Attributes
	private Client client;
	private Calendar moment = Calendar.getInstance();
	private OrderStatus status;
	private List<OrderItem> shopList = new ArrayList<>();
	
	
	//Getters and Setters
	public List<OrderItem> getShopList() {
		return shopList;
	}
	public void setShopList(List<OrderItem> shopList) {
		this.shopList = shopList;
	}
	
	public Calendar getMoment() {
		return moment;
	}	
	public OrderStatus getStatus() {
		return status;
	}
	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	
	//Methods
	public void  addItem(OrderItem order) {
		shopList.add(order);
	}
	public void  removeItem(OrderItem order) {
		shopList.remove(order);
	}
	
	public double total() {
		Double sum = 0.0;
		for(OrderItem item : shopList) {
			sum += item.subTotal();
		}
		return sum;
	}
}
