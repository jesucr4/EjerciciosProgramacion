package tema4_Orientaci�naObjetos_Bloque3_�rbol.copy;

public class Hoja extends Elemento_Arbol {
	
	public String nombre;
	
	public Hoja() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Hoja [hoja=" + nombre + ", toString()=" + super.toString() + "]";
	}

	public String getHoja() {
		return nombre;
	}

	public void setHoja(String hoja) {
		this.nombre = hoja;
	}

	

}
