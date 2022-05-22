package Application.classes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * Clasa pentru schimbarea design-ului iconitelor de pe butoane
 */
public class ChangeIcons {
	
	private JButton icons;
	private Add_Image addimgtemp;
	private TagMenu tagmenutemp;
	private Helper helptemp;
	private static int cont = 1;
	
	/**
	 * Constructor de initializare cu parametri
	 * @param icons Butonul de schimbare a culorilor iconitelor
	 * @param addimgtemp Imagine adaugata
	 * @param tagmenutemp Meniul de taguri existent
	 * @param helptemp Helper-ul
	 */
	ChangeIcons(JButton icons, Add_Image addimgtemp, TagMenu tagmenutemp, Helper helptemp){
		this.icons = icons;
		this.addimgtemp = addimgtemp;
		this.tagmenutemp = tagmenutemp;
		this.helptemp = helptemp;
	}
	
	/**
	 * Metoda de incarcare a schimbarii culorilor iconitelor de pe butoane
	 * in functie de numarul de apasari ale butonului Icons
	 */
	public void load() {
		addimgtemp.changeMainIcons(cont);
		tagmenutemp.changeTagMenuIcons(cont);
		helptemp.changeHelpIcons(cont);
		
		icons.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cont++;
				if(cont>3) {
					cont = 1;
				}
				addimgtemp.changeMainIcons(cont);
				tagmenutemp.changeTagMenuIcons(cont);
				helptemp.changeHelpIcons(cont);
			}
		});
		
	}
}
