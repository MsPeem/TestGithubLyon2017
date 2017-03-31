package presentation;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import metier.Client;
import service.ClientService;
import service.IClientService;

public class Fenetre extends JFrame {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		// Liste des composants de ma fenêtre
		private JLabel jl1 = new JLabel("NOM");
		private JLabel jl2 = new JLabel("Prenom");
		private JLabel jl3 = new JLabel("Couleur des yeux");
		private JTextField jtf1 = new JTextField(12);
		private JTextField jtf2 = new JTextField(20);
		private JTextField jtf3 = new JTextField(10);
		private JButton jb1 = new JButton("Ajouter");
		private JButton jb2 = new JButton("Modifier");
		private JButton jb3 = new JButton("Vider");
		private List liste1 = new List();
		private List liste2 = new List();
		
		private IClientService service = new ClientService();
		Client c = new Client();
		
		public Fenetre(String nom) {

			// Disposition de la fenêtre principale
			super(nom);
			setSize(800, 600);

			this.setLayout(new BorderLayout());

			// Ajout de la première ligne
			JPanel jp1 = new JPanel();
			jp1.setLayout(new BoxLayout(jp1, BoxLayout.PAGE_AXIS));
			jp1.add(jl1);
			jp1.add(jtf1);
			jp1.add(jl2);
			jp1.add(jtf2);
			jp1.add(jl3);
			jp1.add(jtf3);

			
			JPanel jp11 = new JPanel();
			jp11.setLayout(new FlowLayout());
			jp11.add(jb1);
			jp11.add(jb2);
			jp11.add(jb3);
			
			JPanel jp12 = new JPanel();
			jp12.setLayout(new BoxLayout(jp12, BoxLayout.PAGE_AXIS));
			jp12.add(jp1);
			jp12.add(jp11);
			
			this.add(jp12, BorderLayout.NORTH);
		

			// Ajout de la seconde ligne

			JPanel jp2 = new JPanel();
			jp2.setLayout(new GridLayout());
			jp2.add(liste1);
			jp2.add(liste2);

			this.add(jp2, BorderLayout.CENTER);
			
			// rendre le bouton actif en lui donnant une action à réaliser
			jb1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// récupération des paramètres saisis parl'utilisateur
					String nom = jtf1.getText();
					String prenom = jtf2.getText();
					String couleurYeux = jtf3.getText();
					
					// appel de la couche service
					c.setNom(nom);
					c.setPrenom(prenom);
					c.setCouleurYeux(couleurYeux);
					service.ajouterClient(c);
					
					// vider les champs après ajout en base
					jtf1.setText("");
					jtf2.setText("");
					jtf3.setText("");
					
				}
			});

		}

}
