package org.mehdi.project;

public class Ville {
	String nomVille;
	String nomPays;
	int nbreHabitants;
	public static int nbreInstances = 0;

	// Constructeur par défaut
	public Ville() {
		System.out.println("Création d'une ville !");
		nbreInstances++;
		nomVille = "Inconnu";
		nomPays = "Inconnu";
		nbreHabitants = 0;
	}

	// Constructeur avec paramètres
	public Ville(String pNom, int pNbre, String pPays) {
		System.out.println("Création d'une ville avec des paramètres !");
		nbreInstances++;
		nomVille = pNom;
		nomPays = pPays;
		nbreHabitants = pNbre;
	}

	// ************* ACCESSEURS *************
	// Retourne le nom de la ville
	public String getNom() {
		return nomVille;
	}

	// Retourne le nom du pays
	public String getNomPays() {
		return nomPays;
	}

	// Retourne le nombre d'habitants
	public int getNombreHabitants() {
		return nbreHabitants;
	}

	// ************* MUTATEURS *************
	// Définit le nom de la ville
	public void setNom(String pNom) {
		nomVille = pNom;
	}

	// Définit le nom du pays
	public void setNomPays(String pPays) {
		nomPays = pPays;
	}

	// Définit le nombre d'habitants
	public void setNombreHabitants(int nbre) {
		nbreHabitants = nbre;
	}

	// Retourne une chaîne de caractères selon le résultat de la comparaison
	public String comparer(Ville v1) {
		String str = new String();
		if (v1.getNombreHabitants() > this.nbreHabitants)
			str = v1.getNom() + " est une ville plus peuplée que "
					+ this.nomVille;

		else
			str = this.nomVille + " est une ville plus peuplée que "
					+ v1.getNom();

		return str;
	}

	public static int getNombreInstancesBis() {
		return nbreInstances;
	}

	// Retourne la description de la ville

	public String decrisToi() {
		return "\t" + this.nomVille + " est une ville de " + this.nomPays
				+ ", elle comporte : " + this.nbreHabitants;
	}
}
