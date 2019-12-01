package tema4_OrientacionaObjetos_Comestibles;

public class Comestible {

	public String codigo;
	public String nombre;
	public float precio;
	
	public Comestible() {
		// TODO Auto-generated constructor stub
	}

	public Comestible(String codigo, String nombre, float precio) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
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
		return "Comestible [codigo=" + codigo + ", nombre=" + nombre + ", precio=" + precio + "]";
	}
	
	

}
