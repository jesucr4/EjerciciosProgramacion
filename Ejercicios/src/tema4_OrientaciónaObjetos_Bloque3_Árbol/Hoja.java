package tema4_OrientaciónaObjetos_Bloque3_Árbol;

public class Hoja extends Elemento_Arbol {
	
	public String nombre;
	
	public Hoja() {
		// TODO Auto-generated constructor stub
	}
	
	public Hoja(String nombre) {
		super();
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Hoja [nombre=" + nombre + "]";
	}

	public String getHoja() {
		return nombre;
	}

	public void setHoja(String hoja) {
		this.nombre = hoja;
	}

	

}
