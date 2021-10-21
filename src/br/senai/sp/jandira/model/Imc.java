package br.senai.sp.jandira.model;

public class Imc {
	private double valor;
	private String status;
	
	// Get - Set
	public double getValor() {
		return valor;
	}
	
	public void setStatus() {
		if ( valor < 18.5 ) {
			status = "Abaixo do peso";
		} else if ( valor >= 18.5 && valor < 25 ) {
			status = "Peso normal";
		} else if ( valor >= 25  && valor < 30 ) {
			status = "Sobrepeso";
		} else if ( valor >= 30  && valor < 35 ) {
			status = "Obesidade grau I";
		} else if ( valor >= 35  && valor < 40 ) {
			status = "Obesidade grau II";
		} else if ( valor >= 40) {
			status = "Obesidade Mórbida";
		}
	}
	
	public String getStatus() {
		return status;
	}
	
	// Behaviors
	public void calcular(double peso, double altura) {
		valor = peso / (altura * altura);
	}
}
