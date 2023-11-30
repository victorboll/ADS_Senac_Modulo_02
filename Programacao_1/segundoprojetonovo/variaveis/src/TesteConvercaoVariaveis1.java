
public class TesteConvercaoVariaveis1 {

	public static void main(String[] args) {
		// Conversão implícita de tipo
		int a = 5;
		float b = 10.5f; //Precisa colocar f para dizer que é float, se não botar, ele vai achar que é double
		b = a;
		//Conversão explícita de tipo
		int c = (int) b; // Exemplo de Cast
		int d;
		double e = 1.7976931348623157 * Math.pow(10, 308);
		d = (int) e; //O valor que d vai assumir, vai ser 2147483647, que é o máximo que ele consegue guardar
		System.out.println("a="+ a);
		System.out.println("b="+ b);
		System.out.println("c="+ c);
		System.out.println("e="+ e);
		System.out.println("d="+ d);
		
	}

}
