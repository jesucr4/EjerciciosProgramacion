package tema8_AWG_SWING.Gestion.Pantalla;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import tema8_AWG_SWING.Gestion.PanelGestionConcesionario;
import tema8_AWG_SWING.Gestion.PantallaGestionCliente;
import tema8_AWG_SWING.Gestion.PantallaGestionCoche;
import tema8_AWG_SWING.Gestion.PantallaGestionFabricante;
import tema8_AWG_SWING.Gestion.PantallaGestionVenta;
import tema8_AWG_SWING.Gestion.Utils.CacheImagenes;



public class JTabbedPaneGestion extends JTabbedPane {


	/**
	 * 
	 * @return
	 */
	public JTabbedPaneGestion (){
	
		
		ImageIcon icono = CacheImagenes.getCacheImagenes().getIcono("dedo.png");
		
		
		this.addTab("Concesionario", icono, new PanelGestionConcesionario(), "Concesionario");
		this.addTab("Fabricante", icono, new PantallaGestionFabricante(), "Fabricante");
		this.addTab("Cliente", icono, new PantallaGestionCliente(), "Cliente");
		this.addTab("Coche", icono, new PantallaGestionCoche(), "Coche");
		this.addTab("Venta", icono, new PantallaGestionVenta(), "Venta");
		 
		
		
	}	
}
