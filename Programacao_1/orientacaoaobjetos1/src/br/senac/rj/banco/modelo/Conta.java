package br.senac.rj.banco.modelo;

public class Conta {
	public int agencia;
	public int numero;
	public double saldo;
	
	// digita o nome do método seguido de ctrl + barra de espaço
	public void deposita(double valor) {
		saldo = saldo + valor;
	}
	
	public boolean saca (double valor) {
		double novoSaldo = saldo - valor;
		if (novoSaldo < 0)
			return false;
		saldo = novoSaldo;
		return true;	
	}
		
}
