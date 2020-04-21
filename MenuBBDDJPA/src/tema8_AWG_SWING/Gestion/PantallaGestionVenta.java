package tema8_AWG_SWING.Gestion;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Cliente;
import model.Coche;
import model.Concesionario;
import model.Venta;
import tema8_AWG_SWING.Gestion.Controladores.ClienteControlador;
import tema8_AWG_SWING.Gestion.Controladores.CocheControlador;
import tema8_AWG_SWING.Gestion.Controladores.ConcesionarioControlador;
import tema8_AWG_SWING.Gestion.Controladores.VentaControlador;
import tema8_AWG_SWING.Gestion.Utils.CacheImagenes;



public class PantallaGestionVenta extends JPanel {

	public static int LOAD_FIRST = 0;
	public static int LOAD_PREV = 1;
	public static int LOAD_NEXT = 2;
	public static int LOAD_LAST = 3;
	public static int NEW = 4;
	public static int SAVE = 5;
	public static int REMOVE = 6;
	
	
	JTextField jtfId = new JTextField(5);
	JTextField jtfPrecioVenta = new JTextField(15);
	JTextField jtfFecha = new JTextField(30);
	JComboBox<Cliente> jcbIdCliente = new JComboBox<Cliente>();
	JComboBox<Coche> jcbIdCoche = new JComboBox<Coche>();
	JComboBox<Concesionario> jcbIdConcesionario = new JComboBox<Concesionario>();
	
	
	
	Venta actual = null;
	
	
	/**
	 * 
	 */
	public PantallaGestionVenta () {
		actual = VentaControlador.getControlador().findFirst();
		construir();
		cargarDatosActual();
	}
	
	
	
	/**
	 * 
	 */
	private void construir () {
		List<Cliente> cli = ClienteControlador.getControlador().findAll();
		List<Coche> car = CocheControlador.getControlador().findAll();
		List<Concesionario> con = ConcesionarioControlador.getControlador().findAll();
		
		for (Cliente c : cli) {
			jcbIdCliente.addItem(c);
		}
		for (Coche co : car) {
			jcbIdCoche.addItem(co);
		}
		for (Concesionario c : con) {
			jcbIdConcesionario.addItem(c);
		}
		
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		// Inclusiï¿½n del panel de navegaciï¿½n
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
	    c.gridy = 0;
	    c.gridwidth = 2;
	    c.insets = new Insets(0, 0, 25, 0);
	    this.add(getPanelNavegacion(), c);
		
	    // Inclusiï¿½n del campo "Identificador"
		c.fill = GridBagConstraints.NONE;
		c.gridx = 0;
	    c.gridy = 1;
	    c.gridwidth = 1;
	    c.anchor = GridBagConstraints.EAST;
	    c.insets = new Insets(2, 2, 2, 2);
	    this.add(new JLabel("Identificador: "), c);
	    
		c.gridx = 1;
	    c.gridy = 1;
	    jtfId.setEnabled(false);
	    c.anchor = GridBagConstraints.WEST;
		this.add(jtfId, c);
		
		// Inclusiï¿½n del campo "Nombre"
		c.gridx = 0;
	    c.gridy = 2;
	    c.anchor = GridBagConstraints.EAST;
	    this.add(new JLabel("Nombre y apellidos cliente: "), c);
	    
		c.gridx = 1;
	    c.gridy = 2;
	    c.anchor = GridBagConstraints.WEST;
		this.add(jcbIdCliente, c);
		
		// Inclusiï¿½n del campo "Nombre"
		c.gridx = 0;
	    c.gridy = 3;
	    c.anchor = GridBagConstraints.EAST;
	    this.add(new JLabel("Concesionario: "), c);
	    
		c.gridx = 1;
	    c.gridy = 3;
	    c.anchor = GridBagConstraints.WEST;
		this.add(jcbIdConcesionario, c);
		
		// Inclusiï¿½n del campo "Localidads"
		c.gridx = 0;
	    c.gridy = 4;
	    c.anchor = GridBagConstraints.EAST;
	    this.add(new JLabel("Modelo y color coche: "), c);
	    
		c.gridx = 1;
	    c.gridy = 4;
	    c.anchor = GridBagConstraints.WEST;
		this.add(jcbIdCoche, c);
		
		// Inclusiï¿½n del campo "DNINIE"
		c.gridx = 0;
	    c.gridy = 5;
	    c.anchor = GridBagConstraints.EAST;
	    this.add(new JLabel("Fecha venta: "), c);
	    
		c.gridx = 1;
	    c.gridy = 5;
	    c.anchor = GridBagConstraints.WEST;
		this.add(jtfFecha, c);
		
		// Inclusiï¿½n del campo "FECHA NACIMIENTO"
		c.gridx = 0;
	    c.gridy = 6;
	    c.anchor = GridBagConstraints.EAST;
	    this.add(new JLabel("Precio venta: "), c);
	    
		c.gridx = 1;
	    c.gridy = 6;
	    c.anchor = GridBagConstraints.WEST;
		this.add(jtfPrecioVenta, c);
			    
		
		
		c.gridx = 0;
	    c.gridy = 7;
	    c.gridwidth = 2;
	    c.anchor = GridBagConstraints.CENTER;
	    c.insets = new Insets(25, 0, 0, 0);
		this.add(getPanelAcciones(), c);
	}
	
	
	
	/**
	 * 
	 * @return
	 */
	private JPanel getPanelNavegacion () {
		JPanel pnl = new JPanel();

		pnl.setBackground(Color.RED);
		
		JButton jbtPrimero = new JButton("Primero");
		asignarFuncion(jbtPrimero, LOAD_FIRST);
		
		JButton jbtAnterior = new JButton("Anterior");
		asignarFuncion(jbtAnterior, LOAD_PREV);
		
		JButton jbtSiguiente = new JButton("Siguiente");
		asignarFuncion(jbtSiguiente, LOAD_NEXT);

		JButton jbtUltimo = new JButton("Ultimo");
		asignarFuncion(jbtUltimo, LOAD_LAST);
		
		pnl.setLayout(new FlowLayout());
		pnl.add(jbtPrimero);
		pnl.add(jbtAnterior);
		pnl.add(jbtSiguiente);
		pnl.add(jbtUltimo);
		
		return pnl;
	}

	
	/**
	 * 
	 * @return
	 */
	private JPanel getPanelAcciones () {
		JPanel pnl = new JPanel();
		
		pnl.setBackground(Color.red);

		JButton jbtNuevo = new JButton("Nuevo");
		asignarFuncion(jbtNuevo, NEW);
		
		JButton jbtGuardar = new JButton("Guardar");
		asignarFuncion(jbtGuardar, SAVE);
		
		JButton jbtEliminar = new JButton("Eliminar");
		asignarFuncion(jbtEliminar, REMOVE);
		
		
		pnl.setLayout(new FlowLayout());
		pnl.add(jbtNuevo);
		pnl.add(jbtGuardar);
		pnl.add(jbtEliminar);
		
		return pnl;
	}

	
	/**
	 * 
	 */
	private void nuevo () {
		limpiarPantalla();
		JOptionPane.showMessageDialog(this, "Por favor, introduzca los datos del nuevo registro");
	}
	

	/**
	 * 
	 */
	private void limpiarPantalla() {
		this.jtfId.setText("");
		this.jcbIdCliente.setSelectedIndex(-1);
		this.jcbIdConcesionario.setSelectedIndex(-1);
		this.jcbIdCoche.setSelectedIndex(-1);
		this.jtfFecha.setText("");
		this.jtfPrecioVenta.setText("");
		
	}
	
	
	/**
	 * @throws ParseException 
	 * 
	 */
	private void guardar () throws ParseException {
		Venta nuevoRegistro = new Venta();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		if (this.jtfId.getText().trim().equals("")) 
			nuevoRegistro.setId(0);
		else 
			nuevoRegistro.setId(Integer.parseInt(this.jtfId.getText()));
		
		
		nuevoRegistro.setCliente((Cliente) this.jcbIdCliente.getSelectedItem());
		nuevoRegistro.setConcesionario((Concesionario) this.jcbIdConcesionario.getSelectedItem());
		nuevoRegistro.setCoche((Coche) this.jcbIdCoche.getSelectedItem());
		nuevoRegistro.setFecha(sdf.parse(this.jtfFecha.getText()));
		nuevoRegistro.setPrecioVenta(Float.parseFloat(this.jtfPrecioVenta.getText()));
		
		
		
		if (nuevoRegistro.getId() == 0) {
			VentaControlador.getControlador().persist(nuevoRegistro);
		}
		else {
			VentaControlador.getControlador().merge(nuevoRegistro);
		}
		
		this.jtfId.setText("" + nuevoRegistro.getId());
		JOptionPane.showMessageDialog(this, "Guardado correctamente");
		
		this.actual = nuevoRegistro;
	}
	
	
	/**
	 * 
	 * @return
	 */
	private Venta eliminar () {
		String respuestas[] = new String[] {"Sí", "No"};
		int opcionElegida = JOptionPane.showOptionDialog(null, 
				"¿Realmente desea eliminar el registro?", "Eliminación del registro", 
		        JOptionPane.OK_CANCEL_OPTION, 
		        JOptionPane.OK_CANCEL_OPTION, 
		        CacheImagenes.getCacheImagenes().getIcono("confirm.png"), 
		        respuestas, respuestas[1]);

	    if(opcionElegida == 0) {
	    	Venta nuevoAMostrar = VentaControlador.getControlador().findPrevious(actual);
	    	if (nuevoAMostrar == null) {
	    		nuevoAMostrar = VentaControlador.getControlador().findNext(actual);
	    	}
	    	VentaControlador.getControlador().remove(actual);
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
	
	
	/**
	 * 
	 * @param jbt
	 * @param funcion
	 */
	private void asignarFuncion (JButton jbt, final int funcion) {
		jbt.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent arg0) {
				
				Venta obtenido = null;
				if (funcion == LOAD_FIRST) 
					obtenido = VentaControlador.getControlador().findFirst();
				if (funcion == LOAD_PREV) 
					obtenido = VentaControlador.getControlador().findPrevious(actual);
				if (funcion == LOAD_NEXT) 
					obtenido = VentaControlador.getControlador().findNext(actual);
				if (funcion == LOAD_LAST) 
					obtenido = VentaControlador.getControlador().findLast();
				if (funcion == NEW) 
					nuevo();
				if (funcion == SAVE)
					try {
						guardar();
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				if (funcion == REMOVE) 
					obtenido = eliminar();
				
				if (obtenido != null) {
					actual = obtenido;
					cargarDatosActual();
				}
			}});
	}
	

	/**
	 * 
	 */
	private void cargarDatosActual () {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if (this.actual != null) {
			this.jtfId.setText("" + this.actual.getId());
			this.jcbIdCliente.setSelectedItem(this.actual.getCliente());
			this.jcbIdConcesionario.setSelectedItem(this.actual.getConcesionario());
			this.jcbIdCoche.setSelectedItem(this.actual.getCoche());
			this.jtfFecha.setText(sdf.format(this.actual.getFecha()));
			this.jtfPrecioVenta.setText(Float.toString(this.actual.getPrecioVenta()));
		

		
			
		}
	}
}
