package br.senac.rj.teste;

public class TesteContrutor1 {

	public static void main(String[] args) {
		Conta2 conta1 = new Conta2();
		String texto = null; //Se você não inicializar, ele não inicializa automaticamente
		System.out.println("Titular = " + conta1.getTitular()); // Ele inicializa automaticamente quando o objeto é inicializado, sem precisar de um valor
		System.out.println(texto);
	}

}
