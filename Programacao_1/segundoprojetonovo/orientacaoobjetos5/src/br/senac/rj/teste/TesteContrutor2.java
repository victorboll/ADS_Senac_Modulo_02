package br.senac.rj.teste;

public class TesteContrutor2 {

	public static void main(String[] args) {
		Conta conta2 = new Conta();
		String texto = null; //Se você não inicializar, ele não inicializa automaticamente
		System.out.println("Titular = " + conta2.getTitular()); // Ele inicializa automaticamente quando o objeto é inicializado, sem precisar de um valor
		System.out.println(texto);
		
		Conta conta1 = new Conta(33, 101);
		System.out.println("Novo titular = " + conta1.getTitular()); //Aqui é possível ver que ele não usou o construtor padrão, mas sim o construtor com a assinatura. 
		//Para usar os dois, um construtor teria que chamar o outro
		System.out.println("Agência = " + conta1.getAgencia());
		System.out.println("Número da conta = " + conta1.getNumero());
		
	}

}
