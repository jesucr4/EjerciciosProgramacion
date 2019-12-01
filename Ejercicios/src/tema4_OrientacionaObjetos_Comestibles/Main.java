package tema4_OrientacionaObjetos_Comestibles;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Comestible_Perecedero yogurt = new Comestible_Perecedero("5887", "yogur natural", 1f, "2019");
		Comestible_NO_Perecedero patata = new Comestible_NO_Perecedero("222", "patata", 0.5f);
		Comestible_Perecedero queso = new Comestible_Perecedero("5887", "yogur natural", 1f, "01/2020");
		Comestible_NO_Perecedero pan = new Comestible_NO_Perecedero("587", "PAN", 5f);
		
		System.out.println(yogurt.toString());
	}

}
