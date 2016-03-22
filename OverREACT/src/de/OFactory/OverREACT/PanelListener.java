package de.OFactory.OverREACT;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class PanelListener implements MouseMotionListener, MouseListener, ComponentListener{

	@Override
	public void mouseDragged(MouseEvent e) {
		Panel.mausx = e.getX();
		Panel.mausy = e.getY();
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		Panel.mausx = e.getX();
		Panel.mausy = e.getY();
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		Panel.leftmaus = true;
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		Panel.leftmaus = true;
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		Panel.leftmaus = false;
		
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
		Panel.setScreenWidth(Panel.getFrame().getWidth());
		Panel.setScreenHeight(Panel.getFrame().getHeight());
		Panel.resizeFonts(Panel.getScreenWidth(), Panel.getScreenHeight());
		
		System.out.println("[Dimensions] " + Panel.getFrame().getWidth() + " | " + Panel.getFrame().getHeight());
		
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



}
