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
import model.Materia;
import model.Controladores.CursoControlador;
import model.Controladores.MateriaControlador;

public class PanelGestionMateria extends JPanel {
	public static int LOAD_FIRST = 0;
	public static int LOAD_PREV = 1;
	public static int LOAD_NEXT = 2;
	public static int LOAD_LAST = 3;
	public static int NEW = 4;
	public static int SAVE = 5;
	public static int REMOVE = 6;
	
	Materia actual = null;
	private JTextField jtfId = new JTextField(5);
	private JTextField jtfNombre = new JTextField(55);
	private JTextField jtfAcronimo = new JTextField(20);
	JComboBox<Curso> jcbIdCurso = new JComboBox<Curso>();
	
	public PanelGestionMateria() {
		super();
		// TODO Auto-generated constructor stub
		this.setLayout(new BorderLayout());
		this.add(barraHerramientas(), BorderLayout.NORTH);
		this.add(construir(), BorderLayout.CENTER);
		this.actual = MateriaControlador.getInstancia().findFirst();
		
		cargarDatosActual();
	}

	
	private JPanel construir () {
		List<Curso> cur = CursoControlador.getInstancia().findAllCursos();
		
		for (Curso c : cur) {
			jcbIdCurso.addItem(c);
		}
		
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
		panelGestion.add(new JLabel("Nombre: "),c);
		
		c.gridx = 1;
		
		c.anchor = GridBagConstraints.WEST;
		panelGestion.add(jtfNombre,c);
		
		c.gridx = 0;
		c.gridy = 2;
		c.anchor= GridBagConstraints.EAST;
		panelGestion.add(new JLabel("Acrónimo: "), c);
		
		c.gridx = 1;
		c.anchor = GridBagConstraints.WEST;
		panelGestion.add(jtfAcronimo,c);
		
		c.gridx = 0;
		c.gridy = 3;
		c.anchor= GridBagConstraints.EAST;
		panelGestion.add(new JLabel("Curso: "),c);
		
		
		c.gridx=1;
		c.anchor = GridBagConstraints.WEST;
		panelGestion.add(jcbIdCurso,c);
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
				
				Materia obtenido = null;
				if (funcion == LOAD_FIRST) 
					obtenido = MateriaControlador.getInstancia().findFirst();
				if (funcion == LOAD_PREV) 
					obtenido = MateriaControlador.getInstancia().findPrevious(actual);
				if (funcion == LOAD_NEXT) 
					obtenido = MateriaControlador.getInstancia().findNext(actual);
				if (funcion == LOAD_LAST) 
					obtenido = MateriaControlador.getInstancia().findLast();
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
		this.jtfNombre.setText("");
		this.jtfAcronimo.setText("");
		this.jcbIdCurso.setSelectedIndex(-1);
	}
	
	private void guardar () {
		Materia nuevoRegistro = new Materia();
		
		if (this.jtfId.getText().trim().equals("")) 
			nuevoRegistro.setId(0);
		else 
			nuevoRegistro.setId(Integer.parseInt(this.jtfId.getText()));
		
		nuevoRegistro.setNombre(this.jtfNombre.getText());
		nuevoRegistro.setAcronimo(this.jtfAcronimo.getText());
		nuevoRegistro.setCurso((Curso)this.jcbIdCurso.getSelectedItem());		
		
		if (nuevoRegistro.getId() == 0) {
			MateriaControlador.getInstancia().persist(nuevoRegistro);
		}
		else {
			MateriaControlador.getInstancia().merge(nuevoRegistro);
		}
		
		this.jtfId.setText("" + nuevoRegistro.getId());
		JOptionPane.showMessageDialog(this, "Guardado correctamente");
		
		this.actual = nuevoRegistro;
	}
	
	
	/**
	 * 
	 * @return
	 */
	private Materia eliminar () {
		String respuestas[] = new String[] {"Sí", "No"};
		int opcionElegida = JOptionPane.showOptionDialog(null, 
				"¿Realmente desea eliminar el registro?", "Eliminación del registro", 
		        JOptionPane.OK_CANCEL_OPTION, 
		        JOptionPane.OK_CANCEL_OPTION, 
		        CacheImagenes.getCacheImagenes().getIcono("confirm.png"), 
		        respuestas, respuestas[1]);

	    if(opcionElegida == 0) {
	    	Materia nuevoAMostrar = MateriaControlador.getInstancia().findPrevious(actual);
	    	if (nuevoAMostrar == null) {
	    		nuevoAMostrar = MateriaControlador.getInstancia().findNext(actual);
	    	}
	    	MateriaControlador.getInstancia().remove(actual);
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
			this.jtfNombre.setText(this.actual.getNombre());
			this.jtfAcronimo.setText(this.actual.getAcronimo());
			this.jcbIdCurso.setSelectedItem(this.actual.getCurso());
		}
	}
}
