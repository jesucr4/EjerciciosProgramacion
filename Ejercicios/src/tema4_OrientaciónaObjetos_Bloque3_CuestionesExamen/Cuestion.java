package tema4_OrientaciónaObjetos_Bloque3_CuestionesExamen;

public abstract class Cuestion {

	protected String enunciado;
	protected int respuestaCorrecta;
	
	public Cuestion() {
		// TODO Auto-generated constructor stub
	}

	public Cuestion(String enunciado, int respuestaCorrecta) {
		super();
		this.enunciado = enunciado;
		this.respuestaCorrecta = respuestaCorrecta;
	}
	
	
	


	public boolean esCorrecta(int respuestaUsuario) {
		return this.respuestaCorrecta = respuestaUsuario;
	}

	@Override
	public String toString() {
		return "Cuestion [enunciado=" + enunciado + ", respuestaCorrecta=" + respuestaCorrecta + "]";
	}
	
	public abstract int mostrarEnPantalla ();
	
	

}
