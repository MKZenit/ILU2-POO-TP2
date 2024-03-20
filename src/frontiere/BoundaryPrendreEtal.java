package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		boolean nomVendeurConnu = this.controlPrendreEtal.verifierIdentite(nomVendeur);
		if(!nomVendeurConnu) {
			System.out.println(new StringBuilder()
					.append("Je suis désolée ")
					.append(nomVendeur)
					.append(" mais il faut être un habitant de notre village pour commercer ici.")
					.toString() );
		}
		else {
			System.out.println(new StringBuilder()
					.append("Bonjour ")
					.append(nomVendeur)
					.append(" ,je vais regarder si je peux vous trouver un étal.")
					.toString() );
			if(!this.controlPrendreEtal.resteEtals()) {
				System.out.println(new StringBuilder()
						.append("Désolée ")
						.append(nomVendeur)
						.append(" je n'ai plus d'étal qui ne soit pas déjà occupé.")
						.toString() );
			}
			else {
				this.installerVendeur(nomVendeur);
			}
			
		}
	}

	private void installerVendeur(String nomVendeur) {
		String produit;
		
			System.out.println("C'est parfait, il me reste un étal pour vous !\nIl me faudrait quelques reseignements :\n");
			System.out.println("Quel produit souhaitez-vous vendre ?");
			produit = scan.nextLine();

			int nbProduit = Clavier.entrerEntier("Combien souhaitez-vous en vendre ?");
			int numeroEtal = this.controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
			if(numeroEtal != -1) {
				System.out.println(new StringBuilder()
						.append("Le vendeur ")
						.append(nomVendeur)
						.append(" s'est installé à l'étal n°")
						.append(numeroEtal+1)
						.toString() );
			}
	}
}
