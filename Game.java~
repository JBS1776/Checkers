import javax.swing.JFrame;


import javax.swing.JOptionPane;


import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.JOptionPane;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.List;
import java.awt.event.*;
import javax.swing.SwingUtilities;

import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.*;

public class Game extends JPanel implements java.io.Serializable{
 private static final long serialVersionUID = 1L;
 static Board board;
 ImageIcon[] blackimages = Constants.blackimages;
 ImageIcon[] whiteimages = Constants.whiteimages;
 Color[] colors = Constants.colors;
 static TileButton previouslySelected = null;
 static Piece enPassant = null;
 static ArrayList<String> moveLog = new ArrayList<String>();
 static int turnCount = 0;
 static int maxTurns = 50;
 static int maxSeconds = Integer.MAX_VALUE;
 static String extraString = "";
 static Color turnColor = Constants.colors[turnCount % 2];
 static boolean currKingCheck = false;
 static boolean castleProcessing = false;
 static int time = Constants.TIME; // 15 * 60
 static int minutes = time / 60;
 static int seconds = time % 60;
 static long delay = time * 1000;
 static boolean gameEnded = false;
 static boolean timeEnabled = false;
 static boolean takeMeEnabled = false;
 Random rand = new Random();
 JLabel label = new JLabel("", JLabel.LEFT);
 JLabel turnLabel = new JLabel("", JLabel.LEFT);
 JLabel turnCountLabel = new JLabel("", JLabel.LEFT);
 public Game(ArrayList<Piece>[] ps, int turnInc) throws InterruptedException{
 Game.time = Constants.TIME;
 Game.minutes = time / 60;
 Game.seconds = time % 60;
 Game.delay = time * 1000;
 label.setBounds(1200, 20, 200, 30);
 turnLabel.setBounds(100, 20, 200, 30);
 turnCountLabel.setBounds(100, 35, 200, 30);
 setLayout(null);
 add(label);
 add(turnLabel);
 add(turnCountLabel);
 turnLabel.setText(((turnCount % 2 == 0) ? "White's" : "Black's") + " turn to move!");
 turnCountLabel.setText("Turns passed: " + turnCount);
 turnCount = turnInc;
 turnColor = Constants.colors[turnCount % 2];
 previouslySelected = null;
 enPassant = null;
 moveLog.clear();
 currKingCheck = false;
 castleProcessing = false;
 board = new Board();
 TileButton[][] tiles = board.tiles;
 if (ps == null)
 board.fillTiles2(Constants.SCREENPOSX, Constants.SCREENPOSY, TestBoards.original());
 else
   board.fillTiles2(Constants.SCREENPOSX, Constants.SCREENPOSY, ps);
 board.setPieces();
 if (!Gamewindow.takeMeChess) {
 board.reducePath(turnColor);
 board.pinnedPieces(turnColor);
 board.checkMate(turnColor);
 }
 this.setBackground(Constants.BACKGROUNDCOL);
 int n = Constants.TILEWIDTH;
 int m = Constants.TILEHEIGHT;
 Game.gameEnded = false;
 Game.timeEnabled = Gamewindow.isEnabled;
 Game.takeMeEnabled = Gamewindow.takeMeChess;
 for (TileButton[] til : tiles) {
  for (TileButton s : til) {
  add(s);
  s.setIcon(s.getTile().getImage());
  TileButton b = s;
  Tile t = s.getTile();
  add(b);
  b.setBounds(t.getX(), t.getY(), n, m);
  b.setOpaque(true);
  b.setBackground(t.getColor());
  b.setIcon(t.getImage());
  b.setFocusable(false);
  if (!Gamewindow.takeMeChess)
  board.kingsButton[turnCount % 2].setBackground(Constants.TURNHIGHLIGHT);
  ActionListener listener = new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               Object source = e.getSource();
               String colorName = "white";
               if (turnCount % 2 == 0) {
         colorName = "white";
               }
               else {
         colorName = "black";
               }
               if (source instanceof TileButton) {
                 // Pauses the game to let player choose a pawn promotion
                 if (Promotion.isEnabled) {
                 JOptionPane.showMessageDialog(null, "Choose a promotion before continuing!", "NO CHEATING!", JOptionPane.ERROR_MESSAGE, (turnCount % 2 == 0) ? Constants.whiteimages[rand.nextInt(Constants.whiteimages.length)] : Constants.blackimages[rand.nextInt(Constants.blackimages.length)]);
               }
                 else {
                TileButton b = ((TileButton)source);
                Tile tile = b.getTile();
                if (tile.getPiece() != null) {
                  if (previouslySelected != null) {
                    previouslySelected.deSelect(previouslySelected.getTile().getPiece().getPath());
                    if (!previouslySelected.equals(b)) {
                      if (tile.getPiece() != null && previouslySelected.getTile().getPiece().getPath().contains(b)) {
                        Piece piece = previouslySelected.getTile().getPiece();
                        Piece q = tile.getPiece();
                        boolean moved = piece.hasMovedYet;
                        board.move(previouslySelected, b);
                        //System.out.println("Piece moved!");
                        board.setPieces();
                        if (tile.getPiece() instanceof King && !Gamewindow.takeMeChess) {
                        board.kingsButton[turnCount % 2].setBackground(board.kingsButton[turnCount % 2].getTile().getColor());
                        board.kingsButton[turnCount % 2] = b;
                        }
                        if (tile.getPiece() instanceof Pawn) {
                          Position pos = b.getTile().getPosition();
                          int x = pos.getX();
                          int y = pos.getY();
                          if (y == 0 || y == 7) {
                            Promotion p = new Promotion(tile.getPiece().getColor(), b);
                            p.setVisible(true);
                            //board.pieces[turnCount % 2].remove(tile.getPiece());
                   }
                 }
                        if (!Gamewindow.takeMeChess)
                        board.kingsButton[turnCount % 2].setBackground(board.kingsButton[turnCount % 2].getTile().getColor());
                        else
                          TileButton.clearPaint();
                        turnCount += 1;
                        turnColor = Constants.colors[turnCount % 2];
                        if (!Gamewindow.takeMeChess) {
                          if (!Promotion.isEnabled) {
                        board.kingsButton[turnCount % 2].setBackground(Constants.TURNHIGHLIGHT);
               if (board.isKingInCheck(turnColor)) {
                 board.kingsButton[turnCount % 2].setBackground(Constants.CHECKHIGHLIGHT);
               }
               board.reducePath(turnColor);
               board.pinnedPieces(turnColor);
                          }
               }
               else
               board.takeMePath(turnColor);
               board.checkMate(turnColor);
               turnLabel.setText(((turnCount % 2 == 0) ? "White's" : "Black's") + " turn to move!");
               turnCountLabel.setText("Turns passed: " + turnCount);
               Game.time = Constants.TIME;
               Game.delay = time * 1000;
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
                      b.select(b.getTile().getPiece().getPath());
                      previouslySelected = b;
                    }
                  } 
                }
                else {
                  if (previouslySelected != null) {
                    Piece p = previouslySelected.getTile().getPiece();
                    previouslySelected.deSelect(p.getPath());
                    if (previouslySelected.getTile().getPiece().getPath().contains(b)) {
                    // For Castling
                      Position posPrev = previouslySelected.getTile().getPosition();
                      Position pos = b.getTile().getPosition();
                      int posDiff = pos.getX() - posPrev.getX();
                      TileButton but1 = null;
                      TileButton but2 = null;
                    if (p instanceof King && !p.hasMovedYet) {
                        if (posDiff == 2 || posDiff == -2) {
                          if (posDiff == 2) {
                            but1 = board.tiles[pos.getY()][pos.getX() + 1];
                            but2 = board.tiles[pos.getY()][pos.getX() - 1];
                            board.move(but1, but2);
                          }
                          if (posDiff == -2) {
                            but1 = board.tiles[pos.getY()][pos.getX() - 2];
                            but2 = board.tiles[pos.getY()][pos.getX() + 1];
                            board.move(but1, but2);
                          }
                          board.setPieces();
                          System.out.println("Castling Complete");
                          board.kingsButton[turnCount % 2].setBackground(board.kingsButton[turnCount % 2].getTile().getColor());
                          board.kingsButton[turnCount % 2] = b;
                        }
                        }
                    boolean hasPieceMovedYet = previouslySelected.getTile().getPiece().hasMovedYet;
                    board.move(previouslySelected, b);
                    board.setPieces();
                    if (tile.getPiece() instanceof King) {
                      if (!Gamewindow.takeMeChess) {
                        board.kingsButton[turnCount % 2].setBackground(board.kingsButton[turnCount % 2].getTile().getColor());
                        board.kingsButton[turnCount % 2] = b;
                      }
                      else
                        TileButton.clearPaint();
                        turnCount += 1;
                        turnColor = Constants.colors[turnCount % 2];
                        if (!Gamewindow.takeMeChess) {
                          if (!Promotion.isEnabled) {
                        board.kingsButton[turnCount % 2].setBackground(Constants.TURNHIGHLIGHT);
               if (board.isKingInCheck(turnColor)) {
                 board.kingsButton[turnCount % 2].setBackground(Constants.CHECKHIGHLIGHT);
               }
               board.reducePath(turnColor);
               board.pinnedPieces(turnColor);
                          }
               }
               else
               board.takeMePath(turnColor);              
               board.checkMate(turnColor);
               turnLabel.setText(((turnCount % 2 == 0) ? "White's" : "Black's") + " turn to move!");
               turnCountLabel.setText("Turns passed: " + turnCount);
               Game.time = Constants.TIME;
               Game.delay = time * 1000;
                    }
                    else {
                      if (tile.getPiece() instanceof Pawn) {
                          pos = tile.getPosition();
                          int x = pos.getX();
                          int y = pos.getY();
                          System.out.println(x + ", " + y);
                          if (y == 0 || y == 7) {
                            Promotion prom = new Promotion(tile.getPiece().getColor(), b);
                            prom.setVisible(true);
                   }
                      }
                      if (!Gamewindow.takeMeChess)
                    board.kingsButton[turnCount % 2].setBackground(board.kingsButton[turnCount % 2].getTile().getColor());
                      else
                        TileButton.clearPaint();
                    turnCount += 1;
                    turnColor = Constants.colors[turnCount % 2];
                    if (!Gamewindow.takeMeChess) {
                      if (!Promotion.isEnabled) {
                    board.kingsButton[turnCount % 2].setBackground(Constants.TURNHIGHLIGHT);
               if (board.isKingInCheck(turnColor)) {
                 board.kingsButton[turnCount % 2].setBackground(Constants.CHECKHIGHLIGHT);
               }
               board.reducePath(turnColor);
               board.pinnedPieces(turnColor);
                      }
                    }
               else
               board.takeMePath(turnColor);
               board.checkMate(turnColor);
               turnLabel.setText(((turnCount % 2 == 0) ? "White's" : "Black's") + " turn to move!");
               turnCountLabel.setText("Turns passed: " + turnCount);
               Game.time = Constants.TIME;
               Game.delay = time * 1000;
                    }
                    previouslySelected = null;
                  }
                }
                 }
               }
               }
 }
  };
  b.addActionListener(listener);
 }
     }
  }
 public void setTime() throws InterruptedException {
   this.minutes = time / 60;
   this.seconds = time % 60;
   if (Game.timeEnabled) {
   if ((minutes < 10 || seconds < 10)) {
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
   }
   if (delay == 0 && Game.timeEnabled) {
   if (!Game.gameEnded) {
   JOptionPane.showMessageDialog(null, "You ran out of time!  " + ((turnCount % 2 == 1) ? "White" : "Black")  + " wins!", "Time up!", JOptionPane.ERROR_MESSAGE, (turnCount % 2 == 1) ? Constants.whiteimages[rand.nextInt(Constants.whiteimages.length)] : Constants.blackimages[rand.nextInt(Constants.blackimages.length)]);
     for (TileButton[] tils : this.board.tiles) {
       for (TileButton t : tils) {
         t.setBackground(t.getTile().getColor());
       }
     }
     if (!Gamewindow.takeMeChess)
     this.board.kingsButton[this.turnCount % 2].setBackground(Constants.TURNHIGHLIGHT);
   for (int i = 0; i < 2; i++) {
     for (Piece p : Game.board.pieces[i]) {
       p.getPath().clear();
       p.getPath().add(Game.board.tiles[p.getPosition().getY()][p.getPosition().getX()]);
     }
   }
   Game.gameEnded = true;
   Gamewindow.timer.stop();
 }
   }
   if (delay > 0) {
   this.time -= 1;
   this.delay -= 1000;
   }
 }
 public static void main(String[] args) {
 }
}