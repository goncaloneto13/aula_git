
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
	private String title;
	private List<String> options;
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private Scanner s;
	private Scanner s2;

	public Menu(List<String> options) {
		this.title = "Menu";
		this.options = options;
	}

	public Menu(String title, List<String> options) {
		this.title = title;
		this.options = options;
	}

	public int getSelection() {
		int op = 0;
		while (op == 0) {
			System.out.println(title + "\n");
			int i = 1;
			for (String option : options) {
				System.out.println(i++ + " - " + option);
			}

			System.out.println("Informe a opcao desejada. ");
			s2 = new Scanner(System.in);

			String str = s2.nextLine();

			try {
				op = Integer.parseInt(str);
			} catch (NumberFormatException e) {
				op = 0;
			}
			if (op >= i) {
				System.out.println("Opcao errada!");
				op = 0;
			}

			if (op == 2) {
				for (Cliente c: clientes) {
					System.out.println(c.getNome());
				}
				cadastrarCliente();
				
			}

		}
		return op;
	}

	public void cadastrarCliente() {
		
		s = new Scanner(System.in);
		System.out.println("Cadastro de cliente ");
		System.out.println("Informe o nome do cliente: ");
		String nome = s.nextLine();
		
		System.out.println("Agencia: ");
		int agencia = s.nextInt();
		
		Cliente cliente = new Cliente(nome,agencia);
		clientes.add(cliente);
		System.out.println("Cliente criado");
	}
}
