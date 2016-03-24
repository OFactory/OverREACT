package de.OFactory.OverREACT;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JPanel;

import de.OFactory.OverREACT.Objects.Atom;
import de.OFactory.OverREACT.Objects.Elements;
import de.OFactory.OverREACT.Objects.Molecule;
import de.OFactory.OverREACT.Objects.Molecules;
import de.OFactory.OverREACT.Objects.Tuple;

public class MoleculeDrawerPanel extends JPanel implements Runnable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static ArrayList<Atom> atoms = new ArrayList<Atom>();
	
	private static int SCREEN_WIDTH = 1200;
	private static int SCREEN_HEIGHT = 700;

	private static JFrame frame;
	
	//Schriftarten
	public static Font ultra, big, small, head, norm, molecule; 
	
	//Mausposition
	public static int mausx, mausy;
	public static boolean leftmaus; 
	
	MoleculeDrawerPanelListener pl = new MoleculeDrawerPanelListener();
	
	//TESTVARIABLEN
	static Molecule m;
	
	private long delta, last, fps;
	
	
	public static Button start;
	
	public static void main(String[] args){
		new MoleculeDrawerPanel(getScreenWidth(), getScreenHeight());
		
		
		// TEST AREA INCOMING | WARNING | DO NOT TOUCH
		
		
		
		
		
		// TEST AREA TAIL -.-----**--..--**--
		
	}

	
	
	public MoleculeDrawerPanel(int w, int h){
		this.setPreferredSize(new Dimension(w, h));
		this.setBackground(new Color(230, 230, 230));
		
		// Fenster wird erstellt
		setFrame(new JFrame("Substitution - Eine typische Reaktion der Alkane | OFactory© "));
		//frame.setResizable(false);
		getFrame().setLocation(100,100);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().addComponentListener(pl);		
		getFrame().addMouseMotionListener(pl);
		getFrame().addKeyListener(pl);
		getFrame().add(this);
		getFrame().pack();
		getFrame().setVisible(true);

		
		doInitializations();
		
		Thread th = new Thread(this);
		th.start();
	}

	private void doInitializations() {
		
		
		//Sachen f¸r "einmalige Gelegenheiten"
		last = System.nanoTime();
		
		
	}

	private void computeDelta() {
		//Zeit f¸r jeweils vorherigen Schleifendurchlauf errechnen
		delta = System.nanoTime() - last;
		last = System.nanoTime();
		fps = ((long) 1e9)/delta;
		
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		g.setFont(MoleculeDrawerPanel.norm);
		
		g.setColor(Color.RED);
		g.drawString("FPS: " + this.fps, 10, 15);
		g.drawString("NanoTime: " + this.last, 10, 30);
		g.drawString("delta: " + this.delta, 10, 45);
		g.drawString("Maus: " + MoleculeDrawerPanel.mausx + " | " + MoleculeDrawerPanel.mausy, 10, 60);
		g.drawString("MausPressed: " + MoleculeDrawerPanel.leftmaus, 10, 75);
		
		g.setColor(Color.black);
		
		if(atoms.size() > 0){
			for (Atom a : atoms){
				a.draw(g);
			}
		}
		
		
		 //TESTBEREICH
		//Panel.m.draw(g);
		
		
		g.dispose(); // den ganzen scheiﬂ mal beenden
	}


	@Override
	public void run(){
		
		while(getFrame().isVisible()){
			
			doLogic();
			
			computeDelta();
			repaint();
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {}	

			
		}
		
	}
	
	
	private void doLogic() {
		
	}



	public static void resizeFonts(int width, int height){
		
		int delta = ((width+height)/2)/80;
		
		MoleculeDrawerPanel.ultra    = new Font("Arial", Font.BOLD, 20 + delta);
		MoleculeDrawerPanel.molecule = new Font("Arial", Font.BOLD, 100 + delta);
		MoleculeDrawerPanel.big      = new Font("Arial", Font.BOLD, 10 + delta);
		MoleculeDrawerPanel.small = new Font("Arial", Font.BOLD,      delta);
		MoleculeDrawerPanel.norm  = new Font("Arial", Font.BOLD, 3 + delta);
		MoleculeDrawerPanel.head  = new Font("Arial", Font.BOLD, 80 + delta);
	}
	
	
	public static double getEuclidanDistance(Line2D l){	
		return Math.sqrt( Math.pow(l.getX1() - l.getX2(), 2)  + Math.pow(l.getY1() - l.getY2(), 2) );
	}



	public static int getScreenWidth() {
		return SCREEN_WIDTH;
	}



	public static void setScreenWidth(int width) {
		MoleculeDrawerPanel.SCREEN_WIDTH = width;
	}



	public static JFrame getFrame() {
		return frame;
	}



	public void setFrame(JFrame frame) {
		MoleculeDrawerPanel.frame = frame;
	}



	public static int getScreenHeight() {
		return SCREEN_HEIGHT;
	}
	
	public static void setScreenHeight(int height) {
		MoleculeDrawerPanel.SCREEN_HEIGHT = height;
	}
	
}
