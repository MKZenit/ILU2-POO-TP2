package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;
import controleur.ControlAfficherMarche;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		if(!this.controlAcheterProduit.verifierIdentite(nomAcheteur)) {
			System.out.println("Je suis d�sol�e " + nomAcheteur + " mais il faut �tre un habitant de notre village pour commercer ici.");
		}
		else {
			StringBuilder question = new StringBuilder();
			question.append("1 - je veux acheter un produit.\n");
			question.append("2 - je veux avoir une vue d'ensemble du march�.\n");
			question.append("3 - quitter l'application.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					System.out.println("Quel produit voulez-vous acheter ?");
					String produit = scan.nextLine();
					question = new StringBuilder()
							.append("Chez quel commer�ant voulez-vous acheter des fleurs ?");
					String[] vendeursProduit = this.controlAcheterProduit.trouverVendeursProduit(produit);
					if(vendeursProduit.length==0) {
						System.out.println("D�sol�, personne ne vend ce produit au march�.");
					}
					else {
						question.append("\n");
						for(int i=0; i<vendeursProduit.length; i++) {
							question.append(i+"- ");
							question.append(vendeursProduit[i]);
							question.append("\n");
						}
						int choixVendeur = 1;
						do {
							if(choixVendeur<1 || choixVendeur>vendeursProduit.length) 
								System.out.println("Vous devez entrer un nombre compris entre 1 et "+vendeursProduit.length);
							choixVendeur = Clavier.entrerEntier(question.toString());
						}while(choixVendeur<1 || choixVendeur>vendeursProduit.length);
						String nomVendeurChoisi = vendeursProduit[choixVendeur];
						System.out.println(nomAcheteur+" se déplace jusqu'à l'étal du vendeur "+nomVendeurChoisi);
						var etal = this.controlAcheterProduit.trouverEtalVendeur(nomVendeurChoisi);
						System.out.println("Bonjour "+nomAcheteur);
						int nbSouhaite = Clavier.entrerEntier("Combien de "+produit+ " voulez-vous acheter ?");
						if(etal.getQuantite()<=0) {
							System.out.println(nomAcheteur+" veut acheter "+ nbSouhaite + " "+ produit + ", malheureusement il n'y en a plus !");
						}else if(etal.getQuantite()<nbSouhaite) {
							System.out.println(new StringBuilder()
									.append(nomAcheteur)
									.append(" veut acheter ")
									.append(nbSouhaite)
									.append(" ")
									.append(produit)
									.append(", malheureusement ")
									.append(nomVendeurChoisi)
									.append(" n'en a plus que ")
									.append(etal.getQuantite())
									.append(". ")
									.append(nomAcheteur)
									.append(" achète tout le stock de Bonemine.")
									.toString());
							etal.acheterProduit(etal.getQuantite());
						}
						else {
							System.out.println(new StringBuilder()
									.append(nomAcheteur)
									.append(" achète ")
									.append(nbSouhaite)
									.append(produit)
									.append(" à ")
									.append(nomVendeurChoisi)
									.toString());
							etal.acheterProduit(nbSouhaite);
						}
					}
					break;

				case 2:
					this.controlAfficherMarche.donnerInfosMarche();
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
