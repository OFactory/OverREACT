package de.OFactory.OverREACT.Objects;

import java.util.ArrayList;

public class Elements {
	
	public static ArrayList<Element> PSE = new ArrayList<Element>();

	//        NAME			 {Ordnungszahl, Symbol, Gruppe, Periode}
	public static final Element WASSERSTOFF = new Element("Wasserstoff", "H", 1,  1, 1);
	public static final Element KOHLENSTOFF = new Element("Kohlenstoff", "C", 6,  4, 2);
	public static final Element STICKSTOFF  = new Element("Stickstoff",  "N", 7,  5, 2);
	public static final Element SAUERSTOFF  = new Element("Sauerstoff",  "O", 8,  6, 2);
	public static final Element SCHWEFEL    = new Element("Brom",       "Br", 16, 6, 3);
	public static final Element FLOUR       = new Element("Flour",       "F", 9,  7, 2);
	public static final Element CHLOR       = new Element("Chlor",      "Cl", 17, 7, 3);
	public static final Element BROM        = new Element("Brom",       "Br", 35, 7, 4);
	
	private static void loadPSE(){
		PSE.add(Elements.WASSERSTOFF);
		PSE.add(Elements.KOHLENSTOFF);
		PSE.add(Elements.STICKSTOFF);
		PSE.add(Elements.SAUERSTOFF);
		PSE.add(Elements.FLOUR);
		PSE.add(Elements.CHLOR);
		PSE.add(Elements.BROM);
	}
	
	
	public static Element getBySymbol(String symbol) {
		
		loadPSE();
		
		for( Element e : PSE){
			
			if(e.getSymbol() == symbol)
				return e;
			
		}
		
		return null;
	}
}
