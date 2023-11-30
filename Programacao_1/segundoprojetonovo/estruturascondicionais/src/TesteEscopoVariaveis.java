
public class TesteEscopoVariaveis {

	public static void main(String[] args) {
		int a = 1;
		if (a == 1) {
			int b = 1;
			b++;
		}
		System.out.println("b = " + a); //se tivesse colocado b teria dado erro, porque ele só existe no contexto do if

	}

}
