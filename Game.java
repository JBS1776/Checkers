import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Game extends JPanel implements java.io.Serializable{
 private static final long serialVersionUID = 1L;
 
 
 private Board board;
 private Tile previouslySelected;
 private String[] pieceDirs = new String[12];
 private ArrayList<Tile> takeRed = new ArrayList<Tile>();
 private ArrayList<Tile> takeCyan = new ArrayList<Tile>();
 private ArrayList<String> moveList = new ArrayList<String>();
 private ArrayList<LinkedList<Piece>> capturedpieces = new ArrayList<LinkedList<Piece>>();
 private int turnCount; // different save
 private int maxSeconds = Integer.MAX_VALUE;
 private Color turnColor = Constants.colors[this.getTurnCount() & 1];
 private int time = Constants.TIME; // 15 * 60 = 900
 private int minutes;
 private int seconds;
 private boolean gameEnded; // different save
 private boolean timeEnabled; // different save
 private boolean takeMeEnabled; // different save
 private JTextField label = new JTextField("", JLabel.LEFT);
 private JTextField turnLabel = new JTextField("", JLabel.LEFT);
 private JTextField turnCountLabel = new JTextField("", JLabel.LEFT);
 private int pieceAppearance;
 private int ailevel;
 private int aiColor;
 private Computerplayer cp;
 public Game(ArrayList<Piece>[] ps, String[] pieceDirs, int turnInc, boolean endGame, boolean timeEnable, int newTime, int pieceAppearance, int ailevel, int aiColor, ArrayList<LinkedList<Piece>> caps, ArrayList<String> movs, Gamewindow gw) throws InterruptedException {
	 // this.capturedpieces and this.moveList always starts as empty list
	 if (caps == null) {
		 caps = this.capturedpieces;
		 // 6 pieces per color
 for (int i = 0; i < 12; i++) {
	 this.capturedpieces.add(new LinkedList<Piece>());
 }
	 }
	 else
		 this.capturedpieces.addAll(caps);
	 if (movs == null)
		 movs = this.moveList;
	 else
		 this.moveList.addAll(movs);
 cp = new Computerplayer();
 pieceDirs = this.pieceDirs;
 this.turnCount = turnInc;
 this.gameEnded = endGame;
 this.timeEnabled = timeEnable;
 this.setTime(newTime);
 label.setBounds(1200, 20, 200, 30);
 label.setEditable(false);
 label.setBackground(null);
 label.setBorder(null);
 label.setFont(new Font(label.getText(), Font.BOLD, label.getFont().getSize()));
 turnLabel.setBounds(100, 20, 200, 30);
 turnLabel.setEditable(false);
 turnLabel.setBackground(null);
 turnLabel.setBorder(null);
 turnLabel.setFont(new Font(turnLabel.getText(), Font.BOLD, turnLabel.getFont().getSize()));
 turnCountLabel.setBounds(100, 40, 200, 30);
 turnCountLabel.setEditable(false);
 turnCountLabel.setBackground(null);
 turnCountLabel.setBorder(null);
 turnCountLabel.setFont(new Font(turnCountLabel.getText(), Font.BOLD, turnCountLabel.getFont().getSize()));
 setLayout(null);
 add(label);
 add(turnLabel);
 add(turnCountLabel);
 turnLabel.setText((((turnCount & 1) == 0) ? "Red's" : "Black's") + " turn to move!");
 turnCountLabel.setText("Turns passed: " + turnCount);
 this.turnColor = Constants.colors[turnCount & 1];
 this.previouslySelected = null;
 this.pieceAppearance = pieceAppearance;
 this.ailevel = ailevel;
 this.aiColor = aiColor;
 board = new Board();
 if (ps == null)
 board.fillTiles(Constants.SCREENPOSX, Constants.SCREENPOSY, this.pieceAppearance);
 else
   board.fillTiles2(Constants.SCREENPOSX, Constants.SCREENPOSY, this.pieceAppearance, ps);
 board.setPieces(this);
 this.setBackground(Constants.BACKGROUNDCOL);
 this.setGameEnded(false);
 Game g = this;
 JButton button = new JButton("Moves");
 button.setBounds(1100, 30, 75, 30);
 button.addActionListener(new ActionListener() {
 	@Override
 	public void actionPerformed(ActionEvent e) {
 		JFrame fr = new JFrame("Move list");
 		fr.add(new JScrollPane(new JList<Object>(g.moveList.toArray())));
 		fr.setSize(500, 500);
 		fr.setVisible(true);
 		fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
 		gw.setEnabled(false);
 		fr.addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {
			}

			@Override
			public void windowClosing(WindowEvent e) {
				fr.dispose();
				gw.setEnabled(true);
			}

			@Override
			public void windowClosed(WindowEvent e) {
			}

			@Override
			public void windowIconified(WindowEvent e) {
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
			}

			@Override
			public void windowActivated(WindowEvent e) {
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
			}
 			
 		});
 	}
 });
 this.add(button);
 for (Tile[] til : board.getTiles()) {
  for (Tile s : til) {
  add(s);
  s.setBounds(s.getX(), s.getY(), Constants.TILEWIDTH, Constants.TILEHEIGHT);
  s.setOpaque(true);
  s.setBackground(s.getColor());
  s.setFocusable(false);
  ActionListener listener = new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               Object source = e.getSource();
               if (source instanceof Tile) {
                Tile b = ((Tile)source);
                //System.out.println(b.getPiece().getName());
                if (ailevel > 0 && !g.getGameEnded()) {
                	if (ailevel >= 3 || (turnCount & 1) == aiColor) {
                		if (ailevel == 1 || ailevel == 3)
                			cp = cp.cpuMoveEasy(g, Constants.colors[turnCount & 1]);
                		else
                			cp = cp.cpuMoveHard(g, Constants.colors[turnCount & 1]);
                	Piece randPiece = cp.getPiece();
                	previouslySelected = cp.getTile();
                	b = randPiece.getRandTile();
                	}
                }
                Tile tile = b;
                if (tile.getPiece() != null) {
                  if (previouslySelected != null) {
                    previouslySelected.deSelect(previouslySelected.getPiece().getPath(), g);
                    if (!previouslySelected.equals(b)) {
                      if (tile.getPiece() != null && previouslySelected.getPiece().getPath().contains(b)) {
                        board.move(previouslySelected, b, g);
                        board.setPieces(g);
                        if (tile.getPiece() instanceof Peasant) {
                          Position pos = b.getPosition();
                          int y = pos.getY();
                          if (y == 0 || y == 7) {
                        	  tile.setImage(Constants.images[(turnCount + 1) & 1][1]);
                        	  King king = new King(tile.getPiece().getId(), tile.getPiece().getColor(), tile.getPosition(), tile.getImage());
                        	  tile.setPiece(king);
                          }
                        }
                        turnCount += 1;
                        turnColor = Constants.colors[turnCount & 1];
               turnLabel.setText((((turnCount & 1) == 0) ? "Red's" : "Black's") + " turn to move!");
               turnCountLabel.setText("Turns passed: " + turnCount);
               g.setTime(Constants.TIME);
               previouslySelected = null;
                      }
                      else {
                        if (tile.getPiece().getColor().equals(turnColor)) {
                        	b.select(tile.getPiece().getPath());
                        	previouslySelected = b;
                        }
                        else {
                          previouslySelected = null;
                        }
                      }
                    }
                    else {
                      previouslySelected = null;
                    }
                  }
                  else {
                    if (tile.getPiece().getColor().equals(turnColor)) {
                      b.select(b.getPiece().getPath());
                      previouslySelected = b;
                    }
                  } 
                }
                else {
                  if (previouslySelected != null) {
                    Piece p = previouslySelected.getPiece();
                    previouslySelected.deSelect(p.getPath(), g);
                    if (previouslySelected.getPiece().getPath().contains(b)) {
                      Position pos = b.getPosition();
                    board.move(previouslySelected, b, g);
                    g.moveList.set(g.moveList.size() - 1, g.moveList.get(g.moveList.size() - 1));
                    board.setPieces(g);
                    if (tile.getPiece() instanceof King) {
                        turnCount += 1;
                        turnColor = Constants.colors[turnCount & 1];
               turnLabel.setText((((turnCount & 1) == 0) ? "Red's" : "Black's") + " turn to move!");
               turnCountLabel.setText("Turns passed: " + turnCount);
               g.setTime(Constants.TIME);
                    }
                    else {
                      if (tile.getPiece() instanceof Peasant) {
                          pos = tile.getPosition();
                          int y = pos.getY();
                          if (y == 0 || y == 7) {
                        	  tile.setImage(Constants.images[(turnCount + 1) & 1][1]);
                        	  King king = new King(tile.getPiece().getId(), tile.getPiece().getColor(), tile.getPosition(), tile.getImage());
                        	  g.getBoard().getPieces()[(turnCount + 1) & 1].remove(tile.getPiece());
                        	  tile.setPiece(king);
                        	  g.getBoard().getPieces()[(turnCount + 1) & 1].add(tile.getPiece());
                        	  g.getBoard().setPieces(g);
                          }
                      }
                    turnCount += 1;
                    turnColor = Constants.colors[turnCount & 1];
               turnLabel.setText((((turnCount & 1) == 0) ? "Red's" : "Black's") + " turn to move!");
               turnCountLabel.setText("Turns passed: " + turnCount);
               g.setTime(Constants.TIME);
                    }
                    previouslySelected = null;
                  }
                    else {
                      // Fixes a glitch where piece can move when it is deselected
                      previouslySelected = null;
                    }
                }
                 }
               }
 }
  };
  s.addActionListener(listener);
 }
     }
  }
 void setGameTimer() throws InterruptedException {
	   if (this.getTimeEnabled()) {
		   this.minutes = time / 60;
		   this.seconds = time % 60;
	   if (minutes < 10 || seconds < 10) {
	     if (minutes < 10 && seconds < 10) {
	       label.setText("0" + minutes + ":0" + seconds);
	     }
	     else {
	       if (minutes < 10)
	         label.setText("0" + minutes + ":" + seconds);
	       if (seconds < 10)
	         label.setText(minutes + ":0" + seconds);
	     }
	   }
	   else {
	 label.setText(minutes + ":" + seconds);
	   }
	   // Now you can't cheat by running the clock for the AI!!
	   if (this.time >= 0 && (((turnCount & 1) != aiColor && this.ailevel < 3) || this.ailevel == 0))  {
		   if (this.time == 0) {
			   if (!this.getGameEnded()) {
				   JOptionPane.showMessageDialog(null, "You ran out of time!  " + (((turnCount & 1) == 1) ? "White" : "Black")  + " wins!", "Time up!", JOptionPane.ERROR_MESSAGE, null);
				   for (Tile[] tils : this.board.getTiles()) {
					   for (Tile t : tils) {
						   t.setBackground(t.getColor());
					   }
				   }
				   for (int i = 0; i < 2; i++) {
					   for (Piece p : this.board.getPieces()[i]) {
						   p.getPath().clear();
						   p.getPath().add(this.board.getTiles()[p.getPosition().getY()][p.getPosition().getX()]);
					   }
				   }
				   this.setGameEnded(true);
			   }
		   }
		   else {
			   this.time -= 1;
		   }
	   	}
	 }
 }
  public int getTurnCount() {
   return this.turnCount;
 }
  public ArrayList<Tile> getTakeCyan() {
	  return this.takeCyan;
  }
  public void setTakeCyan(ArrayList<Tile> t) {
	  this.takeCyan = t;
  }
  public Color getTurnColor() {
    return this.turnColor;
  }
  public Board getBoard() {
    return this.board;
  }
  public String[] getPieceDirs() {
	  return this.pieceDirs;
  }
  public void setPieceDirs(String[] dirs) {
	  this.pieceDirs = dirs;
  }
  public ArrayList<LinkedList<Piece>> getCapturedPieces() {
	  return this.capturedpieces;
  }
  public void setCapturedPieces(ArrayList<LinkedList<Piece>> val) {
	  this.capturedpieces = val;
  }
  public ArrayList<Tile> getTakeRed() {
	  return this.takeRed;
  }
  public void setTakeRed(ArrayList<Tile> val) {
	  this.takeRed = val;
  }
  public ArrayList<String> getMoveList() {
	  return this.moveList;
  }
  public void setMoveList(ArrayList<String> val) {
	  this.moveList = val;
  }
  public int getMaxSeconds() {
    return this.maxSeconds;
  }
  public void setMaxSeconds(int val) {
    this.maxSeconds = val;
  }
  public int getTime() {
    return this.time;
  }
  public void setTime(int val) {
    this.time = val;
  }
  public boolean getGameEnded() {
    return this.gameEnded;
  }
  public void setGameEnded(boolean val) {
    this.gameEnded = val;
  }
  public boolean getTimeEnabled() {
    return this.timeEnabled;
  }
  public void setTimeEnabled(boolean val) {
    this.timeEnabled = val;
  }
  public boolean getTakeMeEnabled() {
    return this.takeMeEnabled;
  }
  public void setTakeMeEnabled(boolean val) {
    this.takeMeEnabled = val;
  }
  public int getSetting() {
	  return this.pieceAppearance;
  }
  public void setSetting(int val) {
	  this.pieceAppearance = val;
  }
  public int getAilevel() {
	  return this.ailevel;
  }
  public void setAilevel(int val) {
	  this.ailevel = val;
  }
  public int getAiColor() {
	  return this.aiColor;
  }
  public void setAiColor(int val) {
	  this.aiColor = val;
  }
  public JTextField getLabel() {
	  return this.label;
  }
  public JTextField getTurnLabel() {
	  return this.turnLabel;
  }
  public JTextField getTurnCountLabel() {
	  return this.turnCountLabel;
  }
}