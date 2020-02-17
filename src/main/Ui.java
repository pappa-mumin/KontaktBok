package main;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	
    /**
     * Deklarerar instansvariabler, klassvariabler och statiskta variabler
     * @author Linn
     */
	final static String FORSTPANEL = "---Vad vill du göra?---";
    final static String LISTAPANEL = "Visa Lista";
    final static String SOKPANEL = "Sök i lista";
    final static String LAGGTILLPANEL = "Lägg till kontakt";
    final static String TABORTPANEL = "Ta bort kontakt";
    public static JPanel cards;
    public JScrollPane scrollPane;
    public JPanel card, card1, card2, card3, card4, sokPanel, laggTillPanel, taBortPanel;
    public String sokfn, soken, soktel, sokmejl;
    public String laggfn, laggen, laggtel, laggmejl;
    public String bortfn, borten, borttel, bortmejl;
    private JLabel statusLabel;
    public JTextField fornamnInput, efternamnInput, telInput, mejlInput;
    KontaktBok kb = new KontaktBok();
    ByggBok bb = new ByggBok();
    Fil fil = new Fil();
	
    /**
     * Metoden lägger till komponenter till en JPanel
     * @param pane avser panelen som komponenterna ska läggas till i 
     * @author Linn
     */
    public void addComponentToPane(Container pane) {
        JPanel comboBoxPane = new JPanel(); 
        String comboBoxItems[] = { FORSTPANEL, LISTAPANEL, SOKPANEL, LAGGTILLPANEL, TABORTPANEL};
        JComboBox cb = new JComboBox(comboBoxItems);
        cb.setEditable(false);
        cb.addItemListener(this);
        comboBoxPane.add(cb);
        
		statusLabel = new JLabel(" ", JLabel.CENTER);
		statusLabel.setSize(350, 100);

        JPanel card0 = new JPanel();
        
        JPanel card1 = new JPanel();
        card1.add(visaLista());
        
        JPanel card2 = new JPanel();
        card2.add(sokning());
        
        JPanel card3 = new JPanel();
        card3.add(laggTill());
        
        JPanel card4 = new JPanel();
        card4.add(taBort());

        cards = new JPanel(new CardLayout());
        cards.add(card0, FORSTPANEL);
        cards.add(card1, LISTAPANEL);
        cards.add(card2, SOKPANEL);
        cards.add(card3, LAGGTILLPANEL);
        cards.add(card4, TABORTPANEL);
        
        pane.add(comboBoxPane, BorderLayout.PAGE_START);
        pane.add(cards, BorderLayout.CENTER);
        pane.add(statusLabel, BorderLayout.PAGE_END); 
	}
    
    /**
     * Metod för att presentera kontaktlistan i det grafiska interfacet
     * @return en JPanel med JLabels och JTextfields som visar Kontaktlistan
     * @author Linn och Louise
     */
    public JScrollPane visaLista() {

    	ArrayList<String> listlista = new ArrayList<String>();
    	String s = "";
    	for(Person p : kb.KontaktLista) {
    		s = "";
    		s += bb.pad(p.getFnamn(), 25, ' ');
    		s += bb.pad(p.getEnamn(), 20, ' ');
    		s += bb.pad(p.getTel(), 25, ' ');
    		s += bb.pad(p.getMejl(), 15, ' ');
    		
    		listlista.add(s);
    		listlista.sort(null);
    		System.out.println(s);
    	}

		JList<String> list = new JList(listlista.toArray());
		list.setLayoutOrientation(JList.VERTICAL);
		scrollPane = new JScrollPane(list);

    	return scrollPane;
    }
    
    
    /**
     * Metod för att söka i kontaktlistan för det grafiska interfacet
     * @return en JScrollPane som visar Kontaktlistan
     * @author Linn och Louise
     */
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
	    
	    fornamnInput.setText("");
		efternamnInput.setText("");
	    telInput.setText("");
	    mejlInput.setText("");

		sokKnapp.setActionCommand("Sök");

	    sokKnapp.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		sokfn = fornamnInput.getText();		   
	    		soken = efternamnInput.getText();
	    		soktel = telInput.getText();
	            sokmejl = mejlInput.getText();

	            String status = "";
	            ArrayList<Person> statuslista = new ArrayList<Person>();
	            
	            /**
	             * Sökning av förnamn
	             * @author Linn
	             */
	            if(!sokfn.isEmpty() && soken.isEmpty() && soktel.isEmpty() && sokmejl.isEmpty()) {
	            	for (Person p: kb.KontaktLista) {
	            		if(sokfn.equalsIgnoreCase(p.getFnamn())) {
	            			status += p.getFnamn() + " " + p.getEnamn() + " " + p.getTel() + " " + p.getMejl() + "\n";

	            		}
	            	}
	            	if(status == "") {
	            		status += "Du har sökt på en kontakt som inte finns";
	            	}
	            	statusLabel.setText(status);
	            	
		            /**
		             * Sökning av Efternamn
		             * @author Linn
		             */
	            } else if(sokfn.isEmpty() && !soken.isEmpty() && soktel.isEmpty() && sokmejl.isEmpty()) {
	            	for (Person p: kb.KontaktLista) {
	            		if(soken.equalsIgnoreCase(p.getEnamn())) {
	            			status += p.getFnamn() + " " + p.getEnamn() + " " + p.getTel() + " " + p.getMejl() + "\n";
	            		}
	            	}
	            	if(status == "") {
	            		status += "Du har sökt på en kontakt som inte finns";
	            	}
	            	statusLabel.setText(status);
	            
		            /**
		             * Sökning av Telefonnummer
		             * @author Linn
		             */
	            } else if(sokfn.isEmpty() && soken.isEmpty() && !soktel.isEmpty() && sokmejl.isEmpty()) {
	            	for (Person p: kb.KontaktLista) {
	            		if(soktel.equalsIgnoreCase(p.getTel())) {
	            			status += p.getFnamn() + " " + p.getEnamn() + " " + p.getTel() + " " + p.getMejl() + "\n";
	            		}
	            	}
	            	if(status == "") {
	            		status += "Du har sökt på en kontakt som inte finns";
	            	}
	            	statusLabel.setText(status);	
	            
		            /**
		             * Sökning av Mejl
		             * @author Linn
		             */
		        } else if(sokfn.isEmpty() && soken.isEmpty() && soktel.isEmpty() && !sokmejl.isEmpty()) {
	            	for (Person p: kb.KontaktLista) {
	            		if(sokmejl.equalsIgnoreCase(p.getMejl())) {
	            			status += p.getFnamn() + " " + p.getEnamn() + " " + p.getTel() + " " + p.getMejl() + "\n";
	            		}
	            	}
	            	if(status == "") {
	            		status += "Du har sökt på en kontakt som inte finns";
	            	}
	            	statusLabel.setText(status);		
	            
		            /**
		             * Sökning av Förnamn och Efternamn
		             * @author Linn
		             */
	            }else if (!sokfn.isEmpty() && !soken.isEmpty() && soktel.isEmpty() && sokmejl.isEmpty())	{
	            	for (Person p: kb.KontaktLista) {
	            		if(sokfn.equalsIgnoreCase(p.getFnamn()) && soken.equalsIgnoreCase(p.getEnamn())) {
	            			status += p.getFnamn() + " " + p.getEnamn() + " " + p.getTel() + " " + p.getMejl() + "\n";
	            		}
	            	}
	            	if(status == "") {
	            		status += "Du har sökt på en kontakt som inte finns";
	            	}
	            	statusLabel.setText(status);		            
	            
		            /**
		             * Sökning av Förnamn och Telefonnummer
		             * @author Linn
		             */
	            } else if (!sokfn.isEmpty() && soken.isEmpty() && !soktel.isEmpty() && sokmejl.isEmpty())	{
	            	for (Person p: kb.KontaktLista) {
	            		if(sokfn.equalsIgnoreCase(p.getFnamn()) && soktel.equalsIgnoreCase(p.getTel())) {
	            			status += p.getFnamn() + " " + p.getEnamn() + " " + p.getTel() + " " + p.getMejl() + "\n";
	            		}
	            	}
	            	if(status == "") {
	            		status += "Du har sökt på en kontakt som inte finns";
	            	}
		            statusLabel.setText(status);
		       
		            /**
		             * Sökning av Förnamn och Mejl
		             * @author Linn
		             */
	            } else if (!sokfn.isEmpty() && soken.isEmpty() && soktel.isEmpty() && !sokmejl.isEmpty())	{
	            	for (Person p: kb.KontaktLista) {
	            		if(sokfn.equalsIgnoreCase(p.getFnamn()) && sokmejl.equalsIgnoreCase(p.getMejl())) {
	            			status += p.getFnamn() + " " + p.getEnamn() + " " + p.getTel() + " " + p.getMejl() + "\n";
	            		}
	            	}
	            	if(status == "") {
	            		status += "Du har sökt på en kontakt som inte finns";
	            	}
		            statusLabel.setText(status);
		        
		            /**
		             * Sökning av Efternamn och Telefon
		             * @author Linn
		             */
	            } else if (sokfn.isEmpty() && !soken.isEmpty() && !soktel.isEmpty() && sokmejl.isEmpty())	{
	            	for (Person p: kb.KontaktLista) {
	            		if(soken.equalsIgnoreCase(p.getEnamn()) && soktel.equalsIgnoreCase(p.getMejl())) {
	            			status += p.getFnamn() + " " + p.getEnamn() + " " + p.getTel() + " " + p.getMejl() + "\n";
	            		}
	            	}
	            	if(status == "") {
	            		status += "Du har sökt på en kontakt som inte finns";
	            	}
		            statusLabel.setText(status);
		         
		            /**
		             * Sökning av Efternamn och Mejl
		             * @author Linn
		             */
	            } else if (sokfn.isEmpty() && !soken.isEmpty() && soktel.isEmpty() && !sokmejl.isEmpty())	{
	            	for (Person p: kb.KontaktLista) {
	            		if(soken.equalsIgnoreCase(p.getEnamn()) && sokmejl.equalsIgnoreCase(p.getMejl())) {
	            			status += p.getFnamn() + " " + p.getEnamn() + " " + p.getTel() + " " + p.getMejl() + "\n";
	            		}
	            	}
	            	if(status == "") {
	            		status += "Du har sökt på en kontakt som inte finns";
	            	}
		            statusLabel.setText(status); 
		         
		            /**
		             * Sökning av Telefon och Mejl
		             * @author Linn
		             */
	            } else if (sokfn.isEmpty() && soken.isEmpty() && !soktel.isEmpty() && !sokmejl.isEmpty())	{
	            	for (Person p: kb.KontaktLista) {
	            		if(soktel.equalsIgnoreCase(p.getTel()) && sokmejl.equalsIgnoreCase(p.getMejl())) {
	            			status += p.getFnamn() + " " + p.getEnamn() + " " + p.getTel() + " " + p.getMejl() + "\n";
	            		}
	            	}
	            	if(status == "") {
	            		status += "Du har sökt på en kontakt som inte finns";
	            	}
		            statusLabel.setText(status);  
		        
		            /**
		             * Sökning av Förnamn, Efternamn och Telefon
		             * @author Linn
		             */
	            }else if (!sokfn.isEmpty() && !soken.isEmpty() && !soktel.isEmpty() && sokmejl.isEmpty())	{
	            	for (Person p: kb.KontaktLista) {
	            		if(sokfn.equalsIgnoreCase(p.getFnamn()) && soken.equalsIgnoreCase(p.getEnamn()) && soktel.equalsIgnoreCase(p.getTel())) {
	            			status += p.getFnamn() + " " + p.getEnamn() + " " + p.getTel() + " " + p.getMejl() + "\n";
	            		}
	            	}
	            	if(status == "") {
	            		status += "Du har sökt på en kontakt som inte finns";
	            	}
	            	statusLabel.setText(status);
	            	
		            /**
		             * Sökning av Förnamn, Efternamn och Mejl
		             * @author Linn
		             */
	            }else if (!sokfn.isEmpty() && !soken.isEmpty() && soktel.isEmpty() && !sokmejl.isEmpty())	{
	            	for (Person p: kb.KontaktLista) {
	            		if(sokfn.equalsIgnoreCase(p.getFnamn()) && soken.equalsIgnoreCase(p.getEnamn()) && sokmejl.equalsIgnoreCase(p.getMejl())) {
	            			status += p.getFnamn() + " " + p.getEnamn() + " " + p.getTel() + " " + p.getMejl() + "\n";
	            		}
	            	}
	            	statusLabel.setText(status);

		            /**
		             * Sökning av Förnamn, Telefon och Mejl
		             * @author Linn
		             */
	            } else if (!sokfn.isEmpty() && soken.isEmpty() && !soktel.isEmpty() && !sokmejl.isEmpty())	{
	            	for (Person p: kb.KontaktLista) {
	            		if(sokfn.equalsIgnoreCase(p.getFnamn()) && soktel.equalsIgnoreCase(p.getTel()) && sokmejl.equalsIgnoreCase(p.getMejl())) {
	            			status += p.getFnamn() + " " + p.getEnamn() + " " + p.getTel() + " " + p.getMejl() + "\n";
	            		}
	            	}
	            	if(status == "") {
	            		status += "Du har sökt på en kontakt som inte finns";
	            	}
		            statusLabel.setText(status); 
		            
		            /**
		             * Sökning av Efternamn, Telefon och Mejl
		             * @author Linn
		             */
	            } else if (sokfn.isEmpty() && !soken.isEmpty() && !soktel.isEmpty() && !sokmejl.isEmpty())	{
	            	for (Person p: kb.KontaktLista) {
	            		if(soken.equalsIgnoreCase(p.getEnamn()) && soktel.equalsIgnoreCase(p.getTel()) && sokmejl.equalsIgnoreCase(p.getMejl())) {
	            			status += p.getFnamn() + " " + p.getEnamn() + " " + p.getTel() + " " + p.getMejl() + "\n";
	            		}
	            	}
	            	if(status == "") {
	            		status += "Du har sökt på en kontakt som inte finns";
	            	}
		            statusLabel.setText(status); 
		            
		            /**
		             * Sökning av Förnamn, Efternamn, Telefon och Mejl
		             * @author Linn
		             */
	            } else if (!sokfn.isEmpty() && !soken.isEmpty() && !soktel.isEmpty() && !sokmejl.isEmpty())	{
	            	for (Person p: kb.KontaktLista) {
	            		if(sokfn.equalsIgnoreCase(p.getFnamn()) && soken.equalsIgnoreCase(p.getEnamn()) && soktel.equalsIgnoreCase(p.getTel()) && sokmejl.equalsIgnoreCase(p.getMejl())) {
	            			status += p.getFnamn() + " " + p.getEnamn() + " " + p.getTel() + " " + p.getMejl() + "\n";
	            		}
	            	}
	            	if(status == "") {
	            		status += "Du har sökt på en kontakt som inte finns";
	            	}
		            statusLabel.setText(status); 
		            
	            }else {
	            	status += "Du har inte gjort en sökning!";
	            	statusLabel.setText(status);   
	            }              
	    	}
	    });
		
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
    
    /**
     * Metod för att lägga till kontakt i kontaktlistan i det grafiska interfacet
     * @return en JPanel med JLabels och JTextfields
     * @author Linn och Louise
     */
    
    public JPanel laggTill() {
    	laggTillPanel = new JPanel();
    	GridLayout gl = new GridLayout(5,1); 
    	laggTillPanel.setLayout(gl);
    	JButton laggTillKnapp = new JButton("Lägg till");
	    
		JLabel fornamnLabel = new JLabel("Förnamn: ");
		JTextField fornamnInput = new JTextField(30);
		JLabel efternamnLabel = new JLabel("Efternamn: ");
		JTextField efternamnInput = new JTextField(30);
	    JLabel telLabel = new JLabel("Telefonnummer: ");
	    JTextField telInput = new JTextField(30);		    
	    JLabel mejlLabel = new JLabel("Mejladress: ");
	    JTextField mejlInput = new JTextField(30);
	    
	    fornamnInput.setText("");
		efternamnInput.setText("");
	    telInput.setText("");
	    mejlInput.setText("");

	    laggTillKnapp.setActionCommand("Lägg till");
	    
	    laggTillKnapp.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		laggfn = fornamnInput.getText();		   
	    		laggen = efternamnInput.getText();
	    		laggtel = telInput.getText();
	            laggmejl = mejlInput.getText();
	            System.out.println(laggfn + "\t" + laggen + "\t" + laggtel + "\t "+ laggmejl);
	            statusLabel.setText("Kontakt har lagts till!");	
	            kb.läggTill(laggfn, laggen, laggtel, laggmejl);
	            StringBuilder sb = new StringBuilder();
	            sb = bb.skapaText(kb.getKontaktLista());
	            fil.skapaFil(sb);
	    	}
	    });
		
	    laggTillPanel.add(fornamnLabel);
	    laggTillPanel.add(fornamnInput);
	    laggTillPanel.add(efternamnLabel);
	    laggTillPanel.add(efternamnInput);
	    laggTillPanel.add(telLabel);
	    laggTillPanel.add(telInput);
	    laggTillPanel.add(mejlLabel);
	    laggTillPanel.add(mejlInput);
	    laggTillPanel.add(laggTillKnapp);
    	return laggTillPanel;
    }
    
    /**
     * Metod för att ta bort kontakt i kontaktlistan i det grafiska interfacet
     * @return en JPanel med JLabels och JTextfields, ÄNDRAS??? 
     * @author Linn och Louise
     */
    public JPanel taBort() {
    	taBortPanel = new JPanel();

    	ArrayList<String> listlista = new ArrayList<String>();
    	String s = "";
    	for(Person p : kb.KontaktLista) {
    		s = "";
    		s += bb.pad(p.getFnamn(), 25, ' ');
    		s += bb.pad(p.getEnamn(), 20, ' ');
    		s += bb.pad(p.getTel(), 25, ' ');
    		s += bb.pad(p.getMejl(), 15, ' ');
    		
    		listlista.add(s);
    		listlista.sort(null);
    		System.out.println(s);
    	}

		JList<String> list = new JList(listlista.toArray());
		list.setLayoutOrientation(JList.VERTICAL);
		scrollPane = new JScrollPane(list);
		
    	JButton taBortKnapp = new JButton("Ta bort");

//    	ListSelectionListener listSelectionListener = new ListSelectionListener() {
//    	      public void valueChanged(ListSelectionEvent listSelectionEvent) {
//    	    	  
//    	      }
//    	listSelectionModel.addListSelectionListener(new ListSelectionListener() {
//    		public void valueChanged(ListSelectionEvent e) {
//    			bb.pad(p.getFnamn()
//    					kb.KontaktLista
//    		}
//    	});
	    
	    taBortKnapp.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		bortfn = fornamnInput.getText();		   
	    		borten = efternamnInput.getText();
	    		borttel = telInput.getText();
	            bortmejl = mejlInput.getText();
	            System.out.println("korv korv korv" + bortfn + borten + borttel + bortmejl);
	            statusLabel.setText("Kontakt har hittats och tagits bort!");	
	    	}
	    });

	    taBortPanel.add(scrollPane);
	    taBortPanel.add(taBortKnapp);
    	return taBortPanel;
    }
    
    /**
     * Metod för att visning av cards i rullistan
     * @author Linn
     */
    public void itemStateChanged(ItemEvent evt) {
        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, (String)evt.getItem());
    }
       
    /**
     * Metod skapar själva Jframefönstret och visar det. Metoden anropas i main.
     * @author Linn
     */
    static void skaparOchVisarGUI() {

        JFrame frame = new JFrame("KONTAKTBOK");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
        Ui gui = new Ui();
        gui.addComponentToPane(frame.getContentPane());
         
        frame.pack();
        frame.setVisible(true);
    }
     
    /**
     * Metod som skapar GUI.
     * @author Linn
     */
    public static void skaparGUI() {

        try {
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
        
        UIManager.put("swing.boldMetal", Boolean.FALSE);
         
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                skaparOchVisarGUI();
            }
        });  
    }
}
