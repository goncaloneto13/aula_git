import java.util.Scanner;

public class MenuOperacao {
	public void selecionaOperacao() {
		System.out.println("Escolha uma opera��o:");
		System.out.println("1 - Saque");
		System.out.println("2 - Deposito");
		System.out.println("3 - transfer�ncia");
		
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		System.out.println(str);
	}

}
