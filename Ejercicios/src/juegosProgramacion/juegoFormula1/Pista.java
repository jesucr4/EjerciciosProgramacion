package juegoFormula1;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;




public class Pista extends Actor{

	public static int MARGEN = 2;
	List<Obstaculo> obstaculosEnPista = new ArrayList<Obstaculo>();
	public static int longitudPista = 100;
	protected int x,y, width, height;
	
	

	public Pista(int x, int y, int width, int height) {
		super (x,y);
		this.width = width;
		this.height = height;
		
		//dentro del constructor creamos una serie de obstáculos de distinto tipo para que al crear una pista se creen automáticamente
		Rampa rampa1 = new Rampa();
		Rampa rampa2 = new Rampa();
		ManchaAceite mancha1 = new ManchaAceite();
		ManchaAceite mancha2 = new ManchaAceite();
		
		//añadimos cada uno de los obstaculos al arrayList que hemos creado antes
		obstaculosEnPista.add(rampa1);
		obstaculosEnPista.add(mancha1);
		obstaculosEnPista.add(rampa2);
		obstaculosEnPista.add(mancha2);
	}


	public Pista(String nombrePista) {
		super();
		this.longitudPista = longitudPista;
		//dentro del constructor creamos una serie de obstáculos de distinto tipo para que al crear una pista se creen automáticamente
		Rampa rampa1 = new Rampa();
		Rampa rampa2 = new Rampa();
		ManchaAceite mancha1 = new ManchaAceite();
		ManchaAceite mancha2 = new ManchaAceite();
		
		//añadimos cada uno de los obstaculos al arrayList que hemos creado antes
		obstaculosEnPista.add(rampa1);
		obstaculosEnPista.add(mancha1);
		obstaculosEnPista.add(rampa2);
		obstaculosEnPista.add(mancha2);
		//this.obstaculosEnPista = obstaculosEnPista;
		//imprimeList(obstaculosEnPista, "Obstaculos");
		
	}
	
	
	public void paint(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(this.x, this.y, this.width, this.height);
		

		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.white);
		g2d.setStroke(RenderizableUtils.SIMPLE);
		g2d.drawRect(this.x + MARGEN, this.y + MARGEN, this.width - 2 * MARGEN, this.height - 2 * MARGEN);
	}


	@Override
	public void act() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}

	
	




