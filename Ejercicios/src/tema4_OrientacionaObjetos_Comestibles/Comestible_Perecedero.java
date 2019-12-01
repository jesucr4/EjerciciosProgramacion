package tema4_OrientacionaObjetos_Comestibles;

public class Comestible_Perecedero extends Comestible {
	
	private String caducidad;

	public Comestible_Perecedero() {
		// TODO Auto-generated constructor stub
	}

	public Comestible_Perecedero(String codigo, String nombre, float precio, String caducidad) {
		super(codigo, nombre, precio);
		this.caducidad = caducidad;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Comestible_Perecedero [caducidad=" + caducidad + ", getCodigo()=" + getCodigo() + ", getNombre()="
				+ getNombre() + ", getPrecio()=" + getPrecio() + "]";
	}
	
	
	

	
	
	

}
