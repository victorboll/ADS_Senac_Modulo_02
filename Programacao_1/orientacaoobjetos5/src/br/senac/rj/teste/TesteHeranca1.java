package br.senac.rj.teste;

import java.util.Scanner;

public class TesteHeranca1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Entre com o limite da conta corrente especial: ");
		double limite = Double.parseDouble(sc.nextLine());
		System.out.println("Entre com o valor a sacar: ");
		double valorSaque = Double.parseDouble(sc.nextLine());
		ContaCorrenteEspecial cce1 = new ContaCorrenteEspecial(22, 245);
		System.out.println("Número da agência e conta corrente especial: "+cce1.getAgencia());
		System.out.println("Número da conta corrente especial: " + cce1.getNumero());
		System.out.println("Titular da conta corrente especial: " + cce1.getTitular());
		cce1.setLimite(limite);
		if (!cce1.saca(valorSaque, 10))
			System.out.println("Não foi possível efetuar saque na conta corente especial");
		else
			System.out.println("Novo saldo da conta corrente especial: " + cce1.getSaldo());
		ContaCorrenteNormal ccn1 = new ContaCorrenteNormal();
		System.out.println("Número da agência e conta corrente especial: "+ccn1.getAgencia());
		System.out.println("Número da conta corrente especial: " + ccn1.getNumero());
		System.out.println("Titular da conta corrente especial: " + ccn1.getTitular());
		if (!ccn1.saca(valorSaque))
			System.out.println("Não foi possível efetuar saque na conta corrente normal");
		else
			System.out.println("Novo saldo da conta corrente normal: " + ccn1.getSaldo());
		sc.close();

	}

}
