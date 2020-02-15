package main;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
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
	
	//huvudsakligen skriven av Linn
	
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
     * @return en JScrollPane som visar Kontaktlistan
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
	            ArrayList<Person> statuslista2 = new ArrayList<Person>();
	            
//	            Sökning: endast inmatning av Förnamn
	            if(!sokfn.isEmpty() && soken.isEmpty() && soktel.isEmpty() && sokmejl.isEmpty()) {
	            	statuslista = kb.sökEfterFörNamn(sokfn);
	            	for(Person p : statuslista) {
	            		status += p.getFnamn() + " " + p.getEnamn() + " " + p.getMejl() + " " + p.getTel() + "\n";
	            	}
	            	statusLabel.setText(status);
	            
//	            Sökning: endast inmatning av Efternamn
	            } else if(sokfn.isEmpty() && !soken.isEmpty() && soktel.isEmpty() && sokmejl.isEmpty()) {
	            	statuslista = kb.sökEfterEfterNamn(soken);
	            	for(Person p : statuslista) {
	            		status += p.getFnamn() + " " + p.getEnamn() + " " + p.getMejl() + " " + p.getTel() + "\n";
	            	}
	            	statusLabel.setText(status);
	            
//	            Sökning: endast inmatning av Telefonnummer - FUNKAR INTE!
	            } else if(sokfn.isEmpty() && soken.isEmpty() && !soktel.isEmpty() && sokmejl.isEmpty()) {
	            	statuslista = kb.sökEfterTelefonNummer(soktel);
	            	for(Person p : statuslista) {
	            		status += p.getFnamn() + " " + p.getEnamn() + " " + p.getMejl() + " " + p.getTel() + "\n";
	            	}
	            	statusLabel.setText(status);	
	            
//		        Sökning: endast inmatning av Telefonnummer - FUNKAR INTE!
		        } else if(sokfn.isEmpty() && soken.isEmpty() && soktel.isEmpty() && !sokmejl.isEmpty()) {
		          	statuslista = kb.sökEfterMejl(sokmejl);
		           	for(Person p : statuslista) {
		           		status += p.getFnamn() + " " + p.getEnamn() + " " + p.getMejl() + " " + p.getTel() + "\n";
	            	}
	            	statusLabel.setText(status);		
	            
//	            Sökning: Förnamn och Efternamn - FUNKAR INTE!
	            }else if (!sokfn.isEmpty() && !soken.isEmpty() && soktel.isEmpty() && sokmejl.isEmpty())	{
	            	statuslista = kb.sökEfterFörNamn(sokfn);
	            	statuslista2 = kb.sökEfterEfterNamn(soken);
	            	String korv = "";
	            	String korv2 = "";
	            	for(Person p : statuslista) {
	            		korv = p.getFnamn() + " " + p.getEnamn() + " " + p.getMejl() + " " + p.getTel() + "\n";
		            	for(Person p2 : statuslista2) {
		            		korv2 = p2.getFnamn() + " " + p2.getEnamn() + " " + p2.getMejl() + " " + p2.getTel() + "\n";
		            	}
	            	}
            		if(korv.equals(korv2) && korv2.equals(korv)) {
            			status += korv;
            		}else {
            			status += "Ingen träff vid sökning av förnamn och efternamn.";
            		}
		            statusLabel.setText(status);
	            
//		        Sökning: Förnamn och Telefonnummer -FUNKAR INTE!
	            } else if (!sokfn.isEmpty() && soken.isEmpty() && !soktel.isEmpty() && sokmejl.isEmpty())	{
	            	statuslista = kb.sökEfterFörNamn(sokfn);
	            	statuslista2 = kb.sökEfterTelefonNummer(soktel);
	            	String korv = "";
	            	String korv2 = "";
	            	for(Person p : statuslista) {
	            		korv = p.getFnamn() + " " + p.getEnamn() + " " + p.getMejl() + " " + p.getTel() + "\n";
		            	for(Person p2 : statuslista2) {
		            		korv2 = p2.getFnamn() + " " + p2.getEnamn() + " " + p2.getMejl() + " " + p2.getTel() + "\n";
		            	}
	            	}
            		if(korv.equals(korv2)) {
            			status += korv;
            		}else {
            			status += "Ingen träff vid sökning av förnamn och efternamn.";
            		}
		            statusLabel.setText(status);
		       
//			    Sökning: Förnamn och Mejl -FUNKAR INTE!
	            } else if (!sokfn.isEmpty() && soken.isEmpty() && soktel.isEmpty() && !sokmejl.isEmpty())	{
	            	statuslista = kb.sökEfterFörNamn(sokfn);
	            	statuslista2 = kb.sökEfterMejl(sokmejl);
	            	String korv = "";
	            	String korv2 = "";
	            	for(Person p : statuslista) {
	            		korv = p.getFnamn() + " " + p.getEnamn() + " " + p.getMejl() + " " + p.getTel() + "\n";
		            	for(Person p2 : statuslista2) {
		            		korv2 = p2.getFnamn() + " " + p2.getEnamn() + " " + p2.getMejl() + " " + p2.getTel() + "\n";
		            	}
	            	}
            		if(korv.equals(korv2)) {
            			status += korv;
            		}
		            statusLabel.setText(status);
		        
//				Sökning: Efternamn och Telefon - FUNKAR INTE!
	            } else if (sokfn.isEmpty() && !soken.isEmpty() && !soktel.isEmpty() && sokmejl.isEmpty())	{
	            	statuslista = kb.sökEfterEfterNamn(soken);
	            	statuslista2 = kb.sökEfterTelefonNummer(soktel);
	            	String korv = "";
	            	String korv2 = "";
	            	for(Person p : statuslista) {
	            		korv = p.getFnamn() + " " + p.getEnamn() + " " + p.getMejl() + " " + p.getTel() + "\n";
		            	for(Person p2 : statuslista2) {
		            		korv2 = p2.getFnamn() + " " + p2.getEnamn() + " " + p2.getMejl() + " " + p2.getTel() + "\n";
		            	}
	            	}
            		if(korv.equals(korv2)) {
            			status += korv;
            		}
		            statusLabel.setText(status);
		         
//				Sökning: Efternamn och Mejl - FUNKAR INTE!
	            } else if (sokfn.isEmpty() && !soken.isEmpty() && soktel.isEmpty() && !sokmejl.isEmpty())	{
	            	statuslista = kb.sökEfterEfterNamn(soken);
	            	statuslista2 = kb.sökEfterMejl(sokmejl);
	            	String korv = "";
	            	String korv2 = "";
	            	for(Person p : statuslista) {
	            		korv = p.getFnamn() + " " + p.getEnamn() + " " + p.getMejl() + " " + p.getTel() + "\n";
		            	for(Person p2 : statuslista2) {
		            		korv2 = p2.getFnamn() + " " + p2.getEnamn() + " " + p2.getMejl() + " " + p2.getTel() + "\n";
		            	}
	            	}
            		if(korv.equals(korv2)) {
            			status += korv;
            		}
		            statusLabel.setText(status); 
		            
//				Sökning: Telefon och Mejl - FUNKAR INTE!
	            } else if (sokfn.isEmpty() && soken.isEmpty() && !soktel.isEmpty() && !sokmejl.isEmpty())	{
	            	statuslista = kb.sökEfterTelefonNummer(soktel);
	            	statuslista2 = kb.sökEfterMejl(sokmejl);
	            	String korv = "";
	            	String korv2 = "";
	            	for(Person p : statuslista) {
	            		korv = p.getFnamn() + " " + p.getEnamn() + " " + p.getMejl() + " " + p.getTel() + "\n";
		            	for(Person p2 : statuslista2) {
		            		korv2 = p2.getFnamn() + " " + p2.getEnamn() + " " + p2.getMejl() + " " + p2.getTel() + "\n";
		            	}
	            	}
            		if(korv.equals(korv2)) {
            			status += korv;
            		}
		            statusLabel.setText(status);  
		            
	            }else {
	            	status += "Ingen träff!";
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
    
    public JPanel taBort() {
    	taBortPanel = new JPanel();
    	GridLayout gl = new GridLayout(5,1); 
    	taBortPanel.setLayout(gl);
    	JButton taBortKnapp = new JButton("Ta bort");
	    
		JLabel fornamnLabel = new JLabel("Förnamn: ");
		JTextField fornamnInput = new JTextField(30);
		JLabel efternamnLabel = new JLabel("Efternamn: ");
		JTextField efternamnInput = new JTextField(30);
	    JLabel telLabel = new JLabel("Telefonnummer: ");
	    JTextField telInput = new JTextField(30);		    
	    JLabel mejlLabel = new JLabel("Mejladress: ");
	    JTextField mejlInput = new JTextField(30);;		    
	    
	    fornamnInput.setText("");
		efternamnInput.setText("");
	    telInput.setText("");
	    mejlInput.setText("");
	    
	    taBortKnapp.setActionCommand("Ta bort");
	    
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
	    
	    taBortPanel.add(fornamnLabel);
	    taBortPanel.add(fornamnInput);
	    taBortPanel.add(efternamnLabel);
	    taBortPanel.add(efternamnInput);
	    taBortPanel.add(telLabel);
	    taBortPanel.add(telInput);
	    taBortPanel.add(mejlLabel);
	    taBortPanel.add(mejlInput);
	    taBortPanel.add(taBortKnapp);

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
        JFrame frame = new JFrame("KONTAKTBOK");
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
