package Pantalla;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;



import model.Estudiante;
import model.Materia;
import model.Profesor;
import model.Valoracionmateria;

import model.Controladores.EstudianteControlador;
import model.Controladores.MateriaControlador;
import model.Controladores.ProfesorControlador;
import model.Controladores.ValoracionMateriaControlador;

public class PanelGestionValoracionMateria extends JPanel {
	
	public static int SAVE = 1;
	
	
	/*private float VALOR_INICIAL =  0.0f;
	private int valor_X = 0;*/
	private int valor_Y = 2;
	
	Valoracionmateria actual = null;
	
	private JButton jbtRefrescar = new JButton("Refrescar estudiantes");
	private JButton jbtGuardarValoracion = new JButton("Guardar valoración");
	JScrollPane pantallaEstudiantes = new JScrollPane();
	JComboBox<Profesor> jcbIdProfesor = new JComboBox<Profesor>();
	JComboBox<Estudiante> jcbIdEstudiante = new JComboBox<Estudiante>();
	JComboBox<Materia> jcbIdMateria = new JComboBox<Materia>();
	List<SlotValoracionEstudiante> listaValoracionEstudiantes = new ArrayList<SlotValoracionEstudiante>();
	List<EstudianteJSpinner> spinnerNota = new ArrayList<EstudianteJSpinner>();
	
	List<Estudiante> est = EstudianteControlador.getInstancia().findAllEstudiantes();
	

	public PanelGestionValoracionMateria() {
		super();
		// TODO Auto-generated constructor stub
		this.setLayout(new BorderLayout());
		this.add(gestion(), BorderLayout.CENTER);
	//	this.add(construir(), BorderLayout.CENTER);
		this.actual = ValoracionMateriaControlador.getInstancia().findFirst();
		
		cargarDatosActual();
	}

	private JPanel gestion () {
	
		List<Profesor> pro = ProfesorControlador.getInstancia().findAllProfesores();
		
		List<Materia> mat = MateriaControlador.getInstancia().findAllMaterias();
	
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
		c.gridx = 1;
		c.gridy = 2;
		c.anchor = GridBagConstraints.CENTER;
		pantalla.add(jbtRefrescar, c);
		
		c.gridy = 4;
		c.weightx = 1;
		pantallaEstudiantes.setPreferredSize(new Dimension(400, 400));
		c.anchor = GridBagConstraints.CENTER;
		pantalla.add(pantallaEstudiantes,c);
		
		c.gridx = 1;
		c.gridy = 5;
		c.weighty = 0;
		c.anchor = GridBagConstraints.CENTER;
		pantalla.add(jbtGuardarValoracion,c);
		
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
				
				
				if (spinnerNota != null) {
					Profesor p = (Profesor) jcbIdProfesor.getSelectedItem();
					Materia m = (Materia) jcbIdMateria.getSelectedItem();
					for (EstudianteJSpinner spinner : spinnerNota) {
						Valoracionmateria valoracion = ValoracionMateriaControlador.getInstancia().findByEstudianteAndProfesorAndMateria(
								p, m , spinner.estudiante);
						if (valoracion != null) {
							valoracion.setValoracion(((Integer) spinner.getValue()).floatValue()); 
							ValoracionMateriaControlador.getInstancia().merge(valoracion);
						}
						else {
							Valoracionmateria v = new Valoracionmateria();
							v.setEstudiante(spinner.estudiante);
							v.setMateria(m);
							v.setProfesor(p);
							ValoracionMateriaControlador.getInstancia().persist(v);
						}
						
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
		panelAlumnos.setPreferredSize(new Dimension(200, 200));
		
		this.spinnerNota.clear();
		for (Estudiante estu : est) {

			c.gridx = 0;
			c.gridy = 0 + valor_Y;
			c.insets = new Insets(2, 2, 2, 2);
			c.fill = GridBagConstraints.HORIZONTAL;
			panelAlumnos.add(new JLabel(estu.toString()), c);

			c.gridx = 1;
			c.gridy = 0 + valor_Y;
			c.anchor = GridBagConstraints.WEST;
			EstudianteJSpinner spinner = new EstudianteJSpinner(estu);
			this.spinnerNota.add(spinner);
			Valoracionmateria valoracion = ValoracionMateriaControlador.getInstancia()
					.findByEstudianteAndProfesorAndMateria((Profesor) this.jcbIdProfesor.getSelectedItem(),
							(Materia) this.jcbIdMateria.getSelectedItem(), estu);
			if (valoracion != null) {
				spinner.setValue(new Integer((int) valoracion.getValoracion()));
			}
			panelAlumnos.add(spinner, c);

			valor_Y++;
		}
		
		
		return panelAlumnos;
	}
	
	
	
	
	
	private class EstudianteJSpinner extends JSpinner {

		
		Estudiante estudiante = null;

		
		public EstudianteJSpinner (Estudiante estudiante) {
			super();
			this.estudiante = estudiante;
	
		}
	}
	
	private void guardar () {
		
		this.actual.setMateria(this.actual.getMateria());
	
		if (actual.getId() == 0) {
		ValoracionMateriaControlador.getInstancia().persist(this.actual);
		}
		else {
			ValoracionMateriaControlador.getInstancia().merge(this.actual);
		}
		
		JOptionPane.showMessageDialog(this, "Guardado correctamente");
		
	}
	
	


	
	private void cargarDatosActual () {
		if (this.actual != null) {
			
			this.jcbIdProfesor.setSelectedItem(this.actual.getProfesor());
			this.jcbIdEstudiante.setSelectedItem(this.actual.getEstudiante());
			this.jcbIdMateria.setSelectedItem(this.actual.getMateria());
			
		}
	}
}
