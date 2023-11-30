package br.senac.rj.empresa.teste;

import java.util.Scanner;

import br.senac.rj.empresa.modelo.Funcionario;

public class TesteFuncionario1 {

	public static void main(String[] args) {
		Funcionario func1 = new Funcionario();
		Scanner sc = new Scanner(System.in);
		String resposta;
		do {
			System.out.println("Entre com o registro: ");
			int registro = Integer.parseInt(sc.nextLine());
			func1.setRegistro(registro);
			System.out.println("Entre com o nome: ");
			String nome = sc.nextLine();
			func1.setNome(nome);
			System.out.println("Entre com o cargo: ");
			int cargo = Integer.parseInt(sc.nextLine());
			func1.setCargo(cargo);
			System.out.println("Entre com o salário: ");
			double salario = Double.parseDouble(sc.nextLine());
			func1.setSalario(salario);
			System.out.println("Salário = " + func1.getSalario());
			func1.aplicarBonificacao();
			System.out.println("O novo salário de " + func1.getNome() + " é " + func1.getSalario());
			do {
				System.out.println("Deseja continuar (s/n)? ");
				resposta = sc.nextLine().trim().toUpperCase();
				if (!resposta.equals("S") && !resposta.equals("N"))
					System.out.println("Opção incorreta!");
			} while (!resposta.equals("S") && !resposta.equals("N"));
		} while (!resposta.equals("N"));
		System.out.println("Volte sempre!");
		sc.close();
	}
}
