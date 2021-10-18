package programa;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import enums.OrderStatus;

public class MainApp {
	public static void main(String[] args) throws ParseException {
		
		System.out.println("Enter client data:");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Name: ");
		String nome = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		String dataDeNascimento = sc.nextLine();
		
		Client cliente1 = new Client(nome, email, dataDeNascimento);
		
		System.out.println("-".repeat(20));
		
		System.out.println("Enter order data: ");
		
		Order order = new Order();
		order.setStatus(OrderStatus.PROCESSING);
		order.setClient(cliente1);
		
		System.out.println("Status: PROCESSING");
		System.out.println("How many itens to this order? ");
		int itemQuantity = sc.nextInt();
		for (int i = 0; i < itemQuantity; i++) {
			System.out.println("Enter #" + (i+1) + " item data:");
			sc.nextLine();
			System.out.print("Product name: ");
			String product = sc.nextLine();
			System.out.print("Product price: ");
			Double price = sc.nextDouble();
			System.out.print("Quantity: ");
			
			int quantity = sc.nextInt();			
			Product produtinho = new Product(product, price);
			OrderItem orderItemzinho = new OrderItem(quantity, produtinho);
			List<OrderItem> shopList = new ArrayList<>();
			shopList = order.getShopList();
			shopList.add(orderItemzinho);
			order.setShopList(shopList);
		}
		
		System.out.println("\nORDER SUMMARY:\n");
		
		System.out.println("Order moment: " + order.getMoment().getTime());
		System.out.println("Order status: " + order.getStatus());
		System.out.println(order.getClient().toString());
		System.out.println("Order Itens: ");
		
		for (OrderItem item : order.getShopList()) {
			System.out.println(item.getProduto().getName() + ", Price: R$" 
					+ item.getProduto().getPrice() + ", Qauntity: "
					+ item.getQuantity() + ", subtotal: R$"
					+ item.subTotal());
		}
		
		System.out.println("Total price: R$" + order.total());
	}
}
