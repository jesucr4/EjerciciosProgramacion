import javax.swing.JOptionPane;

public class Ejercicio01f {

	public static void main(String[] args) {
		
		InteresMensual();
		
	}
	/*public static void InteresMensual() {
		Float Euribor = -0.3f;
		Float Diferencial = 1.1f;
		
		Float IA = Euribor + Diferencial; 
		
		Float IM = (IA / 12) / 100;
		
		System.out.println("El interés mensual es de " + IM);
		
		Float Capital = (float) 150000;
		
		Float IM0 = IM + 1;
		
		Float IM1 = (float) Math.pow(IM0, 120);
		
		Float CM = Capital * ((IM*IM1)/(IM1-1));
		
		System.out.println("La cuota mensual es de " + CM);
	}*/
		
	public static void InteresMensual(){
		String str = JOptionPane.showInputDialog(" Introduzca Euribor");
		
		Float Euribor = Float.parseFloat(str);
		
		str = JOptionPane.showInputDialog("Introduzca Diferencial");
		Float Diferencial = Float.parseFloat(str);
		
		str = JOptionPane.showInputDialog("Introduzca capital");
		Float Capital = Float.parseFloat(str);
		
		str = JOptionPane.showInputDialog("Introduzca número de plazos mensuales de la hipoteca" );
		Float Mensualidades = Float.parseFloat(str);
		
		Float IA = Euribor + Diferencial; 
		
		Float IM = (IA / 12) / 100;
		
		System.out.println("El interés mensual es de " + IM);
				
		Float IM0 = IM + 1;
		
		Float IM1 = (float) Math.pow(IM0, Mensualidades);
		
		Float CM = Capital * ((IM*IM1)/(IM1-1));
		
		System.out.println("La cuota mensual es de " + CM);
		
	}
}
