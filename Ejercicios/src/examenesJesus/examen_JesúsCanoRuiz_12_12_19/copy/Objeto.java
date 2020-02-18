package examen_JesúsCanoRuiz_12_12_19.copy;

import tema5_arrays.Utils;


public abstract class Objeto {

	private String nombre;
	private int id_Objeto = 0;
	private int suciedad_Objeto;
	private int durezaSuciedad_Objeto;
	private int dificultadLimpieza_Objeto;
	private Objeto pila[] = new Objeto[20];
	/**
	 * 
	 * @param id_Objeto
	 */
	
	public Objeto(String nombre) {
		super();
		this.nombre = nombre;
		this.id_Objeto = id_Objeto;
		this.suciedad_Objeto = Utils.obtenerNumeroAzar(10, 100);
		this.durezaSuciedad_Objeto = Utils.obtenerNumeroAzar(1, 3);
		this.dificultadLimpieza_Objeto = this.suciedad_Objeto + this.durezaSuciedad_Objeto;
		for (int i = 0; i < 5; i++) {
			pila[this.id_Objeto] = new Plato(id_Objeto) ;
			this.id_Objeto++;
		}
		
		for (int i = 0; i < 5; i++) {
			pila[this.id_Objeto] = new Fuente(id_Objeto) ;
			this.id_Objeto++;
		}
		
		for (int i = 0; i < 5; i++) {
			pila[this.id_Objeto] = new Cubierto(id_Objeto) ;
			this.id_Objeto++;
		}
		
		for (int i = 0; i < 5; i++) {
			pila[this.id_Objeto] = new Vaso(id_Objeto) ;
			this.id_Objeto++;
		}
		
	}
	
	
	
	
	
	/**
	 * 
	 * @return
	 */
	public abstract Boolean  seRompe ();
	
	/**
	 * 
	 * @return
	 */
	public int getId_Objeto() {
		return id_Objeto;
	}
	/**
	 * 
	 * @param id_Objeto
	 */
	public void setId_Objeto(int id_Objeto) {
		this.id_Objeto = id_Objeto;
	}
	/**
	 * 
	 * @return
	 */
	public int getSuciedad_Objeto() {
		return suciedad_Objeto;
	}
	/**
	 * 
	 * @param suciedad_Objeto
	 */
	public void setSuciedad_Objeto(int suciedad_Objeto) {
		this.suciedad_Objeto = suciedad_Objeto;
	}
	/**
	 * 
	 * @return
	 */
	public int getDurezaSuciedad_Objeto() {
		return durezaSuciedad_Objeto;
	}
	/**
	 * 
	 * @param durezaSuciedad_Objeto
	 */
	public void setDurezaSuciedad_Objeto(int durezaSuciedad_Objeto) {
		this.durezaSuciedad_Objeto = durezaSuciedad_Objeto;
	}
	/**
	 * 
	 * @return
	 */
	public int getDificultadLimpieza_Objeto() {
		return dificultadLimpieza_Objeto;
	}
	/**
	 * 
	 * @param dificultadLimpieza_Objeto
	 */
	public void setDificultadLimpieza_Objeto(int dificultadLimpieza_Objeto) {
		this.dificultadLimpieza_Objeto = dificultadLimpieza_Objeto;
	}




	public Objeto[] getPila() {
		return pila;
	}




	public void setPila(Objeto[] pila) {
		this.pila = pila;
	}
	
}

