import java.awt.Color;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.ImageIcon;

public class King extends Piece implements java.io.Serializable{
 
 boolean inCheck = false;
 boolean canCastle = true;
 Color check = Constants.CHECKHIGHLIGHT;
 static int whitenewId = 1;
 static int blacknewId = 1;
 public King(int id, Color color, Position pos, ImageIcon image, String name, boolean hasMovedYet) {
  setId(id);
  setColor(color);
  setPosition(pos);
  setImage(image);
  setName(name);
  this.canCastle = (this.hasMovedYet) ? false : true;
  this.hasMovedYet = hasMovedYet;
 }
 public void setPath(Board board, TileButton t) {
  Color c = this.getColor();
  this.path.clear();
  int x = t.getTile().getPosition().getX();
  int y = t.getTile().getPosition().getY();
  this.path.add(t);
  this.allies.clear();
  if (x - 1 >= 0 && y - 1 >= 0) {
   TileButton til = board.tiles[y - 1][x - 1];
   if (til.getTile().getPiece() != null) {
    Color colOther = til.getTile().getPiece().getColor();
    if (!c.equals(colOther)) {
     this.path.add(til);
    }
    else {
      this.allies.add(til);
    }
   }
   else {
    this.path.add(til);
   }
  }
  if (y - 1 >= 0) {
   TileButton til = board.tiles[y - 1][x];
   if (til.getTile().getPiece() != null) {
    Color colOther = til.getTile().getPiece().getColor();
    if (!c.equals(colOther)) {
     this.path.add(til);
    }
    else {
      this.allies.add(til);
    }
   }
   else {
    this.path.add(til);
   }
  }
  if (x + 1 < 8 && y - 1 >= 0) {
   TileButton til = board.tiles[y - 1][x + 1];
   if (til.getTile().getPiece() != null) {
    Color colOther = til.getTile().getPiece().getColor();
    if (!c.equals(colOther)) {
     this.path.add(til);
    }
    else {
      this.allies.add(til);
    }
   }
   else {
    this.path.add(til);
   }
  }
  if (x - 1 >= 0) {
   TileButton til = board.tiles[y][x - 1];
   if (til.getTile().getPiece() != null) {
    Color colOther = til.getTile().getPiece().getColor();
    if (!c.equals(colOther)) {
     this.path.add(til);
    }
    else {
      this.allies.add(til);
    }
   }
   else {
    this.path.add(til);
   }
  }
  if (x + 1 < 8) {
   TileButton til = board.tiles[y][x + 1];
   if (til.getTile().getPiece() != null) {
    Color colOther = til.getTile().getPiece().getColor();
    if (!c.equals(colOther)) {
     this.path.add(til);
    }
    else {
      this.allies.add(til);
    }
   }
   else {
    this.path.add(til);
   }
  }
  if (x - 1 >= 0 && y + 1 < 8) {
   TileButton til = board.tiles[y + 1][x - 1];
   if (til.getTile().getPiece() != null) {
    Color colOther = til.getTile().getPiece().getColor();
    if (!c.equals(colOther)) {
     this.path.add(til);
    }
    else {
      this.allies.add(til);
    }
   }
   else {
    this.path.add(til);
   }
  }
  if (y + 1 < 8) {
   TileButton til = board.tiles[y + 1][x];
   if (til.getTile().getPiece() != null) {
    Color colOther = til.getTile().getPiece().getColor();
    if (!c.equals(colOther)) {
     this.path.add(til);
    }
    else {
      this.allies.add(til);
    }
   }
   else {
    this.path.add(til);
   }
  }
  if (x + 1 < 8 && y + 1 < 8) {
   TileButton til = board.tiles[y + 1][x + 1];
   if (til.getTile().getPiece() != null) {
    Color colOther = til.getTile().getPiece().getColor();
    if (!c.equals(colOther)) {
     this.path.add(til);
    }
    else {
      this.allies.add(til);
    }
   }
   else {
    this.path.add(til);
   }
  }
  if (!this.hasMovedYet) {
    if (x + 3 < 8 && y >= 0 && y < 8) {
   if (board.tiles[y][x + 1].getTile().getPiece() == null && 
     board.tiles[y][x + 2].getTile().getPiece() == null &&
     board.tiles[y][x + 3].getTile().getPiece() != null) {
    Piece p = board.tiles[y][x + 3].getTile().getPiece();
    if (p.getId() == 2 && !p.hasMovedYet) {
     Game.extraString = "(King-side castling!)";
     this.path.add(board.tiles[y][x + 2]);
    }
   }
    }
    if (x - 4 >= 0 && y >= 0 && y < 8) {
   if (board.tiles[y][x - 1].getTile().getPiece() == null && 
     board.tiles[y][x - 2].getTile().getPiece() == null &&
     board.tiles[y][x - 3].getTile().getPiece() == null &&
     board.tiles[y][x - 4].getTile().getPiece() != null) {
    Piece p = board.tiles[y][x - 4].getTile().getPiece();
    if (p.getId() == 1 && !p.hasMovedYet) {
     Game.extraString = "(Queen-side castling!)";
     this.path.add(board.tiles[y][x - 2]);
    }
   }    
  }
  }
 }
 public static void main(String[] args) {
   Board board = new Board();
  TileButton[][] tils = board.tiles;
  TileButton t = board.tiles[0][4];
  int n = Constants.TILEWIDTH;
  Piece p = t.getTile().getPiece();
  System.out.println(p);
  King q = (King) p;
  q.setPath(board, t);
  for (TileButton til : p.path)
  System.out.println(til.getTile().getX() / n + ", " + til.getTile().getY() / n);
 }
}