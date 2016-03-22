package de.OFactory.OverREACT;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import de.OFactory.OverREACT.Objects.Element;
import de.OFactory.OverREACT.Objects.Elements;

public class Panel extends JPanel implements Runnable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private static int SCREEN_WIDTH = 1200;
	private static int SCREEN_HEIGHT = 700;

	private static JFrame frame;
	
	//Schriftarten
	public static Font ultra, big, small, head, norm; 
	
	//Mausposition
	public static int mausx, mausy;
	public static boolean leftmaus; 
	
	PanelListener pl = new PanelListener();
	
	
	
	private long delta, last, fps;
	
	
	public static Button start;
	
	public static void main(String[] args){
		new Panel(getScreenWidth(), getScreenHeight());
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
		
		System.out.println(Elements.WASSERSTOFF.getSymbol());
		
		
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
		drawCenteredString(g, "Substitution", new Rectangle(0, getScreenHeight()/8, getScreenWidth(), getScreenHeight()), Panel.head);
		g.setColor(new Color(100, 100, 100));
		drawCenteredString(g, "Eine typische Reaktion der Alkane", new Rectangle(0, getScreenHeight()/2, getScreenWidth(), getScreenHeight()/4), Panel.ultra);
		drawCenteredString(g, "OFactory", new Rectangle((int) (getScreenWidth()*0.75), 0, getScreenWidth()/4, getScreenHeight()/6), Panel.big);
		
		start.draw(g);
		
		
		g.dispose();
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
		
		Panel.ultra = new Font("Arial", Font.BOLD, 20 + delta);
		Panel.big   = new Font("Arial", Font.BOLD, 10 + delta);
		Panel.small = new Font("Arial", Font.BOLD,      delta);
		Panel.norm  = new Font("Arial", Font.BOLD, 3 + delta);
		Panel.head  = new Font("Arial", Font.BOLD, 80 + delta);
	}
	
	/**
	 * Zeichnet einen String in dem Angebebenem Rechteck!
	 *
	 * @param g Die Graphik-Instanz
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
