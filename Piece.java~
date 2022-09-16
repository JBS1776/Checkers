import java.awt.*;

import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.*;
import java.util.List;
public abstract class Piece implements java.io.Serializable{
 
 private int id;
 private Color color;
 private Position pos;
 private Tile tile;
 private ImageIcon image;
 private String name;
 protected ArrayList<TileButton> path = new ArrayList<TileButton>();
 protected ArrayList<TileButton> checkPath = new ArrayList<TileButton>();
 protected ArrayList<TileButton> allies = new ArrayList<TileButton>();
 protected Board board = new Board();
 protected Color highlight = Constants.HIGHLIGHTER;
 protected Color special = Constants.TURNHIGHLIGHT;
 protected Color[] colors = Constants.colors;
 protected boolean hasMovedYet;
 protected boolean isPinned = false;
 protected boolean causedCheck = false;
 protected static int n = Constants.TILEWIDTH;
 public Piece() {
  this.id = id;
  this.color = color;
  this.pos = pos;
  this.image = image;
  this.hasMovedYet = hasMovedYet;
  this.path = new ArrayList<TileButton>();
  this.checkPath = new ArrayList<TileButton>();
  this.tile = tile;
  if (image != null)
  this.name = image.getDescription();
 }
 public Piece(int id, Color color, Position pos, ImageIcon image, String name, boolean hasMovedYet) {
  this.id = id;
  this.color = color;
  this.pos = pos;
  this.image = image;
  this.hasMovedYet = hasMovedYet;
  this.path = new ArrayList<TileButton>();
  this.checkPath = new ArrayList<TileButton>();
  this.tile = tile;
  if (image != null)
  this.name = image.getDescription();
 }
 public int getId() {
  return this.id;
 }
 public void setIdNum(Piece p, int i) {
  this.id = i;
 }
 public Color getColor() {
  return this.color;
 }
 
 public Position getPos() {
  return this.pos;
 }
 public ImageIcon getImage() {
  return this.image;
 }
 public String getName() {
  return this.name;
 }
 public Tile getTile() {
  return this.tile;
 }
 public ArrayList<TileButton> getPath() {
  return this.path;
 }
 public void setPath(Board board, TileButton b) {
   Piece p = this;
   if (p instanceof Pawn) {
     Pawn pawn = (Pawn) p;
     pawn.setPath(board, b);
   }
   if (p instanceof Rook) {
     Rook rook = (Rook) p;
     rook.setPath(board, b);
   }
   if (p instanceof Knight) {
     Knight knight = (Knight) p;
     knight.setPath(board, b);
   }
   if (p instanceof Bishop) {
     Bishop bishop = (Bishop) p;
     bishop.setPath(board, b);
   }
   if (p instanceof Queen) {
     Queen queen = (Queen) p;
     queen.setPath(board, b);
   }
   if (p instanceof King) {
     King king = (King) p;
     king.setPath(board, b);
   }
 }
 public void setPath(ArrayList<TileButton> lis) {
   this.path = lis;
 }
 public void furtherReducePath() {
   Piece p = this;
   if (p instanceof Rook) {
     Rook rook = (Rook) p;
     rook.furtherReducePath();
   }
   if (p instanceof Bishop) {
     Bishop bishop = (Bishop) p;
     bishop.furtherReducePath();
   }
   if (p instanceof Queen) {
     Queen queen = (Queen) p;
     queen.furtherReducePath();
   } 
 }
 public void setId(int i) {
  this.id = i;
 }
 public void setColor(Color c) {
  this.color = c;
 }
 public void setPosition(Position p) {
  this.pos = p;
 }
 public Position getPosition() {
   return this.pos;
 }
 public void setHasMoved() {
  this.hasMovedYet = true;
 }
 public void setImage(ImageIcon i) {
  this.image = i;
 }
 public void setName(String s) {
  this.name = s;
 }
 public String toString() {
  return "" + this.hasMovedYet + ", " + this.id + ", " + this.color + ", " + this.pos + ", " + this.name;
 }
 public static void main(String[] args) {
  Board board = new Board();
 }

}
