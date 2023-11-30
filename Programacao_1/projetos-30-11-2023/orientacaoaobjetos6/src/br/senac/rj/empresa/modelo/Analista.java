package br.senac.rj.empresa.modelo;

public class Analista extends Funcionario {

	@Override
	public void aplicarBonificacao() {
		double bonificacao;
		if (this.getCargo()==1) 
			bonificacao = this.salario * 0.2;
		else if (this.getCargo()==2)
			bonificacao = this.salario * 0.4;
		else if (this.getCargo()==3)
			bonificacao = this.salario * 0.6;
		else
			bonificacao = 0;
		System.out.println("Bonificação = " + bonificacao);
		this.salario = this.salario + bonificacao;
	}

}
