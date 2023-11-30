package br.senac.rj.empresa.modelo;

public class Gerente extends Funcionario{

	public Gerente(int registro, String nome, int cargo, double salario) {
		super(registro, nome, cargo, salario);
		}

	@Override
	public void aplicarBonificao() {
		this.setSalario(this.getSalario() + this.getBonificacao()); 
		//super.aplicarBonificao(); //Isso é obrigatório? É possível só fazer o override colocando o mesmo método com a mesma assinatura?
	}

	
	
}
