package br.senac.rj.teste;

import java.util.Arrays;

public class TesteArray2 {

	public static void main(String[] args) {
		int i = 0;
		for (String valor : args ) {
			System.out.println("args["+i+"] = " + valor);
			i++;
		}
		System.out.println("args = " + Arrays.toString(args));

	}

}
