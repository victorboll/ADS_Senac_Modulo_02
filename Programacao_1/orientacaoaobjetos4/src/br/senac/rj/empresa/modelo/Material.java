package br.senac.rj.empresa.modelo;

public class Material {
	private int codMaterial;
	private String descMaterial;
	private int qtdeEstoque;
	
	public void entrarMaterial(int qtyMaterial) {
		this.qtdeEstoque = this.qtdeEstoque + qtyMaterial;
	}
	
	public void sairMaterial(int qtyMaterial) {
		if (qtyMaterial > qtdeEstoque) {
			System.out.println("Não há estoque suficiente!");
		}
		else {
			this.qtdeEstoque = this.qtdeEstoque - qtyMaterial;
			System.out.println("Saída do material realizada com sucesso!");
		}	
	}
	
	public int getCodMaterial() {
		return codMaterial;
	}
	
	public void setCodMaterial(int codMaterial) {
		this.codMaterial = codMaterial;
	}
	
	public String getDescMaterial() {
		return descMaterial;
	}
	
	public void setDescMaterial(String descMaterial) {
		this.descMaterial = descMaterial;
	}
	
	public int getQtdeEstoque() {
		return qtdeEstoque;
	}
	
	
}
