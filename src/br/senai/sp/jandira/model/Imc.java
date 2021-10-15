package br.senai.sp.jandira.model;

public class Imc {
	private double peso;
	private double altura;
	private double valor;
	private String status;
	
	// Get - Set
	public double getPeso() {
		return peso;
	}
	
	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	public double getAltura() {
		return altura;
	}
	
	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	public double getValor() {
		return valor;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}

	// Behaviors
	public void calcular() {
		valor = peso / (altura * altura);
		
		if (valor < 18.5 ) {
			status = "Abaixo do peso";
		} else if (valor >= 18.5 && valor < 25) {
			status = "Peso normal";
		} else if (valor >= 25 && valor < 30) {
			status = "Sobrepeso";
		} else if (valor >= 30 && valor < 35) {
			status = "Obesidade I grau";
		} else if (valor >= 35 && valor < 40) {
			status = "Obesidade II grau";
		} else if (valor >= 40) {
			status = "Obesidade Mórbida";
		} else {
			status = "Você não existe!";
		}
	}
}
