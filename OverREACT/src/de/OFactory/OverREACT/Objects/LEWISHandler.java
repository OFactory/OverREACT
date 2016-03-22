package de.OFactory.OverREACT.Objects;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Line2D;
import java.util.Hashtable;

import de.OFactory.OverREACT.Panel;

/**
 * @author Maximilian
 * 
 * Diese Klasse erhält ein Molecule und zeichnet es.
 * 
 */
public class LEWISHandler {
	
	private Molecule m; // Molecule des Handlers
	
	public static Hashtable<Atom, Point> atomposition = new Hashtable<Atom, Point>();
	
	
	
	
	public LEWISHandler(Molecule m) {
		this.setMolecule(m);	
	}
	
	
	public void draw(Graphics g){
		LEWISHandler.drawMolecule(g, this.getMolecule());
	}

	public Molecule getMolecule() {
		return m;
	}

	public void setMolecule(Molecule m) {
		this.m = m;
	}
	
	// STATIC PART
	
	public static void drawMolecule(Graphics g, Molecule m) {
		// TODO: Wichtigster TEIL des gesamten Programms #WichtigerAlsDeinLebenAMINA
		
		g.setColor(Color.black);
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(6));
		
		
		for(Atom a : m.getAtoms()){ // für jedes Atom
			
			if(atomposition.containsKey(a)){
				Panel.drawCenteredString(g, a.getElement().getSymbol(), atomposition.get(a).x , atomposition.get(a).y, Panel.molecule);
			} else {
				atomposition.put(a, new Point((int) (Panel.getScreenWidth()/4 + Math.random()*(Panel.getScreenWidth()/2)), (int) (Panel.getScreenHeight()/4 + Math.random()*(Panel.getScreenHeight()/2))));
			}
			
			
			
			
			
		}
		
		for(Tuple<Integer, Integer> bind : m.getElectronBinds()){ // Für jedes Elektronenpaar
			g2.setColor(Color.GRAY);
			Line2D.Float line = new Line2D.Float(atomposition.get(m.getAtoms().get(bind.x)).x,
												atomposition.get(m.getAtoms().get(bind.x)).y ,
												atomposition.get(m.getAtoms().get(bind.y)).x ,
												atomposition.get(m.getAtoms().get(bind.y)).y );
			
			Panel.shortenLine(line, 0.1);
			
			
			g2.draw(line);
		}
		
		
		
		
		
	}
	
}
