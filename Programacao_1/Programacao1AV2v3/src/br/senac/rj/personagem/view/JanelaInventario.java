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

import br.senac.rj.personagem.modelo.Inventario;

public class JanelaInventario {
	
	public static JFrame criarJanelaInventario() {
		
		JFrame janelaInventario = new JFrame("Atualização dos itens do personagem");
		
		janelaInventario.setResizable(false); 
		janelaInventario.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		janelaInventario.setSize(400, 400); 	
	
		Container caixa = janelaInventario.getContentPane();
		caixa.setLayout(null); 
		
		JLabel labelId_Item = new JLabel("ID Item: ");
		labelId_Item.setBounds(50, 40, 100, 20);
		janelaInventario.add(labelId_Item);
		
		JLabel labelId_Personagem = new JLabel("ID Personagem: ");
		labelId_Personagem.setBounds(50, 80, 100, 20); 
		janelaInventario.add(labelId_Personagem);
		
		JLabel labelNome_Item = new JLabel("Nome Item: ");
		labelNome_Item.setBounds(50, 120, 150, 20); 
		janelaInventario.add(labelNome_Item);
		
		JLabel labelQuantidade_Item = new JLabel("Quantidade: ");
		labelQuantidade_Item.setBounds(50, 160, 100, 20); 
		janelaInventario.add(labelQuantidade_Item);
		
		JLabel labelPeso_Item = new JLabel("Peso: ");
		labelPeso_Item.setBounds(50, 200, 100, 20); 
		janelaInventario.add(labelPeso_Item);
		
		JLabel labelTipo_Item = new JLabel("Tipo: ");
		labelTipo_Item.setBounds(50, 240, 100, 20); 
		janelaInventario.add(labelTipo_Item);
		
		JTextField jTextId_Item = new JTextField();
		jTextId_Item.setEnabled(true);
		jTextId_Item.setBounds(180, 40, 50, 20);
		janelaInventario.add(jTextId_Item);
		
		JTextField jTextId_Personagem = new JTextField();
		jTextId_Personagem.setEnabled(true);
		jTextId_Personagem.setBounds(180, 80, 50, 20);
		janelaInventario.add(jTextId_Personagem);
		
		JTextField jTextNome_Item = new JTextField();
		jTextNome_Item.setEnabled(false);
		jTextNome_Item.setBounds(180, 120, 150, 20);
		janelaInventario.add(jTextNome_Item);
		
		JTextField jTextQuantidade_Item = new JTextField();
		jTextQuantidade_Item.setEnabled(false);
		jTextQuantidade_Item.setBounds(180, 160, 150, 20);
		janelaInventario.add(jTextQuantidade_Item);
		
		JTextField jTextPeso_Item = new JTextField();
		jTextPeso_Item.setEnabled(false);
		jTextPeso_Item.setBounds(180, 200, 150, 20);
		janelaInventario.add(jTextPeso_Item);
		
		JTextField jTextTipo_Item = new JTextField();
		jTextTipo_Item.setEnabled(false);
		jTextTipo_Item.setBounds(180, 240, 150, 20);
		janelaInventario.add(jTextTipo_Item);

		JButton botaoConsultar = new JButton("Consultar");
		botaoConsultar.setBounds(230, 80, 100, 20);
		botaoConsultar.setEnabled(true);
		janelaInventario.add(botaoConsultar);

		JButton botaoGravar = new JButton("Gravar");
		botaoGravar.setBounds(60, 280, 80, 20);
		botaoGravar.setEnabled(false);
		janelaInventario.add(botaoGravar);
		
		JButton botaoDeletar = new JButton("Deletar");
		botaoDeletar.setBounds(155, 280, 80, 20);
		janelaInventario.add(botaoDeletar);
		
		JButton botaoLimpar = new JButton("Limpar");
		botaoLimpar.setBounds(250, 280, 80, 20);
		janelaInventario.add(botaoLimpar);
		
		Inventario inventario = new Inventario();
		
		botaoConsultar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					int id_Item = Integer.parseInt(jTextId_Item.getText());
					int id_Personagem = Integer.parseInt(jTextId_Personagem.getText());;
					
					botaoGravar.setEnabled(true);

					String nome_Item;
					int quantidade_Item;
					float peso_Item;
					String tipo_Item;

					if (!inventario.consultarItem(id_Item, id_Personagem)) {
						nome_Item = "";
						quantidade_Item = 0;
						peso_Item = 0;
						tipo_Item = "";

					}else {
						nome_Item = inventario.getNome_item();
						quantidade_Item = inventario.getQuantidade_item();
						peso_Item = inventario.getPeso_item();
						tipo_Item = inventario.getTipo_item();

					}
					jTextNome_Item.setText(nome_Item);
					jTextNome_Item.setEnabled(true);
					jTextQuantidade_Item.setText(String.valueOf(quantidade_Item));
					jTextQuantidade_Item.setEnabled(true);
					jTextPeso_Item.setText(String.valueOf(peso_Item));
					jTextPeso_Item.setEnabled(true);
					jTextTipo_Item.setText(tipo_Item);
					jTextTipo_Item.setEnabled(true);

					jTextNome_Item.requestFocus();

					jTextId_Item.setEnabled(false);
					jTextId_Personagem.setEnabled(false);

					botaoConsultar.setEnabled(false);
		
				} catch (Exception erro) {
					JOptionPane.showMessageDialog(janelaInventario,"Preencha os campos id do item e id do personagem corretamente");
				}
			}
		});
		
		botaoGravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resposta = JOptionPane.showConfirmDialog(janelaInventario, "Deseja atualizar?", "Confirmação",
						JOptionPane.YES_NO_OPTION);
				
				if (resposta == JOptionPane.YES_OPTION) {
					
					int id_Item = Integer.parseInt(jTextId_Item.getText());
					int id_Personagem = Integer.parseInt(jTextId_Personagem.getText());
					String nome_Item = jTextNome_Item.getText().trim();
					int quantidade_Item = Integer.parseInt(jTextQuantidade_Item.getText());
					float peso_Item = Float.parseFloat(jTextPeso_Item.getText());
					String tipo_Item = jTextTipo_Item.getText().trim();
					
					if (nome_Item.length() == 0 || tipo_Item.length() == 0 || quantidade_Item == 0 || peso_Item == 0) {
						JOptionPane.showMessageDialog(janelaInventario, "Todos os campos devem ser preenchidos");
						jTextNome_Item.requestFocus();
						
					} else {
						if (!inventario.consultarItem(id_Item, id_Personagem)) {
							
							if (!inventario.cadastrarItem(id_Item, id_Personagem, nome_Item, quantidade_Item, peso_Item, tipo_Item))	
								JOptionPane.showMessageDialog(janelaInventario, "Erro na inclusão do item!");
							else
								JOptionPane.showMessageDialog(janelaInventario, "Inclusão realizada!");
						} else {
							if (!inventario.atualizarItem(id_Item, id_Personagem, nome_Item, quantidade_Item, peso_Item, tipo_Item))
								JOptionPane.showMessageDialog(janelaInventario, "Erro na atualização do item!");
							else
								JOptionPane.showMessageDialog(janelaInventario, "Alteração realizada!");
						}

					}

				}
			}
		});
		botaoDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resposta = JOptionPane.showConfirmDialog(janelaInventario, "Tem certeza que deseja deletar?", "Confirmação",
						JOptionPane.YES_NO_OPTION);				
				if (resposta == JOptionPane.YES_OPTION) {
					int id_Item = Integer.parseInt(jTextId_Item.getText());
					int id_Personagem = Integer.parseInt(jTextId_Personagem.getText());
							
							if (!inventario.deletarItem(id_Item, id_Personagem))
								JOptionPane.showMessageDialog(janelaInventario, "Erro ao deletar o item!");
							else
								JOptionPane.showMessageDialog(janelaInventario, "Item deletado com sucesso!");
						}

					}

				});

		
		botaoLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jTextId_Item.setText("");
				jTextId_Item.setEnabled(true);
				jTextId_Item.requestFocus();
				jTextId_Personagem.setText("");
				jTextId_Personagem.setEnabled(true);
		
				jTextNome_Item.setText("");
				jTextNome_Item.setEnabled(false);
				jTextQuantidade_Item.setText("");
				jTextQuantidade_Item.setEnabled(false);
				jTextPeso_Item.setText("");
				jTextPeso_Item.setEnabled(false);
				jTextTipo_Item.setText("");
				jTextTipo_Item.setEnabled(false);

				botaoConsultar.setEnabled(true);
				botaoGravar.setEnabled(false);
			}
		});
		return janelaInventario;
	}
}
