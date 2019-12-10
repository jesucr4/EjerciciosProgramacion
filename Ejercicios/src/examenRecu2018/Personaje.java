package examenRecu2018;

public class Personaje {

	private String nombre;
	private int puntosVida;
	private boolean vivo;
	
	public String getNombre() {
		return nombre;
	}
	public Personaje(String nombre, int puntosVida, boolean vivo) {
		super();
		this.nombre = nombre;
		this.puntosVida = puntosVida;
		this.vivo = vivo;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getPuntosVida() {
		return puntosVida;
	}
	public void setPuntosVida(int puntosVida) {
		this.puntosVida = puntosVida;
	}
	public boolean isVivo() {
		return vivo;
	}
	public void setVivo(boolean vivo) {
		this.vivo = vivo;
	}
	
	@Override
	public String toString() {
		return "Personaje [nombre=" + nombre + ", puntosVida=" + puntosVida + ", vivo=" + vivo + "]";
	}	
	
}

