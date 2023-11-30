package br.senac.rj.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.NumberFormat;
import java.util.Scanner;


public class TesteJdbc1 {

	public static void main(String[] args) {
		try {
			String url = "jdbc:mysql://localhost/banco"; // URL do banco de dados
			String user = "root"; //nome do usuário do banco
			String password = ""; //senha do usuário no banco
			Connection conn = DriverManager.getConnection(url, user, password);
			// Define a consulta
			String sql = "select * from conta where agencia=?";
			// Prepara a consulta
			PreparedStatement ps = conn.prepareStatement(sql);
			// Obtém número da agência a ser pesquisada
			Scanner sc = new Scanner(System.in);
			System.out.print("Entre com o número de uma agência = ");
			int agenciaPesquisa = Integer.parseInt(sc.nextLine());
			ps.setInt(1, agenciaPesquisa);	// Substitui o primeiro parâmetro da consulta pela agência informada	
			// Executa a consulta, resultando em um objeto da classe ResultSet
			ResultSet rs = ps.executeQuery();
			if (!rs.isBeforeFirst()) { // Verifica se não está antes do primeiro registro
				System.out.println("Não foram encontrados registros!");
			}
			else
			{
				// Efetua a leitura dos registros da tabela
				int totalRegistros = 0;
				while (rs.next()) {
				    int agencia = rs.getInt("agencia");
				    int numero = rs.getInt("numero");
				    String titular = rs.getString("titular");
				    double saldo = rs.getDouble("saldo");
				    // Apresenta os valores dos campos da tabela
				    System.out.println("Número do registro = " + rs.getRow());
				    System.out.println("Agência=" + agencia);
				    System.out.println("Número da conta=" + numero);
				    System.out.println("Titular=" + titular);
				    System.out.println("Saldo=" + NumberFormat.getCurrencyInstance().format(saldo));
				    System.out.println();
				    totalRegistros++;
				}
				System.out.println("Total de registros = " + totalRegistros);
			}
			sc.close();
		} catch (Exception erro) {
			System.out.println("Erro: " + erro.toString());
		}
	}
}
