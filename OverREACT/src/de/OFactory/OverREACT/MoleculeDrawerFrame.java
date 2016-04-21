package de.OFactory.OverREACT;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MoleculeDrawerFrame extends JFrame {

	/**
	 *  Default Serial Scheiß
	 */
	private static final long serialVersionUID = 1L;
	
	public static final int DRAW_WIDTH  = 800;
	public static final int DRAW_HEIGHT = 600;
	
	public static final int SCREEN_WIDTH = 1000;
	public static final int SCREEN_HEIGHT = 800;
	
	private static JPanel drawarea;
	public static MoleculeDrawerPanelListener pl = new MoleculeDrawerPanelListener();
	
	public MoleculeDrawerFrame(String name, int w, int h) {
		super(name);
		
		drawarea = new MoleculeDrawerPanel(DRAW_WIDTH, DRAW_HEIGHT);
		
		this.setLocation(100, 100);
		this.setPreferredSize(new Dimension(w, h));
		this.addComponentListener(pl);
		this.addMouseMotionListener(pl);
		this.addMouseListener(pl);
		this.addKeyListener(pl);
		this.add(drawarea);
		this.pack();
		this.setVisible(true);

		try {
			UIManager.setLookAndFeel(Panel.getLookAndFeelClassName("Windows"));
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		doInitializations();
	}
	
	private void doInitializations(){
		setUpMenuBar();
	}
	
	
	
	private void setUpMenuBar() {
		// Menubar am StiZZel
		JMenuBar menubar = new JMenuBar();

		JMenu menu = new JMenu("Datei");
		menu.setMnemonic(KeyEvent.VK_A);
		menu.getAccessibleContext().setAccessibleDescription("Dateien verwalten und speichern");
		menubar.add(menu);

		createMenuItem(menu, "Öffen", "open", KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		createMenuItem(menu, "Speichern", "Save", KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		createMenuItem(menu, "Speichern als...", "Save as");
		createMenuItem(menu, "Exportieren", "Export");
		createMenuItem(menu, "Neues Molekül", "new");

		JMenu edit = new JMenu("Bearbeiten");
		edit.setMnemonic(KeyEvent.VK_E);
		edit.getAccessibleContext().setAccessibleDescription("Dateien verwalten und speichern");
		menubar.add(edit);

		this.setJMenuBar(menubar);
	}

	


	public static void main(String[] args){
		new MoleculeDrawerFrame("Moleküle Zeichnen |     OFactory", SCREEN_HEIGHT, SCREEN_WIDTH);
		
		// TEST AREA INCOMING | WARNING | DO NOT TOUCH

		// TEST AREA TAIL -.-----**--..--**--
		
	}

	
	public static JPanel getPanel() {
		return drawarea;
	}

	public static void setPanel(JPanel drawarea) {
		MoleculeDrawerFrame.drawarea = drawarea;
	}
	
	/** Erstellt ein neues JMenuItem aus angebenen Werten  
	 * @param m JMenu, in dem das JMenuItem eingefügt werden soll
	 * @param text String : Text des MenuItems
	 * @param cmd  String : Befehl des MenuItems auf den der Listener reaggieren soll
	 */
	private void createMenuItem(JMenu m, String text, String cmd) {
		JMenuItem item = new JMenuItem(text);
		item.addActionListener(pl);
		item.setActionCommand(cmd);
		m.add(item);
	}
	
	/** Erstellt ein neues JMenuItem aus angebenen Werten  
	 * @param m JMenu, in dem das JMenuItem eingefügt werden soll
	 * @param text String : Text des MenuItems
	 * @param cmd  String : Befehl des MenuItems auf den der Listener reaggieren soll
	 * @param ks   Keystroke : Tastenkombi für das Ausführen des Befehls
	 */
	private void createMenuItem(JMenu m, String text, String cmd, KeyStroke ks) {
		JMenuItem item = new JMenuItem(text);
		item.addActionListener(pl);
		item.setActionCommand(cmd);
		item.setAccelerator(ks);
		m.add(item);
	}
	

}
