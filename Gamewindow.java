import java.awt.*;



import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.Timer;
public class Gamewindow extends JFrame implements Runnable, java.io.Serializable{
  private Gamewindow frame;
  private Game game;
  private static Timer timer = null;
  private static boolean isEnabled = false;
  private ButtonGroup group = new ButtonGroup();
  public Gamewindow(ArrayList<Piece>[] start, String[] pieceDirs, int turns, boolean endGame, boolean timeEnd, 
		  int time, int pieceLook, int ailevel, int aiColor, ArrayList<LinkedList<Piece>> caps, ArrayList<String> moves) {
	  try {
		  timer = new Timer(1000, new ActionListener() {
			  public void actionPerformed(ActionEvent e) {
				  try {
					  game.setGameTimer();
				  }
				  catch (InterruptedException ex) {
					  ex.printStackTrace();
				  }
			  }
      });
    game = new Game(start, pieceDirs, turns, endGame, timeEnd, time, pieceLook, ailevel, aiColor, caps, moves, this);
    this.initializeMenu(game);
    this.add(game);
    this.setVisible(true);
    this.setSize(new Dimension(Constants.FULLSCREENWIDTH, Constants.FULLSCREENHEIGHT));
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    timer.start();
	  }
	  catch(InterruptedException e) {
		  e.printStackTrace();
	  }
  }
 public void initializeMenu(Game g) {
 JMenuBar menu = new JMenuBar();
 JMenu menu1 = new JMenu("File");
 JMenu menu2 = new JMenu("Settings");
 JMenu menu3 = new JMenu("Instructions");
 JMenuItem stuff = new JMenuItem("Who reads them these days?");
 JMenuItem save = new JMenuItem("save: It's always good to save");
 JMenuItem open = new JMenuItem("open: Load a saved game");
 JMenuItem reset = new JMenuItem("surrender ONLY LOSERS SURRENDER!!");
 JMenuItem appearance = new JMenuItem("Change appearance");
 JMenuItem setTime = new JMenuItem("Change rules");
 menu1.add(open);
 menu1.add(save);
 menu1.add(reset);
 menu2.add(appearance);
 menu2.add(setTime);
 menu3.add(stuff);
 menu.add(menu1);
 menu.add(menu2);
 menu.add(menu3);
 save.addActionListener(new ActionListener() {
   @Override
   public void actionPerformed(ActionEvent e) {
     newSavedGame(g);
   }
 });
 setTime.addActionListener(new ActionListener() {
  @Override
  public void actionPerformed(ActionEvent e) {
    JFrame frame = new JFrame("Frame");
    int multiplyer = 10;
    int index = 0;
    frame.setLayout(null);
    frame.setResizable(false);
    JCheckBox enableTime = new JCheckBox("Enable time", Gamewindow.isEnabled);
    enableTime.setBounds(0, 10, 500, 20);
    frame.add(enableTime);
    Gamewindow.isEnabled = enableTime.isSelected();
    boolean oldEnabled = Gamewindow.isEnabled;
    enableTime.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e) {
        Gamewindow.isEnabled = enableTime.isSelected();
      }
    });
    JButton cancel = new JButton("Cancel");
    cancel.setBounds(200, 350, 100, 20);
    cancel.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        //Gamewindow.takeMeChess = oldTakeMe;
        Gamewindow.isEnabled = oldEnabled;
        frame.dispose();
      }
    });
    frame.add(cancel);
    JButton apply = new JButton("Apply");
    frame.add(apply);
    apply.setBounds(350, 350, 100, 20);
    apply.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        frame.dispose();
        newGame(g);
   }
  });
    JLabel label = new JLabel();
    label.setText("Hitting Apply will start a new game with the applied settings.");
    label.setBounds(20, 200, 400, 20);
    JLabel label2 = new JLabel();
    label2.setText("Hitting Cancel will revert to default settings.");
    label2.setBounds(20, 230, 400, 20);
    JLabel label3 = new JLabel();
    label3.setText("When time is enabled, 15 minutes are alloted for each move.");
    label3.setBounds(20, 35, 400, 10);
  frame.add(label);
  frame.add(label2);
  frame.add(label3);
  frame.setSize(500, 400);
  frame.setVisible(true);
  frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
  }
 });
 appearance.addActionListener(new ActionListener() {
   @Override
   public void actionPerformed(ActionEvent e) {
     Color color=JColorChooser.showDialog(game,"Select a color",Constants.BACKGROUNDCOL);
     game.setBackground(color);
   }
 });
 reset.addActionListener(new ActionListener() {
   @Override
   public void actionPerformed(ActionEvent e) {
     newGame(g);
   }
 });
  this.setJMenuBar(menu);
  }
 @Override
 public void run() {

 }
 public void newSavedGame(Game g) {
   g.setTime(g.getTime());
   dispose();
     try {
   //System.setProperty("apple.laf.useScreenMenuBar", "true");
   //System.setProperty("com.apple.mrj.application.apple.menu.about.name", "WikiTeX");
   UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
      //UIManager.setLookAndFeel(new javax.swing.plaf.metal.MetalLookAndFeel());
  } catch (Exception ex) {
      System.err.println("Cannot set LookAndFeel");
  }
  setImages(g);
  SwingUtilities.invokeLater(new Gamewindow(Constants.STARTCONFIG, new String[12], Constants.STARTTURNCOUNT, Constants.isKingInCheck, 
  		  Constants.isTimeEnabled, 
  		  Constants.TIME, Constants.PieceAppearance, 
  		  Constants.aiLevel, Constants.aiColor, Constants.CAPTUREDPIECES, 
  		  Constants.MOVELIST));
 }
 private void setImages(Game g) {
	 for (int i = 0; i < 2; i++) {
		 for (Piece p : g.getBoard().getPieces()[i]) {
			 int val = 0;
			 Color c = p.getColor();
			 if (p instanceof Peasant) {
				 val = 0;
			 }
			 if (p instanceof King) {
				 val = 1;
			 }
			 ImageIcon set = null;
			 if (g.getSetting() < 3) {
				 set = new ImageIcon(Constants.names[g.getSetting()][val], p.getName());
			 }
			 else {
				 //String[] names = g.getPieceDirs();
				 boolean found = false;
				 for (String s : g.getPieceDirs()) {
					 if (s.contains(p.getName())) {
						 set = new ImageIcon(s, p.getName());
						 found = true;
						 break;
					 }
				 }
				 // Load first default config. if images are not found
				 if (!found) {
					 g.setSetting(0);
					 set = new ImageIcon(Constants.names[g.getSetting()][val], p.getName());
				 }
				 //set = new ImageIcon(Constants.customFiles[c.equals(Color.black) ? val : val + 6], p.getName());
			 }
			 p.setImage(set);
		 }
	 }
	 for (Tile[] tils : g.getBoard().getTiles()) {
		 for (Tile tb : tils) {
			 if (tb.getPiece() != null) {
				 tb.setImage(tb.getPiece().getImage());
				 tb.setIcon(tb.getImage());
			 }
		 }
	 }
	 this.setSelectedButton(this.game);
 }
 private void setSelectedButton(Game g) {
	 int index = 0;
	 this.group.clearSelection();
	 Enumeration<AbstractButton> buttons = this.group.getElements();
	 while (buttons.hasMoreElements()) {
		 AbstractButton but = buttons.nextElement();
		 if (index == g.getSetting()) {
			 group.setSelected(but.getModel(), true);
		 }
		 index++;
	 }
 }
 public void newGame(Game g) {
   Gamewindow.timer.stop();
   dispose();
     try {
   //System.setProperty("apple.laf.useScreenMenuBar", "true");
   //System.setProperty("com.apple.mrj.application.apple.menu.about.name", "WikiTeX");
   UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
      //UIManager.setLookAndFeel(new javax.swing.plaf.metal.MetalLookAndFeel());
  } catch (Exception ex) {
      System.err.println("Cannot set LookAndFeel");
  }
  SwingUtilities.invokeLater(new Gamewindow(Constants.STARTCONFIG, new String[12], Constants.STARTTURNCOUNT, 
  		  Constants.isEndGame, 
  		  Constants.isTimeEnabled, 
  		  Constants.TIME, Constants.PieceAppearance, 
  		  Constants.aiLevel, Constants.aiColor, Constants.CAPTUREDPIECES, 
  		  Constants.MOVELIST));
 }
  public static void main(String[] args) {
    try {
   //System.setProperty("apple.laf.useScreenMenuBar", "true");
   //System.setProperty("com.apple.mrj.application.apple.menu.about.name", "WikiTeX");
   UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
      //UIManager.setLookAndFeel(new javax.swing.plaf.metal.MetalLookAndFeel());
  } catch (Exception ex) {
      System.err.println("Cannot set LookAndFeel");
  }
    SwingUtilities.invokeLater(new Gamewindow(Constants.STARTCONFIG, new String[12], Constants.STARTTURNCOUNT, 
  		  Constants.isEndGame, 
  		  Constants.isTimeEnabled, 
  		  Constants.TIME, Constants.PieceAppearance, 
  		  Constants.aiLevel, Constants.aiColor, Constants.CAPTUREDPIECES, 
  		  Constants.MOVELIST));
  }
}
