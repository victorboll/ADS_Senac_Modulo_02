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
		
		try {
			conexao = Conexao.conectaBanco();
						
			String sql = "INSERT INTO magias SET id_magia=?, id_personagem=?, nome_magia=?, tipo_magia=?, nivel_magia=?, escola_magia=?;";
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setInt(1,  id_magia);
			ps.setInt(2,  id_personagem);
			ps.setString(3,  nome_magia);
			ps.setString(4,  tipo_magia);
			ps.setInt(5,  nivel_magia);
			ps.setString(6, escola_magia);
			
			int totalRegistrosAfetados = ps.executeUpdate();

			if (totalRegistrosAfetados == 0) {
				System.out.println("Não foi feito o cadastro da magia do personagem");
				return false;
			}
			System.out.println("Cadastro da magia do personagem realizado");
			return true;
			
		} catch (SQLException erro) {
			System.out.println("Erro ao cadastrar a magia do personagem: " + erro.toString());
			return false;
			
		} finally {
			Conexao.fechaConexao(conexao);
		}
	}
	
	public boolean consultarMagia(int id_magia, int id_personagem) {
		
		Connection conexao = null;
		
		try {
			conexao = Conexao.conectaBanco();
						
			String sql = "SELECT * FROM magias WHERE id_magia=? AND id_personagem=?";
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setInt(1,  id_magia);
			ps.setInt(2,  id_personagem);		
			
			ResultSet rs = ps.executeQuery();		
			
			if(!rs.isBeforeFirst()) {
				System.out.println("Magia não cadastrada.");
				return false;
			
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

		} catch (SQLException erro) {
			System.out.println("Erro ao consultar a magia do personagem: " + erro.toString());
			return false;
			
		} finally {
			Conexao.fechaConexao(conexao);
		}
	}
	
	
	public boolean atualizarMagia(int id_magia, int id_personagem, String nome_magia, String tipo_magia, int nivel_magia, String escola_magia) {
		if (!consultarMagia(id_magia, id_personagem))
			return false;
		else {
			Connection conexao = null;
			
			try {
				conexao = Conexao.conectaBanco();
							
				String sql = "UPDATE magias SET id_magia=?, id_personagem=?, nome_magia=?, tipo_magia=?, nivel_magia=?, escola_magia=?;";
				
				PreparedStatement ps = conexao.prepareStatement(sql);
				
				ps.setInt(1,  id_magia);
				ps.setInt(2,  id_personagem);
				ps.setString(3,  nome_magia);
				ps.setString(4,  tipo_magia);
				ps.setInt(5,  nivel_magia);
				ps.setString(6, escola_magia);
				
				int totalRegistrosAfetados = ps.executeUpdate();

				if (totalRegistrosAfetados == 0) {
					System.out.println("Não foi feita a atualização");
					return false;
				}
				System.out.println("Atualização Realizada.");
				return true;
				
			} catch (SQLException erro) {
				System.out.println("Erro ao atualizar a magia do personagem: " + erro.toString());
				return false;
				
			} finally {
				Conexao.fechaConexao(conexao);

			}
		}
	}
	
	public boolean deletarMagia(int id_magia, int id_personagem) {
		if (!consultarMagia(id_magia, id_personagem))
			return false;

		else {
			Connection conexao = null;
			
			try {
				conexao = Conexao.conectaBanco();
							
				String sql = "DELETE FROM magias WHERE id_magia=? AND id_personagem=?;";
				
				PreparedStatement ps = conexao.prepareStatement(sql);
				
				ps.setInt(1,  id_magia);
				ps.setInt(2,  id_personagem);
				
				int totalRegistrosAfetados = ps.executeUpdate();

				if (totalRegistrosAfetados == 0) {
					System.out.println("Magia não deletada");
					return false;
				}
				System.out.println("Magia deletada com sucesso.");
				return true;
				
			} catch (SQLException erro) {
				System.out.println("Erro ao deletar a magia: " + erro.toString());
				return false;
				
			} finally {
				Conexao.fechaConexao(conexao);
			}
		}
	}

}

