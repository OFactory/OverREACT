package de.OFactory.OverREACT;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.geom.Line2D;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import de.OFactory.OverREACT.Objects.Atom;
import de.OFactory.OverREACT.Objects.Molecule;
import de.OFactory.OverREACT.Objects.Tuple;

public class MoleculeDrawerPanel extends JPanel implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static Molecule curm = new Molecule("Current", new ArrayList<Atom>(),
			new ArrayList<Tuple<Integer, Integer>>());

	private static int SCREEN_WIDTH = 1200;
	private static int SCREEN_HEIGHT = 700;

	public MoleculeDrawerFrame parent;
	
	private static JFrame frame;

	// Schriftarten
	public static Font ultra, big, small, head, norm, molecule;

	// slected
	public static Atom selected;

	// Mausposition
	public static int mausx, mausy;
	public static boolean leftmaus;

	// TESTVARIABLEN
	static Molecule m;

	private long delta, last, fps;

	public static Button start;
	public MoleculeDrawerPanel(MoleculeDrawerFrame root, int w, int h) {
		this.parent = root;
		this.setPreferredSize(new Dimension(w, h));
		this.setBackground(new Color(230, 230, 230));

		doInitializations();

		Thread th = new Thread(this);
		th.start();

	}

	
	
	/** Initialisiert das Spiel
	 */
	private void doInitializations() {

		Panel.resizeFonts(this.getWidth(), this.getHeight());

		// Sachen für "einmalige Gelegenheiten"
		last = System.nanoTime();

	}

	private void computeDelta() {
		// Zeit für jeweils vorherigen Schleifendurchlauf errechnen
		delta = System.nanoTime() - last;
		last = System.nanoTime();
		fps = ((long) 1e9) / delta;

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setFont(MoleculeDrawerPanel.norm);

		g.setColor(Color.RED);
		g.drawString("FPS: " + this.fps, 10, 15);
		g.drawString("NanoTime: " + this.last, 10, 30);
		g.drawString("delta: " + this.delta, 10, 45);
		g.drawString("Maus: " + MoleculeDrawerPanel.mausx + " | " + MoleculeDrawerPanel.mausy, 10, 60);
		g.drawString("MausPressed: " + MoleculeDrawerPanel.leftmaus, 10, 75);
		g.drawString("selected: " + MoleculeDrawerPanel.selected, 10, 90);

		curm.draw(g);

		// TESTBEREICH
		// Panel.m.draw(g);

		g.dispose(); // den ganzen scheiß mal beenden
	}

	@Override
	public void run() {

		System.out.print("TEST");
		
		while (parent.isVisible()) {
			
			
			
			doLogic();

			computeDelta();
			repaint();

			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
			}

		}

	}

	private void doLogic() {

	}

	/** Vergrößert/Verkleinert die Schrift um der Größe des Fensters gerecht zu werden.
	 *  #ItsForTheLooks
	 * @param width  Breite des Fensters
	 * @param height   Höhe des Fensters
	 */
	public static void resizeFonts(int width, int height) {

		int delta = ((width + height) / 2) / 80;

		MoleculeDrawerPanel.ultra = new Font("Arial", Font.BOLD, 20 + delta);
		MoleculeDrawerPanel.molecule = new Font("Arial", Font.BOLD, 100 + delta);
		MoleculeDrawerPanel.big = new Font("Arial", Font.BOLD, 10 + delta);
		MoleculeDrawerPanel.small = new Font("Arial", Font.BOLD, delta);
		MoleculeDrawerPanel.norm = new Font("Arial", Font.BOLD, 3 + delta);
		MoleculeDrawerPanel.head = new Font("Arial", Font.BOLD, 80 + delta);
	}

	public static double getEuclidanDistance(Line2D l) {
		return Math.sqrt(Math.pow(l.getX1() - l.getX2(), 2) + Math.pow(l.getY1() - l.getY2(), 2));
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
