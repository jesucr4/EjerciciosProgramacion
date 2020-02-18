package juegoFormula1;

import java.awt.Color;
import java.awt.Graphics;

public class ManchaAceite extends Obstaculo {

	

	public ManchaAceite() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public ManchaAceite(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}



	@Override
	public void paint(Graphics g) {
	g.setColor(Color.YELLOW);
	g.fillRoundRect(this.posicion, this.pista.getY() + 5 , 25, 25, 25, 15);
	
	
		
	}


}
