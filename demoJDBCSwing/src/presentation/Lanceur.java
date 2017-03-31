package presentation;

import java.util.ArrayList;
import java.util.Collection;

import metier.Client;
import service.ClientService;
import service.IClientService;
import service.IClientVipService;

public class Lanceur {

	public static void main(String[] args) {
		// déclaration de l'interface client
		IClientService s = new ClientService();
		IClientVipService vips = new ClientService();
		Collection<Client> col = new ArrayList<Client>();

		// déclaration de la classe
		ClientService cs = new ClientService();

		// utilisation de l'interface client
		/*
		 * System.out.println("--------CLIENT NORMAL--------");
		 * s.direAurevoir(); s.direBonjour(); // s.jeSuisVip(); // --> accès
		 * refusé
		 * 
		 * // utilisation de l'interface client vip
		 * System.out.println("--------CLIENT VIP--------");
		 * vips.direAurevoir(); vips.direBonjour(); vips.jeSuisVip();
		 * 
		 * System.out.
		 * println("--------ACCES CLIENT NORMAL DIRECT A LA CLASSE SANS PASSEPAR INTERFACES--------"
		 * );
		 * 
		 */
		/*
		 * en utilisant la classe et non les interfaces le client normal a acces
		 * à jeSuisVip --> non autorisé
		 */
		/*
		 * cs.direAurevoir(); cs.direBonjour(); cs.jeSuisVip(); // --> accès
		 * autorisé
		 */
		// JDBC
		// Client c = new Client();
		// System.out.println("--------AJOUTER CLIENT--------");
		// Client c = new Client();
		// c.setNom("Villard");c.setPrenom("Theo");c.setCouleurYeux("veron");
		// s.ajouterClient(c);

		/*
		 * System.out.println("--------LISTER TOUS LES CLIENTS--------"); col =
		 * s.listerClients(); for (Client cli : col) { System.out.println(cli);
		 * } System.out.println("--------MODIFIER LES CLIENTS--------");
		 * s.modifierClient(7, "VILLAR", "Théo");
		 * 
		 * for (Client cli2 : col) { System.out.println(cli2); }
		 * System.out.println("--------CLIENT SELON ID--------"); Client cli3 =
		 * s.chercherParId(3); System.out.println(cli3);
		 * 
		 * System.out.println("--------SUPPRIMER CLIENT--------");
		 * s.supprimerClient(4); for (Client cli4 : col) {
		 * System.out.println(cli4); }
		 * 
		 * System.out.println("--------NOM CLIENT SELON MOTS CLES--------");
		 * Collection<Client> col2 = s.chercherParMC("t"); for (Client cli5 :
		 * col2) { System.out.println(cli5); }
		 */

		FenetreOnglet f = new FenetreOnglet("Gestion Clients");
		f.setVisible(true);
	}

}
