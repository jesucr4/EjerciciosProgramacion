package tema5_arrays;

public class Ejercicio_Matriz_Adicional {

	public static void main(String[] args) {
		//creamos matriz sin inicializar
		int matriz [][] = new int [5][5];		
		//llamamos a método para inicializar matriz de 0 a 100 y mostras matriz en pantalla
		inicializarMatriz(matriz);	
		
				
				
			
			}
	/**
	 * 
	 * @param matriz
	 */
	public static void inicializarMatriz( int matriz[][]) {
		int contMatriz = 1;
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				
				matriz [i][j] = contMatriz;
				contMatriz++;
			System.out.print(matriz[i][j] + "\t");
			
			}
			System.out.println();
		}
	}
	public static void operarMatriz (int matriz [][]) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				
			}
		}
	}

	}


