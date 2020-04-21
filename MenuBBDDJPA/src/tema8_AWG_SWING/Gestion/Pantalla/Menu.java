package tema8_AWG_SWING.Gestion.Pantalla;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;
import javax.swing.KeyStroke;

import tema8_AWG_SWING.Gestion.Utils.CacheImagenes;



public class Menu extends JMenuBar {

	JTabbedPane tabPane = null;
	public Menu(JTabbedPane tabPane) {
		this.tabPane = tabPane;
		//Menú gestión
		JMenu menuGestion = new JMenu("Gestión");
		menuGestion.add(crearNuevoMenuItem("Concesionario", "limpia.png", 0));
		menuGestion.add(crearNuevoMenuItem("Fabricante", "rueda.png", 1));
		menuGestion.add(crearNuevoMenuItem("Cliente", "persona.png", 2));
		menuGestion.add(crearNuevoMenuItem("Coche", "coche.png", 3));
		menuGestion.add(crearNuevoMenuItem("Venta", "venta.png", 4));
		
		this.add(menuGestion);
	}
	
	
	/**
	 * Menú Item para salir de la aplicación
	 * @return
	 */
	private JMenuItem crearNuevoMenuItem (String titulo, String nombreIcono, int ventana) {
	    JMenuItem item = new JMenuItem(titulo);
	    item.setIcon(CacheImagenes.getCacheImagenes().getIcono(nombreIcono));
	    item.addActionListener(new ActionListener(){
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	VentanaPrincipal.getInstance().cambioPanel(ventana);
	            
	        }
	    });
	    
	    return item;
	}
}



