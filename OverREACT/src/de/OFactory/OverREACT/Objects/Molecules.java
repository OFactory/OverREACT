package de.OFactory.OverREACT.Objects;

import java.util.ArrayList;
import java.util.Arrays;

public class Molecules {
	
	public static final Molecule METHAN = new Molecule("Methan",
			new ArrayList<Atom>(Arrays.asList(new Atom(Elements.WASSERSTOFF), new Atom(Elements.WASSERSTOFF), new Atom(Elements.WASSERSTOFF), new Atom(Elements.WASSERSTOFF), new Atom(Elements.KOHLENSTOFF))),
			new ArrayList<Tuple<Integer, Integer>>(Arrays.asList(new Tuple<Integer, Integer>(0, 4), new Tuple<Integer, Integer>(1, 4), new Tuple<Integer, Integer>(2, 4), new Tuple<Integer, Integer>(3, 4))));
	
	/*public static final Molecule METHAN = new Molecule("Methan",
			"H.4;C.1",
			new ArrayList<Tuple<Integer, Integer>>(Arrays.asList(new Tuple<Integer, Integer>(0, 4), new Tuple<Integer, Integer>(1, 4), new Tuple<Integer, Integer>(2, 4), new Tuple<Integer, Integer>(3, 4))));*/

	
	
	
	/*public static final Molecule SCHWEFELSÄURE = new Molecule("Schwefelsäure",
			"H.2;S.1;O.4",
			(ArrayList<Tuple<Integer,Integer>>) Arrays.asList(new Tuple<Integer, Integer>(0, 1)) );*/
	
	
}
