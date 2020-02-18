package juegosProgramacion_Arkanoid;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;



public class Nave extends ObjetosArkanoid implements KeyListener, MouseMotionListener {

	protected int vx, vy;
	
	private boolean left, right; //up, down;
	
	protected static final int NAVE_SPEED = 6;
	
	
	
	public Nave() {
		super(new String [] {"nave-50x15.png"});
		// TODO Auto-generated constructor stub
	}


	public Nave (String spriteName) {
		super();
		spriteActual = SpritesRepository.getInstance().getSprite(spriteName);
		this.x = Arkanoid.getInstance().getWidth()/2;
		this.y = Arkanoid.getInstance().getHeight()-50;
		
		//this.width = width;
		//this.height = height;
	}

	public Nave(int x, int y) {
		super(x, y);

		
	}

	
	@Override
	public void act() {
		// TODO Auto-generated method stub
		super.act();
		// Movimiento en el eje horizontal
		this.x += this.vx; // En cada iteración del bucle principal, la nave cambiará su posición en el eje X, sumándole a esta el valor de vx
		// si la nave intenta salir por la derecha no se lo permitimos
		if (this.x <  0) {
			this.x = 0;
		}
		// si la nave intenta salir por la izquierda no se lo permitimos
		if (this.x >  (Arkanoid.getInstance().getWidth() - this.width)) {
			this.x = (Arkanoid.getInstance().getWidth() - this.width);
		}
	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(SpritesRepository.getInstance().getSprite(SpritesRepository.getInstance().NAVE), this.x, this.y, null);
		
	}
	
	

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		switch (e.getKeyCode()) {
  		
		case KeyEvent.VK_LEFT : left = true; break;
		case KeyEvent.VK_RIGHT : right = true; break;
		
		
  	}
  	updateSpeed();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_LEFT : left = false; break; 
			case KeyEvent.VK_RIGHT : right = false;break;
	}
	updateSpeed();
	}

	/*public int getBolasLanzadas() {
		return BOLASLANZADAS;
	}


	public void setBolasLanzadas(int bolasLanzadas) {
		this.BOLASLANZADAS = bolasLanzadas;
	}


	public void lanzarBola () {
		if (BOLASLANZADAS > 0) {
		Pelota pelota = new Pelota();
		pelota.setX(this.x + this.width/2 - pelota.getWidth()/2);
		pelota.setY(this.y - 15);
		Arkanoid.getInstance().addNewParticipanteToNextIteration(pelota);
		SoundsRepository.getInstance().playSound(SoundsRepository.getInstance().LANZAMIENTO);
		this.BOLASLANZADAS--;
		}
	}*/
	
	@Override
	public void collisionWith(ObjetosArkanoid objetoCollisioned) {
		// TODO Auto-generated method stub
		super.collisionWith(objetoCollisioned);
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	protected void updateSpeed() {
		vx=0;vy=0;
		//if (down) vy = NAVE_SPEED;
		//if (up) vy = -NAVE_SPEED;
		if (left) vx = -NAVE_SPEED;
		if (right) vx = NAVE_SPEED;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseMoved(MouseEvent e) {
		setX(e.getX());
		
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


	

	
	

	

}
