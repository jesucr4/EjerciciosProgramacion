package tema6_Recursos_Excepciones_Bombilla;

public class NoMasDeTresPalabras extends Exception {
	private int minimoPalabras;

	public NoMasDeTresPalabras(int minimoPalabras) {
		// TODO Auto-generated constructor stub
		this.minimoPalabras = minimoPalabras;
	}

	public NoMasDeTresPalabras(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public NoMasDeTresPalabras(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public NoMasDeTresPalabras(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public NoMasDeTresPalabras(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}
}
