package br.senac.rj.teste;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TesteClasseLocalDate {

	private static String formatarData(LocalDate data) {
		return data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}
	
	public static void main(String[] args) {
		LocalDate data1, data2, data3;
		data1 = LocalDate.of(2023, 5, 1);
		data2 = LocalDate.now();
		data3 = data2.plusMonths(1);
		System.out.println("data1 = " + formatarData(data1)); //Se não tivesse instanciado a classe como static, você teria que colocar o nome da classe antes de formatarData
		System.out.println("data2 = " + formatarData(data2));
		System.out.println("data3 = " + formatarData(data3));
		if (data1.isEqual(data2))
			System.out.println("data1 é igual a data2");
		else if (data1.isBefore(data2))
			System.out.println("data1 é anterior a data2");
		else
			System.out.println("data1 é posterior a data2");
		
		if (data2.isEqual(data2))
			System.out.println("data2 é igual a data2");
		else if (data2.isBefore(data2))
			System.out.println("data2 é anterior a data2");
		else
			System.out.println("data2 é posterior a data2");
		
		if (data3.isEqual(data2))
			System.out.println("data3 é igual a data2");
		else if (data3.isBefore(data2))
			System.out.println("data3 é anterior a data2");
		else
			System.out.println("data3 é posterior a data2");
	}

}
