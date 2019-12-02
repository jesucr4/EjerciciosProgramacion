package tema4_OrientaciónaObjetos_Bloque3_Árbol;

public class Main {

	public static void main(String[] args) {
		Hoja hoja = new Hoja("hoja01");
		Hoja hoja2 = new Hoja("hoja02");
		Fruta fruta = new Fruta("fruta01");
		
		Rama rama1 = new Rama(hoja, hoja2, fruta);
		
		Fruta fruta2 = new Fruta("fruta02");
		Hoja hoja3 = new Hoja("hoja03");
		
		Rama ramaPrincipal = new Rama(hoja3, fruta2, rama1);
		
		System.out.println(ramaPrincipal.toString());
	}

}
