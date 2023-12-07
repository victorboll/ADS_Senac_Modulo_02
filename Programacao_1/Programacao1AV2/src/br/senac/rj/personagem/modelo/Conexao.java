/* JDBC -> Java Database Connectivity -> É uma API
 * Colocar arquivo JAR do Driver do banco (.zip) no caminho de compilação do projeto (Mesmo level da
 * pasta src), depois selecionar o arquivo com botão direito -> Add to build path
 * MySQL -> Platform Independent -> arquivo zip: mysql.connector
 * 
 * XAMPP -> instalar programa, depois inicinar (Start) MySQL seguido de Apache
 * Selecionar "Admin" do mySQL para editar o banco 
 */

package br.senac.rj.personagem.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	public static Connection conectaBanco() {
	//Declaração de um método estático, que retorna um objeto do tipo Connection
		Connection conexao = null;
		//O objeto conexao começa como null. Se o Try tiver sucesso ele recebe uma conexão
		//Caso caia em alguma exceção, ele permanecesse como null
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			//Aponta para o Driver instalado com o nome do Driver MySQL como parâmetro
			
			
			String url = "jdbc:mysql://localhost/personagem"; 
			// URL do banco de dados, que nesse caso está sendo rodado localmente
			String user = "root"; 
			// nome do usuário do banco, para o MySQL o root é padrão
			String password = ""; 
			// senha do banco, que para o que foi criado é vazia
			conexao = DriverManager.getConnection(url, user, password);
			//Método da classe DriverManager que efetivamente se conecta ao banco para
			//que possam ser utilizados comandos de leitura e gravação. Esse método retorna
			//um objeto do tipo Connection
			
			
		} catch (ClassNotFoundException erro) {
			System.out.println("Driver não encontrado: " + erro);
			//Essa exception é para o Class.forName
		} catch (SQLException erro) {
			System.out.println("Erro de conexão ao banco de dados: " + erro.toString());
			//Essa exception é para o DriverManager.getConnection
		} catch (Exception erro) {
			System.out.println("Erro não identificado: " + erro.toString());
			//Exception genérica
		} 
		return conexao;
		//Retorna objeto conexao do tipo Connection que permitirá a leitura e gravação do banco
		
		
	}
	public static void fechaConexao(Connection conexao) {
	//Método que fecha explicitamente um objeto Connection
		try {
			conexao.close();
		} catch (Exception erro) {
			System.out.println("Erro ao fechar a conexão: " + erro.toString());
			//tratamento de exception genérica
		}
	}
}