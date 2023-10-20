package br.senac.rj.empresa.modelo;

import java.util.Scanner;

public class TesteMaterial1 {

	public static void main(String[] args) {
		Material material1 = new Material();
		Scanner sc = new Scanner(System.in);
		int op;
		int codMaterial;
		String descMaterial;
		int qtyMaterial;
		do {
			System.out.println("\n1 - Cadastrar material");
			System.out.println("2 - Entrada de material");
			System.out.println("3 - Saída de material");
			System.out.println("4 - Consultar saldo em estoque");
			System.out.println("5 - Encerrar");
			System.out.println("Entre com uma opção:");
			op = Integer.parseInt(sc.nextLine());
			switch (op) {
			case 1:
				System.out.println("\nInforme o código do material que está sendo cadastrado");
				codMaterial = Integer.parseInt(sc.nextLine());
				material1.setCodMaterial(codMaterial);
				System.out.println("Informe a descrição do material que está sendo cadastrado");
				descMaterial = sc.nextLine();
				material1.setDescMaterial(descMaterial);
				break;
			case 2:
				System.out.println("\nEntre a quantidade de material que será adicionada ao estoque: ");
				qtyMaterial = Integer.parseInt(sc.nextLine());
				material1.entrarMaterial(qtyMaterial);
				break;
			case 3:
				System.out.println("\nEntre a quantidade de material que será retirada do estoque: ");
				qtyMaterial = Integer.parseInt(sc.nextLine());
				material1.sairMaterial(qtyMaterial);
				break;
			case 4:
				System.out.println("\nPara o material " + material1.getDescMaterial() + " cujo código é " + material1.getCodMaterial() + ", a quantidade de material no estoque é " + material1.getQtdeEstoque());
				break;
			case 5:
				System.out.println("Programa encerrado!");
				break;
			default:
				System.out.println("Opção incorreta!");
				break;
			}
		} while (op != 5);

	}

}
