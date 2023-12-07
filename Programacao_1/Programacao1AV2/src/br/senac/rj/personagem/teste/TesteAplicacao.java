package br.senac.rj.personagem.teste;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

import br.senac.rj.personagem.view.JanelaAtributo;
import br.senac.rj.personagem.view.JanelaCaracteristicasPersonagem;
import br.senac.rj.personagem.view.JanelaMagias;

public class TesteAplicacao {

	public static void apresentarMenu() {
		// Define a janela
		JFrame janelaPrincipal = new JFrame(""); // Janela Normal
		janelaPrincipal.setTitle("Hero Story");
		janelaPrincipal.setResizable(false); // A janela não poderá ter o tamanho ajustado
		janelaPrincipal.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		janelaPrincipal.setSize(400, 400); // Define tamanho da janela
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
		JMenuItem menuCaracteristicas = new JMenuItem("Características");
		menuAtualizar.add(menuCaracteristicas);
		JMenuItem menuAtributos = new JMenuItem("Atributos");
		menuAtualizar.add(menuAtributos);
		JMenuItem menuMagias = new JMenuItem("Magias");
		menuAtualizar.add(menuMagias);
		// Criar a janela de atualização da conta
		JFrame janelaCaracteristicasPersonagem = JanelaCaracteristicasPersonagem.criarJanelaCaracteristicasPersonagem();
		// Adiciona ação para o item do menu
		menuCaracteristicas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				janelaCaracteristicasPersonagem.setVisible(true);
			}
		});
		
		JFrame janelaAtributo = JanelaAtributo.criarJanelaAtributo();
		// Adiciona ação para o item do menu
		menuAtributos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				janelaAtributo.setVisible(true);
			}
		});
		
		JFrame janelaMagias = JanelaMagias.criarJanelaMagias();
		// Adiciona ação para o item do menu
		menuMagias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				janelaMagias.setVisible(true);
			}
		});
		
		janelaPrincipal.setVisible(true);
	}

	public static void main(String[] args) {
		apresentarMenu(); //A execução ocorre somente aqui
	}
}