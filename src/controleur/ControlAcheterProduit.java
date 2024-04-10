package controleur;

import personnages.Gaulois;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public boolean verifierIdentite(String nomVendeur) {
		return this.controlVerifierIdentite.verifierIdentite(nomVendeur);
	}
	
	public String[] trouverVendeursProduit(String produit) {
		Gaulois[] vendeurs = this.village.rechercherVendeursProduit(produit);
		String[] nomVendeurs = new String[vendeurs.length];
		for(int i=0; i<vendeurs.length; i++) {
			nomVendeurs[i] = vendeurs[i].getNom();
		}
		return nomVendeurs;
	}
	
	public int acheterProduit(String nomVendeur, int nbAcheter) {
		return this.controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur).acheterProduit(nbAcheter);
	}
	
}
