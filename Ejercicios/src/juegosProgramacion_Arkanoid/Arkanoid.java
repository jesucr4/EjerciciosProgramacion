package juegosProgramacion_Arkanoid;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Arkanoid extends Canvas{
	
	public List<ObjetosArkanoid> participantes = new ArrayList<ObjetosArkanoid>();
	private List<ObjetosArkanoid> newParticipantesForNextIteration = new ArrayList<ObjetosArkanoid>();
	//protected List<Ladrillo> ladrillos = new ArrayList<Ladrillo>();
	//Creamos ventana principal del juego
	JFrame ventana = new JFrame("Arkanoid");
	//Creamos variables para indicar alto y ancho de nuestro Canvas
	private static final int JFRAME_WIDTH = 800;
	private static final int JFRAME_HEIGHT = 800;
	//tiempo usado para cada iteracción del bucle principal del juego
	private long usedTime; 
	public static final int SPEED_FPS = 60;
	
	private BufferStrategy strategy;
	
	public static Arkanoid instance = null;
	
	Nave nave = null;
	Pelota pelota = null;
	
	private boolean gameEnded = false;
	//protected static final float MARGEN = 0.5f;
	//private int cantidadLadrillosColocar = this.getWidth() / Ladrillo.getANCHO();
	
	//public static Color COLORES[] = new Color[] {Color.CYAN, Color.PINK, Color.GREEN,
		//	Color.LIGHT_GRAY, Color.MAGENTA}; 
	
	//CREAMOS CONTADOR DE LADRILLOS PARA QUE CUANDO SE HAYAN DESTRUIDO TODOS PASEMOS A LA SEGUNDA FASE
	public int contadorLadrillos;
	
	//variable booleana para ver que no quedan ladrillos y pasar a segunda fase
	protected boolean quedanLadrillos;
	
	public Arkanoid() {
		
		SoundsRepository.getInstance();

	// Obtengo referencia al panel principal de la ventana
			JPanel panel = (JPanel) ventana.getContentPane();
			// Establezco una plantilla en el panel, para poder incorporar el Canvas
			panel.setLayout(new BorderLayout());
			// Agrego el Canvas al panel
			panel.add(this, BorderLayout.CENTER);
			// Dimensiono la ventana
			ventana.setBounds(0,0, JFRAME_WIDTH, JFRAME_HEIGHT);
			// Muestro la ventana en pantalla
			ventana.setVisible(true);
			// Desactivo el comportamiento por defecto al pulsar el botón de cierre de la ventana
			ventana.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			// Agrego un escuchador a la ventana, para detectar el evento de cierre de la misma
			ventana.addWindowListener( new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					cerrarAplicacion();
				}
			});
		// Creación de la estrategia de doble búffer
		this.createBufferStrategy(2);
		strategy = this.getBufferStrategy();
		// Con ignoreRepaint le decimos al JFrame que no debe repintarse cuando el Sistema Operativo se lo indique,
		// nosotros nos ocupamos totalmente del refresco de la pantalla
		ventana.setIgnoreRepaint(true);
		ventana.setResizable(false);
		ventana.setVisible(true);
		
		this.requestFocus();
		
		
	}
	
	public static Arkanoid getInstance () {
		if (instance == null) {
			instance = new Arkanoid();
		}
		
		return instance;
		
	}

	
	private void cerrarAplicacion() {
		String [] opciones ={"Aceptar","Cancelar"};
		int eleccion = JOptionPane.showOptionDialog(ventana,"¿Desea cerrar la aplicación?","Salir de la aplicación",
		JOptionPane.YES_NO_OPTION,
		JOptionPane.QUESTION_MESSAGE, null, opciones, "Aceptar");
		if (eleccion == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
	
	public void paint() {
		// TODO Auto-generated method stub
		Graphics g = strategy.getDrawGraphics();
		g.setColor(Color.getColor(nm)));
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		for (ObjetosArkanoid o : this.participantes) {
			o.paint(g);
		}
		
		
		if (this.gameEnded == true) {
			paintGameOver(g);
		}
		 
		this.paintLife(g);
		
		strategy.show();
	}
	
	//método para que la bola se vaya moviendo
	public void updateWorld() {
		//recorro lista de participantes en el juego y selecciono algunos para  borrar
		List<ObjetosArkanoid>objetosForRemoval = new ArrayList<ObjetosArkanoid>();
		for (ObjetosArkanoid objeto : this.participantes) {
			if(objeto.isMarkedForRemoval()) {
				objetosForRemoval.add(objeto);
			}
		}
		//elimino los participantes marcados para su eliminación
		for (ObjetosArkanoid objeto : objetosForRemoval) {
			this.participantes.remove(objeto);
		}
		//limpio la lista de actores para eliminar
		objetosForRemoval.clear();
		
		//insertamos nuevos objetos a la iteracion y después borramos esta misma lista
		this.participantes.addAll(newParticipantesForNextIteration);
		this.newParticipantesForNextIteration.clear();
		
		//se recorre lista de participantes y se actua mediante el metodo
		 for (ObjetosArkanoid objeto : this.participantes) {
			 objeto.act();
			 
		 }
		 
		 for (ObjetosArkanoid participante1 : this.participantes) {
			 
			 Rectangle rect1 = new Rectangle(participante1.getX(), participante1.getY(), participante1.getWidth(), participante1.getHeigth());
			 
			 for (ObjetosArkanoid participante2 : this.participantes) {
			
				 //if (!participante1.equals(participante2)) {
				if ((participante1 instanceof Pelota)) {
					 Rectangle rect2 = new Rectangle(participante2.getX(), participante2.getY(), participante2.getWidth(), participante2.getHeigth());
					 
					 if (rect1.intersects(rect2)) {
						 participante1.collisionWith(participante2);
						 participante2.collisionWith(participante1);
						 break;
					 }
				 }
			 }
		 }
		 
		
		 if (participantes.size()==2 && !gameEnded) {
			 quedanLadrillos = false;
			 segundaFase();
			 pelota.setMarkedForRemoval(true);
			 
			 
		 }
			 
			 
		 }
		 	
	public void initGame() {
		
			primeraFase();
			//segundaFase();
		
	}
	
	//método con el que pintamos imagen para saber si el jugador ha perdido
	public void paintGameOver (Graphics g) {
		g.drawImage(SpritesRepository.getInstance().getSprite(SpritesRepository.getInstance().GAME_OVER), Arkanoid.getInstance().getWidth()/4, 
				Arkanoid.getInstance().getHeight()/4, null);
		strategy.show();
	}
		
	//método para pintar la vida que le queda al jugador
	public void paintLife(Graphics g) {
		int y = 700;
		int x = 0;
		for (int i = 0; i < pelota.getShields(); i++) {
			BufferedImage nave = SpritesRepository.getInstance().getSprite("nave-50x15.png");
			g.drawImage(nave, x , y + nave.getWidth(), this);
			x += nave.getWidth();
		}
		
	}
	public void game () {
	// Inicialización del juego
				
			initGame();
		
			
			// Este bucle se ejecutará mientras el objeto Canvas sea visible.
			while (this.isVisible()) {
				// Tomamos el tiempo en milisegundos antes de repintar el frame
				long millisAntesDeConstruirEscena = System.currentTimeMillis();
				// Actualizamos y pintamos el nuevo frame
				updateWorld();
				paint();
				// Calculamos la cantidad de milisegundos que se ha tardado en realizar un nuevo frame del juego
				int millisUsados = (int) (System.currentTimeMillis() - millisAntesDeConstruirEscena);
				// Hago que el programa duerma lo suficiente para que realmente se ejecuten la cantidad de FPS
				// que tenemos programados
				try { 
					int millisADetenerElJuego = 1000 / SPEED_FPS - millisUsados;
					if (millisADetenerElJuego >= 0) {
						 Thread.sleep(millisADetenerElJuego);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
	}
	
	//método para crear la primera fase de nuestro juego
	public void primeraFase() {
		SoundsRepository.getInstance().playSound(SoundsRepository.getInstance().INICIO_FASE);
		
		int cantidadLadrillosColocar = this.getWidth() / Ladrillo.getANCHO();
		int incrementoY = 2;
		int separacion = 15;
		for (int i = 0; i < Ladrillo.COLORES.length; i++) {
			for (int j = 0; j <  cantidadLadrillosColocar ; j++) {
				Ladrillo ladrillo = new Ladrillo((int) ((j * Ladrillo.getANCHO())+ separacion ), incrementoY * Ladrillo.getALTO(), Ladrillo.COLORES[i]);
				participantes.add(ladrillo);
				//ladrillos.add(ladrillo);
				separacion+= 5;
				//CADA VEZ QUE CREAMOS UN LADRILLO AUMENTAMOS EL CONTADOR
				contadorLadrillos++;
			}
			separacion = 15;
			incrementoY += 2;
			//System.out.println("hay un total de " + contadorLadrillos);
		}
		Pelota pelota = new Pelota();
		Nave nave = new Nave();
		nave.setX(150);
		nave.setY(700);
		pelota.setX(nave.getX() + nave.getWidth()/2 - pelota.getWidth()/2);
		pelota.setY(nave.getY() - 15);
		//participantes.add(ladrillo);
		participantes.add(nave);
		participantes.add(pelota);
		this.nave = nave;
		this.pelota = pelota;
		this.addKeyListener(nave);		
		this.addMouseMotionListener(nave);
		this.addKeyListener(pelota);
		
		
	}
	
	//método de creación de la segunda fase de nuestro juego
	public void segundaFase() {
		SoundsRepository.getInstance().playSound(SoundsRepository.getInstance().INICIO_FASE);
		int cantidadLadrillosColocar = this.getWidth() / Ladrillo.getANCHO();
		int incrementoY = 2;
		int separacion = 10;
		for (int i = 0; i < Ladrillo.COLORES.length ; i++) {
			for (int j = 0; j < cantidadLadrillosColocar-2; j++) {
				Ladrillo ladrillo = new Ladrillo((j * Ladrillo.getANCHO())+ separacion, incrementoY * Ladrillo.getALTO());
				participantes.add(ladrillo);
				//ladrillos.add(ladrillo);
				separacion+= 10;
				
				
			}
			cantidadLadrillosColocar -=2;
			
			//CADA VEZ QUE CREAMOS UN LADRILLO AUMENTAMOS EL CONTADOR
			separacion += 60;
			incrementoY += 2;
		}
		
		//System.out.println("hay un total de " + contadorLadrillos);
	
	Pelota pelota = new Pelota();
	Nave nave = new Nave();
	nave.setX(150);
	nave.setY(700);
	pelota.setX(nave.getX() + nave.getWidth()/2 - pelota.getWidth()/2);
	pelota.setY(nave.getY() - 15);
	//participantes.add(ladrillo);
	this.participantes.add(nave);
	this.participantes.add(pelota);
	this.nave = nave;
	//this.pelota = pelota;
	this.addKeyListener(nave);		
	this.addMouseMotionListener(nave);
	this.addKeyListener(pelota);
	}
	
	public boolean noQuedanLadrillosFase () {
		
		String [] opciones ={"Aceptar","Cancelar"};
		int eleccion = JOptionPane.showOptionDialog(ventana,"¿QUIERE PASAR DE FASE?","AVANCE FASE",
		JOptionPane.YES_NO_OPTION,
		JOptionPane.QUESTION_MESSAGE, null, opciones, "Aceptar");
		if (eleccion == JOptionPane.YES_OPTION) {
			setQuedanLadrillos(false);
			System.out.println("ha elegido seguir jugando");
			
		}else {
			System.exit(0);
		}
				
		return false;
	}
	
	
	public void addNewParticipanteToNextIteration (ObjetosArkanoid newParticipante) {
		this.newParticipantesForNextIteration.add(newParticipante);
	}
	
	
	public Nave getNave() {
		return nave;
	}

	public void setNave(Nave nave) {
		this.nave = nave;
	}
	
	

	public boolean isGameEnded() {
		return gameEnded;
	}

	public void setGameEnded(boolean gameEnded) {
		this.gameEnded = gameEnded;
	}
	

	public boolean isQuedanLadrillos() {
		return quedanLadrillos;
	}

	public void setQuedanLadrillos(boolean quedanLadrillos) {
		this.quedanLadrillos = quedanLadrillos;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Arkanoid.getInstance().game();

	}

	
}
