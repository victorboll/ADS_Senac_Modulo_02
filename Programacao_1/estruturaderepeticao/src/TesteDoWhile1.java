
public class TesteDoWhile1 {
	public static void main(String[] args) {
		int a = 2;
		do {
			System.out.println("a = " + a++);
		} while (a <= 4);
		System.out.println("Valor final de a = " + a);
	}
}
