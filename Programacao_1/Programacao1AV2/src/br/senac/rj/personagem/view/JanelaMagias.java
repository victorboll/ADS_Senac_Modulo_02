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
	//Cria a classe que vai permitir instanciar a janela de atualização de usuário
	
	public static JFrame criarJanelaMagias() {
		// Método da classe JanelaUsuario que cria a janela
		
		JFrame janelaMagias = new JFrame("Atualização das magias do personagem");
		// Instaciação do objeto JFrame na variável janelaConta, que vai poder instanciar os métodos da classe JFrame
		//O parâmetro é a mensagem que aparece na parter superior da tela, como
		//<title>Document<title> no HTML
		
		
		janelaMagias.setResizable(false); 
		// A janela não poderá ter o tamanho ajustado
		janelaMagias.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		//Fecha somente a janelaUsuario, olhar Slide 220 para mais opções de fechamento
		janelaMagias.setSize(400, 400); 
		// Define tamanho da janela (largura, altura)
		
	
		Container caixa = janelaMagias.getContentPane();
		// Define o layout da janela efetivamente, todos os componentes que vão aparecer ficam nessa caixa
		caixa.setLayout(null); // Fica como null para você colocar os campos onde você quiser
		// Define os labels dos campos
		

		JLabel labelId_Magia = new JLabel("ID: ");
		labelId_Magia.setBounds(50, 40, 100, 20);
		janelaMagias.add(labelId_Magia);
		// Define um componente texto (lable - rótulo) onde vai aparecer o texto que está no parâmetro
		// Posição e tamanho do lable janela quando adicionado: coluna(x), linha(y), largura(x), tamanho(y)
		// Adiciona a JanelaUsuario o lable CPF
		
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
		// Define uma input box que vai receber algum dado do usuário
		// Define se o input box estará ativo para ser editado pelo usuário
		// Posição e tamanho do input box quando adicionado: coluna(x), linha(y), largura(x), tamanho(y)
		// Adiciona o input box na janela
		
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
		// Define um componente botão (lable - rótulo) onde vai aparecer o texto que está no parâmetro
		// Posição e tamanho do botão quando adicionado: coluna(x), linha(y), largura(x), tamanho(y)
		// Define se o botão estará ativo para ser utilizado pelo usuário, por default é true
		// Adiciona o botão a JanelaUsuario


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
		
		
		
		Magias Magias = new Magias();
		// Instancia um objeto Usuario para atrelar os botões criados acima, a métodos da classe Usuario
		
		
		botaoConsultar.addActionListener(new ActionListener() {
		//Pega um objeto do topo botão e chama o método que faz com que ele aguarde uma ação do usuário
		//Cria um objeto do tipo ActionListener de uma classe anônima. Esse ActionListener é uma interface
		//e não uma classe em si, então agora o botaoConsulta passa a ser um objeto da classe JButton, e de
		//certa forma da interface ActionListener também
			public void actionPerformed(ActionEvent e) {
			//Método da interface ActionListener que está sendo implementado no objeto Jbutton
				try {
					int id_Magia = Integer.parseInt(jTextId_Magia.getText());
					//pega o valor que foi colocado na input box jTextCPF
					int id_Personagem = Integer.parseInt(jTextId_Personagem.getText());;
					
					
					botaoGravar.setEnabled(true);
					//Uma vez que os dados sejam preenchidos, permite que o botão gravar seja utilizado
					
					String nome_Magia;
					String tipo_Magia;
					int nivel_Magia;
					String escola_magia;
					//Aqui se declara as duas variáveis que vão preencher os campos email e endereco quando a consulta for realizada
					
					if (!Magias.consultarMagia(id_Magia, id_Personagem)) {
						nome_Magia = "";
						tipo_Magia = "";
						nivel_Magia = 0;
						escola_magia = "";
						//Se consultarUsuario retornar false, ele vai deixar os dois valores em branco
						
					}else {
						nome_Magia = Magias.getNome_magia();
						tipo_Magia = Magias.getTipo_magia();
						nivel_Magia = Magias.getNivel_magia();
						escola_magia = Magias.getEscola_magia();
						//Se a consulta retornar true, ela popula o objeto, e os métodos get retornam
						//o email e a senha encontrados para as variáveis
						
					}
					
					jTextNome_Magia.setText(nome_Magia);
					jTextNome_Magia.setEnabled(true);
					jTextTipo_Magia.setText(tipo_Magia);
					jTextTipo_Magia.setEnabled(true);
					jTextNivel_Magia.setText(nivel_Magia == 0 ? "" : String.valueOf(nivel_Magia));
					jTextNivel_Magia.setEnabled(true);
					jTextEscola_Magia.setText(escola_magia);
					jTextEscola_Magia.setEnabled(true);
					//Os input box para email e endereco sao populados com os valores das variaveis e ficam disponíveis para edição 
					
					jTextNome_Magia.requestFocus();
					//Coloca o cursor no campo Email para que ele possa ser editado sem a necessidade de ser selecionado
					
					jTextId_Magia.setEnabled(false);
					jTextId_Personagem.setEnabled(false);
					//jTextNome.setEnabled(false);
					botaoConsultar.setEnabled(false);
					//Os campos para CPF e nome são desabilitados, assim como o botão de consultar
					
						
				} catch (Exception erro) {
					JOptionPane.showMessageDialog(janelaMagias,"Preencha os campos id e id_personagem corretamente");
					//Caso alguma execption ocorra durante o processo acima, ele retorna um pop up com essa mensagem
				}
			}
		});
		
		
		botaoGravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resposta = JOptionPane.showConfirmDialog(janelaMagias, "Deseja atualizar?", "Confirmação",
						JOptionPane.YES_NO_OPTION);
				//Faz aparecer um popup com a mensagem no parâmetro que tem um botão de sim e um de não.
				
				if (resposta == JOptionPane.YES_OPTION) {
				//Se a resposta for sim para atualizar, realizasse o código abaixo
					
					int id_Magia = Integer.parseInt(jTextId_Magia.getText());
					//Guarda na variável cpf o valor que está no campo jTextCPF depois de tirar os espaços em branco
					int id_Personagem = Integer.parseInt(jTextId_Personagem.getText());
					String nome_Magia = jTextNome_Magia.getText().trim();
					String tipo_Magia = jTextTipo_Magia.getText().trim();
					int nivel_Magia = Integer.parseInt(jTextNivel_Magia.getText());
					String escola_magia = jTextEscola_Magia.getText().trim();
					
					
					if (nome_Magia.length() == 0 || tipo_Magia.length() == 0 || nivel_Magia == 0 || escola_magia.length() == 0) {
						JOptionPane.showMessageDialog(janelaMagias, "Todos os campos devem ser preenchidos");
						jTextNome_Magia.requestFocus();
						//Ele verifica se, depois do trim, algum dos dois campos está vazio, e pede para ser preenchido se estiver
						
					} else {
						if (!Magias.consultarMagia(id_Magia, id_Personagem)) {
							//Ele varifica se o método consultar usuário está retornando com sucesso
							//Se o método retornar false, ele vai fazer a inclusão de um novo usuário
							
							if (!Magias.cadastrarMagia(id_Magia, id_Personagem, nome_Magia, tipo_Magia, nivel_Magia, escola_magia))
								//Aqui ele verifica se o método cadastrarUsuario retorna true
								
								JOptionPane.showMessageDialog(janelaMagias, "Erro na inclusão da magia!");
								//Caso não, com um pop up, ele afirma que houve um erro ao inserir os dados
							
							else
								JOptionPane.showMessageDialog(janelaMagias, "Inclusão realizada!");
								//Caso retorne true, ele retorna um pop-up informando que o usuário foi incluido com sucesso
							
						} else {
							//Se o método de consultar usuário retorna true, é porque o usuário já existe, então ele
							//não será incluido, mas sim atualizado
							
							if (!Magias.atualizarMagia(id_Magia, id_Personagem, nome_Magia, tipo_Magia, nivel_Magia, escola_magia))
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
				//Faz aparecer um popup com a mensagem no parâmetro que tem um botão de sim e um de não.
				
				if (resposta == JOptionPane.YES_OPTION) {
				//Se a resposta for sim para atualizar, realizasse o código abaixo
					
					int id_Magia = Integer.parseInt(jTextId_Magia.getText());
					//Guarda na variável cpf o valor que está no campo jTextCPF depois de tirar os espaços em branco
					int id_Personagem = Integer.parseInt(jTextId_Personagem.getText());
							
							if (!Magias.deletarMagia(id_Magia, id_Personagem))
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
				jTextId_Magia.requestFocus(); // Colocar o foco no campo Id
				jTextId_Personagem.setText("");
				jTextId_Personagem.setEnabled(true);
				// Limpa o campo cpf e nome para que uma nova consulta seja feita, e permite que eles possam ser editados novamente
				
		
				jTextNome_Magia.setText("");
				jTextNome_Magia.setEnabled(false);
				jTextTipo_Magia.setText("");
				jTextTipo_Magia.setEnabled(false);
				jTextNivel_Magia.setText("");
				jTextNivel_Magia.setEnabled(false);
				jTextEscola_Magia.setText("");
				jTextEscola_Magia.setEnabled(false);
				//Limpa o campo email e endereco, e os desativa os campos email e endereco
				
				
				botaoConsultar.setEnabled(true);
				botaoGravar.setEnabled(false);
				//Ativa o botão Consultar e desativa o botão Gravar
			}
		});
		return janelaMagias;
		//Retorna um objeto janelaUsuario com todas as modificações que foram feitas
	}
}
