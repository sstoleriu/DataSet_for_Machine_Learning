package Application.classes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;

public class selectObject {

	private JFrame frame;
	private Add_Image Add_image;
	private JComboBox<String> selectObject;

	public selectObject(JFrame frame, Add_Image Add_Image, JComboBox<String> selectObject) {
		this.selectObject = selectObject;
		this.frame = frame;
		this.Add_image = Add_Image;
	}

	public JFrame getFrame() {
		return frame;
	}

	public Add_Image getAddImage() {
		return Add_image;
	}

	public JComboBox<String> getSelectObject() {
		return selectObject;
	}

	public void createObjectAndDraw() {
		this.selectObject.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

//				MouseClick ms1 = new MouseClick();
//				getFrame().addMouseListener(ms1);

				String alegere = getSelectObject().getSelectedItem().toString();
				switch (alegere) {
				case "Masina": {
						Masina m1 = new Masina(getAddImage());
				
						MouseClick ms1 = new MouseClick(m1);
						getAddImage();
						Add_Image.geImagePanel().addMouseListener(ms1);
						break;
				}
				case "Bicicleta": {
					Bicicleta b1 = new Bicicleta(getAddImage());
					MouseClick ms1 = new MouseClick(b1);
					getAddImage();
					Add_Image.geImagePanel().addMouseListener(ms1);
					break;
				}
				case "Autobuz": {
					Autobuz a1 = new Autobuz(getAddImage());
					MouseClick ms1 = new MouseClick(a1);
					getAddImage();
					Add_Image.geImagePanel().addMouseListener(ms1);
					break;
				}
				case "Motocicleta": {
					Motocicleta mot1 = new Motocicleta(getAddImage());
					MouseClick ms1 = new MouseClick(mot1);
					getAddImage();
					Add_Image.geImagePanel().addMouseListener(ms1);
					break;
				}
				case "Cladire": {
					Cladire c1 = new Cladire(getAddImage());
					MouseClick ms1 = new MouseClick(c1);
					getAddImage();
					Add_Image.geImagePanel().addMouseListener(ms1);
					break;
				}
				case "Pieton": {
					Pieton p1 = new Pieton(getAddImage());
					MouseClick ms1 = new MouseClick(p1);
					getAddImage();
					Add_Image.geImagePanel().addMouseListener(ms1);
					break;
				}
				case "Indicator": {
					Indicator i1 = new Indicator(getAddImage());
					MouseClick ms1 = new MouseClick(i1);
					getAddImage();
					Add_Image.geImagePanel().addMouseListener(ms1);
					break;
				}
				case "Semafor": {
					Semafor s1 = new Semafor(getAddImage());
					MouseClick ms1 = new MouseClick(s1);
					getAddImage();
					Add_Image.geImagePanel().addMouseListener(ms1);
					break;
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + alegere);
				}
			}
		});

	}
}
