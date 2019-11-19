package entornos_Desarrollo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JEditorPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class Práctica_Sumador {

	private JFrame frame;
	private JTextField numero1;
	private JTextField numero2;
	private JTextField suma;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Práctica_Sumador window = new Práctica_Sumador();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Práctica_Sumador() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 741, 367);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setToolTipText("");
		panel.setBounds(53, 12, 648, 55);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("SUMADOR");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Liberation Serif", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(53, 93, 648, 163);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblnumero1 = new JLabel("Numero 1");
		lblnumero1.setBounds(12, 22, 74, 15);
		panel_1.add(lblnumero1);
		
		numero1 = new JTextField();
		numero1.setBounds(104, 12, 88, 35);
		panel_1.add(numero1);
		numero1.setColumns(10);
		
		numero2 = new JTextField();
		numero2.setColumns(10);
		numero2.setBounds(105, 59, 88, 35);
		panel_1.add(numero2);
		
		suma = new JTextField();
		suma.setEditable(false);
		suma.setColumns(10);
		suma.setBounds(104, 106, 88, 35);
		panel_1.add(suma);
		
		JLabel lblNumero2 = new JLabel("Numero2");
		lblNumero2.setBounds(12, 69, 76, 15);
		panel_1.add(lblNumero2);
		
		JLabel lblresultado = new JLabel("Resultado");
		lblresultado.setBounds(12, 116, 77, 15);
		panel_1.add(lblresultado);
		
		JButton btnSumar = new JButton("SUMAR");
		btnSumar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			int num1, num2, resultado;
			num1 = Integer.parseInt(numero1.getText());
			num2 = Integer.parseInt(numero2.getText());
			resultado = num1 + num2;
			suma.setText(Integer.toString(resultado));
			
			}
		});
		btnSumar.setBounds(136, 268, 114, 25);
		frame.getContentPane().add(btnSumar);
		
		JButton button = new JButton("SALIR");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		button.setBounds(468, 268, 114, 25);
		frame.getContentPane().add(button);
	}
}
