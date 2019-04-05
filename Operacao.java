
public class Operacao {

	int tipo;
	float valor;

	public void executar() {

	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public void transferencia(Conta c1, Conta c2, float valor) {
		if (valor >= c1.saldo) {
			c1.setSaldo(c1.getSaldo() - valor);
			c2.setSaldo(c2.getSaldo() + valor);
		}

	}

	public void deposito(Conta c, float valor) {
		c.setSaldo(c.getSaldo() + valor);
	}

	public void saque(Conta c, float valor) {
		if (valor >= c.getSaldo()) {
			c.setSaldo(c.getSaldo() - valor);
		}
	}
}
