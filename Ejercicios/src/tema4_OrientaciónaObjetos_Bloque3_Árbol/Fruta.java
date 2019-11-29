package tema4_OrientaciónaObjetos_Bloque3_Árbol;

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
