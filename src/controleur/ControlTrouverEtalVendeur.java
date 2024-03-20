package controleur;

import villagegaulois.Etal;
import villagegaulois.Village;

public class ControlTrouverEtalVendeur {
	private Village village;

	public ControlTrouverEtalVendeur(Village village) {
		this.village = village;
	}

	public Etal trouverEtalVendeur(String nomVendeur) {
		var gaulois = this.village.trouverHabitant(nomVendeur);
		Etal etal = null;
		if(gaulois!=null) {
			etal = this.village.rechercherEtal(gaulois);
		}
		return etal;
	}
}
