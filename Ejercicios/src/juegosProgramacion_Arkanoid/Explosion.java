package juegosProgramacion_Arkanoid;

public class Explosion extends ObjetosArkanoid {

	//array con los nombres de los sprites que forman la explosion
	
	private static String[] SPRITES = new String [] {"sprite-explosion1.png", "sprite-explosion2.png", "sprite-explosion3.png",
			"sprite-explosion4.png", "sprite-explosion5.png", "sprite-explosion6.png", 
			"sprite-explosion7.png", "sprite-explosion8.png", "sprite-explosion9.png" };
	
	public Explosion() {
		super(SPRITES, 5);
	}
		// TODO Auto-generated constructor stub
	

	/*public Explosion(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}*/

	public Explosion(String[] spriteNames) {
		super(spriteNames);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void act() {
		// TODO Auto-generated method stub
		super.act();
		if (this.getSpriteActual().equals(this.sprites.get(this.sprites.size()-1))) {
			this.setMarkedForRemoval(true);
		}
	}


	public Explosion(String[] spriteNames, int velocidadDeCambioDeSprite) {
		super(spriteNames, velocidadDeCambioDeSprite);
		// TODO Auto-generated constructor stub
	}

}
