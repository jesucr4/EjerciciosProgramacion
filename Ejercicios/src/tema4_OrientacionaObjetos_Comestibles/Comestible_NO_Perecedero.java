package tema4_OrientacionaObjetos_Comestibles;

public class Comestible_NO_Perecedero extends Comestible {

	public Comestible_NO_Perecedero() {
		// TODO Auto-generated constructor stub
	}

	public Comestible_NO_Perecedero(String codigo, String nombre, float precio) {
		super(codigo, nombre, precio);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Comestible_NO_Perecedero [getCodigo()=" + getCodigo() + ", getNombre()=" + getNombre()
				+ ", getPrecio()=" + getPrecio() + "]";
	}
	

}
