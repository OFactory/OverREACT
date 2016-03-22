package de.OFactory.OverREACT.Objects;

import java.awt.Point;
import java.awt.geom.Point2D;

import de.OFactory.OverREACT.Panel;

public class Atom {
	
	private Element element;
	private int electrons;
	private double binds = this.getElectronAmount()/2;
	
	private int x;
	private int y;
	
	public Atom(Element element){
		this.setElement(element);
		
		this.setElectronAmount(this.getElement().getGroup());
		this.setElectronBinds(this.getElectronAmount()/2);
		
		
	}

	public void checkMouse(){
		if(Panel.leftmaus){
			if(new Point(this.x, this.y).distance(new Point(Panel.mausx, Panel.mausy)) < 50){
				this.setX(Panel.mausx);
				this.setY(Panel.mausy);
			}
				
		}
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
	
	
	
}
