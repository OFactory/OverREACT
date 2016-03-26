package de.OFactory.OverREACT.Objects;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import de.OFactory.OverREACT.Panel;

/**
 * @author Maximilian
 * 
 * Diese Klasse erhält ein Molecule und zeichnet es.
 * 
 */
public class LEWISHandler {
	
	private Molecule m; // Molecule des Handlers
	
	
	
	
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
			
			if(!(a.getX() == 0 && a.getY() == 0)){
				
				a.draw(g);
			} else {
				a.setX((int) (Panel.getScreenWidth()/4 + Math.random()*(Panel.getScreenWidth()/2)   ));
				a.setY((int) (Panel.getScreenHeight()/4 + Math.random()*(Panel.getScreenHeight()/2) ));
			}
			
			if(a.getElectronBinds() == 2){
				
			}
			
			
			
		}
		
		for(Tuple<Integer, Integer> bind : m.getElectronBinds()){ // Für jedes Elektronenpaar
			g2.setColor(Color.BLACK);
			Line2D.Float line = new Line2D.Float(m.getAtoms().get(bind.x).getX(),
												m.getAtoms().get(bind.x).getY() ,
												m.getAtoms().get(bind.y).getX() ,
												m.getAtoms().get(bind.y).getY() );
			
			Panel.shortenLine(line, Math.pow(Panel.getEuclidanDistance(line), -0.34));
			
			
			g2.draw(line);
		}
		
		
		
		
		
	}
	
}
