package br.senac.rj.empresa.teste;

import java.util.Scanner;

import br.senac.rj.empresa.modelo.Analista;
import br.senac.rj.empresa.modelo.Funcionario;
import br.senac.rj.empresa.modelo.Gerente;

public class TesteFuncionario1 {

	public static void main(String[] args) {
		Funcionario func1;
		Scanner sc = new Scanner(System.in);
		String resposta, gerente;
		do {
			try {
				System.out.println("Entre com o registro: ");
				int registro = Integer.parseInt(sc.nextLine());
				System.out.println("Entre com o nome: ");
				String nome = sc.nextLine();
				System.out.println("Entre com o cargo: ");
				int cargo = Integer.parseInt(sc.nextLine());
				System.out.println("Entre com o salário: ");
				double salario = Double.parseDouble(sc.nextLine());
				do {
					System.out.println("É gerente (s/n)?");
					gerente = sc.nextLine().trim().toUpperCase();
				} while (!gerente.equals("S")&&!gerente.equals("N"));
				if (gerente.equals("S")) {
					func1 = new Gerente(); // Upcasting
					System.out.println("Bonificação de gerente: ");
					double bonificacao = Double.parseDouble(sc.nextLine());
					((Gerente) func1).setBonificacao(bonificacao); // Downcasting
				} else {
					func1 = new Analista(); // Upcasting
				}
				func1.setRegistro(registro);
				func1.setNome(nome);
				func1.setCargo(cargo);
				func1.setSalario(salario);
				System.out.println("Salário = " + func1.getSalario());
				func1.aplicarBonificacao();
				System.out.println("O novo salário de " + func1.getNome() + " é " + func1.getSalario());
			} catch (NumberFormatException erro) {
				System.out.println("Erro de formatação!");
			} catch (Exception erro) {
				erro.printStackTrace();
			}
			do {
				System.out.println("Deseja continuar (s/n)? ");
				resposta = sc.nextLine().trim().toUpperCase();
			} while (!resposta.equals("S") && !resposta.equals("N"));
		} while (!resposta.equals("N"));
		System.out.println("Volte sempre!");
		sc.close();
	}
}
