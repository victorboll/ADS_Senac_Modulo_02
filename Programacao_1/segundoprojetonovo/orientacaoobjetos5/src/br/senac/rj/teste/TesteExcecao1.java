package br.senac.rj.teste;

import java.util.Scanner;

public class TesteExcecao1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Entre com um número inteiro: ");
			int num1 = Integer.parseInt(sc.nextLine());
			System.out.println("Entre com um número inteiro: ");
			int num2 = Integer.parseInt(sc.nextLine());
			double num3 = (double) num1 / num2;
			if (num2 == 0)
				throw new ArithmeticException("Divisão por zero!"); //Aqui você está obrigando a gerar uma exceção se a divisão for por 0
			System.out.println("O resultado da divisão de "+num1+" por "+num2+" é "+num3);
		} catch (ArithmeticException erro) {
			System.out.println("Problema de cálculo");
		} catch (NumberFormatException erro) {
			System.out.println("Problema de conversão!");
		} catch (Exception erro) {
			System.out.println("Classe: "+erro.getClass());
			System.out.println("Nome da classe: " +erro.getClass().getName());
			System.out.println("Apenas mensagem: " +erro.getMessage());
			System.out.println("Mensagem completa: " +erro.toString());
		} finally { //Quando você coloca o finally, mesmo que passe pela exceção, ele passa pelo finally
			System.out.println("Fim do bloco try...catch!");
			sc.close();
		}
	}
}
