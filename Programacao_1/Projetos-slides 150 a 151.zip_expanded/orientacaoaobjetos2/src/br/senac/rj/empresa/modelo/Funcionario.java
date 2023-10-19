package br.senac.rj.empresa.modelo;

public class Funcionario {
	private int registro;
	private String nome;
	private int cargo;
	private double salario;
	
	public int getRegistro() {
		return registro;
	}

	public void setRegistro(int registro) {
		this.registro = registro;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCargo() {
		return cargo;
	}

	public void setCargo(int cargo) {
		this.cargo = cargo;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public void aplicarBonificacao() {
		double bonificacao;
		if (this.cargo==1) 
			bonificacao = this.salario * 0.2;
		else if (this.cargo==2)
			bonificacao = this.salario * 0.4;
		else if (this.cargo==3)
			bonificacao = this.salario * 0.6;
		else
			bonificacao = 0;
		System.out.println("Bonificação = " + bonificacao);
		this.salario = this.salario + bonificacao;
	}
}
