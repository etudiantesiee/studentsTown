package fr.esiee.pic.studentsTown.ui;

/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.List;

import javax.swing.JApplet;
import javax.swing.JFrame;

import fr.esiee.pic.studentsTown.domain.Appartement;
import fr.esiee.pic.studentsTown.domain.Piece;
import fr.esiee.pic.studentsTown.infrastructure.AppartementFactory;

/* 
 * This is like the FontDemo applet in volume 1, except that it 
 * uses the Java 2D APIs to define and render the graphics and text.
 */

public class NoisyLeGrandPrinter extends JApplet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 573699742077413313L;

	private AppartementFactory appartFact = AppartementFactory.getInstance();

	final static int maxCharHeight = 15;
	final static int minFontSize = 6;

	final static Color bg = Color.white;
	final static Color fg = Color.black;
	final static Color red = Color.red;
	final static Color white = Color.white;

	final static BasicStroke stroke = new BasicStroke(2.0f);
	final static BasicStroke wideStroke = new BasicStroke(8.0f);

	final static float dash1[] = { 10.0f };
	final static BasicStroke dashed = new BasicStroke(1.0f,
			BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash1, 0.0f);
	Dimension totalSize;
	FontMetrics fontMetrics;

	public void init() {
		// Initialize drawing colors
		setBackground(bg);
		setForeground(fg);
	}

	FontMetrics pickFont(Graphics2D g2, String longString, int xSpace) {
		boolean fontFits = false;
		Font font = g2.getFont();
		FontMetrics fontMetrics = g2.getFontMetrics();
		int size = font.getSize();
		String name = font.getName();
		int style = font.getStyle();

		while (!fontFits) {
			if ((fontMetrics.getHeight() <= maxCharHeight)
					&& (fontMetrics.stringWidth(longString) <= xSpace)) {
				fontFits = true;
			} else {
				if (size <= minFontSize) {
					fontFits = true;
				} else {
					g2.setFont(font = new Font(name, style, --size));
					fontMetrics = g2.getFontMetrics();
				}
			}
		}

		return fontMetrics;
	}

	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		Dimension d = getSize();
		int gridWidth = d.width / 6;

		fontMetrics = pickFont(g2, "Filled and Stroked GeneralPath", gridWidth);

		Color fg3D = Color.lightGray;

		g2.setPaint(fg3D);
		g2.draw3DRect(0, 0, d.width - 1, d.height - 1, true);
		g2.draw3DRect(3, 3, d.width - 7, d.height - 7, false);
		g2.setPaint(fg);

		// draw Rectangle2D.Double
		g2.setStroke(stroke);

		List<Appartement> allApparts = appartFact
				.recupererTousLesAppartements();
		
		Font fonte = new Font("2.TimesRoman ", Font.BOLD, 30);
		BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
		FontMetrics fm = img.getGraphics().getFontMetrics(fonte);
		for (Appartement currentApp : allApparts) {
			for (Piece currentPiece : currentApp.getPieces()) {
				int x = currentPiece.getxPos();
				int y = currentPiece.getyPos();
				int rectWidth = currentPiece.getLongeur();
				int rectHeight = currentPiece.getLargeur();
				
				String textContent = currentPiece.getEtudiant().getName();
				int textLength = fm.stringWidth(textContent);
				int textXPos = x + ((rectWidth/2) - (textLength/2));
				int textYPos = y + (rectHeight/2);
				
				g2.draw(new Rectangle2D.Double(x, y, rectWidth, rectHeight));
				g2.setFont(fonte);
				g2.drawString(textContent, textXPos, textYPos);
			}
		}

	}

	public static void main(String s[]) {
		JFrame f = new JFrame("ShapesDemo2D");
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		JApplet applet = new NoisyLeGrandPrinter();
		f.getContentPane().add("Center", applet);
		applet.init();
		f.pack();
		f.setSize(new Dimension(800, 800));
		f.setVisible(true);
	}

}
