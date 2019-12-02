package tema4_OrientaciónaObjetos_Bloque3_CuestionesExamen;

public class OpcionCorrecta extends Cuestion {

	private String respuesta1;
	private String respuesta2;
	private String respuesta3;
	private String respuesta4;
	
	public OpcionCorrecta() {
		// TODO Auto-generated constructor stub
	}

	
	public OpcionCorrecta(String enunciado, int respuestaCorrecta, String respuesta1, String respuesta2, String respuesta3, String respuesta4) {
		super(enunciado, respuestaCorrecta);
		this.respuesta1 = respuesta1;
		this.respuesta2 = respuesta2;
		this.respuesta3 = respuesta3;
		this.respuesta4 = respuesta4;
	}


	@Override
	public void mostrarEnPantalla() {
		

	}

	@Override
	public void evaluar() {
		// TODO Auto-generated method stub

	}

	

	@Override
	public String toString() {
		return "OpcionCorrecta [respuesta1=" + respuesta1 + ", respuesta2=" + respuesta2 + ", respuesta3=" + respuesta3
				+ ", respuesta4=" + respuesta4 + "]";
	}


	public String getRespuesta1() {
		return respuesta1;
	}


	public void setRespuesta1(String respuesta1) {
		this.respuesta1 = respuesta1;
	}


	public String getRespuesta2() {
		return respuesta2;
	}


	public void setRespuesta2(String respuesta2) {
		this.respuesta2 = respuesta2;
	}


	public String getRespuesta3() {
		return respuesta3;
	}


	public void setRespuesta3(String respuesta3) {
		this.respuesta3 = respuesta3;
	}


	public String getRespuesta4() {
		return respuesta4;
	}


	public void setRespuesta4(String respuesta4) {
		this.respuesta4 = respuesta4;
	}
	
	

}
