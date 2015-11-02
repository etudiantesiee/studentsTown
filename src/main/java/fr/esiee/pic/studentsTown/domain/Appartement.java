package fr.esiee.pic.studentsTown.domain;

import java.util.ArrayList;
import java.util.List;

public class Appartement {
	private List<Piece> pieces;

	public Appartement() {
		super();
		this.pieces = new ArrayList<>();
	}
	
	public void addPiece(Piece p) {
		this.pieces.add(p);
	}

	public List<Piece> getPieces() {
		return pieces;
	}
}
