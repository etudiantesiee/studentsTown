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
		return appartSud;
	}
	
	private List<Appartement> recupererAppartementEst() {
		List<Appartement> appartEst = new ArrayList<>();
		
		Etudiant guillaume = new Etudiant("Guillaume");
		Piece guilPiece = new Piece(100+200 + 200,100,200,400,guillaume);
		
		Appartement guilAppart = new Appartement();
		guilAppart.addPiece(guilPiece);
		
		appartEst.add(guilAppart);
		
		return appartEst;
	}
	
	private List<Appartement> recupererAppartementOuest() {
		List<Appartement> appartOuest = new ArrayList<>();
		return appartOuest;
	}

}
