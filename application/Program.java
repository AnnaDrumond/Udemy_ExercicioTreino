package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		// Ler os dados de um pedido com N itens (N fornecido pelo usu�rio). Depois,
		// mostrar um
		// sum�rio do pedido conforme exemplo (pr�xima p�gina). Nota: o instante do
		// pedido deve ser
		// o instante do sistema: new Date()
		// corre��o em : https://www.youtube.com/watch?v=gj80JEqk5ms

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Enter cliente data: ");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		// tenho que ler uma var do tipo Date para receber o que o usu�rio digitar no
		// formato String.
		System.out.print("Birth date (DD/MM/YYYY): ");// Para receber uma data neste formato, eu preciso de um
														// SimpleDateFormat.
		Date birthDate = sdf.parse(sc.next());
		// A opera��o .parse, vai receber um dado no formato de string, neste caso a
		// informa��o inserida pelo usu�rio, respeitando a
		// regra imposta quando criei e instanciei a var tipo SimpleDateFormat,
		// convertendo este dado para um tipo Date.

		// J� posso instanciar classe CLient
		Client client = new Client(name, email, birthDate);

		System.out.println("Enter order data: ");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());
		
		//Instanciar o Pedido:
		
		Order order = new Order( new Date (), status, client);
		// o moment �  hora atual, por isso o new Date () 
		// Associei meu pedido/order com o objeto client, e com o objeto status.

		System.out.println("How many items to this order? ");
		int n = sc.nextInt();
		
		for (int i = 1; i <= n; i++) {
			System.out.println("Enter #" + i + " item data:");
			System.out.print("Product name: ");
			sc.nextLine(); // para consumir a quebra de linha que ficou pendente, depois de declarar o n.
			String productName = sc.nextLine();
			System.out.print("Product price: ");
			double productPrice = sc.nextDouble();
			System.out.print("Quantity: ");
			int productQuantity = sc.nextInt();
			
			// PASSO 01 - instanciar o produto:		
			Product product = new Product(productName, productPrice);
			
			//PASSO 02 - associar o item de pedido associado a ESTE produto:
			OrderItem it = new OrderItem(productQuantity, productPrice, product); 
			// este �ltimo parametro � o product que acabamos de instanciar acima e assim eu associei ESTE product com o item do pedido.
			// Foi criado na mem�ria um objeto OrderItem associado a um product.
			
			//PASSO 03 - 
			// Adicionar este OrderItem dentro da minha lista do meu pedido:
			order.addItem(it);
	}
		sc.close();
		System.out.println("ORDER SUMMARY: ");
		System.out.println(order); 
		// chamo apenas o order pois dentro dele tem o toString/StringBuilder que chama todas as demais informa��es

	}

}
