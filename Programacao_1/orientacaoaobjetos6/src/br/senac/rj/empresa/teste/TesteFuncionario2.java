package br.senac.rj.empresa.teste;

import br.senac.rj.empresa.modelo.Analista;
import br.senac.rj.empresa.modelo.Funcionario;
import br.senac.rj.empresa.modelo.Gerente;

import java.util.Scanner;

public class TesteFuncionario2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Entre com o Registro do funcionário: ");
		int registro = Integer.parseInt(sc.nextLine());
		System.out.println("Entre com o Nome do funcionário: ");
		String nome = sc.nextLine();
		System.out.println("Entre com o Cargo do funcionário: ");
		int cargo = Integer.parseInt(sc.nextLine());
		System.out.println("Entre com o Salario do funcionário: ");
		double salario = Double.parseDouble(sc.nextLine());
		System.out.println("O funcionário é gerente? Escreve 's' para sim, ou 'n' para não: ");
		String posicao = sc.nextLine();
		
		Funcionario funcionario1;
		
		if (posicao.equals("s")) {
			funcionario1 = new Gerente(registro, nome, cargo, salario);
			System.out.println("Entre com a Bonificação do funcionário: ");
			funcionario1.setBonificacao(Double.parseDouble(sc.nextLine()));
		}
		
		else {
			funcionario1 = new Analista(registro, nome, cargo, salario);
		}
		
		double salarioAntigo = funcionario1.getSalario();
		funcionario1.aplicarBonificao();
		double bonificacao = funcionario1.getSalario() - salarioAntigo;
		System.out.println("Cargo = " + funcionario1.getCargo());
		System.out.println("Nome = " + funcionario1.getNome());
		System.out.println("Registro = " + funcionario1.getRegistro());
		System.out.println("Salario Antigo = " + String.format("%.2f", salarioAntigo));
		System.out.println("Bonificação = " + String.format("%.2f", bonificacao));
		System.out.println("Salario Novo = " + String.format("%.2f", funcionario1.getSalario()));
		sc.close();
	}

}
