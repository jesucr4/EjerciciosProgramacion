package juegoFormula1;

public class Pista {

	
	private Obstaculo obstaculos [] = new Obstaculo [4];
	
	private int longitudPista = 100;
	
	public Pista() {
			
		}

	
	
	public Pista(Obstaculo[] obstaculos, int longitudPista) {
		super();
		this.obstaculos = obstaculos;
		this.longitudPista = longitudPista;
		
		
		for (int i = 0; i < obstaculos.length; i++) {
			
		}
	}



	public int getLongitudPista() {
		return longitudPista;
	}


	public void setLongitudPista(int longitudPista) {
		this.longitudPista = longitudPista;
	}


	public Obstaculo[] getObstaculos() {
		return obstaculos;
	}

	public void setObstaculos(Obstaculo[] obstaculos) {
		this.obstaculos = obstaculos;
	}
	
	

}
