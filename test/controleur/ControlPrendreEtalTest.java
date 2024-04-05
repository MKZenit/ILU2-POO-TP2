package controleur;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ControlPrendreEtalTest {
	private Chef abraracourcix;
	private Village village;
	
	@BeforeEach
	void test() {
		System.out.println("Initialisation...");
		village = new Village("le village des irréductibles", 3, 2);
		assertTrue(new ControlAfficherVillage(village).donnerNbEtals()==2);
		assertTrue(new ControlAfficherVillage(village).donnerNomVillage()=="le village des irréductibles");
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		var controlEmmenager = new ControlEmmenager(village);
		controlEmmenager.ajouterGaulois("Bonemine", 2);
		controlEmmenager.ajouterDruide("Boverix", 5, 3, 10);
	}
	
	@Test
	void testPrendreEtal() {
		var controlPrendreEtal = new ControlPrendreEtal(new ControlVerifierIdentite(village), village);
		assertTrue(controlPrendreEtal.verifierIdentite("Bonemine"));
		assertTrue(controlPrendreEtal.prendreEtal("Bonemine", "fleurs", 10)==1);
		assertFalse(controlPrendreEtal.verifierIdentite("Clown"));
	}
	
	@Test
	void testResteEtal() {
		var controlPrendreEtal = new ControlPrendreEtal(new ControlVerifierIdentite(village), village);
		assertTrue(controlPrendreEtal.resteEtals());
		controlPrendreEtal.prendreEtal("Boverix", "Potion de force", 5);
		assertTrue(new ControlAfficherVillage(village).donnerNomsVillageois()!=null);
		assertFalse(controlPrendreEtal.resteEtals());
	}
	
	
	
	
}
