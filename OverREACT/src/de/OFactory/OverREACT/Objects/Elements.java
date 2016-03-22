package de.OFactory.OverREACT.Objects;

import java.util.ArrayList;

public class Elements {
	@SuppressWarnings("rawtypes")
	public ArrayList<ArrayList> PSE = new ArrayList<ArrayList>();

	//        NAME			 {Ordnungszahl, Symbol, Gruppe, Periode}
	public static final Element WASSERSTOFF = new Element("Wasserstoff", "H", 1,  1, 1);
	public static final Element KOHLENSTOFF = new Element("Kohlenstoff", "C", 6,  4, 2);
	public static final Element STICKSTOFF  = new Element("Stickstoff",  "N", 7,  5, 2);
	public static final Element SAUERSTOFF  = new Element("Sauerstoff",  "O", 8,  6, 2);
	public static final Element FLOUR       = new Element("Flour",       "F", 9,  7, 2);
	public static final Element CHLOR       = new Element("Chlor",      "Cl", 17, 7, 3);
	public static final Element BROM        = new Element("Brom",       "Br", 35, 7, 4);
	
}
