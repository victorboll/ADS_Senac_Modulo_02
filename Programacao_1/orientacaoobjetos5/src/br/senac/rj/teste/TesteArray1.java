package br.senac.rj.teste;

import java.util.Arrays;

public class TesteArray1 {
	public static void main(String[] args) {
		int[] meuArray1 = new int[4];
		meuArray1[0] = 10;
		meuArray1[1] = 20;
		meuArray1[2] = 30;
		meuArray1[3] = 40;
		System.out.println("Tamanho do meuArray1 = " + meuArray1.length);
		for (int i=0; i < meuArray1.length; i++){
			System.out.println("meuArray["+i+"]= " + meuArray1[i]);
		}
		System.out.println("meuArray1 = " + Arrays.toString(meuArray1));
		
		
		int[] meuArray2 = {10,20,30,40};
		System.out.println("Tamanho do meu Array2 = " + meuArray2.length);
		int i=0;
		for (int valor : meuArray2){
			System.out.println("meuArray2["+i+"] = " + valor);
			i++;
		}
		System.out.println("meuArray2 = " + Arrays.toString(meuArray2));
		
		
		int[][] meuArray3 = new int[3][2];
		System.out.println("Número de colunas do meuArray3 = " + meuArray3[0].length);
	}
}
