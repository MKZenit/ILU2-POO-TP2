package controleur;

import villagegaulois.Village;

public class ControlPrendreEtal {
	private Village village;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlPrendreEtal(ControlVerifierIdentite controlVerifierIdentite,
			Village village) {
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.village = village;
	}

	public boolean resteEtals() {
		return this.village.rechercherEtalVide();
	}

	public int prendreEtal(String nomVendeur, String produit, int nbProduit) {
		return this.village.installerVendeur(this.village.trouverHabitant(nomVendeur), produit, nbProduit)+1;
	}

	public boolean verifierIdentite(String nomVendeur) {
		return this.controlVerifierIdentite.verifierIdentite(nomVendeur);
	}
}
