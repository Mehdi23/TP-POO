package org.mehdi.project;

public class Capital extends Ville {
	private String monument;

	// Constructeur par défaut
	public Capital() {
		// Ce mot clé appelle le constructeur de la classe mère
		super();
		monument = "aucun";
	}

	// Constructeur d'initialisation de capitale
	public Capital(String nom, int hab, String pays, String monument) {
		super(nom, hab, pays);
		this.monument = monument;
	}

	public String getMonument() {
		return monument;
	}

	// Définit le nom du monument
	public void setMonument(String monument) {
		this.monument = monument;
	}

	public String decrisToi() {
		String str = super.decrisToi() + "\n \t ==>>" + this.monument
				+ " en est un monument";
		System.out.println("Invocation de super.decrisToi()");
		return str;
	}

}
