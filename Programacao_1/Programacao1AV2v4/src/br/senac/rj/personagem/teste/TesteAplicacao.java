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
import br.senac.rj.personagem.view.JanelaInventario;
import br.senac.rj.personagem.view.JanelaMagias;

public class TesteAplicacao {

	public static void apresentarMenu() {
		JFrame janelaPrincipal = new JFrame("");
		janelaPrincipal.setTitle("Hero Story");
		janelaPrincipal.setResizable(false);
		janelaPrincipal.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		janelaPrincipal.setSize(400, 400);
		UIManager.put("OptionPane.yesButtonText", "Sim"); 
		UIManager.put("OptionPane.noButtonText", "Não");
		JMenuBar menuBar = new JMenuBar();
		janelaPrincipal.setJMenuBar(menuBar);
		JMenu menuAtualizar = new JMenu("Atualizar");
		menuBar.add(menuAtualizar);
		JMenuItem menuCaracteristicas = new JMenuItem("Características");
		menuAtualizar.add(menuCaracteristicas);
		JMenuItem menuAtributos = new JMenuItem("Atributos");
		menuAtualizar.add(menuAtributos);
		JMenuItem menuMagias = new JMenuItem("Magias");
		menuAtualizar.add(menuMagias);
		JMenuItem menuInventario = new JMenuItem("Inventário");
		menuAtualizar.add(menuInventario);
		JFrame janelaCaracteristicasPersonagem = JanelaCaracteristicasPersonagem.criarJanelaCaracteristicasPersonagem();
		menuCaracteristicas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				janelaCaracteristicasPersonagem.setVisible(true);
			}
		});
		
		JFrame janelaAtributo = JanelaAtributo.criarJanelaAtributo();
		menuAtributos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				janelaAtributo.setVisible(true);
			}
		});
		
		JFrame janelaMagias = JanelaMagias.criarJanelaMagias();
		menuMagias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				janelaMagias.setVisible(true);
			}
		});
		
		JFrame janelaInventario = JanelaInventario.criarJanelaInventario();
		menuInventario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				janelaInventario.setVisible(true);
			}
		});
		
		janelaPrincipal.setVisible(true);
	}

	public static void main(String[] args) {
		apresentarMenu();
	}
}