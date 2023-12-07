package br.senac.rj.personagem.view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import br.senac.rj.personagem.modelo.Caracteristicas;

public class JanelaCaracteristicasPersonagem {
	
	public static JFrame criarJanelaCaracteristicasPersonagem() {
		
		JFrame janelaCaracteristicasPersonagem = new JFrame("Atualização de características do personagem");
		
		janelaCaracteristicasPersonagem.setResizable(false); 
		janelaCaracteristicasPersonagem.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		janelaCaracteristicasPersonagem.setSize(400, 400); 		
	
		Container caixa = janelaCaracteristicasPersonagem.getContentPane();
		caixa.setLayout(null);
		
		JLabel labelId = new JLabel("ID: ");
		labelId.setBounds(50, 40, 100, 20);
		janelaCaracteristicasPersonagem.add(labelId);
		
		JLabel labelNome = new JLabel("Nome: ");
		labelNome.setBounds(50, 80, 150, 20); 
		janelaCaracteristicasPersonagem.add(labelNome);
		
		JLabel labelNivel = new JLabel("Nível: ");
		labelNivel.setBounds(50, 120, 100, 20); 
		janelaCaracteristicasPersonagem.add(labelNivel);

		JLabel labelRaca = new JLabel("Raça: ");
		labelRaca.setBounds(50, 160, 100, 20); 
		janelaCaracteristicasPersonagem.add(labelRaca);
		
		JLabel labelClasse = new JLabel("Clase: ");
		labelClasse.setBounds(50, 200, 100, 20); 
		janelaCaracteristicasPersonagem.add(labelClasse);

		JTextField jTextId = new JTextField();
		jTextId.setEnabled(true);
		jTextId.setBounds(180, 40, 50, 20);
		janelaCaracteristicasPersonagem.add(jTextId);
		
		JTextField jTextNome = new JTextField();
		jTextNome.setEnabled(true);
		jTextNome.setBounds(180, 80, 50, 20);
		janelaCaracteristicasPersonagem.add(jTextNome);
		
		JTextField jTextNivel = new JTextField();
		jTextNivel.setEnabled(false);
		jTextNivel.setBounds(180, 120, 150, 20);
		janelaCaracteristicasPersonagem.add(jTextNivel);
		
		JTextField jTextRaca = new JTextField();
		jTextRaca.setEnabled(false);
		jTextRaca.setBounds(180, 160, 150, 20);
		janelaCaracteristicasPersonagem.add(jTextRaca);
		
		JTextField jTextClasse = new JTextField();
		jTextClasse.setEnabled(false);
		jTextClasse.setBounds(180, 200, 150, 20);
		janelaCaracteristicasPersonagem.add(jTextClasse);

		JButton botaoConsultar = new JButton("Consultar");
		botaoConsultar.setBounds(230, 80, 100, 20);
		botaoConsultar.setEnabled(true);
		janelaCaracteristicasPersonagem.add(botaoConsultar);

		JButton botaoGravar = new JButton("Gravar");
		botaoGravar.setBounds(60, 240, 80, 20);
		botaoGravar.setEnabled(false);
		janelaCaracteristicasPersonagem.add(botaoGravar);
		
		JButton botaoDeletar = new JButton("Deletar");
		botaoDeletar.setBounds(155, 240, 80, 20);
		janelaCaracteristicasPersonagem.add(botaoDeletar);
		
		JButton botaoLimpar = new JButton("Limpar");
		botaoLimpar.setBounds(250, 240, 80, 20);
		janelaCaracteristicasPersonagem.add(botaoLimpar);
		
		Caracteristicas caracteristicasPersonagem = new Caracteristicas();
		
		botaoConsultar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				try {
					int id = Integer.parseInt(jTextId.getText());
					String nome = jTextNome.getText();
					
					botaoGravar.setEnabled(true);
					
					int nivel;
					String raca;
					String classe;
					
					if (!caracteristicasPersonagem.consultarCaracteristicas(id, nome)) {
						nivel = 0;
						raca = "";
						classe = "";
						
					}else {
						nivel = caracteristicasPersonagem.getNivel();
						raca = caracteristicasPersonagem.getRaca();
						classe = caracteristicasPersonagem.getClasse();
						
					}
					
					jTextNivel.setText(nivel == 0 ? "" : String.valueOf(nivel));
					jTextNivel.setEnabled(true);
					jTextRaca.setText(raca);
					jTextRaca.setEnabled(true);
					jTextClasse.setText(classe);
					jTextClasse.setEnabled(true);
					
					jTextNivel.requestFocus();
					
					jTextId.setEnabled(false);
					botaoConsultar.setEnabled(false);
					
						
				} catch (Exception erro) {
					JOptionPane.showMessageDialog(janelaCaracteristicasPersonagem,"Preencha os campos id e/ou nome corretamente");
				}
			}
		});
		
		
		botaoGravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resposta = JOptionPane.showConfirmDialog(janelaCaracteristicasPersonagem, "Deseja atualizar?", "Confirmação",
						JOptionPane.YES_NO_OPTION);
				
				if (resposta == JOptionPane.YES_OPTION) {
					
					int id = Integer.parseInt(jTextId.getText());
					String nome = jTextNome.getText().trim();
					int nivel = Integer.parseInt(jTextNivel.getText());
					String raca = jTextRaca.getText().trim();
					String classe = jTextClasse.getText().trim();
					
					
					if (raca.length() == 0 || classe.length() == 0 || nivel == 0 ) {
						JOptionPane.showMessageDialog(janelaCaracteristicasPersonagem, "Todos os campos devem ser preenchidos");
						jTextNivel.requestFocus();
						
					} else {
						if (!caracteristicasPersonagem.consultarCaracteristicas(id, nome)) {
							
							if (!caracteristicasPersonagem.cadastrarCaracteristicas(id, nome, nivel, raca, classe))
								
								JOptionPane.showMessageDialog(janelaCaracteristicasPersonagem, "Erro na inclusão do Personagem!");
							
							else
								JOptionPane.showMessageDialog(janelaCaracteristicasPersonagem, "Inclusão realizada!");
							
						} else {
							
							if (!caracteristicasPersonagem.atualizarCaracteristicas(id, nome, nivel, raca, classe))
								JOptionPane.showMessageDialog(janelaCaracteristicasPersonagem, "Erro na atualização do personagem!");
							else
								JOptionPane.showMessageDialog(janelaCaracteristicasPersonagem, "Alteração realizada!");
						}

					}

				}
			}
		});
		botaoDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resposta = JOptionPane.showConfirmDialog(janelaCaracteristicasPersonagem, "Tem certeza que deseja deletar?", "Confirmação",
						JOptionPane.YES_NO_OPTION);
				
				if (resposta == JOptionPane.YES_OPTION) {
					
					int id = Integer.parseInt(jTextId.getText());

					String nome = jTextNome.getText().trim();
							
							if (!caracteristicasPersonagem.deletarCaracteristicas(id, nome))
								JOptionPane.showMessageDialog(janelaCaracteristicasPersonagem, "Erro ao deletar o personagem!");
							else
								JOptionPane.showMessageDialog(janelaCaracteristicasPersonagem, "Personagem deletado com sucesso!");
						}

					}

				});

		
		botaoLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jTextId.setText("");
				jTextId.setEnabled(true);
				jTextId.requestFocus();
				jTextNome.setText("");
				jTextNome.setEnabled(true);
		
				jTextNivel.setText("");
				jTextNivel.setEnabled(false);
				jTextRaca.setText("");
				jTextRaca.setEnabled(false);
				jTextClasse.setText("");
				jTextClasse.setEnabled(false);				
				
				botaoConsultar.setEnabled(true);
				botaoGravar.setEnabled(false);
			}
		});
		return janelaCaracteristicasPersonagem;
	}
}
