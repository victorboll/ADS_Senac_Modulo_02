package br.senac.rj.banco.teste;

import java.util.Scanner;

import br.senac.rj.banco.modelo.Conta;

public class TesteClasse1 {
	public static void main(String[] args) {
		Conta conta1 = new Conta();
		Scanner sc = new Scanner(System.in);
		int op;
		double valor;
		do {
			System.out.println("1 - Consultar");
			System.out.println("2 - Depositar");
			System.out.println("3 - Sacar");
			System.out.println("4 - Encerrar");
			System.out.println("Entre com uma opção: ");
			op = Integer.parseInt(sc.nextLine());
			switch (op) {
			case 1:
				System.out.println("Saldo da conta: " + conta1.getSaldo());
				break;
			case 2:
				System.out.println("Entre com o valor a depositar: ");
				valor = Double.parseDouble(sc.nextLine());
				conta1.deposita(valor);
				break;
			case 3:
				System.out.println("Entre com o valor a sacar: ");
				valor = Double.parseDouble(sc.nextLine());
				if (!conta1.saca(valor))
					System.out.println("Não foi possível efetuar o saque!");
				else
					System.out.println("Saque realizado com sucesso!");
				break;
			case 4:
				System.out.println("Programa encerrado!");
				break;
			default:
				System.out.println("Opção incorreta!");
				break;
			}
		} while (op != 4);
		sc.close();
	}
}
