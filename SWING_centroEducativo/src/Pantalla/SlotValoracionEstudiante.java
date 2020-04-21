package Pantalla;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;

import model.Estudiante;
import model.Materia;
import model.Profesor;
import model.Valoracionmateria;
import model.Controladores.ValoracionMateriaControlador;

public class SlotValoracionEstudiante extends JPanel {

	private JSpinner spinner ;
	Estudiante estudiante = null;
	Materia materia = null;
	Profesor profesor = null;
	
	
	public SlotValoracionEstudiante(Estudiante estudiante, Profesor profesor, Materia materia) {
		this.estudiante = estudiante;
		this.materia = materia;
		this.profesor = profesor;
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		JLabel lblNombre = new JLabel(estudiante.getNombre() + " " + estudiante.getApellido1() + " " + estudiante.getApellido2());
		
		c.insets = new Insets(0, 0, 0, 5);
		c.anchor = GridBagConstraints.EAST;
		c.gridx = 0;
		c.gridy = 0;
		add(lblNombre, c);
		
		spinner = new JSpinner();
		this.notaEstudiante();
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 0;
		add(spinner, c);
		
	}
	
	private void notaEstudiante() {
		Valoracionmateria valoracionActual = ValoracionMateriaControlador.getInstancia().findByEstudianteAndProfesorAndMateria(profesor, materia, estudiante);
		if(valoracionActual != null) {
			this.spinner.setValue(valoracionActual.getValoracion() );
		}
	}
	
	public void guardarValoracion() {
		Valoracionmateria valoracionActual = ValoracionMateriaControlador.getInstancia().findByEstudianteAndProfesorAndMateria(this.profesor, this.materia, this.estudiante);
		if(valoracionActual == null) {
			valoracionActual = new Valoracionmateria();
			valoracionActual.setProfesor(this.profesor);
			valoracionActual.setMateria(this.materia);
			valoracionActual.setEstudiante(this.estudiante);
			
			if(this.spinner.getValue() instanceof Float) {
				valoracionActual.setValoracion(((Float) this.spinner.getValue()).floatValue());
			}
			else if(this.spinner.getValue() instanceof Integer) {
				valoracionActual.setValoracion(((Integer) this.spinner.getValue()).floatValue());
			}
			
			if(valoracionActual.getId() == 0) {
				ValoracionMateriaControlador.getInstancia().persist(valoracionActual);
			}
			else {
				ValoracionMateriaControlador.getInstancia().merge(valoracionActual);
			}
		}
	}
}
