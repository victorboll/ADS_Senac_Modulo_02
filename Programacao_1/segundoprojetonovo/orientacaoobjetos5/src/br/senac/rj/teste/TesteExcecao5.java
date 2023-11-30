package br.senac.rj.teste;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class TesteExcecao5 {

	public static void main(String[] args) {
		try {
			FileReader file = new FileReader("c:\teste.txt");
			file.close();
		} catch (FileNotFoundException erro) {
			System.out.println("Erro ao abrir o arquivo");
			erro.printStackTrace(); //imprime o erro que daria para unchecked exemption
		} catch (Exception erro) {
			System.out.println("Erro não identificado!");
			erro.printStackTrace();
		}
	}

}
