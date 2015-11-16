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

		Piece guillaumePiece = new Piece(800, 0 , 150, 150, guillaume);
		Piece julienPiece = new Piece(800 + 150, 0, 150, 150, julien);
		Piece jeanPiece = new Piece(800,0 + 150, 150, 150, jean);
		Piece toboPiece = new Piece(800 + 150, 0 + 150, 150, 150, tobo);
		
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
		return appartSud;
	}
	
	private List<Appartement> recupererAppartementEst() {
		List<Appartement> appartEst = new ArrayList<>();
		
		Etudiant zacharie = new Etudiant("Zach");
		Etudiant antony = new Etudiant("Anto");
		Etudiant helene = new Etudiant("Hele");
		Etudiant amaury = new Etudiant("Amau");
		
		
		Piece zachPiece = new Piece(1400,200,150,150,zacharie);
		Piece antoPiece = new Piece(1550,200,150,150,antony);
		Piece helPiece = new Piece(1400,350,150,150,helene);
		Piece amauPiece = new Piece(1550,350,150,150,amaury);
		
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
		
		Etudiant nico = new Etudiant("Nicolas");
		Etudiant tomtom = new Etudiant("Thomas L");
		Etudiant jar = new Etudiant("Jardin");
		
		Piece nicoPiece = new Piece(100, 400, 300, 150, nico);
		Piece tomtomPiece = new Piece(100,550,300,150, tomtom);
		Piece jardinPiece = new Piece(400,400,300,300, jar);
		
		Appartement lAppartDesBG = new Appartement();
		lAppartDesBG.addPiece(nicoPiece);
		lAppartDesBG.addPiece(tomtomPiece);
		
		Appartement jardin = new Appartement();
		jardin.addPiece(jardinPiece);
		

		appartOuest.add(lAppartDesBG);
		appartOuest.add(jardin);
		
		return appartOuest;
	}

}
