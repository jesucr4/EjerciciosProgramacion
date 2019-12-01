package tema4_OrientaciónaObjetos_Bloque3_Árbol.copy;

public abstract class Elemento_Arbol {
	public String nombre;

	public static int TIPO_Fruta = 1;
	public static int TIPO_Hoja = 2;
	public static int TIPO_Rama = 3;
	
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
	
	
	public void imprimirÁrbol() {
		
	}
}
