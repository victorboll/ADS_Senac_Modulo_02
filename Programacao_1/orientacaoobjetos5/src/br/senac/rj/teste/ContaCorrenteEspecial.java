package br.senac.rj.teste;

public class ContaCorrenteEspecial extends Conta3 {
	private double limite;

	public ContaCorrenteEspecial(int numAgencia, int numConta) {
		super(numAgencia, numConta);
	}

	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}

	@Override
	public boolean saca(double valor) {
		double novoSaldo = this.saldo - valor;
		if (novoSaldo < this.limite*-1){
			System.out.println("Não há limite disponível");
			return false;
		}
		this.saldo = novoSaldo;
		return true;
	}
	
	public boolean saca(double valor, int imposto) {
		double novoValorSaque = valor + (valor*imposto/100);
		System.out.println("Imposto " + imposto);
		System.out.println("Novo valor a sacar: " + novoValorSaque);
		if (!this.saca(novoValorSaque))
			return false;
		return true;
	}
	
}
