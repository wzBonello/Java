package soma_simples;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Screen extends JFrame {
	private int num1, num2, resultado;
	private JLabel label, label_resultado;
	private JButton igual;
	private JTextField n1, n2;
	
	public Screen() {
		// Criando a tela;
		setSize(920, 480);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		setVisible(true);
		
		// Criando os JTextFields
		n1 = new JTextField();
		n1.setFont(new Font("Roboto", Font.BOLD, 50));
		n1.setBounds(110, 150, 150, 60);
		add(n1);
	
		
		n2 = new JTextField();
		n2.setFont(new Font("Roboto", Font.BOLD, 50));
		n2.setBounds(330, 150, 150, 60);
		add(n2);
		
		// Criando JLabel com símbolo "+";
		label = new JLabel();
		label.setText("+");
		label.setBounds(280, 150, 50, 50);
		label.setFont(new Font("Arial", Font.BOLD, 50));
		label.setForeground(new Color(0, 0, 0));
		add(label);
		
		// Criando JButton "igual";
		igual = new JButton("=");
		igual.setBounds(495, 155, 50, 50);
		igual.setFont(new Font("Arial", Font.BOLD, 25));
		igual.addActionListener(this::somar);
		add(igual);
		
		// Criando JLabel "resultado";
		label_resultado = new JLabel();
		label_resultado.setFont(new Font("Arial", Font.BOLD, 50));
		label_resultado.setForeground(new Color(0, 0, 0));
		label_resultado.setBounds(580 , 150, 200, 50);
		add(label_resultado);
		
		
		// Criando JLabel com o título;
		JLabel titulo = new JLabel("SOMA SIMPLES");
		titulo.setBounds(290, 0, 400, 50);
		titulo.setFont(new Font("Roboto", Font.BOLD, 50));
		titulo.setForeground(new Color(0, 0, 0));
		add(titulo);
		
		// Criando JPanel para colocar atrás do JLabel "titulo";
		JPanel fundo = new JPanel();
		fundo.setBounds(0, 0, 920, 50);
		fundo.setBackground(new Color(200, 200, 200));
		add(fundo);
		
	}
	
	public boolean isNumeric(String texto) {
		if(texto == null || texto.isBlank()) return false;
		for(int i = 0; i < texto.length(); i++) {
			char c;
			c = texto.charAt(i);
			if(c < '0' || c > '9') {
				return false;
			}
		}
		return true;
	}
	
	public void somar(ActionEvent e) {
		String n1, n2;
		n1 = this.n1.getText();
		n2 = this.n2.getText();
		if(isNumeric(n1) == false || isNumeric(n2) == false) {
			JOptionPane.showMessageDialog(null, 
					"Por favor, preencha todos os campos com números inteiros.", 
					"ERRO", JOptionPane.ERROR_MESSAGE);
		}
		else {
			num1 = Integer.parseInt(n1);
			num2 = Integer.parseInt(n2);
			resultado = num1 + num2;
			label_resultado.setText(String.valueOf(resultado));
			label.setText("+");
		}
	}
}
