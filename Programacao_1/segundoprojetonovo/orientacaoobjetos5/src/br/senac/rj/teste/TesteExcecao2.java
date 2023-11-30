package br.senac.rj.teste;

import java.util.Scanner;

public class TesteExcecao2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Entre com um número inteiro: ");
		int num1 = Integer.parseInt(sc.nextLine());
		System.out.println("Entre com um número inteiro: ");
		int num2 = Integer.parseInt(sc.nextLine());
		double num3 = (double) num1 / num2;
		System.out.println("O resultado da divisão de "+num1+" por "+num2+" é "+num3);
		sc.close();

	}

}
