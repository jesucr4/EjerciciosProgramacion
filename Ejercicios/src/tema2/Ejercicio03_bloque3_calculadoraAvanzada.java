package tema2;

import javax.swing.JOptionPane;

public class Ejercicio03_bloque3_calculadoraAvanzada {

	public static void main(String[] args) {
		String str = JOptionPane.showInputDialog("Elija una de las siguientes opciones:\n\n"
				+ "1.-Hipotenusa de triángulo\n"
				+ "2.-Superficie de circunferencia\n"
				+ "3.-Perímetro circunferencia\n" 
				+ "4.-Área de rectángulo\n" 
				+ "5.-Área de triángulo\n");
		int num = Integer.parseInt(str);
		
		switch (num) {
			case 1: //hipotenusa de un triángulo
				str = JOptionPane.showInputDialog("Introduzca número para un cateto");
				float cateto1 = Float.parseFloat(str);
				str = JOptionPane.showInputDialog("Introduzca número para otro cateto");
				float cateto2 = Float.parseFloat(str);
				//cálculo de la hipotenusa de un triángulo
				float hipotenusa =  (float) Math.sqrt(cateto1*cateto1 + cateto2*cateto2);
				System.out.println("La ra�z cuadrada del n�mero introducido es " + hipotenusa);
				break;
				
			case 2: //superficie de un círculo
				str = JOptionPane.showInputDialog("Introduzca radio");
				float radio = Float.parseFloat(str);
				
				//cálculo del radio
				System.out.println("La superficie vale " + Math.PI*Math.pow(radio, 2));
				break;
				
			case 3: //perímetro circunferencia (falta este)
				str = JOptionPane.showInputDialog("Introduzca n�mero para dividendo");
				float dividendo = Float.parseFloat(str);
				str = JOptionPane.showInputDialog("Introduzca n�mero para divisor");
				int divisor = Integer.parseInt(str);
				//cálculo del perímetro de la circunferencia
				float division = (dividendo % divisor);
				System.out.println("El resto de la divisi�n introducida es " + division);
				break;
				
			case 4: //área rectángulo
				str = JOptionPane.showInputDialog("Introduzca base rectángulo");
				float base= Float.parseFloat(str);
				str = JOptionPane.showInputDialog("Introduzca altura rectángulo");
				int altura = Integer.parseInt(str);
				//cálculo del perímetro de la circunferencia
				System.out.println("El área del rectángulo es " + (base * altura));
				break;
				
			case 5: //área triángulo ((falta este)
				str = JOptionPane.showInputDialog("Introduzca base triángulo");
				float baseTriangulo = Float.parseFloat(str);
				str = JOptionPane.showInputDialog("Introduzca altura triángulo");
				int alturaTriangulo = Integer.parseInt(str);
				//cálculo del área del triángulo
				System.out.println("El área del triángulo es " + ((baseTriangulo*alturaTriangulo)/2));
				break;
				default:
				System.out.println("El n�mero introducido no conlleva ninguna operaci�n");
					
				
		}
	}

}
