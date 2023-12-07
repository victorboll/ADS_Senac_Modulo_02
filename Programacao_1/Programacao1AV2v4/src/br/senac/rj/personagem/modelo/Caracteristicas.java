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
		
		try {
			conexao = Conexao.conectaBanco();
						
			String sql = "INSERT INTO caracteristicas SET id=?, nome=?, nivel=?, raca=?, classe=?;";
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setInt(1,  id);
			ps.setString(2,  nome);
			ps.setInt(3,  nivel);
			ps.setString(4,  raca);
			ps.setString(5, classe);
			
			int totalRegistrosAfetados = ps.executeUpdate();

			if (totalRegistrosAfetados == 0) {
				System.out.println("Não foi feito o cadastro das características do personagem");
				return false;
			}
			System.out.println("Cadastro das características do personagem realizado");
			return true;
			
		} catch (SQLException erro) {
			System.out.println("Erro ao cadastrar as características do personagem: " + erro.toString());
			return false;
			
		} finally {
			Conexao.fechaConexao(conexao);
		}
	}
	
	public boolean consultarCaracteristicas(int id, String nome) {
		
		Connection conexao = null;
		
		try {
			conexao = Conexao.conectaBanco();
						
			String sql = "SELECT * FROM caracteristicas WHERE id=? AND nome=?";
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setInt(1,  id);
			ps.setString(2,  nome);
			
			ResultSet rs = ps.executeQuery();		
			
			if(!rs.isBeforeFirst()) {
				System.out.println("Personagem não cadastrado.");
				return false;
			
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

		} catch (SQLException erro) {
			System.out.println("Erro ao consultar as características do personagem: " + erro.toString());
			return false;
			
		} finally {
			Conexao.fechaConexao(conexao);
		}
	}
	
	
	public boolean atualizarCaracteristicas(int id, String nome, int nivel, String raca, String classe) {
		if (!consultarCaracteristicas(id, nome))
			return false;

		else {
			Connection conexao = null;

			try {
				conexao = Conexao.conectaBanco();
							
				String sql = "UPDATE caracteristicas SET nome=?, nivel=?, raca=?, classe=? WHERE id=?;";
				
				PreparedStatement ps = conexao.prepareStatement(sql);
				
				ps.setString(1,  nome);
				ps.setInt(2,  nivel);
				ps.setString(3,  raca);
				ps.setString(4, classe);
				ps.setInt(5,  id);
				
				int totalRegistrosAfetados = ps.executeUpdate();

				if (totalRegistrosAfetados == 0) {
					System.out.println("Não foi feita a atualização");
					return false;
				}
				System.out.println("Atualização Realizada.");
				return true;
				
			} catch (SQLException erro) {
				System.out.println("Erro ao atualizar as características do personagem: " + erro.toString());
				return false;
				
			} finally {
				Conexao.fechaConexao(conexao);
			}
		}
	}
	
	public boolean deletarCaracteristicas(int id, String nome) {
		if (!consultarCaracteristicas(id, nome))
			return false;
		else {
			Connection conexao = null;
			
			try {
				conexao = Conexao.conectaBanco();
							
				String sql = "DELETE FROM caracteristicas WHERE id=? AND nome=?;";
				
				PreparedStatement ps = conexao.prepareStatement(sql);
				
				ps.setInt(1,  id);
				ps.setString(2,  nome);
				
				int totalRegistrosAfetados = ps.executeUpdate();

				if (totalRegistrosAfetados == 0) {
					System.out.println("Personagem não deletado");
					return false;
				}
				System.out.println("Personagem Deletado com sucesso.");
				return true;
				
			} catch (SQLException erro) {
				System.out.println("Erro ao deletar o personagem: " + erro.toString());
				return false;
				
			} finally {
				Conexao.fechaConexao(conexao);
			}
		}
	}

}

