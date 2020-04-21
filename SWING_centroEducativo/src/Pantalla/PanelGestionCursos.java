package Pantalla;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import Utils.CacheImagenes;
import model.Curso;
import model.Controladores.CursoControlador;

public class PanelGestionCursos extends JPanel {
	public static int LOAD_FIRST = 0;
	public static int LOAD_PREV = 1;
	public static int LOAD_NEXT = 2;
	public static int LOAD_LAST = 3;
	public static int NEW = 4;
	public static int SAVE = 5;
	public static int REMOVE = 6;
	
	Curso actual = null;
	private JTextField jtfId = new JTextField(5);
	private JTextField jtfDescripcion = new JTextField(45);
	
	public PanelGestionCursos() {
		super();
		// TODO Auto-generated constructor stub
		this.setLayout(new BorderLayout());
		this.add(barraHerramientas(), BorderLayout.NORTH);
		this.add(construir(), BorderLayout.CENTER);
		this.actual = CursoControlador.getInstancia().findFirst();
		
		cargarDatosActual();
	}

	
	private JPanel construir () {
		JPanel panelGestion = new JPanel();
		panelGestion.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(5, 5, 5, 5);
		c.anchor = GridBagConstraints.EAST;
		panelGestion.add(new JLabel("Identificador"), c);
		
		c.gridx = 1;
		jtfId.setEnabled(false);
		c.anchor = GridBagConstraints.WEST;
		panelGestion.add(jtfId,c);
		
		c.gridx = 0;
		c.gridy = 1;
		c.anchor = GridBagConstraints.EAST;
		panelGestion.add(new JLabel("Descripción: "),c);
		
		c.gridx = 1;
		
		c.anchor = GridBagConstraints.WEST;
		panelGestion.add(jtfDescripcion,c);
		return panelGestion;
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
				
				Curso obtenido = null;
				if (funcion == LOAD_FIRST) 
					obtenido = CursoControlador.getInstancia().findFirst();
				if (funcion == LOAD_PREV) 
					obtenido = CursoControlador.getInstancia().findPrevious(actual);
				if (funcion == LOAD_NEXT) 
					obtenido = CursoControlador.getInstancia().findNext(actual);
				if (funcion == LOAD_LAST) 
					obtenido = CursoControlador.getInstancia().findLast();
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
		limpiarPantalla();
		JOptionPane.showMessageDialog(this, "Por favor, introduzca los datos del nuevo registro");
	}
	

	/**
	 * 
	 */
	private void limpiarPantalla() {
		this.jtfId.setText("");
		this.jtfDescripcion.setText("");
		
	}
	
	private void guardar () {
		Curso nuevoRegistro = new Curso();
		
		if (this.jtfId.getText().trim().equals("")) 
			nuevoRegistro.setId(0);
		else 
			nuevoRegistro.setId(Integer.parseInt(this.jtfId.getText()));
		
		nuevoRegistro.setDescripcion(this.jtfDescripcion.getText());
		
		
		if (nuevoRegistro.getId() == 0) {
			CursoControlador.getInstancia().persist(nuevoRegistro);
		}
		else {
			CursoControlador.getInstancia().merge(nuevoRegistro);
		}
		
		this.jtfId.setText("" + nuevoRegistro.getId());
		JOptionPane.showMessageDialog(this, "Guardado correctamente");
		
		this.actual = nuevoRegistro;
	}
	
	
	/**
	 * 
	 * @return
	 */
	private Curso eliminar () {
		String respuestas[] = new String[] {"Sí", "No"};
		int opcionElegida = JOptionPane.showOptionDialog(null, 
				"¿Realmente desea eliminar el registro?", "Eliminación del registro", 
		        JOptionPane.OK_CANCEL_OPTION, 
		        JOptionPane.OK_CANCEL_OPTION, 
		        CacheImagenes.getCacheImagenes().getIcono("confirm.png"), 
		        respuestas, respuestas[1]);

	    if(opcionElegida == 0) {
	    	Curso nuevoAMostrar = CursoControlador.getInstancia().findPrevious(actual);
	    	if (nuevoAMostrar == null) {
	    		nuevoAMostrar = CursoControlador.getInstancia().findNext(actual);
	    	}
	    	CursoControlador.getInstancia().remove(actual);
			JOptionPane.showMessageDialog(this, "Eliminación correcta");

	    	if (nuevoAMostrar != null) {
	    		actual = nuevoAMostrar;
	    	}
	    	else {
	    		limpiarPantalla();
	    	} 
	    }
	    return actual;
	}
	
	private void cargarDatosActual () {
		if (this.actual != null) {
			this.jtfId.setText("" + this.actual.getId());
			this.jtfDescripcion.setText(this.actual.getDescripcion());
		}
	}
}
