package de.OFactory.OverREACT.Objects;

import java.util.ArrayList;

public class Molecule {

	private String name;
	private ArrayList<Atom> atoms;
	private ArrayList<Tuple<Integer, Integer>> electronbinds;
	
	public Molecule(String name, ArrayList<Atom> atoms, ArrayList<Tuple<Integer, Integer>> electronbinds){
		this.setName(name);
		this.setAtoms(atoms);
		this.setElectronBinds(electronbinds);
	
	}
	
	public void addAtom(Element e) {
		this.getAtoms().add(new Atom(e));
	}
	
	public void addElectronBind(int firstAtom, int secondAtom) {
		this.getElectronBinds().add(new Tuple<Integer, Integer>(firstAtom, secondAtom));
	}
	
	
	
	
	
	
	
	public ArrayList<Tuple<Integer, Integer>> getElectronBinds() {
		return electronbinds;
	}
	public void setElectronBinds(ArrayList<Tuple<Integer, Integer>> electronbinds) {
		this.electronbinds = electronbinds;
	}
	
	public ArrayList<Atom> getAtoms() {
		return atoms;
	}
	public void setAtoms(ArrayList<Atom> atoms) {
		this.atoms = atoms;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	} 
	
	
}
