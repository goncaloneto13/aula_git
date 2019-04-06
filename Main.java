import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	private static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	
	public static void main(String[] args) {
		int op;
		 Scanner s = new Scanner(System.in);
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
					
					saqDep(1,"Saque");
					
					
				}if(resul == 2){
					
					saqDep(2,"Deposito");
					
					
				}if(resul == 3){
					System.out.println("Informe o nome do cliente que deseja transferir:");
					
					String cliente1 = s.nextLine();
					Cliente c1 = BuscarCliente(cliente1);
					if(c1 == null){
						System.out.println("Cliente não encontrado"); break;
					}
					System.out.println("Informe o número da conta que deseja transferir:");
				
					int conta1 = s.nextInt();
					Conta continha = BuscarConta(c1,conta1);
					if(continha == null){
						System.out.println("Conta não encontrada"); break;
					}
					System.out.println("Informe o nome do cliente que receberá a transferência:");
				
					String cliente2 = s.nextLine();
					Cliente c2 = BuscarCliente(cliente2);
					if(c2 == null){
						System.out.println("Cliente não encontrado");
						break;
					}
					System.out.println("Informe o número da conta que receberá a quantia:");
					
					int conta2 = s.nextInt();
					Conta continha2 = BuscarConta(c2,conta2);
					if(continha2 == null){
						System.out.println("Conta não encontrada"); break;
					}
					System.out.println("Informe a quantia que deseja transferir:");
					
					float valor = s.nextFloat();
					if(valor <= 0 ){
						System.out.println("Não é possível transferir essa quantia"); break;
					}
					continha.transferencia(continha,continha2,valor);

				}
			}
		} while (op != 4);

		System.out.println("Fim!\n\n");
	}
	
	
	public static void saqDep(int tipo,String nome) {
		Scanner s = new Scanner(System.in);
		System.out.println("\n\nOperacao de "+nome);
		System.out.println("Informe o nome do Cliente:");
		String cliente = s.nextLine();
		Cliente c = BuscarCliente(cliente);
		if(c == null){
			System.out.println("Cliente não encontrado");
			return;
		}
		System.out.println("informe o numero da conta");
		int conta = s.nextInt();
		Conta x = BuscarConta(c,conta);
		if(x == null){
			System.out.println("Conta não encontrada");
			return;
		}
		
		System.out.println("Informe o valor do "+nome);
		float valor = s.nextFloat();
		if(tipo==1) {
		if(valor>x.getSaldo()) {
			System.out.println("saldo insuficiente"); 
			return;
		}else {
			x.saque(valor);
			}
		}
		if(tipo==2) {
			if(valor<=0) {
				System.out.println("valor invalido");
				return;
			}else {
				x.deposito(valor);
				}
		}
		System.out.println(nome+" realizado com sucesso!");
	}

	public static void cadastrarCliente() {

		System.out.println("\n\nCadastro de cliente ");
		System.out.println("Informe o nome do cliente: ");
		Scanner x = new Scanner(System.in);
		String nome = x.nextLine();

		System.out.println("Agencia: ");
		int agencia = x.nextInt();

		Cliente cliente = new Cliente(nome, agencia);
		clientes.add(cliente);
		System.out.println(cliente.getNome() + " foi cadastrado como cliente.\n\n");
	}

	public static ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public static Cliente BuscarCliente (String nomeDoCliente)
	{
		for (Cliente c : clientes){
			if (c.getNome().contentEquals(nomeDoCliente)){
				return c;
			}
		}

		return null;
	}

	public static Conta BuscarConta (Cliente cliente, int numeroDaConta)
	{
		return cliente.getConta(numeroDaConta);
	}
}
