package juegosProgramacion_Arkanoid;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import tema5_arrays.Utils;

public class Ladrillo extends ObjetosArkanoid {
	
	JFrame ventana;
	protected static int ANCHO = 70;
	protected static int ALTO = 25;
	
	protected int dureza;
	protected static int RUPTURA_LADRILLO = 20;
	
	private Color color ;
	
	public static Color[] COLORES = new Color[] {Color.ORANGE, Color.PINK, Color.GREEN,
			Color.LIGHT_GRAY, Color.RED, Color.YELLOW, Color.BLUE};  
	 
	public Ladrillo() {
		// TODO Auto-generated constructor stub
	}
	

	/*public Ladrillo(int x, int y, Color[] COLORES) {
		super(x,y);
		this.COLORES = COLORES;
		this.width = getANCHO();
		this.height = getALTO();
		
	}*/
	
	public Ladrillo (int x, int y, Color color) {
		super (x,y);
		this.color = color;
		this.width = getANCHO();
		this.height = getALTO();
		
	}
	
	public Ladrillo (int x, int y) {
		super (x,y);
		this.color = Color.MAGENTA;
		this.width = getANCHO();
		this.height = getALTO();
		this.dureza = Utils.obtenerNumeroAzar(20, 60);
	}

		

	@Override
	public void collisionWith(ObjetosArkanoid objetoCollisioned) {
		// TODO Auto-generated method stub
		super.collisionWith(objetoCollisioned);
		//comprobamos el tipo de objeto con el que choca
		if (objetoCollisioned instanceof Pelota ) {
			dureza = dureza - RUPTURA_LADRILLO;
			if ( dureza <= 0) {
				this.setMarkedForRemoval(true);
				this.createExplosion();
				SoundsRepository.getInstance().playSound(SoundsRepository.getInstance().EXPLOSION);
				//CADA VEZ QUE HAY UNA COLISIÓN Y ELIMINAMOS UN LADRILLO RESTAMOS UNO A NUESTRO CONTADOR DE LADRILLOS PARA QUE CUANDO LLEGUE A 0 CAMBIEMOS DE FASE
				Arkanoid.getInstance().contadorLadrillos--;
				System.out.println(Arkanoid.getInstance().contadorLadrillos);
				if (Arkanoid.getInstance().contadorLadrillos == 0) {
					
					Arkanoid.getInstance().noQuedanLadrillosFase();
				
				}
						
				}
			}
			
		}
	//}

	private void createExplosion () {
 		Explosion explosion = new Explosion();
		explosion.setX(this.x+12);
		explosion.setY(this.y+6);
		Arkanoid.getInstance().addNewParticipanteToNextIteration(explosion);
	}
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(getColor()); 
		g.fillRoundRect(this.x, this.y, ANCHO, ALTO, 3, 3);
	}

	
	public static int getANCHO() {
		return ANCHO;
	}

	public static void setANCHO(int aNCHO) {
		ANCHO = aNCHO;
	}

	public static int getALTO() {
		return ALTO;
	}

	public static void setALTO(int aLTO) {
		ALTO = aLTO;
	}

	public static Color[] getCOLORES() {
		return COLORES;
	}

	public static void setCOLORES(Color[] cOLORES) {
		COLORES = cOLORES;
	}

	
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	/*public int getCantidadLadrillosColocar() {
		return cantidadLadrillosColocar;
	}

	public void setCantidadLadrillosColocar(int cantidadLadrillosColocar) {
		this.cantidadLadrillosColocar = cantidadLadrillosColocar;
	}

	/*@Override
	public void act() {
		// TODO Auto-generated method stub
		
	}*/
	

}
