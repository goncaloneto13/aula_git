import java.util.ArrayList;

public class Conta {
	
	int num;
	float saldo;
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
	public void setOperacoes(ArrayList<Operacao> operacoes) {
		this.operacoes = operacoes;
	}
	
	public void saque(float valor){
		if(valor<=this.getSaldo() && valor>0){
			Operacao op = new Operacao(1,valor);
			operacoes.add(op);
			this.setSaldo(this.getSaldo()-valor);
	}
	}
	public void deposito(float valor){
		if(valor>0) {
			Operacao op = new Operacao(2,valor);
			operacoes.add(op);
			this.setSaldo(this.getSaldo()+valor);
		
		}
	}


	
}
