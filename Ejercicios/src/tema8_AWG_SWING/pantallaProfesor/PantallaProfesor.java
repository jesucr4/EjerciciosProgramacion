package tema8_AWG_SWING.pantallaProfesor;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PantallaProfesor extends JFrame {

	public PantallaProfesor() {
		this.setBounds(0, 0, 600, 400);
		this.setContentPane(panelPrincipal());
		this.setVisible(true);
		
	}
	
	public JPanel panelPrincipal() {
		JPanel panel = new JPanel();
		
		//hacemos que el panel sea un BoxLayout que se organice de manera horizontal
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		
		//Panel nombre profesor
		JPanel panelNombre = new JPanel();
		//agregamos JLabel (etiqueta con el nombre la etiqueta)
		panelNombre.add(new JLabel("Nombre: "));
		//agregamos campo de texto para añadir nombre del profesor/a
		JTextField nombre = new JTextField(35);
		panelNombre.add(nombre);
		
		//añadimos el panel del nombre a nuestro panel principal
		panel.add(panelNombre);
		
		
		//panel para primer apellido
		JPanel panelPriApe = new JPanel();
		//agregamos JLabel (etiqueta con el apellido)
		panelPriApe.add(new JLabel("Primer apellido: "));
		//agregamos campo de texto para añadir apellido del profesor/a
		JTextField priApe = new JTextField(35);
		panelPriApe.add(priApe);
		
		//añadimos el panel del primer apellido a nuestro panel principal
		panel.add(panelPriApe);
		
		//panel para segundo apellido
		JPanel panelSegApe = new JPanel();
		//agregamos JLabel (etiqueta con el apellido)
		panelSegApe.add(new JLabel("Segundo apellido: "));
		//agregamos campo de texto para añadir apellido del profesor/a
		JTextField segApe = new JTextField(35);
		panelSegApe.add(segApe);
		
		//añadimos el panel del segundo apellido a nuestro panel principal
		panel.add(panelSegApe);
		
		//panel para DNI
		JPanel panelDNI = new JPanel();
		//agregamos JLabel (etiqueta con el DNI)
		panelDNI.add(new JLabel("DNI: "));
		//agregamos campo de texto para añadir DNI del profesor/a
		JTextField dni = new JTextField(35);
		panelDNI.add(dni);
		
		//añadimos el panel del DNI a nuestro panel principal
		panel.add(panelDNI);
		
		//panel para DNI
		JPanel panelLocalidad = new JPanel();
		//agregamos JLabel (etiqueta con el DNI)
		panelLocalidad.add(new JLabel("Localidad: "));
		//agregamos campo de texto para añadir DNI del profesor/a
		JTextField localidad = new JTextField(35);
		panelLocalidad.add(localidad);
		
		//añadimos el panel del DNI a nuestro panel principal
		panel.add(panelLocalidad);

		//panel para botón
		JPanel panelbutton = new JPanel();
		
		JButton button = new JButton("Mostrar datos");
		button.addMouseListener(new MouseAdapter() {

			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				super.mouseClicked(arg0);
				JOptionPane.showMessageDialog(null, "Nombre: " + nombre.getText() + 
						"\n Apellidos: " + priApe.getText() + " " + segApe.getText() + 
						"\n DNI: " + dni.getText() + "\n Localidad: " + localidad.getText());
			}

			/*@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseEntered(e);
				JOptionPane.showMessageDialog(null, "Nombre: " + nombre.getText() + 
						"\n Apellidos: " + priApe.getText() + " " + segApe.getText() + 
						"\n DNI: " + dni.getText() + "\n Localidad: " + localidad.getText());
			}*/
			
		});
		panelbutton.add(button);
		
		panel.add(panelbutton);
		return panel;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PantallaProfesor pantalla = new PantallaProfesor();
	}

}
