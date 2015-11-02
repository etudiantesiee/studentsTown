package fr.esiee.pic.studentsTown.domain;

public class Piece {
	private int xPos;
	private int yPos;
	private int longeur;
	private int largeur;
	private Etudiant etudiant;
	
	public Piece(int xPos, int yPos, int longeur, int largeur, Etudiant etudiant) {
		super();
		this.xPos = xPos;
		this.yPos = yPos;
		this.longeur = longeur;
		this.largeur = largeur;
		this.etudiant = etudiant;
	}

	public int getxPos() {
		return xPos;
	}

	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	public int getyPos() {
		return yPos;
	}

	public void setyPos(int yPos) {
		this.yPos = yPos;
	}

	public int getLongeur() {
		return longeur;
	}

	public void setLongeur(int longeur) {
		this.longeur = longeur;
	}

	public int getLargeur() {
		return largeur;
	}

	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}

	public Etudiant getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	@Override
	public String toString() {
		return "Piece [xPos=" + xPos + ", yPos=" + yPos + ", longeur="
				+ longeur + ", largeur=" + largeur + ", etudiant=" + etudiant
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((etudiant == null) ? 0 : etudiant.hashCode());
		result = prime * result + largeur;
		result = prime * result + longeur;
		result = prime * result + xPos;
		result = prime * result + yPos;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Piece other = (Piece) obj;
		if (etudiant == null) {
			if (other.etudiant != null)
				return false;
		} else if (!etudiant.equals(other.etudiant))
			return false;
		if (largeur != other.largeur)
			return false;
		if (longeur != other.longeur)
			return false;
		if (xPos != other.xPos)
			return false;
		if (yPos != other.yPos)
			return false;
		return true;
	}
}
