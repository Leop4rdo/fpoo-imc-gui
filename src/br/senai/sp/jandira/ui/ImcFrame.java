package br.senai.sp.jandira.ui;

import br.senai.sp.jandira.model.Imc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;
import java.text.DecimalFormat;

public class ImcFrame extends JFrame {
	private JLabel lblTitulo;
	private JLabel lblPeso;
	private JLabel lblAltura;
	private JLabel lblImc;
	private JLabel lblImcResultado;
	private JLabel lblStatus;
	private JLabel lblStatusResultado;
	private JLabel lblResultados;
	
	private JTextField txtPeso;
	private JTextField txtAltura;
	
	private JButton btnCalcular;
	
	private Font textFont;
	
	
	public ImcFrame() {
		this.setSize(415,525);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Calculadora IMC");
		this.setLayout(null);
		this.setResizable(false);
		this.getContentPane().setBackground(new Color(240, 240, 240));
		
		renderComponents();
		
		this.setVisible(true);
		
		handleActionListeners();
	}
	
	public void renderComponents() {
		textFont = new Font("Sans Serif", Font.PLAIN, 16);
		
		lblTitulo = new JLabel("Calculadora IMC");
		lblTitulo.setBounds(110, 20, 220, 20);
		lblTitulo.setFont(new Font("Sans Serif", Font.BOLD, 24));
		lblTitulo.setForeground(Color.BLUE);
		
		lblAltura = new JLabel("Sua altura (m):");
		lblAltura.setBounds(70, 100, 120, 20);
		lblAltura.setFont(textFont);
		
		txtAltura = new JTextField();
		txtAltura.setBounds(190, 85, 150, 50);
		
		lblPeso = new JLabel("Seu peso (Kg):");
		lblPeso.setBounds(70, 165, 120, 20);
		lblPeso.setFont(textFont);
		
		txtPeso = new JTextField();
		txtPeso.setBounds(190, 150, 150, 50);
		
		/**********************************************************************/
		
		btnCalcular = new JButton("Calcular");
		btnCalcular.setBounds(108, 240, 200, 50);
		btnCalcular.setBackground(new Color(220, 220, 220));
		btnCalcular.setFont(textFont);
		
		/**********************************************************************/
		
		lblResultados = new JLabel("Resultados");
		lblResultados.setBounds(20, 320, 100, 40);
		lblResultados.setFont(new Font("Sans Serif", Font.BOLD, 16));
		
		lblImc = new JLabel("IMC :");
		lblImc.setBounds(20, 370, 80, 20);
		lblImc.setFont(textFont);
		
		lblImcResultado = new JLabel("00.0", SwingConstants.RIGHT);
		lblImcResultado.setBounds(330, 370, 50, 20);
		lblImcResultado.setFont(textFont);
		lblImcResultado.setForeground(Color.GREEN);
		
		lblStatus = new JLabel("Status :");
		lblStatus.setBounds(20, 400, 80, 20);
		lblStatus.setFont(textFont);
		
		lblStatusResultado = new JLabel("Status", SwingConstants.RIGHT);
		lblStatusResultado.setBounds(230, 400, 150, 20);
		lblStatusResultado.setFont(textFont);
		lblStatusResultado.setForeground(Color.GREEN);
		
		this.getContentPane().add(lblTitulo);
		this.getContentPane().add(lblAltura);
		this.getContentPane().add(txtAltura);
		this.getContentPane().add(lblPeso);
		this.getContentPane().add(txtPeso);
		this.getContentPane().add(btnCalcular);
		this.getContentPane().add(lblResultados);
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
		double altura = Double.parseDouble(txtAltura.getText());
		double peso = Double.parseDouble(txtPeso.getText());
		
		imc.calcular(peso, altura);
		imc.setStatus();
		
		DecimalFormat df = new DecimalFormat("###.##");		
		
		lblImcResultado.setText(df.format(imc.getValor()));
		lblStatusResultado.setText(imc.getStatus());
	}
}
