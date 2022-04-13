package Application;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GUI {
	
	private JFrame frame;
	private JButton Add_Image;
	private JButton Select_Object;
	private JButton Export;
	
	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
		Add_Image imagine = new Add_Image(frame, Add_Image);
		imagine.Load();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1050, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("DataSet");
		frame.getContentPane().setLayout(null);
		
		Add_Image = new JButton("Add Image");
		Add_Image.setBounds(839, 152, 187, 41);
		frame.getContentPane().add(Add_Image);
		
		Select_Object = new JButton("Select Object");
		Select_Object.setBounds(839, 220, 187, 41);
		frame.getContentPane().add(Select_Object);
		
		Export = new JButton("Export");
		Export.setBounds(839, 288, 187, 41);
		frame.getContentPane().add(Export);
		
		String[] optionsToChoose = {"Masina", "Bicicleta", "Motocicleta", "Indicator","Pieton","Cladire","None of the listed"};
		JComboBox<String> jComboBox = new JComboBox<>(optionsToChoose);
        jComboBox.setBounds(839, 338, 187, 41);

        JButton jButton = new JButton("Done");
        jButton.setBounds(889, 388, 90, 30);

        JLabel jLabel = new JLabel();
        jLabel.setBounds(839, 390, 400, 100);

        frame.add(jButton);
        frame.add(jComboBox);
        frame.add(jLabel);
        

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedFruit = "You selected " + jComboBox.getItemAt(jComboBox.getSelectedIndex());
                jLabel.setText(selectedFruit);
                if(jComboBox.getItemAt(jComboBox.getSelectedIndex())=="Masina"){
                	Masina m1=new Masina();
                	m1.setCuloare("rosu");
                
                	String s=m1.getCuloare();
                	System.out.printf(s);
                	
                /*	Graphics2D g2d = imagine.createGraphics(); //To do: preluare imagine
            		g2d.setColor(Color.RED);
            		g2d.drawRect(200, 200, 300, 300);
            		g2d.dispose(); */
                }
                else if(jComboBox.getItemAt(jComboBox.getSelectedIndex())=="Bicicleta"){
                   Bicicleta b1=new Bicicleta();
                   b1.setCuloare("albastru");
                   
               	String s=b1.getCuloare();
               	System.out.printf(s);
            }
                else if(jComboBox.getItemAt(jComboBox.getSelectedIndex())=="Motocicleta"){
                	Motocicleta n1=new Motocicleta();
                	n1.setCuloare("verde");
                    
                	String s=n1.getCuloare();
                	System.out.printf(s);
                }
                else if(jComboBox.getItemAt(jComboBox.getSelectedIndex())=="Indicator"){
                	Semn i1=new Semn();
                	i1.setCuloare("mov");
                    
                	String s=i1.getCuloare();
                	System.out.printf(s);
                }
                else if(jComboBox.getItemAt(jComboBox.getSelectedIndex())=="Pieton"){
                	Pieton p1=new Pieton();
                	p1.setCuloare("galben");
                    
                	String s=p1.getCuloare();
                	System.out.printf(s);
                }
                else if(jComboBox.getItemAt(jComboBox.getSelectedIndex())=="Cladire"){
                	Cladire c1=new Cladire();
                	c1.setCuloare("alb");
                    
                	String s=c1.getCuloare();
                	System.out.printf(s);
                }
               /* else if(jComboBox.getItemAt(jComboBox.getSelectedIndex())=="None of the listed"){
                	Obiect o1=new Obiect();
                	o1.setCuloare("verde");
                    
                	String s=o1.getCuloare();
                	System.out.printf(s);
                }*/
       
            }
        }
	}

		public JFrame getFrame() {
			return frame;
		}
}
