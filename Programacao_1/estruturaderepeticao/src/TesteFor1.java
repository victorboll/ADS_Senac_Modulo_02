
public class TesteFor1 {

	public static void main(String[] args) {
		for (int x=0; x<=3; x++) {
			System.out.println("x = " + x);
		}
		
		// System.out.println("x = " + x); isso não está certo porque x não existe nesse contexto
		int y;
		for (y=3; y>=0; y--) {
			System.out.println("y = " + y);
		}
		
		System.out.println("o valor funal de y é " + y);

	}

}
