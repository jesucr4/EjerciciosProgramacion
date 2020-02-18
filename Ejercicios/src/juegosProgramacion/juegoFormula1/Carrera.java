package juegoFormula1;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



public class Carrera extends Canvas {
	
	private List<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
	
	// Variable para establecer la instancia del patrón singleton
	private static Carrera instance = null;
	
	// Ventana principal del juego
	JFrame ventana = new JFrame("Gran Premio");

			
	public Carrera() {
		
		// Obtengo referencia al panel principal de la ventana
		JPanel panel = (JPanel) ventana.getContentPane();
		// Establezco una plantilla en el panel, para poder incorporar el Canvas
		panel.setLayout(new BorderLayout());
		// Agrego el Canvas al panel
		panel.add(this, BorderLayout.CENTER);
		// Dimensiono la ventana
		ventana.setBounds(0,0, 700, 700);
		// Desactivo el comportamiento por defecto al pulsar el botón de cierre de la ventana
		ventana.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		Canvas punteroAThis = this;
		this.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				super.mouseClicked(arg0);
				punteroAThis.repaint();
			}
			
		});
		// Agrego un escuchador a la ventana, para detectar el evento de cierre de la misma
		ventana.addWindowListener( new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				cerrarAplicacion();
			}
		});
		//ventana.setResizable(false); nos servirá para arkanoid y hacer que la ventana no se pueda reajustar
		ventana.setVisible(true);
	}
	
	public void cerrarAplicacion() {
		String [] opciones ={"Aceptar","Cancelar"};
		int eleccion = JOptionPane.showOptionDialog(ventana,"¿Desea cerrar la aplicación?","Salir de la aplicación",
		JOptionPane.YES_NO_OPTION,
		JOptionPane.QUESTION_MESSAGE, null, opciones, "Aceptar");
		if (eleccion == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public static Carrera getInstance () {
		if (instance == null) {
			instance = new Carrera();
		}
		return instance;
	}
	
	public void paint(Graphics g) {
		super.paint(g);

		System.out.println("Ancho: " + this.getWidth() + " - Alto: " + this.getHeight());
		
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		for (Vehiculo v : this.vehiculos) {
			v.paint(g);
		}
	}

	
	public void creacionCarrera () {
		
		/*
		for (int i = 0; i < contPistas; i++) {
			Pista pista = new Pista(0, i * pixelsAltoPista, this.getWidth(), pixelsAltoPista);
		}*/
		//Creamos las cuatro pistas
		//creamos variable facilmente modificable para variar el número de pistas que queramos
		int contPistas = 4;
		int pixelsAltoPista = this.getHeight() / contPistas;
		Pista pista1 = new Pista(0, (0 * pixelsAltoPista), this.getWidth(), pixelsAltoPista);
		
		Pista pista2 = new Pista(0, (1 * pixelsAltoPista), this.getWidth(), pixelsAltoPista);
		
		Pista pista3 = new Pista(0, (2 * pixelsAltoPista), this.getWidth(), pixelsAltoPista);
		
		Pista pista4 = new Pista(0, (3 * pixelsAltoPista), this.getWidth(), pixelsAltoPista);
		
		
		// creamos cada vehículo ya relacionado con cada pista
		Coche jugador1 = new Coche("Alonso", Color.BLUE, pista1);
		Coche jugador2 = new Coche("jug2", Color.RED, pista2);
		Moto jugador3 = new Moto("jug3", Color.GREEN, pista3);
		Moto jugador4 = new Moto("jug4", Color.ORANGE, pista4);
		
		//añado cada vehículo a la lista de vehículos
		this.vehiculos.add(jugador1);
		this.vehiculos.add(jugador2);
		this.vehiculos.add(jugador3);
		this.vehiculos.add(jugador4);
		
	}
	
	public void partida () {
		do {
			for ( Vehiculo v : this.vehiculos) {
				v.avanzaPosiciones();
			}
			this.repaint();
			JOptionPane.showMessageDialog(null, "Siguiente turno");
		} while (true);
	}

	
	public static void main(String[] args) {
		Carrera.getInstance().creacionCarrera();
		Carrera.getInstance().partida();

	}
	
		
}
