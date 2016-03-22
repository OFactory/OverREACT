package de.OFactory.OverREACT.Objects;

public class Element {
	
	private String name;
	private String symbol;
	
	private int number;
	private int group;
	private int period;
	
	public Element(String name, String symbol, int number, int group, int period){
		this.setName(name);
		this.setSymbol(symbol);
		this.setNumber(number);
		this.setGroup(group);
		this.setPeriod(period);
		
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSymbol() {
		return symbol;
	}
	
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	
	public int getNumber() {
		return number;
	}
	
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	public int getPeriod() {
		return period;
	}
	
	public void setPeriod(int period) {
		this.period = period;
	}
	
	public int getGroup() {
		return group;
	}
	
	public void setGroup(int group) {
		this.group = group;
	}
	
	
	
	
}
