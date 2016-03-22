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
import de.OFactory.OverREACT.Objects.Tuple;

public class Panel extends JPanel implements Runnable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private static int SCREEN_WIDTH = 1200;
	private static int SCREEN_HEIGHT = 700;

	private static JFrame frame;
	
	//Schriftarten
	public static Font ultra, big, small, head, norm, molecule; 
	
	//Mausposition
	public static int mausx, mausy;
	public static boolean leftmaus; 
	
	PanelListener pl = new PanelListener();
	
	//TESTVARIABLEN
	static Molecule m;
	
	private long delta, last, fps;
	
	
	public static Button start;
	
	public static void main(String[] args){
		new Panel(getScreenWidth(), getScreenHeight());
		
		
		// TEST AREA INCOMING | WARNING | DO NOT TOUCH
		
		Atom a = new Atom(Elements.KOHLENSTOFF);
		System.out.println(a.getElement().getName());
		System.out.println(a.getElement().getSymbol());
		System.out.println(a.getElectronAmount());
		System.out.println(a.getElectronBinds());
		
		
		
		Panel.m = new Molecule("Wasser",
				new ArrayList<Atom>(Arrays.asList(new Atom(Elements.WASSERSTOFF), new Atom(Elements.WASSERSTOFF), new Atom(Elements.SAUERSTOFF))),
				new ArrayList<Tuple<Integer, Integer>>(Arrays.asList(new Tuple<Integer, Integer>(0, 2), new Tuple<Integer, Integer>(1, 2) )));
		
		
		
		
		// TEST AREA TAIL -.-----**--..--**--
		
	}

	
	
	public Panel(int w, int h){
		this.setPreferredSize(new Dimension(w, h));
		this.setBackground(new Color(230, 230, 230));
		
		// Fenster wird erstellt
		setFrame(new JFrame("Substitution - Eine typische Reaktion der Alkane | OFactory© "));
		//frame.setResizable(false);
		getFrame().setLocation(100,100);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().addComponentListener(pl);		
		getFrame().addMouseMotionListener(pl);
		getFrame().add(this);
		getFrame().pack();
		getFrame().setVisible(true);

		
		doInitializations();
		
		Thread th = new Thread(this);
		th.start();
	}

	private void doInitializations() {
		
		
		//Sachen für "einmalige Gelegenheiten"
		last = System.nanoTime();
		
		start = new Button(0, (int) (getScreenWidth()*0.7 - getScreenWidth()/7), (int) (getScreenHeight()*0.8 - getScreenHeight()/14), getScreenWidth()/3, getScreenHeight()/7, "Start");
		
	}

	private void computeDelta() {
		//Zeit für jeweils vorherigen Schleifendurchlauf errechnen
		delta = System.nanoTime() - last;
		last = System.nanoTime();
		fps = ((long) 1e9)/delta;
		
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		g.setFont(Panel.norm);
		
		g.setColor(Color.RED);
		g.drawString("FPS: " + this.fps, 10, 15);
		g.drawString("NanoTime: " + this.last, 10, 30);
		g.drawString("delta: " + this.delta, 10, 45);
		g.drawString("Maus: " + Panel.mausx + " | " + Panel.mausy, 10, 60);
		g.drawString("MausPressed: " + Panel.leftmaus, 10, 75);
		
		g.setColor(Color.black);
		//drawCenteredString(g, "Substitution", new Rectangle(0, getScreenHeight()/8, getScreenWidth(), getScreenHeight()), Panel.head);
		g.setColor(new Color(100, 100, 100));
		//drawCenteredString(g, "Eine typische Reaktion der Alkane", new Rectangle(0, getScreenHeight()/2, getScreenWidth(), getScreenHeight()/4), Panel.ultra);
		drawCenteredString(g, "OFactory", new Rectangle((int) (getScreenWidth()*0.75), 0, getScreenWidth()/4, getScreenHeight()/6), Panel.big);
		
		//start.draw(g);
		
		
		 //TESTBEREICH
		Panel.m.draw(g);
		
		
		g.dispose(); // den ganzen scheiß mal beenden
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
		
		
		start.update(Panel.mausx, Panel.mausy, Panel.leftmaus);
		start.setX(   (int) (getScreenWidth()*0.7 - getScreenWidth()/7)    );
		start.setY(   (int) (getScreenHeight()*0.8 - getScreenHeight()/14) );
		start.setWidth(      getScreenWidth()/3                        );
		start.setHeight(     getScreenHeight()/7                       );
		
	}



	public static void resizeFonts(int width, int height){
		
		int delta = ((width+height)/2)/80;
		
		Panel.ultra    = new Font("Arial", Font.BOLD, 20 + delta);
		Panel.molecule = new Font("Arial", Font.BOLD, 100 + delta);
		Panel.big      = new Font("Arial", Font.BOLD, 10 + delta);
		Panel.small = new Font("Arial", Font.BOLD,      delta);
		Panel.norm  = new Font("Arial", Font.BOLD, 3 + delta);
		Panel.head  = new Font("Arial", Font.BOLD, 80 + delta);
	}
	
	/**
	 * Zeichnet einen String in dem Angebebenem Rechteck!
	 *
	 * @param g Die Grafik-Instanz
	 * @param text Den zu zeichnenden String
	 * @param rect Das Rechteck in dem der String gezeichnet werden soll
	 */
	public static void drawCenteredString(Graphics g, String text, Rectangle rect, Font font) {
	    // FontMetrics gönnen #GönnungMussSein
	    FontMetrics metrics = g.getFontMetrics(font);

	    int x = (rect.width - metrics.stringWidth(text)) / 2;
	    int y = ((rect.height - metrics.getHeight()) / 2) - metrics.getAscent();

	    
	    g.setFont(font);
	    g.drawString(text, rect.x + x,  rect.y + y);
	}
	
	/**
	 * Zeichnet einen String Symmetrisch zum angegebenem Punkt
	 *
	 * @param g Die Grafik-Instanz
	 * @param text Den zu zeichnenden String
	 * @param x x-Koordinate
	 * @param y y-Koordinate
	 */
	public static void drawCenteredString(Graphics g, String text, int x, int y, Font font){
		// FontMetrics gönnen #GönnungMussSein
	    FontMetrics metrics = g.getFontMetrics(font);
	    
	    int newx = x - (metrics.stringWidth(text)/2);
	    int newy = y + (metrics.getHeight()/3);
		
	    g.setFont(font);
	    g.drawString(text, newx, newy);
	}
	
	public static void shortenLine(Line2D l, double shortfactor){
		
		// B + ( A - B ) * t
		
		
		l.setLine(l.getX1() + ( l.getX2() - l.getX1() )*shortfactor,
				  l.getY1() + ( l.getY2() - l.getY1() )*shortfactor,
				  l.getX2() + ( l.getX1() - l.getX2() )*shortfactor,
				  l.getY2() + ( l.getY1() - l.getY2() )*shortfactor);
		
		
	}
	
	public static double getEuclidanDistance(Line2D l){	
		return Math.sqrt( Math.pow(l.getX1() - l.getX2(), 2)  + Math.pow(l.getY1() - l.getY2(), 2) );
	}



	public static int getScreenWidth() {
		return SCREEN_WIDTH;
	}



	public static void setScreenWidth(int width) {
		Panel.SCREEN_WIDTH = width;
	}



	public static JFrame getFrame() {
		return frame;
	}



	public void setFrame(JFrame frame) {
		Panel.frame = frame;
	}



	public static int getScreenHeight() {
		return SCREEN_HEIGHT;
	}
	
	public static void setScreenHeight(int height) {
		Panel.SCREEN_HEIGHT = height;
	}
	
}
