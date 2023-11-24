package br.senac.rj.teste;

public class ContaCorrenteNormal extends Conta3 {
	
	public boolean saca (double valor) {
		double novoSaldo = this.saldo - valor;
		if (novoSaldo < 0) 
			return false;
		this.saldo = novoSaldo;
		return true;
	}
	
}
