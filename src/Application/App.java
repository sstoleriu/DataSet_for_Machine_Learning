package Application;

import java.awt.EventQueue;

import Application.classes.GUI;
/**
 * @author     Stoleriu Stefan, Leonte Gabriel, Ignat Mihaela-Loredana, Brailescu Andrei 
 * @version     1.8.0_261-b12
 */
public class App {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}	
}
