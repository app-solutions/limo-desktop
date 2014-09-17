package fr.appsolutions.limodesktop;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import fr.appsolutions.limo.Cryptosysteme;
import fr.appsolutions.limo.Generator;

public class Main extends JFrame {

	private JPanel contentPane;
	private JTextField text;
	private JTextField clef;
	private JTextField resultat;
	private JButton boutonCrypt;
	private JButton boutonDecrypt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/fr/appsolutions/limodesktop/limewire.png")));
		setResizable(false);
		setTitle("LIMO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 350); // WINDOW SIZE
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel logiciel = new JLabel("LIMO DESKTOP 1.1");
		logiciel.setBounds(12, 12, 576, 15);
		contentPane.add(logiciel);
		
		JLabel labelText = new JLabel("Text:");
		labelText.setBounds(12, 50, 70, 15);
		contentPane.add(labelText);
		
		JLabel labelClef = new JLabel("Clef:");
		labelClef.setBounds(12, 90, 70, 15);
		contentPane.add(labelClef);
		
		JLabel labelResultat = new JLabel("Resultat:");
		labelResultat.setBounds(12, 142, 70, 15);
		contentPane.add(labelResultat);
		
		text = new JTextField();
		text.setBounds(81, 48, 507, 19);
		contentPane.add(text);
		text.setColumns(10);
		
		clef = new JTextField();
		clef.setBounds(81, 88, 507, 19);
		contentPane.add(clef);
		clef.setColumns(10);
		
		resultat = new JTextField();
		resultat.setBounds(81, 161, 507, 121);
		contentPane.add(resultat);
		resultat.setColumns(10);
		
		boutonCrypt = new JButton("crypter");
		boutonCrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Cryptosysteme cr = new Cryptosysteme(text.getText(), clef.getText()).crytpInVernam();
				resultat.setText(cr.getResult());
				
			}
		});
		boutonCrypt.setBounds(603, 187, 117, 25);
		contentPane.add(boutonCrypt);
		
		boutonDecrypt = new JButton("decrypter");
		boutonDecrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Cryptosysteme cr = new Cryptosysteme(text.getText(), clef.getText()).decryptFromVernam();
				resultat.setText(cr.getResult());
				
			}
		});
		boutonDecrypt.setBounds(603, 235, 117, 25);
		contentPane.add(boutonDecrypt);
		
		JButton alea = new JButton("générer");
		alea.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String key = new Generator().generateRandomString(64);
				clef.setText(key);
			}
		});
		alea.setBounds(603, 85, 117, 25);
		contentPane.add(alea);
	}
}
