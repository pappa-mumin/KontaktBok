package main;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ui {

	private JFrame forstaFrame;
	private JLabel headerLabel;
	private JLabel statusLabel;
	private JPanel controlPanel;
	
	public void skapaUI() {
		
		forstaFrame = new JFrame("Kontaktbok");
		forstaFrame.setSize(400, 400);
		forstaFrame.setLayout(new GridLayout(3, 1));
		
		headerLabel = new JLabel(" Hallllåååå", JLabel.CENTER);
		statusLabel = new JLabel(" tjeeeeenaaaa", JLabel.CENTER);
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
}
