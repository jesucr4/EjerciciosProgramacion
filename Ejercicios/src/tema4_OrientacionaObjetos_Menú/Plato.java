package tema4_OrientacionaObjetos_Menú;

public class Plato {
	
	public String nombre;
	public float precio;

	public Plato() {
		super();
		this.nombre = "Plato sin nombre";
		this.precio = 0.01F;
	}
	

	public Plato(String nombre, float precio) {
		super();
		this.nombre = nombre;
		this.precio = precio;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}


	@Override
	public String toString() {
		return "Plato [nombre=" + nombre + ", precio=" + precio + "]";
	}


	
	
	

}
