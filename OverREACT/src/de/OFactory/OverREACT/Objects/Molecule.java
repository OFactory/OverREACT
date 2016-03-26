package de.OFactory.OverREACT.Objects;

import java.awt.Graphics;
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
	
	public Molecule(String name, String formula, ArrayList<Tuple<Integer, Integer>> electronbinds){
		this.setName(name);
		this.setAtoms(this.getAtoms(formula));
		this.setElectronBinds(electronbinds);
	
	}
	
	public void addAtom(Atom a) {
		this.getAtoms().add(a);
		a.setMolecule(this);
	}
	
	public void addAtom(Element e) {
		this.getAtoms().add(new Atom(e));
	}
	
	public void addElectronBind(int firstAtom, int secondAtom) {
		this.getElectronBinds().add(new Tuple<Integer, Integer>(firstAtom, secondAtom));
	}
	
	
	public void draw(Graphics g){
		LEWISHandler.drawMolecule(g, this);
	}
	
	
	//Bekommt Formel : S.x;S.y; z.B H.2;O.1;
	@SuppressWarnings("null")
	private ArrayList<Atom> getAtoms(String formula) {
		ArrayList<Atom> formula_atoms = null;
		
		for(String s : formula.split(";")){
			String[] values = s.split(".");
			
			int amount = Integer.parseInt(values[1]);
			Element e = Elements.getBySymbol(values[0]);
			
			
			
			for (int i = 0; i<amount; i++){
				formula_atoms.add(new Atom(e));
			}
			
		}
		
		
		
		return formula_atoms;
		
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
