package tema6_Recursos_Bloque6_Ejercicio1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;



public class Usuario_y_Contrase�a {

	private static Properties propiedades = null;
	
	public Usuario_y_Contrase�a() {
		super();
	}
	
	private static Properties getPropiedades() {
		if (propiedades == null) {
			propiedades = new Properties();
		    
			try {
				// Una forma de leer el fichero de propiedades
//				propiedades.load(propiedades.getClass().getResourceAsStream("/tutorialJava/capitulo6_Recursos/ejemplo.properties"));

				// Otra forma de leer el fichero de propiedades
				File file = new File(".\\src\\tema6_Recursos_Bloque6_Ejercicio1/ejemplo.properties");
				System.out.println("Fichero encontrado: " + file.exists());
				propiedades.load(new FileReader(file));
			
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
		}
		return propiedades;
	}

	/**
	 * 
	 * @param nombrePropiedad
	 * @return
	 */
	public static String getProperty(String nombrePropiedad) {
		return getPropiedades().getProperty(nombrePropiedad);
	}

	public static void main(String[] args) {
		String usuario = Usuario_y_Contrase�a.getProperty("USUARIO");
		String password = Usuario_y_Contrase�a.getProperty("PASSWORD");
		
		
		System.out.println("USUARIO: " + usuario);
		System.out.println("PASSWORD: " + password);
		
	}

	

}
