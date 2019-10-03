package tema2;

import javax.swing.JOptionPane;

public class Ejercicio02_bloque2_contadores {

	public static void main(String[] args) {
		int contBajos = 0;
		int contMedios = 0;
		int contGrandes = 0;
		
		String str = JOptionPane.showInputDialog("Introduzca primer número:");
		int num1 = Integer.parseInt(str);
		
		if (num1 >= 0 && num1<=25) {
			contBajos++; //incremento simple
			// contBajos = conBajos + 1;
			// contBajos += 1;
		}
		else {
			if (num1 >=26 && num1 <=250) {
				contMedios++;
			}
			else {
				if (num1 >=251) {
					contGrandes++;
				}
				else {
					if (num1 < 0);{
						return;
					}
					
				}
			}
		}
		
		str = JOptionPane.showInputDialog("Introduzca segundo número:");
		int num2 = Integer.parseInt(str);

		if (num2 >= 0 && num2<=25) {
			contBajos++;
		}
		else {
			if (num2 >=26 && num2 <=250) {
				contMedios++;
			}
			else {
				if (num2 >=251) {
					contGrandes++;
				}
				else {
					if (num2 < 0);{
						return;
					}
					
				}
			}
		}
		str = JOptionPane.showInputDialog("Introduzca tercer número");
		int num3 = Integer.parseInt(str);
		if (num3 >= 0 && num3<=25) {
			contBajos++;
		}
		else {
			if (num3>=26 && num3 <=250) {
				contMedios++;
			}
			else {
				if (num3 >=251) {
					contGrandes++;
				}
				else {
					if (num3 < 0);{
						return;
					}
					
				}
			}
		}
		
		str = JOptionPane.showInputDialog("Introduzca cuarto número");
		int num4 = Integer.parseInt(str);
		
		if (num4 >= 0 && num4<=25) {
			contBajos++;
		}
		else {
			if (num4 >=26 && num4 <=250) {
				contMedios++;
			}
			else {
				if (num4 >=251) {
					contGrandes++;
				}
				else {
					if (num4 < 0);{
						return;
					}
					
				}
			}
		}
		
		str = JOptionPane.showInputDialog("Introduzca quinto número");
		int num5 = Integer.parseInt(str);
		
		if (num5 >= 0 && num5<=25) {
			contBajos++;
		}
		else {
			if (num5 >=26 && num5 <=250) {
				contMedios++;
			}
			else {
				if (num5 >=251) {
					contGrandes++;
				}
				else {
					if (num5 < 0);{
						return;
					}
					
				}
			}
		}
		System.out.println("Hay " + contBajos + " números bajos, " + "hay " + contMedios + " números medios, "
				+ "hay " + contGrandes + " números grandes.");
	}

}
