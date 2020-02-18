package tema6_Recursos_Bloque3;

import java.util.Scanner;

public class Ejercicio02_Contrase�a {

	public static void main(String[] args) {
		boolean mayuscula = false;
		boolean minuscula = false;
		boolean digito = false;
		boolean noAlfanumerico = false;
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println("Dame una contrase�a con may, min, d�gito y car�cter no alfanum�rico");
			String password = sc.next();
			
			for (int i = 0; i < password.length(); i++) {
				if (Character.isUpperCase(password.charAt(i))) {
					mayuscula = true;
				}
				if (Character.isLowerCase(password.charAt(i))) {
					minuscula = true;
				}
				if (Character.isDigit(password.charAt(i))) {
					digito = true;
				}
				if (!Character.isLetterOrDigit(password.charAt(i))) {
					noAlfanumerico = true;
				}
			}
		} while (!(mayuscula && minuscula && digito && noAlfanumerico));
		
		
	}

}
