package main;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Ui {

	private JFrame forstaFrame;
	private JLabel headerLabel;
	private JLabel statusLabel;
	private JPanel controlPanel;
	KontaktBok kBok = new KontaktBok();
	private ArrayList<Person> KontaktLista;
	
	public void skapaUI() {
		
		forstaFrame = new JFrame("Kontaktbok");
		forstaFrame.setSize(400, 600);
		forstaFrame.setLayout(new GridLayout(3, 1));
		
		headerLabel = new JLabel(" ", JLabel.CENTER);
		statusLabel = new JLabel(" ", JLabel.CENTER);
		statusLabel.setSize(350, 100);
		
		forstaFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});
		
		controlPanel = new JPanel();
		controlPanel.setLayout(new FlowLayout());
		
		forstaFrame.add(headerLabel);
		forstaFrame.add(controlPanel);
		forstaFrame.add(statusLabel);
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
	
	private class Knapptryck implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();
			
			if(command.contentEquals("Lista")) {
				statusLabel.setText("Lista klickades");
				visaLista();
			}else if (command.contentEquals("Sök")) {
				statusLabel.setText("Sök klickades");
			}else if (command.contentEquals("Lägg till")) {
				statusLabel.setText("Lägg till klickades");
			}else
				statusLabel.setText("Ta bort klickades");
			
		}
	}
}
