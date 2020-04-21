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
		
		//Menú gestión
		JMenu menuGestion = new JMenu("Gestión");
		menuGestion.add(crearNuevoMenuItem("Curso",  new PanelGestionCursos()));
		menuGestion.add(crearNuevoMenuItem("Materia", new PanelGestionMateria()));
		menuGestion.add(crearNuevoMenuItem("Valoración materia", new PanelGestionValoracionMateria()));
		menuGestion.add(crearNuevoMenuItem("Estudiante", new PanelGestionEstudiante()));
		menuGestion.add(crearNuevoMenuItem("Profesor", new PanelGestionProfesor()));
		menuGestion.add(crearNuevoMenuItem("Valoración masiva estudiantes", new PanelGestionValoracionMasivaMateria()));
	
		
		this.add(menuGestion);
	}
	
	
	/**
	 * Menú Item para salir de la aplicación
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
	        	//ponemos título al cuadro de diálogo
	        	dialogo.setTitle(titulo);
	        	//introducimos el panel creado en el cuadro de diálogo
	        	dialogo.setContentPane(panel);
	        	//empaquetamos el diálogo para que todos los componentes estén en lugar adecuado
	        	dialogo.pack();
	        	//setModal(true) nos sirve para hacer que el usuario no pueda hacer click en la ventana
	        	//principal si está el cuadro de diálogo abierto
	        	dialogo.setModal(true);
	        	//mostramos cuadro de diálogo en el centro
	        	dialogo.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width/2 - dialogo.getWidth()/2,
	        			(Toolkit.getDefaultToolkit().getScreenSize().height/2 - dialogo.getHeight()/2));
	        	dialogo.setVisible(true);
	        	
	            
	        }
	    });
	    
	    return item;
	}
}



