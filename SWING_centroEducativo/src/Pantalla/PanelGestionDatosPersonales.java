package Pantalla;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.nio.file.Files;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.filechooser.FileFilter;

import Utils.CacheImagenes;
import model.Curso;
import model.Materia;
import model.Tipologiasexo;
import model.Controladores.CursoControlador;
import model.Controladores.MateriaControlador;
import model.Controladores.TipologiaSexoControlador;

public class PanelGestionDatosPersonales extends JPanel {
	
	private JTextField jtfId = new JTextField(5);
	private JTextField jtfNombre = new JTextField(25);
	private JTextField jtfPriApellido = new JTextField(20);
	private JTextField jtfSegApelllido = new JTextField(20);
	private JTextField jtfDNI = new JTextField(15);
	private JTextField jtfDireccion = new JTextField(40);
	private JTextField jtfEmail = new JTextField(50);
	private JTextField jtfTelefono = new JTextField(15);
	JComboBox<Tipologiasexo> jcbSexo = new JComboBox<Tipologiasexo>();
	private JScrollPane scrollPaneImagen = new JScrollPane();
	
	private JTextField jtfColorPreferido = new JTextField(20);
	private JButton jbtColorPreferido = new JButton("Elegir color");
	private byte[] imagen ;
	private JButton jbtCambiarImagen = new JButton("Elegir imagen");
	
	public PanelGestionDatosPersonales() {
		//this.add(construir());
		
		List<Tipologiasexo> tipo = TipologiaSexoControlador.getInstancia().findAllTipologiasSexo();
		
		for (Tipologiasexo tipologiasexo : tipo) {
			jcbSexo.addItem(tipologiasexo);
		}
		jbtCambiarImagen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				seleccionImagen();
			}
		});
		
		jbtColorPreferido.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				seleccionColor();
				
			}
		});
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		//ID
		c.gridx = 0;
		c.gridy = 0;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(5, 5, 5, 5);
		c.anchor = GridBagConstraints.EAST;
		this.add(new JLabel("ID: "),c);
		c.gridx=1;
		c.anchor = GridBagConstraints.WEST;
		
		jtfId.setEnabled(false);
		this.add(jtfId,c);
		//NOMBRE
		c.gridx = 0;
		c.gridy = 1;
		
		c.anchor = GridBagConstraints.EAST;
		this.add(new JLabel("Nombre: "), c);
		c.gridx = 1;
		c.anchor = GridBagConstraints.WEST;
		this.add(jtfNombre, c);
		//APELLIDOS
		c.gridx = 0;
		c.gridy = 2;
		c.anchor = GridBagConstraints.EAST;
		this.add(new JLabel("Primer apellido: "),c);
		c.gridx = 1;
		c.anchor = GridBagConstraints.WEST;
		this.add(jtfPriApellido,c);
		c.gridx = 0;
		c.gridy = 3;
		c.anchor = GridBagConstraints.EAST;
		this.add(new JLabel("Segundo apellido: "),c);
		c.gridx = 1;
		c.anchor = GridBagConstraints.WEST;
		this.add(jtfSegApelllido,c);
		//DNI
		c.gridx = 0;
		c.gridy = 4;
		c.anchor = GridBagConstraints.EAST;
		this.add(new JLabel("DNI: "),c);
		c.gridx = 1;
		c.anchor = GridBagConstraints.WEST;
		this.add(jtfDNI,c);
		//DIRECCION
		c.gridx = 0;
		c.gridy = 5;
		c.anchor = GridBagConstraints.EAST;
		this.add(new JLabel("Dirección: "),c);
		c.gridx = 1;
		c.anchor = GridBagConstraints.WEST;
		this.add(jtfDireccion,c);
		//EMAIL
		c.gridx = 0;
		c.gridy = 6;
		c.anchor = GridBagConstraints.EAST;
		this.add(new JLabel("Email: "),c);
		c.gridx = 1;
		c.anchor = GridBagConstraints.WEST;
		this.add(jtfEmail,c);
		//TELÉFONO
		c.gridx=0;
		c.gridy=7;
		c.anchor= GridBagConstraints.EAST;
		this.add(new JLabel("Teléfono"),c);
		c.gridx = 1;
		c.anchor = GridBagConstraints.WEST;
		this.add(jtfTelefono,c);
		//SEXO
		c.gridx=0;
		c.gridy = 8;
		c.anchor = GridBagConstraints.EAST;
		this.add(new JLabel("Sexo: "),c);
		c.gridx = 1;
		c.anchor = GridBagConstraints.WEST;
		this.add(jcbSexo,c);
		//COLOR
		c.gridx = 0;
		c.gridy = 9;
		c.anchor = GridBagConstraints.EAST;
		this.add(new JLabel("Color preferido"),c);
		c.gridx = 1;
		this.add(jtfColorPreferido,c);
		//BOTON COLOR
		c.gridx = 2;
		this.add(jbtColorPreferido,c);
		//boton imagen
		c.gridx = 2;
		c.gridy = 4;
		this.add(jbtCambiarImagen,c);
		//IMAGEN
		c.gridheight = 4;
		c.gridwidth = 1;
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 2;
		c.gridy = 0;
		this.add(scrollPaneImagen,c);
	
		
	}
	
	
	private void seleccionImagen () {
		//creamos jfilechooser para elegir nuestro fichero (imagen)
		JFileChooser jfile = new JFileChooser();
		//nuestro filechooser solo nos mostrará archivos, no directorios
		jfile.setFileSelectionMode(JFileChooser.FILES_ONLY);
		jfile.setFileFilter(new FileFilter() {
			
			@Override
			public String getDescription() {
				
				return "Archivos de imagen *.jpg *.png *.gif";
			}
			
			@Override
			public boolean accept(File f) {
				if (f.isDirectory() || (f.isFile() &&
						(f.getAbsolutePath().endsWith(".jpg") ||
							f.getAbsolutePath().endsWith(".jpeg") ||
							f.getAbsolutePath().endsWith(".png") ||
							f.getAbsolutePath().endsWith(".gif"))))
					return true;
				return false;
			}
		});
		
		//selección usuario
		int seleccionUsuario = jfile.showOpenDialog(null);
		if(seleccionUsuario == JFileChooser.APPROVE_OPTION) {
			File fichero = jfile.getSelectedFile();
			
			if (fichero.isFile()) {
				try {
					byte [] imagenLeida = Files.readAllBytes(fichero.toPath());
					ImageIcon imagenProvisional = new ImageIcon (imagenLeida);
					if(imagenProvisional.getIconWidth()>100 || imagenProvisional.getIconWidth() >100) {
						JOptionPane.showMessageDialog(null, "La imagen debe tener un tamaño de 100x100 píxeles");
						return;
					}
					setImagen(imagenLeida);
				}catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}
	
	//ID
	public String getId() {
		return  jtfId.getText();
	}
	public void setId(String id) {
		this.jtfId.setText(id);
	}
	
	//NOMBRE
	public String getNombre() {
		return jtfNombre.getText();
	}
	public void setNombre ( String nombre) {
		this.jtfNombre.setText(nombre);
	}
	//PRIMER APELLIDO
	public String getPrimerApellido() {
		return jtfPriApellido.getText();
	}
	public void setPriApellido (String primerApellido) {
		this.jtfPriApellido.setText(primerApellido);
	}
	//SEGUNDO APELLIDO
	public String getSegundoApellido() {
		return jtfSegApelllido.getText();
	}
	public void setSegApellido (String segundoApellido) {
		this.jtfSegApelllido.setText(segundoApellido);
	}
	
	//DNI
	public String getDni() {
		return jtfDNI.getText();
	}
	public void setDNI (String dni) {
		this.jtfDNI.setText(dni);
	}
	
	//DIRECCIÓN
	public String getDireccion () {
		return jtfDireccion.getText();
	}
	public void setDireccion(String direccion) {
		this.jtfDireccion.setText(direccion);
	}
	
	//EMAIL
	public String getEmail() {
		return jtfEmail.getText();
	}
	public void setEmail(String email) {
		this.jtfEmail.setText(email);
	}
	
	//TELEFONO
	public String getTelefono() {
		return jtfTelefono.getText();
	}
	public void setTelefono(String telefono) {
		this.jtfTelefono.setText(telefono);
	}
	
	//TIPOLOGIA SEXO
	public Tipologiasexo getTipologiaSexo() {
		return (Tipologiasexo) this.jcbSexo.getSelectedItem();
	}
	public void setTipoligaSexo (Tipologiasexo sexo) {
		if (sexo == null && this.jcbSexo.getItemCount()>0) {
			this.jcbSexo.setSelectedItem(0);
		}else {
			for (int i = 0; i < this.jcbSexo.getItemCount(); i++) {
				Tipologiasexo sexoEstablecido = this.jcbSexo.getItemAt(i);
				if(sexo.getId() == sexoEstablecido.getId()) {
					this.jcbSexo.setSelectedIndex(i);
				}
			}
		}
	}
	
	
	public byte[] getImagen() {
		return imagen;
	}


	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
		if (imagen != null && imagen.length >0) {
			ImageIcon icono = new ImageIcon(this.imagen);
			JLabel lblIcono = new JLabel(icono);
			lblIcono.addMouseListener(new MouseAdapter() {

				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					super.mouseClicked(e);
					this.mostrarMenu(e);
				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					super.mousePressed(e);
					this.mostrarMenu(e);
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					super.mouseReleased(e);
					this.mostrarMenu(e);
				}
				
				private void mostrarMenu (MouseEvent e) {
					if (e.isPopupTrigger()) {
						JPopupMenu menu = new JPopupMenu();
						menu.add(new JMenuItem(icono.getIconWidth()+ " x " + icono.getIconHeight() + " pixeles"));
						menu.addSeparator();
						JMenuItem seleccionImagen = new JMenuItem("Seleccionar imagen");
						seleccionImagen.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent arg0) {
								// TODO Auto-generated method stub
								seleccionImagen();
							}
						});
						menu.add(seleccionImagen);
						menu.show(e.getComponent(), e.getX(), e.getY());
					}
				}
				
			});
			this.scrollPaneImagen.setViewportView(lblIcono);
		}else {
			JLabel lblIcono = new JLabel("Sin imagen");
			this.scrollPaneImagen.setViewportView(lblIcono);
		}
	}
	public String getColorPreferido() {
		return jtfColorPreferido.getText();
	}
	public void setColorPreferido (String color) {
		this.jtfColorPreferido.setText(color);
		try {
			this.setBackground(Color.decode(color));
		} catch (Exception e) {
			this.setBackground(Color.blue);
		}
	}
	
	private void seleccionColor() {
		Color color = (new JColorChooser()).showDialog(null, "Seleccione un color", Color.blue);
		
		if (color != null) {
			String strColor = "#"+Integer.toHexString(color.getRGB()).substring(2);
			this.jtfColorPreferido.setText(strColor);
			this.setBackground(color);
		}
	}
	
	public void limpiarPantalla() {
		this.setId("");
		this.setNombre("");
		this.setPriApellido("");
		this.setSegApellido("");
		this.setDNI("");
		this.setDireccion("");
		this.setEmail("");
		this.setTelefono("");
		this.setTipoligaSexo(null);
	}
	
	
}
