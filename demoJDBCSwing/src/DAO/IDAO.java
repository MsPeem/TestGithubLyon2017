package DAO;

import java.util.Collection;

import metier.Client;

public interface IDAO {
	public void ajouterClient(Client c);
	public void modifierClient(int id, String nom, String prenom);
	public void supprimerClient(int id);
	public Collection<Client> listerClients();
	//REcherche pas mots-clés de nom
	public Collection<Client> chercherParMC(String mc);
	public Client chercherParId(int id);
	
}
