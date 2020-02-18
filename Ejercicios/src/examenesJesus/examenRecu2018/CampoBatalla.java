package examenRecu2018;

import java.util.Arrays;

import examen_Jesus_Cano_Ruiz.Utils;

public class CampoBatalla {
	private String nombre; 
	
	private Malvado personajeMalvado [] = new Malvado [20];
	private Humano personajeHumano [] = new Humano [20];

	
	@Override
	public String toString() {
		return "CampoBatalla [nombre=" + nombre + ", personajeMalvado=" + Arrays.toString(personajeMalvado)
				+ ", personajeHumano=" + Arrays.toString(personajeHumano) + "]";
	}


	public CampoBatalla(Malvado[] personajeMalvado, Humano[] personajeHumano) {
		super();
		this.personajeMalvado = personajeMalvado;
		this.personajeHumano = personajeHumano;
	}


	public CampoBatalla(String nombre) {
		super();
		this.nombre = nombre;
		for (int i = 0; i < personajeHumano.length; i++) {
			Humano humano = new Humano("humano" + i , Utils.obtenerNumeroAzar(50, 100), true);
			personajeHumano[i] = humano;
		}
		
		
		for (int i = 0; i < personajeMalvado.length; i++) {
			Malvado malvado = new Malvado("malvado" + i, Utils.obtenerNumeroAzar(50, 100), true);
			personajeMalvado[i] = malvado;
		}
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	/*public CampoBatalla() {
		
		for (int i = 0; i < personajeHumano.length; i++) {
			Humano humano = new Humano("humano" + i , Utils.obtenerNumeroAzar(50, 100), true);
			personajeHumano[i] = humano;
		}
		
		for (int i = 0; i < personajeMalvado.length; i++) {
			Malvado malvado = new Malvado("malvado" + i, Utils.obtenerNumeroAzar(50, 100), true);
			personajeMalvado[i] = malvado;
		}
		
		
	}*/
	
	
	

	
}
