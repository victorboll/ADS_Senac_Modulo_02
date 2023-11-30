package br.senac.rj.teste;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class desafio {

private static String formatarData(LocalDate data) {
return data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
}

public static String verificarIntersecao(LocalDate A, LocalDate B, LocalDate C, LocalDate D) {
return (B.isBefore(C) || D.isBefore(A)) ? "Não tem" : "Tem";
}

public static void main(String[] args) {

LocalDate A, B, C, D, E, F, G;
A = LocalDate.of(2023, 01, 01);
B = LocalDate.of(2023, 02, 02);

C = LocalDate.of(2023, 03, 03);
G = LocalDate.of(2023, 03, 30);
D = LocalDate.of(2023, 04, 04);

E = LocalDate.of(2023, 05, 05);
F = LocalDate.of(2023, 06, 06);


System.out.println("Tem que dar: " + verificarIntersecao(A, C, B, D));
System.out.println("Tem que dar: " + verificarIntersecao(C, E, B, D));
System.out.println("Tem que dar: " + verificarIntersecao(B, D, C, G));
System.out.println("Tem que dar: " + verificarIntersecao(A, E, B, D));
System.out.println("Não pode dar: " + verificarIntersecao(A, B, C, D));
System.out.println("Não pode dar: " + verificarIntersecao(C, D, E, F));

}
}


