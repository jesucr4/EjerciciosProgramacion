package juegosProgramacion_Arkanoid;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.Date;


public class Pelota extends ObjetosArkanoid implements KeyListener {

	protected BufferedImage image;
	protected int vx = 3;
	protected int vy = 3;
	protected float distancia = 5;
	protected float aumentoVelocidad = 0.05f;
	protected int limiteAumentoVelocidad = 10;
	public static final int DIAMETRO = 15;
	
	public int MAX_SHIELDS = 2;
	private int shields;
	
	public static int SHIELD_RETRIEVED_FOR_LOST_BALL = 1;
	
	//protected int BOLAS_LANZADAS = 1;
	
	TrayectoriaRecta trayectoria = null;
	PuntoAltaPrecision coordenadas = null;
	
	
	/*public Pelota (String spriteName) {
		this.image = SpritesRepository.getInstance().getSprite(spriteName);
	}*/

	public Pelota() {
		super();
		spriteActual = null;
		this.x = Arkanoid.getInstance().getHeight()/2;
		this.y = Arkanoid.getInstance().getWidth()/2;
		this.width = DIAMETRO;
		this.height = DIAMETRO;
		this.shields = MAX_SHIELDS;
	}

	
	@Override
	public void paint(Graphics g) {
		//g.drawImage(this.image, this.x, this.y, null);
		//g.drawImage(SpritesRepository.getInstance().getSprite(SpritesRepository.getInstance().BOLA), this.x, this.y, null);
		g.setColor(Color.WHITE);
		g.fillOval(this.x, this.y, DIAMETRO, DIAMETRO);
	}
	
	@Override
	public void act() {
		
		if (this.trayectoria == null) {
			this.x = Arkanoid.getInstance().getNave().getX() + Arkanoid.getInstance().getNave().getWidth() / 2 - this.width / 2;
			this.y = Arkanoid.getInstance().getNave().getY() - this.height - 1;
		}
		else { // La trayectoria ya existe
			this.coordenadas = this.trayectoria.getPuntoADistanciaDePunto(this.coordenadas, distancia);
			this.x = Math.round(this.coordenadas.x);
			this.y = Math.round(this.coordenadas.y);
			
		}
		
		if ( this.x > (Arkanoid.getInstance().getWidth()-this.width) || this.x < 0){
			this.trayectoria.reflejarHorizontalmenteRespectoAPunto(coordenadas);
		}
	
		if ( this.y > Arkanoid.getInstance().getHeight()-this.height ) {
			this.trayectoria.reflejarVerticalmenteRespectoAPunto(coordenadas);
			this.retrieveShields(SHIELD_RETRIEVED_FOR_LOST_BALL);
			System.out.println("la bola ha rebotado por debajo la nave");
		}
		if (this.y < 0) {
			this.trayectoria.reflejarVerticalmenteRespectoAPunto(coordenadas);
		}
	
	}
	
	
	public void retrieveShields (int shieldsToRetrieve) {
		this.shields -= shieldsToRetrieve;
		
		if ( this.shields == 0) {
			this.setMarkedForRemoval(true);
			Arkanoid.getInstance().setGameEnded(true);
			
		}
		
	}
	
	/*public void lanzarBola () {
		
		if( this.x < 0 || this.x > (Arkanoid.getInstance().getWidth()- this.width)) {
			vx = -vx;
		}
		this.y += this.vy;
		if (this.y < 0 || this.y > (Arkanoid.getInstance().getHeight() - this.height)) {
			vy = +vy;
		}
		this.x += vx;
		this.y += vy;
		if (BOLAS_LANZADAS > 0) {
		//act();
		SoundsRepository.getInstance().playSound(SoundsRepository.getInstance().LANZAMIENTO);
		BOLAS_LANZADAS--;
		}
		
		
	}*/
	

	@Override
	public void collisionWith(ObjetosArkanoid objetoCollisioned) {
		// TODO Auto-generated method stub
		super.collisionWith(objetoCollisioned);
		
		if (objetoCollisioned instanceof Ladrillo) {
			colisionConLadrillo(objetoCollisioned);
			SoundsRepository.getInstance().playSound(SoundsRepository.getInstance().CHOQUE);
			if ( this.distancia < limiteAumentoVelocidad) {
				this.distancia += distancia * aumentoVelocidad;
			}
		}
		else if (objetoCollisioned instanceof Nave) {
			colisionConNave((Nave) objetoCollisioned);
			SoundsRepository.getInstance().playSound(SoundsRepository.getInstance().NAVE);
		}
	}
	private void colisionConLadrillo (ObjetosArkanoid actorColisionado) {
		int margenLateral = 4; // Este mare
		// Creo pequeños rectángulos que coincidirán con los bordes del ladrillo
		Rectangle rectArribaActor = new Rectangle(actorColisionado.getX(), actorColisionado.getY(), actorColisionado.getWidth(), 1);
		Rectangle rectAbajoActor = new Rectangle(actorColisionado.getX(), actorColisionado.getY() + actorColisionado.getHeigth()-1, actorColisionado.getWidth(), 1);
		Rectangle rectIzquierdaActor = new Rectangle(actorColisionado.getX(), actorColisionado.getY() + margenLateral, 1, actorColisionado.getHeigth() - 2 * margenLateral);
		Rectangle rectDerechaActor = new Rectangle(actorColisionado.getX() + actorColisionado.getWidth()-1, actorColisionado.getY() + margenLateral, 1, actorColisionado.getHeigth() - 2 * margenLateral);

		// variables booleanas que me indicarán una colsión por cada lado del ladrillo
		boolean arriba = false, abajo = false, derecha = false, izquierda = false;
		
		if (this.getRectanguloParaColisiones().intersects(rectArribaActor))  arriba = true;
		if (this.getRectanguloParaColisiones().intersects(rectAbajoActor))  abajo = true;
		if (this.getRectanguloParaColisiones().intersects(rectIzquierdaActor))  izquierda = true;
		if (this.getRectanguloParaColisiones().intersects(rectDerechaActor))  derecha = true;
		
		if (arriba && izquierda) { // Colisión con esquina superior izquierda
			// Coloco la bola en la esquina
			this.x = actorColisionado.x;
			this.y = actorColisionado.y;
			this.coordenadas.x = this.x; this.coordenadas.y = this.y;
			// Recalculo la pendiente
			this.trayectoria.setPendiente(Math.abs(this.trayectoria.getPendiente()), this.coordenadas, false);
			return;
		}
		if (arriba && derecha) {
			this.x = actorColisionado.x + actorColisionado.width;
			this.y = actorColisionado.y;
			this.coordenadas.x = this.x; this.coordenadas.y = this.y;
			this.trayectoria.setPendiente(0-Math.abs(this.trayectoria.getPendiente()), this.coordenadas, true);
			return;
		}
		if (abajo && izquierda) {
			this.x = actorColisionado.x;
			this.y = actorColisionado.y + actorColisionado.height;
			this.coordenadas.x = this.x; this.coordenadas.y = this.y;
			this.trayectoria.setPendiente(0-Math.abs(this.trayectoria.getPendiente()), this.coordenadas, false);
			return;
		}
		if (abajo && derecha) {
			this.x = actorColisionado.x + actorColisionado.width;
			this.y = actorColisionado.y + actorColisionado.height;
			this.coordenadas.x = this.x; this.coordenadas.y = this.y;
			this.trayectoria.setPendiente(Math.abs(this.trayectoria.getPendiente()), this.coordenadas, true);
			return;
		}
		if (abajo) {
			this.y = actorColisionado.y + actorColisionado.height;
			this.coordenadas.y = this.y;
			this.trayectoria.reflejarHaciaAbajo(this.coordenadas);
			return;
		}
		if (arriba) {
			this.y = actorColisionado.y;
			this.coordenadas.y = this.y;
			this.trayectoria.reflejarHaciaArriba(this.coordenadas);
			return;
		}
		if (izquierda) {
			this.x = actorColisionado.x;
			this.coordenadas.x = this.x;
			this.trayectoria.reflejarHaciaIzquierda(this.coordenadas);
			return;
		}
		if (derecha) {
			this.x = actorColisionado.x + actorColisionado.width;
			this.coordenadas.x = this.x;
			this.trayectoria.reflejarHaciaDerecha(this.coordenadas);
			return;
		}
	}
	
	private void colisionConNave (Nave nave) {
		// Creo rectángulos para determinar la zona de la nave con la que choca la bola
		int anchoZonaEspecial = 7; // píxeles que delimitan la zona de rebote especial de la nave
		Rectangle rectIzqNave = new Rectangle(nave.getX(), nave.getY(), anchoZonaEspecial, nave.height);
		Rectangle rectDerNave = new Rectangle(nave.getX() + nave.width - anchoZonaEspecial, nave.getY(), anchoZonaEspecial, nave.height);
		Rectangle rectBola = this.getRectanguloParaColisiones();
		
		// Colisión con el lado derecho de la nave
		if (rectBola.intersects(rectDerNave)) {
			this.y = nave.getY() - nave.getHeigth();
			this.coordenadas.y = this.y;
			if (Math.abs(this.trayectoria.getPendiente()) > 1 ) { // La bola viene on una pendiente mayor a 1
				this.trayectoria.setPendiente(-(float) (Math.random() * (0.8 - 0.3) + 0.3), this.coordenadas, true);
			}
			else { // La bola viene con una pendiente suave ( > 0 y < 1 )
				this.trayectoria.setPendiente(-(float) (Math.random() * (10 - 2) + 2), this.coordenadas, true);
			}
			return;
		}
		// Colisión con el lado izquierdo de la nave
		if (rectBola.intersects(rectIzqNave)) {
			this.y = nave.getY() - nave.getHeigth();
			this.coordenadas.y = this.y;
			if (Math.abs(this.trayectoria.getPendiente()) > 1 ) { // La bola viene con una pendiente mayor a 1
				this.trayectoria.setPendiente((float) (Math.random() * (0.8 - 0.3) + 0.3), this.coordenadas, false);
			}
			else { // La bola viene con una pendiente suave ( > 0 y < 1 )
				this.trayectoria.setPendiente((float) (Math.random() * (10 - 2) + 2), this.coordenadas, false);
			}
			return;
		}
		else { // La bola intersecta la parte central de la nave
			this.trayectoria.reflejarHaciaArriba(this.coordenadas);
			return;
		}			
	}
	public Rectangle getRectanguloParaColisiones () {
		return new Rectangle(this.x + this.width / 2 - 4, this.y + this.height / 2 - 4, 8, 8);
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		switch (e.getKeyCode()) {
		case KeyEvent.VK_SPACE : 
			this.coordenadas = new PuntoAltaPrecision(this.x, this.y);
			this.trayectoria = new TrayectoriaRecta(-3f, this.coordenadas, true);
			SoundsRepository.getInstance().playSound(SoundsRepository.getInstance().LANZAMIENTO);
			break;
		}
		
  	}


	public int getVx() {
		return vx;
	}

	public void setVx(int vx) {
		this.vx = vx;
	}

	public int getVy() {
		return vy;
	}

	public void setVy(int vy) {
		this.vy = vy;
	}

	
	

	public int getShields() {
		return shields;
	}


	public void setShields(int shields) {
		this.shields = shields;
	}


	public int getMaxShields() {
		return MAX_SHIELDS;
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	


	
}
