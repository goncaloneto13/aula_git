import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Menu mainMenu =  new Menu("Menu Principal", Arrays.asList("Conta", "Cliente", "Operacoes"));
		if(mainMenu.getSelection() == 3){
			MenuOperacao m = new MenuOperacao();
			m.selecionaOperacao();
		}
	}

}
