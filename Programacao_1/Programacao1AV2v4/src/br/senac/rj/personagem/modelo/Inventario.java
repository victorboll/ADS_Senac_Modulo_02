package br.senac.rj.personagem.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Inventario {
	private int id_item;
	private int id_personagem;
	private String nome_item;
	private int quantidade_item;
	private float peso_item;
	private String tipo_item;

	
	public Inventario() {
		// TODO Auto-generated constructor stub
	}
	
	public int getId_item() {
		return id_item;
	}

	public void setId_item(int id_item) {
		this.id_item = id_item;
	}

	public int getId_personagem() {
		return id_personagem;
	}

	public void setId_personagem(int id_personagem) {
		this.id_personagem = id_personagem;
	}

	public String getNome_item() {
		return nome_item;
	}

	public void setNome_item(String nome_item) {
		this.nome_item = nome_item;
	}

	public int getQuantidade_item() {
		return quantidade_item;
	}

	public void setQuantidade_item(int quantidade_item) {
		this.quantidade_item = quantidade_item;
	}

	public float getPeso_item() {
		return peso_item;
	}

	public void setPeso_item(float peso_item) {
		this.peso_item = peso_item;
	}

	public String getTipo_item() {
		return tipo_item;
	}

	public void setTipo_item(String tipo_item) {
		this.tipo_item = tipo_item;
	}

	public boolean cadastrarItem(int id_item, int id_personagem, String nome_item, int quantidade_item, float peso_item, String tipo_item){
		
		Connection conexao = null;
		
		try {
			conexao = Conexao.conectaBanco();
						
			String sql = "INSERT INTO inventario SET id_item=?, id_personagem=?, nome_item=?, quantidade_item=?, peso_item=?, tipo_item=?;";
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setInt(1,  id_item);
			ps.setInt(2,  id_personagem);
			ps.setString(3,  nome_item);
			ps.setInt(4,  quantidade_item);
			ps.setFloat(5,  peso_item);
			ps.setString(6, tipo_item);
			
			int totalRegistrosAfetados = ps.executeUpdate();

			if (totalRegistrosAfetados == 0) {
				System.out.println("Não foi feito o cadastro do item no inventário");
				return false;
			}
			System.out.println("Cadastro de item no inventário do personagem realizado com sucesso");
			return true;
			
		} catch (SQLException erro) {
			System.out.println("Erro ao cadastrar o item no inventário do personagem: " + erro.toString());
			return false;
			
		} finally {
			Conexao.fechaConexao(conexao);
		}
	}
	
	public boolean consultarItem(int id_item, int id_personagem) {
		
		Connection conexao = null;
		
		try {
			conexao = Conexao.conectaBanco();
						
			String sql = "SELECT * FROM inventario WHERE  id_item=? AND id_personagem=?";
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setInt(1,  id_item);
			ps.setInt(2,  id_personagem);		
			
			ResultSet rs = ps.executeQuery();		
			
			if(!rs.isBeforeFirst()) {
				System.out.println("Item não cadastrado.");
				return false;
			
			} else {
				while(rs.next()) {
					this.id_item = rs.getInt("id_item");
					this.id_personagem = rs.getInt("id_personagem");
					this.nome_item = rs.getString("nome_item");
					this.quantidade_item = rs.getInt("quantidade_item");
					this.peso_item = rs.getFloat("peso_item");
					this.tipo_item = rs.getString("tipo_item");
				}
				return true;
			}

		} catch (SQLException erro) {
			System.out.println("Erro ao consultar o item: " + erro.toString());
			return false;
			
		} finally {
			Conexao.fechaConexao(conexao);
		}
	}
	
	
	public boolean atualizarItem(int id_item, int id_personagem, String nome_item, int quantidade_item, float peso_item, String tipo_item) {
		if (!consultarItem(id_item, id_personagem))
			return false;
		else {
			Connection conexao = null;
			
			try {
				conexao = Conexao.conectaBanco();
							
				String sql = "UPDATE inventario SET nome_item=?, quantidade_item=?, peso_item=?, tipo_item=? WHERE id_item=? AND id_personagem=?;";
				
				PreparedStatement ps = conexao.prepareStatement(sql);
				
				ps.setString(1,  nome_item);
				ps.setInt(2,  quantidade_item);
				ps.setFloat(3,  peso_item);
				ps.setString(4, tipo_item);
				ps.setInt(5,  id_item);
				ps.setInt(6,  id_personagem);
				
				int totalRegistrosAfetados = ps.executeUpdate();

				if (totalRegistrosAfetados == 0) {
					System.out.println("Não foi feita a atualização");
					return false;
				}
				System.out.println("Atualização Realizada.");
				return true;
				
			} catch (SQLException erro) {
				System.out.println("Erro ao atualizar o item do personagem: " + erro.toString());
				return false;
				
			} finally {
				Conexao.fechaConexao(conexao);

			}
		}
	}
	
	public boolean deletarItem(int id_item, int id_personagem) {
		if (!consultarItem(id_item, id_personagem))
			return false;

		else {
			Connection conexao = null;
			
			try {
				conexao = Conexao.conectaBanco();
							
				String sql = "DELETE FROM inventario WHERE id_item=? AND id_personagem=?;";
				
				PreparedStatement ps = conexao.prepareStatement(sql);
				
				ps.setInt(1,  id_item);
				ps.setInt(2,  id_personagem);
				
				int totalRegistrosAfetados = ps.executeUpdate();

				if (totalRegistrosAfetados == 0) {
					System.out.println("Item não deletado");
					return false;
				}
				System.out.println("Item deletado com sucesso.");
				return true;
				
			} catch (SQLException erro) {
				System.out.println("Erro ao deletar o item: " + erro.toString());
				return false;
				
			} finally {
				Conexao.fechaConexao(conexao);
			}
		}
	}

}

