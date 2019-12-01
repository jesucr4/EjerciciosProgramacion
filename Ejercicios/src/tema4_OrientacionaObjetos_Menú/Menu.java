package tema4_OrientacionaObjetos_Menú;

public class Menu {

	private Plato primerPlato;
	private Plato segundoPlato;
	private Plato postre;
	
	public Menu() {
		super();
	}

	public Menu(Plato primerPlato, Plato segundoPlato, Plato postre) {
		super();
		this.primerPlato = primerPlato;
		this.segundoPlato = segundoPlato;
		this.postre = postre;
	}
	
	public float getPrecio() {
		return this.primerPlato.getPrecio() + this.segundoPlato.getPrecio()+ this.postre.getPrecio();
	}

	public Plato getPrimerPlato() {
		return primerPlato;
	}

	public void setPrimerPlato(Plato primerPlato) {
		this.primerPlato = primerPlato;
	}

	public Plato getSegundoPlato() {
		return segundoPlato;
	}

	public void setSegundoPlato(Plato segundoPlato) {
		this.segundoPlato = segundoPlato;
	}

	public Plato getPostre() {
		return postre;
	}

	public void setPostre(Plato postre) {
		this.postre = postre;
	}

	@Override
	public String toString() {
		return "Menu [primerPlato=" + primerPlato + ", segundoPlato=" + segundoPlato + ", postre=" + postre
				+ ", getPrecio()=" + getPrecio() + "]";
	}
	
	

}
