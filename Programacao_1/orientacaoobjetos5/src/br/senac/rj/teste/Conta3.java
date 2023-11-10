package br.senac.rj.teste;

public class Conta3 {
	private int agencia;
	private int numero;
	protected double saldo;
	private String titular;
	
	Conta3(){ 
		this.titular = "";
	}
	
	Conta3(int agencia, int numero) {
		this();
		this.agencia = agencia;
		this.numero = numero;
	}
	
	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public void deposita(double valor) {
		this.saldo = this.saldo + valor;
	}
	
	public boolean saca (double valor) {
		double novoSaldo = this.saldo - valor;
		if (novoSaldo < 0) 
			return false;
		this.saldo = novoSaldo;
		return true;
	}
}
