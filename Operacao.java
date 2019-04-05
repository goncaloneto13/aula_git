
public class Operacao {

	private int tipo;
	private float valor;

	//saque = 1 
	//deposito = 2
	//tranferencia  = 3
	
	public Operacao(int tipo,float valor) {
		this.tipo = tipo;
		this.valor = valor;
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

	

	
}
