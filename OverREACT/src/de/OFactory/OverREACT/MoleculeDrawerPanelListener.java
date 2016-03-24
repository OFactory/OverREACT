package de.OFactory.OverREACT;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import de.OFactory.OverREACT.Objects.Atom;
import de.OFactory.OverREACT.Objects.Elements;

public class MoleculeDrawerPanelListener implements MouseMotionListener, MouseListener, ComponentListener, KeyListener{

	@Override
	public void mouseDragged(MouseEvent e) {
		MoleculeDrawerPanel.mausx = e.getX();
		MoleculeDrawerPanel.mausy = e.getY();
		MoleculeDrawerPanel.leftmaus = true;
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		MoleculeDrawerPanel.mausx = e.getX();
		MoleculeDrawerPanel.mausy = e.getY();
		MoleculeDrawerPanel.leftmaus = false;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentResized(ComponentEvent e) {
		Panel.setScreenWidth(MoleculeDrawerPanel.getFrame().getWidth());
		Panel.setScreenHeight(MoleculeDrawerPanel.getFrame().getHeight());
		Panel.resizeFonts(MoleculeDrawerPanel.getScreenWidth(), MoleculeDrawerPanel.getScreenHeight());
		
		System.out.println("[Dimensions] " + MoleculeDrawerPanel.getFrame().getWidth() + " | " + MoleculeDrawerPanel.getFrame().getHeight());
		
	}

	@Override
	public void componentMoved(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentShown(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentHidden(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_H){ // H wird gepresst
			Atom a = new Atom(Elements.WASSERSTOFF, MoleculeDrawerPanel.mausx, MoleculeDrawerPanel.mausy);
			System.out.println("Well you just created a H");
			MoleculeDrawerPanel.atoms.add(a);
			
		} else if(e.getKeyCode() == KeyEvent.VK_C){
			Atom a = new Atom(Elements.KOHLENSTOFF, MoleculeDrawerPanel.mausx, MoleculeDrawerPanel.mausy);
			System.out.println("Well you just created a C");
			MoleculeDrawerPanel.atoms.add(a);
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}



}
