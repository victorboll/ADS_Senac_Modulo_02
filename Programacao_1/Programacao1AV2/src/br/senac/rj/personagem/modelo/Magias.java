package br.senac.rj.personagem.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Magias {
	private int id_magia;
	private int id_personagem;
	private String nome_magia;
	private String tipo_magia;
	private int nivel_magia;
	private String escola_magia;
	
	public Magias() {
		// TODO Auto-generated constructor stub
	}
	
	public int getId_magia() {
		return id_magia;
	}

	public void setId_magia(int id_magia) {
		this.id_magia = id_magia;
	}

	public int getId_personagem() {
		return id_personagem;
	}

	public void setId_personagem(int id_personagem) {
		this.id_personagem = id_personagem;
	}

	public String getNome_magia() {
		return nome_magia;
	}

	public void setNome_magia(String nome_magia) {
		this.nome_magia = nome_magia;
	}

	public String getTipo_magia() {
		return tipo_magia;
	}

	public void setTipo_magia(String tipo_magia) {
		this.tipo_magia = tipo_magia;
	}

	public int getNivel_magia() {
		return nivel_magia;
	}

	public void setNivel_magia(int nivel_magia) {
		this.nivel_magia = nivel_magia;
	}

	public String getEscola_magia() {
		return escola_magia;
	}

	public void setEscola_magia(String escola_magia) {
		this.escola_magia = escola_magia;
	}

	public boolean cadastrarMagia(int id_magia, int id_personagem, String nome_magia, String tipo_magia, int nivel_magia, String escola_magia) {
		
		Connection conexao = null;
		//cria um objeto conexao para aplicar o metodo conectaBanco() que está na classe conexao
		
		try {
			conexao = Conexao.conectaBanco();
			//Abre uma conexão com o banco como definido na classe Conexao
						
			String sql = "INSERT INTO magias SET id_magia=?, id_personagem=?, nome_magia=?, tipo_magia=?, nivel_magia=?, escola_magia=?;";
			//Monta a consulta de inserção na tabela Usuario com placeholders
			//que serão substituidos por métodos da classe PreparedStatements
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			//Cria-se um objeto PreparedStatement para podermos utilizar os métodos da classe
			
			ps.setInt(1,  id_magia);
			ps.setInt(2,  id_personagem);
			ps.setString(3,  nome_magia);
			ps.setString(4,  tipo_magia);
			ps.setInt(5,  nivel_magia);
			ps.setString(6, escola_magia);
			//Chamasse o parâmetro setString para colocar no statement feito anteriormente os
			//parâmetros no lugar dos placeholders, pré-compilando o statement que será realizado
			
			int totalRegistrosAfetados = ps.executeUpdate();
			//O método executeUpdate vai compilar o statement que foi preparado anteriormente
			//e o método retorna a quantidade de linhas afetadas. Ele só serve para 'Update',
			//'Insert' e 'Delete', mas não para 'Select'
			if (totalRegistrosAfetados == 0) {
				System.out.println("Não foi feito o cadastro da magia do personagem");
				return false;
			}
			System.out.println("Cadastro da magia do personagem realizado");
			return true;
			//Ele vai verificar quantas alterações tiveram no banco, se não houverem alterações
			//Ele vai retornar false, caso contrátio, true.
			
		} catch (SQLException erro) {
			System.out.println("Erro ao cadastrar a magia do personagem: " + erro.toString());
			return false;
			//tramento de exception SQL que pode dar tanto no método prepareStatement() quanto
			// no método executeUpdate()
			
		} finally {
			Conexao.fechaConexao(conexao);
			//Fecha uma conexão com o banco como definido na classe Conexao
		}
	}
	
	public boolean consultarMagia(int id_magia, int id_personagem) {
		
		Connection conexao = null;
		//cria um objeto conexao para aplicar o metodo conectaBanco() que está na classe conexao
		
		try {
			conexao = Conexao.conectaBanco();
			//Abre uma conexão com o banco como definido na classe Conexao
						
			String sql = "SELECT * FROM magias WHERE id_magia=? AND id_personagem=?";
			//Monta a consulta da tabela Usuario com base no CPF e Nome, e com placeholders
			//que serão substituidos por métodos da classe PreparedStatements
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			//Cria-se um objeto PreparedStatement para podermos utilizar os métodos da classe
			
			ps.setInt(1,  id_magia);
			ps.setInt(2,  id_personagem);
			//Chamasse o parâmetro setString para colocar no statement feito anteriormente os
			//parâmetros no lugar dos placeholders, pré-compilando o statement que será realizado
			
			
			ResultSet rs = ps.executeQuery();
			//Diferente do executeUpdate, o executeQuery só funciona com Select()
			//Como seria o caso de você ter consutas aninhadas?
			
			
			if(!rs.isBeforeFirst()) {
				System.out.println("Magia não cadastrada.");
				return false;
			//O cursos do ResultSet começa logo antes da primeira linha do resultado da query,
			//ou seja, BeforeFirst, se ele começar, e não estiver BeforeFirst, é porque nenhum
			//resultado foi encontrado, e por consequência, não tem como ele estar antes do primeiro
			//resultado encontrado
			
			} else {
				while(rs.next()) {
					this.id_magia = rs.getInt("id_magia");
					this.id_personagem = rs.getInt("id_personagem");
					this.nome_magia = rs.getString("nome_magia");
					this.tipo_magia = rs.getString("tipo_magia");
					this.nivel_magia = rs.getInt("nivel_magia");
					this.escola_magia = rs.getString("escola_magia");
				}
				return true;
			}
			//o rs.next() passa o cursor do ResultSet rs para a próxima linha, e retorna True
			// caso esse linha tenha alguma informação. Então por conta do while, ele vai fazendo
			//isso até o cursor chegar ao ponto de não terem mais linhas, e o rs.next() retorna false
	
			
			
		} catch (SQLException erro) {
			System.out.println("Erro ao consultar a magia do personagem: " + erro.toString());
			return false;
			//tramento de exception SQL que pode dar tanto no método prepareStatement() quanto
			// no método executeQuery()
			
		} finally {
			Conexao.fechaConexao(conexao);
			//Fecha uma conexão com o banco como definido na classe Conexao
		}
	}
	
	
	public boolean atualizarMagia(int id_magia, int id_personagem, String nome_magia, String tipo_magia, int nivel_magia, String escola_magia) {
		if (!consultarMagia(id_magia, id_personagem))
			return false;
		//Se a consulta do usuário retornar false, então ele termina o método, porque não existe
		//um usuário para modificar
		else {
			Connection conexao = null;
			//cria um objeto conexao para aplicar o metodo conectaBanco() que está na classe conexao
			
			try {
				conexao = Conexao.conectaBanco();
				//Abre uma conexão com o banco como definido na classe Conexao
							
				String sql = "UPDATE magias SET id_magia=?, id_personagem=?, nome_magia=?, tipo_magia=?, nivel_magia=?, escola_magia=?;";
				//Monta a consulta de update na tabela Usuario com placeholders
				//que serão substituidos por métodos da classe PreparedStatements
				
				PreparedStatement ps = conexao.prepareStatement(sql);
				//Cria-se um objeto PreparedStatement para podermos utilizar os métodos da classe
				
				ps.setInt(1,  id_magia);
				ps.setInt(2,  id_personagem);
				ps.setString(3,  nome_magia);
				ps.setString(4,  tipo_magia);
				ps.setInt(5,  nivel_magia);
				ps.setString(6, escola_magia);
				//Chamasse o parâmetro setString para colocar no statement feito anteriormente os
				//parâmetros no lugar dos placeholders, pré-compilando o statement que será realizado
				
				int totalRegistrosAfetados = ps.executeUpdate();
				//O método executeUpdate vai compilar o statement que foi preparado anteriormente
				//e o método retorna a quantidade de linhas afetadas. Ele só serve para 'Update',
				//'Insert' e 'Delete', mas não para 'Select'
				if (totalRegistrosAfetados == 0) {
					System.out.println("Não foi feita a atualização");
					return false;
				}
				System.out.println("Atualização Realizada.");
				return true;
				//Ele vai verificar quantas alterações tiveram no banco, se não houverem alterações
				//Ele vai retornar false, caso contrátio, true.
				
			} catch (SQLException erro) {
				System.out.println("Erro ao atualizar a magia do personagem: " + erro.toString());
				return false;
				//tramento de exception SQL que pode dar tanto no método prepareStatement() quanto
				// no método executeUpdate()
				
			} finally {
				Conexao.fechaConexao(conexao);
				//Fecha uma conexão com o banco como definido na classe Conexao
			}
		}
	}
	
	public boolean deletarMagia(int id_magia, int id_personagem) {
		if (!consultarMagia(id_magia, id_personagem))
			return false;
		//Se a consulta do usuário retornar false, então ele termina o método, porque não existe
		//um usuário para deletar
		else {
			Connection conexao = null;
			//cria um objeto conexao para aplicar o metodo conectaBanco() que está na classe conexao
			
			try {
				conexao = Conexao.conectaBanco();
				//Abre uma conexão com o banco como definido na classe Conexao
							
				String sql = "DELETE FROM magias WHERE id_magia=? AND id_personagem=?;";
				//Monta a consulta de update na tabela Usuario com placeholders
				//que serão substituidos por métodos da classe PreparedStatements
				
				PreparedStatement ps = conexao.prepareStatement(sql);
				//Cria-se um objeto PreparedStatement para podermos utilizar os métodos da classe
				
				ps.setInt(1,  id_magia);
				ps.setInt(2,  id_personagem);

				//Chamasse o parâmetro setString para colocar no statement feito anteriormente os
				//parâmetros no lugar dos placeholders, pré-compilando o statement que será realizado
				
				int totalRegistrosAfetados = ps.executeUpdate();
				//O método executeUpdate vai compilar o statement que foi preparado anteriormente
				//e o método retorna a quantidade de linhas afetadas. Ele só serve para 'Update',
				//'Insert' e 'Delete', mas não para 'Select'
				if (totalRegistrosAfetados == 0) {
					System.out.println("Magia não deletada");
					return false;
				}
				System.out.println("Magia deletada com sucesso.");
				return true;
				//Ele vai verificar quantas alterações tiveram no banco, se não houverem alterações
				//Ele vai retornar false, caso contrátio, true.
				
			} catch (SQLException erro) {
				System.out.println("Erro ao deletar a magia: " + erro.toString());
				return false;
				//tramento de exception SQL que pode dar tanto no método prepareStatement() quanto
				// no método executeUpdate()
				
			} finally {
				Conexao.fechaConexao(conexao);
				//Fecha uma conexão com o banco como definido na classe Conexao
			}
		}
	}

}

