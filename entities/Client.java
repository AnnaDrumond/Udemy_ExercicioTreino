package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Client {

	private String name;
	private String email;
	private Date birthDate;

	// para que n�o seja necess�rio toda vez instanciar um SDF eu crio uma constante
	// o private static, � para que n�o tenha uma c�pia do objeto sdf para CADA cliente do meu programa.
	// Assim, eu tenho apenas uma c�pia para a app inteira, instanciando um unico SimpleDateformat para TODOS os clientes.
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Client() {
	}

	public Client(String name, String email, Date birthDate) {
		this.name = name;
		this.email = email;
		this.birthDate = birthDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	// Dentro de Client criar o toString para imprimir os dados do cliente:.

	@Override

	public String toString() {
		return "Client: " + name + " (" + sdf.format(birthDate) + ") - " + email;
	}

}
