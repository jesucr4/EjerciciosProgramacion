package tema8_AWG_SWING.Gestion.Pantalla;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;

import tema8_AWG_SWING.Gestion.Utils.CacheImagenes;



public class ToolBar extends JToolBar {

	private static final long serialVersionUID = 1L;
	
	int pestania = 0;
	
	JTabbedPane tabPane = null;
	
	public ToolBar(JTabbedPane tabPane) {
		this.tabPane = tabPane;
		this.add(creaBoton("", "gotostart.png", "Ir a primera pantalla", 0));
		this.add(creaBoton("", "previous.png", "Anterior", 1));
		this.add(creaBoton("", "next.png", "Siguiente", 2));
		this.add(creaBoton("", "gotoend.png", "Ir a última pantalla", 3));
	}
	/**
	 * 
	 * @param titulo
	 * @param icono
	 * @return
	 */
	private JButton creaBoton(String titulo, String icono, String toolTip, int funcion) {
		
        JButton jbt = new JButton();
        
        jbt.setText(titulo);
        jbt.setToolTipText(toolTip);
        
        jbt.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
            	if(funcion == 0) {
            		pestania = 0;
            		
            	}
            	if (funcion == 1 && pestania > 0) {
            		pestania = tabPane.getSelectedIndex() - 1;
            		if (pestania < 0) {
            			
            			pestania = 0;
            		}
            		
            		
            	}
            	if (funcion == 2 && pestania < 4) {
            		pestania = tabPane.getSelectedIndex() + 1;
            		if (pestania >4) {
            			pestania = 4;
            		}
            		
            	}
            	if (funcion ==3 ) {
            		pestania = 4;
            		
            		
            	}
            
            	VentanaPrincipal.getInstance().cambioPanel(pestania);
            }
        });
        
        try {
        	jbt.setIcon(CacheImagenes.getCacheImagenes().getIcono(icono));  
          } catch (Exception ex) {
        	  ex.printStackTrace();
          }
        return jbt;
	}
}
