package br.senac.rj.teste;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

import br.senac.rj.view.JanelaAtributo;

public class TesteAplicacao {

	public static void apresentarMenu() {
		// Define a janela
		JFrame janelaPrincipal = new JFrame("Cadastro de personagem"); // Janela Normal
		janelaPrincipal.setTitle("Personagem de RPG");
		janelaPrincipal.setResizable(false); // A janela n�o poder� ter o tamanho ajustado
		janelaPrincipal.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		janelaPrincipal.setSize(700, 800); // Define tamanho da janela
		UIManager.put("OptionPane.yesButtonText", "Sim"); 
		UIManager.put("OptionPane.noButtonText", "Não");
		// Cria uma barra de menu para a janela principal
		JMenuBar menuBar = new JMenuBar();
		// Adiciona a barra de menu ao frame
		janelaPrincipal.setJMenuBar(menuBar);
		// Define e adiciona menu na barra de menu
		JMenu menuAtualizar = new JMenu("Atualizar");
		menuBar.add(menuAtualizar);
		// Cria e adiciona um item simples para o menu
		JMenuItem menuAtributo = new JMenuItem("Atributos");
		menuAtualizar.add(menuAtributo);
		// Criar a janela de atualização da conta
		JFrame janelaAtributo = JanelaAtributo.criarJanelaAtributo();
		// Adiciona ação para o item do menu
		menuAtributo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				janelaAtributo.setVisible(true);
			}
		});
		janelaPrincipal.setVisible(true);
	}

	public static void main(String[] args) {
		apresentarMenu(); //A execução ocorre somente aqui
	}
}