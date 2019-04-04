
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





public void deposito(Conta c,float valor){
	c.setSaldo(c.getSaldo()+valor);
}


public void saque(Conta c,float valor){
	if(valor>=c.getSaldo()){
		c.setSaldo(c.getSaldo()-valor);
}
}
}
