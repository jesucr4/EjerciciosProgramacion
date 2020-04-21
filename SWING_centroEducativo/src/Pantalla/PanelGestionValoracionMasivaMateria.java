package Pantalla;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Utils.CacheImagenes;
import model.Curso;
import model.Estudiante;
import model.Materia;
import model.Profesor;
import model.Valoracionmateria;
import model.Controladores.CursoControlador;
import model.Controladores.EstudianteControlador;
import model.Controladores.MateriaControlador;
import model.Controladores.ProfesorControlador;
import model.Controladores.ValoracionMateriaControlador;


public class PanelGestionValoracionMasivaMateria extends JPanel {
	
	//FUNCIONES BOTONES
	public static int SAVE = 1;
	public static int ONLY_ONE = 2;
	public static int ALL_STUDENTS = 3;
	public static int DELETE_ONE_STUDENT = 4;
	public static int DELETE_ALL_STUDENTS = 5;
	
	
	private int valor_Y = 2;
	
	Valoracionmateria actual = null;
	//creamos JLabel en el que mostraremos nuestra nota seleccionada con el jslider
	private JLabel notaSlider = new JLabel();
	//botones para refrescar estudiantes y guardar valoraciones
	private JButton jbtRefrescar = new JButton("Refrescar estudiantes");
	private JButton jbtGuardarValoracion = new JButton("Guardar valoración");
	//jlaberl
	private JLabel jlbNota = new JLabel("Nota");
	JScrollPane pantallaEstudiantes = new JScrollPane();
	//creamos jcombobox de profesores y materias
	JComboBox<Profesor> jcbIdProfesor = new JComboBox<Profesor>();
	
	JComboBox<Materia> jcbIdMateria = new JComboBox<Materia>();
	//slider con orientación vertical, se iniciará por defecto en 5
	private JSlider slNota = new JSlider(JSlider.HORIZONTAL, 0, 10, 5);
	//Jlists que vamos a utilizar
	private JList jlistEstudianteCompleto;
	private JList jlistEstudianteConNota;
	
	private DefaultListModel<Estudiante> listModelEstudiante = null;
	private DefaultListModel<Estudiante> listModelEstudianteNota = null;
	private List<Estudiante> estudianteNota = new ArrayList<Estudiante>();
	//lista de estudiante, profesor y materia
	List<Estudiante> est = EstudianteControlador.getInstancia().findAllEstudiantes();
	List<Profesor> pro = ProfesorControlador.getInstancia().findAllProfesores();
	List<Materia> mat = MateriaControlador.getInstancia().findAllMaterias();

	
	public PanelGestionValoracionMasivaMateria() {
		super();
		// TODO Auto-generated constructor stub
		this.setLayout(new BorderLayout());
		this.add(gestion(), BorderLayout.CENTER);
	//	this.add(construir(), BorderLayout.CENTER);
		this.actual = ValoracionMateriaControlador.getInstancia().findFirst();
		
		//cargarDatosActual();
	}

	private JPanel gestion () {
	
		for (Profesor p: pro) {
			jcbIdProfesor.addItem(p);
		}
		
		for (Materia materia : mat) {
			jcbIdMateria.addItem(materia);
		}
		
		JPanel pantalla = new JPanel();
		pantalla.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(5, 5, 5, 5);
		c.anchor = GridBagConstraints.EAST;
		pantalla.add(new JLabel("Profesor: "),c);
		c.gridx = 1;
		c.anchor = GridBagConstraints.WEST;
		pantalla.add(jcbIdProfesor, c);
		c.gridx = 0;
		c.gridy = 1;
		c.anchor = GridBagConstraints.EAST;
		pantalla.add(new JLabel("Materia: "),c);
		c.gridx = 1;
		c.anchor = GridBagConstraints.WEST;
		pantalla.add(jcbIdMateria, c);
		c.gridx = 0;
		c.gridy = 2;
		c.anchor = GridBagConstraints.EAST;
		pantalla.add(jlbNota,c);
		c.gridx = 1;
		c.anchor = GridBagConstraints.CENTER;
		slNota.setMajorTickSpacing(1);
		slNota.setPaintTicks(true);
		slNota.setPaintLabels(true);
		pantalla.add(slNota,c);
		c.gridx = 2;
		c.anchor = GridBagConstraints.WEST;
		pantalla.add(notaSlider,c);
		
		
		c.gridx = 1;
		c.gridy = 3;
		c.anchor = GridBagConstraints.CENTER;
		pantalla.add(jbtRefrescar, c);
		
		
		c.gridx = 0;
		c.gridy = 4;
		c.anchor = GridBagConstraints.EAST;
		pantalla.add(new JLabel("Fecha valoración: "), c);

		
		c.gridx = 1;
		c.gridy = 4;
		c.anchor = GridBagConstraints.WEST;
		JFormattedTextField fechaVal = getJFormattedTextField();
		pantalla.add(fechaVal, c);
		
		c.gridy = 5;
		c.weightx = 1;
		pantallaEstudiantes.setPreferredSize(new Dimension(600, 600));
		c.anchor = GridBagConstraints.CENTER;
		pantalla.add(pantallaEstudiantes,c);
		
		
		c.gridx = 1;
		c.gridy = 6;
		c.weighty = 0;
		c.anchor = GridBagConstraints.CENTER;
		pantalla.add(jbtGuardarValoracion,c);
		
		//añadimos nota al jlabel en función de nuestro jslider
		slNota.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				int valoracion = slNota.getValue();
				String valFinallbl = Integer.toString(valoracion);
				notaSlider.setText(valFinallbl);
				
				
			}
		});
		
		jbtRefrescar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				pantallaEstudiantes.setViewportView(panelAlumnos());
			}
		});
		
		
		
		jbtGuardarValoracion.addActionListener(new ActionListener() {
			
			/**
			 *
			 * @param e the e
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
			
				
				
					Profesor p = (Profesor) jcbIdProfesor.getSelectedItem();
					Materia m = (Materia) jcbIdMateria.getSelectedItem();
					for (Estudiante estu : estudianteNota) {
						Valoracionmateria valoracion = ValoracionMateriaControlador.getInstancia().findByEstudianteAndProfesorAndMateria(
								p, m , estu);
						if (valoracion != null) {
							valoracion.setValoracion(((Integer) slNota.getValue()).floatValue()); 
							valoracion.setFecha((Date) fechaVal.getValue());
							ValoracionMateriaControlador.getInstancia().merge(valoracion);
						}
						else {
							Valoracionmateria v = new Valoracionmateria();
							v.setEstudiante(estu);
							v.setMateria(m);
							v.setProfesor(p);
							v.setFecha((Date) fechaVal.getValue());
							v.setValoracion(((Integer) slNota.getValue()).floatValue());
							ValoracionMateriaControlador.getInstancia().persist(v);
						}
						
					}
					guardar();
					}
				
		
				
			
				
			
		});
		
		return pantalla;
		
		
	}
	
	public JPanel panelAlumnos() {
		JPanel panelAlumnos = new JPanel();
		panelAlumnos.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		
		c.insets = new Insets(5, 5, 5, 5);
		c.anchor = GridBagConstraints.CENTER;
		panelAlumnos.add(new JLabel("Alumno no seleccionado"),c);
		c.gridx = 2;
		
		panelAlumnos.add(new JLabel("Alumno seleccionado"),c);
		
		jlistEstudianteCompleto = new JList(this.cargarDatosTodosEstudiantes());
		this.jlistEstudianteCompleto.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		
		jlistEstudianteConNota = new JList(this.getDefaultListModel());
		this.jlistEstudianteConNota.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		
		JScrollPane scrollJlistCompleto = new JScrollPane(jlistEstudianteCompleto);
		c.weightx = 1;
		c.weighty = 1;
		c.gridx = 0;
		c.gridy = 2;
		c.fill = GridBagConstraints.BOTH;
		panelAlumnos.add(scrollJlistCompleto, c);
		
		c.weighty = 1;
		c.gridx = 1;
		c.gridy = 2;
		panelAlumnos.add(menuBotones(),c);
		
		JScrollPane scrollJlistNota = new JScrollPane(jlistEstudianteConNota);
		c.weightx = 1;
		c.weighty = 1;
		c.gridx = 2;
		c.gridy = 2;
		c.fill = GridBagConstraints.BOTH;
		panelAlumnos.add(scrollJlistNota, c);
		return panelAlumnos;
	}
	public JFormattedTextField getJFormattedTextField() {
		JFormattedTextField jtf = new JFormattedTextField(new JFormattedTextField.AbstractFormatter() {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

			@Override
			public String valueToString(Object value) throws ParseException {
				if (value != null && value instanceof Date) {
					return sdf.format((Date) value);
				}
				return "";
			}

			@Override
			public Object stringToValue(String text) throws ParseException {
				try {
					return sdf.parse(text);
				} catch (Exception e) {
					return null;
				}
			}
		});
		jtf.setColumns(20);
		jtf.setValue(new Date());
		return jtf;
	}
	
	public JPanel menuBotones() {
		JPanel botones = new JPanel();
		botones.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(5, 5, 5, 5);
		JButton onlyOne = new JButton();
		asignarFuncion(onlyOne, "flechaDerecha.png", ONLY_ONE);
		botones.add(onlyOne,c);
		c.gridx = 0;
		c.gridy = 1;
		JButton allAccepted = new JButton();
		asignarFuncion(allAccepted, "flechaDobleDerecha.png", ALL_STUDENTS);
		botones.add(allAccepted,c);
		c.gridx = 0;
		c.gridy = 2;
		JButton oneDelete = new JButton();
		asignarFuncion(oneDelete, "flechaIzquierda.png", DELETE_ONE_STUDENT);
		botones.add(oneDelete,c);
		c.gridx = 0;
		c.gridy = 3;
		JButton allDeleted = new JButton();
		asignarFuncion(allDeleted, "dobleFechaIzquierda.png", DELETE_ALL_STUDENTS);
		botones.add(allDeleted,c);
		return botones;
		
	}
	/*
	 * MÉTODO PARA LLENAR LISTA DE TODOS ESTUDIANTES DE LADO IZQUIERDA
	 * 
	 */
	private DefaultListModel cargarDatosTodosEstudiantes () {
		this.listModelEstudiante = new DefaultListModel<Estudiante>();
		for (int i = 0; i < est.size(); i++) {

		this.listModelEstudiante.addElement(this.est.get(i));
		}
		return this.listModelEstudiante;
	}
	/**
	 * Método que construye el modelo de JList, a utilizar para agregar y eliminar provincias
	 */
	private DefaultListModel getDefaultListModel () {
		this.listModelEstudianteNota = new DefaultListModel<Estudiante>();
		return this.listModelEstudianteNota;
	}
	
	private void asignarFuncion (JButton jbt, String icono,final int funcion) {
		jbt.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent arg0) {
				
				
				if (funcion == ONLY_ONE) 
					 agregarEstudiante();
				if (funcion == ALL_STUDENTS) 
					agregacionMultipleEstudiantes();
				if (funcion == DELETE_ONE_STUDENT) 
					eliminarEstudiante();
				if (funcion == DELETE_ALL_STUDENTS) 
					eliminarMultiplesEstudiantes(); 
				
			}});
		 try {
	        	jbt.setIcon(CacheImagenes.getCacheImagenes().getIcono(icono));  
	          } catch (Exception ex) {
	        	  ex.printStackTrace();
	          }
	       
	}
	/*
	 * MÉTODO PARA AGREGAR ESTUDIANTES DE UNO EN UNO
	 */
	private void agregarEstudiante () {
		
		this.listModelEstudianteNota.addElement(this.listModelEstudiante.get(jlistEstudianteCompleto.getSelectedIndex()));
		estudianteNota.add((Estudiante) jlistEstudianteCompleto.getSelectedValue());
		this.listModelEstudiante.removeElementAt(this.jlistEstudianteCompleto.getSelectedIndex());
		
	}
	/*
	 * MÉTODO PARA AGREGAR VARIOS ALUMNOS A LA VEZ PARA PONER NOTA
	 */
	private void agregacionMultipleEstudiantes () {
		for (int i = this.jlistEstudianteCompleto.getSelectedIndices().length -1; i>= 0 ; i--) {
			this.listModelEstudianteNota.addElement(this.listModelEstudiante.get(jlistEstudianteCompleto.getSelectedIndices()[i]));
			estudianteNota.add((Estudiante) jlistEstudianteCompleto.getSelectedValue());
			this.listModelEstudiante.removeElementAt(this.jlistEstudianteCompleto.getSelectedIndices()[i]);
		}
	}
	/**
	 * MÉTODO PARA QUITAR ALUMNO DE TABLA ALUMNO SELECCIONADO
	 */
	private void eliminarEstudiante () {
		
		this.listModelEstudiante.addElement(this.listModelEstudianteNota.get(jlistEstudianteConNota.getSelectedIndex()));
		estudianteNota.remove(jlistEstudianteConNota.getSelectedValue());
		this.listModelEstudianteNota.removeElementAt(this.jlistEstudianteConNota.getSelectedIndex());
		
	}
	
	/**
	 * MÉTODO PARA QUITAR VARIOS ALUMNOS A LA VEZ DE LA TABLA SELECCIONADO
	 */
	private void eliminarMultiplesEstudiantes () {
		for (int i = this.jlistEstudianteConNota.getSelectedIndices().length -1; i>=0; i--) {
			this.listModelEstudiante.addElement(this.listModelEstudianteNota.get(jlistEstudianteConNota.getSelectedIndices()[i]));
			this.listModelEstudianteNota.removeElementAt(this.jlistEstudianteConNota.getSelectedIndices()[i]);
		}
		estudianteNota.clear();
		
	}
	
	private void guardar() {
				
		JOptionPane.showMessageDialog(this, "Guardado correctamente");
		
	}
	
	


	
	
}
