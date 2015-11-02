package fr.esiee.pic.studentsTown.ui;

import com.github.lalyos.jfiglet.FigletFont;


public class WordsPrinter {

	public static void main(String[] args) {
		String valueToPrint = args[0];
		String valueToPrintInAsciiArt = FigletFont.convertOneLine(valueToPrint);
		System.out.println(valueToPrintInAsciiArt);
	}
}
