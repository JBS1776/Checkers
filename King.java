import java.awt.Color;

import javax.swing.ImageIcon;

public class King extends Piece implements java.io.Serializable{
 
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
 public King(int id, Color color, Position pos, ImageIcon image, boolean hasMovedYet) {
	 super(id, color, pos, image, hasMovedYet);
 }
void setPath(Game g, Tile t) {
	  Board board = g.getBoard();
	  Color c = this.getColor();
	  this.getPath().clear();
	  int x = t.getPosition().getX();
	  int y = t.getPosition().getY();
	  this.getPath().add(t);
	  this.getAllies().clear();
	 }
}