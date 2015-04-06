package org.mehdi.project;

public class Ville {
	String nomVille;
	String nomPays;
	int nbreHabitants;
	public static int nbreInstances = 0;

	// Constructeur par d�faut
	public Ville() {
		System.out.println("Cr�ation d'une ville !");
		nbreInstances++;
		nomVille = "Inconnu";
		nomPays = "Inconnu";
		nbreHabitants = 0;
	}

	// Constructeur avec param�tres
	public Ville(String pNom, int pNbre, String pPays) {
		System.out.println("Cr�ation d'une ville avec des param�tres !");
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
	// D�finit le nom de la ville
	public void setNom(String pNom) {
		nomVille = pNom;
	}

	// D�finit le nom du pays
	public void setNomPays(String pPays) {
		nomPays = pPays;
	}

	// D�finit le nombre d'habitants
	public void setNombreHabitants(int nbre) {
		nbreHabitants = nbre;
	}

	// Retourne une cha�ne de caract�res selon le r�sultat de la comparaison
	public String comparer(Ville v1) {
		String str = new String();
		if (v1.getNombreHabitants() > this.nbreHabitants)
			str = v1.getNom() + " est une ville plus peupl�e que "
					+ this.nomVille;

		else
			str = this.nomVille + " est une ville plus peupl�e que "
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
