import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		int op;
		do {
			Menu mainMenu = new Menu("Menu Principal", Arrays.asList("Conta", "Cliente", "Operacoes","Sair"));
			op = mainMenu.getSelection();
			System.out.println(op + "foi selecionada");
		} while (op != 0);
	}

}
