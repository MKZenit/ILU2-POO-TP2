package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		if(!this.controlLibererEtal.isVendeur(nomVendeur)) {
			System.out.println("Mais vous n'êtes pas inscrit sur notre marché aujourd'hui !");
		}
		else {
			String[] donneesEtal = this.controlLibererEtal.libererEtal(nomVendeur);
			boolean etalOccupe = Boolean.parseBoolean(donneesEtal[0]);
			if(etalOccupe) {
				System.out.println(new StringBuilder()
						.append("Vous avez vendu ")
						.append(Integer.parseInt(donneesEtal[4]))
						.append(" sur ")
						.append(Integer.parseInt(donneesEtal[3]))
						.append(" ")
						.append(donneesEtal[2])
						.append("\nEn revoir ")
						.append(nomVendeur)
						.append(", passez une bonne journée")
						.toString() );
			}
		}
	}

}
