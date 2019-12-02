package tema4_OrientaciónaObjetos_Bloque3_Árbol;

public class Rama extends Elemento_Arbol {
	
	public Elemento_Arbol Elemento1;
	public Elemento_Arbol Elemento2;
	public Elemento_Arbol Elemento3;
	
	@Override
	public String toString() {
		return "Rama [Elemento1=" + Elemento1 + ", Elemento2=" + Elemento2 + ", Elemento3=" + Elemento3 + "]";
	}

	public Rama() {
		// TODO Auto-generated constructor stub
	}

	public Rama(Elemento_Arbol elemento1, Elemento_Arbol elemento2, Elemento_Arbol elemento3) {
		super();
		Elemento1 = elemento1;
		Elemento2 = elemento2;
		Elemento3 = elemento3;
	}

	public Elemento_Arbol getElemento1() {
		return Elemento1;
	}

	public void setElemento1(Elemento_Arbol elemento1) {
		Elemento1 = elemento1;
	}

	public Elemento_Arbol getElemento2() {
		return Elemento2;
	}

	public void setElemento2(Elemento_Arbol elemento2) {
		Elemento2 = elemento2;
	}

	public Elemento_Arbol getElemento3() {
		return Elemento3;
	}

	public void setElemento3(Elemento_Arbol elemento3) {
		Elemento3 = elemento3;
	}
	

	


	
	
	
}
