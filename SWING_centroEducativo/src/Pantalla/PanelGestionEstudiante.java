package Pantalla;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import Utils.CacheImagenes;
import model.Curso;
import model.Estudiante;
import model.Materia;
import model.Controladores.CursoControlador;
import model.Controladores.EstudianteControlador;
import model.Controladores.MateriaControlador;

public class PanelGestionEstudiante extends JPanel {
	public static int LOAD_FIRST = 0;
	public static int LOAD_PREV = 1;
	public static int LOAD_NEXT = 2;
	public static int LOAD_LAST = 3;
	public static int NEW = 4;
	public static int SAVE = 5;
	public static int REMOVE = 6;
	
	Estudiante actual = null;
	PanelGestionDatosPersonales pnlDatosPersonales = new PanelGestionDatosPersonales();
	
	public PanelGestionEstudiante() {
		super();
		// TODO Auto-generated constructor stub
		this.setLayout(new BorderLayout());
		this.add(barraHerramientas(), BorderLayout.NORTH);
		
		this.add(pnlDatosPersonales, BorderLayout.CENTER);
		this.actual = EstudianteControlador.getInstancia().findFirst();
		
		cargarDatosActual();
	}

	
	
	private JToolBar barraHerramientas () {
		JToolBar barra = new JToolBar();
		JButton jbtPrimero = new JButton("Primero");
		asignarFuncion(jbtPrimero,"gotostart.png", LOAD_FIRST);
		barra.add(jbtPrimero);
		
		JButton jbtAnterior = new JButton("Anterior");
		asignarFuncion(jbtAnterior,"previous.png", LOAD_PREV);
		barra.add(jbtAnterior);
		
		JButton jbtSiguiente = new JButton("Siguiente");
		asignarFuncion(jbtSiguiente,"next.png", LOAD_NEXT);
		barra.add(jbtSiguiente);

		JButton jbtUltimo = new JButton("Ultimo");
		asignarFuncion(jbtUltimo,"gotoend.png", LOAD_LAST);
		barra.add(jbtUltimo);
		
		JButton jbtGuardar = new JButton("Guardar");
		asignarFuncion(jbtGuardar, "guardar.png", SAVE);
		barra.add(jbtGuardar);
		
		JButton jbtNuevo = new JButton("Nuevo");
		asignarFuncion( jbtNuevo, "nuevo.png", NEW);
		barra.add(jbtNuevo);
		
		JButton jbtEliminar = new JButton("Eliminar");
		asignarFuncion(jbtEliminar, "eliminar.png", REMOVE);
		barra.add(jbtEliminar);
		
		return barra;
	}
	
	private void asignarFuncion (JButton jbt, String icono,final int funcion) {
		jbt.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent arg0) {
				
				Estudiante obtenido = null;
				if (funcion == LOAD_FIRST) 
					obtenido = EstudianteControlador.getInstancia().findFirst();
				if (funcion == LOAD_PREV) 
					obtenido = EstudianteControlador.getInstancia().findPrevious(actual);
				if (funcion == LOAD_NEXT) 
					obtenido = EstudianteControlador.getInstancia().findNext(actual);
				if (funcion == LOAD_LAST) 
					obtenido = EstudianteControlador.getInstancia().findLast();
				if (funcion == NEW) 
					nuevo();
				if (funcion == SAVE) 
					guardar();
				if (funcion == REMOVE) 
					obtenido = eliminar();
				
				if (obtenido != null) {
					actual = obtenido;
					cargarDatosActual();
				}
			}});
		 try {
	        	jbt.setIcon(CacheImagenes.getCacheImagenes().getIcono(icono));  
	          } catch (Exception ex) {
	        	  ex.printStackTrace();
	          }
	       
	}
	private void nuevo () {
		pnlDatosPersonales.limpiarPantalla();
		JOptionPane.showMessageDialog(this, "Por favor, introduzca los datos del nuevo registro");
	}
	

	
	
	private void guardar () {
		Estudiante nuevoRegistro = new Estudiante();
		
		 if(pnlDatosPersonales.getId().trim().equals("")) 
			nuevoRegistro.setId(0);
		else 
			nuevoRegistro.setId(Integer.parseInt(pnlDatosPersonales.getId()));
		
		nuevoRegistro.setNombre(pnlDatosPersonales.getNombre());
		nuevoRegistro.setApellido1(pnlDatosPersonales.getPrimerApellido());
		nuevoRegistro.setApellido2(pnlDatosPersonales.getSegundoApellido());
		nuevoRegistro.setDni(pnlDatosPersonales.getDni());
		nuevoRegistro.setDireccion(pnlDatosPersonales.getDireccion());
		nuevoRegistro.setEmail(pnlDatosPersonales.getEmail());
		nuevoRegistro.setTelefono(pnlDatosPersonales.getTelefono());
		nuevoRegistro.setTipologiasexo(pnlDatosPersonales.getTipologiaSexo());
		nuevoRegistro.setImagen(pnlDatosPersonales.getImagen());
		nuevoRegistro.setColorPreferido(pnlDatosPersonales.getColorPreferido());
				
		
		if (nuevoRegistro.getId() == 0) {
			EstudianteControlador.getInstancia().persist(nuevoRegistro);
		}
		else {
			EstudianteControlador.getInstancia().merge(nuevoRegistro);
		}
		
		pnlDatosPersonales.setId("" + nuevoRegistro.getId());
		JOptionPane.showMessageDialog(this, "Guardado correctamente");
		
		this.actual = nuevoRegistro;
	}
	
	
	/**
	 * 
	 * @return
	 */
	private Estudiante eliminar () {
		String respuestas[] = new String[] {"Sí", "No"};
		int opcionElegida = JOptionPane.showOptionDialog(null, 
				"¿Realmente desea eliminar el registro?", "Eliminación del registro", 
		        JOptionPane.OK_CANCEL_OPTION, 
		        JOptionPane.OK_CANCEL_OPTION, 
		        CacheImagenes.getCacheImagenes().getIcono("confirm.png"), 
		        respuestas, respuestas[1]);

	    if(opcionElegida == 0) {
	    	Estudiante nuevoAMostrar = EstudianteControlador.getInstancia().findPrevious(actual);
	    	if (nuevoAMostrar == null) {
	    		nuevoAMostrar = EstudianteControlador.getInstancia().findNext(actual);
	    	}
	    	EstudianteControlador.getInstancia().remove(actual);
			JOptionPane.showMessageDialog(this, "Eliminación correcta");

	    	if (nuevoAMostrar != null) {
	    		actual = nuevoAMostrar;
	    	}
	    	else {
	    		pnlDatosPersonales.limpiarPantalla();
	    	} 
	    }
	    return actual;
	}
	
	private void cargarDatosActual () {
		if (this.actual != null) {
			pnlDatosPersonales.setId("" + this.actual.getId());
			pnlDatosPersonales.setNombre(this.actual.getNombre());
			pnlDatosPersonales.setPriApellido(this.actual.getApellido1());
			pnlDatosPersonales.setSegApellido(this.actual.getApellido2());
			pnlDatosPersonales.setDNI(this.actual.getDni());
			pnlDatosPersonales.setDireccion(this.actual.getDireccion());
			pnlDatosPersonales.setEmail(this.actual.getEmail());
			pnlDatosPersonales.setTelefono(this.actual.getTelefono());
			pnlDatosPersonales.setTipoligaSexo(this.actual.getTipologiasexo());
			pnlDatosPersonales.setColorPreferido(this.actual.getColorPreferido());
			pnlDatosPersonales.setImagen(this.actual.getImagen());
		}
	}
}
