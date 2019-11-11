package tema5_arrays;

public class Ejercicio_Matriz_Adicional {

	public static void main(String[] args) {
		//creamos matriz sin inicializar
		int matriz [][] = new int [5][5];		
		//llamamos a m√©todo para inicializar matriz de 0 a 100 y mostras matriz en pantalla
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
	/**
	 * 
	 * @param matriz
	 * @return
	 */
	//creamos nueva matriz para incluir en esta los n˙meros de la matriz principal
	public static int[]	[] nuevaMatriz (int matriz [][]){
		//creamos nueva matriz y la recorremos con el bucle for
		//procedemos a incluir en ella los datos de la matriz principal que nos interesan
		int Matrizficticia [][] = new int [3][3];
		
			for (int i = 0; i < Matrizficticia.length; i++) {
				for (int j = 0; j < Matrizficticia.length; j++) {
				
				}
			}
		
		return Matrizficticia;
		
	}
	
	public static void operarMatriz (int matriz [][]) {
		
		do {
			for
			
		}while(i == j);
		}
	}

	}


