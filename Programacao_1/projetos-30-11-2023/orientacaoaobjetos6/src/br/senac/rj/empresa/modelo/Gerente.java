package br.senac.rj.empresa.modelo;

public class Gerente extends Funcionario {

	private double bonificacao;

	public double getBonificacao() {
		return bonificacao;
	}

	public void setBonificacao(double bonificacao) {
		this.bonificacao = bonificacao;
	}

	@Override
	public void aplicarBonificacao() {
		this.salario = this.salario + this.getBonificacao();
	}

}
