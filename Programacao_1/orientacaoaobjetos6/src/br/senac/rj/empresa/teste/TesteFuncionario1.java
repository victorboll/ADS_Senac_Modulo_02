package br.senac.rj.empresa.teste;

import br.senac.rj.empresa.modelo.Funcionario;

public class TesteFuncionario1 {

	public static void main(String[] args) {
		
		Funcionario funcionario1 = new Funcionario(100, "Ted", 2, 2500.50);
		double salarioAntigo = funcionario1.getSalario();
		funcionario1.aplicarBonificao();
		double bonificacao = funcionario1.getSalario() - salarioAntigo;
		System.out.println("Cargo = " + funcionario1.getCargo());
		System.out.println("Nome = " + funcionario1.getNome());
		System.out.println("Registro = " + funcionario1.getRegistro());
		System.out.println("Salario Antigo = " + String.format("%.2f", salarioAntigo));
		System.out.println("Bonificação = " + String.format("%.2f", bonificacao));
		System.out.println("Salario Novo = " + String.format("%.2f", funcionario1.getSalario()));
	}

}
