package tema4_Orientaci�naObjetos_Bloque3_�rbol.copy;

public class Fruta extends Elemento_Arbol {

	public String nombre;
	
	public Fruta() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Fruta [nombre=" + nombre + ", toString()=" + super.toString() + "]";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	

}
