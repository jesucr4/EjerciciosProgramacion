package tema4_OrientaciónaObjetos_Bloque3_Árbol;

public abstract class Elemento_Arbol {
	public String nombre;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Elemento_Arbol [nombre=" + nombre + ", toString()=" + super.toString() + "]";
	}
	
	
	
}
