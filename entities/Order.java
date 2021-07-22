package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import entities.enums.OrderStatus;

public class Order {

	// para que n�o seja necess�rio toda vez instanciar um SDF eu crio uma constante
	// o private static, � para que n�o tenha uma c�pia do objeto sdf para CADA
	// order
	// da minha app. Assim, eu tenho apenas uma c�pia para a app inteira
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private Date moment; 
	private OrderStatus status;

	// Agora aqui v�o entrar as associa��es
	private Client client;

	private List<OrderItem> items = new ArrayList<OrderItem>();

	// Construtores

	public Order() {
	}

	// Na associa��o "tem v�rios" a lista n�o entra no construtor e nem ter� m�todo
	// set, porque
	// vc n�o posso deixar que a classe permita que a lista seja trocada por outra
	// lista.
	// para encapsular e proteger o acesso a lista, n�o mantive o m�todo get
	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
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

	public void addItem(OrderItem item) {
		items.add(item);
	}

	public void removeItem(OrderItem item) {
		items.remove(item);
	}

	// TENTAR CORRIGIR

	public double total() {
		double sum = 0.0;
		for (OrderItem it : items) {
			sum = sum + it.subTotal();
		}
		return sum;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Order moment: ");
		sb.append(sdf.format(moment) + "\n");
		sb.append("Order status: ");
		sb.append(status + "\n");
		sb.append("Client: ");
		sb.append(client + "\n"); // vai trazer o que est� no toString da classe Client, pois chamei para imprimir
									// o objeto da classe
		sb.append("Order items: \n");
		for (OrderItem item : items) { // para cada elemento item da minha lista items fa�a:
			sb.append(item + "\n"); // vai trazer o que est� no toString da classe OrderItem
		}
		sb.append("Total price: $");
		sb.append(String.format("%.2f", total()));
		return sb.toString();
	}

	// System.out.println("x1: " + sdf2.format(x1)); - para formatar e chamar o
	// moment

}
