package presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import metier.Client;
import service.ClientService;
import service.IClientService;

public class FenetreOnglet extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Liste des composants de l'onglet 1
	private JLabel jl1 = new JLabel("NOM");
	private JLabel jl2 = new JLabel("Prenom");
	private JLabel jl3 = new JLabel("Couleur des yeux");
	private JButton jb1 = new JButton("Ajouter");
	private JTextField jtf1 = new JTextField(12);
	private JTextField jtf2 = new JTextField(20);
	private JTextField jtf3 = new JTextField(10);

	// Liste des composants de l'onglet 2
	private JLabel jl11 = new JLabel("id");
	private JButton jb3 = new JButton("Vider");
	private JTextField jtf11 = new JTextField(10);

	// Liste des composants de l'onglet 3
	private JLabel jl21 = new JLabel("NOM");
	private JLabel jl22 = new JLabel("Prenom");
	private JLabel jl23 = new JLabel("id");
	private JButton jb2 = new JButton("Modifier");
	private JTextField jtf21 = new JTextField(12);
	private JTextField jtf22 = new JTextField(20);
	private JTextField jtf23 = new JTextField(10);

	// Liste des coposants de l'onglet 4
	private JScrollPane jsp;
	private JLabel jlMC = new JLabel("Mot clé");
	private JTextField jtfMC = new JTextField(12);
	private JButton jBValider = new JButton("Valider");
	private JTable jTableClients;
	private JPanel jpN = new JPanel();
	private ClientModele model;

	private IClientService service = new ClientService();
	Client c = new Client();

	/**
	 * Constructeur qui instancie un JFrame, qui est appelé dans le main
	 * 
	 * @param nom
	 */
	public FenetreOnglet(String nom) {

		// Disposition de la fenêtre principale
		super(nom);
		setSize(800, 600);

		this.setLayout(new BorderLayout());
		// (écrasé par le layout de chaque onglet)

		// déclarer JPanel contenant le JTabbedPane
		JPanel ensemble = new JPanel();

		// déclarer un JtabbedPane
		JTabbedPane onglets = new JTabbedPane(SwingConstants.TOP);

		// déclarer un JPanel
		JPanel onglet1 = new JPanel();
		onglet1.setLayout(new BoxLayout(onglet1, BoxLayout.PAGE_AXIS));
		onglet1.add(jl1);
		onglet1.add(jtf1);
		onglet1.add(jl2);
		onglet1.add(jtf2);
		onglet1.add(jl3);
		onglet1.add(jtf3);
		onglet1.add(jb1);

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

		// associer le Jpanel au JTabbedPane
		onglets.addTab("AJOUTER", onglet1);

		// déclarer un autre panel pour un 2eme onglet
		JPanel onglet2 = new JPanel();
		onglet2.setLayout(new FlowLayout());
		onglet2.add(jl11);
		onglet2.add(jtf11);
		onglet2.add(jb3);

		// rendre le bouton actif en lui donnant une action à réaliser
		jb3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// récupération des paramètres saisis parl'utilisateur
				// (transformation en entier)
				int id = Integer.parseInt(jtf11.getText());

				// appel de la couche service
				c.setId((int) id);
				service.supprimerClient((int) id);

				// vider les champs après ajout en base
				jtf11.setText("");

			}
		});

		// associer le Jpanel au JTabbedPane
		onglets.addTab("SUPPRIMER", onglet2);

		// déclarer un JPanel
		JPanel onglet3 = new JPanel();
		onglet3.setLayout(new BoxLayout(onglet3, BoxLayout.PAGE_AXIS));
		onglet3.add(jl21);
		onglet3.add(jtf21);
		onglet3.add(jl22);
		onglet3.add(jtf22);
		onglet3.add(jl23);
		onglet3.add(jtf23);
		onglet3.add(jb2);
		onglet3.setBackground(Color.lightGray);

		// rendre le bouton actif en lui donnant une action à réaliser
		jb2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// récupération des paramètres saisis parl'utilisateur
				String nom = jtf1.getText();
				String prenom = jtf2.getText();
				int id = Integer.parseInt(jtf21.getText());

				// appel de la couche service
				c.setNom(nom);
				c.setPrenom(prenom);
				c.setId(id);
				service.modifierClient(id, nom, prenom);

				// vider les champs après ajout en base
				jtf21.setText("");
				jtf22.setText("");
				jtf23.setText("");

			}
		});
		
		// associer le Jpanel au JTabbedPane
				onglets.addTab("MODIFIER", onglet3);
		
		// création du 4ème onglet
		JPanel onglet4 = new JPanel();
		onglet4.setLayout(new BoxLayout(onglet4, BoxLayout.PAGE_AXIS));
		onglet4.setBackground(Color.DARK_GRAY);
		jpN.setLayout(new FlowLayout());
		jpN.add(jlMC);jpN.add(jtfMC);jpN.add(jBValider);
		onglet4.add(jpN, BorderLayout.NORTH);
		// ajout du tableau
		model = new ClientModele();
		jTableClients = new JTable(model);
		jsp = new JScrollPane(jTableClients);
		onglet4.add(jsp, BorderLayout.CENTER);
		
		jBValider.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String mc = jtfMC.getText();
				model.setData((List<Client>) service.chercherParMC(mc));
				
			}
		});

		// associer le Jpanel au JTabbedPane
				onglets.addTab("LISTER CLIENTS", onglet4);
		

		// associer la JTabbedPAne à ma fenêtre
		onglets.setOpaque(true);
		this.add(onglets);
		// this.getContentPane().add(ensemble);
		// this.setVisible(true);

	}

}
