package br.senai.sp.jandira.model;

import java.awt.Color;

public class Imc {
	private double valor;
	private String status;
	private Color statusColor;
	
	// Get - Set
	public Color getStatusColor() {
		return statusColor;
	}
	
	public double getValor() {
		return valor;
	}
	
	
	public String getStatus() {
		if ( valor < 18.5 ) {
			status = "Abaixo do peso";
			statusColor = new Color(189, 189, 2);
		} else if ( valor >= 18.5 && valor < 25 ) {
			status = "Peso normal";
			statusColor = Color.GREEN;
		} else if ( valor >= 25  && valor < 30 ) {
			status = "Sobrepeso";
			statusColor = new Color(189, 189, 2);
		} else if ( valor >= 30  && valor < 35 ) {
			status = "Obesidade grau I";
			statusColor = Color.ORANGE;
		} else if ( valor >= 35  && valor < 40 ) {
			status = "Obesidade grau II";
			statusColor = Color.ORANGE;
		} else if ( valor >= 40) {
			status = "Obesidade Mórbida";
			statusColor = Color.RED;
		}
		
		return status;
	}
	
	// Behaviors
	public void calcular(double peso, double altura) {
		valor = peso / (altura * altura);
	}
}
