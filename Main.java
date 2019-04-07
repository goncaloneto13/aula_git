import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	private static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private static Scanner s;
	private static int numContas = 0;

	public static void main(String[] args) {
		int op;

		do {
			Menu mainMenu = new Menu("Menu Principal", Arrays.asList("Conta", "Cliente", "Operacoes", "Sair"));
			op = mainMenu.getSelection();

			if (op == 1) {
				MenuConta();
			} else if (op == 2) {
				cadastrarCliente();
			} else if (op == 3) {
				menuOperacoes();
			}
		}while(op != 4);

		System.out.println("Fim!\n\n");
	}
	
	public static void menuOperacoes() {
		int resul;
		Menu menuOperacoes = new Menu("Menu Operações", Arrays.asList("Saque", "Depósito", "Transferência"));
		resul = menuOperacoes.getSelection();

		if(resul == 1){
			
			saqDep(1,"Saque");
			
			
		}if(resul == 2){
			
			saqDep(2,"Deposito");
			
			
		}if(resul == 3){
			realizaTransferencia();
		}
	}
	public static void saqDep(int tipo,String nome) {
		Scanner s = new Scanner(System.in);
		System.out.println("\n\nOperacao de "+nome);
		System.out.println("Informe o nome do Cliente:");
		String cliente = s.nextLine();
		Cliente c = BuscarCliente(cliente);
		if(c == null){
			System.out.println("Cliente n�o encontrado");
			return;
		}
		System.out.println("informe o numero da conta");
		int conta = s.nextInt();
		Conta x = BuscarConta(c,conta);
		if(x == null){
			System.out.println("Conta nao encontrada");
			return;
		}
		
		System.out.println("Informe o valor do "+nome);
		float valor = s.nextFloat();
		if(tipo==1) {
		if(valor>x.getSaldo()) {
			System.out.println(x.getSaldo());
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
		System.out.println(x.getSaldo());
	}
	
	public static Conta pegaConta(Cliente c1){
		s = new Scanner(System.in);
		int conta1 = s.nextInt();
		Conta continha = BuscarConta(c1, conta1);
		if(continha == null){
			System.out.println("Conta não encontrada");
			return null;
		}
		return continha;
	}
	
public static Cliente pegaCliente(){
		
		s = new Scanner(System.in);
		String cliente1 = s.nextLine();
		Cliente c1 = BuscarCliente(cliente1);
		if(c1 == null){
			System.out.println("Cliente não encontrado");
			return null;
		}
		return c1;
	}

public static void realizaTransferencia(){
	System.out.println("Transferência");
	System.out.println("Informe o nome do cliente que deseja transferir:");
	Cliente c1 = pegaCliente();
	if(c1 == null)
		return;
	System.out.println("Informe o número da conta que deseja transferir:");
	Conta continha = pegaConta(c1);
	if(continha == null)
		return;
	System.out.println("Informe o nome do cliente que receberá a transferência:");
	Cliente c2 = pegaCliente();
	if(c2 == null)
		return;
	System.out.println("Informe o número da conta que receberá a quantia:");
	Conta continha2 = pegaConta(c2);
	if(continha2 == null)
		return;
	if(continha.equals(continha2)){
		System.out.println("Não é possível transferência entre uma única conta");
		return;
	}
	System.out.println("Informe a quantia que deseja transferir:");
	s = new Scanner(System.in);
	float valor = s.nextFloat();
	if(valor < 1){
		System.out.println("Não é possível transferir essa quantia");
		return;
	}
	continha.transferencia(continha,continha2,valor);
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

	public static Cliente BuscarCliente(String nomeDoCliente) {
		for (Cliente c : clientes) {
			if (c.getNome().equals(nomeDoCliente)) {
				return c;
			}
		}

		return null;
	}

	public static Conta BuscarConta(Cliente cliente, int numeroDaConta) {
		return cliente.getConta(numeroDaConta);
	}

	public static void MenuConta() {
		System.out.println("\n\n Menu de Conta");
		System.out.println("Nome do Cliente: ");

		s = new Scanner(System.in);
		String nomeDoCliente = s.nextLine();
		Cliente cliente = BuscarCliente(nomeDoCliente);

		if (cliente != null) {
			System.out.println("1. Criar nova conta.");
			System.out.println("2. Buscar Conta.");
			s = new Scanner(System.in);

			switch (s.nextInt()) {
			case 1:
				int num = CriarConta(cliente);
				System.out.println("Conta criada com sucesso!\nNumero da conta: " + num);
				break;
			case 2:
				System.out.println("\nDigite o nÃºmero da conta: ");
				s = new Scanner(System.in);

				Conta conta = BuscarConta(cliente, s.nextInt());

				if (conta != null) {
					System.out.println("\nSaldo: " + conta.getSaldo());
					System.out.println("\nOperaÃ§Ãµes: " + conta.getOperacoes().toString());
				} else
					System.out.println("Conta nÃ£o encontrada!");
				break;
			default:
				System.out.println("OpÃ§Ã£o nÃ£o consta no menu.");
				break;
			}
		} else {
			System.out.println("Cliente nÃ£o encontrado!");
		}
	}

	public static int CriarConta(Cliente cliente) {
		Conta conta = new Conta();

		numContas++;

		conta.setNum(numContas);
		cliente.setConta(conta);
		return numContas;
	}
}
