package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		if(this.controlAcheterProduit.verifierIdentite(nomAcheteur)) {
			System.out.println("Je suis désolée Bonemine mais il faut être un habitant de notre village pour commercer ici.");
		}
		else {
			StringBuilder question = new StringBuilder();
			question.append("1 - je veux acheter un produit.\n");
			question.append("2 - je veux avoir une vue d'ensemble du marché.\n");
			question.append("3 - quitter l'application.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					System.out.println("Quel produit voulez-vous acheter ?");
					String produit = scan.nextLine();
					question = new StringBuilder()
							.append("Chez quel commerçant voulez-vous acheter des fleurs ?");
					String[] vendeursProduit = this.controlAcheterProduit.trouverVendeursProduit(produit);
					if(vendeursProduit.length==0) {
						System.out.println("Désolé, personne ne vend ce produit au marché.");
					}
					else {
						for(int i=0; i<vendeursProduit.length; i++) {
							question.append(vendeursProduit[i]);
						}
						int choixVendeur = Clavier.entrerEntier(question.toString());
						// TODO vérifier choixVendeur compris dans les bornes de la liste
						String nomVendeurChoisi = vendeursProduit[choixVendeur];
						// TODO suite cas 2
					}
					break;

				case 2:
					//TODO cas 2
					break;

				default:
					System.out
							.println("Vous devez choisir un chiffre entre 1 et 3 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2 && choixUtilisateur !=3);
		}
		
	}
}
