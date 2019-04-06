import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	private static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private static Scanner s;

	public static void main(String[] args) {
		int op;

		do {
			Menu mainMenu = new Menu("Menu Principal", Arrays.asList("Conta", "Cliente", "Operacoes", "Sair"));
			op = mainMenu.getSelection();

			if (op == 1) {

			} else if (op == 2) {
				cadastrarCliente();
			} else if (op == 3) {
				int resul;
				Menu menuOperacoes = new Menu("Menu Operações", Arrays.asList("Saque", "Depósito", "Transferência"));
				resul = menuOperacoes.getSelection();
				if(resul == 1){
					
				}if(resul == 2){
					
				}if(resul == 3){
					System.out.println("Informe o nome do cliente que deseja transferir:");
					s = new Scanner(System.in);
					String cliente1 = s.nextLine();
					Cliente c1 = clientes.BuscarCliente(cliente1);
					if(c1 == null){
						System.out.println("Cliente não encontrado");
					}
					System.out.println("Informe o número da conta que deseja transferir:");
					s = new Scanner(System.in);
					int conta1 = s.nextInt();
					Conta continha = c1.getConta(conta1);
					if(continha == null){
						System.out.println("Conta não encontrada");
					}
					System.out.println("Informe o nome do cliente que receberá a transferência:");
					s = new Scanner(System.in);
					String cliente2 = s.nextLine();
					Cliente c2 = clientes.BuscarCliente(cliente2);
					if(c1 == null){
						System.out.println("Cliente não encontrado");
					}
					System.out.println("Informe o número da conta que receberá a quantia:");
					s = new Scanner(System.in);
					int conta2 = s.nextInt();
					Conta continha2 = c1.getConta(conta2);
					if(continha == null){
						System.out.println("Conta não encontrada");
					}
					System.out.println("Informe a quantia que deseja transferir:");
					s = new Scanner(System.in);
					float valor = s.nextFloat();
					if(valor < 1){
						System.out.println("Não é possível transferir essa quantia");
					}
					Operacao operarei = new Operacao();
					operarei.transferencia(continha, continha2, valor);
					continha.setOperacoes(operarei);
					continha2.setOperacoes(operarei);
					int ind1;
					int ind2;
					ind1 = BuscaIndice(cliente1);
					ind2 = BuscaIndice(cliente2);
					//agente pode fazer isso em java? acho que sim

					clientes[ind1] = continha;
					clientes[ind2] = continha2;
				}
			}
		} while (op != 4);

		System.out.println("Fim!\n\n");
	}

	public static void cadastrarCliente() {

		System.out.println("\n\nCadastro de cliente ");
		System.out.println("Informe o nome do cliente: ");
		s = new Scanner(System.in);
		String nome = s.nextLine();

		System.out.println("Agencia: ");
		int agencia = s.nextInt();

		Cliente cliente = new Cliente(nome, agencia);
		clientes.add(cliente);
		System.out.println(cliente.getNome() + " foi cadastrado como cliente.\n\n");
	}

	public static ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public static Cliente BuscarCliente (String nomeDoCliente)
	{
		for (Cliente c : clientes)
		{
			if (c.getNome() == nomeDoCliente)
			{
				return c;
			}
		}

		return null;
	}
	
	public static int BuscaIndice(String nomeDoCliente){
		for(i = 0; i < clientes.size(); i++){
			if(nomeDocliente.equals(clintes[i].getNome();)){
				return i;
			}
		}else{
			return -1;
		}
	}
	


	public static Conta BuscarConta (Cliente cliente, int numeroDaConta)
	{
		return cliente.getConta(numeroDaConta);
	}
}
