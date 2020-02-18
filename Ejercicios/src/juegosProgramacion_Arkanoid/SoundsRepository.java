package juegosProgramacion_Arkanoid;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;
import java.util.HashMap;

public class SoundsRepository {

	private HashMap<String, AudioClip> sounds = new HashMap<String, AudioClip>();
	
	//singleton
	private static SoundsRepository instance = null;
	
	//Carpeta en la que se encuentran los recursos
	private static String RESOURCES_FOLDER = "../juegosProgramacion_Arkanoid/resources/";
	
	//recursos de sonido que puede utilizarse en el juego
	public static String CHOQUE = "Arkanoid-SFX-04.wav";
	public static String NAVE = "Arkanoid-SFX-07.wav";
	public static String EXPLOSION = "explosion.wav";
	public static String LANZAMIENTO = "Arkanoid-SFX-08.wav";
	public static String INICIO_FASE = "Arkanoid-start-of-stage.wav";
	
	public SoundsRepository() {
		this.getAudioClip(CHOQUE);
		this.getAudioClip(NAVE);
		this.getAudioClip(EXPLOSION);
		this.getAudioClip(LANZAMIENTO);
		this.getAudioClip(INICIO_FASE);
		
	}
	
	public static SoundsRepository getInstance() {
		if (instance == null) {
			instance = new SoundsRepository();
		}
		return instance;
	}
	
	private AudioClip loadResource (String name) {
		URL url = null;
		url = getClass().getResource(name);
		return Applet.newAudioClip(url);
		
	}
	
	private AudioClip getAudioClip (String resourceName) {
		AudioClip clip = sounds.get(resourceName);
		
		if (clip == null) {
			clip = loadResource(RESOURCES_FOLDER + resourceName);
			sounds.put(resourceName, clip);
			
		}
		return clip;
	}
	
	public void playSound (final String name) {
		getAudioClip(name).play();
	}
	
	public void loopSound (final String name) {
		getAudioClip(name).loop();
	}

}
