package examenRecu2018;

public class Humano extends Personaje {

	public Humano(String nombre, int puntosVida, boolean vivo) {
		super(nombre, puntosVida, vivo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Humano [getNombre()=" + getNombre() + ", getPuntosVida()=" + getPuntosVida() + ", isVivo()=" + isVivo()
				+ "]";
	}
	

}
