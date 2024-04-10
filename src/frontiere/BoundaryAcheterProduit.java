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
			System.out.println("Quel produit voulez-vous acheter ?");
			String produit = scan.nextLine();
			var question = new StringBuilder()
					.append("Chez quel commer�ant voulez-vous acheter des fleurs ?");
			String[] vendeursProduit = this.controlAcheterProduit.trouverVendeursProduit(produit);
			if(vendeursProduit.length==0) {
				System.out.println("D�sol�, personne ne vend ce produit au march�.");
			}
			else {
				question.append("\n");
				for(int i=1; i<=vendeursProduit.length; i++) {
					question.append(i+"- ");
					question.append(vendeursProduit[i-1]);
					question.append("\n");
				}
				int choixVendeur = 1;
				do {
					if(choixVendeur<1 || choixVendeur>vendeursProduit.length) 
						System.out.println("Vous devez entrer un nombre compris entre 1 et "+vendeursProduit.length);
					choixVendeur = Clavier.entrerEntier(question.toString());
				}while(choixVendeur<1 || choixVendeur>vendeursProduit.length);
				String nomVendeurChoisi = vendeursProduit[choixVendeur-1];
				System.out.println(nomAcheteur+" se déplace jusqu'à l'étal du vendeur "+nomVendeurChoisi);
				System.out.println("Bonjour "+nomAcheteur);
				int nbSouhaiter = Clavier.entrerEntier("Combien de "+produit+ " voulez-vous acheter ?");
				int nbAcheter = this.controlAcheterProduit.acheterProduit(nomVendeurChoisi, nbSouhaiter);
				if(nbAcheter<=0) {
					System.out.println(nomAcheteur+" veut acheter "+ nbSouhaiter + " "+ produit + ", malheureusement il n'y en a plus !");
				}else if(nbAcheter<nbSouhaiter) {
					System.out.println(new StringBuilder()
							.append(nomAcheteur)
							.append(" veut acheter ")
							.append(nbSouhaiter)
							.append(" ")
							.append(produit)
							.append(", malheureusement ")
							.append(nomVendeurChoisi)
							.append(" n'en a plus que ")
							.append(nbAcheter)
							.append(". ")
							.append(nomAcheteur)
							.append(" achète tout le stock de Bonemine.")
							.toString());
				}
				else {
					System.out.println(new StringBuilder()
							.append(nomAcheteur)
							.append(" achète ")
							.append(nbSouhaiter)
							.append(produit)
							.append(" à ")
							.append(nomVendeurChoisi)
							.toString());
				}
			}
		}
		
	}
}
