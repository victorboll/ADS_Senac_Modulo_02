package br.senac.rj.personagem.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Atributo {
	private int idAtributo;
	private int idPersonagem;
	private String tipo;
	private String nome;
	private String valor;
	private String proficiencia;
	
	public int getIdAtributo() {
		return idAtributo;
	}
	
	public void setIdAtributo(int idAtributo) {
		this.idAtributo = idAtributo;
	}
	
	public int getIdPersonagem() {
		return idPersonagem;
	}
	
	public void setIdPersonagem(int idPersonagem) {
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
	
	
	public boolean cadastrarAtributo(int idAtributo, int idPersonagem, String nome, String tipo, String valor, String proficiencia) {
		
		Connection conexao = null;
		
		try {
			conexao = Conexao.conectaBanco();
						
			String sql = "INSERT INTO atributos SET id_atributo=?, id_personagem=?, nome_atributo=?, tipo_atributo=?, valor_atributo=?, proficiencia_Atributo=?;";
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setInt(1,  idAtributo);
			ps.setInt(2,  idPersonagem);
			ps.setString(3,  nome);
			ps.setString(4,  tipo);
			ps.setString(5, valor);
			ps.setString(6, proficiencia);
			
			int totalRegistrosAfetados = ps.executeUpdate();

			if (totalRegistrosAfetados == 0) {
				System.out.println("O atributo não pode ser cadastrado.");
				return false;
			}
			System.out.println("Atributo cadastrado com sucesso!");
			return true;
			
		} catch (SQLException erro) {
			System.out.println("Erro ao cadastrar o atributo: " + erro.toString());
			return false;
			
		} finally {
			Conexao.fechaConexao(conexao);
		}
	}
	
	public boolean consultarAtributo(int idAtributo, int idPersonagem) {
		
		Connection conexao = null;
		
		try {
			conexao = Conexao.conectaBanco();
						
			String sql = "SELECT * FROM atributos WHERE id_atributo=? and id_personagem=?";
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setInt(1,  idAtributo);
			ps.setInt(2,  idPersonagem);
				
			ResultSet rs = ps.executeQuery();
		
			if(!rs.isBeforeFirst()) {
				System.out.println("Atributo não cadastrado.");
				return false;
			
			} else {
				while(rs.next()) {
					this.idAtributo = rs.getInt("id_atributo");
					this.idPersonagem = rs.getInt("id_personagem");
					this.nome = rs.getString("nome_atributo");
					this.tipo = rs.getString("tipo_atributo");
					this.valor = rs.getString("valor_atributo");
					this.proficiencia = rs.getString("proficiencia_atributo");				
				}
				return true;
			}
	
		} catch (SQLException erro) {
			System.out.println("Erro ao consultar atributo: " + erro.toString());
			return false;
			
		} finally {
			Conexao.fechaConexao(conexao);
		}
	}
	
	public boolean atualizarAtributo(int idAtributo, int idPersonagem, String nome, String tipo, String valor, String proficiencia) {
		if (!consultarAtributo(idAtributo, idPersonagem))
			return false;
		else {
			Connection conexao = null;		
			try {
				conexao = Conexao.conectaBanco();
			
				String sql = "UPDATE atributos SET nome=?, tipo=?, valor=?, proficiencia=? WHERE id_atributo=? and id_personagem=?";

				PreparedStatement ps = conexao.prepareStatement(sql);

				ps.setInt(1,  idAtributo);
				ps.setInt(2,  idPersonagem);
				ps.setString(3,  nome);
				ps.setString(4,  tipo);
				ps.setString(5, valor);
				ps.setString(6, proficiencia);

				int totalRegistrosAfetados = ps.executeUpdate();

				if (totalRegistrosAfetados == 0) {
					System.out.println("Não foi feita a atualização.");
					return false;
				}
				System.out.println("Atualização Realizada.");
				return true;
	
			} catch (SQLException erro) {
				System.out.println("Erro ao atualizar atributo: " + erro.toString());
				return false;
	
			} finally {
				Conexao.fechaConexao(conexao);
			}
		}
	}
	
	public boolean deletarAtributo(int idAtributo, int idPersonagem) {
		if (!consultarAtributo(idAtributo, idPersonagem))
			return false;

		else {
			Connection conexao = null;
			
			try {
				conexao = Conexao.conectaBanco();
							
				String sql = "DELETE FROM atributos WHERE id_atributo=? and id_personagem=?";
				
				PreparedStatement ps = conexao.prepareStatement(sql);
				
				ps.setInt(1,  idAtributo);
				ps.setInt(2,  idPersonagem);
				
				int totalRegistrosAfetados = ps.executeUpdate();

				if (totalRegistrosAfetados == 0) {
					System.out.println("Não foi possível deleter este atributo.");
					return false;
				}
				System.out.println("O atributo foi deletado com sucesso!");
				return true;
				
			} catch (SQLException erro) {
				System.out.println("Erro ao detelar atributo: " + erro.toString());
				return false;
				
			} finally {
				Conexao.fechaConexao(conexao);
			}
		}
				
	}

}
