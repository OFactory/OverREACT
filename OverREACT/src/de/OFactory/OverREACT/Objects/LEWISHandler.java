package de.OFactory.OverREACT.Objects;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Line2D;
import java.util.ArrayList;

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
			
			//TODO Freie Elektronenpaare
			
			
			
		}
		
		ArrayList<Tuple<Integer, Integer>> skipped = new ArrayList<Tuple<Integer, Integer>>();
		
		for(Tuple<Integer, Integer> bind : m.getElectronBinds()){ // Für jedes Elektronenpaar
			
			int bind_type = 0;
			
			for(Tuple<Integer, Integer> brotherbind : m.getElectronBinds()) {
				if((bind.x == brotherbind.x && bind.y == brotherbind.y) ||
						(bind.x == brotherbind.y && bind.y == brotherbind.x)) {
					bind_type += 1;
				}
			}
			
			g2.setColor(Color.BLACK);
			double dist = Point.distance(m.getAtoms().get(bind.x).getX() ,
										 m.getAtoms().get(bind.x).getY() ,
										 m.getAtoms().get(bind.y).getX() ,
										 m.getAtoms().get(bind.y).getY() );
			
			if(bind_type == 1){ //Einfachbindung
				
				
				Line2D.Float line = new Line2D.Float(m.getAtoms().get(bind.x).getX() ,
													 m.getAtoms().get(bind.x).getY() ,
													 m.getAtoms().get(bind.y).getX() ,
													 m.getAtoms().get(bind.y).getY() );
				
				Panel.shortenLine(line, (dist - 50) / dist);
				g2.draw(line);
				
			} else if(bind_type >= 2){ //Doppelbindung
				
				int offset = 10; // Entfernung der Elektronenpaarbindung
				
				
				Line2D.Float line1 = new Line2D.Float(m.getAtoms().get(bind.x).getX() + offset,
													  m.getAtoms().get(bind.x).getY() + offset,
													  m.getAtoms().get(bind.y).getX() + offset,
												   	  m.getAtoms().get(bind.y).getY() + offset);
				
				Line2D.Float line2 = new Line2D.Float(m.getAtoms().get(bind.x).getX() - offset,
													  m.getAtoms().get(bind.x).getY() - offset,
													  m.getAtoms().get(bind.y).getX() - offset,
												   	  m.getAtoms().get(bind.y).getY() - offset);
				Panel.shortenLine(line1, (dist - 50) / dist);	
				Panel.shortenLine(line2, (dist - 50) / dist);	
				
				g2.draw(line1);
				g2.draw(line2);
			}
		}
		
		
		
		
		
	}
	
}
