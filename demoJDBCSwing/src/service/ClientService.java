package service;

import java.util.Collection;

import DAO.DAO;
import DAO.IDAO;
import metier.Client;

public class ClientService implements IClientService, IClientVipService {
	
	// déclaration de la couche DAO dans la couche service
	private IDAO idao = new DAO();

	@Override
	public void direBonjour() {
		System.out.println("BONJOUR");
	}

	@Override
	public void direAurevoir() {
		System.out.println("AU REVOIR");
	}
	
	public void jeSuisVip() {
		System.out.println("JE SUIS VIP");
	}

	@Override
	public void ajouterClient(Client c) {
		idao.ajouterClient(c);
		
	}

	@Override
	public void modifierClient(int id, String nom, String prenom) {
		idao.modifierClient(id, nom, prenom);
		
	}

	@Override
	public void supprimerClient(int id) {
		idao.supprimerClient(id);
		
	}

	@Override
	public Collection<Client> listerClients() {
		return idao.listerClients();
	}

	@Override
	public Collection<Client> chercherParMC(String mc) {
		return idao.chercherParMC(mc);
	}

	@Override
	public Client chercherParId(int id) {
		return idao.chercherParId(id);
		
	}

	@Override
	public void modifierClient(int id, String nom, String prenom, String couleurYeux) {
		idao.modifierClient(id, nom, prenom);
		
	}


}
