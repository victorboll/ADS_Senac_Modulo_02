package br.senac.rj.banco.modelo;

public class Conta {
	private int agencia;
	private int numero;
	private double saldo;
	
	
	private int getAgencia() {
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
	
	// digita o nome do método seguido de ctrl + barra de espaço
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
