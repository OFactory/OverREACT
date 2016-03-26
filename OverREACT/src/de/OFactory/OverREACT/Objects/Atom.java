package de.OFactory.OverREACT.Objects;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import de.OFactory.OverREACT.MoleculeDrawerPanel;
import de.OFactory.OverREACT.Panel;

public class Atom {
	
	private Element element;
	private int electrons;
	private double binds = this.getElectronAmount()/2;
	private Molecule m;
	
	private int x;
	private int y;
	private boolean dragged;
	
	public Atom(Element element){
		this.setElement(element);
		
		this.setElectronAmount(this.getElement().getGroup());
		this.setElectronBinds(this.getElectronAmount()/2);
		
		
	}
	
	public Atom(Element element, int x, int y){
		this.setElement(element);
		this.x = x;
		this.y = y;
		
		this.setElectronAmount(this.getElement().getGroup());
		this.setElectronBinds(this.getElectronAmount()/2);
		
		
	}

	public void checkMouse(){
		if(MoleculeDrawerPanel.leftmaus){ // Molecule Drawer
			if(new Point(this.x, this.y).distance(new Point(MoleculeDrawerPanel.mausx, MoleculeDrawerPanel.mausy)) < 70){
				
				if(MoleculeDrawerPanel.selected != null){
					if(MoleculeDrawerPanel.selected != this) {
							
							//System.out.println(MoleculeDrawerPanel.curm.getAtoms());
							
							int indexa = m.getAtoms().indexOf(MoleculeDrawerPanel.selected);
							int indext = m.getAtoms().indexOf(this);
							
							//System.out.println(indexa + " | " + indext);
							m.addElectronBind( indexa ,  indext);
							
							MoleculeDrawerPanel.selected = null;
							MoleculeDrawerPanel.leftmaus = false;
					}
					
				} else {
					
					MoleculeDrawerPanel.selected = this;
					
				}			
				
			}
				
		}
	}
	
	public void draw(Graphics g) {
		
		
		this.checkMouse();
		g.setColor(Color.BLACK);
		Panel.drawCenteredString(g, this.getElement().getSymbol(), this.x, this.y, Panel.molecule); // Elementc
		Panel.drawCenteredString(g, this.getElectronAmount() + "", this.x + 50, this.y + 50, Panel.big);
		
		if(MoleculeDrawerPanel.selected == this) {
			g.setColor(Color.blue);
			Graphics2D g2 = (Graphics2D) g;
			g2.setStroke(new BasicStroke(10));
			g2.drawOval(this.x - 70, this.y - 70, 140, 140);
			
			
			if(MoleculeDrawerPanel.leftmaus){
			
				dragged = true;
				g.setColor(Color.gray);
				g2.drawLine(this.getX(), this.getY(), MoleculeDrawerPanel.mausx, MoleculeDrawerPanel.mausy);
			} else {
				dragged = false;
			}
		}
	}
	
	public String toString() {
		return "Atom (" + this.getElement() + ") | " + this.getX() + ";" + this.getY();
	}

	public Element getElement() {
		return element;
	}


	public void setElement(Element element) {
		this.element = element;
	}

	public double getElectronBinds() {
		return binds;
	}

	public void setElectronBinds(double binds) {
		this.binds = binds;
	}


	public int getElectronAmount() {
		return electrons;
	}

	public void setElectronAmount(int electrons) {
		this.electrons = electrons;
	}



	public int getX() {
		return x;
	}



	public void setX(int x) {
		this.x = x;
	}



	public int getY() {
		return y;
	}



	public void setY(int y) {
		this.y = y;
	}

	public Molecule getMolecule() {
		return m;
	}

	public void setMolecule(Molecule m) {
		this.m = m;
	}
	
	
	
}
