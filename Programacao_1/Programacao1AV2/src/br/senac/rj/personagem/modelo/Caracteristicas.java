package br.senac.rj.personagem.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Caracteristicas {
	private int id;
	private String nome;
	private int nivel;
	private String raca;
	private String classe;
	
	public Caracteristicas() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}
	
	public boolean cadastrarCaracteristicas(int id, String nome, int nivel, String raca, String classe) {
		
		Connection conexao = null;
		//cria um objeto conexao para aplicar o metodo conectaBanco() que está na classe conexao
		
		try {
			conexao = Conexao.conectaBanco();
			//Abre uma conexão com o banco como definido na classe Conexao
						
			String sql = "INSERT INTO caracteristicas SET id=?, nome=?, nivel=?, raca=?, classe=?;";
			//Monta a consulta de inserção na tabela Usuario com placeholders
			//que serão substituidos por métodos da classe PreparedStatements
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			//Cria-se um objeto PreparedStatement para podermos utilizar os métodos da classe
			
			ps.setInt(1,  id);
			ps.setString(2,  nome);
			ps.setInt(3,  nivel);
			ps.setString(4,  raca);
			ps.setString(5, classe);
			//Chamasse o parâmetro setString para colocar no statement feito anteriormente os
			//parâmetros no lugar dos placeholders, pré-compilando o statement que será realizado
			
			int totalRegistrosAfetados = ps.executeUpdate();
			//O método executeUpdate vai compilar o statement que foi preparado anteriormente
			//e o método retorna a quantidade de linhas afetadas. Ele só serve para 'Update',
			//'Insert' e 'Delete', mas não para 'Select'
			if (totalRegistrosAfetados == 0) {
				System.out.println("Não foi feito o cadastro das características do personagem");
				return false;
			}
			System.out.println("Cadastro das características do personagem realizado");
			return true;
			//Ele vai verificar quantas alterações tiveram no banco, se não houverem alterações
			//Ele vai retornar false, caso contrátio, true.
			
		} catch (SQLException erro) {
			System.out.println("Erro ao cadastrar as características do personagem: " + erro.toString());
			return false;
			//tramento de exception SQL que pode dar tanto no método prepareStatement() quanto
			// no método executeUpdate()
			
		} finally {
			Conexao.fechaConexao(conexao);
			//Fecha uma conexão com o banco como definido na classe Conexao
		}
	}
	
	public boolean consultarCaracteristicas(int id, String nome) {
		
		Connection conexao = null;
		//cria um objeto conexao para aplicar o metodo conectaBanco() que está na classe conexao
		
		try {
			conexao = Conexao.conectaBanco();
			//Abre uma conexão com o banco como definido na classe Conexao
						
			String sql = "SELECT * FROM caracteristicas WHERE id=? AND nome=?";
			//Monta a consulta da tabela Usuario com base no CPF e Nome, e com placeholders
			//que serão substituidos por métodos da classe PreparedStatements
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			//Cria-se um objeto PreparedStatement para podermos utilizar os métodos da classe
			
			ps.setInt(1,  id);
			ps.setString(2,  nome);
			//Chamasse o parâmetro setString para colocar no statement feito anteriormente os
			//parâmetros no lugar dos placeholders, pré-compilando o statement que será realizado
			
			
			ResultSet rs = ps.executeQuery();
			//Diferente do executeUpdate, o executeQuery só funciona com Select()
			//Como seria o caso de você ter consutas aninhadas?
			
			
			if(!rs.isBeforeFirst()) {
				System.out.println("Personagem não cadastrado.");
				return false;
			//O cursos do ResultSet começa logo antes da primeira linha do resultado da query,
			//ou seja, BeforeFirst, se ele começar, e não estiver BeforeFirst, é porque nenhum
			//resultado foi encontrado, e por consequência, não tem como ele estar antes do primeiro
			//resultado encontrado
			
			} else {
				while(rs.next()) {
					this.id = rs.getInt("id");
					this.nome = rs.getString("nome");
					this.nivel = rs.getInt("nivel");
					this.raca = rs.getString("raca");
					this.classe = rs.getString("classe");
				}
				return true;
			}
			//o rs.next() passa o cursor do ResultSet rs para a próxima linha, e retorna True
			// caso esse linha tenha alguma informação. Então por conta do while, ele vai fazendo
			//isso até o cursor chegar ao ponto de não terem mais linhas, e o rs.next() retorna false
	
			
			
		} catch (SQLException erro) {
			System.out.println("Erro ao consultar as características do personagem: " + erro.toString());
			return false;
			//tramento de exception SQL que pode dar tanto no método prepareStatement() quanto
			// no método executeQuery()
			
		} finally {
			Conexao.fechaConexao(conexao);
			//Fecha uma conexão com o banco como definido na classe Conexao
		}
	}
	
	
	public boolean atualizarCaracteristicas(int id, String nome, int nivel, String raca, String classe) {
		if (!consultarCaracteristicas(id, nome))
			return false;
		//Se a consulta do usuário retornar false, então ele termina o método, porque não existe
		//um usuário para modificar
		else {
			Connection conexao = null;
			//cria um objeto conexao para aplicar o metodo conectaBanco() que está na classe conexao
			
			try {
				conexao = Conexao.conectaBanco();
				//Abre uma conexão com o banco como definido na classe Conexao
							
				String sql = "UPDATE caracteristicas SET id=?, nome=?, nivel=?, raca=?, classe=?;";
				//Monta a consulta de update na tabela Usuario com placeholders
				//que serão substituidos por métodos da classe PreparedStatements
				
				PreparedStatement ps = conexao.prepareStatement(sql);
				//Cria-se um objeto PreparedStatement para podermos utilizar os métodos da classe
				
				ps.setInt(1,  id);
				ps.setString(2,  nome);
				ps.setInt(3,  nivel);
				ps.setString(4,  raca);
				ps.setString(5, classe);
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
				System.out.println("Erro ao atualizar as características do personagem: " + erro.toString());
				return false;
				//tramento de exception SQL que pode dar tanto no método prepareStatement() quanto
				// no método executeUpdate()
				
			} finally {
				Conexao.fechaConexao(conexao);
				//Fecha uma conexão com o banco como definido na classe Conexao
			}
		}
	}
	
	public boolean deletarCaracteristicas(int id, String nome) {
		if (!consultarCaracteristicas(id, nome))
			return false;
		//Se a consulta do usuário retornar false, então ele termina o método, porque não existe
		//um usuário para deletar
		else {
			Connection conexao = null;
			//cria um objeto conexao para aplicar o metodo conectaBanco() que está na classe conexao
			
			try {
				conexao = Conexao.conectaBanco();
				//Abre uma conexão com o banco como definido na classe Conexao
							
				String sql = "DELETE FROM caracteristicas WHERE id=? AND nome=?;";
				//Monta a consulta de update na tabela Usuario com placeholders
				//que serão substituidos por métodos da classe PreparedStatements
				
				PreparedStatement ps = conexao.prepareStatement(sql);
				//Cria-se um objeto PreparedStatement para podermos utilizar os métodos da classe
				
				ps.setInt(1,  id);
				ps.setString(2,  nome);

				//Chamasse o parâmetro setString para colocar no statement feito anteriormente os
				//parâmetros no lugar dos placeholders, pré-compilando o statement que será realizado
				
				int totalRegistrosAfetados = ps.executeUpdate();
				//O método executeUpdate vai compilar o statement que foi preparado anteriormente
				//e o método retorna a quantidade de linhas afetadas. Ele só serve para 'Update',
				//'Insert' e 'Delete', mas não para 'Select'
				if (totalRegistrosAfetados == 0) {
					System.out.println("Personagem não deletado");
					return false;
				}
				System.out.println("Personagem Deletado com sucesso.");
				return true;
				//Ele vai verificar quantas alterações tiveram no banco, se não houverem alterações
				//Ele vai retornar false, caso contrátio, true.
				
			} catch (SQLException erro) {
				System.out.println("Erro ao deletar o personagem: " + erro.toString());
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

