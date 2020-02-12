package main;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Ui implements ItemListener{
	
	final static String FORSTPANEL = "---VÄLJ FUNKTION---";
    final static String LISTAPANEL = "Visa Lista";
    final static String SOKPANEL = "Sök i lista";
    final static String LAGGTILLPANEL = "Lägg till kontakt";
    final static String TABORTPANEL = "Ta bort kontakt";
    public static JPanel cards;
    public JScrollPane scrollPane;
    public JPanel card, card1, card2, card3, card4, sokPanel, laggTillPanel, taBortPanel;
    public String fn, en, tel, mejl;
	
    public void addComponentToPane(Container pane) {
        JPanel comboBoxPane = new JPanel(); 
        String comboBoxItems[] = { FORSTPANEL, LISTAPANEL, SOKPANEL, LAGGTILLPANEL, TABORTPANEL};
        JComboBox cb = new JComboBox(comboBoxItems);
        cb.setEditable(false);
        cb.addItemListener(this);
        comboBoxPane.add(cb);

        //Create the "cards".
        JPanel card0 = new JPanel();
        
        JPanel card1 = new JPanel();
        card1.add(visaLista());
         
        JPanel card2 = new JPanel();
        card2.add(sokning());
        
        JPanel card3 = new JPanel();
        card3.add(laggTill());
        
        JPanel card4 = new JPanel();
        card4.add(taBort());
         
        //Create the panel that contains the "cards".
        cards = new JPanel(new CardLayout());
        cards.add(card0, FORSTPANEL);
        cards.add(card1, LISTAPANEL);
        cards.add(card2, SOKPANEL);
        cards.add(card3, LAGGTILLPANEL);
        cards.add(card4, TABORTPANEL);
        
        pane.add(comboBoxPane, BorderLayout.PAGE_START);
        pane.add(cards, BorderLayout.CENTER);
	}
    
    public JScrollPane visaLista() {
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
		scrollPane = new JScrollPane(list);
    	return scrollPane;
    }
    
    public JPanel sokning() {
    	sokPanel = new JPanel();
    	GridLayout gl = new GridLayout(5,1); 
    	sokPanel.setLayout(gl);
    	JButton sokKnapp = new JButton("Sök");
	    
		JLabel fornamnLabel = new JLabel("Förnamn: ");
		JTextField fornamnInput = new JTextField(30);
		JLabel efternamnLabel = new JLabel("Efternamn: ");
		JTextField efternamnInput = new JTextField(30);
	    JLabel telLabel = new JLabel("Telefonnummer: ");
	    JTextField telInput = new JTextField(30);		    
	    JLabel mejlLabel = new JLabel("Mejladress: ");
	    JTextField mejlInput = new JTextField(30);

	    fn = fornamnInput.getText();		   
	    en = efternamnInput.getText();
	    tel = telInput.getText();
	    mejl = mejlInput.getText();		    
	    
	    fornamnInput.setText("");
		efternamnInput.setText("");
	    telInput.setText("");
	    mejlInput.setText("");
		
	    sokPanel.add(fornamnLabel);
	    sokPanel.add(fornamnInput);
	    sokPanel.add(efternamnLabel);
	    sokPanel.add(efternamnInput);
	    sokPanel.add(telLabel);
	    sokPanel.add(telInput);
	    sokPanel.add(mejlLabel);
	    sokPanel.add(mejlInput);
	    sokPanel.add(sokKnapp);

    	return sokPanel;
    }
    public JPanel laggTill() {
    	laggTillPanel = new JPanel();
    	GridLayout gl = new GridLayout(5,1); 
    	laggTillPanel.setLayout(gl);
    	JButton sokKnapp = new JButton("Lägg till");
	    
		JLabel fornamnLabel = new JLabel("Förnamn: ");
		JTextField fornamnInput = new JTextField(30);
		JLabel efternamnLabel = new JLabel("Efternamn: ");
		JTextField efternamnInput = new JTextField(30);
	    JLabel telLabel = new JLabel("Telefonnummer: ");
	    JTextField telInput = new JTextField(30);		    
	    JLabel mejlLabel = new JLabel("Mejladress: ");
	    JTextField mejlInput = new JTextField(30);

	    fn = fornamnInput.getText();		   
	    en = efternamnInput.getText();
	    tel = telInput.getText();
	    mejl = mejlInput.getText();		    
	    
	    fornamnInput.setText("");
		efternamnInput.setText("");
	    telInput.setText("");
	    mejlInput.setText("");
		
	    laggTillPanel.add(fornamnLabel);
	    laggTillPanel.add(fornamnInput);
	    laggTillPanel.add(efternamnLabel);
	    laggTillPanel.add(efternamnInput);
	    laggTillPanel.add(telLabel);
	    laggTillPanel.add(telInput);
	    laggTillPanel.add(mejlLabel);
	    laggTillPanel.add(mejlInput);
	    laggTillPanel.add(sokKnapp);

    	return laggTillPanel;
    }
    public JPanel taBort() {
    	taBortPanel = new JPanel();
    	GridLayout gl = new GridLayout(5,1); 
    	taBortPanel.setLayout(gl);
    	JButton sokKnapp = new JButton("Ta bort");
	    
		JLabel fornamnLabel = new JLabel("Förnamn: ");
		JTextField fornamnInput = new JTextField(30);
		JLabel efternamnLabel = new JLabel("Efternamn: ");
		JTextField efternamnInput = new JTextField(30);
	    JLabel telLabel = new JLabel("Telefonnummer: ");
	    JTextField telInput = new JTextField(30);		    
	    JLabel mejlLabel = new JLabel("Mejladress: ");
	    JTextField mejlInput = new JTextField(30);

	    fn = fornamnInput.getText();		   
	    en = efternamnInput.getText();
	    tel = telInput.getText();
	    mejl = mejlInput.getText();		    
	    
	    fornamnInput.setText("");
		efternamnInput.setText("");
	    telInput.setText("");
	    mejlInput.setText("");
		
	    taBortPanel.add(fornamnLabel);
	    taBortPanel.add(fornamnInput);
	    taBortPanel.add(efternamnLabel);
	    taBortPanel.add(efternamnInput);
	    taBortPanel.add(telLabel);
	    taBortPanel.add(telInput);
	    taBortPanel.add(mejlLabel);
	    taBortPanel.add(mejlInput);
	    taBortPanel.add(sokKnapp);

    	return taBortPanel;
    }

    public void itemStateChanged(ItemEvent evt) {
        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, (String)evt.getItem());
    }
     
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Kontaktbok");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
        //Create and set up the content pane.
        Ui demo = new Ui();
        demo.addComponentToPane(frame.getContentPane());
         
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
     
    public static void skapaUI() {
        /* Use an appropriate Look and Feel */
        try {
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        /* Turn off metal's use of bold fonts */
        UIManager.put("swing.boldMetal", Boolean.FALSE);
         
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

}
