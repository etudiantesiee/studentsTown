package fr.esiee.pic.studentsTown.infrastructure;

import java.util.ArrayList;
import java.util.List;

import fr.esiee.pic.studentsTown.domain.Appartement;
import fr.esiee.pic.studentsTown.domain.Etudiant;
import fr.esiee.pic.studentsTown.domain.Piece;

/**
 * 
 * Retourne toutes les appartements disponibles
 * 
 * @author etudiant
 *
 */
public class AppartementFactory {
	
	private static AppartementFactory instance;
	
	private AppartementFactory() {
		super();
	}
	
	public static AppartementFactory getInstance() {
		if (instance == null) {
			instance = new AppartementFactory();
		}
		
		return instance;
	}
	
	public List<Appartement> recupererTousLesAppartements() {
		List<Appartement> allAppart = new ArrayList<>();
		
		allAppart.addAll(this.recupererAppartementNord());
		allAppart.addAll(this.recupererAppartementSud());
		allAppart.addAll(this.recupererAppartementEst());
		allAppart.addAll(this.recupererAppartementOuest());
		
		return allAppart;
	}
	
	private List<Appartement> recupererAppartementNord() {
		List<Appartement> appartNord = new ArrayList<>();
		
		Etudiant guillaume = new Etudiant("Gui");
		Etudiant julien = new Etudiant("Ju");
		Etudiant jean = new Etudiant("Zozo");
		Etudiant tobo = new Etudiant("Tobo");

		Piece guillaumePiece = new Piece(300, 100, 100, 100, guillaume);
		Piece julienPiece = new Piece(300 + 100, 100, 100, 100, julien);
		Piece jeanPiece = new Piece(300, 100 + 100, 100, 100, jean);
		Piece toboPiece = new Piece(300 + 100, 100 + 100, 100, 100, tobo);
		
		Appartement appart = new Appartement();
		appart.addPiece(guillaumePiece);
		appart.addPiece(julienPiece);
		appart.addPiece(jeanPiece);
		appart.addPiece(toboPiece);
		
		appartNord.add(appart);
		
		return appartNord;
	}
	
	private List<Appartement> recupererAppartementSud() {
		List<Appartement> appartSud = new ArrayList<>();
		
		Etudiant chloe = new Etudiant("Chloé");
		Etudiant remi = new Etudiant("Rémi");
		Etudiant pierre = new Etudiant("Pierre");
		Etudiant antoine = new Etudiant("Antoine");
		
		Piece chloePiece = new Piece(100,100,100,200,chloe);
		Piece remiPiece = new Piece(200,100,100,200,remi);
		Piece pierrePiece = new Piece(100,300,100,200,pierre);
		Piece antoinePiece = new Piece(200,300,100,200,antoine);
		
		Appartement fifteenfifty = new Appartement();
		fifteenfifty.addPiece(chloePiece);
		fifteenfifty.addPiece(remiPiece);
		fifteenfifty.addPiece(pierrePiece);
		fifteenfifty.addPiece(antoinePiece);
		
		appartSud.add(fifteenfifty);
		
		return appartSud;
	}
	
	private List<Appartement> recupererAppartementEst() {
		List<Appartement> appartEst = new ArrayList<>();
		
		Etudiant zacharie = new Etudiant("Zacharie");
		Etudiant antony = new Etudiant("Antony");
		Etudiant helene = new Etudiant("Helene");
		Etudiant amaury = new Etudiant("Amaury");
		
		
		Piece zachPiece = new Piece(1200,300,200,200,zacharie);
		Piece antoPiece = new Piece(1400,300,200,200,antony);
		Piece helPiece = new Piece(1200,500,200,200,helene);
		Piece amauPiece = new Piece(1400,500,200,200,amaury);
		
		Appartement appart = new Appartement();
		appart.addPiece(zachPiece);
		appart.addPiece(antoPiece);
		appart.addPiece(helPiece);
		appart.addPiece(amauPiece);
		
		appartEst.add(appart);
		
		return appartEst;
	}
	
	private List<Appartement> recupererAppartementOuest() {
		List<Appartement> appartOuest = new ArrayList<>();
		return appartOuest;
	}

}
