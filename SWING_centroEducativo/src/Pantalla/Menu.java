package Pantalla;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JDialog;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.KeyStroke;





public class Menu extends JMenuBar {

	
	public Menu() {
		
		//Men� gesti�n
		JMenu menuGestion = new JMenu("Gesti�n");
		menuGestion.add(crearNuevoMenuItem("Curso",  new PanelGestionCursos()));
		menuGestion.add(crearNuevoMenuItem("Materia", new PanelGestionMateria()));
		menuGestion.add(crearNuevoMenuItem("Valoraci�n materia", new PanelGestionValoracionMateria()));
		menuGestion.add(crearNuevoMenuItem("Estudiante", new PanelGestionEstudiante()));
		menuGestion.add(crearNuevoMenuItem("Profesor", new PanelGestionProfesor()));
		menuGestion.add(crearNuevoMenuItem("Valoraci�n masiva estudiantes", new PanelGestionValoracionMasivaMateria()));
	
		
		this.add(menuGestion);
	}
	
	
	/**
	 * Men� Item para salir de la aplicaci�n
	 * @return
	 */
	private JMenuItem crearNuevoMenuItem (String titulo, JPanel panel) {
	    JMenuItem item = new JMenuItem(titulo);
	    
	    item.addActionListener(new ActionListener(){
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	JDialog dialogo = new JDialog();
	        	//la ventana se puede redimensionar
	        	dialogo.setResizable(true);
	        	//ponemos t�tulo al cuadro de di�logo
	        	dialogo.setTitle(titulo);
	        	//introducimos el panel creado en el cuadro de di�logo
	        	dialogo.setContentPane(panel);
	        	//empaquetamos el di�logo para que todos los componentes est�n en lugar adecuado
	        	dialogo.pack();
	        	//setModal(true) nos sirve para hacer que el usuario no pueda hacer click en la ventana
	        	//principal si est� el cuadro de di�logo abierto
	        	dialogo.setModal(true);
	        	//mostramos cuadro de di�logo en el centro
	        	dialogo.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width/2 - dialogo.getWidth()/2,
	        			(Toolkit.getDefaultToolkit().getScreenSize().height/2 - dialogo.getHeight()/2));
	        	dialogo.setVisible(true);
	        	
	            
	        }
	    });
	    
	    return item;
	}
}



