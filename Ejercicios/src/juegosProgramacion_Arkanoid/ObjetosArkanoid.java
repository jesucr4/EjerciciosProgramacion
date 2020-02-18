package juegosProgramacion_Arkanoid;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;


public abstract class ObjetosArkanoid {

	protected int x, y;
	protected int width;
	protected int height;
	protected BufferedImage spriteActual;
	
	protected List<BufferedImage> sprites = new ArrayList<BufferedImage>(); // Lista de archivos de imagen utilizado para representarse en pantalla
	private int unidadDeTiempo = 0; // La unidad de tiempo aumenta cada vez que se llama al método "act()" del Actor
	protected int velocidadDeCambioDeSprite = 0;  // Esta propiedad indica cada cuántas "unidades de tiempo" debemos mostrar
												  // el siguiente sprite del actor

	protected boolean markedForRemoval = false;
	public ObjetosArkanoid() {
		// TODO Auto-generated constructor stub
	}

	public ObjetosArkanoid(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public ObjetosArkanoid(String spriteNames[]) {
		this.velocidadDeCambioDeSprite = 1;
		cargarImagenesDesdeSpriteNames(spriteNames);
	}
	
	/**
	 * 
	 * @param spriteNames
	 * @param velocidadDeCambioDeSprite
	 */
	public ObjetosArkanoid (String spriteNames[], int velocidadDeCambioDeSprite) {
		this.velocidadDeCambioDeSprite = velocidadDeCambioDeSprite;
		cargarImagenesDesdeSpriteNames(spriteNames);
	}
	
	
	
	public void paint(Graphics g) {
		if (this.spriteActual != null) {
			g.drawImage(this.spriteActual, this.x, this.y, null);
		}
	}
	
	public void act() {
		// En el caso de que exista un array de sprites el actor actual se tratará de una animación, para eso llevaremos a cabo los siguientes pasos
		if (this.sprites != null && this.sprites.size() > 1) {
			// cada vez que llaman a "act()" se incrementará esta unidad, siempre que existan sprites
			unidadDeTiempo++;
			// Si la unidad de tiemplo coincide o es múltiplo de la velocidad de cambio de sprite, entramos al if
			if (unidadDeTiempo % velocidadDeCambioDeSprite == 0){
				// Reiniciamos la unidad de tiempo
				unidadDeTiempo = 0;
				// Obtengo el índice del spriteActual, dentro de la lista de índices
				int indiceSpriteActual = sprites.indexOf(this.spriteActual);
				// Obtengo el siguiente índice de sprite, teniendo en cuenta que los sprites cambian de uno a otro en ciclo
				int indiceSiguienteSprite = (indiceSpriteActual + 1) % sprites.size();
				// Se selecciona el nuevo spriteActual
				this.spriteActual = sprites.get(indiceSiguienteSprite);
			}
		}
	}
	
	public void collisionWith (ObjetosArkanoid objetoCollisioned) {}

	private void cargarImagenesDesdeSpriteNames (String spriteNames[]) {
		// Obtengo las imágenes de este actor, a partir del patrón de diseño Singleton con el que se encuentra
		// el spritesRepository
		for (String sprite : spriteNames) {
			this.sprites.add(SpritesRepository.getInstance().getSprite(sprite));
		}
		// ajusto el primer sprite del actor
		if (this.sprites.size() > 0) {
			this.spriteActual = this.sprites.get(0);
		}
		adjustHeightAndWidth ();
	}
	private void adjustHeightAndWidth () {
		// Una vez que tengo las imágenes que representa a este actor, obtengo el ancho y el alto máximos de las mismas y se
		// los traspaso a objeto actual.
		if (this.sprites.size() > 0) {
			this.height = this.sprites.get(0).getHeight();
			this.width = this.sprites.get(0).getWidth();
		}
		for (BufferedImage sprite : this.sprites) {
			// Ajusto el máximo width como el width del actor
			if (sprite.getWidth() > this.width) {
				this.width = sprite.getWidth();
			}
			// Lo mismo que el anterior, pero con el máximo height
			if (sprite.getHeight() > this.height) {
				this.height = sprite.getHeight();
			}
		}
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeigth() {
		return height;
	}

	public void setHeigth(int heigth) {
		this.height = heigth;
	}


	
	public boolean isMarkedForRemoval() {
		return markedForRemoval;
	}

	public void setMarkedForRemoval(boolean markedForRemoval) {
		this.markedForRemoval = markedForRemoval;
	}

	public BufferedImage getSpriteActual() { return spriteActual; }
	public void setSpriteActual(BufferedImage spriteActual) { this.spriteActual = spriteActual; }

	
}
