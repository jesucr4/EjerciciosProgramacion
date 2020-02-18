package tema6_Recursos_Excepciones_Bombilla;

import javax.swing.JOptionPane;

public class Main {
	
	private static String darFraseConBombilla () throws NoBombilla, NoMasDeTresPalabras, PalabraOfensiva,
	SoloCaracteresEnBlanco{
		String str = JOptionPane.showInputDialog("Introduzca una frase con la palabra bombilla");
		
		if (str.trim().equals("")) {
			throw new SoloCaracteresEnBlanco("Solamente ha introducido espacios en blanco, por favor introduzca palabras");
		}
		
		String palabras[] = str.split("[ ]{1,}");
		if (palabras.length < 3) {
			throw new NoMasDeTresPalabras(3);
		}
		
		
		if (str.indexOf("bombilla") == -1) {
			throw new NoBombilla();
		}
		
		
		String palabrasOfensivas[] = new String[] {"tonto", "tonta", "idiota"};
		for (String palabraOfensiva : palabrasOfensivas) {
			if (str.indexOf(palabraOfensiva) != -1) {
				throw new PalabraOfensiva("Palabra " + palabraOfensiva + " encontrada");
			}
		}
		
		
		return str;
		
	}

	public static void main(String[] args) {
		try {
			System.out.println(darFraseConBombilla());
		}catch (NoBombilla e) {
			e.printStackTrace();
		}catch (PalabraOfensiva e) {
			e.printStackTrace();
		}
		catch (NoMasDeTresPalabras e) {
			e.printStackTrace();
		}
		catch (SoloCaracteresEnBlanco e) {
			e.printStackTrace();
		}

	}

}
