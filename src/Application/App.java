package Application;

import java.awt.EventQueue;

import Application.classes.GUI;

/**
 * Clasa principala (contine main - executia codului sursa)

/**
 * @author     Stoleriu Stefan, Leonte Gabriel, Ignat Mihaela-Loredana, Brailescu Andrei 
 * @version     1.8.0_261-b12
 */
public class App {

	/**
	 * Lansarea aplicatiei, crearea unei GUI si setarea vizibila a frame-ului
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					/**
					 * Creare GUI
					 */
					GUI window = new GUI();
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}	
}