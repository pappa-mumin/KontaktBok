package main;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Ui {

	private JFrame forstaFrame;
	private JLabel headerLabel;
	private JLabel statusLabel;
	private JPanel controlPanel;
	KontaktBok kBok = new KontaktBok();
	private ArrayList<Person> KontaktLista;
	
    public String fn, en, tel, mejl;
	
	public void skapaUI() {
		
		forstaFrame = new JFrame("Kontaktbok");
		forstaFrame.setSize(800, 600);
		forstaFrame.setLayout(new GridLayout(5, 1));
		
		headerLabel = new JLabel("Hej Head", JLabel.CENTER);
		headerLabel.setSize(50,50);
//		statusLabel = new JLabel("Hek status", JLabel.CENTER);
//		statusLabel.setSize(10, 10);
		
		forstaFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});
		
		controlPanel = new JPanel();
		controlPanel.setSize(800, 300);
//		controlPanel.setLayout(new FlowLayout());
		
		forstaFrame.add(headerLabel);
		forstaFrame.add(controlPanel);
//		forstaFrame.add(statusLabel);

		forstaFrame.setVisible(true);
	}
	
	public void knappar() {
		headerLabel.setText("Vad vill du göra i Kontaktboken?");
		JButton listaKnapp = new JButton("Visa lista");
		JButton sokKnapp = new JButton("Sök");
		JButton laggTillKnapp = new JButton("Lägg till");
		JButton taBortKnapp = new JButton("Ta bort");
		
		listaKnapp.setActionCommand("Lista");
		sokKnapp.setActionCommand("Sök");
		laggTillKnapp.setActionCommand("Lägg till");
		taBortKnapp.setActionCommand("Ta bort");
		
		listaKnapp.addActionListener(new Knapptryck());
		sokKnapp.addActionListener(new Knapptryck());
		laggTillKnapp.addActionListener(new Knapptryck());
		taBortKnapp.addActionListener(new Knapptryck());
		
		controlPanel.add(listaKnapp);
		controlPanel.add(sokKnapp);
		controlPanel.add(laggTillKnapp);
		controlPanel.add(taBortKnapp);
		
		forstaFrame.setVisible(true);
	}
	
	public void visaLista() {
		
		ArrayList<String> cars = new ArrayList<String>();
	    cars.add("Volvo                fndjkshfdsiua");
	    cars.add("BMW");
	    cars.add("Ford");
	    cars.add("Mazda");
	    cars.add("Volvo");
	    cars.add("BMW");
	    cars.add("Ford");
	    cars.add("Mazda");
	    cars.add("Volvo");
	    cars.add("BMW");
	    cars.add("Ford");
	    cars.add("Mazda");
	    cars.add("Volvo");
	    cars.add("BMW");
	    cars.add("Ford");
	    cars.add("Mazda");
		JList<String> list = new JList(cars.toArray());
		list.setLayoutOrientation(JList.VERTICAL);
		JScrollPane scrollPane = new JScrollPane(list);
		controlPanel.add(scrollPane);      
		
	}
	
	public void sokning() {
//	    JComboBox<String> comboBox = new JComboBox<>();
//	    comboBox.addItem("Förnamn");
//	    comboBox.addItem("Efternamn");
//	    comboBox.addItem("Telefonnummer");
//	    comboBox.addItem("Mejladress");
//	    controlPanel.add(comboBox);
		


		JButton sokKnapp = new JButton("Sök");
		
	    JPanel panel = new JPanel();
	    
		GridLayout gl = new GridLayout(8,1); // 4 rows, 2 columns
		panel.setLayout(gl);
	    
		JLabel fornamnLabel = new JLabel("Förnamn: ");
		JTextField fornamnInput = new JTextField(20);
		JLabel efternamnLabel = new JLabel("Efternamn: ");
		JTextField efternamnInput = new JTextField(20);
	    JLabel telLabel = new JLabel("Telefonnummer: ");
	    JTextField telInput = new JTextField(20);		    
	    JLabel mejlLabel = new JLabel("Mejladress: ");
	    JTextField mejlInput = new JTextField(20);

	    fn = fornamnInput.getText();		   
	    en = efternamnInput.getText();
	    tel = telInput.getText();
	    mejl = mejlInput.getText();		    
	    
	    fornamnInput.setText("");
		efternamnInput.setText("");
	    telInput.setText("");
	    mejlInput.setText("");
		    		    
	    panel.add(fornamnLabel);
		panel.add(fornamnInput);
	    panel.add(efternamnLabel);
	    panel.add(efternamnInput);
	    panel.add(telLabel);
	    panel.add(telInput);
	    panel.add(mejlLabel);
	    panel.add(mejlInput);
	    panel.add(sokKnapp);

	    controlPanel.add(panel);

		
	}
	
	private class Knapptryck implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();
//		    JPanel panelo = new JPanel();
//		    
//			GridLayout glo = new GridLayout(3,1); // 4 rows, 2 columns
//			panelo.setLayout(glo);
			
			if(command.contentEquals("Lista")) {
				headerLabel.setText("Här är Kontaktboken");
//				statusLabel.setText("Lista klickades");
				visaLista();
			}else if (command.contentEquals("Sök")) {
				headerLabel.setText("Sök i Kontaktboken");
//				statusLabel.setText("Sök klickades");
				sokning();
			}else if (command.contentEquals("Lägg till")) {
				headerLabel.setText("Lägg till kontakt i Kontaktboken");
//				statusLabel.setText("Lägg till klickades");
			}else
				headerLabel.setText("Radera kontakt i Kontaktboken");
//				statusLabel.setText("Ta bort klickades");
			
		}
	}
}
