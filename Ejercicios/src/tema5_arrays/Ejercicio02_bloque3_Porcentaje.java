package tema5_arrays;

public class Ejercicio02_bloque3_Porcentaje {

	public static void main(String[] args) {
		//creamos e inicializamos el array
		int array[]=Utils.creaArrayNumerosAzar(20, 0, 10);
		Utils.mostrarArray(array);
		//creamos variables para obtener porcentaje
		float acumAprobados = 0f;
		float acumSuspensos = 0f;
		float porcentajeAprobados = 0;
		float porcentajeSuspensos = 0;
		//realizamos bucle for
		for (int i = 0; i < array.length; i++) {
			if(array[i]>=5) {
				acumAprobados++;
			}else {
				acumSuspensos++;	
			}
		}
		porcentajeAprobados = (float)(100*acumAprobados)/array.length;
		porcentajeSuspensos = (float)(100*acumSuspensos)/array.length;
		System.out.println("El porcentaje de aprobados es de " + porcentajeAprobados + "% "+
				", el porcentaje de suspensos es de " + porcentajeSuspensos + "%");

	}

}
