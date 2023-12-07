package br.senac.rj.personagem.view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import br.senac.rj.personagem.modelo.Atributo;

public class JanelaAtributo {
	
	public static JFrame criarJanelaAtributo() {
		
		JFrame janelaAtributos = new JFrame("Atualização de atributo");
		
	
		janelaAtributos.setResizable(false); 
		
		janelaAtributos.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		janelaAtributos.setSize(400, 400); 

		Container caixa = janelaAtributos.getContentPane();
		caixa.setLayout(null);
		
		JLabel labelIdAtributo = new JLabel("ID atributo: ");
		labelIdAtributo.setBounds(50, 40, 100, 20);
		janelaAtributos.add(labelIdAtributo);

		JLabel labelIdPersonagem = new JLabel("ID personagem: ");
		labelIdPersonagem.setBounds(50, 80, 100, 20);
		janelaAtributos.add(labelIdPersonagem);
		
		JLabel labelNome = new JLabel("Nome: ");
		labelNome.setBounds(50, 120, 150, 20); 
		janelaAtributos.add(labelNome);
		
		JLabel labelTipo = new JLabel("Tipo: ");
		labelTipo.setBounds(50, 160, 150, 20); 
		janelaAtributos.add(labelTipo);

		JLabel labelValor = new JLabel("Valor: ");
		labelValor.setBounds(50, 200, 150, 20); 
		janelaAtributos.add(labelValor);

		JLabel labelProficiencia = new JLabel("Proficiencia: ");
		labelProficiencia.setBounds(50, 240, 150, 20); 
		janelaAtributos.add(labelProficiencia);

		
		
		JTextField jTextIdAtributo = new JTextField();
		jTextIdAtributo.setEnabled(true);
		jTextIdAtributo.setBounds(180, 40, 50, 20);
		janelaAtributos.add(jTextIdAtributo);
		
		JTextField jTextIdPersonagem = new JTextField();
		jTextIdPersonagem.setEnabled(true);
		jTextIdPersonagem.setBounds(180, 80, 50, 20);
		janelaAtributos.add(jTextIdPersonagem);
		
		JComboBox<String> dropdownNomes = new JComboBox<>();
		dropdownNomes.setBounds(180, 120, 150, 20);
		dropdownNomes.setEnabled(true);
		dropdownNomes.addItem("Força");
		dropdownNomes.addItem("Agilidade");
		dropdownNomes.addItem("Constituição");
		dropdownNomes.addItem("Carisma");
		dropdownNomes.addItem("Sabedoria");
		dropdownNomes.addItem("Inteligência");
		janelaAtributos.add(dropdownNomes);
		
		JTextField jTextTipo = new JTextField();
		jTextTipo.setEnabled(false);
		jTextTipo.setBounds(180, 160, 150, 20);
		janelaAtributos.add(jTextTipo);
		
		JTextField jTextValor = new JTextField();
		jTextValor.setEnabled(false);
		jTextValor.setBounds(180, 200, 150, 20);
		janelaAtributos.add(jTextValor);

		JTextField jTextProficiencia = new JTextField();
		jTextProficiencia.setEnabled(false);
		jTextProficiencia.setBounds(180, 240, 150, 20);
		janelaAtributos.add(jTextProficiencia);
		
		
		
		JButton botaoConsultar = new JButton("Consultar");
		botaoConsultar.setBounds(230, 80, 100, 20);
		botaoConsultar.setEnabled(true);
		janelaAtributos.add(botaoConsultar);


		JButton botaoGravar = new JButton("Gravar");
		botaoGravar.setBounds(50, 280, 100, 20);
		botaoGravar.setEnabled(false);
		janelaAtributos.add(botaoGravar);
		
		JButton botaoDeletar = new JButton("Deletar");
		botaoDeletar.setBounds(250, 280, 100, 20);
		janelaAtributos.add(botaoDeletar);
		
		JButton botaoLimpar = new JButton("Limpar");
		botaoLimpar.setBounds(150, 280, 100, 20);
		janelaAtributos.add(botaoLimpar);
		
		Atributo atributo = new Atributo();
		
		botaoConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int idAtributo = Integer.parseInt(jTextIdAtributo.getText());
					int idPersonagem = Integer.parseInt(jTextIdPersonagem.getText());
							
					botaoGravar.setEnabled(true);			
					
					String nome;
					String tipo;
					String valor;
					String proficiencia;
					
					if (!atributo.consultarAtributo(idAtributo, idPersonagem)) {
						nome = "";
						tipo = "";
						valor = "";
						proficiencia = "";
						
					} else {
						nome = atributo.getNome();
						tipo = atributo.getTipo();
						valor = atributo.getValor();
						proficiencia = atributo.getProficiencia();
						
					}
						
					dropdownNomes.setEnabled(true);
					jTextTipo.setText(tipo);
					jTextTipo.setEnabled(true);
					jTextValor.setText(valor);
					jTextValor.setEnabled(true);
					jTextProficiencia.setText(proficiencia);
					jTextProficiencia.setEnabled(true);
					
					dropdownNomes.requestFocus();
					jTextTipo.requestFocus();
					jTextValor.requestFocus();
					jTextProficiencia.requestFocus();
					
					jTextIdAtributo.setEnabled(false);
					jTextIdPersonagem.setEnabled(false);
					botaoConsultar.setEnabled(false);			

				} catch (Exception erro) {
					JOptionPane.showMessageDialog(janelaAtributos,
							"Preencha os campos ID atributo e ID personagem corretamente");
				}
			}
		});
		
		
		botaoGravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resposta = JOptionPane.showConfirmDialog(janelaAtributos, "Deseja atualizar?", "Confirmação",
						JOptionPane.YES_NO_OPTION);
				
				if (resposta == JOptionPane.YES_OPTION) {
					
					int idAtributo = Integer.parseInt(jTextIdAtributo.getText());
					int idPersonagem = Integer.parseInt(jTextIdPersonagem.getText());
					String nome = (String) dropdownNomes.getSelectedItem();
					String tipo = jTextTipo.getText().trim();
					String valor = jTextValor.getText().trim();
					String proficiencia = jTextProficiencia.getText().trim();
					
					if (nome.length() == 0 || tipo.length() == 0 || valor.length() == 0 || proficiencia.length() == 0) {
						JOptionPane.showMessageDialog(janelaAtributos, "Todos os campos devem ser preenchidos");
						dropdownNomes.requestFocus();
						jTextTipo.requestFocus();
						jTextValor.requestFocus();
						jTextProficiencia.requestFocus();
						
					} else {
						if (!atributo.consultarAtributo(idAtributo, idPersonagem)) {
							
							if (!atributo.cadastrarAtributo(idAtributo, idPersonagem, nome, tipo, valor, proficiencia))
								
								JOptionPane.showMessageDialog(janelaAtributos, "Erro na inclusão do atributo, verificar se o personagem existe!");
							
							else
								JOptionPane.showMessageDialog(janelaAtributos, "Inclusão realizada!");
							
						} else {
							
							if (!atributo.atualizarAtributo(idAtributo, idPersonagem, nome, tipo, valor, proficiencia))
								JOptionPane.showMessageDialog(janelaAtributos, "Erro na atualização do usuário!");
							else
								JOptionPane.showMessageDialog(janelaAtributos, "Alteração realizada!");
						}

					}

				}
			}
		});
		
		botaoDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resposta = JOptionPane.showConfirmDialog(janelaAtributos, "Tem certeza que deseja deletar?", "Confirmação",
						JOptionPane.YES_NO_OPTION);
				
				if (resposta == JOptionPane.YES_OPTION) {
					
					int idAtributo = Integer.parseInt(jTextIdAtributo.getText());

					int idPersonagem = Integer.parseInt(jTextIdPersonagem.getText());
							
							if (!atributo.deletarAtributo(idAtributo, idPersonagem))
								JOptionPane.showMessageDialog(janelaAtributos, "Erro ao deletar o atributo!");
							else
								JOptionPane.showMessageDialog(janelaAtributos, "Atributo deletado com sucesso!");
						}

					}

				});
		
		botaoLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jTextIdAtributo.setText("");
				jTextIdAtributo.setEnabled(true);
				jTextIdAtributo.requestFocus();
				jTextIdPersonagem.setText("");
				jTextIdPersonagem.setEnabled(true);
				jTextIdPersonagem.requestFocus();
				
		
				//jTextNome.setText("");
				dropdownNomes.setEnabled(false);
				jTextTipo.setText("");
				jTextTipo.setEnabled(false);
				jTextValor.setText("");
				jTextValor.setEnabled(false);
				jTextProficiencia.setText("");
				jTextProficiencia.setEnabled(false);		
				
				botaoConsultar.setEnabled(true);
				botaoGravar.setEnabled(false);
			}
		});
		return janelaAtributos;
	}
}
