package org.mehdi.project;

public class TpPoo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/****** 03-04-2015 TP0 - installer l'environnement **/
		/* System.out.print("Hello World !"); */

		/****** 06-04-2015 TP1 - cr�er la premi�re classe - dur�e 30min **/
		/*
		 * Ville ville = new Ville(); System.out.println(ville.nomVille);
		 * ville.nomVille = "la t�te � toto ! ! ! !";
		 * System.out.println(ville.nomVille);
		 * 
		 * Ville ville2 = new Ville("Marseille", 123456789, "France");
		 * ville2.nomPays = "La t�te � tutu ! ! ! ! ";
		 * System.out.println(ville2.nomPays);
		 * 
		 * ville.setNom("Hong Kong"); ville2.setNomPays("France");
		 * System.out.println(" v1 = " + ville.getNom() + " ville de  " +
		 * ville.getNombreHabitants() + " habitants se situant en " +
		 * ville.getNomPays()); System.out.println(" v2 = " + ville2.getNom() +
		 * " ville de  " + ville2.getNombreHabitants() +
		 * " habitants se situant en " + ville2.getNomPays() + "\n\n");
		 * 
		 * String val1 = ville.comparer(ville2); System.out.println(val1);
		 * 
		 * System.out.println("Le nombre d'instances de la classe Ville : <" +
		 * Ville.getNombreInstancesBis() + ">");
		 */

		/****** 06-04-2015 TP2 - H�ritage - dur�e 30min **/
		Capital cap = new Capital();
		System.out.println("Le nombre d'instances de la classe Capital : <"
				+ Capital.getNombreInstancesBis() + ">");

		Capital paris = new Capital("Paris", 654987, "France", "la tour Eiffel");
		System.out.println("Monument de Paris : <" + paris.getMonument() + ">");

		// Polymorphism : Pour faire court, nous pouvons le d�finir en disant qu'il permet de manipuler des objets sans vraiment conna�tre leur type.
		// D�finition d'un tableau de villes null
		Ville[] tableau = new Ville[6];
		// D�finition d'un tableau de noms de villes et un autre de nombres
		// d'habitants
		String[] tab = { "Marseille", "lille", "caen", "lyon", "paris",
				"nantes" };
		int[] tab2 = { 123456, 78456, 654987, 75832165, 1594, 213 };
		// Les trois premiers �l�ments du tableau seront des villes,
		// et le reste, des capitales
		for (int i = 0; i < 6; i++) {
			if (i < 3) {
				Ville V = new Ville(tab[i], tab2[i], "france");
				tableau[i] = V;
			}
			else {
				Capital C = new Capital(tab[i], tab2[i], "france",
						"la tour Eiffel");
				tableau[i] = C;
			}
		}
		// Il ne nous reste plus qu'� d�crire tout notre tableau !
		for (Ville V : tableau) {
			System.out.println(V.decrisToi() + "\n");
		}

	}

}
