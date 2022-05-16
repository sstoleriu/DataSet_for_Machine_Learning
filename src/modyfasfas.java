import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.FlowLayout;

public class modyfasfas {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					modyfasfas window = new modyfasfas();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public modyfasfas() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1050, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		 JButton Icons = new JButton();
 		Icons.setFocusPainted(false);
 		Icons.setBounds(839, 461, 90, 41);
 		frame.getContentPane().add(Icons);
 		
 		JButton Credits = new JButton();
 		Credits.setFocusPainted(false);
 		Credits.setBounds(936, 461, 90, 41);
 		frame.getContentPane().add(Credits);
         
         JButton Reset = new JButton();
 		Reset.setFocusPainted(false);
 		Reset.setBounds(894, 510, 90, 41);
 		frame.getContentPane().add(Reset);

	}

}
