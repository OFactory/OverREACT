package de.OFactory.OverREACT.Objects;

public class Atom {
	
	private Element element;
	private int electrons;
	private double binds = this.getElectronAmount()/2;
	
	public Atom(Element element){
		this.setElement(element);
		
		this.setElectronAmount(this.getElement().getGroup());
		this.setElectronBinds(this.getElectronAmount()/2);
		
		
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
	
	
	
}
