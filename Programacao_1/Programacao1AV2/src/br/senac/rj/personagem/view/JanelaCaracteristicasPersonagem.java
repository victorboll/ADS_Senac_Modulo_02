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
	//Cria a classe que vai permitir instanciar a janela de atualização de usuário
	
	public static JFrame criarJanelaCaracteristicasPersonagem() {
		// Método da classe JanelaUsuario que cria a janela
		
		JFrame janelaCaracteristicasPersonagem = new JFrame("Atualização de características do personagem");
		// Instaciação do objeto JFrame na variável janelaConta, que vai poder instanciar os métodos da classe JFrame
		//O parâmetro é a mensagem que aparece na parter superior da tela, como
		//<title>Document<title> no HTML
		
		
		janelaCaracteristicasPersonagem.setResizable(false); 
		// A janela não poderá ter o tamanho ajustado
		janelaCaracteristicasPersonagem.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		//Fecha somente a janelaUsuario, olhar Slide 220 para mais opções de fechamento
		janelaCaracteristicasPersonagem.setSize(400, 400); 
		// Define tamanho da janela (largura, altura)
		
	
		Container caixa = janelaCaracteristicasPersonagem.getContentPane();
		// Define o layout da janela efetivamente, todos os componentes que vão aparecer ficam nessa caixa
		caixa.setLayout(null); // Fica como null para você colocar os campos onde você quiser
		// Define os labels dos campos
		

		JLabel labelId = new JLabel("ID: ");
		labelId.setBounds(50, 40, 100, 20);
		janelaCaracteristicasPersonagem.add(labelId);
		// Define um componente texto (lable - rótulo) onde vai aparecer o texto que está no parâmetro
		// Posição e tamanho do lable janela quando adicionado: coluna(x), linha(y), largura(x), tamanho(y)
		// Adiciona a JanelaUsuario o lable CPF
		
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
		// Define uma input box que vai receber algum dado do usuário
		// Define se o input box estará ativo para ser editado pelo usuário
		// Posição e tamanho do input box quando adicionado: coluna(x), linha(y), largura(x), tamanho(y)
		// Adiciona o input box na janela
		
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
		// Define um componente botão (lable - rótulo) onde vai aparecer o texto que está no parâmetro
		// Posição e tamanho do botão quando adicionado: coluna(x), linha(y), largura(x), tamanho(y)
		// Define se o botão estará ativo para ser utilizado pelo usuário, por default é true
		// Adiciona o botão a JanelaUsuario


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
		// Instancia um objeto Usuario para atrelar os botões criados acima, a métodos da classe Usuario
		
		
		botaoConsultar.addActionListener(new ActionListener() {
		//Pega um objeto do topo botão e chama o método que faz com que ele aguarde uma ação do usuário
		//Cria um objeto do tipo ActionListener de uma classe anônima. Esse ActionListener é uma interface
		//e não uma classe em si, então agora o botaoConsulta passa a ser um objeto da classe JButton, e de
		//certa forma da interface ActionListener também
			public void actionPerformed(ActionEvent e) {
			//Método da interface ActionListener que está sendo implementado no objeto Jbutton
				try {
					int id = Integer.parseInt(jTextId.getText());
					//pega o valor que foi colocado na input box jTextCPF
					String nome = jTextNome.getText();
					
					
					botaoGravar.setEnabled(true);
					//Uma vez que os dados sejam preenchidos, permite que o botão gravar seja utilizado
					
					int nivel;
					String raca;
					String classe;
					//Aqui se declara as duas variáveis que vão preencher os campos email e endereco quando a consulta for realizada
					
					if (!caracteristicasPersonagem.consultarCaracteristicas(id, nome)) {
						nivel = 0;
						raca = "";
						classe = "";
						//Se consultarUsuario retornar false, ele vai deixar os dois valores em branco
						
					}else {
						nivel = caracteristicasPersonagem.getNivel();
						raca = caracteristicasPersonagem.getRaca();
						classe = caracteristicasPersonagem.getClasse();
						//Se a consulta retornar true, ela popula o objeto, e os métodos get retornam
						//o email e a senha encontrados para as variáveis
						
					}
					
					jTextNivel.setText(nivel == 0 ? "" : String.valueOf(nivel));
					jTextNivel.setEnabled(true);
					jTextRaca.setText(raca);
					jTextRaca.setEnabled(true);
					jTextClasse.setText(classe);
					jTextClasse.setEnabled(true);
					//Os input box para email e endereco sao populados com os valores das variaveis e ficam disponíveis para edição 
					
					jTextNivel.requestFocus();
					//Coloca o cursor no campo Email para que ele possa ser editado sem a necessidade de ser selecionado
					
					jTextId.setEnabled(false);
					//jTextNome.setEnabled(false);
					botaoConsultar.setEnabled(false);
					//Os campos para CPF e nome são desabilitados, assim como o botão de consultar
					
						
				} catch (Exception erro) {
					JOptionPane.showMessageDialog(janelaCaracteristicasPersonagem,"Preencha os campos id e/ou nome corretamente");
					//Caso alguma execption ocorra durante o processo acima, ele retorna um pop up com essa mensagem
				}
			}
		});
		
		
		botaoGravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resposta = JOptionPane.showConfirmDialog(janelaCaracteristicasPersonagem, "Deseja atualizar?", "Confirmação",
						JOptionPane.YES_NO_OPTION);
				//Faz aparecer um popup com a mensagem no parâmetro que tem um botão de sim e um de não.
				
				if (resposta == JOptionPane.YES_OPTION) {
				//Se a resposta for sim para atualizar, realizasse o código abaixo
					
					int id = Integer.parseInt(jTextId.getText());
					//Guarda na variável cpf o valor que está no campo jTextCPF depois de tirar os espaços em branco
					String nome = jTextNome.getText().trim();
					int nivel = Integer.parseInt(jTextNivel.getText());
					String raca = jTextRaca.getText().trim();
					String classe = jTextClasse.getText().trim();
					
					
					if (raca.length() == 0 || classe.length() == 0 || nivel == 0 ) {
						JOptionPane.showMessageDialog(janelaCaracteristicasPersonagem, "Todos os campos devem ser preenchidos");
						jTextNivel.requestFocus();
						//Ele verifica se, depois do trim, algum dos dois campos está vazio, e pede para ser preenchido se estiver
						
					} else {
						if (!caracteristicasPersonagem.consultarCaracteristicas(id, nome)) {
							//Ele varifica se o método consultar usuário está retornando com sucesso
							//Se o método retornar false, ele vai fazer a inclusão de um novo usuário
							
							if (!caracteristicasPersonagem.cadastrarCaracteristicas(id, nome, nivel, raca, classe))
								//Aqui ele verifica se o método cadastrarUsuario retorna true
								
								JOptionPane.showMessageDialog(janelaCaracteristicasPersonagem, "Erro na inclusão do Personagem!");
								//Caso não, com um pop up, ele afirma que houve um erro ao inserir os dados
							
							else
								JOptionPane.showMessageDialog(janelaCaracteristicasPersonagem, "Inclusão realizada!");
								//Caso retorne true, ele retorna um pop-up informando que o usuário foi incluido com sucesso
							
						} else {
							//Se o método de consultar usuário retorna true, é porque o usuário já existe, então ele
							//não será incluido, mas sim atualizado
							
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
				//Faz aparecer um popup com a mensagem no parâmetro que tem um botão de sim e um de não.
				
				if (resposta == JOptionPane.YES_OPTION) {
				//Se a resposta for sim para atualizar, realizasse o código abaixo
					
					int id = Integer.parseInt(jTextId.getText());
					//Guarda na variável cpf o valor que está no campo jTextCPF depois de tirar os espaços em branco
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
				jTextId.requestFocus(); // Colocar o foco no campo Id
				jTextNome.setText("");
				jTextNome.setEnabled(true);
				// Limpa o campo cpf e nome para que uma nova consulta seja feita, e permite que eles possam ser editados novamente
				
		
				jTextNivel.setText("");
				jTextNivel.setEnabled(false);
				jTextRaca.setText("");
				jTextRaca.setEnabled(false);
				jTextClasse.setText("");
				jTextClasse.setEnabled(false);
				//Limpa o campo email e endereco, e os desativa os campos email e endereco
				
				
				botaoConsultar.setEnabled(true);
				botaoGravar.setEnabled(false);
				//Ativa o botão Consultar e desativa o botão Gravar
			}
		});
		return janelaCaracteristicasPersonagem;
		//Retorna um objeto janelaUsuario com todas as modificações que foram feitas
	}
}
