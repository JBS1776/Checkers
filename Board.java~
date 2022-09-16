import javax.swing.JFrame;


import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.JOptionPane;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.*;
import javax.swing.SwingUtilities;

import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.*;
import java.util.List;
public class Board implements java.io.Serializable{
static boolean neededRemoval = false;
Random rand = new Random();
ArrayList<Piece>[] pieces = new ArrayList[2];
ArrayList<Piece> blackPieces = new ArrayList<Piece>();
ArrayList<Piece> whitePieces = new ArrayList<Piece>();
ArrayList<Piece> causedCheck = new ArrayList<Piece>();
static HashMap<Piece, ArrayList<TileButton>> checkPaths = new HashMap<Piece, ArrayList<TileButton>>();
static HashMap<Piece, ArrayList<TileButton>> take = new HashMap<Piece, ArrayList<TileButton>>();
ArrayList<Piece>[] removedPieces = new ArrayList[2];
TileButton[] kingsButton = new TileButton[2];
public TileButton[][] tiles = new TileButton[8][8];
public Board() {
  this.tiles = this.tiles;
  for (int i = 0; i < this.pieces.length; i++) {
    this.pieces[i] = new ArrayList<Piece>();
  }
}
class Duple {
  TileButton button;
  boolean isRemoved;
  public Duple(TileButton button, boolean isRemoved) {
    this.button = button;
    this.isRemoved = isRemoved;
  }
}
public TileButton[][] fillTiles(int startX, int startY) {
 TileButton[][] tis = this.tiles;
 int x = startX;
 int y = startY;
 int n = Constants.TILEWIDTH;
 int m = Constants.TILEHEIGHT;
 int index = 0;
 Constants.colors[1] = (Constants.SETTING == 1) ? new Color(60, 60, 60) : Color.BLACK;
 for (int i = 0; i < 8; i++) {
  for (int j = 0; j < 8; j++) {
   int colIndex = (i + j) % 2;
   int idNum = index % 64;
   Tile t = new Tile(n, m, idNum, x, y, Constants.colors[colIndex]);
   t.setPosition(j, i);
   TileButton b = new TileButton(t);
   Tile tile = b.getTile();
   Position fromCoord = new Position(j, i);
   if (i == 0) {
      tile.setImage(Constants.blackimages[j]);
      int identification = 1;
      if (j <= 4)
       identification = 1;
      else
       identification = 2;
      switch(j) {
      case (0) : {
       tile.setPiece(new Rook(identification, Constants.colors[1], new Position(j, i), 
            tile.getImage(), tile.getImage().getDescription(), false));
       tile.hasPiece = true;      
       pieces[1].add(tile.getPiece());
       break;
      }
      case (1) : {
       tile.setPiece(new Knight(identification, Constants.colors[1], new Position(j, i), 
         tile.getImage(), tile.getImage().getDescription()));
       tile.hasPiece = true;
       pieces[1].add(tile.getPiece());
       break;
      }
      case (2) : {
       tile.setPiece(new Bishop(identification, Constants.colors[1], new Position(j, i), 
         tile.getImage(), tile.getImage().getDescription()));
       tile.hasPiece = true;
       pieces[1].add(tile.getPiece());
       break;
      }
      case (3) : {
       tile.setPiece(new Queen(identification, Constants.colors[1], new Position(j, i), 
         tile.getImage(), tile.getImage().getDescription()));
       tile.hasPiece = true;
       pieces[1].add(tile.getPiece());
       break;
      }
      case (4) : {
       tile.setPiece(new King(identification, Constants.colors[1], new Position(j, i), 
         tile.getImage(), tile.getImage().getDescription(), false));
       tile.hasPiece = true;
       pieces[1].add(tile.getPiece());
       kingsButton[1] = b;
       break;
      }
      case (5) : {
       tile.setPiece(new Bishop(identification, Constants.colors[1], new Position(j, i), 
         tile.getImage(), tile.getImage().getDescription()));
       tile.hasPiece = true;
       pieces[1].add(tile.getPiece());
       break;
      }
      case (6) : {
       tile.setPiece(new Knight(identification, Constants.colors[1], new Position(j, i), 
         tile.getImage(), tile.getImage().getDescription()));
       tile.hasPiece = true;  
       pieces[1].add(tile.getPiece());
       break;
      }
      case (7) : {
       tile.setPiece(new Rook(identification, Constants.colors[1], new Position(j, i), 
            tile.getImage(), tile.getImage().getDescription(), false));
       tile.hasPiece = true;      
       pieces[1].add(tile.getPiece());
       break;
      }
      }
     }
     if (i == 1) {
      tile.setImage(Constants.blackimages[Constants.blackimages.length - 1]);
      tile.setPiece(new Pawn(j + 1, Constants.colors[1], new Position(j, i), 
         tile.getImage(), tile.getImage().getDescription(), false));
      tile.hasPiece = true;      
      pieces[1].add(tile.getPiece());
     }
     if (i == 6) {
      tile.setImage(Constants.whiteimages[Constants.whiteimages.length - 1]);
      tile.setPiece(new Pawn(j + 1, Constants.colors[0], new Position(j, i), 
         tile.getImage(), tile.getImage().getDescription(), false));
      tile.hasPiece = true;     
      pieces[0].add(tile.getPiece());
     }
     if (i == 7) {
      tile.setImage(Constants.whiteimages[j]);
      int identification = 1;
      if (j <= 4)
       identification = 1;
      else
       identification = 2;
      switch(j) {
      case (0) : {
       tile.setPiece(new Rook(identification, Constants.colors[0], new Position(j, i), 
            tile.getImage(), tile.getImage().getDescription(), false));
       tile.hasPiece = true;       
       pieces[0].add(tile.getPiece());
       break;
      }
      case (1) : {
       tile.setPiece(new Knight(identification, Constants.colors[0], new Position(j, i), 
         tile.getImage(), tile.getImage().getDescription()));
       tile.hasPiece = true;      
       pieces[0].add(tile.getPiece());
       break;
      }
      case (2) : {
       tile.setPiece(new Bishop(identification, Constants.colors[0], new Position(j, i), 
         tile.getImage(), tile.getImage().getDescription()));
       tile.hasPiece = true;       
       pieces[0].add(tile.getPiece());
       break;
      }
      case (3) : {
       tile.setPiece(new Queen(identification, Constants.colors[0], new Position(j, i), 
         tile.getImage(), tile.getImage().getDescription()));
       tile.hasPiece = true;       
       pieces[0].add(tile.getPiece());
       break;
      }
      case (4) : {
       tile.setPiece(new King(identification, Constants.colors[0], new Position(j, i), 
         tile.getImage(), tile.getImage().getDescription(), false));
       tile.hasPiece = true;       
       pieces[0].add(tile.getPiece());
       kingsButton[0] = b;
       break;
      }
      case (5) : {
       tile.setPiece(new Bishop(identification, Constants.colors[0], new Position(j, i), 
         tile.getImage(), tile.getImage().getDescription()));
       tile.hasPiece = true;       
       pieces[0].add(tile.getPiece());
       break;
      }
      case (6) : {
       tile.setPiece(new Knight(identification, Constants.colors[0], new Position(j, i), 
         tile.getImage(), tile.getImage().getDescription()));
       tile.hasPiece = true;       
       pieces[0].add(tile.getPiece());
       break;
      }
      case (7) : {
       tile.setPiece(new Rook(identification, Constants.colors[0], new Position(j, i), 
            tile.getImage(), tile.getImage().getDescription(), false));
       tile.hasPiece = true;
       pieces[0].add(tile.getPiece());
       break;
      }
      }
      
     }
     tis[i][j] = b;
     x += n;
     index++;
     if (j % 8 == 7) {
      x = startX;
      y += m;
     }
  }
  }
 return tis;
}
public TileButton[][] fillTiles2(int startX, int startY, ArrayList<Piece>[] lis) {
 TileButton[][] tis = this.tiles;
 int x = startX;
 int y = startY;
 int n = Constants.TILEWIDTH;
 int m = Constants.TILEHEIGHT;
 Constants.colors[1] = (Constants.SETTING == 1) ? new Color(60, 60, 60) : Color.BLACK;
 int index = 0;
 for (int i = 0; i < 8; i++) {
  for (int j = 0; j < 8; j++) {
   int colIndex = (i + j) % 2;
   int idNum = index % 64;
   Tile t = new Tile(n, m, idNum, x, y, Constants.colors[colIndex]);
   t.setPosition(j, i);
   TileButton b = new TileButton(t);
   Tile tile = b.getTile();
   tis[i][j] = b;
   index++;
   x += n;
   if (j % 8 == 7) {
     x = startX;
     y += m;
   }
}
 }
 this.pieces = lis;
 for (int i = 0; i < 2; i++) {
   for (Piece p : this.pieces[i]) {
       Position pos = p.getPosition();
       x = pos.getX();
       y = pos.getY();
       if (p instanceof King)
       this.kingsButton[i] = tis[y][x];
       tis[y][x].getTile().setPiece(p);
       tis[y][x].getTile().hasPiece = true;
       tis[y][x].getTile().setImage(p.getImage());
 }
}
  return tis;
}
public void clearBoard() {
  this.pieces[0].clear();
  this.pieces[1].clear();
  for (TileButton[] b : this.tiles) {
    for (TileButton c : b) {
      if (c.getTile().getPiece() != null)
        c.getTile().getPiece().setImage(null);
      c.getTile().setPiece(null);
      c.getTile().hasPiece = false;
      c.getTile().setImage(null);
      c.setIcon(null);
    }
  }
}
public void setPieces() {
  for (int i = 0; i < this.pieces.length; i++) {
  for (Piece p : this.pieces[i]) {
    p.checkPath.clear();
    p.getPath().clear();
    Position pos = p.getPos();
    int x = pos.getX();
    int y = pos.getY();
    //System.out.println(p);
    p.setPath(this, this.tiles[y][x]);
  }
  }
  }
public void move(TileButton prev, TileButton next) {
  Piece p = prev.getTile().getPiece();
  Piece q = next.getTile().getPiece();
  Position posPrev = prev.getTile().getPosition();
  Position pos = next.getTile().getPosition();
  if (q != null) {
    Game.enPassant = null;
    p.setHasMoved();
    next.setIcon(prev.getTile().getImage());
    next.getTile().setPiece(p);
    next.getTile().setHasPiece();
    next.getTile().setImage(prev.getTile().getImage());
    next.getTile().getPiece().setImage(prev.getTile().getImage());
    next.getTile().getPiece().setPosition(pos);
    prev.setIcon(null);
    prev.getTile().setPiece(null);
    prev.getTile().setHasPiece();
    prev.getTile().setImage(null);
    this.pieces[(Game.turnCount + 1) % 2].remove(q);
  }
  else {
    if (p instanceof Pawn) {
      int posDiff = Math.abs(pos.getY() - posPrev.getY());
      Pawn pawn = (Pawn) p;
      if (posDiff == 2) {
        Game.enPassant = pawn;
      }
      else {
        int posDiffx = Math.abs(pos.getX() - posPrev.getX());
        int posDiffy = Math.abs(pos.getY() - posPrev.getY());
        if (posDiffx == 1 && posDiffy == 1) {
          TileButton tb1 = this.tiles[pos.getY() - 1][pos.getX()];
          TileButton tb2 = this.tiles[pos.getY() + 1][pos.getX()];
          TileButton[] tils = {tb1, tb2};
          for (TileButton but : tils) {
          but.setIcon(null);
          but.getTile().setPiece(null);
          but.getTile().setHasPiece();
          but.getTile().setImage(null);
          }
          this.pieces[(Game.turnCount + 1) % 2].remove(Game.enPassant);
          //this.removedPieces[(Game.turnCount + 1) % 2].add(Game.enPassant);
        }
        Game.enPassant = null;
      }
    }
    else {
      if (p instanceof King && !Gamewindow.takeMeChess) {
        this.kingsButton[Game.turnCount % 2].setBackground(this.kingsButton[Game.turnCount % 2].getTile().getColor());
        kingsButton[Game.turnCount % 2] = next;
      }
      Game.enPassant = null;
    }
    //if (p instanceof King)
      //System.out.println(p);
    p.setHasMoved();
    next.setIcon(prev.getTile().getImage());
    next.getTile().setPiece(p);
    next.getTile().setHasPiece();
    next.getTile().setImage(prev.getTile().getImage());
    next.getTile().getPiece().setImage(prev.getTile().getImage());
    next.getTile().getPiece().setPosition(pos);
    prev.setIcon(null);
    prev.getTile().setPiece(null);
    prev.getTile().setHasPiece();
    prev.getTile().setImage(null);
    //if (p instanceof King)
      //System.out.println(p);
  }
}
public boolean isTileInDanger(TileButton b) {
  int colIndex = Game.turnCount % 2;
  int oppositeColor = (colIndex + 1) % 2;
  for (Piece p : this.pieces[oppositeColor]) {
    if (!(p instanceof Pawn)) {
      if (p.getPath().contains(b)) {
        return true;
      }
    }
    else {
      Color color = p.getColor();
      int tileX = p.getPosition().getX();
      int tileY = p.getPosition().getY();
      if (color.equals(Constants.colors[0])) {
        if (tileY - 1 >= 0) {
          if (tileX - 1 >= 0) {
            if (this.tiles[tileY - 1][tileX - 1].equals(b)) {
              return true;
            }
          }
          if (tileX + 1 < 8) {
            if (this.tiles[tileY - 1][tileX + 1].equals(b)) {
              return true;
            }
          }
        }
      }
      else {
        if (tileY + 1 < 8) {
          if (tileX - 1 >= 0) {
            if (this.tiles[tileY + 1][tileX - 1].equals(b)) {
              return true;
            }
          }
          if (tileX + 1 < 8) {
            if (this.tiles[tileY + 1][tileX + 1].equals(b)) {
              return true;
            }
          }
        }
      }
    }
  }
  return false;
}
public boolean isTileInDanger2(TileButton b) {
  int colIndex = Game.turnCount % 2;
  int oppositeColor = (colIndex + 1) % 2;
  Color kingColor = this.kingsButton[colIndex].getTile().getColor();
  for (int i = 0; i < 8; i++) {
    int x = this.kingsButton[colIndex].getTile().getPosition().getX();
    int y = this.kingsButton[colIndex].getTile().getPosition().getY();
    switch(i) {
      case 0 : {
        while (y - 1 >= 0) {
          TileButton but = this.tiles[y - 1][x];
          if (but.getTile().getPiece() != null) {
            Piece p = but.getTile().getPiece();
            if (!p.getColor().equals(kingColor) && p instanceof Queen && p instanceof Rook)
              return true;
            break;
          }
          y--;
        }
        break;
      }
      case 1 : {
        while (y - 1 >= 0 && x + 1 < 8) {
          TileButton but = this.tiles[y - 1][x + 1];
          if (but.getTile().getPiece() != null) {
            Piece p = but.getTile().getPiece();
            if (!p.getColor().equals(kingColor) && p instanceof Queen && p instanceof Bishop)
              return true;
            break;
          }
          y--;
          x++;
        }
        break;
      }
      case 2 : {
        while (x + 1 < 8) {
          TileButton but = this.tiles[y - 1][x];
          if (but.getTile().getPiece() != null) {
            Piece p = but.getTile().getPiece();
            if (!p.getColor().equals(kingColor) && p instanceof Queen && p instanceof Rook)
              return true;
            break;
          }
          x++;
        }
        break;
      }
      case 3 : {
        while (y + 1 < 8 && x + 1 < 8) {
          TileButton but = this.tiles[y + 1][x + 1];
          if (but.getTile().getPiece() != null) {
            Piece p = but.getTile().getPiece();
            if (!p.getColor().equals(kingColor) && p instanceof Queen && p instanceof Bishop)
              return true;
            break;
          }
          y++;
          x++;
        }
        break;
      }
      case 4 : {
        while (y + 1 < 8) {
          TileButton but = this.tiles[y + 1][x];
          if (but.getTile().getPiece() != null) {
            Piece p = but.getTile().getPiece();
            if (!p.getColor().equals(kingColor) && p instanceof Queen && p instanceof Rook)
              return true;
            break;
          }
          y++;
        }
        break;
      }
      case 5 : {
        while (y + 1 < 8 && x - 1 >= 0) {
          TileButton but = this.tiles[y + 1][x - 1];
          if (but.getTile().getPiece() != null) {
            Piece p = but.getTile().getPiece();
            if (!p.getColor().equals(kingColor) && p instanceof Queen && p instanceof Bishop)
              return true;
            break;
          }
          y++;
          x--;
        }
        break;
      }
      case 6 : {
        while (x - 1 >= 0) {
          TileButton but = this.tiles[y][x - 1];
          if (but.getTile().getPiece() != null) {
            Piece p = but.getTile().getPiece();
            if (!p.getColor().equals(kingColor) && p instanceof Queen && p instanceof Rook)
              return true;
            break;
          }
          x--;
        }
        break;
      }
      default : {
        while (y + 1 < 8) {
          TileButton but = this.tiles[y + 1][x];
          if (but.getTile().getPiece() != null) {
            Piece p = but.getTile().getPiece();
            if (!p.getColor().equals(kingColor) && p instanceof Queen && p instanceof Rook)
              return true;
            break;
          }
          y++;
        }
        break;
      }
    }
  }
  return false;
}
public boolean isKingInCheck(Color color) {
  Game.currKingCheck = false;
  this.causedCheck.clear();
  for (Piece p : this.pieces[(Game.turnCount + 1) % 2]) {
    if (p.getPath().contains(this.kingsButton[Game.turnCount % 2])) {
      this.causedCheck.add(p);
    }
  }
  if (!this.causedCheck.isEmpty()) {
    Game.currKingCheck = true;
  }
  return !this.causedCheck.isEmpty();
}
public void reducePath(Color color) {
  int colIndex = Game.turnCount % 2;
  int oppositeColor = (colIndex + 1) % 2;
  boolean isCheck = this.isKingInCheck(Game.turnColor);
  int x = this.kingsButton[colIndex].getTile().getPosition().getX();
  int y = this.kingsButton[colIndex].getTile().getPosition().getY();
  if (isCheck) {
    Duple[] buts = new Duple[8];
    for (int i = 0; i < 8; i++)
      buts[i] = new Duple(null, false);
    if (y - 1 >= 0) {
      buts[0].button = this.tiles[y - 1][x];
      if (x + 1 < 8)
        buts[1].button = this.tiles[y - 1][x + 1];
      if (x - 1 >= 0)
        buts[7].button = this.tiles[y - 1][x - 1];
    }
    if (x + 1 < 8)
      buts[2].button = this.tiles[y][x + 1];
    if (y + 1 < 8) {
      if (x + 1 < 8)
        buts[3].button = this.tiles[y + 1][x + 1];
      buts[4].button = this.tiles[y + 1][x];
      if (x - 1 >= 0)
        buts[5].button = this.tiles[y + 1][x - 1];
    }
    if (x - 1 >= 0)
      buts[6].button = this.tiles[y][x - 1];
    for (int i = 0; i < 8; i++) {
        if (buts[i].button != null) {
          for (Piece p : this.causedCheck) {
            if (p.getPath().contains(buts[i].button) && this.kingsButton[colIndex].getTile().getPiece().getPath().contains(buts[(i + 4) % 8].button)) {
              this.kingsButton[colIndex].getTile().getPiece().getPath().remove(buts[(i + 4) % 8].button);
              buts[(i + 4) % 8].isRemoved = true;
            }
          }
        }
    }
    for (Piece p : this.causedCheck) {
      for (Piece q : this.pieces[colIndex]) {
        if (!(q instanceof King)) {
        ArrayList<TileButton> lis = TileButton.intersection(p.getPath(), q.getPath());
        if (!lis.isEmpty()) {
          ArrayList<TileButton> toAdd = this.checkPaths(Game.turnColor, isCheck, buts);
          Iterator<TileButton> iter = q.getPath().iterator();
          while (iter.hasNext()) {
            TileButton but = iter.next();
            if (!toAdd.contains(but)) {
              iter.remove();
            }
          }
          if (!q.getPath().contains(this.tiles[q.getPosition().getY()][q.getPosition().getX()]))
          q.getPath().add(this.tiles[q.getPosition().getY()][q.getPosition().getX()]);
        }
        else {
          q.getPath().clear();
          q.getPath().add(this.tiles[q.getPosition().getY()][q.getPosition().getX()]);
        }
      }
        else {
          this.checkPaths(Game.turnColor, isCheck, buts);
        }
      }
    }
  }
  Iterator<TileButton> iter = this.kingsButton[colIndex].getTile().getPiece().getPath().iterator();
  while (iter.hasNext()) {
    TileButton but = iter.next();
    if (but.getTile().getPiece() != null) {
      Piece p = but.getTile().getPiece();
      if (!(p instanceof King) && p.getColor().equals(Constants.colors[oppositeColor])) {
      but.getTile().setPiece(null);
      this.pieces[oppositeColor].remove(p);
      for (Piece q : this.pieces[oppositeColor]) {
        //if (!(q instanceof King))
        q.setPath(this, this.tiles[q.getPosition().getY()][q.getPosition().getX()]);
      }
      if (this.isTileInDanger(but) && this.kingsButton[colIndex].getTile().getPiece().getPath().contains(but)) {
        iter.remove();
      }
      but.getTile().setPiece(p);
      this.pieces[oppositeColor].add(p);
      for (Piece q : this.pieces[oppositeColor]) {
        q.setPath(this, this.tiles[q.getPosition().getY()][q.getPosition().getX()]);
      }
    }
    }
    else {
      if (this.isTileInDanger(but) && this.kingsButton[colIndex].getTile().getPiece().getPath().contains(but)) {
        iter.remove();
      }
    }
  }
  if (y >= 0 && y < 8) {
    if (x + 2 < 8) {
      if (this.kingsButton[colIndex].getTile().getPiece().getPath().contains(this.tiles[y][x + 2])) {
        if (!this.kingsButton[colIndex].getTile().getPiece().getPath().contains(this.tiles[y][x + 1]) || isCheck) {
          this.kingsButton[colIndex].getTile().getPiece().getPath().remove(this.tiles[y][x + 2]);
        }
      }
  }
    if (x - 2 >= 0) {
      if (this.kingsButton[colIndex].getTile().getPiece().getPath().contains(this.tiles[y][x - 2])) {
        if (!this.kingsButton[colIndex].getTile().getPiece().getPath().contains(this.tiles[y][x - 1]) || isCheck) {
          this.kingsButton[colIndex].getTile().getPiece().getPath().remove(this.tiles[y][x - 2]);
        }
      }
    }
  }
}
public void takeMePath(Color turnColor) {
  int colIndex = Game.turnCount % 2;
  int oppositeCol = (colIndex + 1) % 2;
  Board.take.clear();
  ArrayList<Piece> takeMe = new ArrayList<Piece>();
  Piece enPass = null;
  for (Piece p : this.pieces[colIndex]) {
    for (Piece q : this.pieces[oppositeCol]) {
      if (p.getPath().contains(this.tiles[q.getPosition().getY()][q.getPosition().getX()])) {
        this.tiles[q.getPosition().getY()][q.getPosition().getX()].setBackground(Color.RED);
        Board.take.put(p, p.getPath());
        takeMe.add(q);
      }
    }
  }
  for (Piece p : this.pieces[colIndex]) {
    if (p instanceof Pawn) {
      int x = p.getPosition().getX();
      int y = p.getPosition().getY();
      if (p.getColor().equals(Constants.colors[0])) {
        if (y - 1 >= 0) {
          if (x - 1 >= 0) {
            TileButton but = this.tiles[y - 1][x - 1];
            if (p.getPath().contains(but) && but.getTile().getPiece() == null && enPass == null) {
              enPass = p;
              Board.take.put(enPass, enPass.getPath());
              takeMe.add(enPass);
              but.setBackground(Color.CYAN);
              this.tiles[y][x - 1].setBackground(Color.RED);
            }
          }
          if (x + 1 < 8) {
            TileButton but = this.tiles[y - 1][x + 1];
            if (p.getPath().contains(but) && but.getTile().getPiece() == null && enPass == null) {
              enPass = p;
              Board.take.put(enPass, enPass.getPath());
              takeMe.add(enPass);
              but.setBackground(Color.CYAN);
              this.tiles[y][x + 1].setBackground(Color.RED);
            }
          }
        }
      }
      else {
        if (y + 1 < 8) {
          if (x - 1 >= 0) {
            TileButton but = this.tiles[y + 1][x - 1];
            if (p.getPath().contains(but) && but.getTile().getPiece() == null && enPass == null) {
              enPass = p;
              Board.take.put(enPass, enPass.getPath());
              takeMe.add(enPass);
              but.setBackground(Color.CYAN);
              this.tiles[y][x - 1].setBackground(Color.RED);
            }
          }
          if (x + 1 < 8) {
            TileButton but = this.tiles[y + 1][x + 1];
            if (p.getPath().contains(but) && but.getTile().getPiece() == null && enPass == null) {
              enPass = p;
              Board.take.put(enPass, enPass.getPath());
              takeMe.add(enPass);
              but.setBackground(Color.CYAN);
              this.tiles[y][x + 1].setBackground(Color.RED);
            }
          }
        }
      }
    }
  }
  if (!takeMe.isEmpty()) {
    System.out.println("Takeme" + this.pieces[1].size());
  for (Piece p : this.pieces[colIndex]) {
    if (p != enPass) {
    if (Board.take.get(p) != null) {
      this.tiles[p.getPosition().getY()][p.getPosition().getX()].setBackground(Color.CYAN);
      Iterator<TileButton> iter = Board.take.get(p).iterator();
      while (iter.hasNext()) {
        TileButton but = iter.next();
        if (but.getTile().getPiece() == null)
          iter.remove();
      }
    }
    else {
      p.getPath().clear();
      p.getPath().add(this.tiles[p.getPosition().getY()][p.getPosition().getX()]);
    }
  }
  }
  }
  if (Board.take.get(enPass) != null) {
    int x = enPass.getPosition().getX();
    int y = enPass.getPosition().getY();
    this.tiles[y][x].setBackground(Color.CYAN);
    if (enPass.getColor().equals(Constants.colors[0])) {
      Board.take.get(enPass).remove(this.tiles[y - 1][x]);
    }
    else {
      Board.take.get(enPass).remove(this.tiles[y + 1][x]);
    }
  }
}
public ArrayList<TileButton> checkPaths(Color color, boolean check, Duple[] buttons) {
  ArrayList<TileButton> lis = new ArrayList<TileButton>();
  int colIndex = Game.turnCount % 2;
  if (check) {
    int kingX = this.kingsButton[colIndex].getTile().getPosition().getX();
    int kingY = this.kingsButton[colIndex].getTile().getPosition().getY();
    boolean pathFound = false;
    boolean kingPathFound = false;
    for (int i = 0; i < 8; i++) {
      int x = kingX;
      int y = kingY;
      kingPathFound = false;
      switch(i) {
        case 0 : {
          if (!pathFound) {
            lis.clear();
          }
          while (y - 1 >= 0) {
            Piece p = this.tiles[y - 1][x].getTile().getPiece();
            if (p != null) {
              Color col = this.tiles[y - 1][x].getTile().getPiece().getColor();
              if (!Game.turnColor.equals(col)) {
                if ((p instanceof Rook || p instanceof Queen) && !pathFound) {
                  lis.add(this.tiles[y - 1][x]);
                  pathFound = true;
                  kingPathFound = true;
                }
              }
              break;
            }
            if (!pathFound) {
            lis.add(this.tiles[y - 1][x]);
            }
            y--;
          }
          break;
        }
        case 1 : {
          if (!pathFound) {
            lis.clear();
          }
          while (y - 1 >= 0 && x + 1 < 8) {
            Piece p = this.tiles[y - 1][x + 1].getTile().getPiece();
            if (p != null) {
              Color col = this.tiles[y - 1][x + 1].getTile().getPiece().getColor();
              if (!Game.turnColor.equals(col)) {
                if ((p instanceof Bishop || p instanceof Queen) && !pathFound) {
                  lis.add(this.tiles[y - 1][x + 1]);
                  pathFound = true;
                  kingPathFound = true;
                }
              }
              break;
            }
            if (!pathFound)
            lis.add(this.tiles[y - 1][x + 1]);
            y--;
            x++;
          }
          break;
        }
        case 2 : {
          if (!pathFound) {
            lis.clear();
          }
          while (x + 1 < 8) {
            Piece p = this.tiles[y][x + 1].getTile().getPiece();
            if (p != null) {
              Color col = this.tiles[y][x + 1].getTile().getPiece().getColor();
              if (!Game.turnColor.equals(col)) {
                if ((p instanceof Rook || p instanceof Queen) && !pathFound) {
                  lis.add(this.tiles[y][x + 1]);
                  pathFound = true;
                  kingPathFound = true;
                }
              }
              break;
            }
            if (!pathFound)
            lis.add(this.tiles[y][x + 1]);
            x++;
          }
          break;
        }
        case 3 : {
          if (!pathFound) {
            lis.clear();
          }
          while (y + 1 < 8 && x + 1 < 8) {
            Piece p = this.tiles[y + 1][x + 1].getTile().getPiece();
            if (p != null) {
              Color col = this.tiles[y + 1][x + 1].getTile().getPiece().getColor();
              if (!Game.turnColor.equals(col)) {
                if ((p instanceof Bishop || p instanceof Queen) && !pathFound) {
                  lis.add(this.tiles[y + 1][x + 1]);
                  pathFound = true;
                  kingPathFound = true;
                }
              }
              break;
            }
            if (!pathFound)
            lis.add(this.tiles[y + 1][x + 1]);
            y++;
            x++;
          }
          break;
        }
        case 4 : {
          if (!pathFound) {
            lis.clear();
          }
          while (y + 1 < 8) {
            Piece p = this.tiles[y + 1][x].getTile().getPiece();
            if (p != null) {
              Color col = this.tiles[y + 1][x].getTile().getPiece().getColor();
              if (!Game.turnColor.equals(col)) {
                if ((p instanceof Rook || p instanceof Queen) && !pathFound) {
                  lis.add(this.tiles[y + 1][x]);
                  pathFound = true;
                  kingPathFound = true;
                }
              }
              break;
            }
            if (!pathFound)
            lis.add(this.tiles[y + 1][x]);
            y++;
          }
          break;
        }
        case 5 : {
          if (!pathFound) {
            lis.clear();
          }
          while (y + 1 < 8 && x - 1 >= 0) {
            Piece p = this.tiles[y + 1][x - 1].getTile().getPiece();
            if (p != null) {
              Color col = this.tiles[y + 1][x - 1].getTile().getPiece().getColor();
              if (!Game.turnColor.equals(col)) {
                if ((p instanceof Bishop || p instanceof Queen) && !pathFound) {
                  lis.add(this.tiles[y + 1][x - 1]);
                  pathFound = true;
                  kingPathFound = true;
                }
              }
              break;
            }
            if (!pathFound)
            lis.add(this.tiles[y + 1][x - 1]);
            y++;
            x--;
          }
          break;
        }
        case 6 : {
          if (!pathFound) {
            lis.clear();
          }
          while (x - 1 >= 0) {
            Piece p = this.tiles[y][x - 1].getTile().getPiece();
            if (p != null) {
              Color col = this.tiles[y][x - 1].getTile().getPiece().getColor();
              if (!Game.turnColor.equals(col)) {
                if ((p instanceof Rook || p instanceof Queen) && !pathFound) {
                  lis.add(this.tiles[y][x - 1]);
                  pathFound = true;
                  kingPathFound = true;
                }
              }
              break;
            }
            if (!pathFound)
            lis.add(this.tiles[y][x - 1]);
            x--;
          }
          break;
        }
        default : {
          if (!pathFound) {
            lis.clear();
          }
          while (y - 1 >= 0 && x - 1 >= 0) {
            Piece p = this.tiles[y - 1][x - 1].getTile().getPiece();
            if (p != null) {
              Color col = this.tiles[y - 1][x - 1].getTile().getPiece().getColor();
              if (!Game.turnColor.equals(col)) {
                if ((p instanceof Rook || p instanceof Queen) && !pathFound) {
                  lis.add(this.tiles[y - 1][x - 1]);
                  pathFound = true;
                  kingPathFound = true;
                }
              }
              break;
            }
            if (!pathFound)
            lis.add(this.tiles[y - 1][x - 1]);
            y--;
            x--;
          }
          break;
        }
      }
          if (buttons[(i + 4) % 8].button != null && !kingPathFound) {
            if (buttons[(i + 4) % 8].isRemoved) {
              this.kingsButton[colIndex].getTile().getPiece().getPath().add(buttons[(i + 4) % 8].button);
            }
          }
    }
  }
  return lis;
    }
public void checkMate(Color color) {
  if (!Gamewindow.takeMeChess) {
  int colIndex = (color.equals(Constants.colors[0])) ? 0 : 1;
  int oppositeColor = (colIndex + 1) % 2;
  int largestPath = 0;
  for (Piece p : this.pieces[colIndex]) {
    if (p.getPath().size() > largestPath) {
      largestPath = p.getPath().size();
    }
  }
  if (largestPath == 1) {
    if (!Game.currKingCheck) {
      JOptionPane.showMessageDialog(null, "The game has ended in stalemate!", "STALEMATE!", JOptionPane.ERROR_MESSAGE, (oppositeColor == 0) ? Constants.whiteimages[rand.nextInt(Constants.whiteimages.length)] : Constants.blackimages[rand.nextInt(Constants.blackimages.length)]);
      Game.gameEnded = true;
      Gamewindow.timer.stop();
    }
    else {
      JOptionPane.showMessageDialog(null, "Checkmate!  " + ((oppositeColor == 0) ? "White" : "Black")  + " wins!", "Long live the King!", JOptionPane.ERROR_MESSAGE, (oppositeColor == 0) ? Constants.whiteimages[rand.nextInt(Constants.whiteimages.length)] : Constants.blackimages[rand.nextInt(Constants.blackimages.length)]);
      Game.gameEnded = true;
      Gamewindow.timer.stop();
    }
  }
  if (!isCheckPossible() && !Game.gameEnded) {
    JOptionPane.showMessageDialog(null, "Checkmate is very hard or impossible to acieve with this board.  Start a new game to declare a draw!", "Very few pieces left!", JOptionPane.ERROR_MESSAGE, (oppositeColor == 0) ? Constants.whiteimages[rand.nextInt(Constants.whiteimages.length)] : Constants.blackimages[rand.nextInt(Constants.blackimages.length)]);
    Game.gameEnded = true;
    Gamewindow.timer.stop();
  }
  }
  else {
      if (this.pieces[Game.turnCount % 2].isEmpty()) {
        JOptionPane.showMessageDialog(null, "No pieces left!  " + ((Game.turnCount % 2 == 0) ? "White ": "Black ") + "wins!", "Ran out of pieces!", JOptionPane.ERROR_MESSAGE, (Game.turnCount % 2 == 0) ? Constants.whiteimages[rand.nextInt(Constants.whiteimages.length)] : Constants.blackimages[rand.nextInt(Constants.blackimages.length)]);
        Game.gameEnded = true;
        Gamewindow.timer.stop();
      }
  }
}
public boolean containsInstance(ArrayList<Piece> pieces, Class clazz) {
  for (Piece p : pieces) {
    if (p.getClass().equals(clazz)) {
      return true;
    }
  }
  return false;
}
public boolean isCheckPossible() {
  int colIndex = Game.turnCount % 2;
  int oppositeCol = (Game.turnCount + 1) % 2;
  int turnSize = this.pieces[colIndex].size();
  int otherSize = this.pieces[oppositeCol].size();
  if (turnSize <= 3 || otherSize <= 3) {
    if (turnSize == 1 && otherSize == 1) {
      return false;
    }
    if (turnSize == 1) {
        if (!this.containsInstance(this.pieces[oppositeCol], Queen.class) && !this.containsInstance(this.pieces[oppositeCol], Bishop.class) 
              && !this.containsInstance(this.pieces[oppositeCol], Rook.class) && !this.containsInstance(this.pieces[oppositeCol], Pawn.class)) {
          return false;
        }
        if (!this.containsInstance(this.pieces[oppositeCol], Queen.class) && !this.containsInstance(this.pieces[oppositeCol], Knight.class) 
              && !this.containsInstance(this.pieces[oppositeCol], Rook.class) && !this.containsInstance(this.pieces[oppositeCol], Pawn.class)) {
          return false;
        }
    }
    if (otherSize == 1) {
        if (!this.containsInstance(this.pieces[colIndex], Queen.class) && !this.containsInstance(this.pieces[colIndex], Bishop.class) 
              && !this.containsInstance(this.pieces[colIndex], Rook.class) && !this.containsInstance(this.pieces[colIndex], Pawn.class)) {
          return false;
        }
        if (!this.containsInstance(this.pieces[colIndex], Queen.class) && !this.containsInstance(this.pieces[colIndex], Knight.class) 
              && !this.containsInstance(this.pieces[colIndex], Rook.class) && !this.containsInstance(this.pieces[colIndex], Pawn.class)) {
          return false;
        }
    }
    if (turnSize == 2 && otherSize == 2) {
        if (!this.containsInstance(this.pieces[colIndex], Queen.class) && !this.containsInstance(this.pieces[colIndex], Knight.class) 
              && !this.containsInstance(this.pieces[colIndex], Rook.class) && !this.containsInstance(this.pieces[colIndex], Pawn.class)) {
        if (!this.containsInstance(this.pieces[oppositeCol], Queen.class) && !this.containsInstance(this.pieces[oppositeCol], Knight.class) 
              && !this.containsInstance(this.pieces[oppositeCol], Rook.class) && !this.containsInstance(this.pieces[oppositeCol], Pawn.class)) {
            return false;
          }
        }
    }
  }
  return true;
}
public void pinnedPieces(Color color) {
  int colIndex = color.equals(Constants.colors[0]) ? 0 : 1;
  int oppositeColor = (colIndex + 1) % 2;
  TileButton kingSpace = this.kingsButton[colIndex]; 
  int kingX = kingSpace.getTile().getPosition().getX();
  int kingY = kingSpace.getTile().getPosition().getY();
  int i = kingY;
  int j = kingX;
  ArrayList<TileButton> newPath = new ArrayList<TileButton>();
  int pinnedCount = 0;
  for (int k = 0; k < 8; k++) {
    int counter = 0;
    Piece potentialPin = null;
    i = kingSpace.getTile().getPosition().getX();
    j = kingSpace.getTile().getPosition().getY();
    newPath.clear();
    switch(k) {
      case 0: {
        // North
        while (j > 0) {
          if (this.tiles[j - 1][i].getTile().getPiece() != null) {
            if (this.tiles[j - 1][i].getTile().getPiece().getColor().equals(color)) {
              if (counter == 0)
              potentialPin = this.tiles[j - 1][i].getTile().getPiece();
            }
            else {
              if (this.tiles[j - 1][i].getTile().getPiece() instanceof Rook || this.tiles[j - 1][i].getTile().getPiece() instanceof Queen) {
                if (potentialPin != null) {
                  if (potentialPin instanceof Pawn) {
                  int pawnX = potentialPin.getPosition().getX();
                  int pawnY = potentialPin.getPosition().getY();
                    if (pawnY - 1 >= 0) {
                      if (pawnX - 1 >= 0) {
                        if (potentialPin.getPath().contains(this.tiles[pawnY - 1][pawnX - 1])) {
                          potentialPin.getPath().remove(this.tiles[pawnY - 1][pawnX - 1]);
                        }
                      }
                      if (pawnX + 1 < 8) {
                        if (potentialPin.getPath().contains(this.tiles[pawnY - 1][pawnX + 1])) {
                          potentialPin.getPath().remove(this.tiles[pawnY - 1][pawnX + 1]);
                        }
                      }
                   }
                }
                  else {
                    if (potentialPin instanceof Rook || potentialPin instanceof Queen) {
                      newPath.add(this.tiles[j - 1][i]);
                      potentialPin.getPath().clear();
                      potentialPin.getPath().addAll(newPath);
                    }
                    else {
                      potentialPin.getPath().clear();
                      potentialPin.getPath().add(this.tiles[potentialPin.getPosition().getY()][potentialPin.getPosition().getX()]);
                    }
                  }
              }
            }
          }
           counter+=1;
        }
          if (counter <= 1 && !(this.tiles[j - 1][i].getTile().getPiece() instanceof King)) {
            newPath.add(this.tiles[j - 1][i]);
          }
          if (counter > 1) {
            break;
          }
          j--;
      }
        break;
      }
      case 1: {
        // Northeast
          while (j >= 0 && i < 8) {
          if (this.tiles[j][i].getTile().getPiece() != null) {
            if (this.tiles[j][i].getTile().getPiece().getColor().equals(color) && !(this.tiles[j][i].getTile().getPiece() instanceof King)) {
              potentialPin = this.tiles[j][i].getTile().getPiece();
              counter+=1;
            }
            if ((this.tiles[j][i].getTile().getPiece() instanceof Bishop || this.tiles[j][i].getTile().getPiece() instanceof Queen) 
                  && counter == 1 && !this.tiles[j][i].getTile().getPiece().getColor().equals(color)) {
              newPath.add(this.tiles[j][i]);
              potentialPin.getPath().clear();
              if (potentialPin instanceof Bishop || potentialPin instanceof Queen) {
              potentialPin.getPath().addAll(newPath);
              }
              else {
                if (potentialPin instanceof Pawn) {
                  int ex = potentialPin.getPosition().getX();
                  int why = potentialPin.getPosition().getY();
                  if (why - 1 >= 0 && ex + 1 < 8) {
                    if (this.tiles[why - 1][ex + 1].getTile().getPiece() != null) {
                      if (!this.tiles[why - 1][ex + 1].getTile().getPiece().getColor().equals(potentialPin.getColor())) {
                        potentialPin.getPath().add(this.tiles[why - 1][ex + 1]);
                      }
                    }
                  }
                }
                potentialPin.getPath().add(this.tiles[potentialPin.getPosition().getY()][potentialPin.getPosition().getX()]);
              }
              pinnedCount++;
              break;
            }
          }
          if (counter <= 1 && !(this.tiles[j][i].getTile().getPiece() instanceof King)) {
            newPath.add(this.tiles[j][i]);
          }
          i++;
          j--;
        }
        break;
      }
      case 2: {
        // east
          while (i < 7) {
          if (this.tiles[j][i + 1].getTile().getPiece() != null) {
            if (this.tiles[j][i + 1].getTile().getPiece().getColor().equals(color)) {
              if (counter == 0)
              potentialPin = this.tiles[j][i + 1].getTile().getPiece();
            }
            else {
              if (this.tiles[j][i + 1].getTile().getPiece() instanceof Rook || this.tiles[j][i + 1].getTile().getPiece() instanceof Queen) {
                if (potentialPin != null) {
                    if (potentialPin instanceof Rook || potentialPin instanceof Queen) {
                      newPath.add(this.tiles[j][i + 1]);
                      potentialPin.getPath().clear();
                      potentialPin.getPath().addAll(newPath);
                    }
                    else {
                      potentialPin.getPath().clear();
                      potentialPin.getPath().add(this.tiles[potentialPin.getPosition().getY()][potentialPin.getPosition().getX()]);
                  }
              }
            }
          }
           counter+=1;
        }
          if (counter <= 1 && !(this.tiles[j][i + 1].getTile().getPiece() instanceof King)) {
            newPath.add(this.tiles[j][i + 1]);
          }
          if (counter > 1) {
            break;
          }
          i++;
        }
        break;
      }
      case 3: {
        // SouthEast
          while (j < 8 && i < 8) {
          if (this.tiles[j][i].getTile().getPiece() != null) {
            if (this.tiles[j][i].getTile().getPiece().getColor().equals(color) && !(this.tiles[j][i].getTile().getPiece() instanceof King)) {
              potentialPin = this.tiles[j][i].getTile().getPiece();
              counter+=1;
            }
            if ((this.tiles[j][i].getTile().getPiece() instanceof Bishop || this.tiles[j][i].getTile().getPiece() instanceof Queen) 
                  && counter == 1 && !this.tiles[j][i].getTile().getPiece().getColor().equals(color)) {
              newPath.add(this.tiles[j][i]);
              potentialPin.getPath().clear();
              if (potentialPin instanceof Bishop || potentialPin instanceof Queen) {
              potentialPin.getPath().addAll(newPath);
              }
              else {
                if (potentialPin instanceof Pawn) {
                  int ex = potentialPin.getPosition().getX();
                  int why = potentialPin.getPosition().getY();
                  if (why + 1 < 8 && ex + 1 < 8) {
                    if (this.tiles[why + 1][ex + 1].getTile().getPiece() != null) {
                      if (!this.tiles[why + 1][ex + 1].getTile().getPiece().getColor().equals(potentialPin.getColor())) {
                        potentialPin.getPath().add(this.tiles[why + 1][ex + 1]);
                      }
                    }
                  }
                }
                potentialPin.getPath().add(this.tiles[potentialPin.getPosition().getY()][potentialPin.getPosition().getX()]);
              }
              pinnedCount++;
              break;
            }
          }
          if (counter <= 1 && !(this.tiles[j][i].getTile().getPiece() instanceof King)) {
            newPath.add(this.tiles[j][i]);
          }
          i++;
          j++;
        }
        break;
      }
      case 4: {
        // South
          while (j < 7) {
          if (this.tiles[j + 1][i].getTile().getPiece() != null) {
            if (this.tiles[j + 1][i].getTile().getPiece().getColor().equals(color)) {
              if (counter == 0)
              potentialPin = this.tiles[j + 1][i].getTile().getPiece();
            }
            else {
              if (this.tiles[j + 1][i].getTile().getPiece() instanceof Rook || this.tiles[j + 1][i].getTile().getPiece() instanceof Queen) {
                if (potentialPin != null) {
                  if (potentialPin instanceof Pawn) {
                  int pawnX = potentialPin.getPosition().getX();
                  int pawnY = potentialPin.getPosition().getY();
                    if (pawnY + 1 < 8) {
                      if (pawnX - 1 >= 0) {
                        if (potentialPin.getPath().contains(this.tiles[pawnY + 1][pawnX - 1])) {
                          potentialPin.getPath().remove(this.tiles[pawnY + 1][pawnX - 1]);
                        }
                      }
                      if (pawnX + 1 < 8) {
                        if (potentialPin.getPath().contains(this.tiles[pawnY + 1][pawnX + 1])) {
                          potentialPin.getPath().remove(this.tiles[pawnY + 1][pawnX + 1]);
                        }
                      }
                   }
                }
                  else {
                    if (potentialPin instanceof Rook || potentialPin instanceof Queen) {
                      newPath.add(this.tiles[j + 1][i]);
                      potentialPin.getPath().clear();
                      potentialPin.getPath().addAll(newPath);
                    }
                    else {
                      potentialPin.getPath().clear();
                      potentialPin.getPath().add(this.tiles[potentialPin.getPosition().getY()][potentialPin.getPosition().getX()]);
                    }
                  }
              }
            }
          }
           counter+=1;
        }
          if (counter <= 1 && !(this.tiles[j + 1][i].getTile().getPiece() instanceof King)) {
            newPath.add(this.tiles[j + 1][i]);
          }
          if (counter > 1) {
            break;
          }
          j++;
        }
        break;
      }
      case 5 : {
        // SouthWest
          while (j < 8 && i >= 0) {
          if (this.tiles[j][i].getTile().getPiece() != null) {
            if (this.tiles[j][i].getTile().getPiece().getColor().equals(color) && !(this.tiles[j][i].getTile().getPiece() instanceof King)) {
              potentialPin = this.tiles[j][i].getTile().getPiece();
              counter+=1;
            }
            if ((this.tiles[j][i].getTile().getPiece() instanceof Bishop || this.tiles[j][i].getTile().getPiece() instanceof Queen) 
                  && counter == 1 && !this.tiles[j][i].getTile().getPiece().getColor().equals(color)) {
              newPath.add(this.tiles[j][i]);
              potentialPin.getPath().clear();
              if (potentialPin instanceof Bishop || potentialPin instanceof Queen) {
              potentialPin.getPath().addAll(newPath);
              }
              else {
                if (potentialPin instanceof Pawn) {
                  int ex = potentialPin.getPosition().getX();
                  int why = potentialPin.getPosition().getY();
                  if (why + 1 < 8 && ex - 1 >= 0) {
                    if (this.tiles[why + 1][ex - 1].getTile().getPiece() != null) {
                      if (!this.tiles[why + 1][ex - 1].getTile().getPiece().getColor().equals(potentialPin.getColor())) {
                        potentialPin.getPath().add(this.tiles[why + 1][ex - 1]);
                      }
                    }
                  }
                }
                potentialPin.getPath().add(this.tiles[potentialPin.getPosition().getY()][potentialPin.getPosition().getX()]);
              }
              pinnedCount++;
              break;
            }
          }
          if (counter <= 1 && !(this.tiles[j][i].getTile().getPiece() instanceof King)) {
            newPath.add(this.tiles[j][i]);
          }
          i--;
          j++;
        }
        break;
      }
      case 6: {
        // West
          while (i > 0) {
          if (this.tiles[j][i - 1].getTile().getPiece() != null) {
            if (this.tiles[j][i - 1].getTile().getPiece().getColor().equals(color)) {
              if (counter == 0)
              potentialPin = this.tiles[j][i - 1].getTile().getPiece();
            }
            else {
              if (this.tiles[j][i - 1].getTile().getPiece() instanceof Rook || this.tiles[j][i - 1].getTile().getPiece() instanceof Queen) {
                if (potentialPin != null) {
                    if (potentialPin instanceof Rook || potentialPin instanceof Queen) {
                      newPath.add(this.tiles[j][i - 1]);
                      potentialPin.getPath().clear();
                      potentialPin.getPath().addAll(newPath);
                    }
                    else {
                      potentialPin.getPath().clear();
                      potentialPin.getPath().add(this.tiles[potentialPin.getPosition().getY()][potentialPin.getPosition().getX()]);
                   }
              }
            }
          }
           counter+=1;
        }
          if (counter <= 1 && !(this.tiles[j][i - 1].getTile().getPiece() instanceof King)) {
            newPath.add(this.tiles[j][i - 1]);
          }
          if (counter > 1) {
            break;
          }
          i--;
        }
        break;
      }
      default : {
        // NorthWest
          while (j >= 0 && i >= 0) {
          if (this.tiles[j][i].getTile().getPiece() != null) {
            if (this.tiles[j][i].getTile().getPiece().getColor().equals(color) && !(this.tiles[j][i].getTile().getPiece() instanceof King)) {
              potentialPin = this.tiles[j][i].getTile().getPiece();
              counter+=1;
            }
            if ((this.tiles[j][i].getTile().getPiece() instanceof Bishop || this.tiles[j][i].getTile().getPiece() instanceof Queen) 
                  && counter == 1 && !this.tiles[j][i].getTile().getPiece().getColor().equals(color)) {
              newPath.add(this.tiles[j][i]);
              potentialPin.getPath().clear();
              if (potentialPin instanceof Bishop || potentialPin instanceof Queen) {
              potentialPin.getPath().addAll(newPath);
              }
              else {
                if (potentialPin instanceof Pawn) {
                  int ex = potentialPin.getPosition().getX();
                  int why = potentialPin.getPosition().getY();
                  if (why - 1 >= 0 && ex - 1 >= 0) {
                    if (this.tiles[why - 1][ex - 1].getTile().getPiece() != null) {
                      if (!this.tiles[why - 1][ex - 1].getTile().getPiece().getColor().equals(potentialPin.getColor())) {
                        potentialPin.getPath().add(this.tiles[why - 1][ex - 1]);
                      }
                    }
                  }
                }
                potentialPin.getPath().add(this.tiles[potentialPin.getPosition().getY()][potentialPin.getPosition().getX()]);
              }
              pinnedCount++;
              break;
            }
          }
          if (counter <= 1 && !(this.tiles[j][i].getTile().getPiece() instanceof King)) {
            newPath.add(this.tiles[j][i]);
          }
          i--;
          j--;
        }
        break;
      }
    }
  }
}
public static void main(String[] args) {
 Board board = new Board();
 ArrayList<Piece>[] pieces = new ArrayList[2];
 ArrayList<Piece> whitePieces = new ArrayList<Piece>();
 whitePieces.add(new King(1, Color.WHITE, new Position(0, 0), Constants.whiteimages[4], "King", true));
 whitePieces.add(new Queen(1, Color.WHITE, new Position(1, 0), Constants.whiteimages[3], "Queen"));
 ArrayList<Piece> blackPieces = new ArrayList<Piece>();
  blackPieces.add(new King(1, Color.BLACK, new Position(2, 0), Constants.blackimages[4], "King", true));
  pieces[0] = whitePieces;
  pieces[1] = blackPieces;
 //System.out.println(board.tiles[i][j].getTile());
 board.setPieces();
 //board.move(board.tiles[6][0], board.tiles[4][0]);
  for (TileButton[] buts : board.tiles) {
    for (TileButton but : buts) {
      System.out.println(but.getTile());
    }
  }
}
}
