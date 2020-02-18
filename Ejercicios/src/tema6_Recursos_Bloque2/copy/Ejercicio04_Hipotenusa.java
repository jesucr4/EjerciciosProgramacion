package tema6_Recursos_Bloque2.copy;

public class Ejercicio04_Hipotenusa {

	public static void main(String[] args) {
		
		int cateto1 = 4;
		int cateto2 = 5;
		

		double hipotenusa = Math.hypot(cateto1, cateto2);
		
		System.out.println("La hipotenusa de un triángulo cuyos catetos son " 
				+ cateto1 + "cm y " + cateto2 + "cm , es igual a " + hipotenusa + "cm");
	}

}
