/*
 * BioJava development code
 *
 * This code may be freely distributed and modified under the
 * terms of the GNU Lesser General Public Licence. This should
 * be distributed with the code. If you do not have a copy,
 * see:
 *
 * http://www.gnu.org/copyleft/lesser.html
 *
 * Copyright for this code is held jointly by the individual
 * authors. These should be listed in @author doc comments.
 *
 * For more information on the BioJava project and its aims,
 * or to join the biojava-l mailing list, visit the home page
 * at:
 *
 * http://www.biojava.org/
 *
 * This code was contributed from the Molecular Biology Toolkit
 * (MBT) project at the University of California San Diego.
 *
 * Please reference J.L. Moreland, A.Gramada, O.V. Buzko, Qing
 * Zhang and P.E. Bourne 2005 The Molecular Biology Toolkit (MBT):
 * A Modular Platform for Developing Molecular Visualization
 * Applications. BMC Bioinformatics, 6:21.
 *
 * The MBT project was funded as part of the National Institutes
 * of Health PPG grant number 1-P01-GM63208 and its National
 * Institute of General Medical Sciences (NIGMS) division. Ongoing
 * development for the MBT project is managed by the RCSB
 * Protein Data Bank(http://www.pdb.org) and supported by funds
 * from the National Science Foundation (NSF), the National
 * Institute of General Medical Sciences (NIGMS), the Office of
 * Science, Department of Energy (DOE), the National Library of
 * Medicine (NLM), the National Cancer Institute (NCI), the
 * National Center for Research Resources (NCRR), the National
 * Institute of Biomedical Imaging and Bioengineering (NIBIB),
 * the National Institute of Neurological Disorders and Stroke
 * (NINDS), and the National Institute of Diabetes and Digestive
 * and Kidney Diseases (NIDDK).
 *
 * Created on 2011/11/08
 *
 */
package org.jcolorbrewer.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

import javax.swing.Icon;

import org.jcolorbrewer.ColorBrewer;



/**
 * Creates a color palette icon from a palette defined by ColorBrewer
 * 
 * @author Peter Rose
 */
public class PaletteIcon implements Icon {
	private ColorBrewer brewer;
	private int colorCount;
	private int width;
	private int height;
	private Color[] colors;
	
	public PaletteIcon(ColorBrewer brewer, int colorCount, int width, int height) {
		this.brewer = brewer;
		this.colorCount = colorCount;
		this.width = width;
		this.height= height;
	}
	
	public void paintIcon(Component c, Graphics g, int x, int y) {
		this.colors = brewer.getColorPalette(colorCount);
		
		for (int i = 0; i < colorCount; i++) {
			g.setColor(colors[i]);
			g.fillRect(x, y+i*height, width, height);
			g.setColor(Color.BLACK);
			g.drawRect(x, y+i*height, width, height);
		}
	}
	
	public int getIconWidth() {
		return width;
	}
	
	public int getIconHeight() {
		return height * colorCount;
	}
}
