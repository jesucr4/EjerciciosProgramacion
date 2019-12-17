package entornos_Desarrollo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TareaMatriz {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TareaMatriz window = new TareaMatriz();
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
	public TareaMatriz() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//creamos variable para ver ancho del boton
		/*final int anchoBoton = 60;
		int matriz [][] = new int[5][5];
		
		for (int fil = 0; fil < matriz.length ; fil++) {
			final JButton button = new JButton("1");
			button.setBounds(10+anchoBoton*fil, 10, 60, 60);
			frame.getContentPane().add(button);
			for (int col = 0; col < matriz.length; col++) {
				
			}
			
			
		}*/
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnNewButton.setBounds(0, 0, 60, 60);
		frame.getContentPane().add(btnNewButton);
		
		JButton button = new JButton("New button");
		button.setBounds(60, 0, 60, 60);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("New button");
		button_1.setBounds(60, 56, 60, 60);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("New button");
		button_2.setBounds(0, 56, 60, 60);
		frame.getContentPane().add(button_2);
		
		//creamos botones a partir de bucle for copiando código del botón que ya hemos creado
		//tenemos que ir modificando coordenadas en las que se van creando los botones para que no se solapen
		//y salgan al lado uno del otro y hacia abajo
		
	}
}
