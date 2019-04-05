import java.util.ArrayList;

public class Cliente {
	private String nome;
	private ArrayList<Conta> contas = new ArrayList<Conta>();
	private int agencia;

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Conta getConta(int num) {
		for (int i = 0; i < contas.size(); i++) {
			if (num == contas.get(i).getNum()) {
				Conta c = new Conta();
				return c;
			}
		}
		return null;
	}

	public void setConta(Conta c) {
		this.contas.add(c);
	}

	public int getAgencia() {
		return this.agencia;
	}

	public void setAgencia(int n) {
		this.agencia = n;
	}

	public Cliente(String nome, int a) {
		this.setNome(nome);
		this.setAgencia(a);
	}
}
