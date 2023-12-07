package br.senac.rj.view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import br.senac.rj.modelo.Atributo;

public class JanelaAtributo {
	//Cria a classe que vai permitir instanciar a janela de atualização
	
	public static JFrame criarJanelaAtributo() {
		// Método da classe JanelaUsuario que cria a janela
		
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
		
		JTextField jTextNome = new JTextField();
		jTextNome.setEnabled(false);
		jTextNome.setBounds(180, 120, 150, 20);
		janelaAtributos.add(jTextNome);
		
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
		// Instancia um objeto Usuario para atrelar os botões criados acima, a métodos da classe Usuario
		
		
		botaoConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String idAtributo = jTextIdAtributo.getText();
					String idPersonagem = jTextIdPersonagem.getText();
					
					
					botaoGravar.setEnabled(true);
					//Uma vez que os dados sejam preenchidos, permite que o botão gravar seja utilizado
					
					
					String nome;
					String tipo;
					String valor;
					String proficiencia;
					//Aqui se declara as duas variáveis que vão preencher os campos email e endereco quando a consulta for realizada
					
					if (!atributo.consultarAtributo(idAtributo, idPersonagem)) {
						nome = "";
						tipo = "";
						valor = "";
						proficiencia = "";
						//Se consultarUsuario retornar false, ele vai deixar os dois valores em branco
						
					} else {
						nome = atributo.getNome();
						tipo = atributo.getTipo();
						valor = atributo.getValor();
						proficiencia = atributo.getProficiencia();
						
					}
						
					jTextNome.setText(nome);
					jTextNome.setEnabled(true);
					jTextTipo.setText(tipo);
					jTextTipo.setEnabled(true);
					jTextValor.setText(valor);
					jTextValor.setEnabled(true);
					jTextProficiencia.setText(proficiencia);
					jTextProficiencia.setEnabled(true);
					//Os input box para email e endereco sao populados com os valores das variaveis e ficam disponíveis para edição 
					
					jTextNome.requestFocus();
					jTextTipo.requestFocus();
					jTextValor.requestFocus();
					jTextProficiencia.requestFocus();
					//Coloca o cursor no campo Email para que ele possa ser editado sem a necessidade de ser selecionado
					
					jTextIdAtributo.setEnabled(false);
					jTextIdPersonagem.setEnabled(false);
					botaoConsultar.setEnabled(false);
					//Os campos para CPF e nome são desabilitados, assim como o botão de consultar
					

				} catch (Exception erro) {
					JOptionPane.showMessageDialog(janelaAtributos,
							"Preencha os campos ID atributo e ID personagem corretamente");
					//Caso alguma execption ocorra durante o processo acima, ele retorna um pop up com essa mensagem
				}
			}
		});
		
		
		botaoGravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resposta = JOptionPane.showConfirmDialog(janelaAtributos, "Deseja atualizar?", "Confirmação",
						JOptionPane.YES_NO_OPTION);
				//Faz aparecer um popup com a mensagem no parâmetro que tem um botão de sim e um de não.
				
				if (resposta == JOptionPane.YES_OPTION) {
				//Se a resposta for sim para atualizar, realizasse o código abaixo
					
					String idAtributo = jTextIdAtributo.getText().trim();
					String idPersonagem = jTextIdPersonagem.getText().trim();
					String nome = jTextNome.getText().trim();
					String tipo = jTextTipo.getText().trim();
					String valor = jTextValor.getText().trim();
					String proficiencia = jTextProficiencia.getText().trim();
					
					if (nome.length() == 0 || tipo.length() == 0 || valor.length() == 0 || proficiencia.length() == 0) {
						JOptionPane.showMessageDialog(janelaAtributos, "Todos os campos devem ser preenchidos");
						jTextNome.requestFocus();
						jTextTipo.requestFocus();
						jTextValor.requestFocus();
						jTextProficiencia.requestFocus();
						
					} else {
						if (!atributo.consultarAtributo(idAtributo, idPersonagem)) {
							//Ele varifica se o método consultar usuário está retornando com sucesso
							//Se o método retornar false, ele vai fazer a inclusão de um novo usuário
							
							if (!atributo.cadastrarAtributo(idAtributo, idPersonagem, nome, tipo, valor, proficiencia))
								//Aqui ele verifica se o método cadastrarUsuario retorna true
								
								JOptionPane.showMessageDialog(janelaAtributos, "Erro na inclusão do titular!");
								//Caso não, com um pop up, ele afirma que houve um erro ao inserir os dados
							
							else
								JOptionPane.showMessageDialog(janelaAtributos, "Inclusão realizada!");
								//Caso retorne true, ele retorna um pop-up informando que o usuário foi incluido com sucesso
							
						} else {
							//Se o método de consultar usuário retorna true, é porque o usuário já existe, então ele
							//não será incluido, mas sim atualizado
							
							if (!atributo.atualizarAtributo(idAtributo, idPersonagem, nome, tipo, valor, proficiencia))
								JOptionPane.showMessageDialog(janelaAtributos, "Erro na atualização do usuário!");
							else
								JOptionPane.showMessageDialog(janelaAtributos, "Alteração realizada!");
						}

					}

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
				
		
				jTextNome.setText("");
				jTextNome.setEnabled(false);
				jTextTipo.setText("");
				jTextTipo.setEnabled(false);
				jTextValor.setText("");
				jTextValor.setEnabled(false);
				jTextProficiencia.setText("");
				jTextProficiencia.setEnabled(false);
				//Limpa o campo email e endereco, e os desativa os campos email e endereco
				
				
				botaoConsultar.setEnabled(true);
				botaoGravar.setEnabled(false);
				//Ativa o botão Consultar e desativa o botão Gravar
			}
		});
		return janelaAtributos;
		//Retorna um objeto janelaUsuario com todas as modificações que foram feitas
	}
}
