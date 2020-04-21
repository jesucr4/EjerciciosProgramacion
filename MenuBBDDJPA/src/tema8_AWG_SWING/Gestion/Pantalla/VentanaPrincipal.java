package tema8_AWG_SWING.Gestion.Pantalla;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

import tema8_AWG_SWING.Gestion.Utils.Apariencia;
import tema8_AWG_SWING.Gestion.Utils.CacheImagenes;


public class VentanaPrincipal extends JFrame {

	public static int ANCHO = 800;
	public static int ALTO = 600;
	public static String TITULO_APLICACION = "Gestión de venta de coches";

	private CacheImagenes cacheImagenes;
	public static BufferedImage iconoApp;

	public static VentanaPrincipal instance = null;
	// Establecer la apariencia típica de Windows
	static {
		Apariencia.setAparienciasOrdenadas(Apariencia.aparienciasOrdenadas);
	}
	
	JTabbedPaneGestion jtabbed = new JTabbedPaneGestion();
	
	
	
	
	public VentanaPrincipal () {
		super (TITULO_APLICACION);
		
		cacheImagenes = new CacheImagenes();
		iconoApp = cacheImagenes.getImagen("iconoAPP.png");
		setIconImage(iconoApp);
		
		this.setExtendedState(JFrame.NORMAL);
		this.setMinimumSize(new Dimension(ANCHO, ALTO));
		
		agregarGestionCierreAplicacion();
		this.setJMenuBar(new Menu(this.jtabbed));
		// Construcción elementos básicos sobre el ContentPanel
		this.setLayout(new BorderLayout());
		this.add(new ToolBar(this.jtabbed), BorderLayout.NORTH);
		this.add(jtabbed, BorderLayout.CENTER);
		this.setVisible(true);
		
		
	}

	public static VentanaPrincipal getInstance() {
		if(instance == null) {
			instance = new VentanaPrincipal();
		}
		return instance;
	}
		
	/**
	 * 
	 */
	private void agregarGestionCierreAplicacion () {
		// Configuración del evento de cerrado
		// Para más información debes estudiar Javadoc WindowListener y WindowAdapter
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener (new WindowAdapter() {
			public void windowClosing (WindowEvent e) {
				String posiblesRespuestas[] = {"Sí","No"};
				// En esta opción se utiliza un showOptionDialog en el que personalizo el icono mostrado
				int opcionElegida = JOptionPane.showOptionDialog(null, "¿Realmente desea cerrar la aplicación?", TITULO_APLICACION, 
				        JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, cacheImagenes.getIcono("confirm.png"), posiblesRespuestas, posiblesRespuestas[1]);
			    if(opcionElegida == 0) {
			      System.exit(0);          
			    }
			}
		});
	}
	
	public void cambioPanel (int indicePanel) {
		jtabbed.setSelectedIndex(indicePanel);
	}
}
