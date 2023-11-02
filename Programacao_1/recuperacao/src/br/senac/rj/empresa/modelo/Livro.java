package br.senac.rj.empresa.modelo;

		public class Livro {
			private int codLivro;
			private String descLivro;
			private int qtdeDisponivel;
			
			public void reservarLivro(int qtdeDisponivel) {
				this.qtdeDisponivel = this.qtdeDisponivel + qtdeDisponivel;
			}
			
			public void devolverLivro(int qtdeDisponivel) {
				if (qtdeDisponivel > qtdeDisponivel) {
					System.out.println("\nNão há estoque suficiente!\n");
				}
				else {
					this.qtdeDisponivel = this.qtdeDisponivel - qtdeDisponivel;
					System.out.println("\nSaída do material realizada com sucesso!\n");
				}	
			}
			
			public int getcodLivro() {
				return codLivro;
			}
			
			public void setcodLivro(int codLivro) {
				this.codLivro = codLivro;
			}
			
			public String getdescLivro() {
				return descLivro;
			}
			
			public void setdescLivro(String descLivro) {
				this.descLivro = descLivro;
			}
			
			public int getqtdeDisponivel() {
				return qtdeDisponivel;
			}
			
			
		}