package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		String[] infosMarche = this.controlAfficherMarche.donnerInfosMarche();
		if(infosMarche.length == 0) {
			System.out.println("Le marché est vide, revenez plus tard.");
		}
		else {
			System.out.println(new StringBuilder()
					.append(nomAcheteur)
					.append(", vous trouverez au marché :")
					.toString() );

			for(int i=0; i<infosMarche.length/3; i++) {
				System.out.println(new StringBuilder()
						.append("- ")
						.append(infosMarche[i++])
						.append(" qui vend ")
						.append(infosMarche[i++])
						.append(" ")
						.append(infosMarche[i++])
						.toString() );
			}
			
		}
	}
}
