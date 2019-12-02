package tema4_OrientaciónaObjetos_Bloque3_CuestionesExamen;

public abstract class Cuestion {

	private String enunciado;
	private int respuestaCorrecta;
	
	public Cuestion() {
		// TODO Auto-generated constructor stub
	}

	public Cuestion(String enunciado, int respuestaCorrecta) {
		super();
		this.enunciado = enunciado;
		this.respuestaCorrecta = respuestaCorrecta;
	}

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public int getRespuestaCorrecta() {
		return respuestaCorrecta;
	}

	public void setRespuestaCorrecta(int respuestaCorrecta) {
		this.respuestaCorrecta = respuestaCorrecta;
	}

	@Override
	public String toString() {
		return "Cuestion [enunciado=" + enunciado + ", respuestaCorrecta=" + respuestaCorrecta + "]";
	}
	
	public abstract void mostrarEnPantalla();
	
	public abstract void evaluar();

}
