package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import metier.Client;

public class DAO implements IDAO {

	@Override
	public void ajouterClient(Client c) {

		try {
			// 1- charger le pilote (type de base de donn�es)
			Class.forName("com.mysql.jdbc.Driver");
			// 2- cr�er la connexion (adresse de la base de donn�es, identifiant
			// et MdP)
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bddclients", "root", "");
			// 3- cr�er la requ�te
			// PreparedStatement ps = conn.prepareStatement(
			// "INSERT INTO Client(nom,prenom) VALUES ('" + c.getNom() + "','" +
			// c.getPrenom() + "')");
			PreparedStatement ps = conn.prepareStatement("INSERT INTO Client(nom, prenom, couleurYeux) VALUES (?,?,?)");
			ps.setString(1, c.getNom());
			ps.setString(2, c.getPrenom());
			ps.setString(3, c.getCouleurYeux());
			// 4- ex�cuter la requ�te
			ps.executeUpdate();
			// 5- pr�senter les r�sultats

			// 6- fermer la connexion
			conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// code qui est ex�cut� quelles que soient les �tapes pr�c�dentes
		}

	}

	@Override
	public void modifierClient(int id, String nom, String prenom) {
		try {
			// 1- charger le pilote (type de base de donn�es)
			Class.forName("com.mysql.jdbc.Driver");
			// 2- cr�er la connexion (adresse de la base de donn�es, identifiant
			// et MdP)
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bddclients", "root", "");
			// 3- cr�er la requ�te
			PreparedStatement ps = conn.prepareStatement("UPDATE Client SET nom = ? , prenom = ? where id=?");
			ps.setString(1, nom);
			ps.setString(2, prenom);
			ps.setInt(3, id);
			// 4- ex�cuter la requ�te
			ps.executeUpdate();
			// 5- pr�senter les r�sultats

			// 6- fermer la connexion
			conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// code qui est ex�cut� quelles que soient les �tapes pr�c�dentes
		}

	}

	@Override
	public void supprimerClient(int id) {
		try {
			// 1- charger le pilote (type de base de donn�es)
			Class.forName("com.mysql.jdbc.Driver");
			// 2- cr�er la connexion (adresse de la base de donn�es, identifiant
			// et MdP)
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bddclients", "root", "");
			// 3- cr�er la requ�te
			PreparedStatement ps = conn.prepareStatement("DELETE from client where id=?");
			ps.setInt(1, id);
			// 4- ex�cuter la requ�te
			ps.executeUpdate();
			// 5- pr�senter les r�sultats
			// 6- fermer la connexion
			conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// code qui est ex�cut� quelles que soient les �tapes pr�c�dentes
		}
	}

	@Override
	public Collection<Client> listerClients() {
		Collection<Client> cl = new ArrayList<Client>();
		try {
			// 1- charger le pilote (type de base de donn�es)
			Class.forName("com.mysql.jdbc.Driver");
			// 2- cr�er la connexion (adresse de la base de donn�es, identifiant
			// et MdP)
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bddclients", "root", "");
			// 3- cr�er la requ�te
			PreparedStatement ps = conn.prepareStatement("SELECT * from client");
			// 4- ex�cuter la requ�te
			ResultSet rs = ps.executeQuery();
			// 5- pr�senter les r�sultats

			while (rs.next()) {
				Client c = new Client();
				c.setId(rs.getInt("id"));
				c.setNom(rs.getString("nom"));
				c.setPrenom(rs.getString("prenom"));
				c.setCouleurYeux(rs.getString("couleurYeux"));
				cl.add(c);

			}
			// 6- fermer la connexion
			conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// code qui est ex�cut� quelles que soient les �tapes pr�c�dentes
		}
		return cl;
	}

	@Override
	public Collection<Client> chercherParMC(String mc) {
		Collection<Client> cl = new ArrayList<Client>();
		try {
			// 1- charger le pilote (type de base de donn�es)
			Class.forName("com.mysql.jdbc.Driver");
			// 2- cr�er la connexion (adresse de la base de donn�es, identifiant
			// et MdP)
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bddclients", "root", "");
			// 3- cr�er la requ�te
			PreparedStatement ps = conn.prepareStatement("SELECT * from client where nom like ?");
			ps.setString(1, "%"+mc+"%");
			// 4- ex�cuter la requ�te
			ResultSet rs = ps.executeQuery();
			// 5- pr�senter les r�sultats

			while (rs.next()) {
				Client c = new Client();
				c.setId(rs.getInt("id"));
				c.setNom(rs.getString("nom"));
				c.setPrenom(rs.getString("prenom"));
				cl.add(c);

			}
			// 6- fermer la connexion
			conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// code qui est ex�cut� quelles que soient les �tapes pr�c�dentes
		}
		return cl;
	}

	@Override
	public Client chercherParId(int id) {
		Client c = new Client();
		try {
			// 1- charger le pilote (type de base de donn�es)
			Class.forName("com.mysql.jdbc.Driver");
			// 2- cr�er la connexion (adresse de la base de donn�es, identifiant
			// et MdP)
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bddclients", "root", "");
			// 3- cr�er la requ�te
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM client where id=?");
			ps.setInt(1, id);
			// 4- ex�cuter la requ�te
			ResultSet rs = ps.executeQuery();
			// 5- pr�senter les r�sultats

			rs.next();

			c.setId(rs.getInt("id"));
			c.setNom(rs.getString("nom"));
			c.setPrenom(rs.getString("prenom"));

			// 6- fermer la connexion
			conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// code qui est ex�cut� quelles que soient les �tapes pr�c�dentes
		}

		return c;
	}
}
