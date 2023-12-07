package br.senac.rj.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Atributo {
	private String idAtributo;
	private String idPersonagem;
	private String tipo;
	private String nome;
	private String valor;
	private String proficiencia;
	
	public String getIdAtributo() {
		return idAtributo;
	}
	
	public void setIdAtributo(String idAtributo) {
		this.idAtributo = idAtributo;
	}
	
	public String getIdPersonagem() {
		return idPersonagem;
	}
	
	public void setIdPersonagem(String idPersonagem) {
		this.idPersonagem = idPersonagem;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getValor() {
		return valor;
	}
	
	public void setValor(String valor) {
		this.valor = valor;
	}
	
	public String getProficiencia() {
		return proficiencia;
	}
	
	public void setProficiencia(String proficiencia) {
		this.proficiencia = proficiencia;
	}
	
	
	public boolean cadastrarAtributo(String idAtributo, String idPersonagem, String nome, String tipo, String valor, String proficiencia) {
		
		Connection conexao = null;
		//cria um objeto conexao para aplicar o metodo conectaBanco() que está na classe conexao
		
		try {
			conexao = Conexao.conectaBanco();
			//Abre uma conexão com o banco como definido na classe Conexao
						
			String sql = "INSERT INTO Atributos SET id_atributo=?, id_personagem=?, nome_atributo=?, tipo_atributo=?, valor_atributo=?, proficiencia_Atributo=?;";
			//Monta a consulta de inserção na tabela Usuario com placeholders
			//que serão substituidos por métodos da classe PreparedStatements
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			//Cria-se um objeto PreparedStatement para podermos utilizar os métodos da classe
			
			ps.setString(1,  idAtributo);
			ps.setString(2,  idPersonagem);
			ps.setString(3,  nome);
			ps.setString(4,  tipo);
			ps.setString(5, valor);
			ps.setString(6, proficiencia);
			//Chamasse o parâmetro setString para colocar no statement feito anteriormente os
			//parâmetros no lugar dos placeholders, pré-compilando o statement que será realizado
			
			int totalRegistrosAfetados = ps.executeUpdate();
			//O método executeUpdate vai compilar o statement que foi preparado anteriormente
			//e o método retorna a quantidade de linhas afetadas. Ele só serve para 'Update',
			//'Insert' e 'Delete', mas não para 'Select'
			if (totalRegistrosAfetados == 0) {
				System.out.println("O atributo não pode ser cadastrado.");
				return false;
			}
			System.out.println("Atributo cadastrado com sucesso!");
			return true;
			//Ele vai verificar quantas alterações tiveram no banco, se não houverem alterações
			//Ele vai retornar false, caso contrátio, true.
			
		} catch (SQLException erro) {
			System.out.println("Erro ao cadastrar o atributo: " + erro.toString());
			return false;
			//tramento de exception SQL que pode dar tanto no método prepareStatement() quanto
			// no método executeUpdate()
			
		} finally {
			Conexao.fechaConexao(conexao);
			//Fecha uma conexão com o banco como definido na classe Conexao
		}
	}
	
	public boolean consultarAtributo(String idAtributo, String idPersonagem) {
		
		Connection conexao = null;
		//cria um objeto conexao para aplicar o metodo conectaBanco() que está na classe conexao
		
		try {
			conexao = Conexao.conectaBanco();
			//Abre uma conexão com o banco como definido na classe Conexao
						
			String sql = "SELECT * FROM Atributos WHERE id_atributo=? and id_personagem=?";
			//Monta a consulta da tabela Usuario com base no CPF e Nome, e com placeholders
			//que serão substituidos por métodos da classe PreparedStatements
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			//Cria-se um objeto PreparedStatement para podermos utilizar os métodos da classe
			
			ps.setString(1,  idAtributo);
			ps.setString(2,  idPersonagem);
			//Chamasse o parâmetro setString para colocar no statement feito anteriormente os
			//parâmetros no lugar dos placeholders, pré-compilando o statement que será realizado
			
			
			ResultSet rs = ps.executeQuery();
			//Diferente do executeUpdate, o executeQuery só funciona com Select()
			//Como seria o caso de você ter consutas aninhadas?
			
			
			if(!rs.isBeforeFirst()) {
				System.out.println("Atributo não cadastrado.");
				return false;
			//O cursos do ResultSet começa logo antes da primeira linha do resultado da query,
			//ou seja, BeforeFirst, se ele começar, e não estiver BeforeFirst, é porque nenhum
			//resultado foi encontrado, e por consequência, não tem como ele estar antes do primeiro
			//resultado encontrado
			
			} else {
				while(rs.next()) {
					this.idAtributo = rs.getString("id_atributo");
					this.idPersonagem = rs.getString("id_personagem");
					this.nome = rs.getString("nome_atributo");
					this.tipo = rs.getString("tipo_atributo");
					this.valor = rs.getString("valor_atributo");
					this.proficiencia = rs.getString("proficiencia_atributo");				
				}
				return true;
			}
			//o rs.next() passa o cursor do ResultSet rs para a próxima linha, e retorna True
			// caso esse linha tenha alguma informação. Então por conta do while, ele vai fazendo
			//isso até o cursor chegar ao ponto de não terem mais linhas, e o rs.next() retorna false
	
			
			
		} catch (SQLException erro) {
			System.out.println("Erro ao consultar atributo: " + erro.toString());
			return false;
			//tramento de exception SQL que pode dar tanto no método prepareStatement() quanto
			// no método executeQuery()
			
		} finally {
			Conexao.fechaConexao(conexao);
			//Fecha uma conexão com o banco como definido na classe Conexao
		}
	}
	
	
	public boolean atualizarAtributo(String idAtributo, String idPersonagem, String nome, String tipo, String valor, String proficiencia) {
		if (!consultarAtributo(idAtributo, idPersonagem))
			return false;
		//Se a consulta do usuário retornar false, então ele termina o método, porque não existe
		//um usuário para modificar
		else {
			Connection conexao = null;
			//cria um objeto conexao para aplicar o metodo conectaBanco() que está na classe conexao
			
			try {
				conexao = Conexao.conectaBanco();
				//Abre uma conexão com o banco como definido na classe Conexao
							
				String sql = "UPDATE Atributos SET nome=?, tipo=?, valor=?, proficiencia=? WHERE id_atributo=? and id_personagem=?";
				//Monta a consulta de update na tabela Usuario com placeholders
				//que serão substituidos por métodos da classe PreparedStatements
				
				PreparedStatement ps = conexao.prepareStatement(sql);
				//Cria-se um objeto PreparedStatement para podermos utilizar os métodos da classe
				
				ps.setString(1,  idAtributo);
				ps.setString(2,  idPersonagem);
				ps.setString(3,  nome);
				ps.setString(4,  tipo);
				ps.setString(5, valor);
				ps.setString(6, proficiencia);
				//Chamasse o parâmetro setString para colocar no statement feito anteriormente os
				//parâmetros no lugar dos placeholders, pré-compilando o statement que será realizado
				
				int totalRegistrosAfetados = ps.executeUpdate();
				//O método executeUpdate vai compilar o statement que foi preparado anteriormente
				//e o método retorna a quantidade de linhas afetadas. Ele só serve para 'Update',
				//'Insert' e 'Delete', mas não para 'Select'
				if (totalRegistrosAfetados == 0) {
					System.out.println("Não foi feita a atualização.");
					return false;
				}
				System.out.println("Atualização Realizada.");
				return true;
				//Ele vai verificar quantas alterações tiveram no banco, se não houverem alterações
				//Ele vai retornar false, caso contrátio, true.
				
			} catch (SQLException erro) {
				System.out.println("Erro ao atualizar atributo: " + erro.toString());
				return false;
				//tramento de exception SQL que pode dar tanto no método prepareStatement() quanto
				// no método executeUpdate()
				
			} finally {
				Conexao.fechaConexao(conexao);
				//Fecha uma conexão com o banco como definido na classe Conexao
			}
		}
	}
	
	public boolean deletarAtributo(String idAtributo, String idPersonagem) {
		if (!consultarAtributo(idAtributo, idPersonagem))
			return false;
		//Se a consulta do usuário retornar false, então ele termina o método, porque não existe
		//um usuário para modificar
		else {
			Connection conexao = null;
			//cria um objeto conexao para aplicar o metodo conectaBanco() que está na classe conexao
			
			try {
				conexao = Conexao.conectaBanco();
				//Abre uma conexão com o banco como definido na classe Conexao
							
				String sql = "Delete Atributo WHERE id_atributo=? and id_personagem=?";
				//Monta a consulta de update na tabela Usuario com placeholders
				//que serão substituidos por métodos da classe PreparedStatements
				
				PreparedStatement ps = conexao.prepareStatement(sql);
				//Cria-se um objeto PreparedStatement para podermos utilizar os métodos da classe
				
				ps.setString(1,  idAtributo);
				ps.setString(2,  idPersonagem);
				//Chamasse o parâmetro setString para colocar no statement feito anteriormente os
				//parâmetros no lugar dos placeholders, pré-compilando o statement que será realizado
				
				int totalRegistrosAfetados = ps.executeUpdate();
				//O método executeUpdate vai compilar o statement que foi preparado anteriormente
				//e o método retorna a quantidade de linhas afetadas. Ele só serve para 'Update',
				//'Insert' e 'Delete', mas não para 'Select'
				if (totalRegistrosAfetados == 0) {
					System.out.println("Não foi possível deleter este atributo.");
					return false;
				}
				System.out.println("O atributo foi deletado com sucesso!");
				return true;
				//Ele vai verificar quantas alterações tiveram no banco, se não houverem alterações
				//Ele vai retornar false, caso contrátio, true.
				
			} catch (SQLException erro) {
				System.out.println("Erro ao detelar atributo: " + erro.toString());
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
