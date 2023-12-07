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

import br.senac.rj.personagem.modelo.Magias;

public class JanelaMagias {
	
	public static JFrame criarJanelaMagias() {
		
		JFrame janelaMagias = new JFrame("Atualização das magias do personagem");
		
		janelaMagias.setResizable(false); 
		janelaMagias.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		janelaMagias.setSize(400, 400); 	
	
		Container caixa = janelaMagias.getContentPane();
		caixa.setLayout(null); 
		
		JLabel labelId_Magia = new JLabel("ID: ");
		labelId_Magia.setBounds(50, 40, 100, 20);
		janelaMagias.add(labelId_Magia);
		
		JLabel labelId_Personagem = new JLabel("ID Personagem: ");
		labelId_Personagem.setBounds(50, 80, 100, 20); 
		janelaMagias.add(labelId_Personagem);
		
		JLabel labelNome_Magia = new JLabel("Nome: ");
		labelNome_Magia.setBounds(50, 120, 150, 20); 
		janelaMagias.add(labelNome_Magia);
		
		JLabel labelTipo_Magia = new JLabel("Tipo: ");
		labelTipo_Magia.setBounds(50, 160, 100, 20); 
		janelaMagias.add(labelTipo_Magia);
		
		JLabel labelNivel_Magia = new JLabel("Nível: ");
		labelNivel_Magia.setBounds(50, 200, 100, 20); 
		janelaMagias.add(labelNivel_Magia);
		
		JLabel labelEscola_Magia = new JLabel("Escola: ");
		labelEscola_Magia.setBounds(50, 240, 100, 20); 
		janelaMagias.add(labelEscola_Magia);
		
		JTextField jTextId_Magia = new JTextField();
		jTextId_Magia.setEnabled(true);
		jTextId_Magia.setBounds(180, 40, 50, 20);
		janelaMagias.add(jTextId_Magia);
		
		JTextField jTextId_Personagem = new JTextField();
		jTextId_Personagem.setEnabled(true);
		jTextId_Personagem.setBounds(180, 80, 50, 20);
		janelaMagias.add(jTextId_Personagem);
		
		JTextField jTextNome_Magia = new JTextField();
		jTextNome_Magia.setEnabled(false);
		jTextNome_Magia.setBounds(180, 120, 150, 20);
		janelaMagias.add(jTextNome_Magia);
		
		JTextField jTextTipo_Magia = new JTextField();
		jTextTipo_Magia.setEnabled(false);
		jTextTipo_Magia.setBounds(180, 160, 150, 20);
		janelaMagias.add(jTextTipo_Magia);
		
		JTextField jTextNivel_Magia = new JTextField();
		jTextNivel_Magia.setEnabled(false);
		jTextNivel_Magia.setBounds(180, 200, 150, 20);
		janelaMagias.add(jTextNivel_Magia);
		
		JTextField jTextEscola_Magia = new JTextField();
		jTextEscola_Magia.setEnabled(false);
		jTextEscola_Magia.setBounds(180, 240, 150, 20);
		janelaMagias.add(jTextEscola_Magia);

		JButton botaoConsultar = new JButton("Consultar");
		botaoConsultar.setBounds(230, 80, 100, 20);
		botaoConsultar.setEnabled(true);
		janelaMagias.add(botaoConsultar);

		JButton botaoGravar = new JButton("Gravar");
		botaoGravar.setBounds(60, 280, 80, 20);
		botaoGravar.setEnabled(false);
		janelaMagias.add(botaoGravar);
		
		JButton botaoDeletar = new JButton("Deletar");
		botaoDeletar.setBounds(155, 280, 80, 20);
		janelaMagias.add(botaoDeletar);
		
		JButton botaoLimpar = new JButton("Limpar");
		botaoLimpar.setBounds(250, 280, 80, 20);
		janelaMagias.add(botaoLimpar);
		
		Magias magias = new Magias();
		
		botaoConsultar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					int id_Magia = Integer.parseInt(jTextId_Magia.getText());
					int id_Personagem = Integer.parseInt(jTextId_Personagem.getText());;
					
					botaoGravar.setEnabled(true);

					String nome_Magia;
					String tipo_Magia;
					int nivel_Magia;
					String escola_magia;

					if (!magias.consultarMagia(id_Magia, id_Personagem)) {
						nome_Magia = "";
						tipo_Magia = "";
						nivel_Magia = 0;
						escola_magia = "";

					}else {
						nome_Magia = magias.getNome_magia();
						tipo_Magia = magias.getTipo_magia();
						nivel_Magia = magias.getNivel_magia();
						escola_magia = magias.getEscola_magia();

					}
					jTextNome_Magia.setText(nome_Magia);
					jTextNome_Magia.setEnabled(true);
					jTextTipo_Magia.setText(tipo_Magia);
					jTextTipo_Magia.setEnabled(true);
					jTextNivel_Magia.setText(nivel_Magia == 0 ? "" : String.valueOf(nivel_Magia));
					jTextNivel_Magia.setEnabled(true);
					jTextEscola_Magia.setText(escola_magia);
					jTextEscola_Magia.setEnabled(true);

					jTextNome_Magia.requestFocus();

					jTextId_Magia.setEnabled(false);
					jTextId_Personagem.setEnabled(false);

					botaoConsultar.setEnabled(false);
		
				} catch (Exception erro) {
					JOptionPane.showMessageDialog(janelaMagias,"Preencha os campos id e id_personagem corretamente");
				}
			}
		});
		
		botaoGravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resposta = JOptionPane.showConfirmDialog(janelaMagias, "Deseja atualizar?", "Confirmação",
						JOptionPane.YES_NO_OPTION);
				
				if (resposta == JOptionPane.YES_OPTION) {
					
					int id_Magia = Integer.parseInt(jTextId_Magia.getText());
					int id_Personagem = Integer.parseInt(jTextId_Personagem.getText());
					String nome_Magia = jTextNome_Magia.getText().trim();
					String tipo_Magia = jTextTipo_Magia.getText().trim();
					int nivel_Magia = Integer.parseInt(jTextNivel_Magia.getText());
					String escola_magia = jTextEscola_Magia.getText().trim();
					
					if (nome_Magia.length() == 0 || tipo_Magia.length() == 0 || nivel_Magia == 0 || escola_magia.length() == 0) {
						JOptionPane.showMessageDialog(janelaMagias, "Todos os campos devem ser preenchidos");
						jTextNome_Magia.requestFocus();
						
					} else {
						if (!magias.consultarMagia(id_Magia, id_Personagem)) {
							
							if (!magias.cadastrarMagia(id_Magia, id_Personagem, nome_Magia, tipo_Magia, nivel_Magia, escola_magia))	
								JOptionPane.showMessageDialog(janelaMagias, "Erro na inclusão da magia!");
							else
								JOptionPane.showMessageDialog(janelaMagias, "Inclusão realizada!");
						} else {
							if (!magias.atualizarMagia(id_Magia, id_Personagem, nome_Magia, tipo_Magia, nivel_Magia, escola_magia))
								JOptionPane.showMessageDialog(janelaMagias, "Erro na atualização da magia!");
							else
								JOptionPane.showMessageDialog(janelaMagias, "Alteração realizada!");
						}

					}

				}
			}
		});
		botaoDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resposta = JOptionPane.showConfirmDialog(janelaMagias, "Tem certeza que deseja deletar?", "Confirmação",
						JOptionPane.YES_NO_OPTION);				
				if (resposta == JOptionPane.YES_OPTION) {
					int id_Magia = Integer.parseInt(jTextId_Magia.getText());
					int id_Personagem = Integer.parseInt(jTextId_Personagem.getText());
							
							if (!magias.deletarMagia(id_Magia, id_Personagem))
								JOptionPane.showMessageDialog(janelaMagias, "Erro ao deletar a magia!");
							else
								JOptionPane.showMessageDialog(janelaMagias, "Magia deletada com sucesso!");
						}

					}

				});

		
		botaoLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jTextId_Magia.setText("");
				jTextId_Magia.setEnabled(true);
				jTextId_Magia.requestFocus();
				jTextId_Personagem.setText("");
				jTextId_Personagem.setEnabled(true);
		
				jTextNome_Magia.setText("");
				jTextNome_Magia.setEnabled(false);
				jTextTipo_Magia.setText("");
				jTextTipo_Magia.setEnabled(false);
				jTextNivel_Magia.setText("");
				jTextNivel_Magia.setEnabled(false);
				jTextEscola_Magia.setText("");
				jTextEscola_Magia.setEnabled(false);

				botaoConsultar.setEnabled(true);
				botaoGravar.setEnabled(false);
			}
		});
		return janelaMagias;
	}
}
