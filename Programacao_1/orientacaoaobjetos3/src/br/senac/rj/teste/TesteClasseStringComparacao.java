package br.senac.rj.teste;

public class TesteClasseStringComparacao {
	public static void main(String[] args) {
		String a, b, c, d;
		a = "Ricardo"; // compartilhará o mesmo endereço de memória da variável "a", porque vai estar no pool string
		b = "Ricardo"; // não compartilhará o mesmo endereço de memória, apesar de estar dentro do pool string
		c = " Ricardo"; // não compartilhará o mesmo endereço de memória, porque o ponteiro vai estar apontando para outro endereço de memória que vai apontar para o mesmo endereço de memória que "a" e "b" estão apontando no pool string
		d = c.substring(1, 8);
		String e = new String();
		e = "Ricardo";
		System.out.println("e = " + e);
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		System.out.println("c = " + c);
		System.out.println("d = " + d);
		System.out.println("a == b ->  " + (a==b));
		System.out.println("a == c ->  " + (a==c));
		System.out.println("a == d ->  " + (a==d));
		System.out.println("a == d.intern() -> " + (a==d.intern()));
		System.out.println("a.equals(b) = " + a.equals(b));
		System.out.println("a.equals(c) = " + a.equals(c));
		System.out.println("a.equals(d) = " + a.equals(d));
	}
}
