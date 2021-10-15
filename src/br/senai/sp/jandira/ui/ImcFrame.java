package br.senai.sp.jandira.ui;

import br.senai.sp.jandira.model.Imc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Font;

public class ImcFrame extends JFrame {
	private JLabel lblTitulo;
	private JLabel lblPeso;
	private JLabel lblAltura;
	private JLabel lblImc;
	private JLabel lblImcResultado;
	private JLabel lblStatus;
	private JLabel lblStatusResultado;
	
	private JTextField txtPeso;
	private JTextField txtAltura;
	
	private JButton btnCalcular;
	
	
	public ImcFrame() {
		this.setSize(400,450);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Calculadora IMC");
		this.setLayout(null);
		
		renderComponents();
		
		this.setVisible(true);
		
		handleActionListeners();
	}
	
	public void renderComponents() {
		lblTitulo = new JLabel("Calculadora IMC");
		lblTitulo.setBounds(90, 20, 220, 20);
		lblTitulo.setFont(new Font("Sans Serif", Font.BOLD, 24));
		
		lblAltura = new JLabel("Altura (m):");
		lblAltura.setBounds(20, 75, 80, 20);
		lblAltura.setFont(new Font("Sans Serif", Font.PLAIN, 12));
		
		txtAltura = new JTextField();
		txtAltura.setBounds(20, 100, 360, 30);
		
		lblPeso = new JLabel("Peso (Kg):");
		lblPeso.setBounds(20, 145, 80, 20);
		lblPeso.setFont(new Font("Sans Serif", Font.PLAIN, 12));
		
		txtPeso = new JTextField();
		txtPeso.setBounds(20, 170, 360, 30);
		
		
		btnCalcular = new JButton("Calcular");
		btnCalcular.setBounds(150, 250, 100, 30);
		
		lblImc = new JLabel("IMC :");
		lblImc.setBounds(20, 320, 80, 20);
		lblImc.setFont(new Font("Sans Serif", Font.PLAIN, 12));
		
		lblImcResultado = new JLabel("00.0", SwingConstants.RIGHT);
		lblImcResultado.setBounds(330, 320, 50, 20);
		lblImcResultado.setFont(new Font("Sans Serif", Font.PLAIN, 12));
		
		lblStatus = new JLabel("Status :");
		lblStatus.setBounds(20, 345, 80, 20);
		lblStatus.setFont(new Font("Sans Serif", Font.PLAIN, 12));
		
		lblStatusResultado = new JLabel("Status", SwingConstants.RIGHT);
		lblStatusResultado.setBounds(230, 345, 150, 20);
		lblStatusResultado.setFont(new Font("Sans Serif", Font.PLAIN, 12));
		
		this.getContentPane().add(lblTitulo);
		this.getContentPane().add(lblAltura);
		this.getContentPane().add(txtAltura);
		this.getContentPane().add(lblPeso);
		this.getContentPane().add(txtPeso);
		this.getContentPane().add(btnCalcular);
		this.getContentPane().add(lblImc);
		this.getContentPane().add(lblImcResultado);
		this.getContentPane().add(lblStatus);
		this.getContentPane().add(lblStatusResultado);
		
		
		// this.getContentPane().add();
	}

	public void handleActionListeners() {
		btnCalcular.addActionListener(e -> { calcular(); });
	}
	
	private void calcular() {
		Imc imc = new Imc();
		imc.setAltura(Double.parseDouble(txtAltura.getText()));
		imc.setPeso(Double.parseDouble(txtPeso.getText()));
		
		imc.calcular();
		
		lblImcResultado.setText(Double.toString(imc.getValor()));
		lblStatusResultado.setText(imc.getStatus());
	}
}
