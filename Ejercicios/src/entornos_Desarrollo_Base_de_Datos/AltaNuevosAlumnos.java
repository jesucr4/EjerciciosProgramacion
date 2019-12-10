package entornos_Desarrollo_Base_de_Datos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AltaNuevosAlumnos {

	private JFrame frame;
	private JTextField txtNombre;
	private JTextField txtCod_Alumno;
	private JTextField txtGrupo;
	private int indiceAlumnoActual = -1;
	private int numAlumnos = 0;
	private Alumnos arrayAlumnos[] = new Alumnos[50];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaNuevosAlumnos window = new AltaNuevosAlumnos();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AltaNuevosAlumnos() {
		initialize();
		//mostrarAlumno();
		
		
	}
	public void mostrarAlumno() {
				
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.desktop);
		frame.getContentPane().setForeground(Color.BLUE);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAltaAlumnos = new JLabel("ALTA ALUMNOS");
		lblAltaAlumnos.setForeground(Color.WHITE);
		lblAltaAlumnos.setFont(new Font("Noto Sans CJK SC Bold", Font.BOLD | Font.ITALIC, 22));
		lblAltaAlumnos.setBounds(131, 12, 190, 40);
		frame.getContentPane().add(lblAltaAlumnos);
		
		JLabel lblCdigoAlumno = new JLabel("Código Alumno");
		lblCdigoAlumno.setForeground(Color.WHITE);
		lblCdigoAlumno.setBackground(SystemColor.text);
		lblCdigoAlumno.setBounds(25, 107, 115, 18);
		frame.getContentPane().add(lblCdigoAlumno);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(141, 64, 156, 19);
		frame.getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setBounds(25, 66, 66, 15);
		frame.getContentPane().add(lblNombre);
		
		txtCod_Alumno = new JTextField();
		txtCod_Alumno.setColumns(10);
		txtCod_Alumno.setBounds(141, 107, 82, 19);
		frame.getContentPane().add(txtCod_Alumno);
		
		JLabel lblGrupo = new JLabel("Grupo");
		lblGrupo.setForeground(Color.WHITE);
		lblGrupo.setBounds(25, 159, 66, 15);
		frame.getContentPane().add(lblGrupo);
		
		txtGrupo = new JTextField();
		txtGrupo.setColumns(10);
		txtGrupo.setBounds(141, 157, 82, 19);
		frame.getContentPane().add(txtGrupo);
		
		JButton btnAnterior = new JButton("Anterior");
		btnAnterior.setBounds(26, 218, 114, 25);
		frame.getContentPane().add(btnAnterior);
		
		JButton btnSiguiente = new JButton("Siguiente");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnSiguiente.setBounds(183, 218, 114, 25);
		frame.getContentPane().add(btnSiguiente);
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				indiceAlumnoActual++;
				txtCod_Alumno.setText(" ");
				txtGrupo.setText(" ");
				txtNombre.setText(" ");
			
			}
		});
		btnNuevo.setBounds(314, 117, 114, 25);
		frame.getContentPane().add(btnNuevo);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				indiceAlumnoActual++;
				Alumnos alumno1 = new Alumnos();
				alumno1.setNombre ("Juan");
				alumno1.setGrupo ("1ºDAW");
				alumno1.setNumAlum ((long) 1);
				arrayAlumnos[indiceAlumnoActual] = alumno1;
				
			}
		});
		btnGuardar.setBounds(314, 154, 114, 25);
		frame.getContentPane().add(btnGuardar);
	}
}
