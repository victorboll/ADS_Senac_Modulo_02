package br.senac.rj.teste;

import java.text.DecimalFormat;

public class TesteClasseDecimalFormat {

	public static void main(String[] args) {
		String numeroFormatado = new DecimalFormat("#,##0.00").format(3002500.50);
		System.out.println(numeroFormatado);

	}

}
