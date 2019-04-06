import java.util.ArrayList;

public class Conta {
	
	private int num;
	private float saldo=0;
	ArrayList<Operacao> operacoes = new ArrayList<>();
	
	public Conta() {
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public float getSaldo() {
		return saldo;
	}
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	public ArrayList<Operacao> getOperacoes() {
		return operacoes;
	}
	
	public void setOperacoes(Operacao op) {
		this.operacoes.add(op);
	}
	
	public void saque(float valor){
		if(valor<=this.getSaldo() && valor>0){
			this.setSaldo(this.getSaldo()-valor);
			setOperacoes(new Operacao(1,valor));
	}
	}
	public void deposito(float valor){
		if(valor>0) {
			this.setSaldo(this.getSaldo()+valor);
			setOperacoes(new Operacao(2,valor));
			
		}
	}

	public void transferencia(Conta c1, Conta c2, float valor) {
		if (valor <= c1.saldo) {
			c1.setSaldo(c1.getSaldo() - valor);
			c2.setSaldo(c2.getSaldo() + valor);
			Operacao op = new Operacao(3,valor);
			operacoes.add(op);
			System.out.println("Transferência completa");
		}
		System.out.println("Saldo insuficiente");
		

	}
	
	
	
	
	
}
