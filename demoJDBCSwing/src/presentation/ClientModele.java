package presentation;

import java.util.List;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import metier.Client;

public class ClientModele extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// colonnes de ma table (définition pour un tableau fini)
	private String[] tableColumnNames = new String[] { "NOM", "PRENOM", "COULEUR DES YEUX", "ID" };

	// lignes de ma table
	private Vector<String[]> tableValues = new Vector<String[]>();

	// nombre de colonnes
	@Override
	public int getColumnCount() {
		return tableColumnNames.length;
	}

	// nom de lignes
	@Override
	public int getRowCount() {
		return tableValues.size();
	}

	// affiche la valeur en fontion de la ligne et de la colonne
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return tableValues.get(rowIndex)[columnIndex];
	}

	// retourne le nom de la colonne
	public String getColumnName(int column) {
		return tableColumnNames[column];
	}

	// remplir le tableau avec les données issues de la bdd
	public void setData(List<Client> clients) {
		tableValues = new Vector<String[]>();
		for (Client c : clients) {
			tableValues.add(new String[] { c.getNom(), c.getPrenom(), c.getCouleurYeux(), String.valueOf(c.getId()) });
		}
		fireTableChanged(null);
	}
}
