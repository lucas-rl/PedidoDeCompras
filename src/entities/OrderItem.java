package entities;

public class OrderItem {
	//Attributes
	private Integer quantity;
	private Product produto;
	
	//Constructors
	public OrderItem(Integer quantity, Product produto) {
		super();
		this.quantity = quantity;
		this.produto = produto;
	}
	
	//Getters
	public Integer getQuantity() {
		return quantity;
	}
	
	public Product getProduto() {
		return produto;
	}

	//Methods
	public double subTotal() {
		return quantity * produto.getPrice();
	}

}
