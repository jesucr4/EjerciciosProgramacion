package tema4_OrientaciónaObjetos_Bloque3_Árbol.copy;

public class Rama extends Elemento_Arbol {
	
	public String Elemento1;
	public String Elemento2;
	public String Elemento3;
	
	public Rama() {
		// TODO Auto-generated constructor stub
	}

	public String getElemento1() {
		return Elemento1;
	}

	public void setElemento1(String elemento1) {
		Elemento1 = elemento1;
	}

	public String getElemento2() {
		return Elemento2;
	}

	public void setElemento2(String elemento2) {
		Elemento2 = elemento2;
	}

	public String getElemento3() {
		return Elemento3;
	}

	public void setElemento3(String elemento3) {
		Elemento3 = elemento3;
	}

	@Override
	public String toString() {
		return "Rama [Elemento1=" + Elemento1 + ", Elemento2=" + Elemento2 + ", Elemento3=" + Elemento3
				+ ", toString()=" + super.toString() + "]";
	}
	
}
