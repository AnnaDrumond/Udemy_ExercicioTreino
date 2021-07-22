package entities;

public class OrderItem {

	private Integer quantity;
	private Double price;

	// Associação com a classe Product

	private Product product;
	
	// Se quero dar ao programador a hipótese de  instanciar COM e SEM argumento seria boa prática por os dois construtores.
	public OrderItem() {
	}

	public OrderItem(Integer quantity, Double price, Product product) {
		this.quantity = quantity;
		this.price = price;
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public double subTotal() {
		return price * quantity;
	}
	
	// Dentro de OrderItem criar o toString para imprimir os dados do pedido - Order items:.
	
	@Override
	
	public String toString() {
		return getProduct().getName() // Fui até o classe Product e acedi o nome do produto.
				+  ", $"
				+ String.format("%.2f", price) // formatar para ter duas casas decimais
				+ ", Quantity: "
				+ quantity
				+ ", Subtotal: $"
				+ String.format("%.2f", subTotal());		
	}	
}
