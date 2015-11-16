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
		List<Appartement> appartSude = new ArrayList<>();
		
		return appartSude;
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
