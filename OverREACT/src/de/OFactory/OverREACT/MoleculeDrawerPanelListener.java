package de.OFactory.OverREACT;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import de.OFactory.OverREACT.Objects.Atom;
import de.OFactory.OverREACT.Objects.Elements;

public class MoleculeDrawerPanelListener implements MouseMotionListener, MouseListener, ComponentListener, ActionListener, KeyListener{

	@Override
	public void mouseClicked(MouseEvent e) {
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		MoleculeDrawerPanel.leftmaus = true;
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		MoleculeDrawerPanel.leftmaus = false;
		
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
	public void mouseDragged(MouseEvent e) {
		MoleculeDrawerPanel.mausx = e.getX();
		MoleculeDrawerPanel.mausy = e.getY();
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		MoleculeDrawerPanel.mausx = e.getX();
		MoleculeDrawerPanel.mausy = e.getY();
	}


	@Override
	public void componentResized(ComponentEvent e) {
		/**MoleculeDrawerPanel.setScreenWidth(MoleculeDrawerFrame.getPanel().getWidth());
		MoleculeDrawerPanel.setScreenHeight(MoleculeDrawerFrame.getPanel().getWidth());
		
		System.out.println("[Dimensions] " + MoleculeDrawerPanel.getDi + " | " + MoleculeDrawerPanel.getFrame().getHeight());*/
		
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
			MoleculeDrawerPanel.curm.addAtom(a);
			
		} else if(e.getKeyCode() == KeyEvent.VK_C){ // C wird gepresst
			Atom a = new Atom(Elements.KOHLENSTOFF, MoleculeDrawerPanel.mausx, MoleculeDrawerPanel.mausy);
			MoleculeDrawerPanel.curm.addAtom(a);
		}
		
		
		
		if(MoleculeDrawerPanel.selected != null){ // Bewegen des ausgewählten Atoms mit Pfeiltasten		
			
			int dirx = 0;
			int diry = 0;
			int speed = 10;
			
			if(e.getKeyCode() == KeyEvent.VK_UP){ // Up pressed
				diry = -speed;
			} 
			
			if(e.getKeyCode() == KeyEvent.VK_DOWN){ // Down pressedc
				diry = speed;
			}
			
			if(e.getKeyCode() == KeyEvent.VK_LEFT){ // Left pressed
				dirx = -speed;
			}
			
			if(e.getKeyCode() == KeyEvent.VK_RIGHT){ // Right pressed
				dirx = speed;
			}
			
			MoleculeDrawerPanel.selected.setX(MoleculeDrawerPanel.selected.getX() + dirx);
			MoleculeDrawerPanel.selected.setY(MoleculeDrawerPanel.selected.getY() + diry);
			
			
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		System.out.println(e.getActionCommand());
		
		if(e.getActionCommand() == "Save"){
			System.out.println("LOL");
		}
		
	}

	





}
