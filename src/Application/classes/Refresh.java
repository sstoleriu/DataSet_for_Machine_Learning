package Application.classes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JButton;

import Application.interfaces.Obiect;

/**
 * Clasa pentru reincarcarea aplicatiei
 */
public class Refresh {

	private JButton refresh;
	private static Vector<Obiect> listOfObjects;
	private static ActionListener refreshAction;
	private static boolean createdBooleanRefresh = false;
	private static JDrawPanel drawPanel;
	
	/**
	 * Constructor de initializare cu parametri
	 * @param refresh Butonul pentru reincarcarea aplicatiei
	 * @param listOfObjects lista cu obiectele create
	 * @param drawPanel Panoul in care a fost facuta desenarea chenarelor
	 */
	public Refresh(JButton refresh, Vector<Obiect> listOfObjects, JDrawPanel drawPanel) {
		this.refresh = refresh;
		Refresh.listOfObjects = listOfObjects;
		Refresh.drawPanel = drawPanel;
	}
	
	/**
	 * Metoda pentru reincarcarea listei obiectele create
	 * @param listOfObjects lista obiectele create prin desenare
	 */
	public void giveList(Vector<Obiect> listOfObjects) {
		Refresh.listOfObjects = listOfObjects;
	}
	
	/**
	 * Metoda de incarcare prin adaugarea de actiune la apasarea mouse-ului
	 * Sterge Panoul in care au fost desenate chenare
	 * Sterge lista de obiecte create
	 */
	public void load() {
		refreshAction = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					drawPanel.clear();
				} catch (IOException e1) {}
				listOfObjects.clear();
			}
		};
		if(createdBooleanRefresh == false) {
			refresh.addActionListener(refreshAction);
			createdBooleanRefresh = true;
		}
	}
	
}
