import java.awt.*;
import javax.swing.*;
import java.util.*;
public abstract class Piece implements java.io.Serializable{
 
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
 private int id;
 private int balance;
 private Color color;
 private Position pos;
 private Tile tile;
 private ImageIcon image;
 private String name;
 private ArrayList<Tile> path = new ArrayList<Tile>();
 private ArrayList<Tile> allies = new ArrayList<Tile>();
 private boolean hasMovedYet;
 public Piece(int id, Color color, Position pos, ImageIcon image) {
	 this.id = id;
	 this.color = color;
	 this.pos = pos;
	 this.image = image;
	 if (image != null)
		 this.name = image.getDescription();
	 }
 public Piece(int id, Color color, Position pos, ImageIcon image, boolean hasMovedYet) {
  this.id = id;
  this.color = color;
  this.pos = pos;
  this.image = image;
  this.hasMovedYet = hasMovedYet;
  this.path = new ArrayList<Tile>();
  if (image != null)
	  this.name = image.getDescription();
 }
 public int getId() {
	 return this.id;
 	}
 public void setId(int i) {
	  this.id = i;
	 }
public int getBalance() {
	return this.balance;
}
public void setBalance(int val) {
	this.balance = val;
}
 public Color getColor() {
  return this.color;
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
 public ArrayList<Tile> getPath() {
	  return this.path;
 }
 void setPath(Game g, Tile b) {
	   if (b.getPiece() instanceof Peasant) {
	     Peasant pawn = (Peasant) b.getPiece();
	     pawn.setPath(g, b);
	   }
	   if (b.getPiece() instanceof King) {
	     King king = (King) b.getPiece();
	     king.setPath(g, b);
	   }
	 }
 public ArrayList<Tile> getAllies() {
	 return this.allies;
 }
 Tile getRandTile() {
	 int rand = Constants.rand.nextInt(this.path.size());
	 if (this.path.get(rand) != null) {
	 while (this.path.get(rand).getPiece() == this) {
		 rand = Constants.rand.nextInt(this.path.size());
		 if (this.path.get(rand) == null) {
			 break;
		 }
	 }
	 }
	 return this.path.get(rand);
 }
int findIndex(Color color) {
	int adder = color.equals(Constants.colors[0]) ? 0 : 1;
		if (this instanceof King) {
			return adder;
		}
		return 1 + adder;
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
 public boolean getHasMoved() {
	 return this.hasMovedYet;
 }
 public void setHasMoved(boolean val) {
	 this.hasMovedYet = val;
 }
 public void setImage(ImageIcon i) {
  this.image = i;
 }
 public void setName(String s) {
  this.name = s;
 }
}